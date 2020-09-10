package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.module.MyAccountViewModelModule;
import com.unicom.wasalakclientproduct.di.module.UserServiceModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.user.MyAccountFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {MyAccountViewModelModule.class , UserServiceModule.class})
public interface MyAccountFragmentComponent {

    void inject(MyAccountFragment myAccountFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        MyAccountFragmentComponent build();
    }
}
