// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReceivingAdapter$ViewHodler_ViewBinding<T extends ReceivingAdapter.ViewHodler> implements Unbinder {
  protected T target;

  @UiThread
  public ReceivingAdapter$ViewHodler_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_user_name = Utils.findRequiredViewAsType(source, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
    target.tv_user_phone = Utils.findRequiredViewAsType(source, R.id.tv_user_phone, "field 'tv_user_phone'", TextView.class);
    target.tv_user_address = Utils.findRequiredViewAsType(source, R.id.tv_user_address, "field 'tv_user_address'", TextView.class);
    target.tv_default = Utils.findRequiredViewAsType(source, R.id.tv_default, "field 'tv_default'", TextView.class);
    target.tv_edit = Utils.findRequiredViewAsType(source, R.id.tv_edit, "field 'tv_edit'", TextView.class);
    target.tv_delete = Utils.findRequiredViewAsType(source, R.id.tv_delete, "field 'tv_delete'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_user_name = null;
    target.tv_user_phone = null;
    target.tv_user_address = null;
    target.tv_default = null;
    target.tv_edit = null;
    target.tv_delete = null;

    this.target = null;
  }
}
