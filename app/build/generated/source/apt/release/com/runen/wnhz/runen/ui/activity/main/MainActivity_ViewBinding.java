// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rb_home = Utils.findRequiredViewAsType(source, R.id.rb_home, "field 'rb_home'", RadioButton.class);
    target.rb_major = Utils.findRequiredViewAsType(source, R.id.rb_major, "field 'rb_major'", RadioButton.class);
    target.rb_public = Utils.findRequiredViewAsType(source, R.id.rb_public, "field 'rb_public'", RadioButton.class);
    target.rb_mine = Utils.findRequiredViewAsType(source, R.id.rb_mine, "field 'rb_mine'", RadioButton.class);
    target.iv_ar = Utils.findRequiredViewAsType(source, R.id.iv_ar, "field 'iv_ar'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rb_home = null;
    target.rb_major = null;
    target.rb_public = null;
    target.rb_mine = null;
    target.iv_ar = null;

    this.target = null;
  }
}
