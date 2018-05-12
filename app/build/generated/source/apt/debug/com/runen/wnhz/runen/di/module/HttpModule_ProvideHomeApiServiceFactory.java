package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.service.HomeApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HttpModule_ProvideHomeApiServiceFactory implements Factory<HomeApi> {
  private final HttpModule module;

  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideHomeApiServiceFactory(
      HttpModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public HomeApi get() {
    return Preconditions.checkNotNull(
        module.provideHomeApiService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<HomeApi> create(HttpModule module, Provider<Retrofit> retrofitProvider) {
    return new HttpModule_ProvideHomeApiServiceFactory(module, retrofitProvider);
  }
}
