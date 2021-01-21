package com.application.test;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.application.test.models.LoginDetails;
import com.application.test.models.LoginResponse;
import com.application.test.service.API;
import com.application.test.service.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static Repository repository;

    public static Repository getInstance(){
        if (repository == null){
            repository = new Repository();
        }
        return repository;
    }

    private API api;

    public Repository(){
        api = Util.createService(API.class);
    }

    public MutableLiveData<LoginResponse> getResponse(String phone, String password, String firebaseToken){
        MutableLiveData<LoginResponse> data = new MutableLiveData<>();

        api.getResponse(phone, password, firebaseToken).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
                else {
                    Log.d("t", response.errorBody().source().toString());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                System.out.println("failed 2");
            }
        });
        return data;
    }
}
