package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PersonalModule_ProvideViewFactory implements Factory<PersonalContart.View> {
  private final PersonalModule module;

  public PersonalModule_ProvideViewFactory(PersonalModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public PersonalContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PersonalContart.View> create(PersonalModule module) {
    return new PersonalModule_ProvideViewFactory(module);
  }
}
