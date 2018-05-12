package com.runen.wnhz.runen.common.utils;

import android.app.Activity;
import android.widget.Toast;

import com.runen.wnhz.runen.ui.ActivityManager;
import com.runen.wnhz.runen.ui.activity.BaseActivity;


/**
 * Created by saky on 2016/7/25.
 */
public class ToastUtil {

    public static void showToast(String txt, int res) {
        Activity activity = ActivityManager.getAppManager().currentActivity();
        if (activity != null && activity instanceof BaseActivity) {
        }
    }


    public static void showToast(String txt) {
        Activity activity = ActivityManager.getAppManager().currentActivity();
        if (activity != null && activity instanceof BaseActivity) {
            Toast.makeText(activity,txt,Toast.LENGTH_SHORT).show();
        }
    }
}
