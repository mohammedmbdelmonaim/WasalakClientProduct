//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.di.module.OrderInfoViewModelModule;
//import com.unicom.waslak_client.di.module.SharedViewModelModule;
//import com.unicom.waslak_client.di.module.UserServiceModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.OrderInfoFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {OrderInfoViewModelModule.class , UserServiceModule.class, SharedViewModelModule.class})
//public interface OrderInfoFragmentComponent {
//
//    void inject(OrderInfoFragment orderInfoFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        OrderInfoFragmentComponent build();
//    }
//}
