package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.service.HomeApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeMdule_ProvideHomedelFactory implements Factory<HomeModel> {
  private final HomeMdule module;

  private final Provider<HomeApi> apiServiceProvider;

  public HomeMdule_ProvideHomedelFactory(HomeMdule module, Provider<HomeApi> apiServiceProvider) {
    assert module != null;
    this.module = module;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public HomeModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(apiServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeModel> create(HomeMdule module, Provider<HomeApi> apiServiceProvider) {
    return new HomeMdule_ProvideHomedelFactory(module, apiServiceProvider);
  }
}
