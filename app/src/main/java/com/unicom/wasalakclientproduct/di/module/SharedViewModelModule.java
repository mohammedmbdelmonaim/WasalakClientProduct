//package com.unicom.wasalakclientproduct.di.module;
//
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.unicom.wasalakclientproduct.di.key.ViewModelKey;
//
//import dagger.Binds;
//import dagger.Module;
//import dagger.multibindings.IntoMap;
//
//@Module
//public abstract class SharedViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(SharedViewModel.class)
//    abstract ViewModel bindViewModel(SharedViewModel sharedViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
//}
