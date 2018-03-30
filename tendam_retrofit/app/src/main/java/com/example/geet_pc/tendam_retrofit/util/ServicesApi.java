package com.example.geet_pc.tendam_retrofit.util;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by geet-pc on 26/3/18.
 */

public interface ServicesApi {
    @FormUrlEncoded
    @POST("authentication/login")
    Call<ResponseBody> getLogin(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("wall/post")
    Call<ResponseBody> upload(@Part ("token") RequestBody token,
                              @Part ("description") RequestBody description,
                              @Part MultipartBody.Part file,
                              @Part MultipartBody.Part file2);
}
