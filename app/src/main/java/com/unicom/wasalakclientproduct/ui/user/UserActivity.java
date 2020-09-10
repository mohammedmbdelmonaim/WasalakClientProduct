package com.unicom.wasalakclientproduct.ui.user;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.ActivityUserBinding;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.BaseActivityComponent;
import com.unicom.wasalakclientproduct.di.component.UserActivityComponent;
import com.unicom.wasalakclientproduct.ui.BaseActivity;
import com.unicom.wasalakclientproduct.utils.AppPermissions;

import javax.inject.Inject;


public class UserActivity extends BaseActivity {
    ActivityUserBinding binding;
    private static final String TAG = "UserActivity";
    public static int id = -1;
    UserActivityComponent userActivityComponent;
    @Inject
    AppPermissions appPermissions;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location mLastKnownLocation;
    private LocationCallback locationCallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "mohammed onCreate: ");

        ApplicationComponent applicationComponent = MainApplication.get(this).getApplicationComponent();
        userActivityComponent = applicationComponent.userActivityComponent().getContext(this).listPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}).build();
        userActivityComponent.inject(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (appPermissions.checkAndRequestPermission()) {
            setupLocation();
        }

        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpNavigation();

    }

    private void setupLocation() {
        //check if gps is enabled or not and then request user to enable it
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());
        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                getDeviceLocation();
            }
        });
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    ResolvableApiException resolvable = (ResolvableApiException) e;
                    try {
                        resolvable.startResolutionForResult(UserActivity.this, 51);
                    } catch (IntentSender.SendIntentException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getDeviceLocation() {
        mFusedLocationProviderClient.getLastLocation()
                .addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(Task<Location> task) {
                        if (task.isSuccessful()) {
                            mLastKnownLocation = task.getResult();
                            if (mLastKnownLocation != null) {
                                Log.d(TAG, "onComplete: ");


//                                requestsViewModel.lat.setValue(String.valueOf(mLastKnownLocation.getLatitude()));
//                                requestsViewModel.lng.setValue(String.valueOf(mLastKnownLocation.getLongitude()));
//                                if (activityClick != null) {
//                                    requestsViewModel.onclick(activityClick);
//                                }
                            } else {
                                final LocationRequest locationRequest = LocationRequest.create();
                                locationRequest.setInterval(10000);
                                locationRequest.setFastestInterval(5000);
                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                                locationCallback = new LocationCallback() {
                                    @Override
                                    public void onLocationResult(LocationResult locationResult) {
                                        super.onLocationResult(locationResult);
                                        if (locationResult == null) {
                                            return;
                                        }
                                        mLastKnownLocation = locationResult.getLastLocation();
                                        if (mLastKnownLocation != null) {
                                            Log.d(TAG, "onLocationResult: ");
//                                            requestsViewModel.lat.setValue(String.valueOf(mLastKnownLocation.getLatitude()));
//                                            requestsViewModel.lng.setValue(String.valueOf(mLastKnownLocation.getLongitude()));
//                                            if (activityClick != null) {
//                                                requestsViewModel.onclick(activityClick);
//                                            }
                                        }
                                        mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
                                    }
                                };
                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
                            }
                        } else {
                            //unable_to_get_last_location
                        }
                    }
                });
    }

    public void setUpNavigation() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.user_nav);
        if (getIntent().getExtras() != null) {
            id = getIntent().getExtras().getInt("id");
            if (id == 0){
                NavigationUI.setupWithNavController(binding.bottomNavigation,
                        navHostFragment.getNavController());
                return;
            }
            NavInflater navInflater = navHostFragment.getNavController().getNavInflater();
            NavGraph navGraph = navInflater.inflate(R.navigation.user_nav_graph);
            NavController navController = navHostFragment.getNavController();
            navGraph.setStartDestination(R.id.notificationFragment);
            navController.setGraph(navGraph);
            NavigationUI.setupWithNavController(binding.bottomNavigation,
                    navController);
        }else {
            NavigationUI.setupWithNavController(binding.bottomNavigation,
                    navHostFragment.getNavController());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (appPermissions.onRequestPermissionsResult(requestCode, grantResults, permissions)) {
            setupLocation();
        }
    }
}