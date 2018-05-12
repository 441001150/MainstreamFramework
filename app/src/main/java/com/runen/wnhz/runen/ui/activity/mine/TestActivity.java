package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-13.
 */

public class TestActivity extends BaseActivity {

    private TextView tv_begin_test;

    @Override
    protected int getLayoutView() {
        return R.layout.test_activity_layout;
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
        
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }


}
