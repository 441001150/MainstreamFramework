package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.fragment.minem.MessageFragment;
import com.runen.wnhz.runen.ui.fragment.minem.NoticeFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class MessageCenterActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.rg)
    RadioGroup rg;  
    @BindView(R.id.rb1)
    RadioButton rb1;  
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.v_v)
    View v_v;
    
    int width;
    int indicatorLength = 120;
    
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutView() {
        return R.layout.message_center_activity;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
                finish();
                break;
            case MIDDLE:
                break;
            case RIGHT:
                break;
            default:
                break;
        }
    }

    @Override
    protected void initStart() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
    }

    @Override
    public void initPresente() {
        super.initPresente();

        fragments.add(new MessageFragment());
        fragments.add(new NoticeFragment());
        //设置ViewPager的适配器
        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));

        rg.setOnCheckedChangeListener(this);
        vp.addOnPageChangeListener(this);
        rg.check(R.id.rb1);
        setBoldText(rb1);
        indicator();
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("消息中心")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
    

    public void indicator() {
        width = getResources().getDisplayMetrics().widthPixels / 4;
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v_v.getLayoutParams();
        params.width = indicatorLength;
        params.height = FrameLayout.LayoutParams.MATCH_PARENT;
        v_v.setLayoutParams(params);

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


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v_v.getLayoutParams();
        int left = (int) ((position + positionOffset) * (2 * width));
        int leftMargins = left + width - (indicatorLength / 2);
        params.setMargins(leftMargins, 0, 0, 0);
        v_v.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        rg.check(position == 0 ? R.id.rb1 : R.id.rb2);
        if (position == 0) {
            setBoldText(rb1);
            setNormalText(rb2);


        } else {
            setBoldText(rb2);
            setNormalText(rb1);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

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
