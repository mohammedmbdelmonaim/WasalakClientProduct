package com.unicom.wasalakclientproduct.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorNetwork {
        @SerializedName("code")
        @Expose
        private Integer code;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("details")
        @Expose
        private Object details;
        @SerializedName("validationErrors")
        @Expose
        private Object validationErrors;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getDetails() {
            return details;
        }

        public void setDetails(Object details) {
            this.details = details;
        }

        public Object getValidationErrors() {
            return validationErrors;
        }

        public void setValidationErrors(Object validationErrors) {
            this.validationErrors = validationErrors;
        }
}
