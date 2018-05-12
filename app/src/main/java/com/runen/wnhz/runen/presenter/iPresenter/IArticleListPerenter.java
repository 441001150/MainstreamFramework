package com.runen.wnhz.runen.presenter.iPresenter;

import android.util.Log;

import com.runen.wnhz.runen.common.rx.RxHttpReponseCompat;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import com.runen.wnhz.runen.presenter.model.ArticleListModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

public class IArticleListPerenter extends BasePresenter<ArticleListModel,ArticleListContart.View> {


    @Inject
    public IArticleListPerenter(ArticleListModel mModel, ArticleListContart.View mView) {
        super(mModel, mView);
    }


    public void getArticleList(int fid, int page) {
        Log.e("---------", "getLessonList");

        Map<String, Integer> map = new HashMap<>();
        map.put("fid", fid);
        map.put("page", page);

        mModel.getArticleList(map).compose(RxHttpReponseCompat.<ArticleListEntity>compatResult())
                .subscribe(new Action1<ArticleListEntity>() {
                    @Override
                    public void call(ArticleListEntity articleListEntity) {
                        if (articleListEntity != null){
                            mView.getArticleListRequest(articleListEntity);
                        } else {
                            ToastUtil.showToast("没有数据");
                        }
                    }
                });
    }

    public void getArticleInfo(int tid) {
        Log.e("---------", "getArticleInfo");

        mModel.getArticleInfo(tid).compose(RxHttpReponseCompat.<ArticleListEntity>compatResult())
                .subscribe(new Action1<ArticleListEntity>() {
                    @Override
                    public void call(ArticleListEntity articleListEntity) {

                    }
                });
    }
}
