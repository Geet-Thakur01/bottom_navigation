package com.example.geet_pc.tendam_retrofit.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by geet-pc on 30/3/18.
 */

public class MyApplication extends Application {
    public static Context ctx;

    public static Context getMyApplicationContext() {
        return ctx;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
    }
}
