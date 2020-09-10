package com.unicom.wasalakclientproduct.di.module;


import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.remote.UserService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class UserServiceModule {

    @Provides
    @FragmentScope
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }
}
