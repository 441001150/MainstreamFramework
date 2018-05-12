// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BalanceActivity_ViewBinding<T extends BalanceActivity> implements Unbinder {
  protected T target;

  @UiThread
  public BalanceActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_play = Utils.findRequiredViewAsType(source, R.id.tv_play, "field 'tv_play'", TextView.class);
    target.tv_user_money = Utils.findRequiredViewAsType(source, R.id.tv_user_money, "field 'tv_user_money'", TextView.class);
    target.et_money = Utils.findRequiredViewAsType(source, R.id.et_money, "field 'et_money'", EditText.class);
    target.ry_select_money = Utils.findRequiredViewAsType(source, R.id.ry_select_money, "field 'ry_select_money'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_play = null;
    target.tv_user_money = null;
    target.et_money = null;
    target.ry_select_money = null;

    this.target = null;
  }
}
