package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.ArticleEntity;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.HomeBannerBean;
import com.runen.wnhz.runen.data.entity.LessonListEntity;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;
import com.runen.wnhz.runen.ui.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018-04-24.
 * MVP V
 */

public interface HomeContart {
    
    interface View extends BaseView {
        
        //获取banner 数据
        void getBannerRequest(List<HomeBannerBean> bannerDatas);      
        
        //获取图说数据
        void getArticleRequest(ArticleEntity articleEntity);    
        
        //获取图说列表信息
        void getArticleListRequest(ArticleListEntity artleListDatas);

        //获取课堂列表信息
        void getLessonListRequest(LessonListEntity lessonList);

        //获取资料精选列表信息
        void getZiliaoListRequest(LessonListEntity lessonList);

        void getShopTypeRequest(List<ShopTypeEntity> shopTypeEntityList);
    }
}
