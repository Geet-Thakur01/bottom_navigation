package com.example.geet_pc.tendam_retrofit.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by geet-pc on 30/3/18.
 */

public class MySharedPrefrence implements SPInterface {
    private final String PREF_NAME = "com.example.geet_pc.tendam_retrofit";

    //      Shared Preference setup
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public MySharedPrefrence() {
        sp = MyApplication.getMyApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public String getToken() {
        return sp.getString(TOKEN, null);
    }

    @Override
    public void setToken(String token) {
        editor.putString(TOKEN, token);
        editor.commit();
    }

    @Override
    public void setUsename(String username) {
        editor.putString(USERNAME, username);
        editor.commit();
    }

    @Override
    public String getUsername() {
        return sp.getString(USERNAME, null);
    }

    @Override
    public String getPassword() {
        return sp.getString(PASSWORD, null);
    }

    @Override
    public void setPassword(String password) {
        editor.putString(PASSWORD, password);
        editor.commit();
    }
}
