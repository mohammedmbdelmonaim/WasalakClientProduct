package com.unicom.wasalakclientproduct.ui;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.appcompat.app.AppCompatActivity;

import com.unicom.wasalakclientproduct.reciever.NetworkReceiver;
import com.unicom.wasalakclientproduct.utils.ChangeLang;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BaseActivity extends AppCompatActivity {
    @Inject
    NetworkReceiver networkreceiver;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ChangeLang.setLocale(newBase));
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
