package com.runen.wnhz.runen.di.module;
import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.google.gson.Gson;
import com.runen.wnhz.runen.BuildConfig;
import com.runen.wnhz.runen.common.http.CommonParamsInterceptor;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.service.MineServiceApi;
import com.runen.wnhz.runen.service.MyCourseApi;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.service.ReceivingAddressApi;
import com.runen.wnhz.runen.common.utils.Constants;
import com.runen.wnhz.runen.service.SettingApi;
import com.runen.wnhz.runen.service.WxServiceApi;
import com.runen.wnhz.runen.ui.BaseApplication;

import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2018-04-24.
 * 公共参数存放地方
 */
@Module
public class HttpModule {
    
    
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Application application, Gson gson){
        
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // 日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("retrofit = ", message);
                    }
                })
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        
        
        // 如果使用到HTTPS，我们需要创建SSLSocketFactory，并设置到client
//        SSLSocketFactory sslSocketFactory = null;
        return builder
//                .addInterceptor(new CommonParamsInterceptor(application,gson))
                // 连接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)  
                // 读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                // 设置写入超时时间
                .writeTimeout(10,TimeUnit.SECONDS)
                //设置10MB 缓存
//                .cache(new Cache(application.getDataDir(), 10 * 1024 * 1024))
                .addInterceptor(loggingInterceptor)
                .build();

    }

    
    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder.build();
    }
    
    //首页
    @Provides
    @Singleton
    public HomeApi provideHomeApiService(Retrofit retrofit){
        return  retrofit.create(HomeApi.class);
    }
    
    //登陆
    @Provides
    @Singleton
    public LoginServiceApi provideLoginServiceApi(Retrofit retrofit){
        return retrofit.create(LoginServiceApi.class);
    }
    
    //涉及金钱这一块的
    @Provides
    @Singleton
    public MineServiceApi provideMineServiceApi(Retrofit retrofit){
        return retrofit.create(MineServiceApi.class);
    }

    //个人中心
    @Provides
    @Singleton
    public PersonalCenterApi provideLoginApiService(Retrofit retrofit){
        return  retrofit.create(PersonalCenterApi.class);
    }
    
    //收货地址
    @Provides
    @Singleton
    public ReceivingAddressApi provideReceivingAddressApi(Retrofit retrofit){
        return  retrofit.create(ReceivingAddressApi.class);
    }

    //个人中心 我的课程
    @Provides
    @Singleton
    public MyCourseApi provideMyCourseApi(Retrofit retrofit){
        return  retrofit.create(MyCourseApi.class);
    }


    //设置账户
    @Provides
    @Singleton
    public SettingApi provideSettingApi(Retrofit retrofit){
        return  retrofit.create(SettingApi.class);
    }

}
