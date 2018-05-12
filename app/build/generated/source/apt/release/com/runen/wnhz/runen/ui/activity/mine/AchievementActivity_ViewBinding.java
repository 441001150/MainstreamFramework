// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AchievementActivity_ViewBinding<T extends AchievementActivity> implements Unbinder {
  protected T target;

  @UiThread
  public AchievementActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.iv_back = Utils.findRequiredViewAsType(source, R.id.iv_back, "field 'iv_back'", ImageView.class);
    target.tv_test_record = Utils.findRequiredViewAsType(source, R.id.tv_test_record, "field 'tv_test_record'", TextView.class);
    target.tv_errorback = Utils.findRequiredViewAsType(source, R.id.tv_errorback, "field 'tv_errorback'", TextView.class);
    target.start_text = Utils.findRequiredViewAsType(source, R.id.start_text, "field 'start_text'", TextView.class);
    target.tv_examinationDay = Utils.findRequiredViewAsType(source, R.id.tv_examinationDay, "field 'tv_examinationDay'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.iv_back = null;
    target.tv_test_record = null;
    target.tv_errorback = null;
    target.start_text = null;
    target.tv_examinationDay = null;

    this.target = null;
  }
}
