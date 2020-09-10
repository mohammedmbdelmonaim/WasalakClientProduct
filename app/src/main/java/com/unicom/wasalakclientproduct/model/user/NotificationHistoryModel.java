package com.unicom.wasalakclientproduct.model.user;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class NotificationHistoryModel {
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

        @SerializedName("creationDateAsText")
        @Expose
        private String creationDateAsText;
        @SerializedName("notificationId")
        @Expose
        private Integer notificationId;
        @SerializedName("senderUserId")
        @Expose
        private String senderUserId;
        @SerializedName("priorityId")
        @Expose
        private Integer priorityId;
        @SerializedName("isSent")
        @Expose
        private Integer isSent;
        @SerializedName("receiverUserId")
        @Expose
        private Integer receiverUserId;
        @SerializedName("isSeen")
        @Expose
        private Integer isSeen;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("typeId")
        @Expose
        private Integer typeId;
        @SerializedName("recordId")
        @Expose
        private Integer recordId;

        public String getCreationDateAsText() {
            return creationDateAsText;
        }

        public void setCreationDateAsText(String creationDateAsText) {
            this.creationDateAsText = creationDateAsText;
        }

        public Integer getNotificationId() {
            return notificationId;
        }

        public void setNotificationId(Integer notificationId) {
            this.notificationId = notificationId;
        }

        public String getSenderUserId() {
            return senderUserId;
        }

        public void setSenderUserId(String senderUserId) {
            this.senderUserId = senderUserId;
        }

        public Integer getPriorityId() {
            return priorityId;
        }

        public void setPriorityId(Integer priorityId) {
            this.priorityId = priorityId;
        }

        public Integer getIsSent() {
            return isSent;
        }

        public void setIsSent(Integer isSent) {
            this.isSent = isSent;
        }

        public Integer getReceiverUserId() {
            return receiverUserId;
        }

        public void setReceiverUserId(Integer receiverUserId) {
            this.receiverUserId = receiverUserId;
        }

        public Integer getIsSeen() {
            return isSeen;
        }

        public void setIsSeen(Integer isSeen) {
            this.isSeen = isSeen;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public Integer getRecordId() {
            return recordId;
        }

        public void setRecordId(Integer recordId) {
            this.recordId = recordId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerDatum that = (InnerDatum) o;
            return creationDateAsText.equals(that.creationDateAsText) &&
                    notificationId.equals(that.notificationId) &&
                    isSeen.equals(that.isSeen) &&
                    title.equals(that.title) &&
                    body.equals(that.body);
        }

        @Override
        public int hashCode() {
            return Objects.hash(creationDateAsText, notificationId, isSeen, title, body);
        }

        public static DiffUtil.ItemCallback<InnerDatum> itemCallback = new DiffUtil.ItemCallback<InnerDatum>() {
            @Override
            public boolean areItemsTheSame(@NonNull InnerDatum oldItem, @NonNull InnerDatum newItem) {
                return oldItem.getNotificationId().equals(newItem.getNotificationId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull InnerDatum oldItem, @NonNull InnerDatum newItem) {
                return oldItem.equals(newItem);
            }
        };
    }
}
