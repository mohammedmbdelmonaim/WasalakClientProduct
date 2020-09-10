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
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.adapter.ReviewsAdapter;
//import com.unicom.waslak_client.databinding.FragmentReviewsBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.ReviewsComponent;
//import com.unicom.waslak_client.model.user.RateModel;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.ReviewsViewModel;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//
//public class ReviewsFragment extends Fragment {
//    private FragmentReviewsBinding binding;
//    private NavController navController;
//    @Inject
//    ReviewsAdapter reviewsAdapter;
//    @Inject
//    ViewModelFactory viewModelFactory;
//    private ReviewsViewModel reviewsViewModel;
//    private StoresActivityModel.InnerDatum store;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        ReviewsComponent component = applicationComponent.reviewsComponentComponentBuilder().getContext(getActivity()).build();
//        component.inject(this);
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reviews, container, false);
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
//        //data binding to view
//        binding.setLifecycleOwner(this);
//        binding.setFragment(this);
//        binding.setViewModel(reviewsViewModel);
//
//        binding.reviewToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
//        reviewsViewModel = new ViewModelProvider(this, viewModelFactory).get(ReviewsViewModel.class);
//        //get store object
//        if (getArguments() != null) {
//            ReviewsFragmentArgs args = ReviewsFragmentArgs.fromBundle(getArguments());
//            store = args.getStore();
//            reviewsViewModel.storeLiveData.setValue(store);
//        }
//
//
//        binding.addReview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ReviewsFragmentDirections.ActionReviewsFragmentToAddReviewFragment toAddReviewFragment = ReviewsFragmentDirections.actionReviewsFragmentToAddReviewFragment(store);
//                navController.navigate(toAddReviewFragment);
//            }
//        });
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        initializeRecyclerProducts();
//    }
//
//    private void initializeRecyclerProducts() {
//        binding.recyclerReviews.setLayoutManager(new LinearLayoutManager(getContext()));
//        binding.recyclerReviews.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        binding.recyclerReviews.setAdapter(reviewsAdapter);
//
//        reviewsViewModel.getCustomer_rates().observe(getViewLifecycleOwner(), new Observer<List<RateModel.CustomersRate>>() {
//            @Override
//            public void onChanged(List<RateModel.CustomersRate> customersRates) {
//                reviewsAdapter.submitList(customersRates);
//                binding.progressBar.setVisibility(View.GONE);
//            }
//        });
//
//    }
//
//}