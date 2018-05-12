// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleListAdapter$ViewHolder_ViewBinding<T extends ArticleListAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ArticleListAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.recycler_item = Utils.findRequiredViewAsType(source, R.id.recycler_item, "field 'recycler_item'", RelativeLayout.class);
    target.ivTushuo = Utils.findRequiredViewAsType(source, R.id.iv_tushuo, "field 'ivTushuo'", ImageView.class);
    target.tvShuoTitle = Utils.findRequiredViewAsType(source, R.id.tv_shuo_title, "field 'tvShuoTitle'", TextView.class);
    target.tvShuoView = Utils.findRequiredViewAsType(source, R.id.tv_shuo_view, "field 'tvShuoView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recycler_item = null;
    target.ivTushuo = null;
    target.tvShuoTitle = null;
    target.tvShuoView = null;

    this.target = null;
  }
}
