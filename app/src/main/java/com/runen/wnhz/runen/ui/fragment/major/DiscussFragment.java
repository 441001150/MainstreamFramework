package com.runen.wnhz.runen.ui.fragment.major;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.ui.fragment.minem.MessageFragment;
import com.runen.wnhz.runen.ui.fragment.minem.NoticeFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-04-13.
 */

public class  DiscussFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener
{

    RadioGroup rg;
    RadioButton rb1, rb2;
    ViewPager vp;

    List<Fragment> fragments = new ArrayList<>();
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.discuss_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {
        initView(view);
       
        fragments.add(new MessageFragment());
        fragments.add(new NoticeFragment());
        //设置ViewPager的适配器
        vp.setAdapter(new MyFragmentAdapter(this.getActivity().getSupportFragmentManager(), fragments));

        rg.setOnCheckedChangeListener(this);
//        vp.addOnPageChangeListener(this);
        rg.check(R.id.rb1);
        setBoldText(rb1);
        
        
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    private void initView(View view) {
        rg = view.findViewById(R.id.rg);
        vp = view.findViewById(R.id.vp);
        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        vp.setCurrentItem(checkedId == R.id.rb1 ? 0 : 1);
        if (checkedId == R.id.rb1) {
            setBoldText(rb1);
            setNormalText(rb2);
        } else {
            setBoldText(rb2);
            setNormalText(rb1);
        }

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

    //ViewPager的适配器
    class MyFragmentAdapter extends FragmentPagerAdapter

    {


        private final List<Fragment> mList;

        public MyFragmentAdapter(FragmentManager fm, List<Fragment> mList) {
            super(fm);
            this.mList = mList;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }

    private void setBoldText(TextView boldText) {
        TextPaint tp = boldText.getPaint();
        tp.setFakeBoldText(true);
        boldText.invalidate();
    }

    private void setNormalText(TextView normalText) {
        TextPaint tp = normalText.getPaint();
        tp.setFakeBoldText(false);
        normalText.invalidate();

    }
}
