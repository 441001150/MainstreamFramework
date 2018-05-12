package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ArticleMdule_ProvideViewFactory implements Factory<ArticleListContart.View> {
  private final ArticleMdule module;

  public ArticleMdule_ProvideViewFactory(ArticleMdule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public ArticleListContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ArticleListContart.View> create(ArticleMdule module) {
    return new ArticleMdule_ProvideViewFactory(module);
  }
}
