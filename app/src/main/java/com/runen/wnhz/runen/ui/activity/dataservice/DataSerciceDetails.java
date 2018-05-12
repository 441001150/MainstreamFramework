package com.runen.wnhz.runen.ui.activity.dataservice;

import android.support.v4.content.ContextCompat;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.data.entity.AllDataEntity;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-26.
 * 数据服务跳转详情页面  只做显示就行，时间点击事件 其他不做操作
 */

public class DataSerciceDetails extends BaseActivity{
    private AllDataEntity entity;
    
    /*调转过来塞值*/
    
    @Override
    protected int getLayoutView() {
        return R.layout.activity_datasercicedetails;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
                this.finish();
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
        entity = (AllDataEntity) getIntent().getSerializableExtra("data");
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("数据服务")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
}
