package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.common.utils.Base64Utils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.presenter.model.FeedModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018-04-28.
 */

public class IFeedPersenter extends BasePresenter<FeedModel,FeedContart.View> {
    
    @Inject
    public IFeedPersenter(FeedModel mModel, FeedContart.View mView) {
        super(mModel, mView);
    }
    
    
    
    /*
    * @param  string  token         用户token
     * @param  int     type          反馈类型 1产品建议 2功能建议
     * @param  string  content       反馈内容
     * @param  string  telephone     联系方式(手机、邮箱)
    * */
    public void feedbackApi() {

        Map<String,String> map = new HashMap<>();
        String base64Mobile = Base64Utils.encode(mView.getTelephone());
        map.put("token",mView.getToken());
        map.put("type",mView.getType());
        map.put("content",mView.getContent());
        map.put("telephone",base64Mobile);
        
        
        mModel.feedbackApi(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()){
                            case "-1":
                                break;  
                            case "0":
                                ToastUtil.showToast(baseUnified.getInfo());
                                break;  
                            case "1":
                                mView.showJump(baseUnified.getInfo());
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
}
