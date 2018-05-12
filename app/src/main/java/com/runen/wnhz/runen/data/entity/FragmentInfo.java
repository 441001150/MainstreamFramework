package com.runen.wnhz.runen.data.entity;

/**
 * Created by Administrator on 2018-04-23.
 */

public class FragmentInfo  {
    
    public String title;
    private Class mFragment;


    public FragmentInfo(String title, Class mFragment) {
        this.title = title;
        this.mFragment = mFragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getmFragment() {
        return mFragment;
    }

    public void setmFragment(Class mFragment) {
        this.mFragment = mFragment;
    }

    @Override
    public String toString() {
        return "FragmentInfo{" +
                "title='" + title + '\'' +
                ", mFragment=" + mFragment +
                '}';
    }
}
