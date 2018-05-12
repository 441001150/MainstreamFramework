package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class MineBean implements Serializable {


    /**
     * re : 1
     * info : 获取成功
     * data : 50.00
     */

    private String re;
    private String info;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
