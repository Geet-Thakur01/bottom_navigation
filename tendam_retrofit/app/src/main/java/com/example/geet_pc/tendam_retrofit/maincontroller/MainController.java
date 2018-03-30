package com.example.geet_pc.tendam_retrofit.maincontroller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.geet_pc.tendam_retrofit.R;
import com.example.geet_pc.tendam_retrofit.frgments.dashboard.DashBoardFragment;
import com.example.geet_pc.tendam_retrofit.frgments.login.LoginFragment;
import com.example.geet_pc.tendam_retrofit.frgments.notification.NotificationFragment;
import com.example.geet_pc.tendam_retrofit.frgments.picture.PictureFragment;

/**
 * Created by geet-pc on 26/3/18.
 */

public class MainController implements ControllerInterface {
    Context ctx;
    Fragment fragment;
    FragmentManager fm;

    public MainController(Activity ctx) {
        this.ctx = ctx;

    }

    @Override
    public void OnReplaceFragment(int fragment_id) {
        switch (fragment_id) {
            case R.string.title_login:
                if (!(fragment instanceof LoginFragment))
                    fragment = LoginFragment.newInstance("login", "");
                break;
            case R.string.title_dashboard:
                if (!(fragment instanceof DashBoardFragment))
                    fragment = DashBoardFragment.newInstance("dashboard", "");
                break;
            case R.string.title_picture:
                if (!(fragment instanceof PictureFragment))
                    fragment = PictureFragment.newInstance("picture", "");
                break;
            case R.string.title_notifications:
                if (!(fragment instanceof NotificationFragment))
                    fragment = NotificationFragment.newInstance("notification", "");
                break;
        }

        ((AppCompatActivity)ctx).getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, fragment).commit();
    }
}
