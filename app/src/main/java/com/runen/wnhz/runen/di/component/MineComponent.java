package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.MineModule;
import com.runen.wnhz.runen.ui.activity.mine.BalanceActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018-04-28.
 */

@PerActivity
@Component(modules = MineModule.class,dependencies = ApplicationComponent.class)
public interface MineComponent {
    
    void initject(BalanceActivity activity);
}
