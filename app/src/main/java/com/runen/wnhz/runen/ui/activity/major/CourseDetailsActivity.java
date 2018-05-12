package com.runen.wnhz.runen.ui.activity.major;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.fragment.major.CatalogFragment;
import com.runen.wnhz.runen.ui.fragment.major.DiscussFragment;
import com.runen.wnhz.runen.ui.fragment.major.IntroduceFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import java.util.ArrayList;
import java.util.List;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
/**
 * 课程详情界面
 * Created by Administrator on 2018-04-12.
 */

public class CourseDetailsActivity extends BaseActivity {

    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;
    ViewPager vp;
    View v_v;
    int width;
    int indicatorLength = 120;
    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutView() {
        return R.layout.course_details_activity_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {

    }

    @Override
    protected void initStart() {

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
    
/*
    @Override
    public void initUiAndListener() {


        HzrVideoPlayer hzrVideoPlayer = (HzrVideoPlayer) findViewById(R.id.videoplayer);
        hzrVideoPlayer.setActivity(this);
        hzrVideoPlayer.setProbation(true);//是否试看
        hzrVideoPlayer.setProbationTime(1000*10);//设置试看时间 单位毫秒
        hzrVideoPlayer.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"asdasd");
        hzrVideoPlayer.thumbImageView.setImageResource(R.mipmap.bg_login);
//        TextView textView = new TextView(mContext);
//        textView.setText("asdasdas");
//        hzrVideoPlayer.createDialogWithView(textView).show();
        //   setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");

        fragments.add(new IntroduceFragment());
        fragments.add(new CatalogFragment());
        fragments.add(new DiscussFragment());
        fragments.add(new Fragment());
        //设置ViewPager的适配器
        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
        rg.check(R.id.rb1);
        setBoldText(rb1);
        indicator();
    }*/

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
    public void indicator() {
        width = getResources().getDisplayMetrics().widthPixels / 8;
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v_v.getLayoutParams();
        params.width = indicatorLength;
        params.height = FrameLayout.LayoutParams.MATCH_PARENT;
        v_v.setLayoutParams(params);

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

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    
}
