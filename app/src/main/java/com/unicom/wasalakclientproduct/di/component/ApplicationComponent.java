package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.module.AppPreferenceModule;
import com.unicom.wasalakclientproduct.di.module.NetworkModule;
import com.unicom.wasalakclientproduct.di.qualifier.ApplicationContext;
import com.unicom.wasalakclientproduct.di.scope.ApplicationScope;
import com.unicom.wasalakclientproduct.model.MyAppGlideModule;

import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {NetworkModule.class , AppPreferenceModule.class})
public interface ApplicationComponent {

    LoginFragmentComponent.Builder loginFragmentComponentBuilder();

    RegisterFragmentComponent.Builder registerFragmentComponentBuilder();

    ForgetPassFragmentComponent.Builder forgetPassFragmentComponentBuilder();

    void inject(MyAppGlideModule glide);

//    RequstsFragmentComponent.Builder requstsFragmentComponentBuilder();

//    NewOrderFragmentComponent.Builder newOrderFragmentComponentBuilder();
//
//    OrdersFragmentComponent.Builder orderFragmentComponentBuilder();
//
//    OrderInfoFragmentComponent.Builder orderInfoFragmentComponentBuilder();
//
//    MapFragmentComponent.Builder mapFragmentComponentBuilder();
//
//    OrderHistoryFragmentComponent.Builder orderHistoryFragmentComponentBuilder();

    MyAccountFragmentComponent.Builder myAccountFragmentComponentBuilder();

    ChangePasswordFragmentComponent.Builder changePasswordFragmentComponentBuilder();

    EditProfileFragmentComponent.Builder editProfileFragmentComponentBuilder();

    ProfileFragmentComponent.Builder profileFragmentComponentBuilder();

    SplashFragmentComponent splashFragmentComponent();

    BaseActivityComponent.Builder baseActivityComponent();

    UserActivityComponent.Builder userActivityComponent();

//    ReviewsComponent.Builder reviewsComponentComponentBuilder();

//    OrderDetailFragmentComponent.Builder orderDetailComponentBuilder();
//
//    NotificationsHistoryFragmentComponent.Builder notificationComponentComponentBuilder();

    FirebaseServiceComponent firebaseServiceComponent();

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ApplicationContext Context context);

        ApplicationComponent build();
    }
}
