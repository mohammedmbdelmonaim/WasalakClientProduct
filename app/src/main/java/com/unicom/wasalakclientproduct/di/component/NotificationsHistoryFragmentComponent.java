//package com.unicom.wasalakclientproduct.di.component;
//
//import android.content.Context;
//
//import com.unicom.waslak_client.adapter.NotificationsHistoryAdapter;
//import com.unicom.waslak_client.di.module.NotificationsHistoryModule;
//import com.unicom.waslak_client.di.module.NotificationsHistoryViewModelModule;
//import com.unicom.waslak_client.di.module.UserServiceModule;
//import com.unicom.waslak_client.di.qualifier.ActivityContext;
//import com.unicom.waslak_client.di.scope.FragmentScope;
//import com.unicom.waslak_client.ui.user.NotificationFragment;
//
//import dagger.BindsInstance;
//import dagger.Subcomponent;
//
//@FragmentScope
//@Subcomponent(modules = {NotificationsHistoryViewModelModule.class , UserServiceModule.class , NotificationsHistoryModule.class})
//public interface NotificationsHistoryFragmentComponent {
//
//    void inject(NotificationFragment notificationFragment);
//
//    @Subcomponent.Builder
//    interface Builder{
//        @BindsInstance
//        Builder getContext(@ActivityContext Context context);
//
//        @BindsInstance
//        Builder getClickListener(NotificationsHistoryAdapter.ClickListener clickListener);
//
//
//        NotificationsHistoryFragmentComponent build();
//    }
//}
