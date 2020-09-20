package com.unicom.wasalakclientproduct.ui.guest.forget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentForgetBinding;
import com.unicom.wasalakclientproduct.model.guest.ForgetPassUSer;
import com.unicom.wasalakclientproduct.model.guest.ForgetPasswordModel;
import com.unicom.wasalakclientproduct.viewmodel.guest.ForgetPasswordViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import es.dmoral.toasty.Toasty;
@AndroidEntryPoint
public class ForgetPasswordFragment extends Fragment {
    private NavController navController;
    private FragmentForgetBinding binding;
    private ForgetPasswordViewModel forgetPasswordViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_forget , container , false);
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
        forgetPasswordViewModel = new ViewModelProvider(this).get(ForgetPasswordViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setForgetViewModel(forgetPasswordViewModel);
        binding.setFragment(this);

        // get user data and validate then call network
        forgetPasswordViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<ForgetPassUSer>() {
            @Override
            public void onChanged(ForgetPassUSer forgetPassUSer) {
                binding.txtLayoutEmail.setError(null);
                if (forgetPassUSer.getStrEmailAddress() == null || forgetPassUSer.getStrEmailAddress().isEmpty()) {
                    binding.txtLayoutEmail.setError(getResources().getString(R.string.email_mandatory));
                    forgetPasswordViewModel.enableButton.setValue(true);
                }else if (!forgetPassUSer.isEmailValid()) {
                    binding.txtLayoutEmail.setError(getResources().getString(R.string.email_error));
                    forgetPasswordViewModel.enableButton.setValue(true);
                }else{
                    forgetPasswordViewModel.forgetNetwork();
                }
            }
        });
//
//        //get login network data
        forgetPasswordViewModel.getForgetNetworkResponse().observe(getViewLifecycleOwner(), new Observer<ForgetPasswordModel>() {
            @Override
            public void onChanged(ForgetPasswordModel forgetPasswordModel) {
                navController.navigateUp();
                Toasty.info(getActivity() ,getString(R.string.check_email) , Toast.LENGTH_LONG).show();
            }
        });
    }

}