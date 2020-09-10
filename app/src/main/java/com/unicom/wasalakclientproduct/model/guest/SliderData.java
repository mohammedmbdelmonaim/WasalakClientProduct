package com.unicom.wasalakclientproduct.model.guest;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class SliderData {
    private int image;
    private String title;
    private String text;

    public SliderData(int image, String title, String text) {
        this.image = image;
        this.title = title;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @BindingAdapter("android:loadImageSlider")
    public static void loadImage(ImageView imageView, int imageDrawable) {
        Glide.with(imageView)
                .load(imageDrawable)
                .into(imageView);
    }
}
