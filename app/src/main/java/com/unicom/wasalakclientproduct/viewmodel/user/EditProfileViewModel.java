package com.unicom.wasalakclientproduct.viewmodel.user;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.unicom.wasalakclientproduct.R;
import com.unicom.wasalakclientproduct.model.CityClass;
import com.unicom.wasalakclientproduct.model.CityModel;
import com.unicom.wasalakclientproduct.model.CountryClass;
import com.unicom.wasalakclientproduct.model.CountryModel;
import com.unicom.wasalakclientproduct.model.guest.RegisterModel;
import com.unicom.wasalakclientproduct.model.user.GenderDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileDTO;
import com.unicom.wasalakclientproduct.model.user.UpdateProfileModel;
import com.unicom.wasalakclientproduct.model.user.UploadImageModel;
import com.unicom.wasalakclientproduct.repository.UserRepository;
import com.unicom.wasalakclientproduct.utils.KeyboardUtils;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.utils.SingleLiveData;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.FragmentScoped;
import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

@FragmentScoped
public class EditProfileViewModel extends ViewModel {
    public MutableLiveData<Integer> countryId = new MutableLiveData<>();
    public MutableLiveData<Integer> cityId = new MutableLiveData<>();
    public MutableLiveData<String> gender = new MutableLiveData<>();
    public MutableLiveData<String> birthDate = new MutableLiveData<>();
    public MutableLiveData<Integer> id = new MutableLiveData<>();

    public MutableLiveData<String> emailAddress = new MutableLiveData<>();
    public MutableLiveData<String> firstName = new MutableLiveData<>();
    public MutableLiveData<String> lastName = new MutableLiveData<>();
    public MutableLiveData<String> mobile = new MutableLiveData<>();

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<List<CountryClass>> countriesMutableLiveData;
    private MutableLiveData<List<CityClass>> citiesMutableLiveData;
    private MutableLiveData<List<UpdateProfileDTO.FilesKey>> fileKeysMutableLiveData = new MutableLiveData<>();
    public SingleLiveData<UploadImageModel> uploadImageModelMutableLiveData;
    public MutableLiveData<Uri> uriImageMutableLiveData;
    private SingleLiveData<UpdateProfileDTO> userMutableLiveData;
    private SingleLiveData<UpdateProfileModel> updateLiveData;
    private CompositeDisposable disposables = new CompositeDisposable();
    public MutableLiveData<Boolean> enableButton = new MutableLiveData<>();
    private MutableLiveData<List<GenderDTO>> genderLiveData;
    private Retrofit retrofit;
    private KeyboardUtils keyboardUtils;
    private PreferenceUtils preference;
    private UserRepository userRepository;
    private UpdateProfileDTO user;
    private SavedStateHandle savedStateHandle;
    private Context context;

    @ViewModelInject
    public EditProfileViewModel(@Assisted SavedStateHandle savedStateHandle  , @ActivityContext Context context , UserRepository userRepository, KeyboardUtils keyboardUtils, PreferenceUtils preference, Retrofit retrofit) {
        this.savedStateHandle = savedStateHandle;
        this.context = context;
        this.userRepository = userRepository;
        this.keyboardUtils = keyboardUtils;
        this.preference = preference;
        this.retrofit = retrofit;
    }

    public LiveData<List<GenderDTO>> getGenderLiveData() {
        if (genderLiveData == null) {
            genderLiveData = new MutableLiveData<>();
            retrieveGender();
        }
        return genderLiveData;
    }

    private void retrieveGender() {
        List<GenderDTO> genders = new ArrayList<>();
        genders.add(new GenderDTO(1, context.getString(R.string.male)));
        genders.add(new GenderDTO(2, context.getString(R.string.female)));
        genderLiveData.setValue(genders);
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
        disposables.add(userRepository.getCountries().map(new Function<CountryModel, List<CountryClass>>() {
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
        disposables.add(userRepository.getCities(countryId.getValue()).map(new Function<CityModel, List<CityClass>>() {
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

    public MutableLiveData<Uri> getUriImageMutableLiveData() {
        if (uriImageMutableLiveData == null) {
            uriImageMutableLiveData = new MutableLiveData<>();
        }
        return uriImageMutableLiveData;
    }

    public SingleLiveData<UploadImageModel> getUploadImageModelMutableLiveData() {
        if (uploadImageModelMutableLiveData == null) {
            uploadImageModelMutableLiveData = new SingleLiveData<>();
        }
        return uploadImageModelMutableLiveData;
    }

    public void uploadFile(MultipartBody.Part body) {
        disposables.add(userRepository.getUpload("Bearer " + preference.getTokenUser(), body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResultsUpload, this::handleError));
    }

    private void handleResultsUpload(UploadImageModel uploadImageModel) {
        if (uploadImageModel.getSuccess()) {
            uploadImageModelMutableLiveData.setValue(uploadImageModel);
        }
    }

    public MutableLiveData<List<UpdateProfileDTO.FilesKey>> getFileKeysMutableLiveData() {
        return fileKeysMutableLiveData;
    }

    public SingleLiveData<UpdateProfileDTO> getUserMutableLiveData() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new SingleLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onEditClick() {
        keyboardUtils.hideKeyboard();
        enableButton.setValue(false);
        user = new UpdateProfileDTO(id.getValue(), "", firstName.getValue(), firstName.getValue(), emailAddress.getValue(), birthDate.getValue(), firstName.getValue(), lastName.getValue(), countryId.getValue(), cityId.getValue(), mobile.getValue(), gender.getValue(), fileKeysMutableLiveData.getValue(), 6);
        userMutableLiveData.setValue(user);
    }

    public SingleLiveData<UpdateProfileModel> getUpdateProfileLiveData() {
        if (updateLiveData == null) {
            updateLiveData = new SingleLiveData<>();
            enableButton.setValue(true);
        }
        return updateLiveData;
    }

    public void updateNetwork() {
        isLoading.setValue(true);
        disposables.add(userRepository.getUpdateProfile("Bearer " + preference.getTokenUser(), user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResultsUpdate, this::handleError));
    }

    private void handleResultsUpdate(UpdateProfileModel updateProfileModel) {
        if (updateProfileModel != null && updateProfileModel.getSuccess()) {
            updateLiveData.setValue(updateProfileModel);
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
                    Toasty.error(context, error.getError().getDetails().toString(), Toast.LENGTH_LONG).show();
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
