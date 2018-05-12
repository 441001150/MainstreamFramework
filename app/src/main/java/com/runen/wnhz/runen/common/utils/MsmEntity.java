package com.runen.wnhz.runen.common.utils;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-27.
 */

public class MsmEntity implements Serializable{

    private int re;

    private String info;

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
