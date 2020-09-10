package com.unicom.wasalakclientproduct.ui.user;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentRequestsBinding;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

import static android.app.Activity.RESULT_OK;

public class RequestsFragment extends Fragment  {
    private static final String TAG = "RequestsFragment";
//    @Inject
//    ActivitiesAdapter adapter;
//
//    @Inject
//    ActivityStoresAdapter storesAdapter;
//
//    @ActivityContext
//    @Inject
//    Context context;
//
//    private NavController navController;
    private FragmentRequestsBinding binding;
//    private RequestsViewModel requestsViewModel;
//
//    @Inject
//    ViewModelFactory viewModelFactory;
//
//    @Inject
//    AppPermissions appPermissions;
//
//    public static ActivitiesModel.InnerDatum activityClick;
//    private FusedLocationProviderClient mFusedLocationProviderClient;
//    private Location mLastKnownLocation;
//    private LocationCallback locationCallback;
//    private PublishSubject<Boolean> backButtonClickSource = PublishSubject.create();
//    private static final long EXIT_TIMEOUT = 2000;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        activityClick = null;
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        RequstsFragmentComponent requstsFragmentComponent = applicationComponent.requstsFragmentComponentBuilder().getFragment(this).getClickListener(this).getClickListenerOrder(this).listPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}).getContext(getActivity()).build();
//        requstsFragmentComponent.inject(this);
//        requestsViewModel = new ViewModelProvider(this, viewModelFactory).get(RequestsViewModel.class);
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
//        if (appPermissions.checkAndRequestPermission()) {
//            setupLocation();
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_requests, container, false);
        View v = binding.getRoot();
        return v;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (navController == null) {
//            navController = Navigation.findNavController(view);
//        }
//        ((UserActivity) context).binding.bottomNavigation.setVisibility(View.VISIBLE);
//
//        //handle back button
//        observeBackButton();
//
//        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                backButtonClickSource.onNext(true);
//            }
//        });
//
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setFragment(this);
//        binding.setViewModel(requestsViewModel);
//
//
//
//        initializeRecyclerActivityStores();
//        initializeSwipeRefresh();
//        initializeSearchBar();
//    }
//
//    private void setupLocation() {
//        //check if gps is enabled or not and then request user to enable it
//        LocationRequest locationRequest = LocationRequest.create();
//        locationRequest.setInterval(10000);
//        locationRequest.setFastestInterval(5000);
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
//
//        SettingsClient settingsClient = LocationServices.getSettingsClient(getActivity());
//        Task<LocationSettingsResponse> task = settingsClient.checkLocationSettings(builder.build());
//        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
//            @Override
//            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
//                getDeviceLocation();
//            }
//        });
//        task.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                if (e instanceof ResolvableApiException) {
//                    ResolvableApiException resolvable = (ResolvableApiException) e;
//                    try {
//                        resolvable.startResolutionForResult(getActivity(), 51);
//                    } catch (IntentSender.SendIntentException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//        });
//    }
//
//    @SuppressLint("MissingPermission")
//    private void getDeviceLocation() {
//        mFusedLocationProviderClient.getLastLocation()
//                .addOnCompleteListener(new OnCompleteListener<Location>() {
//                    @Override
//                    public void onComplete(Task<Location> task) {
//                        if (task.isSuccessful()) {
//                            mLastKnownLocation = task.getResult();
//                            if (mLastKnownLocation != null) {
//                                requestsViewModel.lat.setValue(String.valueOf(mLastKnownLocation.getLatitude()));
//                                requestsViewModel.lng.setValue(String.valueOf(mLastKnownLocation.getLongitude()));
//                                if (activityClick != null) {
//                                    requestsViewModel.onclick(activityClick);
//                                }
//                            } else {
//                                final LocationRequest locationRequest = LocationRequest.create();
//                                locationRequest.setInterval(10000);
//                                locationRequest.setFastestInterval(5000);
//                                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//                                locationCallback = new LocationCallback() {
//                                    @Override
//                                    public void onLocationResult(LocationResult locationResult) {
//                                        super.onLocationResult(locationResult);
//                                        if (locationResult == null) {
//                                            return;
//                                        }
//                                        mLastKnownLocation = locationResult.getLastLocation();
//                                        if (mLastKnownLocation != null) {
//                                            requestsViewModel.lat.setValue(String.valueOf(mLastKnownLocation.getLatitude()));
//                                            requestsViewModel.lng.setValue(String.valueOf(mLastKnownLocation.getLongitude()));
//                                            if (activityClick != null) {
//                                                requestsViewModel.onclick(activityClick);
//                                            }
//                                        }
//                                        mFusedLocationProviderClient.removeLocationUpdates(locationCallback);
//                                    }
//                                };
//                                mFusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, null);
//                            }
//                        } else {
//                            //unable_to_get_last_location
//                        }
//                    }
//                });
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (appPermissions.onRequestPermissionsResult(requestCode, grantResults, permissions)) {
//            setupLocation();
//        }
//    }
//
//    private void initializeSearchBar() {
//        binding.searchBar.addTextChangeListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                storesAdapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                Log.d("TAG", "afterTextChanged: ");
//            }
//        });
//    }
//
//    private void initializeSwipeRefresh() {
//
//        binding.swipRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                requestsViewModel.onclick(activityClick);
//            }
//        });
//    }
//
//    private void initializeRecyclerActivities() {
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 3);
//        int spanCount = 3; // 3 columns
//        int spacing = 20; // 50px
//        boolean includeEdge = true;
//        binding.requestsCategories.setLayoutManager(mLayoutManager);
//        binding.requestsCategories.setItemAnimator(new DefaultItemAnimator());
//        binding.requestsCategories.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
//        binding.requestsCategories.setAdapter(adapter);
//
//        requestsViewModel.getActivities().observe(getViewLifecycleOwner(), new Observer<List<ActivitiesModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<ActivitiesModel.InnerDatum> activities) {
//                adapter.submitList(activities);
//                if (activityClick == null) {
//                    activityClick = activities.get(0);
//                }
//            }
//        });
//    }
//
//    private void initializeRecyclerActivityStores() {
//        binding.requestsCategoryStores.setLayoutManager(new LinearLayoutManager(context));
//        binding.requestsCategoryStores.setAdapter(storesAdapter);
//
//        requestsViewModel.getStores().observe(getViewLifecycleOwner(), new Observer<List<StoresActivityModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<StoresActivityModel.InnerDatum> stores) {
//                storesAdapter.submitList(stores);
//                storesAdapter.allStores = new ArrayList<>(stores);
//                binding.swipRefresh.setRefreshing(false);
//            }
//        });
//
//        storesAdapter.filteredStores.observe(getViewLifecycleOwner(), new Observer<List<StoresActivityModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<StoresActivityModel.InnerDatum> filteredStores) {
//                if (filteredStores != null) {
//                    storesAdapter.submitList(filteredStores);
//                }
//            }
//        });
//    }
//
//    @Override
//    public void clickActivity(int position) {
//        List<ActivitiesModel.InnerDatum> activities = new ArrayList<>(adapter.getCurrentList());
//        requestsViewModel.onclick(activities.get(position));
//        activityClick = activities.get(position);
//    }
//
//
//    @Override
//    public void clickStoreOrder(int position) {
//        List<StoresActivityModel.InnerDatum> stores = new ArrayList<>(storesAdapter.getCurrentList());
//        StoresActivityModel.InnerDatum store = stores.get(position);
//        RequestsFragmentDirections.ActionRequestsFragmentToNewOrderFragment action = RequestsFragmentDirections.actionRequestsFragmentToNewOrderFragment(store);
//        navController.navigate(action);
//    }
//
//    private void setSnackBar() {
//        Snackbar snackbar = Snackbar
//                .make(binding.constraint, R.string.once_again_to_exit, Snackbar.LENGTH_LONG);
//        snackbar.setTextColor(Color.GREEN);
//        snackbar.show();
//    }
//
//    private Disposable observeBackButton() {
//        return backButtonClickSource
//                .debounce(100, TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(__ -> setSnackBar())
//                .timeInterval(TimeUnit.MILLISECONDS)
//                .skip(1)
//                .filter(interval -> interval.time() < EXIT_TIMEOUT)
//                .subscribe(__ -> getActivity().finish());
//    }
//
//    private LocationManager locationManager ;
//
//    private boolean isLocationEnabled(){
//        String le = Context.LOCATION_SERVICE;
//        locationManager = (LocationManager) context.getSystemService(le);
//        if(!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    private void activeLocation(){
//        new MaterialAlertDialogBuilder(context)
//                .setTitle(R.string.active_location)
//                .setMessage(R.string.go_setting)
//                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        startActivityForResult(intent , 111);
//                    }
//                })
//                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                       dialog.dismiss();
//                    }
//                })
//                .show();
//    }
//
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 51) {
//            if (resultCode == RESULT_OK) {
//                getDeviceLocation();
//            }
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
}