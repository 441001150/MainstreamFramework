package com.runen.wnhz.runen.di.module;
import com.runen.wnhz.runen.presenter.Contart.MineContart;
import com.runen.wnhz.runen.presenter.model.MineModel;
import com.runen.wnhz.runen.service.MineServiceApi;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018-04-28.
 */

@Module
public class MineModule {
    
    public MineContart.View view;

    public MineModule(MineContart.View view) {
        this.view = view;
    }

    @Provides
    public MineContart.View provideView(){
        return view;
    }

    @Provides
    public MineModel provideHomedel(MineServiceApi mineServiceApi){
        return new MineModel(mineServiceApi);
    }
}
