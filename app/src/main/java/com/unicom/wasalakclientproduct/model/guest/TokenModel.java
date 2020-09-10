package com.unicom.wasalakclientproduct.model.guest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenModel {
    @Expose
    @SerializedName("refreshToken")
    private String refreshtoken;
    @Expose
    @SerializedName("token")
    private String token;

    public String getRefreshtoken() {
        return refreshtoken;
    }

    public void setRefreshtoken(String refreshtoken) {
        this.refreshtoken = refreshtoken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
