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

public class LoginForPersonalActivity_ViewBinding<T extends LoginForPersonalActivity> implements Unbinder {
  protected T target;

  @UiThread
  public LoginForPersonalActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_skip = Utils.findRequiredViewAsType(source, R.id.tv_skip, "field 'tv_skip'", TextView.class);
    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.tv_register = Utils.findRequiredViewAsType(source, R.id.tv_register, "field 'tv_register'", TextView.class);
    target.et_input_phone = Utils.findRequiredViewAsType(source, R.id.et_input_phone, "field 'et_input_phone'", EditText.class);
    target.et_input_password = Utils.findRequiredViewAsType(source, R.id.et_input_password, "field 'et_input_password'", EditText.class);
    target.tv_login_verification = Utils.findRequiredViewAsType(source, R.id.tv_login_verification, "field 'tv_login_verification'", TextView.class);
    target.tv_forget_password = Utils.findRequiredViewAsType(source, R.id.tv_forget_password, "field 'tv_forget_password'", TextView.class);
    target.tv_pass_error = Utils.findRequiredViewAsType(source, R.id.tv_pass_error, "field 'tv_pass_error'", TextView.class);
    target.tv_login = Utils.findRequiredViewAsType(source, R.id.tv_login, "field 'tv_login'", TextView.class);
    target.iv_login_wx = Utils.findRequiredViewAsType(source, R.id.iv_login_wx, "field 'iv_login_wx'", ImageView.class);
    target.iv_login_qq = Utils.findRequiredViewAsType(source, R.id.iv_login_qq, "field 'iv_login_qq'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_skip = null;
    target.iv_back = null;
    target.tv_register = null;
    target.et_input_phone = null;
    target.et_input_password = null;
    target.tv_login_verification = null;
    target.tv_forget_password = null;
    target.tv_pass_error = null;
    target.tv_login = null;
    target.iv_login_wx = null;
    target.iv_login_qq = null;

    this.target = null;
  }
}
