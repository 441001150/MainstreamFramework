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

public class PersonalDataActivity_ViewBinding<T extends PersonalDataActivity> implements Unbinder {
  protected T target;

  @UiThread
  public PersonalDataActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rb_man = Utils.findRequiredViewAsType(source, R.id.rb_man, "field 'rb_man'", RadioButton.class);
    target.rb_woman = Utils.findRequiredViewAsType(source, R.id.rb_woman, "field 'rb_woman'", RadioButton.class);
    target.et_school = Utils.findRequiredViewAsType(source, R.id.et_school, "field 'et_school'", EditText.class);
    target.et_place = Utils.findRequiredViewAsType(source, R.id.et_place, "field 'et_place'", EditText.class);
    target.tv_personal_save = Utils.findRequiredViewAsType(source, R.id.tv_personal_save, "field 'tv_personal_save'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rb_man = null;
    target.rb_woman = null;
    target.et_school = null;
    target.et_place = null;
    target.tv_personal_save = null;

    this.target = null;
  }
}
