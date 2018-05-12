package com.runen.wnhz.runen.ui.activity.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.Constants;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerLoginComponent;
import com.runen.wnhz.runen.di.module.LoginModule;
import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import com.runen.wnhz.runen.presenter.iPresenter.ILoginPersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.activity.main.MainActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-27.
 * 忘记密码
 */

public class ForgetActivity extends BaseActivity<ILoginPersenter> implements LoginContart.View,View.OnClickListener {
    
    @BindView(R.id.iv_back)
    ImageView iv_back;
    
    /*手机*/
    @BindView(R.id.et_forget_input_phone)
    EditText et_forget_input_phone;   
    /*验证码*/
    @BindView(R.id.et_forget_input_vcode)
    EditText et_forget_input_vcode;    
    /*第一次密码*/
    @BindView(R.id.et_forget_newpassword)
    EditText et_forget_newpassword;    
    /*确认密码*/
    @BindView(R.id.et_forget_querpassword)
    EditText et_forget_querpassword;    
    
    /*登陆*/
    @BindView(R.id.tv_forget_login)
    TextView tv_forget_login;    
    
    /*获取验证码*/
    @BindView(R.id.tv_forget_v_code)
    TextView tv_forget_v_code;
    
    
    
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_forget_v_code:  //获取验证码
                mPresenter.requestMSN();
                break;  
            case R.id.tv_forget_login:  //登陆 
                mPresenter.requesteForget();
                break;
        }
        
    }
    
    @Override
    protected int getLayoutView() {
        return R.layout.activity_forget;
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
        iv_back.setOnClickListener(this);
        tv_forget_v_code.setOnClickListener(this);
        tv_forget_login.setOnClickListener(this);
        
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerLoginComponent.builder()
                .applicationComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build().initJect(this);
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
    public String mobile() {
        return et_forget_input_phone.getText().toString();
    }

    @Override
    public void mMobileError() {

    }

    @Override
    public String verify() {
        return null;
    }

    @Override
    public String type() {
        return "2";
    }

    @Override
    public void showSend(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public TextView getTextSendOut() {
        return tv_forget_v_code;
    }

    @Override
    public String mobiLogName() {
        return null;
    }

    @Override
    public String mobiLogPass() {
        return null;
    }

    @Override
    public void showLoginErrorMsg(String msg) {

    }

    @Override
    public void saveUserBean(UserBean data) {

    }

    @Override
    public String getResterPhone() {
        return null;
    }

    @Override
    public String getResterSendOut() {
        return null;
    }

    @Override
    public String getResterPassWord() {
        return null;
    }

    @Override
    public void showJump(String msg) {

    }

    @Override
    public Bundle getBundle() {
        return null;
    }

    @Override
    public String getVerifPhone() {
        return null;
    }

    @Override
    public String getVerifCode() {
        return null;
    }

    @Override
    public void saveVerifData(UserBean data) {

    }

    @Override
    public String getForgetPhone() {
        return et_forget_input_phone.getText().toString().trim();
    }

    @Override
    public String getForgetPass() {
        return et_forget_newpassword.getText().toString().trim();
    }

    @Override
    public String getForgetNewPass() {
        return et_forget_querpassword.getText().toString().trim();
    }

    @Override
    public String getForgetCode() {
        return et_forget_input_vcode.getText().toString().toString();
    }

    @Override
    public void saveForData(UserBean data) {
        //保存数据  直接跳转到首页
        if (data != null){
            ACacheUtlis.getInstance().IsFirstToApp(this, Constants.ISFIRSTOAPP);
            ACacheUtlis.getInstance().IsRequstUser(this,data.getToken(),data.getUsername(),data.getHead_img());
            JumpUtlis.getInstance().jumpActivity(this,MainActivity.class);
        }
    }
}
