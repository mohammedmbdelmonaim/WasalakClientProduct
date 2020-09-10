package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class OrderDetailModel {
    @SerializedName("innerData")
    @Expose
    private InnerData innerData;
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;

    public InnerData getInnerData() {
        return innerData;
    }

    public void setInnerData(InnerData innerData) {
        this.innerData = innerData;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class InnerData {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("referenceNo")
        @Expose
        private String referenceNo;
        @SerializedName("pickupAddress")
        @Expose
        private String pickupAddress;
        @SerializedName("pickupAddressDetails")
        @Expose
        private Object pickupAddressDetails;
        @SerializedName("pickupNeighborhoodId")
        @Expose
        private Object pickupNeighborhoodId;
        @SerializedName("pickupName")
        @Expose
        private Object pickupName;
        @SerializedName("pickupLatitude")
        @Expose
        private String pickupLatitude;
        @SerializedName("pickupLongitude")
        @Expose
        private String pickupLongitude;
        @SerializedName("destinationName")
        @Expose
        private String destinationName;
        @SerializedName("destinationAddress")
        @Expose
        private String destinationAddress;
        @SerializedName("destinationAddressDetails")
        @Expose
        private Object destinationAddressDetails;
        @SerializedName("destinationNeighborhoodId")
        @Expose
        private Object destinationNeighborhoodId;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("destinationLatitude")
        @Expose
        private Object destinationLatitude;
        @SerializedName("destinationLongitude")
        @Expose
        private Object destinationLongitude;
        @SerializedName("pickupMobile")
        @Expose
        private Object pickupMobile;
        @SerializedName("destinationMobile")
        @Expose
        private String destinationMobile;
        @SerializedName("description")
        @Expose
        private Object description;
        @SerializedName("vendorId")
        @Expose
        private Integer vendorId;
        @SerializedName("numberOfTrials")
        @Expose
        private Integer numberOfTrials;
        @SerializedName("categoryId")
        @Expose
        private Object categoryId;
        @SerializedName("activityId")
        @Expose
        private Integer activityId;
        @SerializedName("pickupCityId")
        @Expose
        private Object pickupCityId;
        @SerializedName("pickupGovernorateId")
        @Expose
        private Object pickupGovernorateId;
        @SerializedName("destinationCityId")
        @Expose
        private Object destinationCityId;
        @SerializedName("destinationGovernorateId")
        @Expose
        private Object destinationGovernorateId;
        @SerializedName("distance")
        @Expose
        private Object distance;
        @SerializedName("pickupTime")
        @Expose
        private Object pickupTime;
        @SerializedName("deliveryTime")
        @Expose
        private Object deliveryTime;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("textOrder")
        @Expose
        private String textOrder;
        @SerializedName("courierUserId")
        @Expose
        private Object courierUserId;
        @SerializedName("courierName")
        @Expose
        private Object courierName;
        @SerializedName("createdBy")
        @Expose
        private Integer createdBy;
        @SerializedName("orderSourceId")
        @Expose
        private Integer orderSourceId;
        @SerializedName("statusId")
        @Expose
        private Integer statusId;
        @SerializedName("statusName")
        @Expose
        private String statusName;
        @SerializedName("hasSignature")
        @Expose
        private Object hasSignature;
        @SerializedName("customerId")
        @Expose
        private Integer customerId;
        @SerializedName("storeId")
        @Expose
        private Integer storeId;
        @SerializedName("orderItems")
        @Expose
        private List<OrderItem> orderItems = null;

        public Integer getActivityId() {
            return activityId;
        }

        public void setActivityId(Integer activityId) {
            this.activityId = activityId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
        }

        public String getPickupAddress() {
            return pickupAddress;
        }

        public void setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
        }

        public Object getPickupAddressDetails() {
            return pickupAddressDetails;
        }

        public void setPickupAddressDetails(Object pickupAddressDetails) {
            this.pickupAddressDetails = pickupAddressDetails;
        }

        public Object getPickupNeighborhoodId() {
            return pickupNeighborhoodId;
        }

        public void setPickupNeighborhoodId(Object pickupNeighborhoodId) {
            this.pickupNeighborhoodId = pickupNeighborhoodId;
        }

        public Object getPickupName() {
            return pickupName;
        }

        public void setPickupName(Object pickupName) {
            this.pickupName = pickupName;
        }

        public String getPickupLatitude() {
            return pickupLatitude;
        }

        public void setPickupLatitude(String pickupLatitude) {
            this.pickupLatitude = pickupLatitude;
        }

        public String getPickupLongitude() {
            return pickupLongitude;
        }

        public void setPickupLongitude(String pickupLongitude) {
            this.pickupLongitude = pickupLongitude;
        }

        public String getDestinationName() {
            return destinationName;
        }

        public void setDestinationName(String destinationName) {
            this.destinationName = destinationName;
        }

        public String getDestinationAddress() {
            return destinationAddress;
        }

        public void setDestinationAddress(String destinationAddress) {
            this.destinationAddress = destinationAddress;
        }

        public Object getDestinationAddressDetails() {
            return destinationAddressDetails;
        }

        public void setDestinationAddressDetails(Object destinationAddressDetails) {
            this.destinationAddressDetails = destinationAddressDetails;
        }

        public Object getDestinationNeighborhoodId() {
            return destinationNeighborhoodId;
        }

        public void setDestinationNeighborhoodId(Object destinationNeighborhoodId) {
            this.destinationNeighborhoodId = destinationNeighborhoodId;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public Object getDestinationLatitude() {
            return destinationLatitude;
        }

        public void setDestinationLatitude(Object destinationLatitude) {
            this.destinationLatitude = destinationLatitude;
        }

        public Object getDestinationLongitude() {
            return destinationLongitude;
        }

        public void setDestinationLongitude(Object destinationLongitude) {
            this.destinationLongitude = destinationLongitude;
        }

        public Object getPickupMobile() {
            return pickupMobile;
        }

        public void setPickupMobile(Object pickupMobile) {
            this.pickupMobile = pickupMobile;
        }

        public String getDestinationMobile() {
            return destinationMobile;
        }

        public void setDestinationMobile(String destinationMobile) {
            this.destinationMobile = destinationMobile;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Integer getVendorId() {
            return vendorId;
        }

        public void setVendorId(Integer vendorId) {
            this.vendorId = vendorId;
        }

        public Integer getNumberOfTrials() {
            return numberOfTrials;
        }

        public void setNumberOfTrials(Integer numberOfTrials) {
            this.numberOfTrials = numberOfTrials;
        }

        public Object getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Object categoryId) {
            this.categoryId = categoryId;
        }

        public Object getPickupCityId() {
            return pickupCityId;
        }

        public void setPickupCityId(Object pickupCityId) {
            this.pickupCityId = pickupCityId;
        }

        public Object getPickupGovernorateId() {
            return pickupGovernorateId;
        }

        public void setPickupGovernorateId(Object pickupGovernorateId) {
            this.pickupGovernorateId = pickupGovernorateId;
        }

        public Object getDestinationCityId() {
            return destinationCityId;
        }

        public void setDestinationCityId(Object destinationCityId) {
            this.destinationCityId = destinationCityId;
        }

        public Object getDestinationGovernorateId() {
            return destinationGovernorateId;
        }

        public void setDestinationGovernorateId(Object destinationGovernorateId) {
            this.destinationGovernorateId = destinationGovernorateId;
        }

        public Object getDistance() {
            return distance;
        }

        public void setDistance(Object distance) {
            this.distance = distance;
        }

        public Object getPickupTime() {
            return pickupTime;
        }

        public void setPickupTime(Object pickupTime) {
            this.pickupTime = pickupTime;
        }

        public Object getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(Object deliveryTime) {
            this.deliveryTime = deliveryTime;
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

        public Object getCourierUserId() {
            return courierUserId;
        }

        public void setCourierUserId(Object courierUserId) {
            this.courierUserId = courierUserId;
        }

        public Object getCourierName() {
            return courierName;
        }

        public void setCourierName(Object courierName) {
            this.courierName = courierName;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public Integer getOrderSourceId() {
            return orderSourceId;
        }

        public void setOrderSourceId(Integer orderSourceId) {
            this.orderSourceId = orderSourceId;
        }

        public Integer getStatusId() {
            return statusId;
        }

        public void setStatusId(Integer statusId) {
            this.statusId = statusId;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }

        public Object getHasSignature() {
            return hasSignature;
        }

        public void setHasSignature(Object hasSignature) {
            this.hasSignature = hasSignature;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public Integer getStoreId() {
            return storeId;
        }

        public void setStoreId(Integer storeId) {
            this.storeId = storeId;
        }

        public List<OrderItem> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
        }

    }


    public static class OrderItem {

        @SerializedName("productId")
        @Expose
        private Integer productId;
        @SerializedName("orderId")
        @Expose
        private Integer orderId;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("productName")
        @Expose
        private Object productName;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Object getProductName() {
            return productName;
        }

        public void setProductName(Object productName) {
            this.productName = productName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderItem orderItem = (OrderItem) o;
            return productId.equals(orderItem.productId) &&
                    orderId.equals(orderItem.orderId) &&
                    price.equals(orderItem.price) &&
                    productName.equals(orderItem.productName) &&
                    quantity.equals(orderItem.quantity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productId, orderId, price, productName, quantity);
        }

        public static DiffUtil.ItemCallback<OrderItem> itemCallback = new DiffUtil.ItemCallback<OrderItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull OrderItem oldItem, @NonNull OrderItem newItem) {
                return oldItem.getProductId().equals(newItem.getProductId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull OrderItem oldItem, @NonNull OrderItem newItem) {
                return oldItem.equals(newItem);
            }
        };
    }
}
