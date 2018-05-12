// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.fragment.minem;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding<T extends HomeFragment> implements Unbinder {
  protected T target;

  @UiThread
  public HomeFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.banner = Utils.findRequiredViewAsType(source, R.id.convenientBanner, "field 'banner'", Banner.class);
    target.tv_shuo_title = Utils.findRequiredViewAsType(source, R.id.tv_shuo_title, "field 'tv_shuo_title'", TextView.class);
    target.tv_shuo_view = Utils.findRequiredViewAsType(source, R.id.tv_shuo_view, "field 'tv_shuo_view'", TextView.class);
    target.tv_tushuo = Utils.findRequiredViewAsType(source, R.id.tv_tushuo, "field 'tv_tushuo'", TextView.class);
    target.iv_tushuo = Utils.findRequiredViewAsType(source, R.id.iv_tushuo, "field 'iv_tushuo'", ImageView.class);
    target.relativeLayout = Utils.findRequiredViewAsType(source, R.id.ry_tushuo, "field 'relativeLayout'", RelativeLayout.class);
    target.rvLesson = Utils.findRequiredViewAsType(source, R.id.ry_Forum, "field 'rvLesson'", RecyclerView.class);
    target.rvZiliao = Utils.findRequiredViewAsType(source, R.id.ry_ziliaojingxuan, "field 'rvZiliao'", RecyclerView.class);
    target.rvDataService = Utils.findRequiredViewAsType(source, R.id.ry_data_service, "field 'rvDataService'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.banner = null;
    target.tv_shuo_title = null;
    target.tv_shuo_view = null;
    target.tv_tushuo = null;
    target.iv_tushuo = null;
    target.relativeLayout = null;
    target.rvLesson = null;
    target.rvZiliao = null;
    target.rvDataService = null;

    this.target = null;
  }
}
