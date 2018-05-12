// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReceivingAddressActivity_ViewBinding<T extends ReceivingAddressActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ReceivingAddressActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_add_address = Utils.findRequiredViewAsType(source, R.id.tv_add_address, "field 'tv_add_address'", TextView.class);
    target.smart_refresh_layout = Utils.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'smart_refresh_layout'", SmartRefreshLayout.class);
    target.recycler_view = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recycler_view'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_add_address = null;
    target.smart_refresh_layout = null;
    target.recycler_view = null;

    this.target = null;
  }
}
