package com.unicom.wasalakclientproduct.di.module;

import com.unicom.wasalakclientproduct.remote.GuestService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import retrofit2.Retrofit;

@InstallIn(ActivityRetainedComponent.class)
@Module
public class GuestServiceModule {

    @Provides
    @ActivityRetainedScoped
    GuestService provideGuestService(Retrofit retrofit) {
        return retrofit.create(GuestService.class);
    }
}
