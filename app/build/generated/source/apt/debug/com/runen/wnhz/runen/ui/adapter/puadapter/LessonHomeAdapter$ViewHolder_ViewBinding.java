// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LessonHomeAdapter$ViewHolder_ViewBinding<T extends LessonHomeAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public LessonHomeAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.recycler_item = Utils.findRequiredViewAsType(source, R.id.recycler_item, "field 'recycler_item'", LinearLayout.class);
    target.ivPic = Utils.findRequiredViewAsType(source, R.id.iv_pic, "field 'ivPic'", ImageView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvStar = Utils.findRequiredViewAsType(source, R.id.tv_star, "field 'tvStar'", TextView.class);
    target.tvViews = Utils.findRequiredViewAsType(source, R.id.tv_views, "field 'tvViews'", TextView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tvPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recycler_item = null;
    target.ivPic = null;
    target.tvTitle = null;
    target.tvStar = null;
    target.tvViews = null;
    target.tvPrice = null;

    this.target = null;
  }
}
