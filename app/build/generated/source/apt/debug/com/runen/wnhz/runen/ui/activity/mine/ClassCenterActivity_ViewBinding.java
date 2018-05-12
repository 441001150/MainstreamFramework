// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClassCenterActivity_ViewBinding<T extends ClassCenterActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ClassCenterActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rg = Utils.findRequiredViewAsType(source, R.id.rg, "field 'rg'", RadioGroup.class);
    target.rb1 = Utils.findRequiredViewAsType(source, R.id.rb1, "field 'rb1'", RadioButton.class);
    target.rb2 = Utils.findRequiredViewAsType(source, R.id.rb2, "field 'rb2'", RadioButton.class);
    target.vp = Utils.findRequiredViewAsType(source, R.id.vp, "field 'vp'", ViewPager.class);
    target.v_v = Utils.findRequiredView(source, R.id.v_v, "field 'v_v'");
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rg = null;
    target.rb1 = null;
    target.rb2 = null;
    target.vp = null;
    target.v_v = null;

    this.target = null;
  }
}
