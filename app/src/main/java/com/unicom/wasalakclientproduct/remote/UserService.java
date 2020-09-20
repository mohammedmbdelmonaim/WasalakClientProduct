package com.unicom.wasalakclientproduct.remote;

import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.StructueMode;
import com.unicom.wasalakclientproduct.model.user.AccountModel;
import com.unicom.wasalakclientproduct.model.user.ChangePassUser;
import com.unicom.wasalakclientproduct.model.user.LanguageClass;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileModel;
import com.unicom.wasalakclientproduct.model.user.UploadImageModel;

import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserService {
//    @GET("api/Activity/GetAllActivitys")
//    Observable<ActivitiesModel> requestActivities(@Header("Authorization") String token);
//
//    @POST("api/Store/GetActivityStores")
//    Observable<StoresActivityModel> storesActivity(@Header("Authorization") String token, @Body RequestStore requestStore);
//
//    @GET("api/Product/GetVendorProductsForCustomer")
//    Single<ProductsStoreModel> productsStore(@Header("Authorization") String token, @Query("vendorId") int id);
//
//    @POST("api/Order/CreateOrder")
//    Observable<CreateOrderModel> createOrder(@Header("Authorization") String token, @Body OrderUser orderUser);
//
//    @GET("api/Order/GetClientOrders")
//    Observable<OrdersHistoryModel> ordersHistory(@Header("Authorization") String token);
//
//    @GET("api/Notification/GetCustomerNotifications")
//    Observable<NotificationHistoryModel> notificationsHistory(@Header("Authorization") String token);
//
    @POST("services/app/User/ViewProfileForEdit")
    Single<AccountModel> account(@Header("Authorization") String token);

    @GET("services/app/Country/GetAllForDropDownList")
    Single<CountryModel> countriesRequest();

    @GET("services/app/City/GetAllForDropDownListWithCountryId")
    Single<CityModel> citiesRequest(@Query("CountryId") int countryId);

    @POST("services/app/User/ChangeLanguage")
    Single<StructueMode> language(@Header("Authorization") String token, @Body LanguageClass languageClass);

    @POST("services/app/User/ChangePassword")
    Single<StructueMode> changePass(@Header("Authorization") String token, @Body ChangePassUser changePassUser);

    @Multipart
    @POST("UploadFile/Upload")
    Single<UploadImageModel> uploadImage(@Header("Authorization") String token , @Part MultipartBody.Part file);

    @PUT("services/app/User/Update")
    Single<UpdateProfileModel> updateUser(@Header("Authorization") String token ,@Body UpdateProfileDTO user);


//    @POST("api/rate")
//    Observable<RateModel> changeRate(@Header("Authorization") String token, @Body RateUser rateUser);
//
//    @GET("api/rate")
//    Observable<RateModel> rates(@Header("Authorization") String token, @Query("storeId") int id);
//
//    @POST("api/Account/UpdateCustomerNotificationStatus")
//    Observable<NotificationChangeModel> updateNotification(@Header("Authorization") String token, @Body NotificationUser notificationUser);
//
//    @GET("api/Order/GetOrderDetials")
//    Observable<OrderDetailModel> orderDetail(@Header("Authorization") String token, @Query("orderId") int id);
//
//    @POST("api/Order/ChangeOrderStatus")
//    Observable<UpdateOrderModel> updateOrder(@Header("Authorization") String token, @Body UpdateOrder updateOrder);
//
}
