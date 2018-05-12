package com.runen.wnhz.runen.di.component;

import android.app.Application;
import com.google.gson.Gson;
import com.runen.wnhz.runen.di.module.ApplicationModule;
import com.runen.wnhz.runen.di.module.ApplicationModule_ProvideApplicationFactory;
import com.runen.wnhz.runen.di.module.ApplicationModule_ProvideGsonFactory;
import com.runen.wnhz.runen.di.module.HttpModule;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideHomeApiServiceFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideLoginApiServiceFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideLoginServiceApiFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideMineServiceApiFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideMyCourseApiFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideOkHttpClientFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideReceivingAddressApiFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideRetrofitFactory;
import com.runen.wnhz.runen.di.module.HttpModule_ProvideSettingApiFactory;
import com.runen.wnhz.runen.service.HomeApi;
import com.runen.wnhz.runen.service.LoginServiceApi;
import com.runen.wnhz.runen.service.MineServiceApi;
import com.runen.wnhz.runen.service.MyCourseApi;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.service.ReceivingAddressApi;
import com.runen.wnhz.runen.service.SettingApi;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Application> provideApplicationProvider;

  private Provider<Gson> provideGsonProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<LoginServiceApi> provideLoginServiceApiProvider;

  private Provider<HomeApi> provideHomeApiServiceProvider;

  private Provider<MineServiceApi> provideMineServiceApiProvider;

  private Provider<PersonalCenterApi> provideLoginApiServiceProvider;

  private Provider<ReceivingAddressApi> provideReceivingAddressApiProvider;

  private Provider<MyCourseApi> provideMyCourseApiProvider;

  private Provider<SettingApi> provideSettingApiProvider;

  private DaggerApplicationComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideApplicationProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule));

    this.provideGsonProvider =
        DoubleCheck.provider(
            ApplicationModule_ProvideGsonFactory.create(builder.applicationModule));

    this.provideOkHttpClientProvider =
        DoubleCheck.provider(
            HttpModule_ProvideOkHttpClientFactory.create(
                builder.httpModule, provideApplicationProvider, provideGsonProvider));

    this.provideRetrofitProvider =
        DoubleCheck.provider(
            HttpModule_ProvideRetrofitFactory.create(
                builder.httpModule, provideOkHttpClientProvider));

    this.provideLoginServiceApiProvider =
        DoubleCheck.provider(
            HttpModule_ProvideLoginServiceApiFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideHomeApiServiceProvider =
        DoubleCheck.provider(
            HttpModule_ProvideHomeApiServiceFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideMineServiceApiProvider =
        DoubleCheck.provider(
            HttpModule_ProvideMineServiceApiFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideLoginApiServiceProvider =
        DoubleCheck.provider(
            HttpModule_ProvideLoginApiServiceFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideReceivingAddressApiProvider =
        DoubleCheck.provider(
            HttpModule_ProvideReceivingAddressApiFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideMyCourseApiProvider =
        DoubleCheck.provider(
            HttpModule_ProvideMyCourseApiFactory.create(
                builder.httpModule, provideRetrofitProvider));

    this.provideSettingApiProvider =
        DoubleCheck.provider(
            HttpModule_ProvideSettingApiFactory.create(
                builder.httpModule, provideRetrofitProvider));
  }

  @Override
  public LoginServiceApi loginServiceApi() {
    return provideLoginServiceApiProvider.get();
  }

  @Override
  public HomeApi homeApisercivce() {
    return provideHomeApiServiceProvider.get();
  }

  @Override
  public MineServiceApi mineServiceApi() {
    return provideMineServiceApiProvider.get();
  }

  @Override
  public PersonalCenterApi personalCenterApi() {
    return provideLoginApiServiceProvider.get();
  }

  @Override
  public ReceivingAddressApi receivingAddressApi() {
    return provideReceivingAddressApiProvider.get();
  }

  @Override
  public MyCourseApi myCourseApi() {
    return provideMyCourseApiProvider.get();
  }

  @Override
  public SettingApi settingApi() {
    return provideSettingApiProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;

    private HttpModule httpModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (applicationModule == null) {
        throw new IllegalStateException(
            ApplicationModule.class.getCanonicalName() + " must be set");
      }
      if (httpModule == null) {
        this.httpModule = new HttpModule();
      }
      return new DaggerApplicationComponent(this);
    }

    public Builder applicationModule(ApplicationModule applicationModule) {
      this.applicationModule = Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder httpModule(HttpModule httpModule) {
      this.httpModule = Preconditions.checkNotNull(httpModule);
      return this;
    }
  }
}
