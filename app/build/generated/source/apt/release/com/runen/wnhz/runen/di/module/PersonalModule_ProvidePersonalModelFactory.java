package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.PersonalModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalModule_ProvidePersonalModelFactory implements Factory<PersonalModel> {
  private final PersonalModule module;

  private final Provider<PersonalCenterApi> personalCenterApiProvider;

  public PersonalModule_ProvidePersonalModelFactory(
      PersonalModule module, Provider<PersonalCenterApi> personalCenterApiProvider) {
    assert module != null;
    this.module = module;
    assert personalCenterApiProvider != null;
    this.personalCenterApiProvider = personalCenterApiProvider;
  }

  @Override
  public PersonalModel get() {
    return Preconditions.checkNotNull(
        module.providePersonalModel(personalCenterApiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PersonalModel> create(
      PersonalModule module, Provider<PersonalCenterApi> personalCenterApiProvider) {
    return new PersonalModule_ProvidePersonalModelFactory(module, personalCenterApiProvider);
  }
}
