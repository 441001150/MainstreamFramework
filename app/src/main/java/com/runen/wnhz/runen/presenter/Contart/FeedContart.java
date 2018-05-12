package com.runen.wnhz.runen.presenter.Contart;

import com.runen.wnhz.runen.ui.BaseView;

/**
 * Created by Administrator on 2018-04-28.
 */

public interface FeedContart {
    
    
    interface View extends BaseView{


        String getToken();

        String getType();

        String getContent();

        String getTelephone();

        void showJump(String info);
    }
}
