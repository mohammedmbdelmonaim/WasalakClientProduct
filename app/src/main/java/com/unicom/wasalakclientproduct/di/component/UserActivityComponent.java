package com.unicom.wasalakclientproduct.di.component;


import android.content.Context;

import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.ActivityScope;
import com.unicom.wasalakclientproduct.ui.splash.SplashActivity;
import com.unicom.wasalakclientproduct.ui.user.UserActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface UserActivityComponent {

    void inject(UserActivity activity);
    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        @BindsInstance
        Builder listPermission(String[] permissions);

        UserActivityComponent build();
    }
}
