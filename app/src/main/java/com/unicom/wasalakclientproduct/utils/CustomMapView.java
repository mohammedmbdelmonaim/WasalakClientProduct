package com.unicom.wasalakclientproduct.utils;//package com.unicom.waslak_client.utils;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.MotionEvent;
//
//
//public class CustomMapView extends MapView {
//    public CustomMapView(Context context) {
//        super(context);
//    }
//    public CustomMapView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public CustomMapView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }
//
//    public CustomMapView(Context context, GoogleMapOptions options) {
//        super(context, options);
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        /**
//         * Request all parents to relinquish the touch events
//         */
//        getParent().requestDisallowInterceptTouchEvent(true);
//        return super.dispatchTouchEvent(ev);
//    }
//}
