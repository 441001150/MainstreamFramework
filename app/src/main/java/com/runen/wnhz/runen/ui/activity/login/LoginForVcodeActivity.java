package com.runen.wnhz.runen.ui.activity.login;

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

public class LoginForVcodeActivity extends BaseActivity {


    private ImageView iv_back;

    private EditText et_input_phone;

    private EditText et_input_vcode;

    private TextView tv_get_vcode;

    private TextView tv_login;

    @Override
    protected int getLayoutView() {
        return R.layout.login_for_vcode_activty_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {

    }

    @Override
    protected void initStart() {

    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {

    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }

}
