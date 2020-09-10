//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import androidx.fragment.app.Fragment;
//
//
//import com.unicom.wasalakclientproduct.di.module.ActivitesModule;
//import com.unicom.wasalakclientproduct.di.module.ActivityStoresModule;
//import com.unicom.wasalakclientproduct.di.module.RequestsViewModelModule;
//import com.unicom.wasalakclientproduct.di.module.UserServiceModule;
//import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
//import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {RequestsViewModelModule.class , UserServiceModule.class , ActivitesModule.class , ActivityStoresModule.class})
//public interface RequstsFragmentComponent {
//
////    void inject(RequestsFragment requestsFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        @BindsInstance
//        Builder getFragment(Fragment fragment);
//
////        @BindsInstance
////        Builder getClickListener(ActivitiesAdapter.ClickListener clickListener);
////
////        @BindsInstance
////        Builder getClickListenerOrder(ActivityStoresAdapter.ClickListener clickListener);
//
//        @BindsInstance
//        Builder listPermission(String[] permissions);
//
//        RequstsFragmentComponent build();
//    }
//}
