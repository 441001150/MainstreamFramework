package com.runen.wnhz.runen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Chronometer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 2018-04-13.
 */

public class Anticlockwise extends Chronometer {

    public Anticlockwise(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO 自动生成的构造函数存根  
        mTimeFormat = new SimpleDateFormat("mm:ss");
        this.setOnChronometerTickListener(listener);
    }


    private String label  = "";
    private long mTime;
    private long mNextTime;
    private OnTimeCompleteListener mListener;
    private SimpleDateFormat mTimeFormat;

    public Anticlockwise(Context context) {
        super(context);

    }

    /**
     * 重新启动计时
     */
    public void reStart(long _time_s) {
        if (_time_s == -1) {
            mNextTime = mTime;
        } else {
            mTime = mNextTime = _time_s;
        }
        this.start();
    }

    public void reStart() {
        reStart(-1);
    }

    /**
     * 继续计时
     */
    public void onResume() {
        this.start();
    }

    /**
     * 暂停计时
     */
    public void onPause() {
        this.stop();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 设置时间格式
     *
     * @param pattern 计时格式
     */
    public void setTimeFormat(String pattern) {
        mTimeFormat = new SimpleDateFormat(pattern);
        mTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));//设置时区
    }

    public void setOnTimeCompleteListener(OnTimeCompleteListener l) {
        mListener = l;
    }

    OnChronometerTickListener listener = new OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            if (mNextTime <= 0) {
                if (mNextTime == 0) {
                    Anticlockwise.this.stop();
                    if (null != mListener)
                        mListener.onTimeComplete();
                }
                mNextTime = 0;
                updateTimeText();
                return;
            }

            mNextTime--;

            updateTimeText();
        }
    };

    /**
     * 初始化时间
     *
     * @param _time_s
     */
    public void initTime(long _time_s) {
        mTime = mNextTime = _time_s;
        updateTimeText();
    }

    private void updateTimeText() {
        this.setText(label+mTimeFormat.format(new Date(mNextTime * 1000)));
    }

    public interface OnTimeCompleteListener {
        void onTimeComplete();
    }
}
