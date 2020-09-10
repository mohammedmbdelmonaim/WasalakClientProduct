//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import androidx.activity.OnBackPressedCallback;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//
//import com.google.android.material.snackbar.Snackbar;
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.SharedViewModel;
//import com.unicom.waslak_client.databinding.FragmentOrderInfoBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.OrderInfoFragmentComponent;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.model.user.CreateOrderModel;
//import com.unicom.waslak_client.model.user.LocationUser;
//import com.unicom.waslak_client.model.user.OrderUser;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.OrderInfoFragmentViewModel;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import es.dmoral.toasty.Toasty;
//
//public class OrderInfoFragment extends Fragment {
//    private FragmentOrderInfoBinding binding;
//    private NavController navController;
//    @ActivityContext
//    @Inject
//    Context context;
//    private OrderInfoFragmentViewModel orderInfoFragmentViewModel;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    private SharedViewModel sharedViewModel;
//    List<OrderUser.OrderItem> orders = new ArrayList<>();
//    StoresActivityModel.InnerDatum store;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        OrderInfoFragmentComponent newOrderFragmentComponent = applicationComponent.orderInfoFragmentComponentBuilder().getContext(getActivity()).build();
//        newOrderFragmentComponent.inject(this);
//
//        orderInfoFragmentViewModel = new ViewModelProvider(this, viewModelFactory).get(OrderInfoFragmentViewModel.class);
//        sharedViewModel = new ViewModelProvider(getActivity() , viewModelFactory).get(SharedViewModel.class);
//
//        //get store object
//        if (getArguments() != null) {
//            OrderInfoFragmentArgs args = OrderInfoFragmentArgs.fromBundle(getArguments());
//            if (args.getOrders() != null) {
//                Collections.addAll(orders, args.getOrders());
//            }
//            orderInfoFragmentViewModel.ordersLiveData.setValue(orders);
//            store = args.getStore();
//            orderInfoFragmentViewModel.storeLiveData.setValue(store);
//            orderInfoFragmentViewModel.textOrder.setValue(NewOrderFragment.textOrder);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_info, container, false);
//        View view = binding.getRoot();
//        return view;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        if (navController == null) {
//            navController = Navigation.findNavController(view);
//        }
//
//        binding.orderToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navController.navigateUp();
//            }
//        });
//        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                navController.navigateUp();
//            }
//        });
//
//
//        ((UserActivity) context).binding.bottomNavigation.setVisibility(View.GONE);
//
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setFragment(this);
//        binding.setViewModel(orderInfoFragmentViewModel);
//
//
//
//        orderInfoFragmentViewModel.getOrderUserMutableLive().observe(getViewLifecycleOwner(), new Observer<OrderUser>() {
//            @Override
//            public void onChanged(OrderUser orderUser) {
//                if (orderUser.getDestinationAddress() == null || orderUser.getDestinationAddress().isEmpty()) {
//                    Snackbar snackbar = Snackbar
//                            .make(binding.orderconstraint, R.string.enter_address, Snackbar.LENGTH_LONG)
//                            .setAction(R.string.retry, new View.OnClickListener() {
//                                @Override
//                                public void onClick(View view) {
////
//                                }
//                            });
//                    snackbar.setActionTextColor(Color.GREEN);
//                    snackbar.setTextColor(Color.RED);
//                    snackbar.show();
//                } else {
//
//                    orderInfoFragmentViewModel.publishSubject.onNext("null");
//                }
//            }
//        });
//
//        //get create order response
//        orderInfoFragmentViewModel.getCreateOrderModelMutableLiveData().observe(getViewLifecycleOwner(), new Observer<CreateOrderModel>() {
//            @Override
//            public void onChanged(CreateOrderModel createOrderModel) {
//                Toasty.success(context , createOrderModel.getMessage().toString() , Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(context, UserActivity.class));
//                ((UserActivity) context).overridePendingTransition(R.anim.animate_windmill_enter,
//                        R.anim.animate_windmill_exit);
//                ((UserActivity) context).finish();
//                // go to fragment and destroy this
////                NavOptions options = new NavOptions.Builder().setPopUpTo(R.id.orderInfoFragment, true).build();
////                navController.navigate(R.id.action_orderInfoFragment_to_requestsFragment, null, options);
//            }
//        });
//
//        orderInfoFragmentViewModel.getError().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Snackbar snackbar = Snackbar
//                        .make(binding.orderconstraint, s, Snackbar.LENGTH_LONG)
//                        .setAction(R.string.retry, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
////                                forgetPasswordViewModel.forgetNetwork();
//                            }
//                        });
//                snackbar.setActionTextColor(Color.GREEN);
//                snackbar.setTextColor(Color.RED);
//                snackbar.show();
//            }
//        });
//
//        sharedViewModel.getLocationUserMutableLiveData().observe(getActivity(), new Observer<LocationUser>() {
//            @Override
//            public void onChanged(LocationUser locationUser) {
//                orderInfoFragmentViewModel.locationUserMutableLiveData.setValue(locationUser);
//                orderInfoFragmentViewModel.address.setValue(locationUser.getAddress());
//            }
//        });
//
//    }
//
//    public void onMapClick(){
//        OrderInfoFragmentDirections.ActionOrderInfoFragmentToMapFragment actionOrderInfoFragmentToMapFragment = OrderInfoFragmentDirections.actionOrderInfoFragmentToMapFragment(store);
//        navController.navigate(actionOrderInfoFragmentToMapFragment);
//    }
//}