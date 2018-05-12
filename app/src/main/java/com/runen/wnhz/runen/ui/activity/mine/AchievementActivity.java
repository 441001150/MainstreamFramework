package com.runen.wnhz.runen.ui.activity.mine;

import android.widget.ImageView;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import android.view.View;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.widget.TitleBuilder;
import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-12.
 */

public class AchievementActivity extends BaseActivity implements View.OnClickListener {
    
    @BindView(R.id.iv_back)
    ImageView iv_back;
    
    @BindView(R.id.tv_test_record)
    TextView tv_test_record;   
    
    @BindView(R.id.tv_errorback) 
    TextView tv_errorback;   
    
    @BindView(R.id.start_text)
    TextView start_text;
    
    @BindView(R.id.tv_examinationDay)
    TextView tv_examinationDay;
    

    @Override
    protected int getLayoutView() {
        return R.layout.achievement_activity_layout;
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
        initOnClick();
        
    }

    private void initOnClick() {
        iv_back.setOnClickListener(this);
        tv_test_record.setOnClickListener(this);
        tv_errorback.setOnClickListener(this);
        start_text.setOnClickListener(this);
        tv_examinationDay.setOnClickListener(this);
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:      //返回
                finish();
                break;
            case R.id.tv_test_record:   //测试记录
                JumpUtlis.getInstance().jumpActivity(this,TestRecordActivity.class);
                break;
            case R.id.tv_errorback:   //错题
                JumpUtlis.getInstance().jumpActivity(this,ErrorBackActivity.class);
                break;   
            case R.id.start_text:   //开始测试
                JumpUtlis.getInstance().jumpActivity(this,StartTestActivity.class);
                break;    
            case R.id.tv_examinationDay:   //剩余天数  接口获取到
                break;
            default:
                break;
        }
    }
}
