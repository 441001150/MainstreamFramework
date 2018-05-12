package com.runen.wnhz.runen.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.ui.BaseApplication;
import com.runen.wnhz.runen.ui.BaseView;
import com.runen.wnhz.runen.widget.TitleBuilder;

import org.simple.eventbus.EventBus;

import java.lang.reflect.Field;

import javax.inject.Inject;

import butterknife.ButterKnife;


public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView, TitleBuilder.TitleBuilderListener {

    protected Context mContext;

    protected View mRootView;

    @Inject
    protected T mPresenter;

    public FrameLayout mTitle_container;

    public TitleBuilder mTitleBuilder;  //标题

    private BaseApplication mApplication;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    //当activity启动时候，他进行调用的
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mApplication = (BaseApplication) getActivity().getApplication();
        setupAcitivtyComponent(mApplication.getAppComponent());
        init();

    }

    protected void init(){
        
    }
    
    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     
            if (null == mRootView) {
               
                // 总布局
                int rootViewId = getLayoutView();
                this.mContext = getActivity();
                mRootView = inflater.inflate(R.layout.activity_title_bar, container, false);
                mTitle_container = (FrameLayout) mRootView.findViewById(R.id.title_container);
                setContent(rootViewId);
                //这里里面进行butterkin 注入
                initTitle();
                if (useEventBus()) {
                    EventBus.getDefault().register(this);
                }
                initUiAndListener(mRootView);
                baseInit();
            } else {
                ViewGroup parent = (ViewGroup) mRootView.getParent();
                if (null != parent) {
                    parent.removeView(mRootView);
                }
            }
        ButterKnife.bind(this,mRootView);
        return mRootView;
    }
    
    private void setContent(int resID) {
        View content_view = getActivity().getLayoutInflater().inflate(resID, null);
        mTitle_container.addView(content_view);
    }

    private void initTitle() {
        mTitleBuilder = new TitleBuilder(getActivity());
        mTitleBuilder.initBar(mRootView.findViewById(R.id.id_title_bar));
        mTitleBuilder.setTitleBuilderListener(this);
        initToolBar(mTitleBuilder);
    }

    /**
     * 设置title是否可见  默认是可见状态
     *
     * @param visible
     */
    public void setToolBarVisible(int visible) {
        mRootView.findViewById(R.id.id_title_bar).setVisibility(visible);
    }

    public abstract  void setupAcitivtyComponent(ApplicationComponent appComponent);


    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /****************
     * begain  网络请求相关
     ***************/
    private KProgressHUD hud;

    /****************end dagger相关***************/

    protected abstract int getLayoutView();

    /**
     * 供子类初始化一些配置，包括dagger等东西
     *
     * @return
     */
    protected void baseInit() {

    }

    /**
     * init UI && Listener
     */
    public abstract void initUiAndListener(View view);

    /**
     * 子类设置标题
     *
     * @param mTitleBuilder
     */
    public abstract void initToolBar(TitleBuilder mTitleBuilder);
    
    @Override
    public void onResume() {
        super.onResume();
        Log.e("fragment1", this.getClass().getSimpleName() + "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        Log.e("fragment1", this.getClass().getSimpleName() + "onDestroyOptionsMenu");
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    protected boolean useEventBus() {
        return true;
    }
}
