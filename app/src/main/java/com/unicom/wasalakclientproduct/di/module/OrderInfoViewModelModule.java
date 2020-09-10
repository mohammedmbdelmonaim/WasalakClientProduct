//package com.unicom.wasalakclientproduct.di.module;
//
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.unicom.waslak_client.di.key.ViewModelKey;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.OrderInfoFragmentViewModel;
//
//import dagger.Binds;
//import dagger.Module;
//import dagger.multibindings.IntoMap;
//
//@Module
//public abstract class OrderInfoViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(OrderInfoFragmentViewModel.class)
//    abstract ViewModel bindViewModel(OrderInfoFragmentViewModel loginViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
//}
