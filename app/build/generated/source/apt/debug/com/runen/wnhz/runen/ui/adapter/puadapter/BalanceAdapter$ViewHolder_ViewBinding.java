// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BalanceAdapter$ViewHolder_ViewBinding<T extends BalanceAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public BalanceAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_price = Utils.findRequiredViewAsType(source, R.id.tv_price, "field 'tv_price'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_price = null;

    this.target = null;
  }
}
