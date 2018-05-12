package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IhomePersenter_Factory implements Factory<IhomePersenter> {
  private final MembersInjector<IhomePersenter> ihomePersenterMembersInjector;

  private final Provider<HomeModel> mModelProvider;

  private final Provider<HomeContart.View> mViewProvider;

  public IhomePersenter_Factory(
      MembersInjector<IhomePersenter> ihomePersenterMembersInjector,
      Provider<HomeModel> mModelProvider,
      Provider<HomeContart.View> mViewProvider) {
    assert ihomePersenterMembersInjector != null;
    this.ihomePersenterMembersInjector = ihomePersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IhomePersenter get() {
    return MembersInjectors.injectMembers(
        ihomePersenterMembersInjector,
        new IhomePersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IhomePersenter> create(
      MembersInjector<IhomePersenter> ihomePersenterMembersInjector,
      Provider<HomeModel> mModelProvider,
      Provider<HomeContart.View> mViewProvider) {
    return new IhomePersenter_Factory(ihomePersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
