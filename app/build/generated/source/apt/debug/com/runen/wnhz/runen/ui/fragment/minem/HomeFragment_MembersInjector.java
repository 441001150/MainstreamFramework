package com.runen.wnhz.runen.ui.fragment.minem;

import com.runen.wnhz.runen.presenter.iPresenter.IhomePersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
  private final Provider<IhomePersenter> mPresenterProvider;

  public HomeFragment_MembersInjector(Provider<IhomePersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<HomeFragment> create(Provider<IhomePersenter> mPresenterProvider) {
    return new HomeFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(HomeFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.fragment.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
