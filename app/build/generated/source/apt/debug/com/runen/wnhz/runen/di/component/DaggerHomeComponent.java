package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.HomeMdule;
import com.runen.wnhz.runen.di.module.HomeMdule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.HomeMdule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.HomeContart;
import com.runen.wnhz.runen.presenter.iPresenter.IhomePersenter;
import com.runen.wnhz.runen.presenter.iPresenter.IhomePersenter_Factory;
import com.runen.wnhz.runen.presenter.model.HomeModel;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.ui.fragment.minem.HomeFragment;
import com.runen.wnhz.runen.ui.fragment.minem.HomeFragment_MembersInjector;
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
public final class DaggerHomeComponent implements HomeComponent {
  private Provider<HomeApi> homeApisercivceProvider;

  private Provider<HomeModel> provideHomedelProvider;

  private Provider<HomeContart.View> provideViewProvider;

  private Provider<IhomePersenter> ihomePersenterProvider;

  private MembersInjector<HomeFragment> homeFragmentMembersInjector;

  private DaggerHomeComponent(Builder builder) {
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
        HomeMdule_ProvideHomedelFactory.create(builder.homeMdule, homeApisercivceProvider);

    this.provideViewProvider = HomeMdule_ProvideViewFactory.create(builder.homeMdule);

    this.ihomePersenterProvider =
        IhomePersenter_Factory.create(
            MembersInjectors.<IhomePersenter>noOp(), provideHomedelProvider, provideViewProvider);

    this.homeFragmentMembersInjector = HomeFragment_MembersInjector.create(ihomePersenterProvider);
  }

  @Override
  public void initject(HomeFragment homeFragment) {
    homeFragmentMembersInjector.injectMembers(homeFragment);
  }

  public static final class Builder {
    private HomeMdule homeMdule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public HomeComponent build() {
      if (homeMdule == null) {
        throw new IllegalStateException(HomeMdule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerHomeComponent(this);
    }

    public Builder homeMdule(HomeMdule homeMdule) {
      this.homeMdule = Preconditions.checkNotNull(homeMdule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
