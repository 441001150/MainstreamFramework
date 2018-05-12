package com.runen.wnhz.runen.ui.fragment;

import com.runen.wnhz.runen.presenter.BasePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseFragment_MembersInjector<T extends BasePresenter>
    implements MembersInjector<BaseFragment<T>> {
  private final Provider<T> mPresenterProvider;

  public BaseFragment_MembersInjector(Provider<T> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <T extends BasePresenter> MembersInjector<BaseFragment<T>> create(
      Provider<T> mPresenterProvider) {
    return new BaseFragment_MembersInjector<T>(mPresenterProvider);
  }

  @Override
  public void injectMembers(BaseFragment<T> instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static <T extends BasePresenter> void injectMPresenter(
      BaseFragment<T> instance, Provider<T> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
