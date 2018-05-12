package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */

public class ShopTypeEntity implements Serializable {

    /**
     * @return string re    =>0
     * @return string info  =>暂无内容
     * @return string re    =>1
     * @return string info  =>获取成功
     * @return object data  =>返回信息集
     * @return string data.0.id  =>分类id
     * @return string data.0.name  =>分类名称
     * @return string data.0.pic  =>分类图标
     * */

    /**
     * {"re": "1","info": "获取成功","data": [{"id": "1","name": "美食类","pic": "http://runen.unohacha.com/Uploads/Picture/uploads/20180426/11.jpg"},{......}]}
     */

    private String id;
    private String name;
    private String pic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
