package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class OrdersHistoryModel {
    @SerializedName("innerData")
    @Expose
    private List<InnerDatum> innerData = null;
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;

    public List<InnerDatum> getInnerData() {
        return innerData;
    }

    public void setInnerData(List<InnerDatum> innerData) {
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
    public static class InnerDatum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("storeName")
        @Expose
        private String storeName;
        @SerializedName("storeId")
        @Expose
        private String storeId;
        @SerializedName("referenceNo")
        @Expose
        private String referenceNo;
        @SerializedName("statusId")
        @Expose
        private Integer statusId;
        @SerializedName("statusName")
        @Expose
        private String statusName;
        @SerializedName("creationDate")
        @Expose
        private String creationDate;
        @SerializedName("vendorId")
        @Expose
        private Integer vendorId;
        @SerializedName("categoryId")
        @Expose
        private Integer categoryId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreId() {
            return storeId;
        }

        public void setStoreId(String storeId) {
            this.storeId = storeId;
        }

        public String getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
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

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public Integer getVendorId() {
            return vendorId;
        }

        public void setVendorId(Integer vendorId) {
            this.vendorId = vendorId;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerDatum that = (InnerDatum) o;
            return id.equals(that.id) &&
                    storeName.equals(that.storeName) &&
                    storeId.equals(that.storeId) &&
                    referenceNo.equals(that.referenceNo) &&
                    statusName.equals(that.statusName) &&
                    creationDate.equals(that.creationDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, storeName, storeId, referenceNo, statusName, creationDate);
        }

        public static DiffUtil.ItemCallback<InnerDatum> itemCallback = new DiffUtil.ItemCallback<InnerDatum>() {
            @Override
            public boolean areItemsTheSame(@NonNull InnerDatum oldItem, @NonNull InnerDatum newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull InnerDatum oldItem, @NonNull InnerDatum newItem) {
                return oldItem.equals(newItem);
            }
        };
    }
}
