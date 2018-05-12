package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginModule_ProvideViewFactory implements Factory<LoginContart.View> {
  private final LoginModule module;

  public LoginModule_ProvideViewFactory(LoginModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public LoginContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoginContart.View> create(LoginModule module) {
    return new LoginModule_ProvideViewFactory(module);
  }
}
