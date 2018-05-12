package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;
import com.runen.wnhz.runen.ui.BaseView;

import java.io.File;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public interface PersonalContart {

    interface View extends BaseView{


        String getToken();


        void setLogin(String info);

        void setErrorMessage(String info);

        void getUserMessage(PersonalEntity data);






        //修改个人资料   把所有都放置进去，上传都时候都传递进去。
        String getNickName();

        String getSex();

        String getSchool();

        String getPlace();

        String getPassword();

        String getHedimg();

        void setSuccess(String info);

        void setSuccess(UploadImgEntity info);

        File getFile();
    }


}
