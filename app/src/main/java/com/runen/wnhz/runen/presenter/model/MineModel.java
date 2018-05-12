package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.MineBean;
import com.runen.wnhz.runen.data.entity.UcenterEntity;
import com.runen.wnhz.runen.service.MineServiceApi;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class MineModel {
    
    public MineServiceApi mineServiceApi;

    public MineModel(MineServiceApi mineServiceApi) {
        this.mineServiceApi = mineServiceApi;
    }
    
    //获取我的余额
    public Observable<MineBean> getUserMoneyApi(Map<String,String> map){
        return mineServiceApi.userMoneyApi(map);
    } 
      
    //获取充值列表
    public Observable<BaseEntity<List<UcenterEntity>>> rechargeListApi(){
        return mineServiceApi.rechargeListApi();
    } 
    
    
}
