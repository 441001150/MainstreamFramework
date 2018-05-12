package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-23.
 */

public class BaseEntity<T> implements Serializable {
    
    
    /**
     * @return string re    =>1
     * @return string info  =>获取成功
     * @return object data  =>数据

     * **/

    public static final int SUCCESS=1;
    
    private int re;
    private String info;
    private T data;

    public BaseEntity() {
    }

    public BaseEntity(int re, String info, T data) {
        this.re = re;
        this.info = info;
        this.data = data;
    }

    public boolean success(){

        return  (re==SUCCESS);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "re=" + re +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }
}
