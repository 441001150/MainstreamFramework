package com.runen.wnhz.runen.di.module;
import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.model.ArticleListModel;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.service.HomeApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-24.
 */

@Module
public class ArticleMdule {

    public ArticleListContart.View view;

    public ArticleMdule(ArticleListContart.View view) {
        this.view = view;
    }
    
    @Provides
    public ArticleListContart.View provideView(){
        return view;
    }
    
    @Provides
    public ArticleListModel provideHomedel(HomeApi apiService){
        return new ArticleListModel(apiService);
    }
}
