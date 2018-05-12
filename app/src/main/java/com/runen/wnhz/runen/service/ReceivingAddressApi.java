package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018-04-16.
 */

public interface ReceivingAddressApi {
    /**
     *收货地址列表
     */
    @FormUrlEncoded
    @POST("Ucenter_userAddress")
    Observable<BaseEntity<List<ReceivingAddressEntity>>> getAddressApi(@FieldMap Map<String, String> params);


    /**
     *修改，增加 删除 地址
     */
    @FormUrlEncoded
    @POST("Ucenter_changeAddress")
    Observable<BaseUnified> addAddressApi(@FieldMap Map<String, String> params);

    

    
}
