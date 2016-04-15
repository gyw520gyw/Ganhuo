package com.gyw.ganhuo.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/4/15.
 */
public class MainRetrofit {

    GanApi mGanApi;

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").create();

    MainRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GanUri.BASE_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mGanApi = retrofit.create(GanApi.class);

    }


    public GanApi getServer() {
       return mGanApi;
    }
}
