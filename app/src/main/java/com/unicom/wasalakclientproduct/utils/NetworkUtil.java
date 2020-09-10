package com.unicom.wasalakclientproduct.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;

import javax.inject.Inject;


public class NetworkUtil {
    Context context;

    @Inject
    public NetworkUtil(@ActivityContext Context context) {
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