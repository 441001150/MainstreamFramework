package com.runen.wnhz.runen.ui.activity.mine;
import android.support.v4.content.ContextCompat;
import com.github.mikephil.charting.charts.BarChart;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-12.
 */

public class TestRecordActivity extends BaseActivity {

    @BindView(R.id.chart)
    BarChart chart;

    @Override
    protected int getLayoutView() {
        return R.layout.test_record_activity_layout;
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
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("测试记录")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
}
