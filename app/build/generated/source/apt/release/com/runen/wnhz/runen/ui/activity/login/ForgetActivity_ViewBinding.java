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

public class ForgetActivity_ViewBinding<T extends ForgetActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ForgetActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.et_forget_input_phone = Utils.findRequiredViewAsType(source, R.id.et_forget_input_phone, "field 'et_forget_input_phone'", EditText.class);
    target.et_forget_input_vcode = Utils.findRequiredViewAsType(source, R.id.et_forget_input_vcode, "field 'et_forget_input_vcode'", EditText.class);
    target.et_forget_newpassword = Utils.findRequiredViewAsType(source, R.id.et_forget_newpassword, "field 'et_forget_newpassword'", EditText.class);
    target.et_forget_querpassword = Utils.findRequiredViewAsType(source, R.id.et_forget_querpassword, "field 'et_forget_querpassword'", EditText.class);
    target.tv_forget_login = Utils.findRequiredViewAsType(source, R.id.tv_forget_login, "field 'tv_forget_login'", TextView.class);
    target.tv_forget_v_code = Utils.findRequiredViewAsType(source, R.id.tv_forget_v_code, "field 'tv_forget_v_code'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_back = null;
    target.et_forget_input_phone = null;
    target.et_forget_input_vcode = null;
    target.et_forget_newpassword = null;
    target.et_forget_querpassword = null;
    target.tv_forget_login = null;
    target.tv_forget_v_code = null;

    this.target = null;
  }
}
