package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.model.AddressModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IAddressPersenter_Factory implements Factory<IAddressPersenter> {
  private final MembersInjector<IAddressPersenter> iAddressPersenterMembersInjector;

  private final Provider<AddressModel> mModelProvider;

  private final Provider<AddressContart.View> mViewProvider;

  public IAddressPersenter_Factory(
      MembersInjector<IAddressPersenter> iAddressPersenterMembersInjector,
      Provider<AddressModel> mModelProvider,
      Provider<AddressContart.View> mViewProvider) {
    assert iAddressPersenterMembersInjector != null;
    this.iAddressPersenterMembersInjector = iAddressPersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IAddressPersenter get() {
    return MembersInjectors.injectMembers(
        iAddressPersenterMembersInjector,
        new IAddressPersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IAddressPersenter> create(
      MembersInjector<IAddressPersenter> iAddressPersenterMembersInjector,
      Provider<AddressModel> mModelProvider,
      Provider<AddressContart.View> mViewProvider) {
    return new IAddressPersenter_Factory(
        iAddressPersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
