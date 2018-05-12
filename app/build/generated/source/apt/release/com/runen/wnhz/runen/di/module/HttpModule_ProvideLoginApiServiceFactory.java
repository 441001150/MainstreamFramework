package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.service.PersonalCenterApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HttpModule_ProvideLoginApiServiceFactory implements Factory<PersonalCenterApi> {
  private final HttpModule module;

  private final Provider<Retrofit> retrofitProvider;

  public HttpModule_ProvideLoginApiServiceFactory(
      HttpModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public PersonalCenterApi get() {
    return Preconditions.checkNotNull(
        module.provideLoginApiService(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PersonalCenterApi> create(
      HttpModule module, Provider<Retrofit> retrofitProvider) {
    return new HttpModule_ProvideLoginApiServiceFactory(module, retrofitProvider);
  }
}
