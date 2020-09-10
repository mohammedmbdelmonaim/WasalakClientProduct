package com.unicom.wasalakclientproduct.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityModel {
    @SerializedName("result")
    @Expose
    private List<Result> result = null;
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

    public static class Result implements Parcelable {

        @SerializedName("nameAr")
        @Expose
        private String nameAr;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("displayName")
        @Expose
        private String displayName;
        @SerializedName("descriptionAr")
        @Expose
        private String descriptionAr;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("displayDescription")
        @Expose
        private String displayDescription;
        @SerializedName("id")
        @Expose
        private Integer id;

        protected Result(Parcel in) {
            nameAr = in.readString();
            name = in.readString();
            displayName = in.readString();
            descriptionAr = in.readString();
            description = in.readString();
            displayDescription = in.readString();
            if (in.readByte() == 0) {
                id = null;
            } else {
                id = in.readInt();
            }
        }

        public static final Creator<Result> CREATOR = new Creator<Result>() {
            @Override
            public Result createFromParcel(Parcel in) {
                return new Result(in);
            }

            @Override
            public Result[] newArray(int size) {
                return new Result[size];
            }
        };

        public String getNameAr() {
            return nameAr;
        }

        public void setNameAr(String nameAr) {
            this.nameAr = nameAr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getDescriptionAr() {
            return descriptionAr;
        }

        public void setDescriptionAr(String descriptionAr) {
            this.descriptionAr = descriptionAr;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisplayDescription() {
            return displayDescription;
        }

        public void setDisplayDescription(String displayDescription) {
            this.displayDescription = displayDescription;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(nameAr);
            dest.writeString(name);
            dest.writeString(displayName);
            dest.writeString(descriptionAr);
            dest.writeString(description);
            dest.writeString(displayDescription);
            if (id == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(id);
            }
        }
    }
}
