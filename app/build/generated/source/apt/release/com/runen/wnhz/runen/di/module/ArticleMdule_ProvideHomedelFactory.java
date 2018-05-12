package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.ArticleListModel;
import com.runen.wnhz.runen.service.HomeApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ArticleMdule_ProvideHomedelFactory implements Factory<ArticleListModel> {
  private final ArticleMdule module;

  private final Provider<HomeApi> apiServiceProvider;

  public ArticleMdule_ProvideHomedelFactory(
      ArticleMdule module, Provider<HomeApi> apiServiceProvider) {
    assert module != null;
    this.module = module;
    assert apiServiceProvider != null;
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ArticleListModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(apiServiceProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ArticleListModel> create(
      ArticleMdule module, Provider<HomeApi> apiServiceProvider) {
    return new ArticleMdule_ProvideHomedelFactory(module, apiServiceProvider);
  }
}
