package com.runen.wnhz.runen.common.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by saky on 2016/7/27.
 */
public class CountDownButtonHelper {

    // 倒计时timer
    private CountDownTimer countDownTimer;
    // 计时结束的回调接口
    private OnFinishListener listener;

    private Button button;
    // 用来设置按钮上显示的文案
    private String text;

    private TextView textView;

    /**
     * @param button   需要显示倒计时的Button
     * @param max      需要进行倒计时的最大值,单位是秒
     * @param interval 倒计时的间隔，单位是秒
     */
    public CountDownButtonHelper(final Button button, int max, int interval) {

        this.button = button;
        // 由于CountDownTimer并不是准确计时，在onTick方法调用的时候，time会有1-10ms左右的误差，这会导致最后一秒不会调用onTick()
        // 因此，设置间隔的时候，默认减去了10ms，从而减去误差。
        // 经过以上的微调，最后一秒的显示时间会由于10ms延迟的积累，导致显示时间比1s长max*10ms的时间，其他时间的显示正常,总时间正常
        countDownTimer = new CountDownTimer(max * 1000, interval * 1000 - 10) {

            @Override
            public void onTick(long time) {
                // 第一次调用会有1-10ms的误差，因此需要+15ms，防止第一个数不显示，第二个数显示2s
                button.setText(((time + 15) / 1000)
                        + "s后重试");
                button.setTextColor(Color.parseColor("#999999"));
                //button.setText(((time + 15) / 1000) /1000+"s后重试");
            }

            @Override
            public void onFinish() {
                button.setEnabled(true);
                button.setText(text);
                button.setTextColor(Color.parseColor("#2F2F36"));
                if (listener != null) {
                    listener.countDownFinish();
                }
            }
        };
    }

    public CountDownButtonHelper(final TextView textView, int max, int interval, final String availableColor, final String unavailabilityColor ) {

        this.textView = textView;
        this.text = textView.getText().toString();
        // 由于CountDownTimer并不是准确计时，在onTick方法调用的时候，time会有1-10ms左右的误差，这会导致最后一秒不会调用onTick()
        // 因此，设置间隔的时候，默认减去了10ms，从而减去误差。
        // 经过以上的微调，最后一秒的显示时间会由于10ms延迟的积累，导致显示时间比1s长max*10ms的时间，其他时间的显示正常,总时间正常
        countDownTimer = new CountDownTimer(max * 1000, interval * 1000 - 10) {

            @Override
            public void onTick(long time) {
                // 第一次调用会有1-10ms的误差，因此需要+15ms，防止第一个数不显示，第二个数显示2s
                textView.setText(((time + 15) / 1000)
                        + "s后重试");
                textView.setTextColor(Color.parseColor(unavailabilityColor));
                //button.setText(((time + 15) / 1000) /1000+"s后重试");
            }

            @Override
            public void onFinish() {
                textView.setEnabled(true);
                textView.setText(text);
                textView.setTextColor(Color.parseColor(availableColor));
                if (listener != null) {
                    listener.countDownFinish();
                }
            }
        };
    }

    /**
     * 开始倒计时
     */
    public void start() {
        if(button!=null){
            button.setEnabled(false);
        }
        if(textView!=null){
            textView.setEnabled(false);
        }

        countDownTimer.start();
    }

    /**
     * 设置倒计时结束的监听器
     *
     * @param listener
     */
    public void setOnFinishListener(OnFinishListener listener) {
        this.listener = listener;
    }

    /**
     * 计时结束的回调接口
     *
     * @author zhaokaiqiang
     */
    public interface OnFinishListener {
        public void countDownFinish();
    }

    public void stop() {
        countDownTimer.cancel();
        countDownTimer.onFinish();

    }

    public void setText(String text) {
        this.text = text;
    }
}
