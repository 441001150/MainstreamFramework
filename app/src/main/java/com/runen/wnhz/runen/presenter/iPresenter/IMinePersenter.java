package com.runen.wnhz.runen.presenter.iPresenter;

import android.util.Log;

import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.MineBean;
import com.runen.wnhz.runen.data.entity.UcenterEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.MineContart;
import com.runen.wnhz.runen.presenter.model.MineModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018-04-28.
 */

public class IMinePersenter extends BasePresenter<MineModel,MineContart.View> {
    
    @Inject
    public IMinePersenter(MineModel mModel, MineContart.View mView) {
        super(mModel, mView);
    }
    
    
    /*  获取余额
    * * @param   string    token    登录用户token
    * */
    public void requesetUserMone(){
        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        mModel.getUserMoneyApi(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MineBean>() {
                    @Override
                    public void call(MineBean mineBean) {
                        switch (mineBean.getRe()){
                            case "-1":
                                break;  
                            case "0":
                                ToastUtil.showToast(mineBean.getInfo());
                                break;   
                            case "1":
                                mView.showMon(mineBean.getData());
                                break;
                            
                            
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage().toString());
                    }
                });
        
        
        
    }
    
    
    /*
    * 获取充值列表
    * */
    public void reqeustUserMoneList(){
        mModel.rechargeListApi()
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<List<UcenterEntity>>>() {
                    @Override
                    public void call(BaseEntity<List<UcenterEntity>> listBaseEntity) {
                        switch (listBaseEntity.getRe()) {
                            case 0:
                                mView.getRequstErrorList(listBaseEntity.getInfo());
                                break;
                            case 1:
                                mView.getrequest(listBaseEntity.getData());
                                break;
                            case -1:
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }
    
    
    
}
