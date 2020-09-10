package com.unicom.wasalakclientproduct.model.user;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ProductsStoreModel {

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
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("shortDescription")
        @Expose
        private String shortDescription;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("sellingPrice")
        @Expose
        private Double sellingPrice;
        @SerializedName("purchasingPrice")
        @Expose
        private Double purchasingPrice;
        @SerializedName("priceAfterDiscount")
        @Expose
        private Double priceAfterDiscount;
        @SerializedName("discount")
        @Expose
        private Integer discount;
        @SerializedName("departmentId")
        @Expose
        private Integer departmentId;
        @SerializedName("expirationDate")
        @Expose
        private String expirationDate;
        @SerializedName("manufacturerId")
        @Expose
        private Integer manufacturerId;
        @SerializedName("wieght")
        @Expose
        private Integer wieght;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("tags")
        @Expose
        private String tags;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("storeId")
        @Expose
        private Integer storeId;
        @SerializedName("productCategories")
        @Expose
        private List<ProductCategory> productCategories = null;
        @SerializedName("attachemntsURL")
        @Expose
        private List<String> attachemntsURL = null;

        private int quantityOrder;

        public int getQuantityOrder() {
            return quantityOrder;
        }

        public void setQuantityOrder(int quantityOrder) {
            this.quantityOrder = quantityOrder;
        }

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

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getSellingPrice() {
            return sellingPrice;
        }

        public void setSellingPrice(Double sellingPrice) {
            this.sellingPrice = sellingPrice;
        }

        public Double getPurchasingPrice() {
            return purchasingPrice;
        }

        public void setPurchasingPrice(Double purchasingPrice) {
            this.purchasingPrice = purchasingPrice;
        }

        public Integer getDiscount() {
            return discount;
        }

        public void setDiscount(Integer discount) {
            this.discount = discount;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }

        public Integer getManufacturerId() {
            return manufacturerId;
        }

        public void setManufacturerId(Integer manufacturerId) {
            this.manufacturerId = manufacturerId;
        }

        public Integer getWieght() {
            return wieght;
        }

        public void setWieght(Integer wieght) {
            this.wieght = wieght;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getStoreId() {
            return storeId;
        }

        public void setStoreId(Integer storeId) {
            this.storeId = storeId;
        }

        public List<ProductCategory> getProductCategories() {
            return productCategories;
        }

        public void setProductCategories(List<ProductCategory> productCategories) {
            this.productCategories = productCategories;
        }

        public List<String> getAttachemntsURL() {
            return attachemntsURL;
        }

        public void setAttachemntsURL(List<String> filesKey) {
            this.attachemntsURL = filesKey;
        }

        public Double getPriceAfterDiscount() {
            return priceAfterDiscount;
        }

        public void setPriceAfterDiscount(Double priceAfterDiscount) {
            this.priceAfterDiscount = priceAfterDiscount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InnerDatum that = (InnerDatum) o;
            return id.equals(that.id) &&
                    name.equals(that.name) &&
                    shortDescription.equals(that.shortDescription) &&
                    description.equals(that.description) &&
                    sellingPrice.equals(that.sellingPrice) &&
                    purchasingPrice.equals(that.purchasingPrice) &&
                    priceAfterDiscount.equals(that.priceAfterDiscount) &&
                    attachemntsURL.equals(that.attachemntsURL) &&
                    discount.equals(that.discount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, shortDescription, description, sellingPrice, purchasingPrice,priceAfterDiscount, discount, departmentId, expirationDate, manufacturerId, wieght, color, tags, quantity, storeId, productCategories, attachemntsURL);
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

        @BindingAdapter("android:loadImageProduct")
        public static void loadImage(ImageView imageView, String image) {
            if (image.equals("")){
                return;
            }
            Glide.with(imageView)
                    .load(image)
                    .into(imageView);
        }

    }

    public class ProductCategory {

        @SerializedName("productId")
        @Expose
        private Integer productId;
        @SerializedName("categoryId")
        @Expose
        private Integer categoryId;

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }
    }
}
