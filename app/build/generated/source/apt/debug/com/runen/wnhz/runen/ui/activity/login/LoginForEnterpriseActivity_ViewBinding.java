// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginForEnterpriseActivity_ViewBinding<T extends LoginForEnterpriseActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LoginForEnterpriseActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.tv_forenterpr_next = Utils.findRequiredViewAsType(source, R.id.tv_forenterpr_next, "field 'tv_forenterpr_next'", TextView.class);
    target.et_input_phone = Utils.findRequiredViewAsType(source, R.id.et_input_phone, "field 'et_input_phone'", EditText.class);
    target.et_input_password = Utils.findRequiredViewAsType(source, R.id.et_input_password, "field 'et_input_password'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_back = null;
    target.tv_forenterpr_next = null;
    target.et_input_phone = null;
    target.et_input_password = null;

    this.target = null;
  }
}
