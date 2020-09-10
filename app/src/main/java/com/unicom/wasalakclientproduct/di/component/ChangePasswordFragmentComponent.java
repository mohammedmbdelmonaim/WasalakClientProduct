package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.module.ChangePassViewModelModule;
import com.unicom.wasalakclientproduct.di.module.UserServiceModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.user.ChangePasswordFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {ChangePassViewModelModule.class , UserServiceModule.class})
public interface ChangePasswordFragmentComponent {

    void inject(ChangePasswordFragment changePasswordFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        ChangePasswordFragmentComponent build();
    }
}
