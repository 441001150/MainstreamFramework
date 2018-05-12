package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.MyCollection;
import com.runen.wnhz.runen.data.entity.MyCourseEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.model.CourseModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class ICoursePersenter extends BasePresenter<CourseModel,CourseContart.View> {

    @Inject
    public ICoursePersenter(CourseModel mModel, CourseContart.View mView) {
        super(mModel, mView);
    }




    //获取我的课程
    public void getContent(){

        Map<String,String> map = new HashMap<>();

        map.put("token", mView.getToken());
        map.put("type",mView.getType());
        map.put("page",mView.getPage());


        mModel.getContent(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MyCourseEntity>() {
                    @Override
                    public void call(MyCourseEntity myCourseEntity) {
                        switch (myCourseEntity.getRe()){
                            case "-1":
                                mView.showLoginError(myCourseEntity.getInfo());
                                break;
                            case "0":
                                mView.showErrorMessage(myCourseEntity.getInfo());
                                break;
                            case "1":
                                mView.reqeuestData(myCourseEntity);
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage());
                    }
                });



    }

    //获取我的收藏

    public void getUcenter(){

        Map<String,String> map = new HashMap<>();

        map.put("token", mView.getToken());
        map.put("page",mView.getPage());

        mModel.getUcenter(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MyCollection>() {
                    @Override
                    public void call(MyCollection myCollection) {
                        switch (myCollection.getRe()){
                            case "-1":
                                mView.showLoginError(myCollection.getInfo());
                                break;
                            case "0":
                                mView.showErrorMessage(myCollection.getInfo());
                                break;
                            case "1":
                                ToastUtil.showToast(myCollection.getInfo() + myCollection.getData().toString());
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        ToastUtil.showToast(throwable.getMessage());
                    }
                });



    }
}
