package com.runen.wnhz.runen.presenter.iPresenter;

import android.util.Log;

import com.runen.wnhz.runen.common.utils.Base64Utils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.model.AddressModel;

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

public class IAddressPersenter extends BasePresenter<AddressModel,AddressContart.View> {
    
    @Inject
    public IAddressPersenter(AddressModel mModel, AddressContart.View mView) {
        super(mModel, mView);
    }
    
    /*显示所有的列表
    * @param   string    token    登录用户token
     * @param   int       page    当前页数
    * */
    public void getAddressList(){
        Log.e("-----", "getAddressList: 进来了" );
        
        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        map.put("page",mView.getPage());

        Log.e("-----", "token: " + mView.getToken() + "t" + mView.getPage() );
        
        mModel.getReceivingAddress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<List<ReceivingAddressEntity>>>() {
                    @Override
                    public void call(BaseEntity<List<ReceivingAddressEntity>> listBaseEntity) {
                        switch (listBaseEntity.getRe()){
                            case 0:
                                ToastUtil.showToast(listBaseEntity.getInfo());
                                break;
                            case 1:
                                mView.getReceivingRecycler(listBaseEntity.getData());
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
    * 修改 删除 新增 
    * * @param string  token         用户token
     * @param int     type          类型  1 新增（除aid 其余参数全部必传）  2修改（aid 必传）  3删除（aid 必传） 4设置默认地址（aid token 必传）
     * @param int     aid           地址id  (修改 删除 地址时必传)
     * @param string  consignee     收货人姓名
     * @param string  telephone     收货人手机号码
     * @param string  province      省
     * @param string  city          市
     * @param string  county        县
     * @param string  address       详细地址
     * @param int     isDefault     不默认1 默认2
     * (新增 必传参数 token type consignee telephone province city county address isDefault)
     * (修改 必传参数 token type aid consignee telephone province city county address isDefault)
     * (删除 必传参数 token type aid)
     * (设置默认地址 必传参数 token type aid isDefault)
    * */
    
    public void setAddress(){
        
        Log.e("-----", "getAddressList: 进来了" );
        Map<String,String> map = new HashMap<>();
    
        String base64Mobile = Base64Utils.encode(mView.getPhone());
        map.put("token",mView.getToken());
        map.put("type",mView.getType());
               /*1 新增（除aid 其余参数全部必传）  2修改（aid 必传）  3删除（aid 必传） 4设置默认地址（aid token 必传）*/
        switch (mView.getType()){
            case "1":
                break;
            case "2":
                map.put("aid",mView.getAid());
                break;
            case "3":
                map.put("aid",mView.getAid());
                break;
            case "4":
                map.put("aid",mView.getAid());
                break;
        }
        map.put("consignee",mView.getName());
        map.put("telephone",base64Mobile);
        map.put("province",mView.getprovince());
        map.put("city",mView.getCity());
        map.put("county",mView.getCounty());
        map.put("address",mView.getAddress());
        map.put("isDefault",mView.getIsDefault());
        
        
 
        
        mModel.setAddress(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                      switch (baseUnified.getRe()){
                          case "-1":
                              ToastUtil.showToast(baseUnified.getInfo());
                              break;
                          case "0":
                              ToastUtil.showToast(baseUnified.getInfo());
                              break;
                          case "1":
                              mView.showJumpToast(baseUnified.getInfo());
                              break;
                      }
                        
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage().trim());
                    }
                });
        

    }
}
