package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-04-11.
 */

public class EditAddressActivity extends BaseActivity implements  View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private RelativeLayout rl_select_address;

    private TextView tv_select_address;

    private TextView tv_save_address;

    private Switch sw_default_address;

    private EditText et_name;

    private EditText et_phone;

    private EditText et_address;

    private String isDefault = "1";

    private ArrayList<String> citys = new ArrayList<>();

    String consignee;

    String telephone;

    String province;

    String city;

    String county;

    String place;

    String moren;

    String aid;

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
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("编辑收货地址")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
    

 /*   @Override
    public void initUiAndListener() {
        Intent intent = getIntent();
        consignee = intent.getStringExtra("consignee");
        telephone = intent.getStringExtra("telephone");
        province = intent.getStringExtra("province");
        city = intent.getStringExtra("city");
        county = intent.getStringExtra("county");
        place = intent.getStringExtra("place");
        moren = intent.getStringExtra("moren");
        aid = intent.getStringExtra("aid");
        PickerViewUtils.initJsonData(mContext);
        initView();
    }*/

 /*   private void initView() {
        rl_select_address = findViewById(R.id.rl_select_address);
        tv_select_address = findViewById(R.id.tv_select_address);
        tv_save_address = findViewById(R.id.tv_save_address);
        sw_default_address = findViewById(R.id.sw_default_address);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_address = findViewById(R.id.et_address);

        rl_select_address.setOnClickListener(this);
        tv_save_address.setOnClickListener(this);
        sw_default_address.setOnCheckedChangeListener(this);


        if (StringUtils.isNotEmpty(consignee)) {
            et_name.setText(consignee);
            et_name.setSelection(consignee.length());
        }
        if (StringUtils.isNotEmpty(telephone)) {
            et_phone.setText(telephone);
            et_phone.setSelection(telephone.length());
        }
        if (StringUtils.isNotEmpty(province) && StringUtils.isNotEmpty(city) && StringUtils.isNotEmpty(county)) {
            tv_select_address.setText(province + " " + city + " " + county);
        }

        if (StringUtils.isNotEmpty(place)) {
            et_address.setText(place);
            et_address.setSelection(place.length());
        }
        if (StringUtils.isNotEmpty(moren)) {
            if ("1".equals(moren)) {
                sw_default_address.setChecked(false);
            } else if ("2".equals(moren)) {
                sw_default_address.setChecked(true);
            }
        }


    }*/

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.sw_default_address) {
            if (isChecked) {
                isDefault = "2";
            } else {
                isDefault = "1";
            }
        }
    }

    @Override
    public void onClick(View view) {
        
    }
}
