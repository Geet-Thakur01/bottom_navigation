package com.example.geet_pc.tendam_retrofit.util;

/**
 * Created by geet-pc on 30/3/18.
 */

public interface SPInterface {
    String TOKEN = "token";
    String USERNAME = "username";
    String PASSWORD = "password";

    String getToken();

    void setToken(String token);

    void setUsename(String username);

    String getUsername();

    String getPassword();

    void setPassword(String password);
}
