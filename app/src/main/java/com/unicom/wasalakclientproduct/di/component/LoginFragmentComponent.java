package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.module.GuestServiceModule;
import com.unicom.wasalakclientproduct.di.module.LoginViewModelModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.guest.login.LoginFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {LoginViewModelModule.class , GuestServiceModule.class})
public interface LoginFragmentComponent {

    void inject(LoginFragment loginFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        LoginFragmentComponent build();
    }
}
