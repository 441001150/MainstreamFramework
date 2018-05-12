package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.IMinePersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BalanceActivity_MembersInjector implements MembersInjector<BalanceActivity> {
  private final Provider<IMinePersenter> mPresenterProvider;

  public BalanceActivity_MembersInjector(Provider<IMinePersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BalanceActivity> create(
      Provider<IMinePersenter> mPresenterProvider) {
    return new BalanceActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BalanceActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
