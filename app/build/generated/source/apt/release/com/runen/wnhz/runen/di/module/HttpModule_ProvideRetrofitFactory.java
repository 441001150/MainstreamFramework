package com.runen.wnhz.runen.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HttpModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final HttpModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public HttpModule_ProvideRetrofitFactory(
      HttpModule module, Provider<OkHttpClient> okHttpClientProvider) {
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.provideRetrofit(okHttpClientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      HttpModule module, Provider<OkHttpClient> okHttpClientProvider) {
    return new HttpModule_ProvideRetrofitFactory(module, okHttpClientProvider);
  }
}
