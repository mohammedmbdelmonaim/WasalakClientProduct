package com.unicom.wasalakclientproduct.remote;

import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.guest.ForgetPassUSer;
import com.unicom.wasalakclientproduct.model.guest.ForgetPasswordModel;
import com.unicom.wasalakclientproduct.model.guest.LoginModel;
import com.unicom.wasalakclientproduct.model.guest.LoginUser;
import com.unicom.wasalakclientproduct.model.guest.RegisterModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterUser;
import com.unicom.wasalakclientproduct.model.guest.ResetPasswordUser;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GuestService {
    @POST("TokenAuth/Authenticate")
    Single<LoginModel> loginRequest(@Body LoginUser user);

    @POST("TokenAuth/ExternalAuthenticate")
    Single<LoginModel> loginExternalRequest(@Query("AuthProvider")String authProvider, @Query("ProviderKey")String providerKey, @Query("ProviderAccessCode")String providerAccessCode );

    @POST("services/app/Account/Register")
    Single<RegisterModel> registerRequest(@Body RegisterUser user);

    @POST("services/app/Account/ForgotPassword")
    Single<ForgetPasswordModel> forgetRequest(@Body ForgetPassUSer user);

    @POST("services/app/User/ResetPassword")
    Single<ForgetPasswordModel> resetPassword(@Body ResetPasswordUser user);

    @GET("services/app/Country/GetAllForDropDownList")
    Single<CountryModel> countriesRequest();

    @GET("services/app/City/GetAllForDropDownListWithCountryId")
    Single<CityModel> citiesRequest(@Query("CountryId") int countryId);
}
