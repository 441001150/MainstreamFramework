package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-14.
 */

public class UserBean implements Serializable {


    /**
     * token : 9e465e6924a00227801fa4c6e69284d5
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

    @Override
    public String toString() {
        return "UserBean{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                ", head_img='" + head_img + '\'' +
                '}';
    }
}
