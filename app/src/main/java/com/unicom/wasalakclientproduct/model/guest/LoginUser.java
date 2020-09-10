package com.unicom.wasalakclientproduct.model.guest;

import android.util.Patterns;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginUser {
    @SerializedName("userNameOrEmailAddress")
    @Expose
    private String userNameOrEmailAddress;
    @SerializedName("password")
    @Expose
    private String password;

    public LoginUser(String userNameOrEmailAddress, String password) {
        this.userNameOrEmailAddress = userNameOrEmailAddress;
        this.password = password;
    }

    public String getUserNameOrEmailAddress() {
        return userNameOrEmailAddress;
    }

    public void setUserNameOrEmailAddress(String userNameOrEmailAddress) {
        this.userNameOrEmailAddress = userNameOrEmailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getUserNameOrEmailAddress()).matches();
    }

    public boolean isPasswordValid() {
        return getPassword().length() < 8 || getPassword().length() > 20;
    }
}
