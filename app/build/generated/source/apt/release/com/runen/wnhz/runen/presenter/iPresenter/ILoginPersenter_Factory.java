package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import com.runen.wnhz.runen.presenter.model.LoginModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ILoginPersenter_Factory implements Factory<ILoginPersenter> {
  private final MembersInjector<ILoginPersenter> iLoginPersenterMembersInjector;

  private final Provider<LoginModel> mModelProvider;

  private final Provider<LoginContart.View> mViewProvider;

  public ILoginPersenter_Factory(
      MembersInjector<ILoginPersenter> iLoginPersenterMembersInjector,
      Provider<LoginModel> mModelProvider,
      Provider<LoginContart.View> mViewProvider) {
    assert iLoginPersenterMembersInjector != null;
    this.iLoginPersenterMembersInjector = iLoginPersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public ILoginPersenter get() {
    return MembersInjectors.injectMembers(
        iLoginPersenterMembersInjector,
        new ILoginPersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<ILoginPersenter> create(
      MembersInjector<ILoginPersenter> iLoginPersenterMembersInjector,
      Provider<LoginModel> mModelProvider,
      Provider<LoginContart.View> mViewProvider) {
    return new ILoginPersenter_Factory(
        iLoginPersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
