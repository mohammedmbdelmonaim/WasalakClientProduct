//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentSender;
//import android.location.Address;
//import android.location.Geocoder;
//import android.location.Location;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//
//import androidx.activity.OnBackPressedCallback;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//
//import com.google.android.gms.common.api.ResolvableApiException;
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationCallback;
//import com.google.android.gms.location.LocationRequest;
//import com.google.android.gms.location.LocationResult;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.location.LocationSettingsRequest;
//import com.google.android.gms.location.LocationSettingsResponse;
//import com.google.android.gms.location.SettingsClient;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.SharedViewModel;
//import com.unicom.waslak_client.databinding.FragmentMapBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.MapFragmentComponent;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.model.user.LocationUser;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.utils.AppPermissions;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import static android.app.Activity.RESULT_OK;
//
//public class MapFragment extends Fragment implements OnMapReadyCallback {
//    private FragmentMapBinding binding;
//    private NavController navController;
//        private GoogleMap mMap;
//    private FusedLocationProviderClient mFusedLocationProviderClient;
//    private Location mLastKnownLocation;
//    private LocationCallback locationCallback;
//    private final float DEFAULT_ZOOM = 15;
//    private GoogleMap.OnCameraIdleListener onCameraIdleListener;
//    private String country;
//    private String city;
//    private String latitude;
//    private String longitude;
//    private String address;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    private SharedViewModel sharedViewModel;
//    private StoresActivityModel.InnerDatum store;
//    @Inject
//    AppPermissions appPermissions;
//    @ActivityContext
//    @Inject
//    Context context;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        MapFragmentComponent mapFragmentComponent = applicationComponent.mapFragmentComponentBuilder().getContext(getActivity()).getFragment(this).listPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}).build();
//        mapFragmentComponent.inject(this);
//
//        sharedViewModel = new ViewModelProvider(getActivity(), viewModelFactory).get(SharedViewModel.class);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = FragmentMapBinding.inflate(inflater, container, false);
//        View view = binding.getRoot();
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (navController == null) {
//            navController = Navigation.findNavController(view);
//        }
//        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                navController.navigateUp();
//            }
//        });
//
//        binding.confirmPickup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LocationUser locationUser = new LocationUser(latitude, longitude, address);
//                sharedViewModel.getLocationUserMutableLiveData().setValue(locationUser);
//                navController.navigateUp();
//            }
//        });
//
//        binding.getLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getDeviceLocation();
//            }
//        });
//
//        //get store object
//        if (getArguments() != null) {
//            MapFragmentArgs args = MapFragmentArgs.fromBundle(getArguments());
//            store = args.getStore();
//        }
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
//
//        configureCameraIdle();
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
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        if (store.getLatitude() != null && store.getLongitude() != null) {
//            mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(String.valueOf(store.getLatitude())), Double.parseDouble(String.valueOf(store.getLongitude())))).title(store.getName() + " here").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
//        }
//        if (appPermissions.checkAndRequestPermission()) {
//            setupLocation();
//        }
//
//        mMap.setOnCameraIdleListener(onCameraIdleListener);
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
//                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
//                                mMap.addMarker(new MarkerOptions().position(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude())).title(getString(R.string.you_are_here)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
////                                getTextAddress(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()));
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
//                                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM));
//                                        mMap.addMarker(new MarkerOptions().position(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude())).title(getString(R.string.you_are_here)).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
////                                        getTextAddress(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()));
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
//    private void configureCameraIdle() {
//        onCameraIdleListener = () -> {
//            LatLng latLng = mMap.getCameraPosition().target;
//            getTextAddress(latLng);
//        };
//    }
//
//    private void getTextAddress(LatLng latLng) {
//        Geocoder geocoder = new Geocoder(getActivity());
//        try {
//            List<Address> addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
//            if (addressList != null && addressList.size() > 0) {
//                if (addressList.get(0) != null) {
//                    country = addressList.get(0).getCountryName();
//                    city = addressList.get(0).getLocality();
//                    address = addressList.get(0).getAddressLine(0);
//                    latitude = String.valueOf(addressList.get(0).getLatitude());
//                    longitude = String.valueOf(addressList.get(0).getLongitude());
//                    if (address != null && country != null) {
//                        binding.draggResult.setText(address + "  " + country);
//                        binding.draggResult.setVisibility(View.VISIBLE);
//                        Animation a = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_text);
//                        a.reset();
//                        binding.draggResult.startAnimation(a);
//
//                    }
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
//}