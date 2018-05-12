package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.model.PersonalModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;

import dagger.Module;
import dagger.Provides;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@Module
public class PersonalModule {

    public PersonalContart.View view;


    public PersonalModule(PersonalContart.View view) {
        this.view = view;
    }


    @Provides
    public PersonalContart.View provideView(){
        return view;
    }

    @Provides
    public PersonalModel providePersonalModel(PersonalCenterApi PersonalCenterApi){
        return new PersonalModel(PersonalCenterApi);
    }
}
