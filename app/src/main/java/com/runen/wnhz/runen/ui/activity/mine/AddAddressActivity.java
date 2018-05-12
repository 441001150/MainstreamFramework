package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerAddressComponent;
import com.runen.wnhz.runen.di.module.AddressModule;
import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.iPresenter.IAddressPersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class AddAddressActivity extends BaseActivity<IAddressPersenter> implements AddressContart.View,View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    
    @BindView(R.id.rl_select_address)
    RelativeLayout rl_select_address;

    @BindView(R.id.tv_save_address)
    TextView tv_select_address;
    
    @BindView(R.id.sw_default_address)
    Switch sw_default_address;

    @BindView(R.id.et_name)   //收货人地址
    EditText et_name;

    @BindView(R.id.et_phone)   //电话
    EditText et_phone;

    @BindView(R.id.et_address)   //详细地址
     EditText et_address;

    private String isDefault;
    
    private UserBean reqeustUser;  //用户保存的信息

    @Override
    protected int getLayoutView() {
        return R.layout.add_address_activity_layout;
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
        tv_select_address.setOnClickListener(this);
        rl_select_address.setOnClickListener(this);
        sw_default_address.setOnCheckedChangeListener(this);
    }


    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("新增收货地址")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerAddressComponent.builder().applicationComponent(appComponent)
                .addressModule(new AddressModule(this))
                .build().initJect(this);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                isDefault = "2";
            } else {
                isDefault = "1";
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_save_address:
                //新增用户
                mPresenter.setAddress();
                break;
            case R.id.rl_select_address:
                ToastUtil.showToast("三级联动省 市 及");
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
    public String getPage() {
        return null;
    }

    @Override
    public void getReceivingRecycler(List<ReceivingAddressEntity> mlist) {

    }

    @Override
    public String getType() {
        return "1";
    }

    @Override
    public String getAid() {
        return null;
    }

    @Override
    public String getName() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPhone() {
        return et_phone.getText().toString().trim();
    }

    @Override
    public String getprovince() {
        return "测试";
    }

    @Override
    public String getCity() {
        return "测试";
    }

    @Override
    public String getCounty() {
        return "测试";
    }

    @Override
    public String getAddress() {
        return et_address.getText().toString().trim();
    }

    @Override
    public String getIsDefault() {
        Log.e("------+++", isDefault );
        return isDefault;
    }

    @Override
    public void showJumpToast(String info) {
        ToastUtil.showToast(info);
        this.finish();
    }
}
