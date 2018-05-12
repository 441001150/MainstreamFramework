// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AccountSettingActivity_ViewBinding<T extends AccountSettingActivity> implements Unbinder {
  protected T target;

  @UiThread
  public AccountSettingActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.tv_bind_wx = Utils.findRequiredViewAsType(source, R.id.tv_bind_wx, "field 'tv_bind_wx'", TextView.class);
    target.tv_bind_qq = Utils.findRequiredViewAsType(source, R.id.tv_bind_qq, "field 'tv_bind_qq'", TextView.class);
    target.sw_auto_play = Utils.findRequiredViewAsType(source, R.id.sw_auto_play, "field 'sw_auto_play'", Switch.class);
    target.sw_wap_watch = Utils.findRequiredViewAsType(source, R.id.sw_wap_watch, "field 'sw_wap_watch'", Switch.class);
    target.sw_wap_download = Utils.findRequiredViewAsType(source, R.id.sw_wap_download, "field 'sw_wap_download'", Switch.class);
    target.tv_clear_cache = Utils.findRequiredViewAsType(source, R.id.tv_clear_cache, "field 'tv_clear_cache'", Switch.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tv_bind_wx = null;
    target.tv_bind_qq = null;
    target.sw_auto_play = null;
    target.sw_wap_watch = null;
    target.sw_wap_download = null;
    target.tv_clear_cache = null;

    this.target = null;
  }
}
