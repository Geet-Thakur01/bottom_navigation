package com.example.geet_pc.tendam_retrofit.frgments.dashboard;

import com.example.geet_pc.tendam_retrofit.util.UserInfo;

/**
 * Created by geet-pc on 29/3/18.
 */

public class DashBoardPresenter implements DashBoardPresenterInterface {
    DashboardView dashboardView;

    public DashBoardPresenter(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
    }

    @Override
    public void updateInfo() {
        if (UserInfo.getInstance().getLoginResponse() != null) {
            String profile_pic = UserInfo.getInstance().getLoginResponse().getPath().getImages() +
                    UserInfo.getInstance().getLoginResponse().getValue().getProfilepic();
            String basic_info = UserInfo.getInstance().getLoginResponse().getValue().getNickname() + "\n"
                    + UserInfo.getInstance().getLoginResponse().getValue().getCity() + "\n"
                    + UserInfo.getInstance().getLoginResponse().getValue().getContactno();
            dashboardView.onUpdateInfo(profile_pic, basic_info);
        }
    }
}
