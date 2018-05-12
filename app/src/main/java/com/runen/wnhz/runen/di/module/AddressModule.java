package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.model.AddressModel;
import com.runen.wnhz.runen.service.ReceivingAddressApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-28.
 */
@Module
public class AddressModule {
    
    AddressContart.View view;

    public AddressModule(AddressContart.View view) {
        this.view = view;
    }
    
    @Provides
    public AddressContart.View provideView(){
        return view;
    }
    
    @Provides
    public AddressModel provideModel(ReceivingAddressApi addressApi){
        return new AddressModel(addressApi);
    }
}
