package com.application.test;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.application.test.models.LoginDetails;
import com.application.test.models.LoginResponse;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<LoginResponse> mutableLiveData;
    private Repository repository;

    public void init(String phone, String password, String firebaseToken){
        if (mutableLiveData != null){
            return;
        }
        repository = Repository.getInstance();
        mutableLiveData = repository.getResponse(phone, password, firebaseToken);

    }

    public LiveData<LoginResponse> getRepository() {
        return mutableLiveData;
    }

}