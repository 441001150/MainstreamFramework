package com.runen.wnhz.runen.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018-04-13.
 */

public class ViewPagerSlide extends ViewPager {
    public ViewPagerSlide(Context context) {
        super(context);
    }

    public ViewPagerSlide(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    //是否可以进行滑动
    private boolean isSlide = false;

    public void setSlide(boolean slide) {
        isSlide = slide;
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide;
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
    }
}
