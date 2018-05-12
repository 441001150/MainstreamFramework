// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CourseAdapter$ViewHodler_ViewBinding<T extends CourseAdapter.ViewHodler> implements Unbinder {
  protected T target;

  @UiThread
  public CourseAdapter$ViewHodler_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_collection_img = Utils.findRequiredViewAsType(source, R.id.iv_collection_img, "field 'iv_collection_img'", ImageView.class);
    target.tv_collection_title = Utils.findRequiredViewAsType(source, R.id.tv_collection_title, "field 'tv_collection_title'", TextView.class);
    target.tv_collection_data = Utils.findRequiredViewAsType(source, R.id.tv_collection_data, "field 'tv_collection_data'", TextView.class);
    target.tv_yikan = Utils.findRequiredViewAsType(source, R.id.tv_yikan, "field 'tv_yikan'", TextView.class);
    target.tv_yidown = Utils.findRequiredViewAsType(source, R.id.tv_yidown, "field 'tv_yidown'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_collection_img = null;
    target.tv_collection_title = null;
    target.tv_collection_data = null;
    target.tv_yikan = null;
    target.tv_yidown = null;

    this.target = null;
  }
}
