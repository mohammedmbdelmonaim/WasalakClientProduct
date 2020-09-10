//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.adapter.OrdersHistoryAdapter;
//import com.unicom.waslak_client.di.module.OrdersHistoryModule;
//import com.unicom.waslak_client.di.module.OrdersHistoryViewModelModule;
//import com.unicom.waslak_client.di.module.UserServiceModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.OrderHistoryFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {OrdersHistoryViewModelModule.class, UserServiceModule.class, OrdersHistoryModule.class})
//public interface OrderHistoryFragmentComponent {
//
//    void inject(OrderHistoryFragment orderHistoryFragment);
//
//    @Subcomponent.Builder
//    interface Builder {
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        @BindsInstance
//        Builder getClickListener(OrdersHistoryAdapter.ClickListener clickListener);
//
//        OrderHistoryFragmentComponent build();
//    }
//}
