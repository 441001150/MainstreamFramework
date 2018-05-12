package com.runen.wnhz.runen.presenter;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import com.runen.wnhz.runen.ui.BaseView;

/*base基类编写 */
public class BasePresenter<M,V extends BaseView> {
    
    
    protected M mModel;
    protected V mView;
    private Context mContext;

    public BasePresenter(M mModel, V mView) {
        this.mModel = mModel;
        this.mView = mView;
    }



    private void initContext(){
        
        if(mView instanceof Fragment){
            mContext = ((Fragment)mView).getActivity();
        }
        else {
            mContext = (Activity) mView;
        }
    }
}
