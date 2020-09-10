package com.unicom.wasalakclientproduct.utils;

import android.content.SharedPreferences;


import com.unicom.wasalakclientproduct.di.scope.ApplicationScope;

import javax.inject.Inject;

@ApplicationScope
public class PreferenceUtils {
    SharedPreferences preference;
    @Inject
    public PreferenceUtils(SharedPreferences preference) {
        this.preference = preference;
    }

    public boolean saveTokenDevice(String deviceToken) {
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("device_token", deviceToken);
        editor.apply();
        return true;
    }

    public String getTokenDevice() {
        return preference.getString("device_token", "");
    }


    public boolean saveTokenUser(String userToken) {
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("user_token", userToken);
        editor.apply();
        return true;
    }

    public String getTokenUser() {
        return preference.getString("user_token", "");
    }

    public boolean saveNotificationState(Boolean notificationState) {
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean("notification_state", notificationState);
        editor.apply();
        return true;
    }

    public Boolean getNotification() {
        return preference.getBoolean("notification_state", true);
    }

    public String getLang() {
        return preference.getString("language", "ar");
    }

}
