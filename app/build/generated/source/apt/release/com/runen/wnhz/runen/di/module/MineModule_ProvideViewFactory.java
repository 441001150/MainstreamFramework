package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.MineContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MineModule_ProvideViewFactory implements Factory<MineContart.View> {
  private final MineModule module;

  public MineModule_ProvideViewFactory(MineModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MineContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MineContart.View> create(MineModule module) {
    return new MineModule_ProvideViewFactory(module);
  }
}
