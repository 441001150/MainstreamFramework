package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-14.
 */

public class RegisterBean implements Serializable {


    /**
     * token : b76b5d4245ce94b22a781bc13791e61f
     * username : 
     * head_img : http://img3.imgtn.bdimg.com/it/u=3599989605,2377066072&fm=27&gp=0.jpg
     */

    private String token;
    private String username;
    private String head_img;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}
