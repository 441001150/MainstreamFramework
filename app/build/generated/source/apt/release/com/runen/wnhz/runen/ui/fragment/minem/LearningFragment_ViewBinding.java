// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.fragment.minem;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LearningFragment_ViewBinding<T extends LearningFragment> implements Unbinder {
  protected T target;

  @UiThread
  public LearningFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rv_message, "field 'recyclerView'", RecyclerView.class);
    target.smartRefreshLayout = Utils.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'smartRefreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.smartRefreshLayout = null;

    this.target = null;
  }
}
