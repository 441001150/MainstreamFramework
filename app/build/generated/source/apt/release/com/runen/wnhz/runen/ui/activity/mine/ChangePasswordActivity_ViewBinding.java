// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangePasswordActivity_ViewBinding<T extends ChangePasswordActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ChangePasswordActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.et_change_password = Utils.findRequiredViewAsType(source, R.id.et_change_password, "field 'et_change_password'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.et_change_password = null;

    this.target = null;
  }
}
