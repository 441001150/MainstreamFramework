package com.runen.wnhz.runen.common.utils;
import android.os.Environment;


/**
 * Created by saky on 2016/7/5.
 * 常量类
 */
public class Constants {
    
    /**GET  POST 请求中需要的头信息
     * 
     * @return totken 用户信息
     * @return VERSIONS 版本信息
     * @return REQUESTFOR 手机版本类型
     * 
     * */
    public static String TOKEN = "token";
    
    
    public static String VERSIONS = "versions";
    
    
    public static String REQUESTFOR = "requestfor";
    
    
    public static String PARAM = "p";
    
    /**
     * 是否第一次进入App
     * */
    public static String ISFIRSTOAPP = "FIRSTOAPP";
    
    /**
    *  登陆缓存的用户具体信息
    * */
    public static String UserName = "userName";
    public static String UserToken = "token";
    public static String UserImage = "image";
    
    
    
    /**
     * QQ  微信的appID和APP_KEY
     */
    public static final String QQ_APPID = "1104826425";
    
    public static final String QQ_APP_KEY = "eKIgY6XsUfAOFUOq";

    public static final String WEIBO_APP_ID = "wx45ded9c0b63a0889";
    
    public static final String WEIBO_APP_SECRET = "5092ddff6f570d2823f3443e064682c3";
    /**
     * 新支持scope：支持传入多个scope权限，用逗号分隔
     */
    public static final String SINA_SCOPE = "email,direct_messages_read,direct_messages_write,"
            + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
            + "follow_app_official_microblog," + "invitation_write";
    
    /**
     * SDCard路径
     */
    public static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    /**
     * app name
     */
    public static String APP_NAME = "ishangzu";

    /**
     * update目录
     */
    public static String DIR_APP_UPDATE = "update";

    /**
     * temp目录
     */
    public static String DIR_APP_TEMP = "temp";

    /**
     * 单点登录 token无效
     */
    public static final String ERROR_SINGLE = "1004";
    
    /**
     * 照片选择/照相回来的结果
     */
    public static final int REQUEST_IMAGE = 0x000002;

    /**
     * 照片选择/照相回来的结果
     */
    public static final int TAKE_PICTURE = 0x000001;

    /**
     * 请求相机
     */
    public static final int REQUEST_CAPTURE = 100;

    /**
     * 请求相册
     */
    public static final int REQUEST_PICK = 101;

    /**
     * 请求截图
     */
    public static final int REQUEST_CROP_PHOTO = 102;

    /**
     * complexity value
     */
    public static final String EASY = "easy";

    public static final String MULTIIMG = "multiImg";

    /**
     * 图片分辨率配置
     */
    public static final String WH100_100 = "@!100w_100h_100Q_app";
    public static final String WH1000_800 = "@!1000w_800h_100Q_app";
    public static final String WH500_400 = "@!500w_400h_100Q_app";
    public static final String WH1500_1500 = "@!1500w_1500h_100Q_app";
    
    /*
    * 
    * 服务器ip地址
    * */
    public static String BaseUrl = "http://runen.unohacha.com/Api/api/";
    
    /**
     * uid
     */
    public static final String SP_UID = "uid";

    /**
     * token
     */
    public static final String SP_TOKEN = "token";

    /**
     * 个推ID
     */
    public static final String SP_GETUI = "sp_getui";

    /**
     * 城市编码
     */
    public static final String SP_CITY_CODE = "SP_CITY_CODE";

    /**
     * 城市名称
     */
    public static final String SP_CITY_NAME = "SP_CITY_NAME";

    /**
     * 声音开关
     */
    public static final String SP_SOUND_OPEN = "SP_SOUND_OPEN";
    
    /**
     * 环信登录参数
     */
    public static final String SP_LOGIN_HUANXIN = "sp_login_huanxin";

    /**
     * SP name 标记
     */
    public static final String SP_NAME = "runen_share_data";
    
    /**
     * 图片存储路径
     */
    public static final String BASE_PATH = SD_PATH + "/ishangzu/temp/";

    /**
     * 缓存图片路径
     */
    public static final String BASE_IMAGE_CACHE = BASE_PATH + "cache/images/";

    public static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
}
