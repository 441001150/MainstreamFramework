package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class BaseUnified implements Serializable {


    /**
     * re : 1
     * info : 添加成功!
     */

    private String re;
    private String info;

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
