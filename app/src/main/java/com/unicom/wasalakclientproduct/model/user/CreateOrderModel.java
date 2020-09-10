package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateOrderModel {
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
        private String pickupAddressDetails;
        @SerializedName("pickupNeighborhoodId")
        @Expose
        private Integer pickupNeighborhoodId;
        @SerializedName("pickupName")
        @Expose
        private String pickupName;
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
        private String destinationAddressDetails;
        @SerializedName("destinationNeighborhoodId")
        @Expose
        private Integer destinationNeighborhoodId;
        @SerializedName("notes")
        @Expose
        private String notes;
        @SerializedName("destinationLatitude")
        @Expose
        private String destinationLatitude;
        @SerializedName("destinationLongitude")
        @Expose
        private String destinationLongitude;
        @SerializedName("pickupMobile")
        @Expose
        private String pickupMobile;
        @SerializedName("destinationMobile")
        @Expose
        private String destinationMobile;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("vendorId")
        @Expose
        private Integer vendorId;
        @SerializedName("numberOfTrials")
        @Expose
        private Integer numberOfTrials;
        @SerializedName("categoryId")
        @Expose
        private Integer categoryId;
        @SerializedName("pickupCityId")
        @Expose
        private Integer pickupCityId;
        @SerializedName("pickupGovernorateId")
        @Expose
        private Integer pickupGovernorateId;
        @SerializedName("destinationCityId")
        @Expose
        private Integer destinationCityId;
        @SerializedName("destinationGovernorateId")
        @Expose
        private Integer destinationGovernorateId;
        @SerializedName("destance")
        @Expose
        private Integer destance;
        @SerializedName("pickupTime")
        @Expose
        private String pickupTime;
        @SerializedName("deliveryTime")
        @Expose
        private String deliveryTime;
        @SerializedName("price")
        @Expose
        private Object price;
        @SerializedName("textOrder")
        @Expose
        private String textOrder;
        @SerializedName("courierUserId")
        @Expose
        private Integer courierUserId;
        @SerializedName("courierName")
        @Expose
        private String courierName;
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
        private Boolean hasSignature;
        @SerializedName("customerId")
        @Expose
        private Integer customerId;
        @SerializedName("storeId")
        @Expose
        private Integer storeId;
        @SerializedName("orderItems")
        @Expose
        private List<OrderItem> orderItems = null;

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

        public String getPickupAddressDetails() {
            return pickupAddressDetails;
        }

        public void setPickupAddressDetails(String pickupAddressDetails) {
            this.pickupAddressDetails = pickupAddressDetails;
        }

        public Integer getPickupNeighborhoodId() {
            return pickupNeighborhoodId;
        }

        public void setPickupNeighborhoodId(Integer pickupNeighborhoodId) {
            this.pickupNeighborhoodId = pickupNeighborhoodId;
        }

        public String getPickupName() {
            return pickupName;
        }

        public void setPickupName(String pickupName) {
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

        public String getDestinationAddressDetails() {
            return destinationAddressDetails;
        }

        public void setDestinationAddressDetails(String destinationAddressDetails) {
            this.destinationAddressDetails = destinationAddressDetails;
        }

        public Integer getDestinationNeighborhoodId() {
            return destinationNeighborhoodId;
        }

        public void setDestinationNeighborhoodId(Integer destinationNeighborhoodId) {
            this.destinationNeighborhoodId = destinationNeighborhoodId;
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

        public String getPickupMobile() {
            return pickupMobile;
        }

        public void setPickupMobile(String pickupMobile) {
            this.pickupMobile = pickupMobile;
        }

        public String getDestinationMobile() {
            return destinationMobile;
        }

        public void setDestinationMobile(String destinationMobile) {
            this.destinationMobile = destinationMobile;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
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

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public Integer getPickupCityId() {
            return pickupCityId;
        }

        public void setPickupCityId(Integer pickupCityId) {
            this.pickupCityId = pickupCityId;
        }

        public Integer getPickupGovernorateId() {
            return pickupGovernorateId;
        }

        public void setPickupGovernorateId(Integer pickupGovernorateId) {
            this.pickupGovernorateId = pickupGovernorateId;
        }

        public Integer getDestinationCityId() {
            return destinationCityId;
        }

        public void setDestinationCityId(Integer destinationCityId) {
            this.destinationCityId = destinationCityId;
        }

        public Integer getDestinationGovernorateId() {
            return destinationGovernorateId;
        }

        public void setDestinationGovernorateId(Integer destinationGovernorateId) {
            this.destinationGovernorateId = destinationGovernorateId;
        }

        public Integer getDestance() {
            return destance;
        }

        public void setDestance(Integer destance) {
            this.destance = destance;
        }

        public String getPickupTime() {
            return pickupTime;
        }

        public void setPickupTime(String pickupTime) {
            this.pickupTime = pickupTime;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public String getTextOrder() {
            return textOrder;
        }

        public void setTextOrder(String textOrder) {
            this.textOrder = textOrder;
        }

        public Integer getCourierUserId() {
            return courierUserId;
        }

        public void setCourierUserId(Integer courierUserId) {
            this.courierUserId = courierUserId;
        }

        public String getCourierName() {
            return courierName;
        }

        public void setCourierName(String courierName) {
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

        public Boolean getHasSignature() {
            return hasSignature;
        }

        public void setHasSignature(Boolean hasSignature) {
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

    public class OrderItem {

        @SerializedName("productId")
        @Expose
        private Integer productId;
        @SerializedName("orderId")
        @Expose
        private Integer orderId;
        @SerializedName("price")
        @Expose
        private Object price;
        @SerializedName("productName")
        @Expose
        private String productName;
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

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

    }
}
