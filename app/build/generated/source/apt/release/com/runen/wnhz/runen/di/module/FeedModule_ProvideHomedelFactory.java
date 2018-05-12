package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.FeedModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedModule_ProvideHomedelFactory implements Factory<FeedModel> {
  private final FeedModule module;

  private final Provider<PersonalCenterApi> apiServiceProvider;

  public FeedModule_ProvideHomedelFactory(
      FeedModule module, Provider<PersonalCenterApi> apiServiceProvider) {
    assert module != null;
    this.module = module;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public FeedModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(apiServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FeedModel> create(
      FeedModule module, Provider<PersonalCenterApi> apiServiceProvider) {
    return new FeedModule_ProvideHomedelFactory(module, apiServiceProvider);
  }
}
