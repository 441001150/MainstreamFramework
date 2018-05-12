// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyEvaluationAdapter$ViewHodler_ViewBinding<T extends MyEvaluationAdapter.ViewHodler> implements Unbinder {
  protected T target;

  @UiThread
  public MyEvaluationAdapter$ViewHodler_ViewBinding(T target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.ry_evaluation, "field 'recyclerView'", RecyclerView.class);
    target.tv_type = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'tv_type'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.tv_type = null;

    this.target = null;
  }
}
