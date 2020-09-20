package com.unicom.wasalakclientproduct.viewmodel.user;

import android.content.Context;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.unicom.wasalakclientproduct.repository.UserRepository;
import com.unicom.wasalakclientproduct.utils.PreferenceUtils;

import dagger.hilt.android.qualifiers.ActivityContext;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import retrofit2.Retrofit;

public class MarketsViewModel extends ViewModel {
    private Context context;
    private SavedStateHandle savedStateHandle;
    private UserRepository userRepository;
    private PreferenceUtils preference;
    private Retrofit retrofit;
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private CompositeDisposable disposables = new CompositeDisposable();
    @ViewModelInject
    public MarketsViewModel(@Assisted SavedStateHandle savedStateHandle , @ActivityContext Context context , UserRepository userRepository, PreferenceUtils preference , Retrofit retrofit) {
        this.savedStateHandle = savedStateHandle;
        this.context = context;
        this.userRepository = userRepository;
        this.preference = preference;
        this.retrofit = retrofit;
    }

}
