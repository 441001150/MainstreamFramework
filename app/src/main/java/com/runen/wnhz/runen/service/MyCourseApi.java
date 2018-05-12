package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.MyCollection;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
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


public interface MyCourseApi {

    /**
     *我的课程
     */
    @FormUrlEncoded
    @POST("Ucenter_userLesson")
    Observable<MyCourseEntity> getCourse(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST("Ucenter_userFavorite")
    Observable<MyCollection> getUcenter(@FieldMap Map<String, String> params);

}
