package com.example.geet_pc.tendam_retrofit;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.geet_pc.tendam_retrofit.frgments.dashboard.DashBoardFragment;
import com.example.geet_pc.tendam_retrofit.frgments.login.LoginFragment;
import com.example.geet_pc.tendam_retrofit.frgments.notification.NotificationFragment;
import com.example.geet_pc.tendam_retrofit.frgments.picture.PictureFragment;
import com.example.geet_pc.tendam_retrofit.maincontroller.ControllerInterface;
import com.example.geet_pc.tendam_retrofit.maincontroller.MainController;

public class MainActivity extends AppCompatActivity implements DashBoardFragment.OnDashBoardFragmentInteractionListener,
        LoginFragment.OnLoginFragmentInteractionListener,
        PictureFragment.OnPictureFragmentInteractionListener,
        NotificationFragment.OnNotificationFragmentInteractionListener {
    private ControllerInterface mainController;
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                =new BottomNavigationView.OnNavigationItemSelectedListener()

    {

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.navigation_login:
                mainController.OnReplaceFragment(R.string.title_login);
                return true;
            case R.id.navigation_dashboard:
                mainController.OnReplaceFragment(R.string.title_dashboard);
                return true;
            case R.id.navigation_picture:
                mainController.OnReplaceFragment(R.string.title_picture);
                return true;
            case R.id.navigation_notifications:
                mainController.OnReplaceFragment(R.string.title_notifications);
                return true;
        }
        return false;
    }
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mainController = new MainController(this);
        mainController.OnReplaceFragment(R.string.title_login);
    }

    @Override
    public void onLoginFragmentInteraction(String action) {
        navigation.setSelectedItemId(R.id.navigation_dashboard);
    }

    @Override
    public void onPictureFragmentInteraction(Uri uri) {

    }

    @Override
    public void onDashBoardFragmentInteraction(Uri uri) {

    }

    @Override
    public void onNotificationFragmentInteraction(Uri uri) {

    }
}
