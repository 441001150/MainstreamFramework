package com.runen.wnhz.runen.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.ui.ActivityManager;
import com.runen.wnhz.runen.ui.BaseApplication;
import com.runen.wnhz.runen.widget.TitleBuilder;
import org.simple.eventbus.EventBus;
import javax.inject.Inject;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.runen.wnhz.runen.R.id.id_title_bar;

/**
 * Created by saky on 2016/7/6.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity
        implements TitleBuilder.TitleBuilderListener {

    public TitleBuilder mTitleBuilder;  //标题
    
    @Inject
    protected T mPresenter; //泛型 presenter
    
    private FrameLayout mTitle_container;
    
    public String TAG = "Run---->";

    private Unbinder mUnbinder;

    private long exitTime = 0;
    
    private View rootView;
    
    private BaseApplication mBaseApplication;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, getPackageName().getClass().getName() + "onCreate");
        ActivityManager.getAppManager().addActivity(this);
        this.mBaseApplication = (BaseApplication) getApplication();
        setupAcitivtyComponent(mBaseApplication.getAppComponent());
        initView();
        initTitle();
        initStart();
        initPresente();
    }

    private void initView() {
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        // 总布局
        int rootViewId = getLayoutView();
        setContentView(R.layout.activity_title_bar);
        mTitle_container = (FrameLayout) findViewById(R.id.title_container);
        rootView = findViewById(R.id.base_rootView);
        setContent(rootViewId);
        mUnbinder = ButterKnife.bind(this);
    }
    
    private void initTitle() {
        mTitleBuilder = new TitleBuilder(BaseActivity.this);
        mTitleBuilder.initBar(rootView.findViewById(id_title_bar));
        mTitleBuilder.setTitleBuilderListener(this);
        initToolBar(mTitleBuilder);
    }
    
    private void setContent(int resID) {
        View content_view = getLayoutInflater().inflate(resID, null);
        mTitle_container.addView(content_view);
    }

    /**
     * 设置title是否可见  默认是可见状态
     *
     * @param visible
     */
    public void setToolBarVisible(int visible) {
        findViewById(id_title_bar).setVisibility(visible);
    }
    
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, getPackageName().getClass().getName() + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, getPackageName().getClass().getName() + "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, getPackageName().getClass().getName() + "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, getPackageName().getClass().getName() + "onPause");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getAppManager().finishActivity(this);
        Log.e(TAG, getPackageName().getClass().getName() + "onDestroy");
        if(mUnbinder !=Unbinder.EMPTY){
            mUnbinder.unbind();
        }
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        Runtime.getRuntime().gc();
      
    }
    /**进度条*/
    private KProgressHUD hud;

    protected abstract int getLayoutView();

    protected abstract void onTitleClickListen(TitleBuilder.TitleButton clicked);

    /**
     * 供子类初始化一些配置
     *
     * @return
     */
    protected abstract void initStart();

    /**
     * 子类设置标题
     *
     * @param mTitleBuilder
     */
    public abstract void initToolBar(TitleBuilder mTitleBuilder);

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    protected boolean useEventBus() {
        return true;
    }
    
    
    public void initPresente(){
        
    }
    
     /**
     *   注入获取Application
     */
    public abstract  void setupAcitivtyComponent(ApplicationComponent appComponent);
    
    
    @Override
    public void onTitleButtonClicked(TitleBuilder.TitleButton clicked) {
        onTitleClickListen(clicked);
    }

    
    
    /*这种效率最高*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {

            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000  
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else
            {
                ActivityManager.getAppManager().finishAllActivity();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
