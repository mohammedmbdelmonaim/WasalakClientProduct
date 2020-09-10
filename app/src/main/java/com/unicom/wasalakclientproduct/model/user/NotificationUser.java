package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationUser {
    @SerializedName("enableNotification")
    @Expose
    private boolean enableNotification;
    @SerializedName("notificationTokenId")
    @Expose
    private String notificationTokenId;

    public NotificationUser(boolean enableNotification, String notificationTokenId) {
        this.enableNotification = enableNotification;
        this.notificationTokenId = notificationTokenId;
    }
}
