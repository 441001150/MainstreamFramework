// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddAddressActivity_ViewBinding<T extends AddAddressActivity> implements Unbinder {
  protected T target;

  @UiThread
  public AddAddressActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rl_select_address = Utils.findRequiredViewAsType(source, R.id.rl_select_address, "field 'rl_select_address'", RelativeLayout.class);
    target.tv_select_address = Utils.findRequiredViewAsType(source, R.id.tv_save_address, "field 'tv_select_address'", TextView.class);
    target.sw_default_address = Utils.findRequiredViewAsType(source, R.id.sw_default_address, "field 'sw_default_address'", Switch.class);
    target.et_name = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'et_name'", EditText.class);
    target.et_phone = Utils.findRequiredViewAsType(source, R.id.et_phone, "field 'et_phone'", EditText.class);
    target.et_address = Utils.findRequiredViewAsType(source, R.id.et_address, "field 'et_address'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rl_select_address = null;
    target.tv_select_address = null;
    target.sw_default_address = null;
    target.et_name = null;
    target.et_phone = null;
    target.et_address = null;

    this.target = null;
  }
}
