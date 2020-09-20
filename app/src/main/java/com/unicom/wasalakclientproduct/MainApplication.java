package com.unicom.wasalakclientproduct;

import android.app.Application;
import android.content.Context;

import com.unicom.wasalakclientproduct.utils.ChangeLang;

import dagger.hilt.android.HiltAndroidApp;


@HiltAndroidApp
public class MainApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ChangeLang.setLocale(base));
    }
}