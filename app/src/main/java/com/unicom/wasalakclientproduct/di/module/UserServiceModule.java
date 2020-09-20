package com.unicom.wasalakclientproduct.di.module;


import com.unicom.wasalakclientproduct.remote.UserService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import retrofit2.Retrofit;

@InstallIn(ActivityRetainedComponent.class)
@Module
public class UserServiceModule {

    @Provides
    @ActivityRetainedScoped
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
