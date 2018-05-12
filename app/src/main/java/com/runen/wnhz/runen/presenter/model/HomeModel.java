package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.ArticleEntity;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.HomeBannerBean;
import com.runen.wnhz.runen.data.entity.LessonListEntity;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;
import com.runen.wnhz.runen.service.HomeApi;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * 
 * Created by Administrator on 2018-04-24.
 */

/* MVP层中M 层 */
public class HomeModel {
    
    public HomeApi homeApiService;


    public HomeModel(HomeApi homeApiService) {
        this.homeApiService = homeApiService;
    }
    
    //获取首页banner 数据
    public Observable<BaseEntity<List<HomeBannerBean>>> getHomeBanner(){
        return homeApiService.getBannerApi();
    }
    
    //获取首页图说设置
    public Observable<BaseEntity<ArticleEntity>> getAritcle(){
        return homeApiService.getArticleApi();
    }


    //获取图说列表数据
    public Observable<BaseEntity<ArticleListEntity>> getAritcle(Map<String, Integer> map){
        return homeApiService.getArticleList(map);
    }

    //获取首页课程列表/资料列表数据
    public Observable<BaseEntity<LessonListEntity>> getLessonList(Map<String, Integer> map) {
        return homeApiService.getLessonList(map);
    }

    //获取数据服务模块数据
    public Observable<BaseEntity<List<ShopTypeEntity>>> getShopTypeList() {
        return homeApiService.getShopTypeApi();
    }
}
