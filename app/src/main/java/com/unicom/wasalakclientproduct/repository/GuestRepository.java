package com.unicom.wasalakclientproduct.repository;


import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.guest.ForgetPassUSer;
import com.unicom.wasalakclientproduct.model.guest.ForgetPasswordModel;
import com.unicom.wasalakclientproduct.model.guest.LoginModel;
import com.unicom.wasalakclientproduct.model.guest.LoginUser;
import com.unicom.wasalakclientproduct.model.guest.RegisterModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterUser;
import com.unicom.wasalakclientproduct.remote.GuestService;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityRetainedScoped;
import io.reactivex.rxjava3.core.Single;

@ActivityRetainedScoped
public class GuestRepository {

    private GuestService guestService;

    @Inject
    public GuestRepository(GuestService guestService) {
        this.guestService = guestService;
    }

    public Single<LoginModel> getLoginRequest(LoginUser user) {
        return guestService.loginRequest(user);
    }
    public Single<LoginModel> getLoginExternalRequest(String authProvider , String providerKey , String providerAccessCode) {
        return guestService.loginExternalRequest(authProvider , providerKey , providerAccessCode);
    }


    public Single<RegisterModel> getRegisterRequest(RegisterUser user) {
        return guestService.registerRequest(user);
    }

    public Single<ForgetPasswordModel> getForgetRequest(ForgetPassUSer user) {
        return guestService.forgetRequest(user);
    }

    public Single<CountryModel> getCountries() {
        return guestService.countriesRequest();
    }

    public Single<CityModel> getCities(int countryId) {
        return guestService.citiesRequest(countryId);
    }


}
