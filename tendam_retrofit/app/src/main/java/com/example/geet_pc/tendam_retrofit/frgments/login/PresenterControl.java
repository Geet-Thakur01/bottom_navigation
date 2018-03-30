package com.example.geet_pc.tendam_retrofit.frgments.login;

import android.text.TextUtils;
import android.util.Log;

import com.example.geet_pc.tendam_retrofit.frgments.login.LoginModel.LoginResponse;
import com.example.geet_pc.tendam_retrofit.util.ApiClient;
import com.example.geet_pc.tendam_retrofit.util.MySharedPrefrence;
import com.example.geet_pc.tendam_retrofit.util.SPInterface;
import com.example.geet_pc.tendam_retrofit.util.ServicesApi;
import com.example.geet_pc.tendam_retrofit.util.UserInfo;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by geet-pc on 27/3/18.
 */

public class PresenterControl implements PreserterInterface {
    LoginView loginView;
    ServicesApi servicesApi;
    SPInterface mySharedPrefrence;

    public PresenterControl(LoginView loginView) {
        this.loginView = loginView;
        this.servicesApi = ApiClient.getInstance().create(ServicesApi.class);
        this.mySharedPrefrence=new MySharedPrefrence();
    }

    @Override
    public boolean checkusernamepassword(Login_param login_param) {
        if (TextUtils.isEmpty(login_param.getUsername())) {
            loginView.onUsernameError();
        } else if (TextUtils.isEmpty(login_param.getPassword())) {
            loginView.onPaswordError();
        } else return true;
        return false;
    }

    @Override
    public void applyLoginAPI(Login_param login_param) {
        Call<ResponseBody> call = servicesApi.getLogin(login_param.getUsername(), login_param.getPassword());
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONObject obj = new JSONObject(response.body().string());
                    if (obj.getBoolean("result")) {
                        LoginResponse loginResponse = new Gson().fromJson(obj.toString(), LoginResponse.class);
                        UserInfo.getInstance().setLoginResponse(loginResponse);
                        mySharedPrefrence.setToken(loginResponse.getToken());
                        loginView.displaytoast("success");
                        loginView.onLogin();
                    } else {
                        loginView.displaytoast(obj.getString("value"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e("Service Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }

    @Override
    public void setCredentials(String username, String password) {
        if(mySharedPrefrence!=null){
            mySharedPrefrence.setUsename(username);
            mySharedPrefrence.setPassword(password);
        }
    }

    @Override
    public void getCredentials() {
        String credentials[]=new String[2];
        credentials[0]=mySharedPrefrence.getUsername();
        credentials[1]=mySharedPrefrence.getPassword();
        loginView.setCredentials(credentials);
    }
}
