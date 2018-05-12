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

public class AllRecyclerViewAdapter$ViewHodler_ViewBinding<T extends AllRecyclerViewAdapter.ViewHodler> implements Unbinder {
  protected T target;

  @UiThread
  public AllRecyclerViewAdapter$ViewHodler_ViewBinding(T target, View source) {
    this.target = target;

    target.item_path = Utils.findRequiredViewAsType(source, R.id.item__recycler, "field 'item_path'", ImageView.class);
    target.item_title = Utils.findRequiredViewAsType(source, R.id.item_title, "field 'item_title'", TextView.class);
    target.item_money = Utils.findRequiredViewAsType(source, R.id.item_money, "field 'item_money'", TextView.class);
    target.recycler_item = Utils.findRequiredViewAsType(source, R.id.recycler_item, "field 'recycler_item'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.item_path = null;
    target.item_title = null;
    target.item_money = null;
    target.recycler_item = null;

    this.target = null;
  }
}
