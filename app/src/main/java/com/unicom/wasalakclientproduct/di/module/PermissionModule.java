package com.unicom.wasalakclientproduct.di.module;

import android.Manifest;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;

@InstallIn(ActivityComponent.class)
@Module
public class PermissionModule {

    @Provides
    @ActivityScoped
    String[] providePermissions(){
        return new String[]{ Manifest.permission.ACCESS_FINE_LOCATION};
    }
}
