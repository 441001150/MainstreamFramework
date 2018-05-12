package com.runen.wnhz.runen.ui.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * NAME：薛世杰
 * DATE：2018/5/3
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_webview;
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
        webview.loadUrl("http://runen.unohacha.com/api/User/protocol");
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("注册协议").setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }
}
