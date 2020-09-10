package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;

import com.unicom.wasalakclientproduct.di.module.GuestServiceModule;
import com.unicom.wasalakclientproduct.di.module.RegisterViewModelModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.guest.register.RegisterFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {RegisterViewModelModule.class , GuestServiceModule.class})
public interface RegisterFragmentComponent {

    void inject(RegisterFragment registerFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        RegisterFragmentComponent build();
    }
}
