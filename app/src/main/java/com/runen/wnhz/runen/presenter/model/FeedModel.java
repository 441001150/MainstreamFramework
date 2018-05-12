package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.service.PersonalCenterApi;

import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class FeedModel {
    
 
    private PersonalCenterApi mPersonalCenterApi;

    public FeedModel(PersonalCenterApi PersonalCenterApi) {
        this.mPersonalCenterApi = PersonalCenterApi;
    }
    
    
    public Observable<BaseUnified> feedbackApi(Map<String,String> map){
        return mPersonalCenterApi.feedbackApi(map);
    }


}
