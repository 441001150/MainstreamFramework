package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.ArticleEntity;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.HomeBannerBean;
import com.runen.wnhz.runen.data.entity.LessonListEntity;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018-04-24.
 * home 首页数据
 */

public interface HomeApi {

    /**
     *首页banner
     */
    @POST("Index_banner")
    Observable<BaseEntity<List<HomeBannerBean>>> getBannerApi();

    /**
     * 获取图说
     * */
    @POST("Article_index")
    Observable<BaseEntity<ArticleEntity>> getArticleApi();


    /**
     * 获取图说列表
     *  @param   int       fid    文章分类(选填 默认1)
     * @param   int       page    当前页数(默认0)
     */
    @POST("Article_articleList/{fid}")
    @FormUrlEncoded
    Observable<BaseEntity<ArticleListEntity>> getArticleList(@FieldMap Map<String, Integer> params);

    /**
     * 获取图说详情
     *  @param   int       tid    文章id
     */
    @POST("Article_articleInfo")
    Observable<BaseEntity<ArticleListEntity>> getArticleInfo(@Query("tid") int tid);

    /**
     * 获取课程列表
     * @param   int       type    获取类型 1普通课程 3资料(默认1)
     * @param   int       form_id  课程分类ID(选填)
     * @param   int       page    当前页数(默认0)
     * @param   int       size    获取条数(默认10)
     * @param   string    search   搜索内容
     */
    @POST("Lesson_formList")
    @FormUrlEncoded
    Observable<BaseEntity<LessonListEntity>> getLessonList(@FieldMap Map<String, Integer> params);

    /**
     *首页banner
     */
    @POST("Shopdata_getShoptype")
    Observable<BaseEntity<List<ShopTypeEntity>>> getShopTypeApi();
}
