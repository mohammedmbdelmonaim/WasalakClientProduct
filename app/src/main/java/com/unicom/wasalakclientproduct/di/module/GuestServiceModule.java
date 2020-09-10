package com.unicom.wasalakclientproduct.di.module;

import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.remote.GuestService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GuestServiceModule {

    @Provides
    @FragmentScope
    GuestService provideGuestService(Retrofit retrofit){
        return retrofit.create(GuestService.class);
    }
}
