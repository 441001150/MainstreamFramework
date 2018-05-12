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

public class VerificationActivity_ViewBinding<T extends VerificationActivity> implements Unbinder {
  protected T target;

  @UiThread
  public VerificationActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.et_input_phone = Utils.findRequiredViewAsType(source, R.id.et_input_phone, "field 'et_input_phone'", EditText.class);
    target.et_verification_input_vcode = Utils.findRequiredViewAsType(source, R.id.et_verification_input_vcode, "field 'et_verification_input_vcode'", EditText.class);
    target.tv_verification_code = Utils.findRequiredViewAsType(source, R.id.tv_verification_code, "field 'tv_verification_code'", TextView.class);
    target.tv_verification_login = Utils.findRequiredViewAsType(source, R.id.tv_verification_login, "field 'tv_verification_login'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_back = null;
    target.et_input_phone = null;
    target.et_verification_input_vcode = null;
    target.tv_verification_code = null;
    target.tv_verification_login = null;

    this.target = null;
  }
}
