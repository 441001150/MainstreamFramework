package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerFragment;
import com.runen.wnhz.runen.di.module.CourseModule;
import com.runen.wnhz.runen.ui.activity.mine.MyCollectionActivity;
import com.runen.wnhz.runen.ui.fragment.minem.DownloadedFragment;
import com.runen.wnhz.runen.ui.fragment.minem.LearningFragment;

import dagger.Component;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@PerFragment
@Component(modules = CourseModule.class,dependencies = ApplicationComponent.class)
public interface CourseComponent {

    void initject(LearningFragment LearningFragment);

    void intject(DownloadedFragment fragment);

    void initject(MyCollectionActivity activity);
}
