package com.runen.wnhz.runen.ui;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.DisplayMetrics;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.runen.wnhz.runen.common.utils.Constants;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerApplicationComponent;
import com.runen.wnhz.runen.common.utils.DisplayUtil;
import com.runen.wnhz.runen.di.module.ApplicationModule;
import com.runen.wnhz.runen.di.module.HttpModule;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.simple.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;


/**
 * Created by saky on 2016/7/5.
 */

public class BaseApplication extends MultiDexApplication {

    ApplicationComponent mAppComponent;

    public static IWXAPI mWxApi;

    public static BaseApplication get(Context context){
        return (BaseApplication)context.getApplicationContext();
    }
    
    public ApplicationComponent getAppComponent(){

        return mAppComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        registerToWX();
    }
    private void registerToWX() {
        //第二个参数是指你应用在微信开放平台上的AppID
        mWxApi = WXAPIFactory.createWXAPI(this, Constants.WEIBO_APP_ID, false);
        // 将该app注册到微信
        mWxApi.registerApp(Constants.WEIBO_APP_ID);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent
                = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
        
    }
    
    //欢迎页的时候执行
    public void initAppconfig() {
        // 初始化log
        Logger.init(LOG_TAG);
        
        initDisplayOpinion();

        EventBus.getDefault().register(this);
    }
    

    private void initDisplayOpinion() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dp(getApplicationContext(), dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dp(getApplicationContext(), dm.heightPixels);
    }
}
