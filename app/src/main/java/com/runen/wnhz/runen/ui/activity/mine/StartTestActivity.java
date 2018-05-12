package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-26. 开始测试界面
 */

public class StartTestActivity extends BaseActivity {
    
    /*
    * 这个界面里面直接是 展示 上面传递过来的值，显示之后再进行编写测试
    * 
    * */
    @Override
    protected int getLayoutView() {
        return R.layout.activity_starttest;
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
        mTitleBuilder.setMiddleTitleText("接口获取到").setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));

    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
                
    }
}
