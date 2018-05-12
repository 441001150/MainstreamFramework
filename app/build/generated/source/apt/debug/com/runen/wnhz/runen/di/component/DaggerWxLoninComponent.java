package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.wxapi.WXEntryActivity;
import com.runen.wnhz.runen.wxapi.WXEntryActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerWxLoninComponent implements WxLoninComponent {
  private Provider<LoginServiceApi> loginServiceApiProvider;

  private MembersInjector<WXEntryActivity> wXEntryActivityMembersInjector;

  private DaggerWxLoninComponent(Builder builder) {
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

    this.wXEntryActivityMembersInjector =
        WXEntryActivity_MembersInjector.create(loginServiceApiProvider);
  }

  @Override
  public void initject(WXEntryActivity activity) {
    wXEntryActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private ApplicationComponent applicationComponent;

    private Builder() {}

    public WxLoninComponent build() {
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerWxLoninComponent(this);
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
