package com.runen.wnhz.runen.presenter.iPresenter;

import android.support.design.widget.TabLayout;

import com.runen.wnhz.runen.common.utils.MsmEntity;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.UserUcenterEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import com.runen.wnhz.runen.presenter.model.SettingModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class ISettingPersenter extends BasePresenter<SettingModel,SettingCotart.View> {

    @Inject
    public ISettingPersenter(SettingModel mModel, SettingCotart.View mView) {
        super(mModel, mView);
    }


    public void getUcenter(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());

        mModel.getUserMessage(map).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<UserUcenterEntity>>() {
                    @Override
                    public void call(BaseEntity<UserUcenterEntity> userUcenterEntityBaseEntity) {
                        switch (userUcenterEntityBaseEntity.getRe()){
                            case -1:
                                mView.setLoginError(userUcenterEntityBaseEntity.getInfo());
                                break;
                            case 0:
                                mView.getUserMessage(userUcenterEntityBaseEntity.getData());
                                break;
                            case 1:
                                mView.showErrorMessage(userUcenterEntityBaseEntity.getInfo());
                                break;
                            default:
                                ToastUtil.showToast("未知错误");
                                break;
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage());
                    }
                });


    }



    //第三方解绑
    public void setUntie(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());  //token
        map.put("type",mView.getType());    //type  1 微信  2 qq
        map.put("openid",mView.getOpenid());   //唯一表示
        map.put("imgurl",mView.getImgUrl());   //头像路径
        map.put("nickname",mView.getName());   //昵称



        mModel.setUserData(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {

                        switch (baseUnified.getRe()){
                            case "-1":
                                mView.setLoginError(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.showErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.showUserMessage(baseUnified.getInfo());
                                break;
                            default:
                                ToastUtil.showToast("未知错误");
                                break;
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage());
                    }
                });
    }
}
