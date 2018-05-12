package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerFeedComponent;
import com.runen.wnhz.runen.di.module.FeedModule;
import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.presenter.iPresenter.IFeedPersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class FeedbackActivity extends BaseActivity<IFeedPersenter> implements FeedContart.View,View.OnClickListener {

    @BindView(R.id.rb_product)
    RadioButton rb_product;

    @BindView(R.id.rb_function)
    RadioButton rb_function;

    @BindView(R.id.et_content)
    EditText et_content;

    @BindView(R.id.et_phone_or_email)
    EditText et_phone_or_email;

    @BindView(R.id.tv_submit)
    TextView tv_submit;

    private String type;
    
    private UserBean reqeustUser;

    @Override
    protected int getLayoutView() {
        return R.layout.feedback_activity_layout;
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
        initOnClick();
    }

    private void initOnClick() {

        tv_submit.setOnClickListener(this);
        rb_function.setOnClickListener(this);
        rb_product.setOnClickListener(this);
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("意见反馈").setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

        DaggerFeedComponent.builder().applicationComponent(appComponent)
                .feedModule(new FeedModule(this))
                .build().initject(this);
    }
    

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_submit:
                mPresenter.feedbackApi();
                break;
            case R.id.rb_function:
                type = "2";
                break;
            case R.id.rb_product:
                type = "1";
                break;
            default:
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
    public String getType() {
        return type;
    }

    @Override
    public String getContent() {
        return et_content.getText().toString().trim();
    }

    @Override
    public String getTelephone() {
        return et_phone_or_email.getText().toString().trim();
    }

    @Override
    public void showJump(String info) {
        ToastUtil.showToast(info);
        this.finish();
    }
}
