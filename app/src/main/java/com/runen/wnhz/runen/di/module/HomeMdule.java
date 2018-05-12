package com.runen.wnhz.runen.di.module;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.service.HomeApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-24.
 */

@Module
public class HomeMdule {
    
    public HomeContart.View view;

    public HomeMdule(HomeContart.View view) {
        this.view = view;
    }
    
    @Provides
    public HomeContart.View provideView(){
        return view;
    }
    
    @Provides
    public HomeModel provideHomedel(HomeApi apiService){
        return new HomeModel(apiService);
    }
}
