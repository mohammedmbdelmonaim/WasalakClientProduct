package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;

import com.unicom.wasalakclientproduct.di.module.ChangePassViewModelModule;
import com.unicom.wasalakclientproduct.di.module.EditProfileViewModelModule;
import com.unicom.wasalakclientproduct.di.module.UserServiceModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.user.ChangePasswordFragment;
import com.unicom.wasalakclientproduct.ui.user.EditProfileFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {EditProfileViewModelModule.class , UserServiceModule.class})
public interface EditProfileFragmentComponent {

    void inject(EditProfileFragment editProfileFragment);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        EditProfileFragmentComponent build();
    }
}
