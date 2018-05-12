package com.runen.wnhz.runen.ui.activity;

import com.runen.wnhz.runen.presenter.iPresenter.IArticleListPerenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ArticleListActivity_MembersInjector
    implements MembersInjector<ArticleListActivity> {
  private final Provider<IArticleListPerenter> mPresenterProvider;

  public ArticleListActivity_MembersInjector(Provider<IArticleListPerenter> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<ArticleListActivity> create(
      Provider<IArticleListPerenter> mPresenterProvider) {
    return new ArticleListActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(ArticleListActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    ((BaseActivity) instance).mPresenter = mPresenterProvider.get();
  }
}
