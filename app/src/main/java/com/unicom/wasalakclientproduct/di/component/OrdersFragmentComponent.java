//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.adapter.OrdersAdapter;
//import com.unicom.waslak_client.di.module.OrdersModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.OrdersFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {OrdersModule.class})
//public interface OrdersFragmentComponent {
//
//    void inject(OrdersFragment ordersFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        @BindsInstance
//        Builder getClickListener(OrdersAdapter.ClickListener clickListener);
//
//
//        OrdersFragmentComponent build();
//    }
//}
