package com.unicom.wasalakclientproduct.ui.guest.reset;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentResetBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResetFragment extends Fragment {
    private NavController navController;
    private FragmentResetBinding binding;
//    private LoginViewModel loginViewModel;
//    @Inject
//    ViewModelFactory viewModelFactory;

//    @Inject
//    @ActivityContext
//    Context context;


    private static final String TAG = "LoginFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "mohammed onCreateView: ");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reset, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "mohammed onViewCreated: ");
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }


        // dagger
//        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
//        LoginFragmentComponent loginFragmentComponent = applicationComponent.loginFragmentComponentBuilder().getContext(getActivity()).build();
//        loginFragmentComponent.inject(this);

        //data binding to view
//        loginViewModel = new ViewModelProvider(this, viewModelFactory).get(LoginViewModel.class);
//        binding.setLifecycleOwner(this);
//        binding.setLoginViewModel(loginViewModel);
//        binding.setFragment(this);

        // get user data and validate then call network
//        loginViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<LoginUser>() {
//            @Override
//            public void onChanged(LoginUser loginUser) {
//                binding.txtLayoutEmail.setError(null);
//                binding.txtLayoutPassword.setError(null);
//                if (loginUser.getStrEmailAddress() == null || loginUser.getStrEmailAddress().isEmpty()) {
//                    binding.txtLayoutEmail.setError(getResources().getString(R.string.email_mandatory));
//                    loginViewModel.enableButton.setValue(true);
//                } else if (loginUser.getStrPassword() == null || loginUser.getStrPassword().isEmpty()) {
//                    binding.txtLayoutPassword.setError(getResources().getString(R.string.password_mandatory));
//                    loginViewModel.enableButton.setValue(true);
//                } else if (!loginUser.isEmailValid()) {
//                    binding.txtLayoutEmail.setError(getResources().getString(R.string.email_error));
//                    loginViewModel.enableButton.setValue(true);
//                } else if (loginUser.isPasswordValid()) {
//                    binding.txtLayoutPassword.setError(getResources().getString(R.string.password_error));
//                    loginViewModel.enableButton.setValue(true);
//                } else {
//                    loginViewModel.isLoading.setValue(true);
//                    loginViewModel.publishSubject.onNext(new Random().nextInt(258 * 15));
//                }
//            }
//        });

        //get login network data
//        loginViewModel.getLoginNetworkResponse().observe(getViewLifecycleOwner(), new Observer<LoginModel>() {
//            @Override
//            public void onChanged(LoginModel loginModel) {
//                Snackbar snackbar = Snackbar
//                        .make(binding.constraintLayout, R.string.sucess , Snackbar.LENGTH_LONG);
//                snackbar.setTextColor(Color.GREEN);
//                snackbar.show();
//                startActivity(new Intent(context , UserActivity.class));
//                ((GuestActivity) context).overridePendingTransition(R.anim.animate_slide_in_left,
//                        R.anim.animate_slide_out_right);
//                ((GuestActivity) context).finish();
//            }
//        });
//        //handle error response from server
//        loginViewModel.getError().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Snackbar snackbar = Snackbar
//                        .make(binding.loginConstraint, s, Snackbar.LENGTH_LONG)
//                        .setAction(R.string.retry, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
////                                loginViewModel.loginNetwork();
//                            }
//                        });
//                snackbar.setActionTextColor(Color.GREEN);
//                snackbar.setTextColor(Color.RED);
//                snackbar.show();
//
//            }
//        });
    }


}