package com.runen.wnhz.runen.ui;

/**
 * Created by saky on 2016/7/6.
 */
public interface BaseView {

    void showLoadding();            //loading 加载
    
    void dimissLoding();            //loading 结束加载
    
    void showErrorMessage(String msg);  //错误信息
    
}
