package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.IAddressPersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddAddressActivity_MembersInjector
    implements MembersInjector<AddAddressActivity> {
  private final Provider<IAddressPersenter> mPresenterProvider;

  public AddAddressActivity_MembersInjector(Provider<IAddressPersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AddAddressActivity> create(
      Provider<IAddressPersenter> mPresenterProvider) {
    return new AddAddressActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AddAddressActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
