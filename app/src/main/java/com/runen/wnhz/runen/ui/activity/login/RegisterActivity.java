package com.runen.wnhz.runen.ui.activity.login;
import android.graphics.Paint;
import android.os.Bundle;
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

import static com.runen.wnhz.runen.R.id.tv_register;

/**
 * Created by Administrator on 2018-04-09.
 */

public class RegisterActivity extends BaseActivity<ILoginPersenter> implements LoginContart.View, View.OnClickListener{
    
    //跳过
    @BindView(R.id.tv_skip)
    TextView tv_skip;
    
    //返回
    @BindView(R.id.iv_back)
    ImageView iv_back;

    //获取验证码 
    @BindView(R.id.tv_v_code)
    TextView tv_v_code;
    
    @BindView(R.id.et_input_phone)
    EditText et_input_phone; //手机号码

    @BindView(R.id.et_input_vcode)
    EditText et_input_vcode; //验证码

    @BindView(R.id.et_input_password)
    EditText et_input_password; //密码

    @BindView(tv_register)
    TextView tv_login;//登录按钮

    @BindView(R.id.tv_agreement)
    TextView tv_agreement;

    @BindView(R.id.iv_agreement)
    ImageView imageView;

    private boolean agree = false;
    
    @Override
    protected int getLayoutView() {
        return R.layout.register_activity_layout;
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
        tv_login.setOnClickListener(this);
    }

    @Override
    public void initPresente() {
        tv_skip.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        tv_v_code.setOnClickListener(this);
        tv_agreement.setOnClickListener(this);
        imageView.setOnClickListener(this);
        tv_agreement.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG); //下划线
        tv_agreement.getPaint().setAntiAlias(true);  //抗锯齿

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
                .build().initject(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_skip:
                ACacheUtlis.getInstance().IsFirstToApp(this, Constants.ISFIRSTOAPP);
                JumpUtlis.getInstance().jumpActivity(this, MainActivity.class);
                break;    
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_v_code:
                //获取验证码
                mPresenter.requestMSN();
                break;   
            case R.id.tv_register:
                if (agree){
                    mPresenter.requestResgist(); 
                } else {
                    ToastUtil.showToast("同意服务协议之后才可以注册");
                }
                
                break;
            case R.id.tv_agreement:

                JumpUtlis.getInstance().jumpActivity(this,WebViewActivity.class);
                break;
            case R.id.iv_agreement:
                if (agree) {
                    imageView.setImageResource(R.mipmap.icon_unselected);
             /*       Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.icon_unselected);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tv_agreement.setCompoundDrawables(drawable, null, null, null);*/
                    agree = !agree;
                } else {
                    imageView.setImageResource(R.mipmap.icon_selected);
                /*    Drawable drawable = ContextCompat.getDrawable(this, R.mipmap.icon_selected);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tv_agreement.setCompoundDrawables(drawable, null, null, null);*/
                    agree = !agree;
                }
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
        ToastUtil.showToast(msg);
    }

    @Override
    public String mobile() {
        return et_input_phone.getText().toString().trim();
    }

    @Override
    public void mMobileError() {
        ToastUtil.showToast("手机号不能为空");
    }

    @Override
    public String verify() {
        return et_input_vcode.getText().toString().trim();
    }

    @Override
    public String type() {
        return "1";
    }

    @Override
    public void showSend(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public TextView getTextSendOut() {
        return tv_v_code;
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

        //里面缓存数据数据
    }

    @Override
    public String getResterPhone() {
        return et_input_phone.getText().toString().trim();
    }

    @Override
    public String getResterSendOut() {
        return et_input_vcode.getText().toString().trim();
    }

    @Override
    public String getResterPassWord() {
        return et_input_password.getText().toString().trim();
    }
    
    @Override
    public void showJump(String msg) {
        ToastUtil.showToast(msg);
        JumpUtlis.getInstance().jumpActivity(this,LoginForPersonalActivity.class);
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

    }
}
