//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.content.Context;
//import android.content.Intent;
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
//import androidx.recyclerview.widget.LinearLayoutManager;
//
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.adapter.DetailStoresAdapter;
//import com.unicom.waslak_client.adapter.OrdersDetailAdapter;
//import com.unicom.waslak_client.databinding.FragmentOrderDetailBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.OrderDetailFragmentComponent;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.model.user.OrderDetailModel;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.model.user.UpdateOrderModel;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.OrderDetailViewModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import es.dmoral.toasty.Toasty;
//
//public class OrderDetailFragment extends Fragment implements DetailStoresAdapter.ClickListener {
//    private FragmentOrderDetailBinding binding;
//    private NavController navController;
//    @Inject
//    OrdersDetailAdapter ordersDetailAdapter;
//    @Inject
//    DetailStoresAdapter storesAdapter;
//    @ActivityContext
//    @Inject
//    Context context;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    private OrderDetailViewModel orderDetailViewModel;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        OrderDetailFragmentComponent orderDetailFragmentComponent = applicationComponent.orderDetailComponentBuilder().getClickListenerOrder(this).getContext(getActivity()).build();
//        orderDetailFragmentComponent.inject(this);
//
//        orderDetailViewModel = new ViewModelProvider(this, viewModelFactory).get(OrderDetailViewModel.class);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_detail, container, false);
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
//        binding.orderDetailToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
//        ((UserActivity) context).binding.bottomNavigation.setVisibility(View.GONE);
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setViewModel(orderDetailViewModel);
//        binding.setFragment(this);
//
//        //get orderId object
//        if (getArguments() != null) {
//            OrderDetailFragmentArgs args = OrderDetailFragmentArgs.fromBundle(getArguments());
//            orderDetailViewModel.orderId.setValue(args.getOrderId());
//        }
//
//        initializeRecyclerProducts();
//
//        orderDetailViewModel.updateOrderLiveData.observe(getViewLifecycleOwner(), new Observer<UpdateOrderModel>() {
//            @Override
//            public void onChanged(UpdateOrderModel updateOrderModel) {
//                if (updateOrderModel.getIsSuccess()){
//                    startActivity(new Intent(context, UserActivity.class));
//                    ((UserActivity) context).overridePendingTransition(R.anim.animate_windmill_enter,
//                            R.anim.animate_windmill_exit);
//                    ((UserActivity) context).finish();
//                    Toasty.success(context , updateOrderModel.getMessage() , Toast.LENGTH_SHORT).show();
//                }else {
//                    Toasty.error(context , updateOrderModel.getMessage() , Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//    }
//
//    private void initializeRecyclerStores() {
//        binding.orderStoresRecycler.setLayoutManager(new LinearLayoutManager(context));
//        binding.orderStoresRecycler.setAdapter(storesAdapter);
//        orderDetailViewModel.getStores().observe(getViewLifecycleOwner(), new Observer<List<StoresActivityModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<StoresActivityModel.InnerDatum> stores) {
//                storesAdapter.submitList(stores);
//            }
//        });
//    }
//
//    private void initializeRecyclerProducts() {
//        binding.orderProductsRecycler.setLayoutManager(new LinearLayoutManager(context));
//        binding.orderProductsRecycler.setAdapter(ordersDetailAdapter);
//        orderDetailViewModel.getOrderDetailMutableLive().observe(getViewLifecycleOwner(), new Observer<OrderDetailModel>() {
//            @Override
//            public void onChanged(OrderDetailModel orderDetailModel) {
//                if (orderDetailModel.getInnerData().getOrderItems() != null && orderDetailModel.getInnerData().getOrderItems().size() == 0){
//                    binding.orderProductsRecycler.setVisibility(View.INVISIBLE);
//                    binding.orderProductsTxt.setVisibility(View.VISIBLE);
//                    binding.orderProductsTxt.setText(orderDetailModel.getInnerData().getTextOrder());
//                }else{
//                    binding.orderProductsRecycler.setVisibility(View.VISIBLE);
//                    binding.orderProductsTxt.setVisibility(View.GONE);
//                    ordersDetailAdapter.submitList(orderDetailModel.getInnerData().getOrderItems());
//                }
//                if (orderDetailModel.getInnerData().getStatusId() == 3 || orderDetailModel.getInnerData().getStatusId() == 9){
////                    initializeRecyclerStores();
////                    orderDetailViewModel.retrieveStores(orderDetailModel.getInnerData().getActivityId() , String.valueOf(orderDetailModel.getInnerData().getDestinationLatitude()) , String.valueOf(orderDetailModel.getInnerData().getDestinationLongitude()));
////                    binding.edtAddAddress.setVisibility(View.VISIBLE);
////                    binding.orderAddressImg.setVisibility(View.VISIBLE);
////                    binding.orderAddressLine.setVisibility(View.VISIBLE);
////                    binding.orderAddressMap.setVisibility(View.VISIBLE);
////                    binding.orderAddressTitle.setVisibility(View.VISIBLE);
////                    binding.txtLayoutAddAddress.setVisibility(View.VISIBLE);
////                    binding.orderStoresRecycler.setVisibility(View.VISIBLE);
////                    binding.orderStoresImg.setVisibility(View.VISIBLE);
////                    binding.orderStoresLine.setVisibility(View.VISIBLE);
////                    binding.orderStoresTitle.setVisibility(View.VISIBLE);
////                    binding.orderBtn.setVisibility(View.VISIBLE);
//                }else if (orderDetailModel.getInnerData().getStatusId() == 1){
//                    binding.orderCancel.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//    }
//    private StoresActivityModel.InnerDatum store;
//    @Override
//    public void clickStoreOrder(int position) {
//        List<StoresActivityModel.InnerDatum> stores = new ArrayList<>(storesAdapter.getCurrentList());
//        store = stores.get(position);
//    }
//}