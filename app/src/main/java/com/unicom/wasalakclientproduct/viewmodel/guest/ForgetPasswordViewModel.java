package com.unicom.wasalakclientproduct.viewmodel.guest;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.unicom.wasalakclientproduct.di.qualifier.ActivityContext;
import com.unicom.wasalakclientproduct.di.scope.FragmentScope;
import com.unicom.wasalakclientproduct.model.guest.ForgetPassUSer;
import com.unicom.wasalakclientproduct.model.guest.ForgetPasswordModel;
import com.unicom.wasalakclientproduct.repository.GuestRepository;
import com.unicom.wasalakclientproduct.utils.KeyboardUtils;
import com.unicom.wasalakclientproduct.utils.SingleLiveData;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;

import es.dmoral.toasty.Toasty;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

@FragmentScope
public class ForgetPasswordViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    private Disposable disposable;
    private SingleLiveData<ForgetPassUSer> userMutableLiveData;
    private SingleLiveData<ForgetPasswordModel> forgetMutableLiveData;
    public MutableLiveData<Boolean> enableButton = new MutableLiveData<>();
    ForgetPassUSer forgetPassUSer;
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    KeyboardUtils keyboardUtils;
    GuestRepository guestRepository;
    @Inject
    @ActivityContext
    Context context;
    Retrofit retrofit;

    @Inject
    public ForgetPasswordViewModel(KeyboardUtils keyboardUtils, GuestRepository guestRepository, Retrofit retrofit) {
        this.keyboardUtils = keyboardUtils;
        this.guestRepository = guestRepository;
        this.retrofit = retrofit;
    }

    public SingleLiveData<ForgetPassUSer> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new SingleLiveData<>();

        }
        return userMutableLiveData;
    }

    public void onClickforget() {
        keyboardUtils.hideKeyboard();
        enableButton.setValue(false);
        forgetPassUSer = new ForgetPassUSer(email.getValue());
        userMutableLiveData.setValue(forgetPassUSer);
    }


    public SingleLiveData<ForgetPasswordModel> getForgetNetworkResponse() {
        if (forgetMutableLiveData == null) {
            forgetMutableLiveData = new SingleLiveData<>();
            enableButton.setValue(true);
            isLoading.setValue(false);
        }
        return forgetMutableLiveData;
    }


    public void forgetNetwork() {
        isLoading.setValue(true);
        disposable = guestRepository.getForgetRequest(forgetPassUSer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(ForgetPasswordModel forgetPasswordModel) {
        if (forgetPasswordModel != null && forgetPasswordModel.getSuccess()) {
            forgetMutableLiveData.setValue(forgetPasswordModel);
        }
        enableButton.setValue(true);
        isLoading.setValue(false);
    }

    private void handleError(Throwable t) {
        try {
//            if (((HttpException) t).response().code() == 500) {
                if (((HttpException) t).response().errorBody() != null) {
                    Converter<ResponseBody, ForgetPasswordModel> errorConverter =
                            retrofit.responseBodyConverter(ForgetPasswordModel.class, new Annotation[0]);
                    try {
                        ForgetPasswordModel error = errorConverter.convert(((HttpException) t).response().errorBody());
                        Toasty.error(context,error.getError().getDetails().toString(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//            }
        }catch (Exception e){
            Toasty.error(context, t.toString(), Toast.LENGTH_SHORT).show();
        }
        enableButton.setValue(true);
        isLoading.setValue(false);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
