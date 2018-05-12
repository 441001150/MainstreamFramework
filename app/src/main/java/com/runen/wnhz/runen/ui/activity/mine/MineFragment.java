package com.runen.wnhz.runen.ui.activity.mine;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.GlideCircleTransform;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.data.entity.MineFragmentBean;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.login.LoginForPersonalActivity;
import com.runen.wnhz.runen.ui.adapter.puadapter.MineFragmentAdapter;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import java.util.ArrayList;

import static android.R.attr.path;

/**
 * Created by Administrator on 2018-04-08.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    public static final String TAG = "MineFragment";

    private ListView lv_mine_list;

    private MineFragmentAdapter adapter;

    private ArrayList<MineFragmentBean> mDatas = new ArrayList<>();

    private View mHeadView;

    private TextView tv_nick_name;

    private ImageView iv_mine_touxiang;
    
    private LinearLayout mine_head_image;
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.mine_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar((Activity) getContext(),R.color.person);
        initHeadView();
        initView(view);
        initDatas();
        initAdapter();

        lv_mine_list.addHeaderView(mHeadView);
        lv_mine_list.setAdapter(adapter);
        
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

  private void initAdapter() {
        adapter = new MineFragmentAdapter(mContext, mDatas);
    }

    private void initDatas() {

        MineFragmentBean mineFragmentBean1 = new MineFragmentBean("我的测评", R.mipmap.icon_wodeceping);
        MineFragmentBean mineFragmentBean2 = new MineFragmentBean("我的课程", R.mipmap.icon_wodekecheng);
        MineFragmentBean mineFragmentBean3 = new MineFragmentBean("我的收藏", R.mipmap.icon_wodeshoucang);
        MineFragmentBean mineFragmentBean4 = new MineFragmentBean("我的余额", R.mipmap.icon_wodeyue);
        MineFragmentBean mineFragmentBean5 = new MineFragmentBean("消息中心", R.mipmap.icon_xiaoxizhongxin);
        MineFragmentBean mineFragmentBean6 = new MineFragmentBean("我的订单", R.mipmap.icon_wodedingdan);
        MineFragmentBean mineFragmentBean7 = new MineFragmentBean("收货地址", R.mipmap.icon_shouhuodizhi);
        MineFragmentBean mineFragmentBean8 = new MineFragmentBean("个人中心", R.mipmap.icon_gerenzhongxin);
        MineFragmentBean mineFragmentBean9 = new MineFragmentBean("意见反馈", R.mipmap.icon_yijianfankui);
        MineFragmentBean mineFragmentBean10 = new MineFragmentBean("账号设置", R.mipmap.icon_zhanghaoshezhi);

        mDatas.add(mineFragmentBean1);
        mDatas.add(mineFragmentBean2);
        mDatas.add(mineFragmentBean3);
        mDatas.add(mineFragmentBean4);
        mDatas.add(mineFragmentBean5);
        mDatas.add(mineFragmentBean6);
        mDatas.add(mineFragmentBean7);
        mDatas.add(mineFragmentBean8);
        mDatas.add(mineFragmentBean9);
        mDatas.add(mineFragmentBean10);
    }

    private void initHeadView() {
        mHeadView = LayoutInflater.from(mContext).inflate(R.layout.mine_fragment_head_view, null);
    }

    private void initView(View view) {
        lv_mine_list = view.findViewById(R.id.lv_mine_list);
        mine_head_image = mHeadView.findViewById(R.id.mine_head_image);
        tv_nick_name = mHeadView.findViewById(R.id.tv_nick_name);
        iv_mine_touxiang = mHeadView.findViewById(R.id.iv_mine_touxiang);
        lv_mine_list.setOnItemClickListener(this);
        UserBean reqeustUser = ACacheUtlis.getInstance().getReqeustUser(getContext());
        if (reqeustUser == null){
            mine_head_image.setOnClickListener(this);
        } else {
            tv_nick_name.setText(reqeustUser.getUsername());
            Glide.with(getContext()).load(reqeustUser.getHead_img()).centerCrop().transform(new GlideCircleTransform(getContext())).into(iv_mine_touxiang);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
          case 1:
                /*我的测评*/
                JumpUtlis.getInstance().jumpActivity(getContext(),MyEvaluationActivity.class);
                break;
            case 2:
                /*我的课程*/
                JumpUtlis.getInstance().jumpActivity(getContext(),ClassCenterActivity.class);
                break;
            case 3:
                /*我的收藏*/
                JumpUtlis.getInstance().jumpActivity(getContext(),MyCollectionActivity.class);
                break;
            case 4:
                /*我的余额*/
                JumpUtlis.getInstance().jumpActivity(getContext(),BalanceActivity.class);
                break;
            case 5:
                /*消息中心*/
                JumpUtlis.getInstance().jumpActivity(getContext(),MessageCenterActivity.class);
                break;
            case 6:
                /*我的订单*/
                JumpUtlis.getInstance().jumpActivity(getContext(),MyOrderActivity.class);
                break;
            case 7:
                /*收货地址*/
                JumpUtlis.getInstance().jumpActivity(getContext(),ReceivingAddressActivity.class);
                break;
            case 8:
                /*个人中心*/
                JumpUtlis.getInstance().jumpActivity(getContext(),PersonalCenterActivity.class);
                break;
            case 9:
                /*意见反馈*/
                JumpUtlis.getInstance().jumpActivity(getContext(),FeedbackActivity.class);
                break;
            case 10:
                /*账号设置*/
                JumpUtlis.getInstance().jumpActivity(getContext(),AccountSettingActivity.class);
                break;
            default:
                break;
        }
    }
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mine_head_image:
                JumpUtlis.getInstance().jumpActivity(getContext(),LoginForPersonalActivity.class);
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
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {

    }
}
