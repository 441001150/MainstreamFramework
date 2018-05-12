package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.UcenterEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerMineComponent;
import com.runen.wnhz.runen.di.module.MineModule;
import com.runen.wnhz.runen.presenter.Contart.MineContart;
import com.runen.wnhz.runen.presenter.iPresenter.IMinePersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-12.
 */

public class BalanceActivity extends BaseActivity<IMinePersenter> implements MineContart.View, View.OnClickListener{
    
    @BindView(R.id.tv_play)
    TextView tv_play;    
    
    @BindView(R.id.tv_user_money)
    TextView tv_user_money;
    
    @BindView(R.id.et_money)
    EditText et_money;    
    
    @BindView(R.id.ry_select_money)
    RecyclerView ry_select_money;
    
    private UserBean reqeustUser;

    @Override
    protected int getLayoutView() {
        return R.layout.balance_activity_layout;
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
        //获取余额
        initOnClick();
    }

    @Override
    public void initPresente() {
        super.initPresente();
        mPresenter.requesetUserMone();
        /*获取充值列表*/
        mPresenter.reqeustUserMoneList();
    }

    private void initOnClick() {
        tv_play.setOnClickListener(this);
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("我的余额")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
    }
    
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent){
        DaggerMineComponent.builder().applicationComponent(appComponent)
                .mineModule(new MineModule(this))
                .build().initject(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_play:
                //调用第三方接口
                break;
        }
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
    public String getToken() {
        return reqeustUser.getToken();
    }

    @Override
    public void showMon(String data) {
        tv_user_money.setText(data);
    }

    @Override
    public void getRequstErrorList(String info) {
        ToastUtil.showToast(info);
        //显示没有数据这一个界面
    }

    @Override
    public void getrequest(List<UcenterEntity> data) {

    }
}
