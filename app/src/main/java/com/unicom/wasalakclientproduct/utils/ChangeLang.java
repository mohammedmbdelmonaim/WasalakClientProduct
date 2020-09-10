package com.unicom.wasalakclientproduct.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import androidx.preference.PreferenceManager;

import java.util.Locale;

public class ChangeLang {

    public static Context setNewLocale(Context mContext, String mLocaleKey) {
        saveLang(mContext , mLocaleKey);
        return updateResources(mContext, mLocaleKey);
    }

    public static Context setLocale(Context mContext) {
        String lang = getLang(mContext);
        return updateResources(mContext, lang);
    }

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return Build.VERSION.SDK_INT >= 24 ? config.getLocales().get(0) : config.locale;
    }

    public static boolean saveLang(Context mContext,String lang) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("language", lang);
        editor.apply();
        return true;
    }

    public static String getLang(Context mContext) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        return preferences.getString("language", "ar");
    }
}
