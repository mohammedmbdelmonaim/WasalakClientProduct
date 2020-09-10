package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryModel;

import java.util.List;

public class UpdateProfileModel {
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("targetUrl")
    @Expose
    private Object targetUrl;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private Object error;
    @SerializedName("unAuthorizedRequest")
    @Expose
    private Boolean unAuthorizedRequest;
    @SerializedName("__abp")
    @Expose
    private Boolean abp;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
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

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
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

    public class Result {

        @SerializedName("userName")
        @Expose
        private String userName;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("surname")
        @Expose
        private String surname;
        @SerializedName("emailAddress")
        @Expose
        private String emailAddress;
        @SerializedName("isActive")
        @Expose
        private Boolean isActive;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("lastLoginTime")
        @Expose
        private Object lastLoginTime;
        @SerializedName("creationTime")
        @Expose
        private String creationTime;
        @SerializedName("roleNames")
        @Expose
        private List<String> roleNames = null;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("secondName")
        @Expose
        private Object secondName;
        @SerializedName("thirdName")
        @Expose
        private Object thirdName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("age")
        @Expose
        private Object age;
        @SerializedName("nationalityId")
        @Expose
        private Object nationalityId;
        @SerializedName("nationalId")
        @Expose
        private Object nationalId;
        @SerializedName("qualification")
        @Expose
        private Object qualification;
        @SerializedName("currentJob")
        @Expose
        private Object currentJob;
        @SerializedName("address")
        @Expose
        private Object address;
//        @SerializedName("countryId")
//        @Expose
//        private Integer countryId;
//        @SerializedName("cityId")
//        @Expose
//        private Integer cityId;

        @SerializedName("country")
        @Expose
        private CountryModel.Result country;
        @SerializedName("city")
        @Expose
        private CityModel.Result city;
        @SerializedName("birthDate")
        @Expose
        private String birthDate;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("userImage")
        @Expose
        private String userImage;
        @SerializedName("phoneNumber")
        @Expose
        private String phoneNumber;
        @SerializedName("isAlwaysOpen")
        @Expose
        private Boolean isAlwaysOpen;
        @SerializedName("courierAttachments")
        @Expose
        private List<Object> courierAttachments = null;
        @SerializedName("courierVehicles")
        @Expose
        private Object courierVehicles;
        @SerializedName("workingHours")
        @Expose
        private List<Object> workingHours = null;
        @SerializedName("filesKey")
        @Expose
        private Object filesKey;
        @SerializedName("attachmentIds")
        @Expose
        private Object attachmentIds;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Object getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(Object lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        public List<String> getRoleNames() {
            return roleNames;
        }

        public void setRoleNames(List<String> roleNames) {
            this.roleNames = roleNames;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public Object getSecondName() {
            return secondName;
        }

        public void setSecondName(Object secondName) {
            this.secondName = secondName;
        }

        public Object getThirdName() {
            return thirdName;
        }

        public void setThirdName(Object thirdName) {
            this.thirdName = thirdName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getNationalityId() {
            return nationalityId;
        }

        public void setNationalityId(Object nationalityId) {
            this.nationalityId = nationalityId;
        }

        public Object getNationalId() {
            return nationalId;
        }

        public void setNationalId(Object nationalId) {
            this.nationalId = nationalId;
        }

        public Object getQualification() {
            return qualification;
        }

        public void setQualification(Object qualification) {
            this.qualification = qualification;
        }

        public Object getCurrentJob() {
            return currentJob;
        }

        public void setCurrentJob(Object currentJob) {
            this.currentJob = currentJob;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

//        public Integer getCountryId() {
//            return countryId;
//        }
//
//        public void setCountryId(Integer countryId) {
//            this.countryId = countryId;
//        }
//
//        public Integer getCityId() {
//            return cityId;
//        }
//
//        public void setCityId(Integer cityId) {
//            this.cityId = cityId;
//        }


        public CountryModel.Result getCountry() {
            return country;
        }

        public void setCountry(CountryModel.Result country) {
            this.country = country;
        }

        public CityModel.Result getCity() {
            return city;
        }

        public void setCity(CityModel.Result city) {
            this.city = city;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Boolean getIsAlwaysOpen() {
            return isAlwaysOpen;
        }

        public void setIsAlwaysOpen(Boolean isAlwaysOpen) {
            this.isAlwaysOpen = isAlwaysOpen;
        }

        public List<Object> getCourierAttachments() {
            return courierAttachments;
        }

        public void setCourierAttachments(List<Object> courierAttachments) {
            this.courierAttachments = courierAttachments;
        }

        public Object getCourierVehicles() {
            return courierVehicles;
        }

        public void setCourierVehicles(Object courierVehicles) {
            this.courierVehicles = courierVehicles;
        }

        public List<Object> getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(List<Object> workingHours) {
            this.workingHours = workingHours;
        }

        public Object getFilesKey() {
            return filesKey;
        }

        public void setFilesKey(Object filesKey) {
            this.filesKey = filesKey;
        }

        public Object getAttachmentIds() {
            return attachmentIds;
        }

        public void setAttachmentIds(Object attachmentIds) {
            this.attachmentIds = attachmentIds;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
}
