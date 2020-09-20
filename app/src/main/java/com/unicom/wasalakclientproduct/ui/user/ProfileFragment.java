package com.unicom.wasalakclientproduct.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentProfileBinding;
import com.unicom.wasalakclientproduct.model.GlideApp;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;
    private NavController navController;
    @Inject
    public PreferenceUtils preference;
    ProfileFragmentArgs args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }

        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navController.navigateUp();
            }
        });

        //data binding to view
        binding.setLifecycleOwner(this);
        binding.setFragment(this);

        getProfileData();
//
    }

    private void getProfileData(){
        //get store object
        if (getArguments() != null) {
            args = ProfileFragmentArgs.fromBundle(getArguments());
            binding.setAccount(args.getProfileAccount());
            GlideApp.with(ProfileFragment.this)
                    .load("http://192.168.50.236:4101/api"+args.getProfileAccount().getUserImage())
                    .placeholder(R.drawable.ic_wasellak_logo_color)
                    .into(binding.profileImage);
        }
    }

    public void editProfile(){
        ProfileFragmentDirections.ActionProfileFragmentToEditProfileFragment toEditProfileFragment = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment(args.getProfileAccount());
        navController.navigate(toEditProfileFragment);
    }
}