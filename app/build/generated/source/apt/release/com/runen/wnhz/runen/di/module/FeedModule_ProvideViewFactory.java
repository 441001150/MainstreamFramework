package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedModule_ProvideViewFactory implements Factory<FeedContart.View> {
  private final FeedModule module;

  public FeedModule_ProvideViewFactory(FeedModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public FeedContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FeedContart.View> create(FeedModule module) {
    return new FeedModule_ProvideViewFactory(module);
  }
}
