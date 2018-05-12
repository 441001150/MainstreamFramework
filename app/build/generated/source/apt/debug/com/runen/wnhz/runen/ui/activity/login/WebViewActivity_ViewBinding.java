// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebViewActivity_ViewBinding<T extends WebViewActivity> implements Unbinder {
  protected T target;

  @UiThread
  public WebViewActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.webview = Utils.findRequiredViewAsType(source, R.id.webview, "field 'webview'", WebView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.webview = null;

    this.target = null;
  }
}
