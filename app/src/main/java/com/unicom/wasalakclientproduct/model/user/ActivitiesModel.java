package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ActivitiesModel {
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
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "InnerDatum{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerDatum that = (InnerDatum) o;
            return id.equals(that.id) &&
                    name.equals(that.name) &&
                    description.equals(that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, description);
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
