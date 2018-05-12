package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class ReceivingAddressEntity implements Serializable {


    /**
     * consignee : 杨川川
     * telephone : 15068101498
     * province : 浙江省
     * city : 杭州市
     * county : 滨江区
     * place : 杭州市滨江区三文路445号
     * aid : 122
     * moren : 1
     */

    private String consignee;
    private String telephone;
    private String province;
    private String city;
    private String county;
    private String place;
    private String aid;
    private String moren;

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getMoren() {
        return moren;
    }

    public void setMoren(String moren) {
        this.moren = moren;
    }
}
