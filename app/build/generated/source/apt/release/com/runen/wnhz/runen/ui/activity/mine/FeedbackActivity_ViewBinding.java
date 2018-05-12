// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FeedbackActivity_ViewBinding<T extends FeedbackActivity> implements Unbinder {
  protected T target;

  @UiThread
  public FeedbackActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rb_product = Utils.findRequiredViewAsType(source, R.id.rb_product, "field 'rb_product'", RadioButton.class);
    target.rb_function = Utils.findRequiredViewAsType(source, R.id.rb_function, "field 'rb_function'", RadioButton.class);
    target.et_content = Utils.findRequiredViewAsType(source, R.id.et_content, "field 'et_content'", EditText.class);
    target.et_phone_or_email = Utils.findRequiredViewAsType(source, R.id.et_phone_or_email, "field 'et_phone_or_email'", EditText.class);
    target.tv_submit = Utils.findRequiredViewAsType(source, R.id.tv_submit, "field 'tv_submit'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rb_product = null;
    target.rb_function = null;
    target.et_content = null;
    target.et_phone_or_email = null;
    target.tv_submit = null;

    this.target = null;
  }
}
