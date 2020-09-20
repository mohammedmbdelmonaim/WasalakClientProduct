package com.unicom.wasalakclientproduct.ui.user;

import android.content.DialogInterface;
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
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.databinding.FragmentMyAccountBinding;
import com.unicom.wasalakclientproduct.model.GlideApp;
import com.unicom.wasalakclientproduct.model.StructueMode;
import com.unicom.wasalakclientproduct.model.user.AccountModel;
import com.unicom.wasalakclientproduct.ui.guest.GuestActivity;
import com.unicom.wasalakclientproduct.utils.ChangeLang;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.viewmodel.user.MyAccountViewModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

@AndroidEntryPoint
public class MyAccountFragment extends Fragment {
    private FragmentMyAccountBinding binding;
    private NavController navController;
    private MyAccountViewModel myAccountViewModel;

    @Inject
    public PreferenceUtils preference;
    private PublishSubject<Boolean> backButtonClickSource = PublishSubject.create();
    private static final long EXIT_TIMEOUT = 2000;
    private CircularProgressDrawable circularProgressDrawable;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data binding to view
        myAccountViewModel = new ViewModelProvider(this).get(MyAccountViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_account, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (navController == null) {
            navController = Navigation.findNavController(view);
        }
        ((UserActivity) getActivity()).binding.bottomNavigation.setVisibility(View.VISIBLE);

        //handle back button
        observeBackButton();

        getActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                backButtonClickSource.onNext(true);
            }
        });
        binding.setLifecycleOwner(this);
        binding.setFragment(this);
        binding.setViewModel(myAccountViewModel);
        checkSwitchChange();

        myAccountViewModel.getAccountMutableLiveData().observe(getViewLifecycleOwner(), new Observer<AccountModel>() {
            @Override
            public void onChanged(AccountModel accountModel) {
//                circularProgressDrawable = new CircularProgressDrawable(context);
//                circularProgressDrawable.setStrokeWidth(5f);
//                circularProgressDrawable.setCenterRadius(30f);
//                circularProgressDrawable.start();
                binding.setAccount(accountModel.getResult());
                GlideApp.with(MyAccountFragment.this)
                        .load("http://192.168.50.236:4101/api"+accountModel.getResult().getUserImage())
                        .placeholder(R.drawable.ic_wasellak_logo_color)
                        .into(binding.profileImage);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        checkSwitchChange();
    }

    private boolean isCheck;

    private void checkSwitchChange() {
//        binding.switchNotification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                isCheck = preference.getNotification();
//                if (isChecked == isCheck) {
//                    return;
//                }
//                myAccountViewModel.notification.setValue(isChecked);
//                myAccountViewModel.publishSubject.onNext("null");
//
//            }
//        });
    }

    public void onClickLogout() {
        new MaterialAlertDialogBuilder(getActivity(), R.style.AlertDialogTheme)
                .setTitle("")
                .setMessage(R.string.sure_logout)
                .setNegativeButton(R.string.logout, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        preference.saveTokenUser("");
                        startActivity(new Intent(getActivity(), GuestActivity.class));
                        getActivity().overridePendingTransition(R.anim.animate_diagonal_right_enter,
                                R.anim.animate_diagonal_right_exit);
                        getActivity().finish();
                    }
                })
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    public void clickChangePass() {
        navController.navigate(R.id.action_myAccountFragment_to_changePasswordFragment);
    }

    public void clickViewProfile() {
        MyAccountFragmentDirections.ActionMyAccountFragmentToProfileFragment toProfileFragment = MyAccountFragmentDirections.actionMyAccountFragmentToProfileFragment(myAccountViewModel.getAccountMutableLiveData().getValue().getResult());
        navController.navigate(toProfileFragment);
    }


    public void onClickLanguage() {
        new MaterialAlertDialogBuilder(getActivity(), R.style.AlertDialogTheme)
                .setTitle("")
                .setMessage(R.string.choose_lang)
                .setNegativeButton(R.string.arabic, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myAccountViewModel.getLang().setValue("ar");
                        myAccountViewModel.langService("ar-EG");
                    }
                })
                .setPositiveButton(R.string.english, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myAccountViewModel.getLang().setValue("en");
                        myAccountViewModel.langService("en");
                    }
                })
                .show();
        myAccountViewModel.getLangMutableLiveData().observe(getViewLifecycleOwner(), new Observer<StructueMode>() {
            @Override
            public void onChanged(StructueMode structueMode) {
                ChangeLang.setNewLocale(getActivity(), myAccountViewModel.getLang().getValue());
                startActivity(new Intent(getActivity(), UserActivity.class));
                getActivity().overridePendingTransition(R.anim.animate_zoom_enter,
                        R.anim.animate_zoom_exit);
                getActivity().finish();
            }
        });


    }

    private void setSnackBar() {
//        Snackbar snackbar = Snackbar
//                .make(binding.coordinate, R.string.once_again_to_exit, Snackbar.LENGTH_LONG);
//        snackbar.setTextColor(Color.GREEN);
//        snackbar.show();
    }

    private Disposable observeBackButton() {
        return backButtonClickSource
                .debounce(100, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(__ -> setSnackBar())
                .timeInterval(TimeUnit.MILLISECONDS)
                .skip(1)
                .filter(interval -> interval.time() < EXIT_TIMEOUT)
                .subscribe(__ -> getActivity().finish());
    }
}