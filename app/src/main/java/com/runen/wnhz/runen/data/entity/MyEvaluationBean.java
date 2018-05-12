package com.runen.wnhz.runen.data.entity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-04-12.
 */

public class MyEvaluationBean extends BaseEntity {
    
    String type;
    ArrayList<String> subType = new ArrayList<>();

    public ArrayList<String> getSubType() {
        return subType;
    }

    public void setSubType(ArrayList<String> subType) {
        this.subType = subType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
