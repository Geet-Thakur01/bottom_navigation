package com.example.geet_pc.tendam_retrofit.util;

import com.example.geet_pc.tendam_retrofit.frgments.login.LoginModel.LoginResponse;
import com.example.geet_pc.tendam_retrofit.frgments.login.Login_param;

/**
 * Created by geet-pc on 28/3/18.
 */

public class UserInfo {
    private LoginResponse loginResponse;
    private static final UserInfo ourInstance = new UserInfo();

    public static UserInfo getInstance() {
        return ourInstance;
    }

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

}
