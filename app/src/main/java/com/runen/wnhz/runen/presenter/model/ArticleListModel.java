package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.service.HomeApi;

import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class ArticleListModel {

    public HomeApi mHomeApi;

    public ArticleListModel(HomeApi addressApi) {
        this.mHomeApi = addressApi;
    }

    /**
     *  获取图说二级列表
     */
    public  Observable<BaseEntity<ArticleListEntity>> getArticleList(Map<String,Integer> map){
        return mHomeApi.getArticleList(map);
    }

    /**
     * 获取图说详情
     */
    public  Observable<BaseEntity<ArticleListEntity>> getArticleInfo(int tid){
        return mHomeApi.getArticleInfo(tid);
    }
}
