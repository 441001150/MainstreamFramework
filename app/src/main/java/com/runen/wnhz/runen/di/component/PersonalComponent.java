package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.PersonalModule;
import com.runen.wnhz.runen.ui.activity.mine.ChangePasswordActivity;
import com.runen.wnhz.runen.ui.activity.mine.PersonalCenterActivity;
import com.runen.wnhz.runen.ui.activity.mine.PersonalDataActivity;
import com.runen.wnhz.runen.ui.activity.mine.UpdateNameActivity;
import com.runen.wnhz.runen.ui.activity.personal.UploadImageActivity;

import dagger.Component;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */

@PerActivity
@Component(modules = PersonalModule.class,dependencies = ApplicationComponent.class)
public interface PersonalComponent {

    void inject(PersonalCenterActivity activity);
    void inject(PersonalDataActivity activity);
    void inject(ChangePasswordActivity activity);
    void inject(UpdateNameActivity activity);
    void inject(UploadImageActivity activity);
}
