package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.UserUcenterEntity;
import com.runen.wnhz.runen.ui.BaseView;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public interface SettingCotart {


    interface View extends BaseView{


        String getToken();

        void setLoginError(String info);

        void getUserMessage(UserUcenterEntity data);

        void showUserMessage(String info);

        String getType();

        String getOpenid();

        String getImgUrl();

        String getName();
    }
}
