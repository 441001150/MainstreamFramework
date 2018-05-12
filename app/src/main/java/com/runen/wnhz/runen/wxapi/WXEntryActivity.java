package com.runen.wnhz.runen.wxapi;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.Constants;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.data.entity.WxEntity;
import com.runen.wnhz.runen.data.entity.WxUserEntity;
import com.runen.wnhz.runen.di.component.DaggerWxLoninComponent;
import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.service.WxServiceApi;
import com.runen.wnhz.runen.ui.BaseApplication;
import com.runen.wnhz.runen.ui.activity.login.RegisterActivity;
import com.runen.wnhz.runen.ui.activity.main.MainActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * NAME：薛世杰
 * DATE：2018/3/12
 * EMIAL：zenhac@163.com
 * DESCRIBE：
 */


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private String TAG = "WXEntryActivity";

    WxEntity wxEntity;

    WxUserEntity userEntity;

    WxUserEntity userName;

    @Inject
    LoginServiceApi loginServiceApi;

    WxServiceApi wxServiceApi;

    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;

    public Retrofit wxRetrofit(){
        return new Retrofit
                .Builder()
                .baseUrl("https://api.weixin.qq.com/")   //101.201.233.92:8082/api/grade/save
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //如果没回调onResp，八成是这句没有写
        BaseApplication.mWxApi.handleIntent(getIntent(), WXEntryActivity.this);
        DaggerWxLoninComponent.builder().applicationComponent( ((BaseApplication)getApplicationContext()).getAppComponent())
                .build().initject(this);
    }



    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq baseReq) {

    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    //app发送消息给微信，处理返回消息的回调
    @Override
    public void onResp(BaseResp resp) {
        Log.i("----", "onResp:------>");
        Log.i("----", "error_code:---->" + resp.errCode);
        int type = resp.getType(); //类型：分享还是登录
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                //用户拒绝授权
                ToastUtil.showToast("拒绝授权微信登录");
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (RETURN_MSG_TYPE_SHARE == resp.getType()) {
                    Log.e(TAG, "分享失败");
                } else {
                    Log.e(TAG, "登录失败");
                }
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (resp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        //用户同意
                        if (type == RETURN_MSG_TYPE_LOGIN) {
                            //用户换取access_token的code，仅在ErrCode为0时有效
                            String code = ((SendAuth.Resp) resp).code;

                            //这里拿到了这个code，去做2次网络请求获取access_token和用户个人信息   //得到这两个，用event 传递到另外到页面去
                            getAccess_token(Constants.WEIBO_APP_ID, Constants.WEIBO_APP_SECRET, code);

                            //Log.e(TAG, access_token.toString());
                        } else if (type == RETURN_MSG_TYPE_SHARE) {

                            Toast.makeText(this, "微信分享成功", Toast.LENGTH_SHORT).show();
                        }


                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求

                        break;
                }
            case RETURN_MSG_TYPE_SHARE:
                Log.e(TAG, "微信分享成功");
                break;
        }

    }


    /**
     * 接口
     * https://api.weixin.qq.com/sns/oauth2/access_token ? appid = APPID &
     * secret = SECRET & code=CODE & grant_type = authorization_code
     * <p>
     * okhttp 请求 获取到授权信息
     * access_token	接口调用凭证
     * expires_in	access_token接口调用凭证超时时间，单位（秒）
     * refresh_token	用户刷新access_token
     * openid	授权用户唯一标识
     * scope	用户授权的作用域，使用逗号（,）分隔
     */
    public void getAccess_token(String APPID, String SECRET, String CODE) {

        Log.e("----1111", "code:------>" + APPID + SECRET + CODE);

        wxServiceApi = wxRetrofit().create(WxServiceApi.class);

        wxServiceApi.getWxInfo(APPID,SECRET,CODE,"authorization_code")
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<WxEntity>() {
            @Override
            public void call(WxEntity wxEntity) {

                Log.e("---22221",wxEntity.toString());

                getUserName(wxEntity.getAccess_token(), wxEntity.getOpenid());

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("---2222",throwable.getMessage().toString());
            }
        });
    }


    /**
     获取用户个人信息（UnionID机制）
     https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
     * */

    public void getUserName(String ACCESS_TOKEN,String OPENID){

        wxServiceApi.getWxUsernfo(ACCESS_TOKEN,OPENID).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<WxUserEntity>() {
            @Override
            public void call(final WxUserEntity wxUserEntity) {

                Log.e("33331",wxUserEntity.toString());

                userEntity =wxUserEntity;


                Map<String,String> map = new HashMap<String, String>();
                map.put("login_type","2");
                map.put("type","1");
                map.put("openid",userEntity.getOpenid());
                map.put("imgurl",userEntity.getHeadimgurl());
                map.put("nickname",userEntity.getNickname());


                loginServiceApi.loginForPersonalApi(map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<BaseEntity<UserBean>>() {
                            @Override
                            public void call(BaseEntity<UserBean> userBeanBaseEntity) {
                                switch (userBeanBaseEntity.getRe()){
                                    case -1:
                                        ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                        break;
                                    case 0:
                                        ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                        break;
                                    case 1:
                                        ACacheUtlis.getInstance().IsRequstUser(WXEntryActivity.this,userBeanBaseEntity.getData().getToken(),userBeanBaseEntity.getData().getUsername(),userBeanBaseEntity.getData().getHead_img());
                                        JumpUtlis.getInstance().jumpActivity(WXEntryActivity.this, MainActivity.class);
                                        break;
                                    case 2:
                                        ToastUtil.showToast(userBeanBaseEntity.getInfo());
                                        JumpUtlis.getInstance().jumpActivity(WXEntryActivity.this,RegisterActivity.class);
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
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.e("3333",throwable.getMessage().toString());
            }
        });

    }






}
