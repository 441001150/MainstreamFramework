package com.runen.wnhz.runen.presenter.model;
import com.runen.wnhz.runen.common.utils.MsmEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.RegisterBean;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.service.LoginServiceApi;

import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2018-04-27.
 */

public class LoginModel {


    
    
    public LoginServiceApi mLoginServiceApi;

    public LoginModel(LoginServiceApi loginServiceApi) {
        this.mLoginServiceApi = loginServiceApi;
    }
    
    /* 手机发送验证码
    * * @param  int       mobile       手机号 （base64加密）
     * @param  string    verify       验证码 （）
     * @param  int       type         /**1注册  2 忘记密码  3 验证新手机号  4 修改密码  5 设置支付密码  6 绑定银行卡  7.验证旧手机号  8.分享后注册成功 33登录
    * */
    public Observable<MsmEntity> getRequestSms(Map<String, String> params){
        return mLoginServiceApi.userMoneyApi(params);
    }
    
    /*
    *  密码登陆
    * * @param   int    mobile        手机号
     * @param   int    ptype        手机号归属(默认86)
     * @param   int    password      密码
     * @param   string code          手机验证码
     * @param   int    login_type    登录类型        1手机登录   2第三方登录
     * @param   int    type          登录类型        1微信   2qq  
     * @param   string openid        唯一表示
     * @param   string imgurl        头像路径
     * @param   string nickname      昵称
     * (手机登录 必传参数 login_type mobile password[code])
     * (第三方登录 必传参数 login_type type openid imgurl nickname 注：只支持绑定过的账号登录)
    * */
    public Observable<BaseEntity<UserBean>> getRequestLoginName(Map<String,String> params){
        return mLoginServiceApi.loginForPersonalApi(params);
    }


    /**
     * 注册
     * */
    public Observable<BaseEntity<RegisterBean>> getRequestRegister(Map<String,String> params){
        return mLoginServiceApi.registerApi(params);
    }
    
    /**F
     * 忘记密码
     * */
    public Observable<BaseEntity<UserBean>> getForgetPasswordApi(Map<String,String> params){
        return mLoginServiceApi.forgetPasswordApi(params);
    }
}
