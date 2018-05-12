// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

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

public class ErrorBackActivity_ViewBinding<T extends ErrorBackActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ErrorBackActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.tv_clear = Utils.findRequiredViewAsType(source, R.id.tv_clear, "field 'tv_clear'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_back = null;
    target.tv_title = null;
    target.tv_clear = null;

    this.target = null;
  }
}
