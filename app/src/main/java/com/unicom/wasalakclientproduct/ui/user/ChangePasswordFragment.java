package com.unicom.wasalakclientproduct.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentChangePasswordBinding;
import com.unicom.wasalakclientproduct.model.StructueMode;
import com.unicom.wasalakclientproduct.model.user.ChangePassUser;
import com.unicom.wasalakclientproduct.ui.guest.GuestActivity;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.viewmodel.user.ChangePasswordViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import es.dmoral.toasty.Toasty;

@AndroidEntryPoint
public class ChangePasswordFragment extends Fragment {
    private FragmentChangePasswordBinding binding;
    private NavController navController;
    private ChangePasswordViewModel changePasswordViewModel;
    @Inject
    public PreferenceUtils preference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_change_password, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }
        binding.changePassToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigateUp();
            }
        });
        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigateUp();
            }
        });

        //data binding to view
        changePasswordViewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(changePasswordViewModel);
        binding.setFragment(this);

        // get user data and validate then call network
        changePasswordViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<ChangePassUser>() {
            @Override
            public void onChanged(ChangePassUser changePassUser) {
                binding.txtLayoutConfirmPassword.setError(null);
                binding.txtLayoutNewPassword.setError(null);
                binding.txtLayoutPassword.setError(null);
                if (changePassUser.getOldPassword() == null || changePassUser.getOldPassword().isEmpty()) {
                    binding.txtLayoutPassword.setError(getResources().getString(R.string.password_mandatory));
                    changePasswordViewModel.enableButton.setValue(true);
                } else if (changePassUser.getNewPassword() == null || changePassUser.getNewPassword().isEmpty()) {
                    binding.txtLayoutNewPassword.setError(getResources().getString(R.string.password_mandatory));
                    changePasswordViewModel.enableButton.setValue(true);
                } else if (changePasswordViewModel.passwordConfirm.getValue() == null || changePasswordViewModel.passwordConfirm.getValue().isEmpty()) {
                    binding.txtLayoutConfirmPassword.setError(getResources().getString(R.string.password_mandatory));
                    changePasswordViewModel.enableButton.setValue(true);
                } else if (changePassUser.isPasswordValid()) {
                    binding.txtLayoutNewPassword.setError(getResources().getString(R.string.password_error));
                    changePasswordViewModel.enableButton.setValue(true);
                } else if (!changePassUser.isPasswordMatch()) {
                    binding.txtLayoutConfirmPassword.setError(getString(R.string.password_not_match));
                    binding.txtLayoutNewPassword.setError(getString(R.string.password_not_match));
                    changePasswordViewModel.enableButton.setValue(true);
                } else if (!changePassUser.isPasswordValid2()) {
                    binding.txtLayoutNewPassword.setError(getString(R.string.password_not_valid));
                    changePasswordViewModel.enableButton.setValue(true);
                } else {
                    changePasswordViewModel.changePass();
                }
            }
        });


        //get login network data
        changePasswordViewModel.getLChangePassNetworkResponse().observe(getViewLifecycleOwner(), new Observer<StructueMode>() {
            @Override
            public void onChanged(StructueMode changePassModel) {
                Toasty.success(getActivity(), R.string.success_change, Toasty.LENGTH_LONG).show();
                preference.saveTokenUser("");
                startActivity(new Intent(getActivity(), GuestActivity.class));
                getActivity().overridePendingTransition(R.anim.animate_diagonal_right_enter,
                        R.anim.animate_diagonal_right_exit);
                getActivity().finish();
            }
        });

    }

}