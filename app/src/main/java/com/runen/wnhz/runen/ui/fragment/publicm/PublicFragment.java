package com.runen.wnhz.runen.ui.fragment.publicm;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.adapter.puadapter.ViewPagerAdapter;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-04-08.
 * 数据服务界面
 */

public class PublicFragment extends BaseFragment {

    public static final String TAG = "PublicFragment";
    
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter; 


    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.public_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {
        tabLayout = view.findViewById(R.id.public_tablayout);
        viewPager = view.findViewById(R.id.public_viewpager);
        
        //设置viewpager 加载东西
        initSetAdapter();
        
    }
    
    private void initSetAdapter() {
        List<String> mlist = new ArrayList<>();
        mlist.add("美食类");
        mlist.add("书籍类");
        mlist.add("服装美容类");
        mlist.add("小家电类");
        mlist.add("居家类");
        mlist.add("其他");
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(),mlist);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Subscriber(tag = "shopType")
    public void selectTab(String id) {
        tabLayout.getTabAt(Integer.valueOf(id) - 1).select();
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
            mTitleBuilder.setMiddleTitleText("数据服务");
            mTitleBuilder.setMiddleTitleTextColor(getResources().getColor(R.color.white));
        
    }

    @Override
    public void showLoadding() {
        
    }

    @Override
    public void dimissLoding() {

    }

    @Override
    public void showErrorMessage(String msg) {
        
    }

    @Override
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {

    }
}
