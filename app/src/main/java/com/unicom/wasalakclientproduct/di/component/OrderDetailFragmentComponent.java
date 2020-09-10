//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.adapter.DetailStoresAdapter;
//import com.unicom.waslak_client.di.module.ActivityStoresModule;
//import com.unicom.waslak_client.di.module.OrderDetailViewModelModule;
//import com.unicom.waslak_client.di.module.ProductsDetailModule;
//import com.unicom.waslak_client.di.module.UserServiceModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.OrderDetailFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {OrderDetailViewModelModule.class , UserServiceModule.class , ProductsDetailModule.class ,  ActivityStoresModule.class})
//public interface OrderDetailFragmentComponent {
//
//    void inject(OrderDetailFragment orderDetailFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//        @BindsInstance
//        Builder getClickListenerOrder(DetailStoresAdapter.ClickListener clickListener);
//
//        OrderDetailFragmentComponent build();
//    }
//}
