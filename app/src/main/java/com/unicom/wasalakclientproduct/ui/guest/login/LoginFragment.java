package com.unicom.wasalakclientproduct.ui.guest.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentLoginBinding;
import com.unicom.wasalakclientproduct.model.guest.LoginModel;
import com.unicom.wasalakclientproduct.model.guest.LoginUser;
import com.unicom.wasalakclientproduct.ui.user.UserActivity;
import com.unicom.wasalakclientproduct.viewmodel.guest.LoginViewModel;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 */
@AndroidEntryPoint
public class LoginFragment extends Fragment {
    private NavController navController;
    private FragmentLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }

        //data binding to view
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(loginViewModel);
        binding.setFragment(this);

//         get user data and validate then call network
        loginViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<LoginUser>() {
            @Override
            public void onChanged(LoginUser loginUser) {
                binding.txtLayoutEmail.setError(null);
                binding.txtLayoutPassword.setError(null);
                if (loginUser.getUserNameOrEmailAddress() == null || loginUser.getUserNameOrEmailAddress().isEmpty()) {
                    binding.txtLayoutEmail.setError(getResources().getString(R.string.email_mandatory2));
                    loginViewModel.enableButton.setValue(true);
                } else if (loginUser.getPassword() == null || loginUser.getPassword().isEmpty()) {
                    binding.txtLayoutPassword.setError(getResources().getString(R.string.pass_mandatory2));
                    loginViewModel.enableButton.setValue(true);
                } else if (!loginUser.isEmailValid()) {
                    binding.txtLayoutEmail.setError(getString(R.string.email_error));
                    loginViewModel.enableButton.setValue(true);
                } else {
                    loginViewModel.loginNetwork();
                }
            }
        });

//        get login network data
        loginViewModel.getLoginNetworkResponse().observe(getViewLifecycleOwner(), new Observer<LoginModel>() {
            @Override
            public void onChanged(LoginModel loginModel) {
                startActivity(new Intent(getActivity(), UserActivity.class));
                getActivity().overridePendingTransition(R.anim.animate_slide_in_left,
                        R.anim.animate_slide_out_right);
                getActivity().finish();
            }
        });
    }

    public void onClickForget() {
        navController.navigate(R.id.action_loginFragment_to_forgetFragment);
    }

    //
    public void onClickRegister() {
        navController.navigate(R.id.action_loginFragment_to_registerFragment);
    }

}