package com.runen.wnhz.runen.data.entity;


/**
 * Created by Administrator on 2018-04-09.
 */

public class MineFragmentBean extends BaseEntity {
    String label;
    int resId;

    public MineFragmentBean(String l, int id) {
        label = l;
        resId = id;
    }

    public int getResId() {
        return resId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
