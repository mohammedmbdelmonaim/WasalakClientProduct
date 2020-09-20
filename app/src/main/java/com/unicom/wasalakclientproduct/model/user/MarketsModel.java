package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.unicom.wasalakclientproduct.model.ErrorNetwork;

import java.util.List;
import java.util.Objects;

public class MarketsModel {
    @SerializedName("result")
    @Expose
    private List<Result> result;
    @SerializedName("targetUrl")
    @Expose
    private Object targetUrl;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private ErrorNetwork error;
    @SerializedName("unAuthorizedRequest")
    @Expose
    private Boolean unAuthorizedRequest;
    @SerializedName("__abp")
    @Expose
    private Boolean abp;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ErrorNetwork getError() {
        return error;
    }

    public void setError(ErrorNetwork error) {
        this.error = error;
    }

    public Boolean getUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(Boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public Boolean getAbp() {
        return abp;
    }

    public void setAbp(Boolean abp) {
        this.abp = abp;
    }

    public static class Result {
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
            Result that = (Result) o;
            return id.equals(that.id) &&
                    name.equals(that.name) &&
                    description.equals(that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, description);
        }

        public static DiffUtil.ItemCallback<Result> itemCallback = new DiffUtil.ItemCallback<Result>() {
            @Override
            public boolean areItemsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
                return oldItem.equals(newItem);
            }
        };
    }
}
