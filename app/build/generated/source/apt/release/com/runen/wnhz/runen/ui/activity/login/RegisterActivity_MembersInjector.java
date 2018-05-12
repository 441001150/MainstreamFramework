package com.runen.wnhz.runen.ui.activity.login;

import com.runen.wnhz.runen.presenter.iPresenter.ILoginPersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RegisterActivity_MembersInjector implements MembersInjector<RegisterActivity> {
  private final Provider<ILoginPersenter> mPresenterProvider;

  public RegisterActivity_MembersInjector(Provider<ILoginPersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<RegisterActivity> create(
      Provider<ILoginPersenter> mPresenterProvider) {
    return new RegisterActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(RegisterActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
