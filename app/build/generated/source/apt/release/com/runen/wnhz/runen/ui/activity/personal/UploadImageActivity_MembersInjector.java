package com.runen.wnhz.runen.ui.activity.personal;

import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UploadImageActivity_MembersInjector
    implements MembersInjector<UploadImageActivity> {
  private final Provider<IPersonal> mPresenterProvider;

  public UploadImageActivity_MembersInjector(Provider<IPersonal> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<UploadImageActivity> create(
      Provider<IPersonal> mPresenterProvider) {
    return new UploadImageActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(UploadImageActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
