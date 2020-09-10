package com.unicom.wasalakclientproduct.viewmodel.guest;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.model.CityClass;
import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryClass;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterUser;
import com.unicom.wasalakclientproduct.repository.GuestRepository;
import com.unicom.wasalakclientproduct.utils.KeyboardUtils;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.utils.SingleLiveData;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

@FragmentScope
public class RegisterViewModel extends ViewModel {
    public MutableLiveData<String> emailAddress = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> passwordConfirm = new MutableLiveData<>();
    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    //    public MutableLiveData<String> userName = new MutableLiveData<>();
    public MutableLiveData<String> mobile = new MutableLiveData<>();
    public MutableLiveData<Integer> countryId = new MutableLiveData<>();
    public MutableLiveData<Integer> cityId = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private SingleLiveData<RegisterUser> userMutableLiveData;
    private SingleLiveData<RegisterModel> registerMutableLiveData;
    private MutableLiveData<List<CountryClass>> countriesMutableLiveData;
    private MutableLiveData<List<CityClass>> citiesMutableLiveData;
    private CompositeDisposable disposables = new CompositeDisposable();
    public MutableLiveData<Boolean> enableButton = new MutableLiveData<>();
    RegisterUser user;
    GuestRepository guestRepository;
    Retrofit retrofit;
    KeyboardUtils keyboardUtils;
    PreferenceUtils preference;
    @Inject
    @ActivityContext
    Context context;

    @Inject
    public RegisterViewModel(GuestRepository guestRepository, KeyboardUtils keyboardUtils, PreferenceUtils preference, Retrofit retrofit) {
        this.guestRepository = guestRepository;
        this.keyboardUtils = keyboardUtils;
        this.preference = preference;
        this.retrofit = retrofit;
    }

    public SingleLiveData<RegisterUser> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new SingleLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onRegisterClick() {
        keyboardUtils.hideKeyboard();
        enableButton.setValue(false);
        user = new RegisterUser(firstName.getValue(), firstName.getValue(), emailAddress.getValue(),emailAddress.getValue(), password.getValue(), passwordConfirm.getValue(), firstName.getValue(), lastName.getValue(), countryId.getValue(), cityId.getValue(), mobile.getValue(), 6);
        userMutableLiveData.setValue(user);
    }

    public SingleLiveData<RegisterModel> getRegisterMutableLiveData() {
        if (registerMutableLiveData == null) {
            registerMutableLiveData = new SingleLiveData<>();
            enableButton.setValue(true);
        }
        return registerMutableLiveData;
    }

    public MutableLiveData<List<CountryClass>> getCountriesMutableLiveData() {
        if (countriesMutableLiveData == null) {
            countriesMutableLiveData = new MutableLiveData<>();
            retrieveCountries();
        }
        return countriesMutableLiveData;
    }

    public MutableLiveData<List<CityClass>> getCitiesMutableLiveData() {
        if (citiesMutableLiveData == null) {
            citiesMutableLiveData = new MutableLiveData<>();
        }
        return citiesMutableLiveData;
    }

    private void retrieveCountries() {
        isLoading.setValue(true);
        disposables.add(guestRepository.getCountries().map(new Function<CountryModel, List<CountryClass>>() {
            @Override
            public List<CountryClass> apply(CountryModel countryModel) throws Throwable {
                List<CountryClass> countries = new ArrayList<>();
                if (preference.getLang().equals("en")) {
                    for (int i = 0; i < countryModel.getResult().size(); i++) {
                        countries.add(new CountryClass(countryModel.getResult().get(i).getId(), countryModel.getResult().get(i).getName()));
                    }
                } else {
                    for (int i = 0; i < countryModel.getResult().size(); i++) {
                        countries.add(new CountryClass(countryModel.getResult().get(i).getId(), countryModel.getResult().get(i).getName()));
                    }
                }
                return countries;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResultsCountries, this::handleError));
    }

    private void handleResultsCountries(List<CountryClass> countries) {
        if (countries.size() > 0) {
            countriesMutableLiveData.setValue(countries);
        }
        isLoading.setValue(false);
    }

    public void retrieveCities() {
        isLoading.setValue(true);
        disposables.add(guestRepository.getCities(countryId.getValue()).map(new Function<CityModel, List<CityClass>>() {
            @Override
            public List<CityClass> apply(CityModel cityModel) throws Throwable {
                List<CityClass> cities = new ArrayList<>();
                if (preference.getLang().equals("en")) {
                    for (int i = 0; i < cityModel.getResult().size(); i++) {
                        cities.add(new CityClass(cityModel.getResult().get(i).getId(), cityModel.getResult().get(i).getName()));
                    }
                } else {
                    for (int i = 0; i < cityModel.getResult().size(); i++) {
                        cities.add(new CityClass(cityModel.getResult().get(i).getId(), cityModel.getResult().get(i).getName()));
                    }
                }
                return cities;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResultsCities, this::handleError));
    }

    private void handleResultsCities(List<CityClass> cities) {
        citiesMutableLiveData.setValue(cities);
        isLoading.setValue(false);
    }


    public void registerNetwork() {
        isLoading.setValue(true);
        disposables.add(guestRepository.getRegisterRequest(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError));
    }

    private void handleResults(RegisterModel registerModel) {
        if (registerModel != null && registerModel.getResult().getCanLogin()) {
            registerMutableLiveData.setValue(registerModel);
        }
        isLoading.setValue(false);
        enableButton.setValue(true);
    }




    private void handleError(Throwable t) {
        try {
//            if (((HttpException) t).response().code() == 500) {
                if (((HttpException) t).response().errorBody() != null) {
                    Converter<ResponseBody, RegisterModel> errorConverter =
                            retrofit.responseBodyConverter(RegisterModel.class, new Annotation[0]);
                    try {
                        RegisterModel error = errorConverter.convert(((HttpException) t).response().errorBody());
                        Toasty.error(context, error.getError().getMessage(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//            }
        } catch (Exception e) {
            Toasty.error(context, t.toString(), Toast.LENGTH_SHORT).show();
        }

        isLoading.setValue(false);
        enableButton.setValue(true);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposables != null) {
            disposables.clear();
        }
    }
}
