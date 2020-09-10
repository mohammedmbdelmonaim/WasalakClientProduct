package com.unicom.wasalakclientproduct.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.BaseActivityComponent;
import com.unicom.wasalakclientproduct.reciever.NetworkReceiver;
import com.unicom.wasalakclientproduct.utils.ChangeLang;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {
    @Inject
    NetworkReceiver networkreceiver;

    BaseActivityComponent baseActivityComponent;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ChangeLang.setLocale(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationComponent applicationComponent = MainApplication.get(this).getApplicationComponent();
        baseActivityComponent = applicationComponent.baseActivityComponent().getContext(this).build();
        baseActivityComponent.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(networkreceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(networkreceiver);
    }
}
