package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.data.entity.UserUcenterEntity;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import com.runen.wnhz.runen.presenter.iPresenter.ISettingPersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-10.
 */

public class AccountSettingActivity extends BaseActivity<ISettingPersenter> implements SettingCotart.View,View.OnClickListener {



    @BindView(R.id.tv_bind_wx)
    TextView tv_bind_wx;
    @BindView(R.id.tv_bind_qq)
    TextView tv_bind_qq;


    @BindView(R.id.sw_auto_play)   //自动播放下一节
    Switch sw_auto_play;

    @BindView(R.id.sw_wap_watch)   //允许在数据流量环境观看
    Switch sw_wap_watch;

    @BindView(R.id.sw_wap_download)   //允许在数据流量环境下载
    Switch sw_wap_download;

    @BindView(R.id.tv_clear_cache)   //清理缓存
    Switch tv_clear_cache;







   private UserBean reqeustUser;


    @Override
    protected int getLayoutView() {
        return R.layout.account_setting_activity_layout;
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
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getUcenter();
    }
    

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("账号设置")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }

    @Override
    public void onClick(View v) {

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
    public void setLoginError(String info) {

    }

    @Override
    public void getUserMessage(UserUcenterEntity data) {
        tv_bind_wx.setText(data.getIs_weixin());
        tv_bind_qq.setText(data.getIs_qq());
    }

    @Override
    public void showUserMessage(String info) {

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getOpenid() {
        return null;
    }

    @Override
    public String getImgUrl() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
