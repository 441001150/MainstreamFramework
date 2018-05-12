package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.ArticleMdule;
import com.runen.wnhz.runen.di.module.ArticleMdule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.ArticleMdule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.ArticleListContart;
import com.runen.wnhz.runen.presenter.iPresenter.IArticleListPerenter;
import com.runen.wnhz.runen.presenter.iPresenter.IArticleListPerenter_Factory;
import com.runen.wnhz.runen.presenter.model.ArticleListModel;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.ui.activity.ArticleListActivity;
import com.runen.wnhz.runen.ui.activity.ArticleListActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerArticleComponent implements ArticleComponent {
  private Provider<HomeApi> homeApisercivceProvider;

  private Provider<ArticleListModel> provideHomedelProvider;

  private Provider<ArticleListContart.View> provideViewProvider;

  private Provider<IArticleListPerenter> iArticleListPerenterProvider;

  private MembersInjector<ArticleListActivity> articleListActivityMembersInjector;

  private DaggerArticleComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.homeApisercivceProvider =
        new Factory<HomeApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public HomeApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.homeApisercivce(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideHomedelProvider =
        ArticleMdule_ProvideHomedelFactory.create(builder.articleMdule, homeApisercivceProvider);

    this.provideViewProvider = ArticleMdule_ProvideViewFactory.create(builder.articleMdule);

    this.iArticleListPerenterProvider =
        IArticleListPerenter_Factory.create(
            MembersInjectors.<IArticleListPerenter>noOp(),
            provideHomedelProvider,
            provideViewProvider);

    this.articleListActivityMembersInjector =
        ArticleListActivity_MembersInjector.create(iArticleListPerenterProvider);
  }

  @Override
  public void initject(ArticleListActivity activity) {
    articleListActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ArticleMdule articleMdule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ArticleComponent build() {
      if (articleMdule == null) {
        throw new IllegalStateException(ArticleMdule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerArticleComponent(this);
    }

    public Builder articleMdule(ArticleMdule articleMdule) {
      this.articleMdule = Preconditions.checkNotNull(articleMdule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
