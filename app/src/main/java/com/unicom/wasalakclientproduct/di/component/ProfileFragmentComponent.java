package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;

import com.unicom.wasalakclientproduct.di.module.EditProfileViewModelModule;
import com.unicom.wasalakclientproduct.di.module.UserServiceModule;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.ui.user.EditProfileFragment;
import com.unicom.wasalakclientproduct.ui.user.ProfileFragment;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent
public interface ProfileFragmentComponent {

    void inject(ProfileFragment profileFragment);

    @Subcomponent.Builder
    interface Builder{
        ProfileFragmentComponent build();
    }
}
