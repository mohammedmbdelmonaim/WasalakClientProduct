package com.unicom.wasalakclientproduct.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.unicom.wasalakclientproduct.di.key.ViewModelKey;
import com.unicom.wasalakclientproduct.viewmodel.ViewModelFactory;
import com.unicom.wasalakclientproduct.viewmodel.user.MyAccountViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MyAccountViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyAccountViewModel.class)
    abstract ViewModel bindViewModel(MyAccountViewModel forgetPasswordViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
}
