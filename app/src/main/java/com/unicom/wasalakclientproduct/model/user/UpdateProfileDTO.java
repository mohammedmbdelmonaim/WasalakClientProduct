package com.unicom.wasalakclientproduct.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpdateProfileDTO {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courierVehicles")
    @Expose
    private String courierVehicles;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surName")
    @Expose
    private String surname;

    @SerializedName("userName")
    @Expose
    private String emailaddress;
    @SerializedName("firstName")
    @Expose
    private String firstname;
    @SerializedName("lastName")
    @Expose
    private String lastname;
    @SerializedName("countryId")
    @Expose
    private Integer countryid;
    @SerializedName("cityId")
    @Expose
    private Integer cityid;
    @SerializedName("phoneNumber")
    @Expose
    private String phonenumber;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("filesKey")
    @Expose
    private List<FilesKey> filesKey;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("RoleId")
    @Expose
    private Integer roleId;

    public UpdateProfileDTO(Integer id, String courierVehicles, String name, String surname, String emailaddress, String birthDate, String firstname, String lastname, Integer countryid, Integer cityid, String phonenumber, String gender, List<FilesKey> filesKey , Integer roleId) {
        this.id = id;
        this.courierVehicles = courierVehicles;
        this.name = name;
        this.surname = surname;
        this.filesKey = filesKey;
        this.emailaddress = emailaddress;
        this.birthDate = birthDate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.countryid = countryid;
        this.cityid = cityid;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourierVehicles() {
        return courierVehicles;
    }

    public void setCourierVehicles(String courierVehicles) {
        this.courierVehicles = courierVehicles;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<FilesKey> getFilesKey() {
        return filesKey;
    }

    public void setFilesKey(List<FilesKey> filesKey) {
        this.filesKey = filesKey;
    }


    public static class FilesKey {
        public FilesKey(String fileKey, String description, Integer attachmentTypesId) {
            this.fileKey = fileKey;
            this.description = description;
            this.attachmentTypesId = attachmentTypesId;
        }

        @SerializedName("fileKey")
        @Expose
        private String fileKey;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("attachmentTypesId")
        @Expose
        private Integer attachmentTypesId;

        public String getFileKey() {
            return fileKey;
        }

        public void setFileKey(String fileKey) {
            this.fileKey = fileKey;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getAttachmentTypesId() {
            return attachmentTypesId;
        }

        public void setAttachmentTypesId(Integer attachmentTypesId) {
            this.attachmentTypesId = attachmentTypesId;
        }
    }
}
