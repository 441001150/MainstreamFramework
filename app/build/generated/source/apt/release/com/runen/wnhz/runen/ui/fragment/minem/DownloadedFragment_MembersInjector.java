package com.runen.wnhz.runen.ui.fragment.minem;

import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DownloadedFragment_MembersInjector
    implements MembersInjector<DownloadedFragment> {
  private final Provider<ICoursePersenter> mPresenterProvider;

  public DownloadedFragment_MembersInjector(Provider<ICoursePersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<DownloadedFragment> create(
      Provider<ICoursePersenter> mPresenterProvider) {
    return new DownloadedFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(DownloadedFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.fragment.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
