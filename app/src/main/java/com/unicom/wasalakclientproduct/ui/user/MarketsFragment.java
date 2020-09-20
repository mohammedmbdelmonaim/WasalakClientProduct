package com.unicom.wasalakclientproduct.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.adapter.MarketsAdapter;
import com.unicom.wasalakclientproduct.databinding.FragmentMarketsBinding;
import com.unicom.wasalakclientproduct.viewmodel.user.MarketsViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MarketsFragment extends Fragment  {
    private static final String TAG = "RequestsFragment";
    @Inject
    MarketsAdapter adapter;
    private NavController navController;
    private FragmentMarketsBinding binding;
    private MarketsViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_markets, container, false);
        View v = binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }
//
//        //handle back button
//        observeBackButton();
//        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                backButtonClickSource.onNext(true);
//            }
//        });

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
    }

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