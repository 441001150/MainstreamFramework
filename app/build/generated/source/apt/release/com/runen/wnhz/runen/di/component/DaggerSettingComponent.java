package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.SettingModule;
import com.runen.wnhz.runen.di.module.SettingModule_ProvidePersonalModelFactory;
import com.runen.wnhz.runen.di.module.SettingModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import com.runen.wnhz.runen.presenter.iPresenter.ISettingPersenter;
import com.runen.wnhz.runen.presenter.iPresenter.ISettingPersenter_Factory;
import com.runen.wnhz.runen.presenter.model.SettingModel;
import com.runen.wnhz.runen.service.SettingApi;
import com.runen.wnhz.runen.ui.activity.mine.AccountSettingActivity;
import com.runen.wnhz.runen.ui.activity.mine.AccountSettingActivity_MembersInjector;
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
public final class DaggerSettingComponent implements SettingComponent {
  private Provider<SettingApi> settingApiProvider;

  private Provider<SettingModel> providePersonalModelProvider;

  private Provider<SettingCotart.View> provideViewProvider;

  private Provider<ISettingPersenter> iSettingPersenterProvider;

  private MembersInjector<AccountSettingActivity> accountSettingActivityMembersInjector;

  private DaggerSettingComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.settingApiProvider =
        new Factory<SettingApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public SettingApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.settingApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providePersonalModelProvider =
        SettingModule_ProvidePersonalModelFactory.create(builder.settingModule, settingApiProvider);

    this.provideViewProvider = SettingModule_ProvideViewFactory.create(builder.settingModule);

    this.iSettingPersenterProvider =
        ISettingPersenter_Factory.create(
            MembersInjectors.<ISettingPersenter>noOp(),
            providePersonalModelProvider,
            provideViewProvider);

    this.accountSettingActivityMembersInjector =
        AccountSettingActivity_MembersInjector.create(iSettingPersenterProvider);
  }

  @Override
  public void initJect(AccountSettingActivity activity) {
    accountSettingActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private SettingModule settingModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public SettingComponent build() {
      if (settingModule == null) {
        throw new IllegalStateException(SettingModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerSettingComponent(this);
    }

    public Builder settingModule(SettingModule settingModule) {
      this.settingModule = Preconditions.checkNotNull(settingModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
