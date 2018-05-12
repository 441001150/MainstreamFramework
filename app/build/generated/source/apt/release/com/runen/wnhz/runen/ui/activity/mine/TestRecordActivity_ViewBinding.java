// Generated code from Butter Knife. Do not modify!
package com.runen.wnhz.runen.ui.activity.mine;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.runen.wnhz.runen.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TestRecordActivity_ViewBinding<T extends TestRecordActivity> implements Unbinder {
  protected T target;

  @UiThread
  public TestRecordActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.chart = Utils.findRequiredViewAsType(source, R.id.chart, "field 'chart'", BarChart.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.chart = null;

    this.target = null;
  }
}
