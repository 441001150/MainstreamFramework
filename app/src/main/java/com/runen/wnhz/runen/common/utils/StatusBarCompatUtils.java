package com.runen.wnhz.runen.common.utils;

import android.app.Activity;
import android.content.Context;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2018-04-25.
 * 在基类中不确定子类页面，做成工具类   变化状态栏
 *  setContentView 方法调用后再设置.
   如果使用了全屏 Activity ,记得调用StatusBarCompat.translucentStatusBar(activity);
 */

public class StatusBarCompatUtils {
    
    //懒汉模式
    private static StatusBarCompatUtils instance;
    private StatusBarCompatUtils(){}

    public static StatusBarCompatUtils getInstance(){
        if (instance == null) {
            synchronized (StatusBarCompatUtils.class){
                instance = new StatusBarCompatUtils();  
            }
        }
        return instance;
    }
    
    
    /**
     * 设置StatusBarCompat 透明状态栏
     * @retrun activity
     * */
    
    public void TranslucentStatusBar(Activity className){
        
        StatusBarCompat.setStatusBarColor(className);
        
    }


    /**
     * 设置StatusBarCompat 带颜色状态栏
     * @retrun activity
     * */

    public void TranslucentStatusBar(Activity className,int color){
        StatusBarCompat.setStatusBarColor(className,className.getResources().getColor(color));

    }
}
