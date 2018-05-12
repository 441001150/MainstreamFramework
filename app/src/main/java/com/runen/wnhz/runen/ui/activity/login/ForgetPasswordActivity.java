package com.runen.wnhz.runen.ui.activity.login;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-10.
 */

public class ForgetPasswordActivity extends BaseActivity {
    

    private ImageView iv_back;

    private EditText et_input_phone;

    private EditText et_input_vcode;

    private EditText et_input_password;

    private EditText et_input_new_password;

    private TextView tv_forget_submit;

    private TextView tv_get_vcode;

    @Override
    protected int getLayoutView() {
        return R.layout.forget_password_activity_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {

    }

    @Override
    protected void initStart() {

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }

}
