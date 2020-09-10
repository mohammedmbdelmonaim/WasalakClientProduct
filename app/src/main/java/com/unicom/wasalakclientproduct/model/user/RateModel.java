package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class RateModel {
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

        @SerializedName("rate")
        @Expose
        private Integer rate;
        @SerializedName("numberOfReviews")
        @Expose
        private Integer numberOfReviews;
        @SerializedName("customersRate")
        @Expose
        private List<CustomersRate> customersRate = null;

        public Integer getRate() {
            return rate;
        }

        public void setRate(Integer rate) {
            this.rate = rate;
        }

        public Integer getNumberOfReviews() {
            return numberOfReviews;
        }

        public void setNumberOfReviews(Integer numberOfReviews) {
            this.numberOfReviews = numberOfReviews;
        }

        public List<CustomersRate> getCustomersRate() {
            return customersRate;
        }

        public void setCustomersRate(List<CustomersRate> customersRate) {
            this.customersRate = customersRate;
        }

    }

    public static class CustomersRate {
        @SerializedName("customerId")
        @Expose
        private Integer customerId;
        @SerializedName("customerName")
        @Expose
        private String customerName;
        @SerializedName("rate")
        @Expose
        private Integer rate;
        @SerializedName("note")
        @Expose
        private String note;

        @SerializedName("dateAsText")
        @Expose
        private String date;

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CustomersRate that = (CustomersRate) o;
            return customerId.equals(that.customerId) &&
                    customerName.equals(that.customerName) &&
                    rate.equals(that.rate) &&
                    note.equals(that.note) &&
                    (date!= null &&date.equals(that.date));
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerId, customerName, rate, note, date);
        }

        public static DiffUtil.ItemCallback<CustomersRate> itemCallback = new DiffUtil.ItemCallback<CustomersRate>() {
            @Override
            public boolean areItemsTheSame(@NonNull CustomersRate oldItem, @NonNull CustomersRate newItem) {
                return oldItem.getCustomerId().equals(newItem.getCustomerId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull CustomersRate oldItem, @NonNull CustomersRate newItem) {
                return oldItem.equals(newItem);
            }
        };
    }
}
