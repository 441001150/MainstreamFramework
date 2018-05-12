package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.FeedModule;
import com.runen.wnhz.runen.di.module.FeedModule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.FeedModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.presenter.iPresenter.IFeedPersenter;
import com.runen.wnhz.runen.presenter.iPresenter.IFeedPersenter_Factory;
import com.runen.wnhz.runen.presenter.model.FeedModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.ui.activity.mine.FeedbackActivity;
import com.runen.wnhz.runen.ui.activity.mine.FeedbackActivity_MembersInjector;
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
public final class DaggerFeedComponent implements FeedComponent {
  private Provider<PersonalCenterApi> personalCenterApiProvider;

  private Provider<FeedModel> provideHomedelProvider;

  private Provider<FeedContart.View> provideViewProvider;

  private Provider<IFeedPersenter> iFeedPersenterProvider;

  private MembersInjector<FeedbackActivity> feedbackActivityMembersInjector;

  private DaggerFeedComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.personalCenterApiProvider =
        new Factory<PersonalCenterApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public PersonalCenterApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.personalCenterApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideHomedelProvider =
        FeedModule_ProvideHomedelFactory.create(builder.feedModule, personalCenterApiProvider);

    this.provideViewProvider = FeedModule_ProvideViewFactory.create(builder.feedModule);

    this.iFeedPersenterProvider =
        IFeedPersenter_Factory.create(
            MembersInjectors.<IFeedPersenter>noOp(), provideHomedelProvider, provideViewProvider);

    this.feedbackActivityMembersInjector =
        FeedbackActivity_MembersInjector.create(iFeedPersenterProvider);
  }

  @Override
  public void initject(FeedbackActivity activity) {
    feedbackActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private FeedModule feedModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public FeedComponent build() {
      if (feedModule == null) {
        throw new IllegalStateException(FeedModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFeedComponent(this);
    }

    public Builder feedModule(FeedModule feedModule) {
      this.feedModule = Preconditions.checkNotNull(feedModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
