package com.runen.wnhz.runen.presenter.Contart;

import android.os.Bundle;
import android.widget.TextView;

import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.ui.BaseView;

/**
 * Created by Administrator on 2018-04-27.
 */

public interface LoginContart {

    interface View extends BaseView {
        
        /*发送验证码需要View*/
        String mobile();

        void mMobileError();

        String verify();

        String type();

        void showSend(String msg);

        TextView getTextSendOut();

        String mobiLogName();
        
        String mobiLogPass();
        
        void showLoginErrorMsg(String msg);
        
        void saveUserBean(UserBean data);

        
        /*注册用户使用到*/
        String getResterPhone();

        String getResterSendOut();

        String getResterPassWord();

        void showJump(String msg);   //注册成功直接跳转到登陆界面

        Bundle getBundle();
        
        
        /*验证码登陆*/
        
        String getVerifPhone();
     
        String getVerifCode();
        
        void saveVerifData(UserBean data);
        
        
        /*忘记密码*/
        
        String getForgetPhone();
        String getForgetPass();
        String getForgetNewPass();
        String getForgetCode();
        void saveForData(UserBean data);
    }
}
