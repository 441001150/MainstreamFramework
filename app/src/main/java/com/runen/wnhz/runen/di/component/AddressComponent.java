package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.PerActivity;
import com.runen.wnhz.runen.di.module.AddressModule;
import com.runen.wnhz.runen.ui.activity.mine.AddAddressActivity;
import com.runen.wnhz.runen.ui.activity.mine.ReceivingAddressActivity;
import dagger.Component;

/**
 * Created by Administrator on 2018-04-28.
 */

@PerActivity
@Component(modules = AddressModule.class,dependencies = ApplicationComponent.class)
public interface AddressComponent {
    
    void initJect(ReceivingAddressActivity activity);
    
    void initJect(AddAddressActivity activity);
}
