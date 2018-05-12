package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
import com.runen.wnhz.runen.ui.BaseView;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public interface CourseContart {

    interface  View extends BaseView{


        String getType();

        String getPage();

        String getToken();

        void showLoginError(String info);

        void reqeuestData(MyCourseEntity data);
    }
}
