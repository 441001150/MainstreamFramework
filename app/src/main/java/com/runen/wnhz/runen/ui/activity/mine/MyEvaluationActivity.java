package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;
import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-12.
 */

public class MyEvaluationActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected int getLayoutView() {
        return R.layout.my_evaluation_activity_layout;
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
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("题库").setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }
}
