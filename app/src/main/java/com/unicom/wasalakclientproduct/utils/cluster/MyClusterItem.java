package com.unicom.wasalakclientproduct.utils.cluster;//package com.unicom.waslak_client.utils.cluster;
//
//
//
//public class MyClusterItem implements ClusterItem {
//
//    private SearchListResponseModel.Datum data;
//    private Double price;
//    private String price_convert;
//    private  String position;
//    private LatLng location;
//
//    public MyClusterItem(String  pos , SearchListResponseModel.Datum data ,LatLng location) {
//        this.position = pos;
//        this.data = data;
//        this.location = location;
//    }
//
//    @Override
//    public LatLng getPosition() {
//        return location;
//    }
//
//    @Override
//    public String getTitle() {
//        return position;
//    }
//
//    @Override
//    public String getSnippet() {
//        return null;
//    }
//
//
//    public String getPrice(){
//        if (data.getDiscountPercentage() == null || data.getDiscountPercentage() == 0) {
//            price = Double.valueOf(String.valueOf(data.getMinPrice()));
//            price_convert = PriceFormatter.toDecimalString(price);
//        } else {
//            price = Double.valueOf(String.valueOf(data.getMinPrice()));
//            price_convert = PriceFormatter.toDecimalString((price * data.getDiscountPercentage()));
//        }
//        return price_convert + " " + data.getCurrency();
//    }
//
//}
