package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.UserUcenterEntity;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public interface SettingApi {

    /*
    *
    * 获取账户设置信息
    * */
    @FormUrlEncoded
    @POST("Ucenter_setNumber")
    Observable<BaseEntity<UserUcenterEntity>> getUserMessageApi(@FieldMap Map<String, String> params);



    /*
 *
 * 登陆第三方账户 绑定，解绑
 * */
    @FormUrlEncoded
    @POST("Ucenter_otherBind")
    Observable<BaseUnified> setThirdPartyUser(@FieldMap Map<String, String> params);




}
