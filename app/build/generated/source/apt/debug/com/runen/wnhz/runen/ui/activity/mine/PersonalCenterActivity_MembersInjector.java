package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalCenterActivity_MembersInjector
    implements MembersInjector<PersonalCenterActivity> {
  private final Provider<IPersonal> mPresenterProvider;

  public PersonalCenterActivity_MembersInjector(Provider<IPersonal> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PersonalCenterActivity> create(
      Provider<IPersonal> mPresenterProvider) {
    return new PersonalCenterActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PersonalCenterActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
