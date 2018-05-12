package com.runen.wnhz.runen.ui.activity.mine;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.data.entity.ReceivingAddressEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerAddressComponent;
import com.runen.wnhz.runen.di.module.AddressModule;
import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.iPresenter.IAddressPersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.adapter.puadapter.ReceivingAdapter;
import com.runen.wnhz.runen.widget.TitleBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-11.
 */

public class ReceivingAddressActivity extends BaseActivity<IAddressPersenter> implements AddressContart.View, View.OnClickListener {
    
    @BindView(R.id.tv_add_address)
    TextView tv_add_address;
    
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smart_refresh_layout;

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private int page = 0;
    
    private UserBean reqeustUser;
    
    
    private ReceivingAdapter receivingAdapter;


    @Override
    protected int getLayoutView() {
        return R.layout.receiving_address_activity_layout;
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
        tv_add_address.setOnClickListener(this);
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getAddressList();
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("收货地址")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerAddressComponent.builder()
                .applicationComponent(appComponent)
                .addressModule(new AddressModule(this))
                .build()
                .initJect(this);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_add_address:
                JumpUtlis.getInstance().jumpActivity(this,AddAddressActivity.class);
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
    public String getPage() {
        return String.valueOf(page);
    }

    @Override
    public void getReceivingRecycler(List<ReceivingAddressEntity> mlist) {
        Log.e("----地址列表", "获取数据成功 " );
        receivingAdapter = new ReceivingAdapter(this,mlist);
        recycler_view.setLayoutManager(new LinearLayoutManager(this)); 
        
        recycler_view.setAdapter(receivingAdapter);
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getAid() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }

    @Override
    public String getprovince() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getCounty() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public String getIsDefault() {
        return null;
    }

    @Override
    public void showJumpToast(String info) {
        
    }

}
