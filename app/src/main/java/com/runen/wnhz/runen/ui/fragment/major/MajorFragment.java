package com.runen.wnhz.runen.ui.fragment.major;

import android.view.View;
import android.widget.RelativeLayout;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-08.
 */

public class MajorFragment extends BaseFragment implements View.OnClickListener {
    
    public static final String TAG = "MajorFragment";
    
    @BindView(R.id.rl_professional)  //专业
    RelativeLayout rl_professional;   
    
    @BindView(R.id.rl_publics)      //公共
    RelativeLayout rl_publics;    
    
    @BindView(R.id.rl_project)      //项目
    RelativeLayout rl_project;

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.major_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {
        initView(view);
    }


    @Override
    protected void init() {
        super.init();
        //设置点击事件
        initOnClick();
    }

    private void initOnClick() {
        rl_professional.setOnClickListener(this);
        rl_publics.setOnClickListener(this);
        rl_project.setOnClickListener(this);
        
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }
    
    private void initView(View view){
    }

    @Override
    public void showLoadding() {
        
    }

    @Override
    public void dimissLoding() {

    }

    @Override
    public void showErrorMessage(String msg) {
        
    }
    

    @Override
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {

    }

    
    /* 项目管理 和 公众课程跳转到一样adapter  而专业课程直接跳转到带着播放器的界面*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_professional:
                //跳转到详情界面
            
                break;   
            case R.id.rl_publics:
                
                break;    
            case R.id.rl_project:
                break;
        }
    }
}
