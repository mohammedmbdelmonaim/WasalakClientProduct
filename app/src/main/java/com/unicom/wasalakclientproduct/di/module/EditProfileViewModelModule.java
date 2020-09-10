package com.unicom.wasalakclientproduct.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.unicom.wasalakclientproduct.di.key.ViewModelKey;
import com.unicom.wasalakclientproduct.viewmodel.ViewModelFactory;
import com.unicom.wasalakclientproduct.viewmodel.user.ChangePasswordViewModel;
import com.unicom.wasalakclientproduct.viewmodel.user.EditProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class EditProfileViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(EditProfileViewModel.class)
    abstract ViewModel bindViewModel(EditProfileViewModel editProfileViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}
