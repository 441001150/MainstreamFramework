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

public class RegisterActivity_ViewBinding<T extends RegisterActivity> implements Unbinder {
  protected T target;

  @UiThread
  public RegisterActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_skip = Utils.findRequiredViewAsType(source, R.id.tv_skip, "field 'tv_skip'", TextView.class);
    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.tv_v_code = Utils.findRequiredViewAsType(source, R.id.tv_v_code, "field 'tv_v_code'", TextView.class);
    target.et_input_phone = Utils.findRequiredViewAsType(source, R.id.et_input_phone, "field 'et_input_phone'", EditText.class);
    target.et_input_vcode = Utils.findRequiredViewAsType(source, R.id.et_input_vcode, "field 'et_input_vcode'", EditText.class);
    target.et_input_password = Utils.findRequiredViewAsType(source, R.id.et_input_password, "field 'et_input_password'", EditText.class);
    target.tv_login = Utils.findRequiredViewAsType(source, R.id.tv_register, "field 'tv_login'", TextView.class);
    target.tv_agreement = Utils.findRequiredViewAsType(source, R.id.tv_agreement, "field 'tv_agreement'", TextView.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.iv_agreement, "field 'imageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_skip = null;
    target.iv_back = null;
    target.tv_v_code = null;
    target.et_input_phone = null;
    target.et_input_vcode = null;
    target.et_input_password = null;
    target.tv_login = null;
    target.tv_agreement = null;
    target.imageView = null;

    this.target = null;
  }
}
