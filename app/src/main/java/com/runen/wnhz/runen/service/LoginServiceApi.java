package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.common.utils.MsmEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.RegisterBean;
import com.runen.wnhz.runen.data.entity.UserBean;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018-04-14.
 * 登陆接口
 */

public interface LoginServiceApi {


    /**
     * 短信接口
     */
    @FormUrlEncoded
    @POST("User_getMessage")
    Observable<MsmEntity> userMoneyApi(@FieldMap Map<String, String> params);
    
    
    /**
     *注册
     */
    @FormUrlEncoded
    @POST("User_register")
    Observable<BaseEntity<RegisterBean>> registerApi(@FieldMap Map<String, String> params);

    /**
     *登录
     */
    @FormUrlEncoded
    @POST("User_login")
    Observable<BaseEntity<UserBean>> loginForPersonalApi(@FieldMap Map<String, String> params);

    /**
     *忘记密码
     */
    @FormUrlEncoded
    @POST("User_forgotPassword")
    Observable<BaseEntity<UserBean>> forgetPasswordApi(@FieldMap Map<String, String> params);
}
