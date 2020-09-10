package com.unicom.wasalakclientproduct.model.guest;

import android.util.Log;
import android.util.Patterns;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.regex.Pattern;

public class RegisterUser {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surName")
    @Expose
    private String surname;
    @SerializedName("emailaddress")
    @Expose
    private String username;
    @SerializedName("userName")
    @Expose
    private String emailaddress;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("passwordConfirm")
    @Expose
    private String passwordConfirm;
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
    @SerializedName("RoleId")
    @Expose
    private Integer roleId;

    public RegisterUser(String name, String surname, String emailaddress,String username, String password, String passwordConfirm, String firstname, String lastname, Integer countryid, Integer cityid, String phonenumber ,Integer roleId) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.emailaddress = emailaddress;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.firstname = firstname;
        this.lastname = lastname;
        this.countryid = countryid;
        this.cityid = cityid;
        this.phonenumber = phonenumber;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmailaddress()).matches();
    }


    public boolean isPasswordValid() {
        return getPassword().length() < 8 || getPassword().length() > 25;
    }

    public boolean isMobileValid() {
        return getPhonenumber().length() == 10;
    }

    public boolean isPasswordMatch(){
        return getPassword().equals(getPasswordConfirm());
    }

    String regex = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)" +
            "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";
    public boolean isPasswordValid2(){
        return Pattern.compile(regex).matcher(getPassword()).matches();
    }
}
