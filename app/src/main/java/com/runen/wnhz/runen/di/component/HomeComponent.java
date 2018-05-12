package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.HomeMdule;
import com.runen.wnhz.runen.ui.fragment.minem.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018-04-24.
 */
@PerActivity
@Component(modules = HomeMdule.class,dependencies = ApplicationComponent.class)
public interface HomeComponent {
    
    void initject(HomeFragment homeFragment);
}
