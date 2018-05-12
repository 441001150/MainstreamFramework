package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.AddressModel;
import com.runen.wnhz.runen.service.ReceivingAddressApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddressModule_ProvideModelFactory implements Factory<AddressModel> {
  private final AddressModule module;

  private final Provider<ReceivingAddressApi> addressApiProvider;

  public AddressModule_ProvideModelFactory(
      AddressModule module, Provider<ReceivingAddressApi> addressApiProvider) {
    assert module != null;
    this.module = module;
    assert addressApiProvider != null;
    this.addressApiProvider = addressApiProvider;
  }

  @Override
  public AddressModel get() {
    return Preconditions.checkNotNull(
        module.provideModel(addressApiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AddressModel> create(
      AddressModule module, Provider<ReceivingAddressApi> addressApiProvider) {
    return new AddressModule_ProvideModelFactory(module, addressApiProvider);
  }
}
