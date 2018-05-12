package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.MineModel;
import com.runen.wnhz.runen.service.MineServiceApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MineModule_ProvideHomedelFactory implements Factory<MineModel> {
  private final MineModule module;

  private final Provider<MineServiceApi> mineServiceApiProvider;

  public MineModule_ProvideHomedelFactory(
      MineModule module, Provider<MineServiceApi> mineServiceApiProvider) {
    assert module != null;
    this.module = module;
    assert mineServiceApiProvider != null;
    this.mineServiceApiProvider = mineServiceApiProvider;
  }

  @Override
  public MineModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(mineServiceApiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MineModel> create(
      MineModule module, Provider<MineServiceApi> mineServiceApiProvider) {
    return new MineModule_ProvideHomedelFactory(module, mineServiceApiProvider);
  }
}
