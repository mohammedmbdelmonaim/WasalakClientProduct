package com.unicom.wasalakclientproduct.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.unicom.wasalakclientproduct.R;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class NetworkUtil {
    Context context;

    @Inject
    public NetworkUtil(@ApplicationContext Context context) {
        this.context = context;
    }

    public String getConnectivityStatusString() {
        String status = null;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {


            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {


            }
        } else {
            status = context.getString(R.string.internet_connection_error);
            return status;
        }
        return status;
    }
}