package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.ApplicationModule;
import com.runen.wnhz.runen.di.module.HttpModule;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.service.MineServiceApi;
import com.runen.wnhz.runen.service.MyCourseApi;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.service.ReceivingAddressApi;
import com.runen.wnhz.runen.service.SettingApi;
import com.runen.wnhz.runen.service.WxServiceApi;
import com.runen.wnhz.runen.wxapi.WXEntryActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saky on 2017/3/8.
 */
@Singleton
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {
    
    //登陆Api
    LoginServiceApi loginServiceApi();
    //首页Api
    HomeApi homeApisercivce();
    //涉及金钱这一块的
    MineServiceApi mineServiceApi();
    //个人中心
    PersonalCenterApi personalCenterApi();
    //收货地址
    ReceivingAddressApi receivingAddressApi();
    //个人模块中我的课程这一块
    MyCourseApi myCourseApi();

    SettingApi settingApi();

    
}
