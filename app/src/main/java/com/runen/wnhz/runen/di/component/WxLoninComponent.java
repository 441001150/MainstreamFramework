package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.wxapi.WXEntryActivity;

import dagger.Component;

/**
 * NAME：薛世杰
 * DATE：2018/5/3
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class)
public interface WxLoninComponent {

    void initject(WXEntryActivity activity);
}
