package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.model.FeedModel;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.service.PersonalCenterApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-28.
 */

@Module
public class FeedModule {
    
    public FeedContart.View view;

    public FeedModule(FeedContart.View view) {
        this.view = view;
    }

    @Provides
    public FeedContart.View provideView(){
        return view;
    }

    @Provides
    public FeedModel provideHomedel(PersonalCenterApi apiService){
        return new FeedModel(apiService);
    }
}
