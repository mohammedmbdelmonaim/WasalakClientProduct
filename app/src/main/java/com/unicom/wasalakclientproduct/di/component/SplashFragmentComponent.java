package com.unicom.wasalakclientproduct.di.component;


import com.unicom.wasalakclientproduct.di.scope.ActivityScope;
import com.unicom.wasalakclientproduct.ui.splash.SplashActivity;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface SplashFragmentComponent {

    void inject(SplashActivity activity);

}
