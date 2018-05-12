package com.runen.wnhz.runen.ui.activity.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.activity.mine.MineFragment;
import com.runen.wnhz.runen.ui.fragment.major.MajorFragment;
import com.runen.wnhz.runen.ui.fragment.publicm.PublicFragment;
import com.runen.wnhz.runen.ui.fragment.minem.HomeFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    
    //fragment管理
    FragmentTransaction transaction;
    //四个fragment
    HomeFragment homeFragment;
    MajorFragment majorFragment;
    PublicFragment publicFragment;
    MineFragment mineFragment;
    //当前存在的fragment
    Fragment mCurrentFragment;
    
    @BindView(R.id.rb_home)
    RadioButton rb_home;   
    @BindView(R.id.rb_major)
    RadioButton rb_major;   
    @BindView(R.id.rb_public)
    RadioButton rb_public;   
    @BindView(R.id.rb_mine)
    RadioButton rb_mine;    
    @BindView(R.id.iv_ar)
    ImageView iv_ar;
    
    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
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
        initLinseter();
        addFragmentToStack(0);
    }


    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        
    }


    private void initLinseter() {
        
        rb_home.setOnClickListener(this);
        rb_major.setOnClickListener(this);
        rb_public.setOnClickListener(this);
        rb_mine.setOnClickListener(this);
        iv_ar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_home:
                addFragmentToStack(0);
                break;
            case R.id.rb_major:
                addFragmentToStack(1);
                break;
            case R.id.rb_public:
                addFragmentToStack(2);
                break;
            case R.id.rb_mine:
                addFragmentToStack(3);
                break;
            case R.id.iv_ar:
                ToastUtil.showToast("等待第三方接口");
                break;
            default:
                ToastUtil.showToast("App未知错误");
                break;
        }
    }

    // 切换fragment
    private void addFragmentToStack(int currSel) {
        transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (currSel) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.ll_fragment_container, homeFragment, HomeFragment.TAG);
                } else {
                    transaction.show(homeFragment);
                }
                mCurrentFragment = homeFragment;
                break;
            case 1:
                if (majorFragment == null) {
                    majorFragment = new MajorFragment();
                    transaction.add(R.id.ll_fragment_container, majorFragment, MajorFragment.TAG);
                } else {
                    transaction.show(majorFragment);
                }
                mCurrentFragment = majorFragment;
                break;
            case 2:
                if (publicFragment == null) {
                    publicFragment = new PublicFragment();
                    transaction.add(R.id.ll_fragment_container, publicFragment, PublicFragment.TAG);
                } else {
                    transaction.show(publicFragment);
                }
                mCurrentFragment = publicFragment;
                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.ll_fragment_container, mineFragment, MineFragment.TAG);
                } else {
                    transaction.show(mineFragment);
                }
                mCurrentFragment = mineFragment;
                break;
            default:
                break;
        }

        transaction.commitAllowingStateLoss();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (majorFragment != null) {
            transaction.hide(majorFragment);
        }
        if (publicFragment != null) {
            transaction.hide(publicFragment);
        }

        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    public void goToPublicFragment() {
        transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);

        if (publicFragment == null) {
            publicFragment = new PublicFragment();
            transaction.add(R.id.ll_fragment_container, publicFragment, PublicFragment.TAG);
        } else {
            transaction.show(publicFragment);
        }
        mCurrentFragment = publicFragment;
        transaction.commitAllowingStateLoss();
    }

    @Subscriber(tag = "shopType")
    public void selectTab(String id) {
        rb_public.toggle();
    }
    
}
