//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.content.Context;
//import android.graphics.Color;
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
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.dialog.MaterialAlertDialogBuilder;
//import com.google.android.material.snackbar.Snackbar;
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.adapter.MenuAdapter;
//import com.unicom.waslak_client.adapter.OpenTimesAdapter;
//import com.unicom.waslak_client.databinding.FragmentNewOrderBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.NewOrderFragmentComponent;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.model.user.ProductsStoreModel;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.NewOrderViewModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//public class NewOrderFragment extends Fragment implements MenuAdapter.ClickListener {
//    private FragmentNewOrderBinding binding;
//    private NavController navController;
//    @Inject
//    MenuAdapter menuAdapter;
//    @ActivityContext
//    @Inject
//    Context context;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    @Inject
//    OpenTimesAdapter openTimesAdapter;
//    private NewOrderViewModel newOrderViewModel;
//    StoresActivityModel.InnerDatum store = null;
//    static List<ProductsStoreModel.InnerDatum> ordersNow;
//    static String textOrder;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        ordersNow = new ArrayList<>();
//        textOrder = "";
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        NewOrderFragmentComponent newOrderFragmentComponent = applicationComponent.newOrderFragmentComponentBuilder().getClickListener(this).getContext(getActivity()).build();
//        newOrderFragmentComponent.inject(this);
//
//        newOrderViewModel = new ViewModelProvider(this, viewModelFactory).get(NewOrderViewModel.class);
//    }
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_order, container, false);
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
//        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                navController.navigateUp();
//            }
//        });
//
//        binding.newOrderToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navController.navigateUp();
//            }
//        });
//
//        ((UserActivity) context).binding.bottomNavigation.setVisibility(View.GONE);
//
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setStore(newOrderViewModel);
//        binding.setFragment(this);
//
//
//        //get store object
//        if (getArguments() != null) {
//            NewOrderFragmentArgs args = NewOrderFragmentArgs.fromBundle(getArguments());
//            store = args.getStore();
//            newOrderViewModel.storeLiveData.setValue(store);
//        }
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        initializeRecyclerProducts();
//    }
//
//    private void initializeRecyclerProducts() {
//        binding.productsRecycler.setLayoutManager(new LinearLayoutManager(context));
//        binding.productsRecycler.setAdapter(menuAdapter);
//        newOrderViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<ProductsStoreModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<ProductsStoreModel.InnerDatum> products) {
//                if (products.size() == 0) {
//                    binding.productsRecycler.setVisibility(View.GONE);
//                    binding.txtLayoutAddProducts.setVisibility(View.VISIBLE);
//                    binding.orderBtn.setVisibility(View.VISIBLE);
//                    binding.basketConstraint.setVisibility(View.GONE);
//                } else {
//                    if (ordersNow.size() > 0) {
//                        menuAdapter.submitList(products);
//                        binding.basketQty.setVisibility(View.VISIBLE);
//                        binding.basketQty.setText(String.format("%d", ordersNow.size()));
//                    } else {
//                        menuAdapter.submitList(products);
//                    }
//                }
//            }
//        });
//    }
//
//    public void clickAddCart(int position) {
//        List<ProductsStoreModel.InnerDatum> products = new ArrayList<>(menuAdapter.getCurrentList());
//        ProductsStoreModel.InnerDatum product = products.get(position);
//        product.setQuantityOrder(1);
//        ordersNow.add(product);
//        binding.basketQty.setVisibility(View.VISIBLE);
//        binding.basketQty.setText(String.format("%d", ordersNow.size()));
//    }
//
//    public void clickRemoveCart(int position) {
//        List<ProductsStoreModel.InnerDatum> products = new ArrayList<>(menuAdapter.getCurrentList());
//        ProductsStoreModel.InnerDatum product = products.get(position);
//        product.setQuantityOrder(0);
//        ordersNow.remove(product);
//        if (ordersNow.size() == 0) {
//            binding.basketQty.setVisibility(View.INVISIBLE);
//        } else {
//            binding.basketQty.setText(String.format("%d", ordersNow.size()));
//        }
//    }
//
//    public void orderNow() {
//        if (menuAdapter.getCurrentList().size() > 0 && ordersNow.size() == 0) {
//            Snackbar snackbar = Snackbar
//                    .make(binding.constraint, R.string.choose_at_least_product, Snackbar.LENGTH_LONG);
//            snackbar.setTextColor(Color.RED);
//            snackbar.show();
//        } else if (menuAdapter.getCurrentList().size() > 0 && ordersNow.size() > 0) {
//            NewOrderFragmentDirections.ActionNewOrderFragmentToOrdersFragment actionNewOrderFragmentToOrdersFragment = NewOrderFragmentDirections.actionNewOrderFragmentToOrdersFragment(store);
//            navController.navigate(actionNewOrderFragmentToOrdersFragment);
//        }
//    }
//
//    public void orderBtn() {
//        if (menuAdapter.getCurrentList().size() == 0 && binding.edtAddProducts.getText().toString().isEmpty()) {
//            Snackbar snackbar = Snackbar
//                    .make(binding.constraint, R.string.please_enter_products, Snackbar.LENGTH_LONG);
//            snackbar.setTextColor(Color.RED);
//            snackbar.show();
//        } else if (menuAdapter.getCurrentList().size() == 0 && !binding.edtAddProducts.getText().toString().isEmpty()) {
//            textOrder = binding.edtAddProducts.getText().toString();
//            NewOrderFragmentDirections.ActionNewOrderFragmentToOrderInfoFragment actionNewOrderFragmentToOrderInfoFragment = NewOrderFragmentDirections.actionNewOrderFragmentToOrderInfoFragment(null, store);
//            navController.navigate(actionNewOrderFragmentToOrderInfoFragment);
//        }
//    }
//
//    public void clickTimes(){
//        MaterialAlertDialogBuilder builder =  new MaterialAlertDialogBuilder(context);
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogView =  inflater.inflate(R.layout.dialog_open_times, null);
//        builder.setView(dialogView);
//        RecyclerView rv = dialogView.findViewById(R.id.recycler_opening_times);
//        rv.setLayoutManager(new LinearLayoutManager(context));
//        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        rv.setAdapter(openTimesAdapter);
//        openTimesAdapter.submitList(store.getStoresOpeningTimes());
//        builder.show();
//
//    }
//
//    public void clickReviews(int reviews){
//        if (reviews == 0){
//            NewOrderFragmentDirections.ActionNewOrderFragmentToAddReviewFragment actionNewOrderFragmentToAddReviewFragment = NewOrderFragmentDirections.actionNewOrderFragmentToAddReviewFragment(store);
//            actionNewOrderFragmentToAddReviewFragment.setFirstReview(true);
//            navController.navigate(actionNewOrderFragmentToAddReviewFragment);
//        }else{
//            NewOrderFragmentDirections.ActionNewOrderFragmentToReviewsFragment actionNewOrderFragmentToReviewsFragment = NewOrderFragmentDirections.actionNewOrderFragmentToReviewsFragment(store);
//            navController.navigate(actionNewOrderFragmentToReviewsFragment);
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        ordersNow = null;
//        textOrder = null;
//    }
//}