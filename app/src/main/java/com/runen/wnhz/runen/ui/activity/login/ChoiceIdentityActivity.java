package com.runen.wnhz.runen.ui.activity.login;
import android.Manifest;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.Constants;
import com.runen.wnhz.runen.common.utils.JumpUtlis;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.ui.activity.main.MainActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;
import butterknife.BindView;
import rx.functions.Action1;

/**
 * Created by Administrator on 2018-04-09.
 */

public class ChoiceIdentityActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,View.OnClickListener {

    
    /*下一步*/
    @BindView(R.id.tv_next)
    TextView tv_next;


    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;

    public int selected;
    
    /*用于判断是否点击按钮，不点击无法跳转页面*/
    public boolean isFist = false;

    @Override
    protected int getLayoutView() {
        return R.layout.choice_identity_activity_layout;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
                break;
            case MIDDLE:
                break;
            case RIGHT:
                startActivity(new Intent(this,MainActivity.class));
                ACacheUtlis.getInstance().IsFirstToApp(this, Constants.ISFIRSTOAPP);
                break;
            default:
                ToastUtil.showToast("未知错误");
                break;
        }
    }

    @Override
    protected void initStart() {
        if (null == ACacheUtlis.getInstance().IsFirstToApp(this)) {
            StatusBarCompatUtils.getInstance().TranslucentStatusBar(this, R.color.title_green);

            //这个里面进行申请权限
            requestPermissions();
            radiogroup.setOnCheckedChangeListener(this);
            tv_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG, isFist + "" + selected + "");
                    if (!isFist) {
                        ToastUtil.showToast("请选择机构");
                    } else {
                        JumpUtlis.getInstance().jumpActivity(ChoiceIdentityActivity.this, LoginForPersonalActivity.class, selected);
                    }
                }
            });
        } else {
            JumpUtlis.getInstance().jumpActivity(ChoiceIdentityActivity.this, MainActivity.class);
        }
    }
    
    /** 获取权限。整体使用
     * WRITE_EXTERNAL_STORAGE 读写文件
     * RECORD_AUDIO 音频处理权限
     * 
     * */
    
    private void requestPermissions() {
        RxPermissions rxPermission = new RxPermissions(this);
        rxPermission
                .requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA)
                .subscribe(new Action1<Permission>() {
                    @Override
                    public void call(Permission permission) {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            Log.d(TAG, permission.name + " is granted.");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Log.d(TAG, permission.name + " is denied. More info should be provided.");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            switch (permission.name){
                                case "android.permission.RECORD_AUDIO":
                                    ToastUtil.showToast("无法观看视频");
                                    break;
                                case "android.permission.WRITE_EXTERNAL_STORAGE":
                                    ToastUtil.showToast("无法保存文件到本地");
                                    break;     
                                case "android.permission.CAMERA":
                                    ToastUtil.showToast("无法正常使用AR功能");
                                    break;
                            }
                            
                            Log.d(TAG, permission.name + " is denied.");
                        }
                    }
                });


    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.seTitleBgColor(ContextCompat.getColor(this, R.color.title_green))
                .setMiddleTitleText("选择身份")
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white))
                .setRightText("跳过")
                .setRightTextColor(ContextCompat.getColor(this, R.color.text_white));
    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            /*机构用户*/
            case R.id.rb_enterprise:
                isFist = true;
                selected = 0;
                JumpUtlis.getInstance().jumpActivity(this,LoginForEnterpriseActivity.class);
                break;
            /*个人用户*/
            case R.id.rb_personal:
                isFist = true;
                selected = 1;
                JumpUtlis.getInstance().jumpActivity(this,LoginForPersonalActivity.class);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        
    }
}
