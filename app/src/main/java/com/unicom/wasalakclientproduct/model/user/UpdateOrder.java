package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateOrder {
    @SerializedName("orderId")
    @Expose
    private Integer orderId;
    @SerializedName("newStatus")
    @Expose
    private Integer newStatus;

    public UpdateOrder(Integer orderId, Integer newStatus) {
        this.orderId = orderId;
        this.newStatus = newStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }
}
