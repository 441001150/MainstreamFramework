package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;
import com.runen.wnhz.runen.service.PersonalCenterApi;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class PersonalModel {


    PersonalCenterApi personalCenterApi;

    public PersonalModel(PersonalCenterApi personalCenterApi) {
        this.personalCenterApi = personalCenterApi;
    }

    //获取个人中心信息

    public Observable<BaseEntity<PersonalEntity>> getUserMessage(Map<String,String> map){

        return personalCenterApi.userInfoApi(map);
    }



    //修改用户资料
    public Observable<BaseUnified> setUserData(Map<String,String> map){
        return personalCenterApi.changeProfileApi(map);
    }


    //退出登陆
    public Observable<BaseUnified> setExitLogin(Map<String,String> map){
        return personalCenterApi.logoutApi(map);
    }

    /*
    * 上传图片
    * */
    public Observable<BaseEntity<UploadImgEntity>> setUploadImg(Map<String, RequestBody> map){
        return personalCenterApi.uploadImage(map);
    }
}
