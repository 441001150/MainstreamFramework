package com.runen.wnhz.runen.presenter.model;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import com.runen.wnhz.runen.service.ReceivingAddressApi;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class AddressModel {
    
    public ReceivingAddressApi addressApi;

    public AddressModel(ReceivingAddressApi addressApi) {
        this.addressApi = addressApi;
    }
    
    /* 
     *收货地址列表
     */
    public  Observable<BaseEntity<List<ReceivingAddressEntity>>> getReceivingAddress(Map<String,String> map){
        return addressApi.getAddressApi(map);
    }
    
    /*
     *增加，删除，新增等收货地址
    * */
    public Observable<BaseUnified> setAddress(Map<String,String> map){
        return addressApi.addAddressApi(map);
    }
    
    
    
}
