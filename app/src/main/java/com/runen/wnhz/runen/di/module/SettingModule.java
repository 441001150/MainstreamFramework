package com.runen.wnhz.runen.di.module;
import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import com.runen.wnhz.runen.presenter.model.PersonalModel;
import com.runen.wnhz.runen.presenter.model.SettingModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.service.SettingApi;

import dagger.Module;
import dagger.Provides;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@Module
public class SettingModule {


    public SettingCotart.View view;


    public SettingModule(SettingCotart.View view) {
        this.view = view;
    }


    @Provides
    public SettingCotart.View provideView(){
        return view;
    }

    @Provides
    public SettingModel providePersonalModel(SettingApi SettingApi){
        return new SettingModel(SettingApi);
    }
}
