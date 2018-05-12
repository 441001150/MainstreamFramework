package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.SettingModel;
import com.runen.wnhz.runen.service.SettingApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingModule_ProvidePersonalModelFactory implements Factory<SettingModel> {
  private final SettingModule module;

  private final Provider<SettingApi> settingApiProvider;

  public SettingModule_ProvidePersonalModelFactory(
      SettingModule module, Provider<SettingApi> settingApiProvider) {
    assert module != null;
    this.module = module;
    assert settingApiProvider != null;
    this.settingApiProvider = settingApiProvider;
  }

  @Override
  public SettingModel get() {
    return Preconditions.checkNotNull(
        module.providePersonalModel(settingApiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SettingModel> create(
      SettingModule module, Provider<SettingApi> settingApiProvider) {
    return new SettingModule_ProvidePersonalModelFactory(module, settingApiProvider);
  }
}
