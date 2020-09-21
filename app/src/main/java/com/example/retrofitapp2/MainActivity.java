package com.example.retrofitapp2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI service = retrofit.create(RetrofitAPI.class);

        HashMap<String, Object> input = new HashMap<>();
        input.put("user_id", "0517831805");
        input.put("user_pw", "kst1234");
        Log.v("kjw_input", input.toString());
        service.postData(input).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.isSuccessful()){
                    Example example = response.body();
                    Log.v("kjw_result", "response() >>> " +response);
                    Log.v("kjw_result", "getCode() >>> " +example.getHeader().getCode());
                    Log.v("kjw_result", "getMessage() >>> " +example.getHeader().getMessage());
                } else{
                    Log.v("kjw_result", "response() >>> " +response);
                    Log.v("kjw_error", "error");
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.v("kjw_Failure", t.getMessage());
            }
        });
    }
}