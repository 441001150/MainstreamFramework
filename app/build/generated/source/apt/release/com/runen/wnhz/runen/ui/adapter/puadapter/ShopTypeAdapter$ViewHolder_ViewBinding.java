// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.adapter.puadapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopTypeAdapter$ViewHolder_ViewBinding<T extends ShopTypeAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public ShopTypeAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.recycler_item = Utils.findRequiredViewAsType(source, R.id.recycler_item, "field 'recycler_item'", LinearLayout.class);
    target.ivShopType = Utils.findRequiredViewAsType(source, R.id.iv_shop_type, "field 'ivShopType'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recycler_item = null;
    target.ivShopType = null;

    this.target = null;
  }
}
