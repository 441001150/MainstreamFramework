package com.runen.wnhz.runen.ui.activity.mine;

import com.runen.wnhz.runen.presenter.iPresenter.IFeedPersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FeedbackActivity_MembersInjector implements MembersInjector<FeedbackActivity> {
  private final Provider<IFeedPersenter> mPresenterProvider;

  public FeedbackActivity_MembersInjector(Provider<IFeedPersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<FeedbackActivity> create(
      Provider<IFeedPersenter> mPresenterProvider) {
    return new FeedbackActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(FeedbackActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.activity.BaseActivity_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
