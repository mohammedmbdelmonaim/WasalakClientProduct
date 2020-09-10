package com.unicom.wasalakclientproduct.model.user;

public class LocationUser {
    String lat , lng , address;

    public LocationUser(String lat, String lng, String address) {
        this.lat = lat;
        this.lng = lng;
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
