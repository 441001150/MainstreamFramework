package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.data.entity.UcenterEntity;
import com.runen.wnhz.runen.ui.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2018-04-28.
 */

public interface MineContart {
    
    interface View extends BaseView{

        String getToken();

        void showMon(String data);

        //失败的
        void getRequstErrorList(String info);

        //获取成功
        void getrequest(List<UcenterEntity> data);
    }
}
