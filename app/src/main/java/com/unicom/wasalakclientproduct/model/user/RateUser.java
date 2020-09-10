package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateUser {
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("note")
    @Expose
    private String note;

    public RateUser(Integer storeId, Integer rate, String note) {
        this.storeId = storeId;
        this.rate = rate;
        this.note = note;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
