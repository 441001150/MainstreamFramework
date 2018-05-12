package com.runen.wnhz.runen.common.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.lang.ref.WeakReference;

/**
 * Created by saky on 2016/8/21.
 */
//打开或关闭软键盘
public class KeyBoardUtils {
    /**
     * 打卡软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        WeakReference<Context> w_context = new WeakReference<Context>(mContext);
        InputMethodManager imm = (InputMethodManager) w_context.get().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 关闭软键盘
     *
     * @param mEditText 输入框
     * @param mContext  上下文
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        WeakReference<Context> w_context = new WeakReference<Context>(mContext);
        InputMethodManager imm = (InputMethodManager) w_context.get().getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

    /**
     * 关闭软键盘
     *
     * @param view     输入框
     * @param mContext 上下文
     */
    public static void closeKeybord(View view, Context mContext) {
        WeakReference<Context> w_context = new WeakReference<Context>(mContext);
        Context weakContext = w_context.get();
        if(weakContext != null){
            InputMethodManager imm = (InputMethodManager) w_context.get().getSystemService(Context.INPUT_METHOD_SERVICE);

            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
