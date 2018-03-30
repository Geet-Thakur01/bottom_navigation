package com.example.geet_pc.tendam_retrofit.frgments.login;

/**
 * Created by geet-pc on 26/3/18.
 */

public interface LoginView {
    void onUsernameError();

    void onPaswordError();

    void onLogin();

    void displaytoast(String msg);

    void setCredentials(String[] credentials);
}
