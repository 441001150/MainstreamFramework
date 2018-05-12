package com.runen.wnhz.runen.presenter.iPresenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.runen.wnhz.runen.common.utils.Base64Utils;
import com.runen.wnhz.runen.common.utils.CountDownButtonHelper;
import com.runen.wnhz.runen.common.utils.MsmEntity;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.RegisterBean;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.presenter.BasePresenter;
import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import com.runen.wnhz.runen.presenter.model.LoginModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.runen.wnhz.runen.R.id.rg;

/**
 * Created by Administrator on 2018-04-27.
 */

public class ILoginPersenter extends BasePresenter<LoginModel,LoginContart.View> {
    
    CountDownButtonHelper timeHelper;
    
    @Inject
    public ILoginPersenter(LoginModel mModel, LoginContart.View mView) {
        super(mModel, mView);
    }

    /*发送验证码*/
    public void requestMSN(){

        Log.e("----", "requestMSN: " );

        timeHelper = new CountDownButtonHelper(mView.getTextSendOut(), 60, 1, "#03C066", "#cccccc");
        
        //对手机号码加密
        if (TextUtils.isEmpty(mView.mobile())){
            mView.mMobileError();
        }
        if (mView.mobile().length() != 11) {
            ToastUtil.showToast("手机号有误");
            return;
        }
        switch (mView.type()){
            case "":
                break;
            case "1":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "2":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "3":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "4":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "5":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "6":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "7":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "8":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;
            case "33":
                if (TextUtils.isEmpty(mView.type())){
                    ToastUtil.showToast("验证码不能为空");
                }
                break;

            default:
                break;
        }

        timeHelper.start();
        String base64Mobile = Base64Utils.encode(mView.mobile());
        mView.verify();
        mView.type();
        Map<String, String> params =new HashMap<>();
        params.put("mobile",base64Mobile);
        params.put("type",mView.type());

        mModel.getRequestSms(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MsmEntity>() {
                    @Override
                    public void call(MsmEntity msmEntity) {
                        switch (msmEntity.getRe()) {
                            case 0:
                                mView.showErrorMessage(msmEntity.getInfo());
                                break;
                            case 1:
                                mView.showSend(msmEntity.getInfo());
                                break;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("---IRegisterPersenter", throwable.getMessage().toString());
                    }
                });


    }
    /**
    * 注册用户  普通用户注册
    * */
    public void requestResgist(){
        
        if (TextUtils.isEmpty(mView.getResterPhone())){
            ToastUtil.showToast("手机号不能为空");
        } else if (TextUtils.isEmpty(mView.getResterSendOut())){
            ToastUtil.showToast("验证码不能为空");
        } else if (TextUtils.isEmpty(mView.getResterPassWord())){
            ToastUtil.showToast("密码不能为空");
        } else if (mView.getResterPhone().length() != 11){
            ToastUtil.showToast("手机号码少于11位");
        } else if (mView.getResterPassWord().length() >= 6){
            ToastUtil.showToast("密码少于6位");
        } else {
            Log.e("------Resgist",mView.getResterPassWord().length() + ""  );
      
            String base64Mobile = Base64Utils.encode(mView.getResterPhone());
            String base64Pass = Base64Utils.encode(mView.getResterPassWord());
            
            
            Map<String,String> map = new HashMap<>();
            map.put("mobile",base64Mobile);
            map.put("password",base64Pass);
            map.put("ptype","86");
            map.put("code",mView.getResterSendOut());
            Bundle bundle = mView.getBundle();
            if (bundle != null){
                map.put("city_code",bundle.getString("city_code"));
                map.put("company_code",bundle.getString("company_code"));
            }
            mModel.getRequestRegister(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BaseEntity<RegisterBean>>() {
                        @Override
                        public void call(BaseEntity<RegisterBean> registerBeanBaseEntity) {
                            Log.e("------Resgist",registerBeanBaseEntity.toString() );
                            switch (registerBeanBaseEntity.getRe()){
                                case 0:
                                    ToastUtil.showToast(registerBeanBaseEntity.getInfo());
                                    break;
                                case 1:
                                  mView.showJump(registerBeanBaseEntity.getInfo());
                                    break;
                            }
                            
                            
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.e("-----", throwable.getMessage().toString());
                        }
                    });
      
            
        }
        
        
        
        

        
    }
    
    
    
    /*密码登陆*/
    public void requesteName(){

        Log.e("----", "requesteName: " );
        if (TextUtils.isEmpty(mView.mobiLogName())){
            ToastUtil.showToast("手机号不能为空");
        } else if (TextUtils.isEmpty(mView.mobiLogPass())){
            ToastUtil.showToast("密码不能为空");
        } else if (mView.mobiLogName().length() != 11){
            ToastUtil.showToast("手机不符合11位");
        } else {
            
            String base64Mobile = Base64Utils.encode(mView.mobiLogName());
            String base64PassWord= Base64Utils.encode(mView.mobiLogPass());
            Map<String,String> map = new HashMap<>();
            map.put("mobile",base64Mobile);
            map.put("password",base64PassWord);
            map.put("login_type","1");
            map.put("ptype ","86");
            Bundle bundle = mView.getBundle();
            if (bundle != null){
                map.put("city_code",bundle.getString("city_code"));
                map.put("company_code",bundle.getString("company_code"));
            }
            Log.e("----1","进来了" );
            mModel.getRequestLoginName(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BaseEntity<UserBean>>() {
                        @Override
                        public void call(BaseEntity<UserBean> userBeanBaseEntity) {
                            Log.e("----1","进来了" + userBeanBaseEntity.toString() );
                            switch (userBeanBaseEntity.getRe()) {
                                case 0:
                                    mView.showLoginErrorMsg(userBeanBaseEntity.getInfo());
                                    break;
                                case 1:
                                    mView.saveUserBean(userBeanBaseEntity.getData());
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


    /*验证码登陆， 不要密码*/
    public void requesteCode(){

        Log.e("----", "requesteCode: " );
        if (TextUtils.isEmpty(mView.getVerifPhone())){
            ToastUtil.showToast("手机号不能为空");
        } else if (mView.getVerifPhone().length() != 11){
            ToastUtil.showToast("手机不符合11位");
        } else {

            String base64Mobile = Base64Utils.encode(mView.getVerifPhone());
            Map<String,String> map = new HashMap<>();
            map.put("mobile",base64Mobile);
            map.put("code",mView.getVerifCode());
            map.put("login_type","1");
            
            mModel.getRequestLoginName(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BaseEntity<UserBean>>() {
                        @Override
                        public void call(BaseEntity<UserBean> userBeanBaseEntity) {
                            Log.e("--------", userBeanBaseEntity.toString() );
                            switch (userBeanBaseEntity.getRe()) {
                                case 0:
                                    ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                    break;
                                case 1:
                                    mView.saveVerifData(userBeanBaseEntity.getData());
                                    break;
                            }
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.e("--------", throwable.getMessage().toString() );
                            ToastUtil.showToast(throwable.getMessage());
                        }
                    });
        }
    }


    /*忘记密码*/
    public void requesteForget(){

        Log.e("----", "requesteForget: " );
        if (TextUtils.isEmpty(mView.getForgetPhone())){
            ToastUtil.showToast("手机号不能为空");
        }
        if (mView.getForgetPhone().length() != 11){
            ToastUtil.showToast("手机号码长度不符合");
        }
        if (TextUtils.isEmpty(mView.getForgetCode())){
            ToastUtil.showToast("验证码不能为空");
        }
        if (TextUtils.isEmpty(mView.getForgetPass())){
            ToastUtil.showToast("密码不能为空");
        } 
        if (TextUtils.isEmpty(mView.getForgetNewPass())){
            ToastUtil.showToast("新的密码不能为空");
        }
        if (!mView.getForgetPass().equals(mView.getForgetNewPass())){
            ToastUtil.showToast("两次输入的密码不对");
        }

        String base64Mobile = Base64Utils.encode(mView.getForgetPhone());
        String base64Pass = Base64Utils.encode(mView.getForgetPass());
        String base64NewPass = Base64Utils.encode(mView.getForgetNewPass());
        Map<String,String> map = new HashMap<>();
        
        map.put("mobile",base64Mobile);
        map.put("code",mView.getForgetCode());
        map.put("password",base64Pass);
        map.put("repassword",base64NewPass);
        map.put("login_type","1");
        mModel.getForgetPasswordApi(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BaseEntity<UserBean>>() {
                        @Override
                        public void call(BaseEntity<UserBean> userBeanBaseEntity) {
                            Log.e("--------",userBeanBaseEntity.toString());
                            switch (userBeanBaseEntity.getRe()) {
                                case 0:
                                    ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                    break;
                                case 1:
                                    ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                    mView.saveForData(userBeanBaseEntity.getData());
                                    break;
                            }
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            Log.e("--------", throwable.getMessage().toString() );
                            ToastUtil.showToast(throwable.getMessage());
                        }
                    });
        }
    
}
