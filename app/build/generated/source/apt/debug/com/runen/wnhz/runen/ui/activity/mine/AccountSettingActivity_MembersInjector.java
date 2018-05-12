package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.ISettingPersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AccountSettingActivity_MembersInjector
    implements MembersInjector<AccountSettingActivity> {
  private final Provider<ISettingPersenter> mPresenterProvider;

  public AccountSettingActivity_MembersInjector(Provider<ISettingPersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<AccountSettingActivity> create(
      Provider<ISettingPersenter> mPresenterProvider) {
    return new AccountSettingActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(AccountSettingActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
