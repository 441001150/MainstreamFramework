package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeMdule_ProvideViewFactory implements Factory<HomeContart.View> {
  private final HomeMdule module;

  public HomeMdule_ProvideViewFactory(HomeMdule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public HomeContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeContart.View> create(HomeMdule module) {
    return new HomeMdule_ProvideViewFactory(module);
  }
}
