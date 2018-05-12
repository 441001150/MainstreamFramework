package com.runen.wnhz.runen.data.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-04-28.
 */

public class UcenterEntity implements Serializable {


    /**
     * rid : 1
     * values : 99元
     */

    private String rid;
    private String values;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "UcenterEntity{" +
                "rid='" + rid + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}
