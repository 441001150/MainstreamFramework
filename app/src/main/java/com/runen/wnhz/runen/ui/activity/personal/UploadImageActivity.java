package com.runen.wnhz.runen.ui.activity.personal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.runen.wnhz.runen.R;
import com.runen.wnhz.runen.common.utils.ACacheUtlis;
import com.runen.wnhz.runen.common.utils.PhotoUtils;
import com.runen.wnhz.runen.common.utils.StatusBarCompatUtils;
import com.runen.wnhz.runen.common.utils.ToastUtil;
import com.runen.wnhz.runen.data.entity.PersonalEntity;
import com.runen.wnhz.runen.data.entity.UploadImgEntity;
import com.runen.wnhz.runen.data.entity.UserBean;
import com.runen.wnhz.runen.di.component.ApplicationComponent;
import com.runen.wnhz.runen.di.component.DaggerPersonalComponent;
import com.runen.wnhz.runen.di.module.PersonalModule;
import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import com.runen.wnhz.runen.ui.activity.BaseActivity;
import com.runen.wnhz.runen.widget.TitleBuilder;

import java.io.File;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-04-26.
 */

public class UploadImageActivity extends BaseActivity<IPersonal> implements PersonalContart.View,View.OnClickListener {

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.tv_phone_xc)
    TextView tv_phone_xc;

    @BindView(R.id.tv_phone_img)
    TextView tv_phone_img;


    private UserBean reqeustUser;

    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    private static final int CAMERA_PERMISSIONS_REQUEST_CODE = 0x03;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileUri = new File(Environment.getExternalStorageDirectory().getPath() + "/*.jpg");
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/*.jpg");
    private Uri imageUri;
    private Uri cropImageUri;
    private String image;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_uploadimage;
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
                mPresenter.setUploadImage();
                break;
            default:
                break;
        }
    }

    @Override
    protected void initStart() {
        StatusBarCompatUtils.getInstance().TranslucentStatusBar(this,R.color.title_green);

        reqeustUser = ACacheUtlis.getInstance().getReqeustUser(this);
        mPresenter.getUserMessage();

        initOnClcik();
    }

    private void initOnClcik() {

        tv_phone_xc.setOnClickListener(this);
        tv_phone_img.setOnClickListener(this);
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("设置个人头像")
                .setLeftDrawable(R.mipmap.icon_back)
                .seTitleBgRes(R.mipmap.bg_title)
                .setRightText("上传")
                .setRightTextColor(ContextCompat.getColor(this, R.color.text_white))
                .setMiddleTitleTextColor(ContextCompat.getColor(this, R.color.text_white));

    }

    @Override
    public void setupAcitivtyComponent(ApplicationComponent appComponent) {
        DaggerPersonalComponent.builder().applicationComponent(appComponent)
                .personalModule(new PersonalModule(this))
                .build().inject(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_phone_xc:
                autoObtainStoragePermission();
                break;
            case R.id.tv_phone_img:
                autoObtainCameraPermission();
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
        ToastUtil.showToast(msg);
    }

    @Override
    public String getToken() {
        return reqeustUser.getToken();
    }

    @Override
    public void setLogin(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void setErrorMessage(String info) {
        ToastUtil.showToast(info);
    }

    @Override
    public void getUserMessage(PersonalEntity data) {
        Glide.with(this).load(data.getHead_img()).into(imageView);
    }

    @Override
    public String getNickName() {
        return null;
    }

    @Override
    public String getSex() {
        return null;
    }

    @Override
    public String getSchool() {
        return null;
    }

    @Override
    public String getPlace() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getHedimg() {
        return image;
    }

    @Override
    public void setSuccess(String info) {
        ToastUtil.showToast(info);
        this.finish();
    }

    @Override
    public void setSuccess(UploadImgEntity info) {
        image = info.getImg();
        mPresenter.setUpdateUserImg();
    }

    @Override
    public File getFile() {
        if (fileUri != null){
            return fileUri;
        } else if (fileCropUri != null){
            return fileCropUri;
        } else {
            return null;
        }
    }

    /**
     * 自动获取相机权限
     */
    private void autoObtainCameraPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ToastUtil.showToast("您已经拒绝过一次");
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_PERMISSIONS_REQUEST_CODE);
        } else {//有权限直接调用系统相机拍照
            if (hasSdcard()) {
                imageUri = Uri.fromFile(fileUri);
                //通过FileProvider创建一个content类型的Uri
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    imageUri = FileProvider.getUriForFile(this, "com.runen.wnhz.runen", fileUri);
                }
                PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
            } else {
                ToastUtil.showToast("设备没有SD卡！");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            //调用系统相机申请拍照权限回调
            case CAMERA_PERMISSIONS_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (hasSdcard()) {
                        imageUri = Uri.fromFile(fileUri);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            imageUri = FileProvider.getUriForFile(this, "com.runen.wnhz.runen", fileUri);//通过FileProvider创建一个content类型的Uri
                        PhotoUtils.takePicture(this, imageUri, CODE_CAMERA_REQUEST);
                    } else {
                        ToastUtil.showToast("设备没有SD卡！");
                    }
                } else {
                    ToastUtil.showToast("请允许打开相机！！");
                }
                break;


            }
            //调用系统相册申请Sdcard权限回调
            case STORAGE_PERMISSIONS_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
                } else {

                    ToastUtil.showToast("请允许打操作SDCard！！");
                }
                break;
            default:
        }
    }

    private static final int OUTPUT_X = 480;
    private static final int OUTPUT_Y = 480;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //拍照完成回调
                case CODE_CAMERA_REQUEST:
                    cropImageUri = Uri.fromFile(fileCropUri);
                    PhotoUtils.cropImageUri(this, imageUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    break;
                //访问相册完成回调
                case CODE_GALLERY_REQUEST:
                    if (hasSdcard()) {
                        cropImageUri = Uri.fromFile(fileCropUri);
                        Uri newUri = Uri.parse(PhotoUtils.getPath(this, data.getData()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            newUri = FileProvider.getUriForFile(this, "com.runen.wnhz.runen", new File(newUri.getPath()));
                        }
                        PhotoUtils.cropImageUri(this, newUri, cropImageUri, 1, 1, OUTPUT_X, OUTPUT_Y, CODE_RESULT_REQUEST);
                    } else {
                        ToastUtil.showToast("设备没有SD卡！");
                    }
                    break;
                case CODE_RESULT_REQUEST:
                    Bitmap bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, this);
                    if (bitmap != null) {
                        showImages(bitmap);
                    }
                    break;
                default:
            }
        }
    }


    /**
     * 自动获取sdk权限
     */

    private void autoObtainStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            PhotoUtils.openPic(this, CODE_GALLERY_REQUEST);
        }

    }

    private void showImages(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }


    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }

}
