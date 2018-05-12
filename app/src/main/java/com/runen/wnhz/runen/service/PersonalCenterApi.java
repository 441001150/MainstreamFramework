package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * Created by Administrator on 2018-04-24.
 */

public interface PersonalCenterApi {

    /**
     *退出登录
     */
    @FormUrlEncoded
    @POST("User_logout")
    Observable<BaseUnified> logoutApi(@FieldMap Map<String, String> params);

    /**
     *个人中心信息
     */
    @FormUrlEncoded
    @POST("Ucenter_userInfo")
    Observable<BaseEntity<PersonalEntity>> userInfoApi(@FieldMap Map<String, String> params);

    /**
     *修改个人资料
     */
    @FormUrlEncoded
    @POST("Ucenter_changeProfile")
    Observable<BaseUnified> changeProfileApi(@FieldMap Map<String, String> params);

    /**
     *意见反馈
     */
    @FormUrlEncoded
    @POST("Ucenter_feedback")
    Observable<BaseUnified> feedbackApi(@FieldMap Map<String, String> params);


    /*
    * 上传图片文件
    * */
    @Multipart
    @POST("Ucenter_uploadImgs")
    Observable<BaseEntity<UploadImgEntity>> uploadImage(@PartMap Map<String, RequestBody> map);

}

