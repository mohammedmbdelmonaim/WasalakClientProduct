package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.regex.Pattern;

public class ChangePassUser {
    @SerializedName("currentPassword")
    @Expose
    private String oldPassword;
    @SerializedName("newPassword")
    @Expose
    private String newPassword;
    @SerializedName("newPasswordConfirm")
    @Expose
    private String newPasswordConfirm;

    public ChangePassUser(String oldPassword, String newPassword , String newPasswordConfirm) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPasswordConfirm = newPasswordConfirm;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirm() {
        return newPasswordConfirm;
    }

    public void setNewPasswordConfirm(String newPasswordConfirm) {
        this.newPasswordConfirm = newPasswordConfirm;
    }

    public boolean isPasswordValid() {
        return getNewPassword().length() < 6 || getNewPassword().length() > 20;
    }

    public boolean isPasswordMatch(){
        return getNewPassword().equals(getNewPasswordConfirm());
    }

    String regex = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)" +
            "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";
    public boolean isPasswordValid2(){
        return Pattern.compile(regex).matcher(getNewPassword()).matches();
    }
}
