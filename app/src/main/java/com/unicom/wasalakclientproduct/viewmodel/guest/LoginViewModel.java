package com.unicom.wasalakclientproduct.viewmodel.guest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.ahmedadel.socialmediasignup.SocialMediaSignUp;
import com.ahmedadel.socialmediasignup.callback.SocialMediaSignUpCallback;
import com.ahmedadel.socialmediasignup.model.SocialMediaUser;
import com.unicom.wasalakclientproduct.model.guest.LoginModel;
import com.unicom.wasalakclientproduct.model.guest.LoginUser;
import com.unicom.wasalakclientproduct.repository.GuestRepository;
import com.unicom.wasalakclientproduct.utils.KeyboardUtils;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;
import com.unicom.wasalakclientproduct.utils.SingleLiveData;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.android.scopes.FragmentScoped;
import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;


@FragmentScoped
public class LoginViewModel extends ViewModel implements SocialMediaSignUpCallback {
    private SingleLiveData<LoginUser> userMutableLiveData;
    private SingleLiveData<LoginModel> loginMutableLiveData;
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public MutableLiveData<String> emailAddress = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Boolean> enableButton = new MutableLiveData<>();
    private Retrofit retrofit;
    Context context;
    private SavedStateHandle savedStateHandle;
    private CompositeDisposable disposables = new CompositeDisposable();
    private GuestRepository guestRepository;
    private PreferenceUtils preference;
    private KeyboardUtils keyboardUtils;
    private LoginUser loginUser;

    @ViewModelInject
    public LoginViewModel(@Assisted SavedStateHandle savedStateHandle  , @ActivityContext Context context , GuestRepository guestRepository, PreferenceUtils preference, KeyboardUtils keyboardUtils, Retrofit retrofit) {
        this.savedStateHandle = savedStateHandle;
        this.context = context;
        this.guestRepository = guestRepository;
        this.preference = preference;
        this.keyboardUtils = keyboardUtils;
        this.retrofit = retrofit;
    }

    public void onClickFaceBook() {

        SocialMediaSignUp.getInstance().connectTo(SocialMediaSignUp.SocialMediaType.FACEBOOK, Arrays.asList("email"), this);

    }

    public SingleLiveData<LoginUser> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new SingleLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onLoginClick() {
        keyboardUtils.hideKeyboard();
        enableButton.setValue(false);
        loginUser = new LoginUser(emailAddress.getValue(), password.getValue());
        userMutableLiveData.setValue(loginUser);
    }

    public SingleLiveData<LoginModel> getLoginNetworkResponse() {
        if (loginMutableLiveData == null) {
            loginMutableLiveData = new SingleLiveData<>();
            enableButton.setValue(true);
            isLoading.setValue(false);
        }
        return loginMutableLiveData;
    }

    public void loginNetwork() {
        isLoading.setValue(true);
        disposables.add(guestRepository.getLoginRequest(loginUser).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError));
    }

    private void handleResults(LoginModel loginModel) {
        if (loginModel != null && loginModel.getSuccess()) {
            preference.saveTokenUser(loginModel.getResult().getAccessToken());
            loginMutableLiveData.setValue(loginModel);
        } else {
            Toasty.error(context, loginModel.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
        enableButton.setValue(true);
        isLoading.setValue(false);
    }

    private void handleError(Throwable t) {
        try {
//            if (((HttpException) t).response().code() == 500) {
            if (((HttpException) t).response().errorBody() != null) {
                Converter<ResponseBody, LoginModel> errorConverter =
                        retrofit.responseBodyConverter(LoginModel.class, new Annotation[0]);
                try {
                    LoginModel error = errorConverter.convert(((HttpException) t).response().errorBody());
                    Toasty.error(context, error.getError().getDetails().toString(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            }
        } catch (Exception e) {
            Toasty.error(context, t.toString(), Toast.LENGTH_SHORT).show();
        }
        enableButton.setValue(true);
        isLoading.setValue(false);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.clear();
    }

    @Override
    public void onSuccess(SocialMediaSignUp.SocialMediaType socialMediaType, SocialMediaUser socialMediaUser) {
        isLoading.setValue(true);
        disposables.add(guestRepository.getLoginExternalRequest(socialMediaType.name() , socialMediaUser.getUserId() , socialMediaUser.getAccessToken()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError));
        Log.d("TAG", "onSuccess: ");
    }

    @Override
    public void onError(Throwable throwable) {
        Log.d("TAG", "onSuccess: ");
    }

    @Override
    public void onSignOut(SocialMediaSignUp.SocialMediaType socialMediaType) {
        Log.d("TAG", "onSuccess: ");
    }
}