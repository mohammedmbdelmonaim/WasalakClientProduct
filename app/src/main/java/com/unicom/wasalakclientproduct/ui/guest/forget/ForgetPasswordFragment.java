package com.unicom.wasalakclientproduct.ui.guest.forget;

import android.content.Context;
import android.graphics.Color;
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

import com.google.android.material.snackbar.Snackbar;
import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentForgetBinding;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.ForgetPassFragmentComponent;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.model.guest.ForgetPassUSer;
import com.unicom.wasalakclientproduct.model.guest.ForgetPasswordModel;
import com.unicom.wasalakclientproduct.viewmodel.ViewModelFactory;
import com.unicom.wasalakclientproduct.viewmodel.guest.ForgetPasswordViewModel;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;

public class ForgetPasswordFragment extends Fragment {
    private NavController navController;
    private FragmentForgetBinding binding;
    private ForgetPasswordViewModel forgetPasswordViewModel;
    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    @ActivityContext
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_forget , container , false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //         dagger
        ApplicationComponent applicationComponent = MainApplication.get(getActivity()).getApplicationComponent();
        ForgetPassFragmentComponent forgetPassFragmentComponent = applicationComponent.forgetPassFragmentComponentBuilder().getContext(getActivity()).build();
        forgetPassFragmentComponent.inject(this);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }


        //data binding to view
        forgetPasswordViewModel = new ViewModelProvider(this, viewModelFactory).get(ForgetPasswordViewModel.class);
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
                navController.navigate(R.id.action_forgetFragment_to_resetFragment);
                Toasty.info(context ,getString(R.string.check_email) , Toast.LENGTH_LONG).show();
            }
        });
    }

}