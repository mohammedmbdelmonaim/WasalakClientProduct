//package com.unicom.wasalakclientproduct.ui.user;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.RatingBar;
//import android.widget.Toast;
//
//import androidx.activity.OnBackPressedCallback;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//import androidx.fragment.app.Fragment;
//import androidx.navigation.NavController;
//import androidx.navigation.NavOptions;
//import androidx.navigation.Navigation;
//
//import com.google.android.material.snackbar.Snackbar;
//import com.unicom.waslak_client.MainApplication;
//import com.unicom.waslak_client.R;
//import com.unicom.waslak_client.databinding.FragmentAddReviewBinding;
//import com.unicom.waslak_client.di.component.ApplicationComponent;
//import com.unicom.waslak_client.di.component.ReviewsComponent;
//import com.unicom.waslak_client.model.user.RateModel;
//import com.unicom.waslak_client.model.user.RateUser;
//import com.unicom.waslak_client.model.user.StoresActivityModel;
//import com.unicom.waslak_client.repository.UserRepository;
//import com.unicom.waslak_client.utils.KeyboardUtils;
//import com.unicom.waslak_client.utils.PreferenceUtils;
//
//import javax.inject.Inject;
//
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.disposables.Disposable;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//import io.reactivex.rxjava3.subjects.PublishSubject;
//
//
//public class AddReviewFragment extends Fragment {
//    private FragmentAddReviewBinding binding;
//    private NavController navController;
//    private StoresActivityModel.InnerDatum store;
//    private float rating;
//    private String review;
//    @Inject
//    UserRepository userRepository;
//    RateUser rateUser;
//    @Inject
//    PreferenceUtils preference;
//    @Inject
//    KeyboardUtils keyboardUtils;
//    private Disposable disposable;
//    private boolean first_review;
//    public PublishSubject publishSubject = PublishSubject.create();
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        ReviewsComponent component = applicationComponent.reviewsComponentComponentBuilder().getContext(getActivity()).build();
//        component.inject(this);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_review, container, false);
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
//        binding.setLifecycleOwner(this);
//        binding.setFragment(this);
//        binding.addReviewToolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
//        //get store object
//        if (getArguments() != null) {
//            AddReviewFragmentArgs args = AddReviewFragmentArgs.fromBundle(getArguments());
//            first_review = args.getFirstReview();
//            store = args.getStore();
//        }
//        binding.rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                AddReviewFragment.this.rating = rating;
//            }
//        });
//    }
//
//
//    public void submitRating() {
//        review = binding.edtAddProducts.getText().toString();
//        if (review == null || review.isEmpty()) {
//            Snackbar snackbar = Snackbar
//                    .make(binding.constraint, R.string.insert_review, Snackbar.LENGTH_LONG);
//            snackbar.setTextColor(Color.RED);
//            snackbar.show();
//            return;
//        }
//        binding.progressBar.setVisibility(View.VISIBLE);
//        rateUser = new RateUser(store.getId(), (int) rating, review);
//        keyboardUtils.hideKeyboard();
//        disposable = userRepository.getRate("Bearer "+preference.getTokenUser(),rateUser).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError);
//    }
//    private void handleError(Throwable throwable) {
//        Toast.makeText(getContext(), throwable.toString(), Toast.LENGTH_SHORT).show();
//        binding.progressBar.setVisibility(View.GONE);
//    }
//
//    private void handleResults(RateModel rateModel) {
//        if (rateModel != null && rateModel.getIsSuccess()){
//            if (first_review) {
//                Bundle bundle = new Bundle();
//                store.setNumberOfReviews(rateModel.getInnerData().getNumberOfReviews());
//                store.setRate(rateModel.getInnerData().getRate());
//                bundle.putParcelable("store", store);
//                // go to fragment and destroy this
//                NavOptions options = new NavOptions.Builder().setPopUpTo(R.id.addReviewFragment, true).build();
//                navController.navigate(R.id.action_addReviewFragment_to_reviewsFragment, bundle, options);
//            }else{
//                store.setNumberOfReviews(rateModel.getInnerData().getNumberOfReviews());
//                store.setRate(rateModel.getInnerData().getRate());
//                navController.navigateUp();
//            }
//        }
//        binding.progressBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        if (disposable != null) {
//            disposable.dispose();
//        }
//    }
//}