package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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

public class PersonalDataActivity extends BaseActivity<IPersonal> implements  PersonalContart.View ,View.OnClickListener {

    @BindView(R.id.rb_man)
    RadioButton rb_man;

    @BindView(R.id.rb_woman)
    RadioButton rb_woman;

    @BindView(R.id.et_school)
    EditText et_school;

    @BindView(R.id.et_place)
    EditText et_place;

    @BindView(R.id.tv_personal_save)
    TextView tv_personal_save;

    PersonalEntity entity;
    UserBean reqeustUser;


    private String sex;

    @Override
    protected int getLayoutView() {
        return R.layout.personal_data_activity_layout;
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


        initGetUserMessage();

        initOnClick();


    }

    private void initGetUserMessage() {
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getUserMessage();
    }

    private void initOnClick() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
        tv_personal_save.setOnClickListener(this);
        rb_man.setOnClickListener(this);
        rb_woman.setOnClickListener(this);

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("个人资料")
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_personal_save:
                //修改状态
                mPresenter.setUserData();
                break;
            case R.id.rb_man:
                sex = "1";
                break;
            case R.id.rb_woman:
                sex = "2";
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
        entity = data;
        switch (data.getSex()){
            case "1":
                rb_man.setChecked(true);
                rb_woman.setChecked(false);
                break;
            case "2":
                rb_woman.setChecked(true);
                rb_man.setChecked(false);
                break;
            default:
                ToastUtil.showToast("未知错误");
                break;
        }
        et_school.setText(data.getSchool());
        et_place.setText(data.getPlace());
    }

    @Override
    public String getNickName() {
        return entity.getUsername();
    }

    @Override
    public String getSex() {
        if (TextUtils.isEmpty(sex)){
            sex = entity.getSex();
        }
        return sex;
    }

    @Override
    public String getSchool() {
        return et_school.getText().toString().trim();
    }

    @Override
    public String getPlace() {
        return et_place.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return entity.getPassword();
    }

    @Override
    public String getHedimg() {
        return entity.getHead_img();
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
