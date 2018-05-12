package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.runen.wnhz.runen.data.entity.FragmentInfo;
import com.runen.wnhz.runen.ui.fragment.publicm.AllFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-04-23.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    
    private List<FragmentInfo> mDatas = new ArrayList<>();
    
    /**
     * 
     * 第一个参数：fragment 适配器
     * 第二个参数：服务器请求回来的title  根据这个title 进行增加对于的recyclerview
     * */
    public ViewPagerAdapter(FragmentManager fm,List<String> title) {
        super(fm);
        getFragmentTitle(title);
    }
    
    public void getFragmentTitle(List<String> title){
        for (int i = 0; i < title.size(); i++) {
            mDatas.add(new FragmentInfo(title.get(i),AllFragment.class));
        }
        
    };

    @Override
    public Fragment getItem(int position) {
        try {
            return (Fragment) mDatas.get(position).getmFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position).getTitle();
    }
}
