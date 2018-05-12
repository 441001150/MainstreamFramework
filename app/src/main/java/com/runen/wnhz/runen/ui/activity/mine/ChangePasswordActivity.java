package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerPersonalComponent;
import com.runen.wnhz.runen.di.module.PersonalModule;
import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.io.File;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class ChangePasswordActivity extends BaseActivity<IPersonal> implements PersonalContart.View,View.OnClickListener {


    @BindView(R.id.et_change_password)
    EditText et_change_password;


    private UserBean reqeustUser;
    PersonalEntity personalEntity;

    @Override
    protected int getLayoutView() {
        return R.layout.change_password_activity_layout;
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
                //修改密码
                mPresenter.setUpdatePass();
                break;
            default:
                break;
        }
    }

    @Override
    protected void initStart() {
        initGetUserMessage();
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
    }

    private void initGetUserMessage() {
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getUserMessage();

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("修改密码")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setRightText("保存")
                .setRightTextColor(ContextCompat.getColor(this, R.color.text_white))
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }
    
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

        DaggerPersonalComponent.builder().applicationComponent(appComponent)
                .personalModule(new PersonalModule(this))
                .build().inject(this);
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
        ToastUtil.showToast(msg);
    }

    @Override
    public String getToken() {
        return reqeustUser.getToken();
    }

    @Override
    public void setLogin(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void setErrorMessage(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void getUserMessage(PersonalEntity data) {
        personalEntity = data;
        et_change_password.setText(personalEntity.getPassword());
    }

    @Override
    public String getNickName() {
        return null;
    }

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public String getSchool() {
        return null;
    }

    @Override
    public String getPlace() {
        return null;
    }

    @Override
    public String getPassword() {
        return et_change_password.getText().toString();
    }

    @Override
    public String getHedimg() {
        return null;
    }

    @Override
    public void setSuccess(String info) {
        ToastUtil.showToast(info);
        this.finish();
    }

    @Override
    public void setSuccess(UploadImgEntity info) {

    }

    @Override
    public File getFile() {
        return null;
    }
}
