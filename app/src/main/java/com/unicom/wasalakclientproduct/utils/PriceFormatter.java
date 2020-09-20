package com.unicom.wasalakclientproduct.utils;

import android.content.Context;

import java.text.DecimalFormat;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PriceFormatter {
    @Inject
    PreferenceUtils preference;
    @Inject
    public PriceFormatter() {
    }

    public  String toDecimalString(double price, Context context){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String priceString = df.getNumberInstance(Locale.US).format(price);
        return priceString;
    }
    public  String toDecimalString(double price){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        Locale locale = new Locale(preference.getLang());
        String priceString = df.getNumberInstance(locale).format(price);
        return priceString;
    }

}
