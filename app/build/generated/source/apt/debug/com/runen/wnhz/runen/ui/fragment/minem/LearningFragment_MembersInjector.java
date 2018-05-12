package com.runen.wnhz.runen.ui.fragment.minem;

import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LearningFragment_MembersInjector implements MembersInjector<LearningFragment> {
  private final Provider<ICoursePersenter> mPresenterProvider;

  public LearningFragment_MembersInjector(Provider<ICoursePersenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<LearningFragment> create(
      Provider<ICoursePersenter> mPresenterProvider) {
    return new LearningFragment_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(LearningFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    com.runen.wnhz.runen.ui.fragment.BaseFragment_MembersInjector.injectMPresenter(
        instance, mPresenterProvider);
  }
}
