// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChoiceIdentityActivity_ViewBinding<T extends ChoiceIdentityActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ChoiceIdentityActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_next = Utils.findRequiredViewAsType(source, R.id.tv_next, "field 'tv_next'", TextView.class);
    target.radiogroup = Utils.findRequiredViewAsType(source, R.id.radiogroup, "field 'radiogroup'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_next = null;
    target.radiogroup = null;

    this.target = null;
  }
}
