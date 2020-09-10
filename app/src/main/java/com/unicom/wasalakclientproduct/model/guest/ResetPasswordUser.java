package com.unicom.wasalakclientproduct.model.guest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResetPasswordUser {
    @SerializedName("adminPassword")
    @Expose
    private String adminPassword;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("newPassword")
    @Expose
    private String newPassword;

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
