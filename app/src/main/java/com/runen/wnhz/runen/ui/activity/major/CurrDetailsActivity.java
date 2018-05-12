package com.runen.wnhz.runen.ui.activity.major;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.adapter.puadapter.CurrDetailsAdapter;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-26.
 * 课程详情界面
 */

public class CurrDetailsActivity extends BaseActivity {

    CurrDetailsAdapter mCurrDetailsAdapter;
    
    @Override
    protected int getLayoutView() {
        return R.layout.activity_major_detail;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {

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
