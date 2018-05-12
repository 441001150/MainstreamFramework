// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalCenterActivity_ViewBinding<T extends PersonalCenterActivity> implements Unbinder {
  protected T target;

  @UiThread
  public PersonalCenterActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.rl_personal_data = Utils.findRequiredViewAsType(source, R.id.rl_personal_data, "field 'rl_personal_data'", RelativeLayout.class);
    target.rl_personal_img = Utils.findRequiredViewAsType(source, R.id.rl_personal_img, "field 'rl_personal_img'", RelativeLayout.class);
    target.rl_change_password = Utils.findRequiredViewAsType(source, R.id.rl_change_password, "field 'rl_change_password'", RelativeLayout.class);
    target.personal_myname = Utils.findRequiredViewAsType(source, R.id.personal_myname, "field 'personal_myname'", RelativeLayout.class);
    target.tv_phone_num = Utils.findRequiredViewAsType(source, R.id.tv_phone_num, "field 'tv_phone_num'", TextView.class);
    target.tv_nick_name = Utils.findRequiredViewAsType(source, R.id.tv_nick_name, "field 'tv_nick_name'", TextView.class);
    target.tv_logout = Utils.findRequiredViewAsType(source, R.id.tv_logout, "field 'tv_logout'", TextView.class);
    target.personal_image = Utils.findRequiredViewAsType(source, R.id.personal_image, "field 'personal_image'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.rl_personal_data = null;
    target.rl_personal_img = null;
    target.rl_change_password = null;
    target.personal_myname = null;
    target.tv_phone_num = null;
    target.tv_nick_name = null;
    target.tv_logout = null;
    target.personal_image = null;

    this.target = null;
  }
}
