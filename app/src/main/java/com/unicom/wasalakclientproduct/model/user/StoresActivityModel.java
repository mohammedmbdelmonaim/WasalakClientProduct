package com.unicom.wasalakclientproduct.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class StoresActivityModel {
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

    public static class InnerDatum implements Parcelable{

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("vendorId")
        @Expose
        private Integer vendorId;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("commercialLicenseNumber")
        @Expose
        private Object commercialLicenseNumber;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("referenceNo")
        @Expose
        private Object referenceNo;
        @SerializedName("storesOpeningTimes")
        @Expose
        private List<StoresOpeningTime> storesOpeningTimes = null;
        @SerializedName("rate")
        @Expose
        private Integer rate;
        @SerializedName("numberOfReviews")
        @Expose
        private Integer numberOfReviews;
        @SerializedName("isOpen")
        @Expose
        private Boolean isOpen;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("latitude")
        @Expose
        private Object latitude;
        @SerializedName("longitude")
        @Expose
        private Object longitude;
        @SerializedName("distance")
        @Expose
        private String distance;

        protected InnerDatum(Parcel in) {
            if (in.readByte() == 0) {
                id = null;
            } else {
                id = in.readInt();
            }
            name = in.readString();
            description = in.readString();
            if (in.readByte() == 0) {
                vendorId = null;
            } else {
                vendorId = in.readInt();
            }
            email = in.readString();
            mobile = in.readString();
            if (in.readByte() == 0) {
                rate = null;
            } else {
                rate = in.readInt();
            }
            if (in.readByte() == 0) {
                numberOfReviews = null;
            } else {
                numberOfReviews = in.readInt();
            }
            byte tmpIsOpen = in.readByte();
            isOpen = tmpIsOpen == 0 ? null : tmpIsOpen == 1;
            location = in.readString();
            distance = in.readString();
        }

        public static final Creator<InnerDatum> CREATOR = new Creator<InnerDatum>() {
            @Override
            public InnerDatum createFromParcel(Parcel in) {
                return new InnerDatum(in);
            }

            @Override
            public InnerDatum[] newArray(int size) {
                return new InnerDatum[size];
            }
        };

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

        public Integer getVendorId() {
            return vendorId;
        }

        public void setVendorId(Integer vendorId) {
            this.vendorId = vendorId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getCommercialLicenseNumber() {
            return commercialLicenseNumber;
        }

        public void setCommercialLicenseNumber(Object commercialLicenseNumber) {
            this.commercialLicenseNumber = commercialLicenseNumber;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(Object referenceNo) {
            this.referenceNo = referenceNo;
        }

        public List<StoresOpeningTime> getStoresOpeningTimes() {
            return storesOpeningTimes;
        }

        public void setStoresOpeningTimes(List<StoresOpeningTime> storesOpeningTimes) {
            this.storesOpeningTimes = storesOpeningTimes;
        }

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

        public Boolean getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(Boolean isOpen) {
            this.isOpen = isOpen;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
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
            return Objects.hash(id, name, description, vendorId, email, commercialLicenseNumber, mobile, referenceNo, storesOpeningTimes, rate, numberOfReviews, isOpen);
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            if (id == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(id);
            }
            dest.writeString(name);
            dest.writeString(description);
            if (vendorId == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(vendorId);
            }
            dest.writeString(email);
            dest.writeString(mobile);
            if (rate == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(rate);
            }
            if (numberOfReviews == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(numberOfReviews);
            }
            dest.writeByte((byte) (isOpen == null ? 0 : isOpen ? 1 : 2));
            dest.writeString(location);
            dest.writeString(distance);
        }
    }


    public static class StoresOpeningTime {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("openingTime")
        @Expose
        private String openingTime;
        @SerializedName("closingTime")
        @Expose
        private String closingTime;
        @SerializedName("days")
        @Expose
        private Integer days;
        @SerializedName("dayAsText")
        @Expose
        private String dayAsText;
        @SerializedName("storeId")
        @Expose
        private Integer storeId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getOpeningTime() {
            return openingTime;
        }

        public void setOpeningTime(String openingTime) {
            this.openingTime = openingTime;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public void setClosingTime(String closingTime) {
            this.closingTime = closingTime;
        }

        public Integer getDays() {
            return days;
        }

        public void setDays(Integer days) {
            this.days = days;
        }

        public String getDayAsText() {
            return dayAsText;
        }

        public void setDayAsText(String dayAsText) {
            this.dayAsText = dayAsText;
        }

        public Integer getStoreId() {
            return storeId;
        }

        public void setStoreId(Integer storeId) {
            this.storeId = storeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StoresOpeningTime that = (StoresOpeningTime) o;
            return id.equals(that.id) &&
                    openingTime.equals(that.openingTime) &&
                    closingTime.equals(that.closingTime) &&
                    dayAsText.equals(that.dayAsText);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, openingTime, closingTime, dayAsText);
        }

        public static DiffUtil.ItemCallback<StoresOpeningTime> openingTimeItemCallback = new DiffUtil.ItemCallback<StoresOpeningTime>() {
            @Override
            public boolean areItemsTheSame(@NonNull StoresOpeningTime oldItem, @NonNull StoresOpeningTime newItem) {
                return oldItem.getId().equals(newItem.getId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull StoresOpeningTime oldItem, @NonNull StoresOpeningTime newItem) {
                return oldItem.equals(newItem);
            }
        };

    }
}
