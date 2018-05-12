package com.runen.wnhz.runen.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.runen.wnhz.runen.ui.ActivityManager;
import com.runen.wnhz.runen.ui.BaseApplication;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.activity.main.MainActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
/**
 * Created by Administrator on 2018-04-09.
 * 登陆模块
 */

public class LoginForPersonalActivity extends BaseActivity<ILoginPersenter> implements LoginContart.View, View.OnClickListener{
    @BindView(R.id.tv_skip)
    //跳过
    TextView tv_skip;
    //返回
    @BindView(R.id.iv_back)
    ImageView iv_back;
    //注册
    @BindView(R.id.tv_register)
    TextView tv_register;
    
    //手机号码输入框
    @BindView(R.id.et_input_phone)
    EditText et_input_phone;
    //密码输入框
    @BindView(R.id.et_input_password)
    EditText et_input_password;
    //验证码登陆按钮
    @BindView(R.id.tv_login_verification)
    TextView tv_login_verification;
    //忘记密码按钮
    @BindView(R.id.tv_forget_password)
    TextView tv_forget_password;

    //密码不正确，请重新输入
    @BindView(R.id.tv_pass_error)
    TextView tv_pass_error;


    //登陆按钮
    @BindView(R.id.tv_login)
    TextView tv_login;
    
    //微信登录
    @BindView(R.id.iv_login_wx)
    ImageView iv_login_wx;
    //QQ登陆
    @BindView(R.id.iv_login_qq)
    ImageView iv_login_qq;

    @Override
    protected int getLayoutView() {
        return R.layout.login_for_personal_activty_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        setToolBarVisible(View.GONE);
    }

    @Override
    protected void initStart() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
        //onClick
        initOnClick();
    }

    private void initOnClick() {
        tv_skip.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_login_verification.setOnClickListener(this);
        tv_forget_password.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        iv_login_wx.setOnClickListener(this);
        iv_login_qq.setOnClickListener(this);
        
        
    }


    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerLoginComponent.builder().applicationComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build().initJect(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_skip:
                ACacheUtlis.getInstance().IsFirstToApp(this, Constants.ISFIRSTOAPP);
                JumpUtlis.getInstance().jumpActivity(this, MainActivity.class);
                break;
            case R.id.iv_back:
                ActivityManager.getAppManager().finishActivity(this);
                break;
            case R.id.tv_register:
                //跳转到注册页面
                Bundle bundle = getIntent().getBundleExtra("bundle");
                Intent intent = new Intent(this, RegisterActivity.class);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
                break;
            case R.id.tv_login_verification:
                JumpUtlis.getInstance().jumpActivity(this,VerificationActivity.class);
                break;      
            case R.id.tv_forget_password:
                JumpUtlis.getInstance().jumpActivity(this,ForgetActivity.class);
                break;          
            case R.id.tv_login:
                
                mPresenter.requesteName();
                break;    
            case R.id.iv_login_wx:

                //启动第三方SDK   第一个可以使用register_newNumber, 使用简单的dloag 实现
                if (!BaseApplication.mWxApi.isWXAppInstalled()) {
                    ToastUtil.showToast("您还未安装微信客户端");
                    return;
                }
                //跳转到界面中去
                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "wechat_sdk_demo_test";
                BaseApplication.mWxApi.sendReq(req);
                break;     
            case R.id.iv_login_qq:
                ToastUtil.showToast("Qq登陆");
                break;
            default:
                ToastUtil.showToast("未知错误");
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
    public String mobile() {
        return null;
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
        return null;
    }

    @Override
    public void showSend(String msg) {

    }

    @Override
    public TextView getTextSendOut() {
        return null;
    }

    @Override
    public String mobiLogName() {
        return et_input_phone.getText().toString().trim();
    }

    @Override
    public String mobiLogPass() {
        return et_input_password.getText().toString().trim();
    }

    @Override
    public void showLoginErrorMsg(String msg) {
        tv_login_verification.setVisibility(View.GONE);
        tv_pass_error.setVisibility(View.VISIBLE);
        tv_pass_error.setTextColor(getResources().getColor(R.color.text_orange));
        tv_pass_error.setText(msg);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                tv_login_verification.setVisibility(View.VISIBLE);
                tv_pass_error.setVisibility(View.GONE);
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void saveUserBean(UserBean data) {
        if (data != null){
            ACacheUtlis.getInstance().IsFirstToApp(this, Constants.ISFIRSTOAPP);
            ACacheUtlis.getInstance().IsRequstUser(this,data.getToken(),data.getUsername(),data.getHead_img());
            JumpUtlis.getInstance().jumpActivity(this,MainActivity.class);
        } 
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
        return getIntent().getBundleExtra("bundle");
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
        return null;
    }

    @Override
    public String getForgetPass() {
        return null;
    }

    @Override
    public String getForgetNewPass() {
        return null;
    }

    @Override
    public String getForgetCode() {
        return null;
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
