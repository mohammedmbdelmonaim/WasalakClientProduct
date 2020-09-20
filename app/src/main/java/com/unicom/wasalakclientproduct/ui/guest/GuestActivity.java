package com.unicom.wasalakclientproduct.ui.guest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.unicom.wasalakclientproduct.databinding.ActivityGuestBinding;
import com.unicom.wasalakclientproduct.ui.BaseActivity;


public class GuestActivity extends BaseActivity {
    ActivityGuestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
