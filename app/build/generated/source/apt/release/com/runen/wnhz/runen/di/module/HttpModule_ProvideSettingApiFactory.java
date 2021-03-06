package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.service.SettingApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HttpModule_ProvideSettingApiFactory implements Factory<SettingApi> {
  private final HttpModule module;

  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideSettingApiFactory(
      HttpModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public SettingApi get() {
    return Preconditions.checkNotNull(
        module.provideSettingApi(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SettingApi> create(HttpModule module, Provider<Retrofit> retrofitProvider) {
    return new HttpModule_ProvideSettingApiFactory(module, retrofitProvider);
  }
}
