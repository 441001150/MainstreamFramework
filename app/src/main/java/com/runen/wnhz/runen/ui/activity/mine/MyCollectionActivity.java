package com.runen.wnhz.runen.ui.activity.mine;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerCourseComponent;
import com.runen.wnhz.runen.di.module.CourseModule;
import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

/**
 * Created by Administrator on 2018-04-12.
 */

public class MyCollectionActivity extends BaseActivity<ICoursePersenter> implements CourseContart.View,View.OnClickListener {


    private UserBean reqeustUser;

    @Override
    protected int getLayoutView() {
        return R.layout.my_collection_activity_layout;
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
        mPresenter.getUcenter();

    }
    

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("我的收藏")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }
    
    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

        DaggerCourseComponent.builder().applicationComponent(appComponent)
                .courseModule(new CourseModule(this))
                .build().initject(this);
    }


    @Override
    public void onClick(View v) {

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
    public String getType() {
        return null;
    }

    @Override
    public String getPage() {
        return "0";
    }

    @Override
    public String getToken() {
        return reqeustUser.getToken();
    }

    @Override
    public void showLoginError(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void reqeuestData(MyCourseEntity data) {
        ToastUtil.showToast(data.getInfo());
    }
}
