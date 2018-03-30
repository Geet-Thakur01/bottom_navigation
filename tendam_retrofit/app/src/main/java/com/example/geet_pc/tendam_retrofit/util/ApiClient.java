package com.example.geet_pc.tendam_retrofit.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by geet-pc on 26/3/18.
 */

public class ApiClient {
    private static final String BASE_URL = "http://www.apliteinfo.com/demo/ExtjsCI/tandemservices/index.php/";
    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
