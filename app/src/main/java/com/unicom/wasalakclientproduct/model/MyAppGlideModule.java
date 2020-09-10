package com.unicom.wasalakclientproduct.model;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.Excludes;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.unicom.wasalakclientproduct.MainApplication;

import java.io.InputStream;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

@GlideModule
@Excludes(OkHttpLibraryGlideModule.class)
public final class MyAppGlideModule extends AppGlideModule {
    @Inject
    OkHttpClient okHttpClient;

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        MainApplication.get(context).getApplicationComponent().inject(this);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
    }
}