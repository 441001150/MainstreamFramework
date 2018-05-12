package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import com.runen.wnhz.runen.presenter.model.ArticleListModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IArticleListPerenter_Factory implements Factory<IArticleListPerenter> {
  private final MembersInjector<IArticleListPerenter> iArticleListPerenterMembersInjector;

  private final Provider<ArticleListModel> mModelProvider;

  private final Provider<ArticleListContart.View> mViewProvider;

  public IArticleListPerenter_Factory(
      MembersInjector<IArticleListPerenter> iArticleListPerenterMembersInjector,
      Provider<ArticleListModel> mModelProvider,
      Provider<ArticleListContart.View> mViewProvider) {
    assert iArticleListPerenterMembersInjector != null;
    this.iArticleListPerenterMembersInjector = iArticleListPerenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IArticleListPerenter get() {
    return MembersInjectors.injectMembers(
        iArticleListPerenterMembersInjector,
        new IArticleListPerenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IArticleListPerenter> create(
      MembersInjector<IArticleListPerenter> iArticleListPerenterMembersInjector,
      Provider<ArticleListModel> mModelProvider,
      Provider<ArticleListContart.View> mViewProvider) {
    return new IArticleListPerenter_Factory(
        iArticleListPerenterMembersInjector, mModelProvider, mViewProvider);
  }
}
