package com.runen.wnhz.runen.common.rx.subscriber;

import android.content.Context;
import android.util.Log;

import com.runen.wnhz.runen.common.exception.BaseException;
import com.runen.wnhz.runen.common.rx.RxErrorHandler;


/**
 */

public abstract  class ErrorHandlerSubscriber<T> extends DefualtSubscriber<T> {


    protected RxErrorHandler mErrorHandler = null;

    protected Context mContext;

    public ErrorHandlerSubscriber(Context context){

        this.mContext = context;


        mErrorHandler = new RxErrorHandler(mContext);

    }


    @Override
    public void onError(Throwable e) {

        BaseException baseException =  mErrorHandler.handleError(e);

        if(baseException==null){
            e.printStackTrace();
            Log.d("ErrorHandlerSubscriber",e.getMessage());
        }
        else {
            mErrorHandler.showErrorMessage(baseException);
        }

    }


}
