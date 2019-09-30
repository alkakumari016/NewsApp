package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.recyclerview.widget.DefaultItemAnimator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRv;
    private  Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRv=findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setItemAnimator(new DefaultItemAnimator());

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS).build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build();


        api=retrofit.create(Api.class);

        api.getResponse().enqueue(new Callback<WebServiceResponse>() {
            @Override
            public void onResponse(Call<WebServiceResponse> call, Response<WebServiceResponse> response) {
                if(response.isSuccessful() && response.body()!=null)
                {
                    if(response.body().getmStatus().equals("ok")) {
                        Log.i(TAG,"On Response:::::"+response.body().getMtotalResults());

                        setupNewList(response.body().getmArtices());
                    }
                }
            }

            @Override
            public void onFailure(Call<WebServiceResponse> call, Throwable t) {

                Log.i(TAG,"OnFailure::::::"+t.getLocalizedMessage());
            }
        });
    }

    private void setupNewList(List<Article> articles) {
        if(articles.size()>0) {
            mRv.setAdapter(new NewsAdapter(this,articles));
        }
    }
}
