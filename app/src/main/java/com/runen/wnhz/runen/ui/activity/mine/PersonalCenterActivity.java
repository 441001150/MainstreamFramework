package com.runen.wnhz.runen.ui.activity.mine;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.GlideCircleTransform;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
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
import com.runen.wnhz.runen.ui.ActivityManager;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.activity.login.LoginForPersonalActivity;
import com.runen.wnhz.runen.ui.activity.personal.UploadImageActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.io.File;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class PersonalCenterActivity extends BaseActivity<IPersonal> implements PersonalContart.View,View.OnClickListener{
    
    @BindView(R.id.rl_personal_data)
    RelativeLayout rl_personal_data; 
    
    @BindView(R.id.rl_personal_img)
    RelativeLayout rl_personal_img;
    
    @BindView(R.id.rl_change_password)
    RelativeLayout rl_change_password;

    @BindView(R.id.personal_myname)
    RelativeLayout personal_myname;

    @BindView(R.id.tv_phone_num)
    TextView tv_phone_num;

    @BindView(R.id.tv_nick_name)
    TextView tv_nick_name;

    @BindView(R.id.tv_logout)
    TextView tv_logout;


    @BindView(R.id.personal_image)
    ImageView personal_image;

    UserBean reqeustUser;

    @Override
    protected int getLayoutView() {
        return R.layout.personal_center_activity_layout;
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
        initGetUserMessage();
        initOnClick();
    }

    private void initGetUserMessage() {
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getUserMessage();


    }

    private void initOnClick() {
        rl_personal_img.setOnClickListener(this);
        rl_personal_data.setOnClickListener(this);
        tv_logout.setOnClickListener(this);
        rl_change_password.setOnClickListener(this);
        personal_myname.setOnClickListener(this);
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("个人中心")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerPersonalComponent.builder().applicationComponent(appComponent)
                .personalModule(new PersonalModule(this))
                .build().inject(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_personal_img:
                JumpUtlis.getInstance().jumpActivity(this, UploadImageActivity.class);
                break;
            case R.id.rl_personal_data:
                JumpUtlis.getInstance().jumpActivity(this,PersonalDataActivity.class);
                break;
            case R.id.rl_change_password:
                JumpUtlis.getInstance().jumpActivity(this,ChangePasswordActivity.class);
                break;
            case R.id.personal_myname:
                JumpUtlis.getInstance().jumpActivity(this,UpdateNameActivity.class);
                break;
            case R.id.tv_logout:
                //清空所有内容，然后跳转到登陆页面
                mPresenter.setExitLogin();
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
    public void setLogin(String info) {
        ToastUtil.showToast(info);

    }

    @Override
    public void setErrorMessage(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void getUserMessage(PersonalEntity data) {
        Glide.with(this).load(data.getHead_img()).centerCrop().transform(new GlideCircleTransform(this)).into(personal_image);
        //解密手机号码
        tv_phone_num.setText(data.getMobile());
        tv_nick_name.setText(data.getUsername());
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
        return null;
    }

    @Override
    public String getHedimg() {
        return null;
    }

    @Override
    public void setSuccess(String info) {
        ToastUtil.showToast(info);
        JumpUtlis.getInstance().jumpActivity(this,LoginForPersonalActivity.class);
        ActivityManager.getAppManager().finishActivity(this);

    }

    @Override
    public void setSuccess(UploadImgEntity info) {

    }

    @Override
    public File getFile() {
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }
}
