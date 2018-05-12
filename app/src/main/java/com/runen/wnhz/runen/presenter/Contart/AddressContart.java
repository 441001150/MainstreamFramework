package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import com.runen.wnhz.runen.ui.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018-04-28.
 */

public interface AddressContart {
    
    
    interface View extends BaseView{
        
        String getToken();
        
        String getPage();

        void getReceivingRecycler(List<ReceivingAddressEntity> mlist);

//        类型  1 新增（除aid 其余参数全部必传）  2修改（aid 必传）  3删除（aid 必传） 4设置默认地址（aid token 必传）
        String getType();

//        地址id  (修改 删除 地址时必传)
        String getAid();

        //名字
        String getName();

        //手机号
        String getPhone();

        //省
        String getprovince();

        //市
        String getCity();

        //县
        String getCounty();

        //详细地址
        String getAddress();

        //默认是否选中
        String getIsDefault();

        void showJumpToast(String info);
    }
}
