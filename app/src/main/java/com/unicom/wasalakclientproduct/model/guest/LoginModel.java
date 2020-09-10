package com.unicom.wasalakclientproduct.model.guest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.unicom.wasalakclientproduct.model.ErrorNetwork;

public class LoginModel {
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
    private ErrorNetwork error;
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

    public class Result {

        @SerializedName("accessToken")
        @Expose
        private String accessToken;
        @SerializedName("encryptedAccessToken")
        @Expose
        private String encryptedAccessToken;
        @SerializedName("expireInSeconds")
        @Expose
        private Integer expireInSeconds;
        @SerializedName("userId")
        @Expose
        private Integer userId;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getEncryptedAccessToken() {
            return encryptedAccessToken;
        }

        public void setEncryptedAccessToken(String encryptedAccessToken) {
            this.encryptedAccessToken = encryptedAccessToken;
        }

        public Integer getExpireInSeconds() {
            return expireInSeconds;
        }

        public void setExpireInSeconds(Integer expireInSeconds) {
            this.expireInSeconds = expireInSeconds;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }


}
