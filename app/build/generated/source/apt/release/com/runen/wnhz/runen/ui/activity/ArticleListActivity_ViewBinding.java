// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ArticleListActivity_ViewBinding<T extends ArticleListActivity> implements Unbinder {
  protected T target;

  private View view2131624082;

  @UiThread
  public ArticleListActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'onClick'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view2131624082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.ry_articlelist, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivBack = null;
    target.mRecyclerView = null;

    view2131624082.setOnClickListener(null);
    view2131624082 = null;

    this.target = null;
  }
}
