package com.runen.wnhz.runen.common.rx.subscriber;

import android.content.Context;

/**

 */

public  abstract  class ProgressDialogSubcriber<T> extends ErrorHandlerSubscriber<T> {



//    private ProgressDialogHandler mProgressDialogHandler;


    public ProgressDialogSubcriber(Context context) {
        super(context);

//        mProgressDialogHandler = new ProgressDialogHandler(mContext,true,this);
    }

    protected boolean isShowProgressDialog(){
        return  true;
    }
    
    
    @Override
    public void onStart() {

        if(isShowProgressDialog()){
           
        }

    }

    @Override
    public void onCompleted() {



        if(isShowProgressDialog()){
            
        }
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);

        if(isShowProgressDialog()){
          
        }

    }

}
