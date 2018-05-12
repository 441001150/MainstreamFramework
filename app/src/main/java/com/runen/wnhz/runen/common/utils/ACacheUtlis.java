package com.runen.wnhz.runen.common.utils;

import android.content.Context;

import com.runen.wnhz.runen.data.entity.UserBean;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.data;

/**
 * Created by Administrator on 2018-04-25.
 * 用于缓存各种数据的
 */

public class ACacheUtlis {
    
    //懒汉模式
    private static ACacheUtlis interfice;
    private ACacheUtlis(){}

    public static ACacheUtlis getInstance(){
        if (interfice == null) {
            synchronized (ACacheUtlis.class){
                interfice = new ACacheUtlis();
            }
        }
        return interfice;
    }
    
    
    
    /**
     * 是否第一次进入App
     * @return Null
     * */
     public void  IsFirstToApp(Context context,String name){
         ACache.get(context).put(Constants.ISFIRSTOAPP,name);
     }

    /**
     * 读出是否第一次进入App
     * @return Null
     * */
    public String IsFirstToApp(Context context){
        String asString = ACache.get(context).getAsString(Constants.ISFIRSTOAPP);
        return asString;
    }

    /**
     *
     "token": "b76b5d4245ce94b22a781bc13791e61f",
     "username": "",
     "head_img": "http://img3.imgtn.bdimg.com/it/u=3599989605,2377066072&fm=27&gp=0.jpg"
     */

    /**
     * 保存用户登录信息
     * @retrun
     * */
    
    public void  IsRequstUser(Context context,String token,String username,String head_img){
        ACache.get(context).put(Constants.UserName,username);
        ACache.get(context).put(Constants.UserToken,token);
        ACache.get(context).put(Constants.UserImage,head_img);
    } 
    
    
    /**
     * 取出用户登陆信息
     * */
    public UserBean getReqeustUser(Context context){
        String UserName = ACache.get(context).getAsString(Constants.UserName);
        String UserToken = ACache.get(context).getAsString(Constants.UserToken);
        String UserImage = ACache.get(context).getAsString(Constants.UserImage);
        UserBean userBean = new UserBean();
        userBean.setHead_img(UserImage);
        userBean.setToken(UserToken);
        userBean.setUsername(UserName);
        return userBean;
    }

    
    /**
     * 清空用户信息
     * */
    
    /**
     * 清空数据缓存信息
     * */
    
    /**
     * 清空所有信息
     *
     * */

}
