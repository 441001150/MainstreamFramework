package com.runen.wnhz.runen.wxapi;

import com.runen.wnhz.runen.service.LoginServiceApi;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class WXEntryActivity_MembersInjector implements MembersInjector<WXEntryActivity> {
  private final Provider<LoginServiceApi> loginServiceApiProvider;

  public WXEntryActivity_MembersInjector(Provider<LoginServiceApi> loginServiceApiProvider) {
    assert loginServiceApiProvider != null;
    this.loginServiceApiProvider = loginServiceApiProvider;
  }

  public static MembersInjector<WXEntryActivity> create(
      Provider<LoginServiceApi> loginServiceApiProvider) {
    return new WXEntryActivity_MembersInjector(loginServiceApiProvider);
  }

  @Override
  public void injectMembers(WXEntryActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.loginServiceApi = loginServiceApiProvider.get();
  }

  public static void injectLoginServiceApi(
      WXEntryActivity instance, Provider<LoginServiceApi> loginServiceApiProvider) {
    instance.loginServiceApi = loginServiceApiProvider.get();
  }
}
