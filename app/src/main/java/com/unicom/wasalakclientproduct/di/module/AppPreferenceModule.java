package com.unicom.wasalakclientproduct.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@InstallIn(ApplicationComponent.class)
@Module
public class AppPreferenceModule {

    @Provides
    @Singleton
    public SharedPreferences providePreference(@ApplicationContext Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
