package com.example.geet_pc.tendam_retrofit.frgments.picture;

import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.geet_pc.tendam_retrofit.util.ApiClient;
import com.example.geet_pc.tendam_retrofit.util.MyApplication;
import com.example.geet_pc.tendam_retrofit.util.MySharedPrefrence;
import com.example.geet_pc.tendam_retrofit.util.SPInterface;
import com.example.geet_pc.tendam_retrofit.util.ServicesApi;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geet-pc on 30/3/18.
 */

public class PicPresenter implements PicPresenter_Interface {
    private PicView picView;
    private SPInterface spInterface;
    private File file;
    private String imgPath;
    private ServicesApi servicesApi;
    private Uri uriimg;

    public PicPresenter(PicView picView) {
        this.picView = picView;
        servicesApi = ApiClient.getInstance().create(ServicesApi.class);
        this.spInterface = new MySharedPrefrence();
    }


    @Override
    public void sendWallpost() {
        file = new File(imgPath);
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(MyApplication.getMyApplicationContext().getContentResolver().getType(uriimg)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("photo", file.getName(), requestFile);
//        MultipartBody.Part body2 =
//                MultipartBody.Part.createFormData("thumb", file.getName(), requestFile);
        // add another part within the multipart request
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, descriptionString);

        String tokenstr = spInterface.getToken();
        RequestBody token =
                RequestBody.create(
                        okhttp3.MultipartBody.FORM, tokenstr);
        Call<ResponseBody> call = servicesApi.upload(token, description, body, null);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("ReSUlt", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("ReSUlt", "FAIL");
            }
        });

    }

    @Override
    public void getImagerealPath(Uri uri) {
        uriimg = uri;
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = (MyApplication.getMyApplicationContext().getContentResolver().query(uri, proj, null, null, null));
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        imgPath = res;

    }

}
