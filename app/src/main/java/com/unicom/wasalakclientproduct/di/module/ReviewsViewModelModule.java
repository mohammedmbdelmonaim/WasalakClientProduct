//package com.unicom.wasalakclientproduct.di.module;
//
//import androidx.lifecycle.ViewModel;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.unicom.waslak_client.di.key.ViewModelKey;
//import com.unicom.waslak_client.viewmodel.ViewModelFactory;
//import com.unicom.waslak_client.viewmodel.user.ReviewsViewModel;
//
//import dagger.Binds;
//import dagger.Module;
//import dagger.multibindings.IntoMap;
//
//@Module
//public abstract class ReviewsViewModelModule {
//    @Binds
//    @IntoMap
//    @ViewModelKey(ReviewsViewModel.class)
//    abstract ViewModel bindViewModel(ReviewsViewModel reviewsViewModel);
//
//    @Binds
//    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory factory);
//}
