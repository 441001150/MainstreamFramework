package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * NAME：薛世杰
 * DATE：2018/5/3
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class UploadImgEntity implements Serializable {



    private String img;
    private String upimg;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUpimg() {
        return upimg;
    }

    public void setUpimg(String upimg) {
        this.upimg = upimg;
    }


    @Override
    public String toString() {
        return "UploadImgEntity{" +
                "img='" + img + '\'' +
                ", upimg='" + upimg + '\'' +
                '}';
    }
}
