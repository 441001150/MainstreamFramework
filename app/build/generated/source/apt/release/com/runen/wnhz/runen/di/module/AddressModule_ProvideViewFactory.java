package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddressModule_ProvideViewFactory implements Factory<AddressContart.View> {
  private final AddressModule module;

  public AddressModule_ProvideViewFactory(AddressModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AddressContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AddressContart.View> create(AddressModule module) {
    return new AddressModule_ProvideViewFactory(module);
  }
}
