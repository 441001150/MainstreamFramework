package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-14.
 */

public class HomeBannerBean implements Serializable {


    /**
     * url_type : article
     * url : 1
     * img : http://bpic.588ku.com/back_pic/03/70/72/5257b6c12d89875.jpg
     */

    private String url_type;
    private String url;
    private String img;

    public String getUrl_type() {
        return url_type;
    }

    public void setUrl_type(String url_type) {
        this.url_type = url_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "HomeBannerBean{" +
                "url_type='" + url_type + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
