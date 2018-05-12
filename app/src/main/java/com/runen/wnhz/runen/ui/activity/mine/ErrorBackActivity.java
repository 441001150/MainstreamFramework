package com.runen.wnhz.runen.ui.activity.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-26.
 */

public class ErrorBackActivity extends BaseActivity implements View.OnClickListener {
    
    
    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.tv_title)
    TextView tv_title;   
    @BindView(R.id.tv_clear)
    TextView tv_clear;
    
    
    @Override
    protected int getLayoutView() {
        return R.layout.actvitiy_errorback;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
    }

    @Override
    protected void initStart() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
        initOnClick();
        
    }

    private void initOnClick() {
        tv_clear.setOnClickListener(this);
        tv_title.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
        
        
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
/*
*  
* */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break; 
            case R.id.tv_title:
                ToastUtil.showToast("设置title值");
                break; 
            case R.id.tv_clear:
                ToastUtil.showToast("接口掉的清除");
                break;
        }
    }
}
