package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.LoginModule;
import com.runen.wnhz.runen.ui.activity.login.ForgetActivity;
import com.runen.wnhz.runen.ui.activity.login.LoginForPersonalActivity;
import com.runen.wnhz.runen.ui.activity.login.RegisterActivity;
import com.runen.wnhz.runen.ui.activity.login.VerificationActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018-04-27.
 */
@PerActivity
@Component(modules = LoginModule.class,dependencies = ApplicationComponent.class)
public interface LoginComponent {

    void initject(RegisterActivity activity);
    void initJect(VerificationActivity activity);
    void initJect(ForgetActivity activity);
    void initJect(LoginForPersonalActivity activity);
}
