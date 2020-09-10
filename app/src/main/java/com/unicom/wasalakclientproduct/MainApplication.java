package com.unicom.wasalakclientproduct;

import android.app.Application;
import android.content.Context;

import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.DaggerApplicationComponent;
import com.unicom.wasalakclientproduct.utils.ChangeLang;


public class MainApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ChangeLang.setLocale(base));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().getContext(this).build();
    }

    public static MainApplication get(Context context){
        return (MainApplication) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}