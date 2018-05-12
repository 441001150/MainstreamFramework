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

public class DownloadedFragment_ViewBinding<T extends DownloadedFragment> implements Unbinder {
  protected T target;

  @UiThread
  public DownloadedFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.smart_refresh_layout = Utils.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'smart_refresh_layout'", SmartRefreshLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rv_downloaded, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.smart_refresh_layout = null;
    target.recyclerView = null;

    this.target = null;
  }
}
