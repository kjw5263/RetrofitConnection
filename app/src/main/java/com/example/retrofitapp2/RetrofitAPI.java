package com.example.retrofitapp2;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    String url = "http://imarker.kr";
    @FormUrlEncoded
    @POST("")
    Call<Example> postData(@FieldMap HashMap<String, Object> param);
}
