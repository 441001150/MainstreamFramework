package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import com.runen.wnhz.runen.presenter.model.LoginModel;
import com.runen.wnhz.runen.service.LoginServiceApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-27.
 */

@Module
public class LoginModule {


    public LoginContart.View view;

    public LoginModule(LoginContart.View view) {
        this.view = view;
    }


    @Provides
    public LoginContart.View provideView(){
        return view;
    }

    @Provides
    public LoginModel provideHomedel(LoginServiceApi apiService){
        return new LoginModel(apiService);
    }
}
