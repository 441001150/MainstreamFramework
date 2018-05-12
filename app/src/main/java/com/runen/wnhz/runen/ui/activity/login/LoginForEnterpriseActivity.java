package com.runen.wnhz.runen.ui.activity.login;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;
import butterknife.BindView;
/**
 * Created by Administrator on 2018-04-09.
 */

public class LoginForEnterpriseActivity extends BaseActivity implements View.OnClickListener {
    
    @BindView(R.id.iv_back)
    ImageView iv_back;
    
    @BindView(R.id.tv_forenterpr_next)
    TextView tv_forenterpr_next;    
    
    @BindView(R.id.et_input_phone)
    EditText et_input_phone;    
    
    @BindView(R.id.et_input_password)
    EditText et_input_password;

    @Override
    protected int getLayoutView() {
        return R.layout.login_for_enterprise_activty_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        setToolBarVisible(View.GONE);
    }

    @Override
    protected void initStart() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);
        initView();
    }


    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }

    private void initView() {
        iv_back.setOnClickListener(this);
        tv_forenterpr_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_forenterpr_next:
                if (TextUtils.isEmpty(et_input_phone.getText().toString().trim())){
                    ToastUtil.showToast("城市编码不能为空");
                } else if (TextUtils.isEmpty(et_input_password.getText().toString().trim())){
                    ToastUtil.showToast("企业识别码不能为空");
                } else {
                    Intent intent = new Intent(this, LoginForPersonalActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("city_code", et_input_phone.getText().toString().trim());
                    bundle.putString("company_code",et_input_password.getText().toString().trim());
                    intent.putExtra("bundle",bundle);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
    
}
