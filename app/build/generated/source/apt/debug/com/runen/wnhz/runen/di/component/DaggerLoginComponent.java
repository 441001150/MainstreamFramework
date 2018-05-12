package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.LoginModule;
import com.runen.wnhz.runen.di.module.LoginModule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.LoginModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.LoginContart;
import com.runen.wnhz.runen.presenter.iPresenter.ILoginPersenter;
import com.runen.wnhz.runen.presenter.iPresenter.ILoginPersenter_Factory;
import com.runen.wnhz.runen.presenter.model.LoginModel;
import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.ui.activity.login.ForgetActivity;
import com.runen.wnhz.runen.ui.activity.login.ForgetActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.login.LoginForPersonalActivity;
import com.runen.wnhz.runen.ui.activity.login.LoginForPersonalActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.login.RegisterActivity;
import com.runen.wnhz.runen.ui.activity.login.RegisterActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.login.VerificationActivity;
import com.runen.wnhz.runen.ui.activity.login.VerificationActivity_MembersInjector;
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
public final class DaggerLoginComponent implements LoginComponent {
  private Provider<LoginServiceApi> loginServiceApiProvider;

  private Provider<LoginModel> provideHomedelProvider;

  private Provider<LoginContart.View> provideViewProvider;

  private Provider<ILoginPersenter> iLoginPersenterProvider;

  private MembersInjector<RegisterActivity> registerActivityMembersInjector;

  private MembersInjector<VerificationActivity> verificationActivityMembersInjector;

  private MembersInjector<ForgetActivity> forgetActivityMembersInjector;

  private MembersInjector<LoginForPersonalActivity> loginForPersonalActivityMembersInjector;

  private DaggerLoginComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.loginServiceApiProvider =
        new Factory<LoginServiceApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public LoginServiceApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.loginServiceApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideHomedelProvider =
        LoginModule_ProvideHomedelFactory.create(builder.loginModule, loginServiceApiProvider);

    this.provideViewProvider = LoginModule_ProvideViewFactory.create(builder.loginModule);

    this.iLoginPersenterProvider =
        ILoginPersenter_Factory.create(
            MembersInjectors.<ILoginPersenter>noOp(), provideHomedelProvider, provideViewProvider);

    this.registerActivityMembersInjector =
        RegisterActivity_MembersInjector.create(iLoginPersenterProvider);

    this.verificationActivityMembersInjector =
        VerificationActivity_MembersInjector.create(iLoginPersenterProvider);

    this.forgetActivityMembersInjector =
        ForgetActivity_MembersInjector.create(iLoginPersenterProvider);

    this.loginForPersonalActivityMembersInjector =
        LoginForPersonalActivity_MembersInjector.create(iLoginPersenterProvider);
  }

  @Override
  public void initject(RegisterActivity activity) {
    registerActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void initJect(VerificationActivity activity) {
    verificationActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void initJect(ForgetActivity activity) {
    forgetActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void initJect(LoginForPersonalActivity activity) {
    loginForPersonalActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private LoginModule loginModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public LoginComponent build() {
      if (loginModule == null) {
        throw new IllegalStateException(LoginModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerLoginComponent(this);
    }

    public Builder loginModule(LoginModule loginModule) {
      this.loginModule = Preconditions.checkNotNull(loginModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
