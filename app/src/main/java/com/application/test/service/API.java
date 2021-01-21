package com.application.test.service;

import com.application.test.BuildConfig;
import com.application.test.models.LoginDetails;
import com.application.test.models.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {

    String BASE_URL = BuildConfig.BASE_URL;


    @FormUrlEncoded
    @POST("/OnlineCourseStudentLogin/studentLogin")
    Call<LoginResponse> getResponse(@Field("phone") String phone, @Field("password") String password, @Field("firebaseToken") String firebaseToken);
}
