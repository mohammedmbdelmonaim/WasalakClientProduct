package com.unicom.wasalakclientproduct.ui.guest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.unicom.wasalakclientproduct.databinding.ActivityGuestBinding;
import com.unicom.wasalakclientproduct.ui.BaseActivity;


public class GuestActivity extends BaseActivity {
    ActivityGuestBinding binding;

    private static final String TAG = "GuestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "mohammed onCreate: ");
        binding = ActivityGuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "mohammed onStart: ");
    }



    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "mohammed onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "mohammed onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "mohammed onStop: ");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "mohammed onDestroy: ");
    }


}
