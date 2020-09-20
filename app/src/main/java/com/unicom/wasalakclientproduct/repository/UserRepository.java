package com.unicom.wasalakclientproduct.repository;

import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.StructueMode;
import com.unicom.wasalakclientproduct.model.user.AccountModel;
import com.unicom.wasalakclientproduct.model.user.ChangePassUser;
import com.unicom.wasalakclientproduct.model.user.LanguageClass;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileModel;
import com.unicom.wasalakclientproduct.model.user.UploadImageModel;
import com.unicom.wasalakclientproduct.remote.UserService;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityRetainedScoped;
import io.reactivex.rxjava3.core.Single;
import okhttp3.MultipartBody;

@ActivityRetainedScoped
public class UserRepository {

    private UserService userService;

    @Inject
    public UserRepository(UserService userService) {
        this.userService = userService;
    }

//    public Observable<ActivitiesModel> getActivities(String token) {
//        return userService.requestActivities(token);
//    }
//
//    public Observable<StoresActivityModel> getStoresActivity(String token , RequestStore requestStore){
//        return userService.storesActivity(token,requestStore);
//    }
//    public Single<ProductsStoreModel> getProducts(String token , int storeId){
//        return userService.productsStore(token,storeId);
//    }
//
//    public Observable<CreateOrderModel> createOrder(String token , OrderUser orderUser){
//        return userService.createOrder(token , orderUser);
//    }
//
//    public Observable<OrdersHistoryModel> getOrdersHistory(String token){
//        return userService.ordersHistory(token);
//    }
//
//    public Observable<NotificationHistoryModel> getNotificationsHistory(String token){
//        return userService.notificationsHistory(token);
//    }
//
    public Single<AccountModel> getAccount(String token){
        return userService.account(token);
    }

    public Single<CountryModel> getCountries() {
        return userService.countriesRequest();
    }

    public Single<CityModel> getCities(int countryId) {
        return userService.citiesRequest(countryId);
    }
//
//    public Single<LogoutModel> getLogout(String token){
//        return userService.logout(token);
//    }

    public Single<StructueMode> getLang(String token, LanguageClass languageClass){
        return userService.language(token , languageClass);
    }

    public Single<UploadImageModel> getUpload(String token , MultipartBody.Part file) {
        return userService.uploadImage(token , file);
    }

    public Single<UpdateProfileModel> getUpdateProfile(String token ,UpdateProfileDTO user) {
        return userService.updateUser(token , user);
    }


//
//    public Observable<NotificationChangeModel> getChangeNotification(String token, NotificationUser notificationUser){
//        return userService.updateNotification(token , notificationUser);
//    }
//
    public Single<StructueMode> getChangePass(String token , ChangePassUser changePassUser){
        return userService.changePass(token , changePassUser);
    }
//
//    public Observable<RateModel> getRate(String token , RateUser rateUser){
//        return userService.changeRate(token , rateUser);
//    }
//    public Observable<RateModel> getRates(String token , int store_id){
//        return userService.rates(token , store_id);
//    }
//
//    public Observable<OrderDetailModel> getOrderDetail(String token , int orderId){
//        return userService.orderDetail(token,orderId);
//    }
//
//    public Observable<UpdateOrderModel> getUpdateOrder(String token, UpdateOrder updateOrder){
//        return userService.updateOrder(token , updateOrder);
//    }

}
