package com.unicom.wasalakclientproduct.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrderUser {

    @SerializedName("destinationAddress")
    @Expose
    private String destinationAddress;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("activityId")
    @Expose
    private Integer activityId;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("destinationLatitude")
    @Expose
    private String destinationLatitude;
    @SerializedName("destinationLongitude")
    @Expose
    private String destinationLongitude;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("textOrder")
    @Expose
    private String textOrder;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("storeId")
    @Expose
    private Integer storeId;
    @SerializedName("vendorId")
    @Expose
    private Integer vendorId;
    @SerializedName("orderItems")
    @Expose
    private List<OrderItem> orderItems = null;

    public OrderUser(String destinationAddress, String notes, String destinationLatitude, String destinationLongitude, Double price, String textOrder, String storeName, Integer storeId, Integer vendorId, List<OrderItem> orderItems , String location , Integer activityId) {
        this.destinationAddress = destinationAddress;
        this.notes = notes;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
        this.price = price;
        this.textOrder = textOrder;
        this.storeName = storeName;
        this.storeId = storeId;
        this.vendorId = vendorId;
        this.orderItems = orderItems;
        this.location = location;
        this.activityId = activityId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public String getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTextOrder() {
        return textOrder;
    }

    public void setTextOrder(String textOrder) {
        this.textOrder = textOrder;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public static class OrderItem implements Parcelable {
        @SerializedName("productId")
        @Expose
        private Integer productId;
        @SerializedName("productName")
        @Expose
        private String productName;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;

        public OrderItem(Integer productId, String name, Double price, Integer quantity) {
            this.productId = productId;
            this.productName = name;
            this.price = price;
            this.quantity = quantity;
        }


        protected OrderItem(Parcel in) {
            if (in.readByte() == 0) {
                productId = null;
            } else {
                productId = in.readInt();
            }
            productName = in.readString();
            if (in.readByte() == 0) {
                price = null;
            } else {
                price = in.readDouble();
            }
            if (in.readByte() == 0) {
                quantity = null;
            } else {
                quantity = in.readInt();
            }
        }

        public static final Creator<OrderItem> CREATOR = new Creator<OrderItem>() {
            @Override
            public OrderItem createFromParcel(Parcel in) {
                return new OrderItem(in);
            }

            @Override
            public OrderItem[] newArray(int size) {
                return new OrderItem[size];
            }
        };

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (productId == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(productId);
            }
            dest.writeString(productName);
            if (price == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeDouble(price);
            }
            if (quantity == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(quantity);
            }
        }
    }
}
