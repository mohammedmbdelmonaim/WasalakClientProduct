package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.module.ForgetPassViewModelModule;
import com.unicom.wasalakclientproduct.di.module.GuestServiceModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.guest.forget.ForgetPasswordFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {ForgetPassViewModelModule.class , GuestServiceModule.class})
public interface ForgetPassFragmentComponent {

    void inject(ForgetPasswordFragment loginFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        ForgetPassFragmentComponent build();
    }
}
