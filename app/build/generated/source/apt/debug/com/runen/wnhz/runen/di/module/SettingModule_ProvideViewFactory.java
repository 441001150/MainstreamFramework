package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingModule_ProvideViewFactory implements Factory<SettingCotart.View> {
  private final SettingModule module;

  public SettingModule_ProvideViewFactory(SettingModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public SettingCotart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SettingCotart.View> create(SettingModule module) {
    return new SettingModule_ProvideViewFactory(module);
  }
}
