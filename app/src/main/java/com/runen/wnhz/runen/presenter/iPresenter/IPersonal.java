package com.runen.wnhz.runen.presenter.iPresenter;

import android.util.Log;

import com.runen.wnhz.runen.common.utils.Base64Utils;
import com.runen.wnhz.runen.common.utils.RetrofitParameterBuilder;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.BaseUnified;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.model.PersonalModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * NAME：薛世杰
 * DATE：2018/5/2
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class IPersonal extends BasePresenter<PersonalModel,PersonalContart.View> {


    @Inject
    public IPersonal(PersonalModel mModel, PersonalContart.View mView) {
        super(mModel, mView);
    }




    //获取用户详细信息
    public void getUserMessage(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        mModel.getUserMessage(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<PersonalEntity>>() {
                    @Override
                    public void call(BaseEntity<PersonalEntity> personalEntityBaseEntity) {
                        switch (personalEntityBaseEntity.getRe()){
                            case -1:
                                mView.setLogin(personalEntityBaseEntity.getInfo());
                                break;
                            case 0:
                                mView.setErrorMessage(personalEntityBaseEntity.getInfo());
                                break;
                            case 1:
                                mView.getUserMessage(personalEntityBaseEntity.getData());
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

    //修改用户信息
    public void setUserData(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        map.put("username",mView.getNickName());
        map.put("sex",mView.getSex());
        map.put("school",mView.getSchool());
        map.put("place",mView.getPlace());
        map.put("head_img",mView.getHedimg());

        mModel.setUserData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()) {
                            case "-1":
                                mView.setLogin(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.setErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.setSuccess(baseUnified.getInfo());
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

    /*修改密码*/
    public void setUpdatePass(){

        Map<String,String> map = new HashMap<>();


        map.put("token",mView.getToken());
        String base64Mobile = Base64Utils.encode(mView.getPassword());
        map.put("password",base64Mobile);

        mModel.setUserData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()) {
                            case "-1":
                                mView.setLogin(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.setErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.setSuccess(baseUnified.getInfo());
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

    /*修改昵称*/
    public void setUpdateUserName(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        map.put("username",mView.getNickName());

        mModel.setUserData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()) {
                            case "-1":
                                mView.setLogin(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.setErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.setSuccess(baseUnified.getInfo());
                                ToastUtil.showToast(baseUnified.getInfo());
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


    //退出登陆
    public void setExitLogin(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        mModel.setExitLogin(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()){
                            case "-1":
                                mView.setLogin(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.setErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.setSuccess(baseUnified.getInfo());
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


    /*修改头像*/
    public void setUpdateUserImg(){

        Map<String,String> map = new HashMap<>();
        map.put("token",mView.getToken());
        map.put("head_img",mView.getHedimg());

        mModel.setUserData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseUnified>() {
                    @Override
                    public void call(BaseUnified baseUnified) {
                        switch (baseUnified.getRe()) {
                            case "-1":
                                mView.setLogin(baseUnified.getInfo());
                                break;
                            case "0":
                                mView.setErrorMessage(baseUnified.getInfo());
                                break;
                            case "1":
                                mView.setSuccess(baseUnified.getInfo());
                                ToastUtil.showToast(baseUnified.getInfo());
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



    //上传头像
    public void setUploadImage(){


        Map<String, RequestBody> params = RetrofitParameterBuilder.newBuilder()
                .addParameter("file",mView.getFile())
                .bulider(mView.getToken());


        mModel.setUploadImg(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<BaseEntity<UploadImgEntity>>() {
                    @Override
                    public void call(BaseEntity<UploadImgEntity> uploadImgEntityBaseEntity) {
                        switch (uploadImgEntityBaseEntity.getRe()){

                            case -1:
                                mView.setLogin(uploadImgEntityBaseEntity.getInfo());
                                break;
                            case 0:
                                mView.setErrorMessage(uploadImgEntityBaseEntity.getInfo());
                                break;
                            case 1:
                                mView.setSuccess(uploadImgEntityBaseEntity.getData());
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
