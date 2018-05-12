// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.fragment.major;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MajorFragment_ViewBinding<T extends MajorFragment> implements Unbinder {
  protected T target;

  @UiThread
  public MajorFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.rl_professional = Utils.findRequiredViewAsType(source, R.id.rl_professional, "field 'rl_professional'", RelativeLayout.class);
    target.rl_publics = Utils.findRequiredViewAsType(source, R.id.rl_publics, "field 'rl_publics'", RelativeLayout.class);
    target.rl_project = Utils.findRequiredViewAsType(source, R.id.rl_project, "field 'rl_project'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rl_professional = null;
    target.rl_publics = null;
    target.rl_project = null;

    this.target = null;
  }
}
