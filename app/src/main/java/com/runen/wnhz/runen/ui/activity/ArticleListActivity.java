package com.runen.wnhz.runen.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerArticleComponent;
import com.runen.wnhz.runen.di.module.ArticleMdule;
import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import com.runen.wnhz.runen.presenter.iPresenter.IArticleListPerenter;
import com.runen.wnhz.runen.ui.adapter.puadapter.ArticleListAdapter;
import com.runen.wnhz.runen.widget.TitleBuilder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018-04-24.
 */

public class ArticleListActivity extends BaseActivity<IArticleListPerenter> implements ArticleListContart.View {

    @BindView(R.id.iv_back)
    ImageView ivBack;

    @BindView(R.id.ry_articlelist)
    RecyclerView mRecyclerView;


    private int fid = 1;
    private int pag = 0;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_articlelist;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {

    }

    @Override
    protected void initStart() {
        mPresenter.getArticleList(1, 0);
    }


    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        setToolBarVisible(View.GONE);
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerArticleComponent.builder().applicationComponent(appComponent)
                .articleMdule(new ArticleMdule(this))
                .build().initject(this);
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
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
    public void getArticleListRequest(ArticleListEntity articleListDatas) {

        ArticleListAdapter adapter = new ArticleListAdapter(this, articleListDatas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        adapter.setItemClickListener(new ArticleListAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, ArticleListEntity.ListBean data) {
                //跳转webview界面，展示图说详情
                Log.e(TAG, data.toString());
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://runen.unohacha.com/Api/api/Article_articleInfo/tid/" + data.getTid());
                bundle.putString("title", "润恩教育");
                Intent intent = new Intent(ArticleListActivity.this, WebViewActivity.class);
                intent.putExtra("url", "http://runen.unohacha.com/Api/api/Article_articleInfo/tid/" + data.getTid());
                intent.putExtra("title", "润恩教育");
//                JumpUtlis.getInstance().jumpActivity(ArticleListActivity.this, WebViewActivity.class, bundle);
                startActivity(intent);
            }
        });
    }


}
