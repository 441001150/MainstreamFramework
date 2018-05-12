package com.runen.wnhz.runen.di.module;

import android.app.Application;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HttpModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final HttpModule module;

  private final Provider<Application> applicationProvider;

  private final Provider<Gson> gsonProvider;

  public HttpModule_ProvideOkHttpClientFactory(
      HttpModule module, Provider<Application> applicationProvider, Provider<Gson> gsonProvider) {
    assert module != null;
    this.module = module;
    assert applicationProvider != null;
    this.applicationProvider = applicationProvider;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(applicationProvider.get(), gsonProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<OkHttpClient> create(
      HttpModule module, Provider<Application> applicationProvider, Provider<Gson> gsonProvider) {
    return new HttpModule_ProvideOkHttpClientFactory(module, applicationProvider, gsonProvider);
  }
}
