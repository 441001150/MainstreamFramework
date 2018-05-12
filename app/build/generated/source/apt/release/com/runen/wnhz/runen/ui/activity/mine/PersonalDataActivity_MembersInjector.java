package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalDataActivity_MembersInjector
    implements MembersInjector<PersonalDataActivity> {
  private final Provider<IPersonal> mPresenterProvider;

  public PersonalDataActivity_MembersInjector(Provider<IPersonal> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<PersonalDataActivity> create(
      Provider<IPersonal> mPresenterProvider) {
    return new PersonalDataActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(PersonalDataActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
