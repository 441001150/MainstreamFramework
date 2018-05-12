package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.WxEntity;
import com.runen.wnhz.runen.data.entity.WxUserEntity;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * NAME：薛世杰
 * DATE：2018/3/21
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public interface WxServiceApi {



    @GET("sns/oauth2/access_token")
    Observable<WxEntity> getWxInfo(@Query("appid") String APPID, @Query("secret") String SECRET, @Query("code") String CODE, @Query("grant_type") String authorization_code);//获取wx taken信息

    @GET("sns/userinfo")
    Observable<WxUserEntity> getWxUsernfo(@Query("access_token") String ACCESS_TOKEN, @Query("openid") String OPENID);

}
