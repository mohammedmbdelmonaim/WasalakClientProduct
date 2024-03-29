package com.unicom.wasalakclientproduct.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;

import javax.inject.Inject;

public class KeyboardUtils {
    Context context;

    @Inject
    public KeyboardUtils( @ActivityContext Context context) {
        this.context = context;
    }

    public void hideKeyboard() {
        View view = ((Activity)context).findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}
