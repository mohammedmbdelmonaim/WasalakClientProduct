package com.unicom.wasalakclientproduct.ui.splash;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.unicom.wasalakclientproduct.MainApplication;
import com.unicom.wasalakclientproduct.R;

import com.unicom.wasalakclientproduct.databinding.ActivitySplashBinding;
import com.unicom.wasalakclientproduct.di.component.ApplicationComponent;
import com.unicom.wasalakclientproduct.di.component.SplashFragmentComponent;
import com.unicom.wasalakclientproduct.ui.BaseActivity;
import com.unicom.wasalakclientproduct.ui.slider.SliderActivity;
import com.unicom.wasalakclientproduct.ui.user.UserActivity;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    @Inject
    PreferenceUtils preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//         dagger
        ApplicationComponent applicationComponent = MainApplication.get(this).getApplicationComponent();
        SplashFragmentComponent splashFragmentComponent = applicationComponent.splashFragmentComponent();
        splashFragmentComponent.inject(this);


        Observable.timer(1 , TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                if (preference.getTokenUser().equalsIgnoreCase("")) {
                    startActivity(new Intent(SplashActivity.this, SliderActivity.class));
                }else {
                    if (getIntent().getExtras() != null){
                        Bundle bundle = new Bundle();
                        bundle.putInt("id" ,  getIntent().getExtras().getInt("id"));
                        startActivity(new Intent(SplashActivity.this, UserActivity.class).putExtras(bundle));
                    }else {
                        startActivity(new Intent(SplashActivity.this, UserActivity.class));
                    }
                }
                overridePendingTransition(R.anim.animate_slide_in_left,
                        R.anim.animate_slide_out_right);
                finish();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(SplashActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
