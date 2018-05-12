package com.runen.wnhz.runen.data.entity;
import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-23.
 */

public class AllDataEntity  implements Serializable{
    
    
    private String ImagePath;  //图片地址
    private String Title;      // 标题
    private String SaleMoney;   //销售钱数
    private String startData;   //开始时间
    private String endData;     //结束时间
    private String Contacts;    //联系人
    private String CallPhone;   //电话
    private Integer StoreSize;   //商铺规模
    private Integer PassengerFlow;   //客流量

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSaleMoney() {
        return SaleMoney;
    }

    public void setSaleMoney(String saleMoney) {
        SaleMoney = saleMoney;
    }

    public String getStartData() {
        return startData;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    public String getContacts() {
        return Contacts;
    }

    public void setContacts(String contacts) {
        Contacts = contacts;
    }

    public String getCallPhone() {
        return CallPhone;
    }

    public void setCallPhone(String callPhone) {
        CallPhone = callPhone;
    }

    public Integer getStoreSize() {
        return StoreSize;
    }

    public void setStoreSize(Integer storeSize) {
        StoreSize = storeSize;
    }

    public Integer getPassengerFlow() {
        return PassengerFlow;
    }

    public void setPassengerFlow(Integer passengerFlow) {
        PassengerFlow = passengerFlow;
    }

    @Override
    public String toString() {
        return "AllDataEntity{" +
                "ImagePath='" + ImagePath + '\'' +
                ", Title='" + Title + '\'' +
                ", SaleMoney='" + SaleMoney + '\'' +
                ", startData='" + startData + '\'' +
                ", endData='" + endData + '\'' +
                ", Contacts='" + Contacts + '\'' +
                ", CallPhone='" + CallPhone + '\'' +
                ", StoreSize=" + StoreSize +
                ", PassengerFlow=" + PassengerFlow +
                '}';
    }
}
