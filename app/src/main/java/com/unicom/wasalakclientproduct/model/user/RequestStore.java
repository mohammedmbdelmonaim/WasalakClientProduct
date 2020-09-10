package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestStore {
    @SerializedName("clientLat")
    @Expose
    private String lat ;
    @SerializedName("clientLong")
    @Expose
    private String lng;
    @SerializedName("activityId")
    @Expose
    private int activityId;

    public RequestStore(String lat, String lng, int activityId) {
        this.lat = lat;
        this.lng = lng;
        this.activityId = activityId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
