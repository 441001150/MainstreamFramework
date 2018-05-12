package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.LoginModel;
import com.runen.wnhz.runen.service.LoginServiceApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginModule_ProvideHomedelFactory implements Factory<LoginModel> {
  private final LoginModule module;

  private final Provider<LoginServiceApi> apiServiceProvider;

  public LoginModule_ProvideHomedelFactory(
      LoginModule module, Provider<LoginServiceApi> apiServiceProvider) {
    assert module != null;
    this.module = module;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public LoginModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(apiServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginModel> create(
      LoginModule module, Provider<LoginServiceApi> apiServiceProvider) {
    return new LoginModule_ProvideHomedelFactory(module, apiServiceProvider);
  }
}
