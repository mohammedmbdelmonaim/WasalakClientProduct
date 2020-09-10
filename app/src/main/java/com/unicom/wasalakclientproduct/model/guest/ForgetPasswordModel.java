package com.unicom.wasalakclientproduct.model.guest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.unicom.wasalakclientproduct.model.ErrorNetwork;

public class ForgetPasswordModel {

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

        @SerializedName("passwordResetCode")
        @Expose
        private String passwordResetCode;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getPasswordResetCode() {
            return passwordResetCode;
        }

        public void setPasswordResetCode(String passwordResetCode) {
            this.passwordResetCode = passwordResetCode;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
}
