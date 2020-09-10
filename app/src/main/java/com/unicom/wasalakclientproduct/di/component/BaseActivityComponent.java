package com.unicom.wasalakclientproduct.di.component;

import android.content.Context;


import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.ActivityScope;
import com.unicom.wasalakclientproduct.ui.BaseActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface BaseActivityComponent {

    void inject(BaseActivity activity);

    @Subcomponent.Builder
    interface Builder{
        @BindsInstance
        Builder getContext(@ActivityContext Context context);

        BaseActivityComponent build();
    }
}
