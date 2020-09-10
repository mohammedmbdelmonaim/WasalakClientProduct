//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.activity.OnBackPressedCallback;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.recyclerview.widget.LinearLayoutManager;
//
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.adapter.OrdersAdapter;
//import com.unicom.waslak_client.databinding.FragmentOrdersBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.OrdersFragmentComponent;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.model.user.OrderUser;
//import com.unicom.waslak_client.model.user.ProductsStoreModel;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//public class OrdersFragment extends Fragment implements OrdersAdapter.ClickListener {
//    private FragmentOrdersBinding binding;
//    private NavController navController;
//    @Inject
//    OrdersAdapter ordersAdapter;
//    @ActivityContext
//    @Inject
//    Context context;
//    private List<OrderUser.OrderItem> orders;
//    List<ProductsStoreModel.InnerDatum> ordersNow = NewOrderFragment.ordersNow;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_orders, container, false);
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
//        binding.newOrderToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
//        binding.orderBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                orderConfirm();
//            }
//        });
//
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        OrdersFragmentComponent ordersFragmentComponent = applicationComponent.orderFragmentComponentBuilder().getClickListener(this).getContext(getActivity()).build();
//        ordersFragmentComponent.inject(this);
//
//        ((UserActivity) context).binding.bottomNavigation.setVisibility(View.GONE);
//
//        initializeRecyclerProducts();
//
//
////        //get products object
////        if (getArguments() != null) {
////            OrdersFragmentArgs args = OrdersFragmentArgs.fromBundle(getArguments());
////            Collections.addAll(ordersNow, args.getOrdersCart());
////        }
//        ordersAdapter.submitList(ordersNow);
//        int qty = 0;
//        for (ProductsStoreModel.InnerDatum order : ordersNow) {
//            if (order.getQuantityOrder() == 0) {
//                qty += 1;
//            } else {
//                qty += order.getQuantityOrder();
//            }
//        }
//        binding.basketQty.setText(String.format("%d", qty));
//    }
//
//
//    private void orderConfirm() {
//        orders = new ArrayList<>();
//        for (ProductsStoreModel.InnerDatum orderNow : ordersNow) {
//            OrderUser.OrderItem order = new OrderUser.OrderItem(orderNow.getId(), orderNow.getName(), (orderNow.getDiscount() == null || orderNow.getDiscount() == 0) ?  orderNow.getSellingPrice() : orderNow.getPriceAfterDiscount(), orderNow.getQuantityOrder());
//            orders.add(order);
//        }
//        OrderUser.OrderItem[] ordersList = new OrderUser.OrderItem[orders.size()];
//        ordersList = orders.toArray(ordersList);
//        StoresActivityModel.InnerDatum store = null;
//        if (getArguments() != null) {
//            OrdersFragmentArgs args = OrdersFragmentArgs.fromBundle(getArguments());
//            store = args.getStore();
//        }
//        OrdersFragmentDirections.ActionOrdersFragmentToOrderInfoFragment actionOrdersFragmentToOrderInfoFragment = OrdersFragmentDirections.actionOrdersFragmentToOrderInfoFragment(ordersList, store);
//        navController.navigate(actionOrdersFragmentToOrderInfoFragment);
//    }
//
//    private void initializeRecyclerProducts() {
//        binding.ordersRecycler.setLayoutManager(new LinearLayoutManager(context));
//        binding.ordersRecycler.setAdapter(ordersAdapter);
//    }
//
//    @Override
//    public void clickRemoveCart(int position, int qty) {
//        ProductsStoreModel.InnerDatum orderUpdate = ordersNow.get(position);
//        orderUpdate.setQuantityOrder(0);
//        ordersNow.remove(position);
//        ordersAdapter.submitList(ordersNow);
//        ordersAdapter.notifyDataSetChanged();
//        int current_qty = Integer.parseInt(binding.basketQty.getText().toString());
//        int after_qty = current_qty - qty;
//        if (after_qty == 0) {
//            binding.basketQty.setVisibility(View.INVISIBLE);
//            binding.orderBtn.setVisibility(View.INVISIBLE);
//        } else {
//            binding.basketQty.setText(String.format("%d", after_qty));
//        }
//    }
//
//    @Override
//    public void clickPlusQty(int position, int qty) {
//        ProductsStoreModel.InnerDatum orderUpdate = ordersNow.get(position);
//        orderUpdate.setQuantityOrder(qty);
//        ordersNow.set(position, orderUpdate);
//        int qty_basket = Integer.parseInt(binding.basketQty.getText().toString());
//        binding.basketQty.setText(String.format("%d", ++qty_basket));
//    }
//
//    @Override
//    public void clickMinusQty(int position, int qty) {
//        ProductsStoreModel.InnerDatum orderUpdate = ordersNow.get(position);
//        orderUpdate.setQuantityOrder(qty);
//        ordersNow.set(position, orderUpdate);
//        int qty_basket = Integer.parseInt(binding.basketQty.getText().toString());
//        binding.basketQty.setText(String.format("%d", --qty_basket));
//    }
//}