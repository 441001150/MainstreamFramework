package com.runen.wnhz.runen.presenter.iPresenter;

import android.support.v4.app.NavUtils;
import android.util.Log;

import com.runen.wnhz.runen.common.rx.RxErrorHandler;
import com.runen.wnhz.runen.common.rx.RxHttpReponseCompat;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.ArticleEntity;
import com.runen.wnhz.runen.data.entity.ArticleListEntity;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.HomeBannerBean;
import com.runen.wnhz.runen.data.entity.LessonListEntity;
import com.runen.wnhz.runen.data.entity.ShopTypeEntity;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static android.icu.text.UnicodeSet.CASE;
import static android.os.Build.VERSION_CODES.O;
import static com.runen.wnhz.runen.common.rx.RxHttpReponseCompat.compatResult;

/**
 * Created by Administrator on 2018-04-24.
 * MVP P
 */

public class IhomePersenter extends BasePresenter<HomeModel, HomeContart.View> {

    //直接注入进入了
    @Inject
    public IhomePersenter(HomeModel mModel, HomeContart.View mView) {
        super(mModel, mView);
    }

    //定义方法，写自身的逻辑方法   获取banner 数据
    public void getBannerData() {
        Log.e("------", "getBannerData: ");

        mModel.getHomeBanner()
                .compose(RxHttpReponseCompat.<List<HomeBannerBean>>compatResult())
                .subscribe(new Action1<List<HomeBannerBean>>() {
                    @Override
                    public void call(List<HomeBannerBean> homeBannerBeen) {
                        if (homeBannerBeen != null) {
                            mView.getBannerRequest(homeBannerBeen);
                        } else {
                            ToastUtil.showToast("没有数据");
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("---IhomePersenter", throwable.getMessage().toString());
                    }
                });
    }
    
    //获取图说
    public void getImageSay(){

        Log.e("---------", "getImageSay");
        
        mModel.getAritcle().compose(RxHttpReponseCompat.<ArticleEntity>compatResult())
                .subscribe(new Action1<ArticleEntity>() {
                    @Override
                    public void call(ArticleEntity articleEntity) {
                        if (articleEntity != null){
                            mView.getArticleRequest(articleEntity);
                        } else {
                            ToastUtil.showToast("没有数据");
                        }
                    }
                });
        
    }

    public void getArticleList(int fid, int page) {
        Log.e("---------", "getLessonList");

        Map<String, Integer> map = new HashMap<>();
        map.put("fid", fid);
        map.put("page", page);

        mModel.getAritcle(map).compose(RxHttpReponseCompat.<ArticleListEntity>compatResult())
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


    public void getLessonList(int type, int page, int size) {

        Log.e("---------", "getLessonList");

        Map<String, Integer> map = new HashMap<>();
        map.put("type", type);
        map.put("page", page);
        map.put("size", size);

        mModel.getLessonList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<LessonListEntity>>() {
                    @Override
                    public void call(BaseEntity<LessonListEntity> lessonListEntityBaseEntity) {
                        switch (lessonListEntityBaseEntity.getRe()) {
                            case 0:
                                ToastUtil.showToast("没有数据");
                                break;
                            case 1:
                                mView.getLessonListRequest(lessonListEntityBaseEntity.getData());
                                break;
                            case -1:
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }

    public void getZiliaoList(int type, int page, int size) {

        Log.e("---------", "getZiliaoList");


        Map<String, Integer> map = new HashMap<>();
        map.put("type", type);
        map.put("page", page);
        map.put("size", size);

        mModel.getLessonList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<LessonListEntity>>() {
                    @Override
                    public void call(BaseEntity<LessonListEntity> lessonListEntityBaseEntity) {
                        switch (lessonListEntityBaseEntity.getRe()) {
                            case 0:
                                ToastUtil.showToast("没有数据");
                                break;
                            case 1:
                                mView.getZiliaoListRequest(lessonListEntityBaseEntity.getData());
                                break;
                            case -1:
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                    }
                });
    }

    public void getShopTypeList() {
        Log.e("---------", "getShopTypeList");

        mModel.getShopTypeList()
                .compose(RxHttpReponseCompat.<List<ShopTypeEntity>>compatResult())
                .subscribe(new Action1<List<ShopTypeEntity>>() {
                    @Override
                    public void call(List<ShopTypeEntity> shopTypeEntities) {
                        if (shopTypeEntities != null) {
                            mView.getShopTypeRequest(shopTypeEntities);
                        } else {
                            ToastUtil.showToast("没有数据");
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("---IhomePersenter", throwable.getMessage().toString());
                    }
                });
    }
}
