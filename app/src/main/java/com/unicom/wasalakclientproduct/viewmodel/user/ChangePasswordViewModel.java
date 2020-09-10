package com.unicom.wasalakclientproduct.viewmodel.user;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.model.StructueMode;
import com.unicom.wasalakclientproduct.model.user.ChangePassUser;
import com.unicom.wasalakclientproduct.repository.UserRepository;
import com.unicom.wasalakclientproduct.utils.KeyboardUtils;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

public class ChangePasswordViewModel extends ViewModel {
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> passwordNew = new MutableLiveData<>();
    public MutableLiveData<String> passwordConfirm = new MutableLiveData<>();
    private MutableLiveData<ChangePassUser> userMutableLiveData;
    private MutableLiveData<StructueMode> changePassModelMutableLiveData;
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    public PublishSubject publishSubject = PublishSubject.create();
    public MutableLiveData<Boolean> enableButton = new MutableLiveData<>();
    Retrofit retrofit;
    Context context;
    private Disposable disposable;
    UserRepository userRepository;
    PreferenceUtils preference;
    KeyboardUtils keyboardUtils;
    ChangePassUser changePassUser;

    @Inject
    public ChangePasswordViewModel(@ActivityContext Context context, UserRepository userRepository, PreferenceUtils preference, KeyboardUtils keyboardUtils, Retrofit retrofit) {
        this.context = context;
        this.userRepository = userRepository;
        this.preference = preference;
        this.keyboardUtils = keyboardUtils;
        isLoading.setValue(false);
        enableButton.setValue(true);
        this.retrofit = retrofit;
    }

    public MutableLiveData<ChangePassUser> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }

    public void onChangeClick() {
        enableButton.setValue(false);
        keyboardUtils.hideKeyboard();
        changePassUser = new ChangePassUser(password.getValue(), passwordNew.getValue() , passwordConfirm.getValue());
        userMutableLiveData.setValue(changePassUser);
    }

    public MutableLiveData<StructueMode> getLChangePassNetworkResponse() {
        if (changePassModelMutableLiveData == null) {
            changePassModelMutableLiveData = new MutableLiveData<>();
            enableButton.setValue(true);
            isLoading.setValue(false);
        }
        return changePassModelMutableLiveData;
    }


    public void changePass() {
        disposable = userRepository.getChangePass("Bearer " + preference.getTokenUser(), changePassUser)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(this::handleResults, this::handleError);
    }

    private void handleError(Throwable t) {
        try {
//            if (((HttpException) t).response().code() == 500) {
                if (((HttpException) t).response().errorBody() != null) {
                    Converter<ResponseBody, StructueMode> errorConverter =
                            retrofit.responseBodyConverter(StructueMode.class, new Annotation[0]);
                    try {
                        StructueMode error = errorConverter.convert(((HttpException) t).response().errorBody());
                        Toasty.error(context, error.getError().getMessage().toString(), Toast.LENGTH_LONG).show();
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

    private void handleResults(StructueMode changePassModel) {
        if ((changePassModel) != null && changePassModel.getSuccess()) {
            changePassModelMutableLiveData.setValue(changePassModel);
        }
        isLoading.setValue(false);
        enableButton.setValue(true);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }

    }
}