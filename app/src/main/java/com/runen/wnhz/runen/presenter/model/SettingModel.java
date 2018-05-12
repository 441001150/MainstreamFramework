package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UserUcenterEntity;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.service.SettingApi;

import java.util.Map;

import rx.Observable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class SettingModel {



    SettingApi mSettingApi;

    public SettingModel(SettingApi settingApi) {
        this.mSettingApi = settingApi;
    }

    //获取账户设置信息
    public Observable<BaseEntity<UserUcenterEntity>> getUserMessage(Map<String,String> map){

        return mSettingApi.getUserMessageApi(map);
    }



    //登陆第三方账户绑定、解绑
    public Observable<BaseUnified> setUserData(Map<String,String> map){
        return mSettingApi.setThirdPartyUser(map);
    }
}
