package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class UserUcenterEntity implements Serializable {


    String is_weixin;
    String is_qq;

    public String getIs_weixin() {
        return is_weixin;
    }

    public void setIs_weixin(String is_weixin) {
        this.is_weixin = is_weixin;
    }

    public String getIs_qq() {
        return is_qq;
    }

    public void setIs_qq(String is_qq) {
        this.is_qq = is_qq;
    }

    @Override
    public String toString() {
        return "UserUcenterEntity{" +
                "is_weixin='" + is_weixin + '\'' +
                ", is_qq='" + is_qq + '\'' +
                '}';
    }
}
