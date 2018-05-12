package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-23.
 */

public class ArticleEntity implements Serializable {


    
    
    /**
     * fid : 1
     * form_title : 图说
     * form_img : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3821359448,2497624629&fm=27&gp=0.jpg
     * views : 2
     * des : 企业发展之合作篇
     * 
     * 
     * @return string data.form_id  =>图说fid
     * @return string data.form_title  =>标题
     * @return string data.form_img  =>图片
     * @return string data.views  =>阅读量
     * @return string data.des  =>描述
     */

    private String fid;
    private String form_title;
    private String form_img;
    private String views;
    private String des;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getForm_title() {
        return form_title;
    }

    public void setForm_title(String form_title) {
        this.form_title = form_title;
    }

    public String getForm_img() {
        return form_img;
    }

    public void setForm_img(String form_img) {
        this.form_img = form_img;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
