package com.unicom.wasalakclientproduct.utils.cluster;//package com.unicom.waslak_client.utils.cluster;
//
//
//import android.content.Context;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.maps.android.clustering.ClusterManager;
//import com.google.maps.android.clustering.view.DefaultClusterRenderer;
//import com.google.maps.android.ui.IconGenerator;
//
//public class CustomClusterRenderer extends DefaultClusterRenderer<MyClusterItem> {
//
//    private final IconGenerator mClusterIconGenerator;
//    private final Context mContext;
//
//    public CustomClusterRenderer(Context context, GoogleMap map, ClusterManager<MyClusterItem> clusterManager) {
//        super(context, map, clusterManager);
//        //
//        mContext = context;
//        mClusterIconGenerator = new IconGenerator(mContext);
//    }
//
//    @Override
//    protected void onBeforeClusterItemRendered(MyClusterItem item, MarkerOptions markerOptions) {
//        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(mClusterIconGenerator.makeIcon(item.getPrice()))).
//                    anchor(mClusterIconGenerator.getAnchorU(), mClusterIconGenerator.getAnchorV());
////        /// 根據條件設置每個標記的外觀
////        if (item.getType() == 1) {
////            BitmapDescriptor markerDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_black);
////            markerOptions.icon(markerDescriptor).snippet(item.getTitle());
////        } else {
////            BitmapDescriptor markerDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_blue);
////            markerOptions.icon(markerDescriptor).snippet(item.getTitle());
////        }
//    }
////    @Override
////    protected void onClusterItemRendered(final MyClusterItem clusterItem, final Marker marker) {
////        super.onClusterItemRendered(clusterItem, marker);
////
////    }
////    @Override
////    protected void onBeforeClusterRendered(Cluster<MyClusterItem> cluster, MarkerOptions markerOptions) {
////        /// 根據條件設置每個聚集的外觀
//////        if (cluster.getSize() > 6) {
//////            mClusterIconGenerator.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_cluster_circle));
//////        } else {
//////            mClusterIconGenerator.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_cluster_circle2));
//////        }
//////        // 如果使用setColor會使用內建的Cluster外觀，加上背景顏色，設定的Background會無效
////////        mClusterIconGenerator.setColor(Color.BLUE);
//////        // 設定文字的Style
////////        mClusterIconGenerator.setTextAppearance(R.style.AppTheme_WhiteTextAppearance);
//////        // 建立Icon
//////        String clusterTitle = String.valueOf(cluster.getSize());
//////        Bitmap icon = mClusterIconGenerator.makeIcon(clusterTitle);
//////        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
////    }
//
//}