package com.example.geet_pc.tendam_retrofit.frgments.login;

/**
 * Created by geet-pc on 26/3/18.
 */

public interface PreserterInterface {
    boolean checkusernamepassword(Login_param login_param);

    void applyLoginAPI(Login_param login_param);

    void setCredentials(String username, String password);

    void getCredentials();
}
