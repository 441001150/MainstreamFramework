package com.runen.wnhz.runen.service;

import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.MineBean;
import com.runen.wnhz.runen.data.entity.UcenterEntity;

import java.util.List;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018-04-16.
 */

public interface MineServiceApi {

    /**
     *我的余额
     */
    @FormUrlEncoded
    @POST("Ucenter_userMoney")
    Observable<MineBean> userMoneyApi(@FieldMap Map<String, String> params);

    /**
     *充值列表
     */
    @POST("Ucenter_rechargeList")
    Observable<BaseEntity<List<UcenterEntity>>> rechargeListApi();
    
}
