package com.runen.wnhz.runen.ui.fragment.minem;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerCourseComponent;
import com.runen.wnhz.runen.di.module.CourseModule;
import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import com.runen.wnhz.runen.ui.adapter.puadapter.CourseAdapter;
import com.runen.wnhz.runen.ui.fragment.BaseFragment;
import com.runen.wnhz.runen.widget.TitleBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-12.
 */

public class LearningFragment extends BaseFragment<ICoursePersenter> implements CourseContart.View,View.OnClickListener {

    @BindView(R.id.rv_message)
    RecyclerView recyclerView;

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    private int page = 0;

    private UserBean reqeustUser;

    private CourseAdapter courseAdapter;

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerCourseComponent.builder().applicationComponent(appComponent)
                .courseModule(new CourseModule(this))
                .build().initject(this);
        
    }

    @Override
    protected int getLayoutView() {
        return R.layout.learning_fragment_layout;
    }

    @Override
    public void initUiAndListener(View view) {
        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(getContext());

    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getContent();
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
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
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public String getType() {
        return "1";
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

        courseAdapter = new CourseAdapter(data.getData().getList(),getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(courseAdapter);
    }

}
