package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：个人中心数据
 */


public class PersonalEntity implements Serializable{


    /**
     * username :
     * mobile : 17635454606
     * sex : 1
     * school :
     * place :
     * head_img : http://runen.unohacha.com/Uploads/Picture/avatar.png
     */

    private String username;
    private String mobile;
    private String sex;
    private String school;
    private String place;
    private String head_img;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}
