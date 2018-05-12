package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.MineModule;
import com.runen.wnhz.runen.di.module.MineModule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.MineModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.MineContart;
import com.runen.wnhz.runen.presenter.iPresenter.IMinePersenter;
import com.runen.wnhz.runen.presenter.iPresenter.IMinePersenter_Factory;
import com.runen.wnhz.runen.presenter.model.MineModel;
import com.runen.wnhz.runen.service.MineServiceApi;
import com.runen.wnhz.runen.ui.activity.mine.BalanceActivity;
import com.runen.wnhz.runen.ui.activity.mine.BalanceActivity_MembersInjector;
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
public final class DaggerMineComponent implements MineComponent {
  private Provider<MineServiceApi> mineServiceApiProvider;

  private Provider<MineModel> provideHomedelProvider;

  private Provider<MineContart.View> provideViewProvider;

  private Provider<IMinePersenter> iMinePersenterProvider;

  private MembersInjector<BalanceActivity> balanceActivityMembersInjector;

  private DaggerMineComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.mineServiceApiProvider =
        new Factory<MineServiceApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public MineServiceApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.mineServiceApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideHomedelProvider =
        MineModule_ProvideHomedelFactory.create(builder.mineModule, mineServiceApiProvider);

    this.provideViewProvider = MineModule_ProvideViewFactory.create(builder.mineModule);

    this.iMinePersenterProvider =
        IMinePersenter_Factory.create(
            MembersInjectors.<IMinePersenter>noOp(), provideHomedelProvider, provideViewProvider);

    this.balanceActivityMembersInjector =
        BalanceActivity_MembersInjector.create(iMinePersenterProvider);
  }

  @Override
  public void initject(BalanceActivity activity) {
    balanceActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private MineModule mineModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public MineComponent build() {
      if (mineModule == null) {
        throw new IllegalStateException(MineModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerMineComponent(this);
    }

    public Builder mineModule(MineModule mineModule) {
      this.mineModule = Preconditions.checkNotNull(mineModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
