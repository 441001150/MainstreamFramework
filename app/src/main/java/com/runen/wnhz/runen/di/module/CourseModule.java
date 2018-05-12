package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.model.CourseModel;
import com.runen.wnhz.runen.presenter.model.FeedModel;
import com.runen.wnhz.runen.service.MyCourseApi;
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
public class CourseModule {


    public CourseContart.View view;

    public CourseModule(CourseContart.View view) {
        this.view = view;
    }

    @Provides
    public CourseContart.View provideView(){
        return view;
    }


    @Provides
    public CourseModel provideHomedel(MyCourseApi myCourseApi){
        return new CourseModel(myCourseApi);
    }
}
