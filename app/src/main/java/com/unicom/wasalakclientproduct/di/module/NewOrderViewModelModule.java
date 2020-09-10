//package com.unicom.wasalakclientproduct.di.module;
//
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.unicom.waslak_client.di.key.ViewModelKey;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.NewOrderViewModel;
//
//import dagger.Binds;
//import dagger.Module;
//import dagger.multibindings.IntoMap;
//
//@Module
//public abstract class NewOrderViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(NewOrderViewModel.class)
//    abstract ViewModel bindViewModel(NewOrderViewModel requestsViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
//}
