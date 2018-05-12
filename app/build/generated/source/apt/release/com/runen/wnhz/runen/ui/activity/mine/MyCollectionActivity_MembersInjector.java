package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyCollectionActivity_MembersInjector
    implements MembersInjector<MyCollectionActivity> {
  private final Provider<ICoursePersenter> mPresenterProvider;

  public MyCollectionActivity_MembersInjector(Provider<ICoursePersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MyCollectionActivity> create(
      Provider<ICoursePersenter> mPresenterProvider) {
    return new MyCollectionActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MyCollectionActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
