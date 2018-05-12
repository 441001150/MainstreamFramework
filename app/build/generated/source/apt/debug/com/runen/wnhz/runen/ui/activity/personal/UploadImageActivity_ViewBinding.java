// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.personal;

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

public class UploadImageActivity_ViewBinding<T extends UploadImageActivity> implements Unbinder {
  protected T target;

  @UiThread
  public UploadImageActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.imageView = Utils.findRequiredViewAsType(source, R.id.imageView, "field 'imageView'", ImageView.class);
    target.tv_phone_xc = Utils.findRequiredViewAsType(source, R.id.tv_phone_xc, "field 'tv_phone_xc'", TextView.class);
    target.tv_phone_img = Utils.findRequiredViewAsType(source, R.id.tv_phone_img, "field 'tv_phone_img'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imageView = null;
    target.tv_phone_xc = null;
    target.tv_phone_img = null;

    this.target = null;
  }
}
