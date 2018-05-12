package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.FeedModule;
import com.runen.wnhz.runen.ui.activity.mine.FeedbackActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018-04-28.
 */

@PerActivity
@Component(modules = FeedModule.class,dependencies = ApplicationComponent.class)
public interface FeedComponent {
    
    void initject(FeedbackActivity activity);
}
