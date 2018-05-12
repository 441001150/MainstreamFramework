package com.runen.wnhz.runen.di.component;
import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.SettingModule;
import com.runen.wnhz.runen.ui.activity.mine.AccountSettingActivity;

import dagger.Component;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@PerActivity
@Component(modules = SettingModule.class,dependencies = ApplicationComponent.class)
public interface SettingComponent {


    void initJect(AccountSettingActivity activity);
}


