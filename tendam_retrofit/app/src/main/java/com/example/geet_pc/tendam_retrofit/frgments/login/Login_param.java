package com.example.geet_pc.tendam_retrofit.frgments.login;

/**
 * Created by geet-pc on 27/3/18.
 */

public class Login_param {
    String username;
    String password;

    public Login_param(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
