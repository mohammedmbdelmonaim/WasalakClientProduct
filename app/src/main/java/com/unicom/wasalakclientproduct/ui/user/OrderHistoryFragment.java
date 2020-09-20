package com.unicom.wasalakclientproduct.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentOrderHistoryBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class OrderHistoryFragment extends Fragment {
    private FragmentOrderHistoryBinding binding;
//    private NavController navController;
//    @Inject
//    OrdersHistoryAdapter historyAdapter;
//    @ActivityContext
//    @Inject
//    Context context;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    private OrdersHistoryViewModel historyViewModel;
//    private PublishSubject<Boolean> backButtonClickSource = PublishSubject.create();
//    private static final long EXIT_TIMEOUT = 2000;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        OrderHistoryFragmentComponent orderHistoryFragmentComponent = applicationComponent.orderHistoryFragmentComponentBuilder().getContext(getActivity()).getClickListener(this).build();
//        orderHistoryFragmentComponent.inject(this);
//        //data binding to view
//        historyViewModel = new ViewModelProvider(this, viewModelFactory).get(OrdersHistoryViewModel.class);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_order_history, container , false);
        View view = binding.getRoot();
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        if (navController == null) {
//            navController = Navigation.findNavController(view);
//        }
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setViewModel(historyViewModel);
//        binding.setFragment(this);
//
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
//        initializeRecyclerOrders();
//    }
//
//    private void initializeRecyclerOrders() {
//        binding.orderHistoryRecycler.setLayoutManager(new LinearLayoutManager(context));
//        binding.orderHistoryRecycler.setAdapter(historyAdapter);
//        historyViewModel.getOrderHistoryMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<OrdersHistoryModel.InnerDatum>>() {
//            @Override
//            public void onChanged(List<OrdersHistoryModel.InnerDatum> ordersHistoryModel) {
//               historyAdapter.submitList(ordersHistoryModel);
//            }
//        });
//    }
//    private void setSnackBar() {
//        Snackbar snackbar = Snackbar
//                .make(binding.coordinate, R.string.once_again_to_exit, Snackbar.LENGTH_LONG);
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
//    @Override
//    public void clickOrder(int position) {
//        List<OrdersHistoryModel.InnerDatum> orders = new ArrayList<>(historyAdapter.getCurrentList());
//        OrdersHistoryModel.InnerDatum order = orders.get(position);
//        OrderHistoryFragmentDirections.ActionOrderHistoryFragmentToOrderDetailFragment actionNotificationFragmentToOrderDetailFragment = OrderHistoryFragmentDirections.actionOrderHistoryFragmentToOrderDetailFragment();
//        actionNotificationFragmentToOrderDetailFragment.setOrderId(order.getId());
//        navController.navigate(actionNotificationFragmentToOrderDetailFragment);
//    }
}