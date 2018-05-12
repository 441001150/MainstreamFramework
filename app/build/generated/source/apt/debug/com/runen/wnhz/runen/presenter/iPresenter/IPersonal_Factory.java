package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.model.PersonalModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IPersonal_Factory implements Factory<IPersonal> {
  private final MembersInjector<IPersonal> iPersonalMembersInjector;

  private final Provider<PersonalModel> mModelProvider;

  private final Provider<PersonalContart.View> mViewProvider;

  public IPersonal_Factory(
      MembersInjector<IPersonal> iPersonalMembersInjector,
      Provider<PersonalModel> mModelProvider,
      Provider<PersonalContart.View> mViewProvider) {
    assert iPersonalMembersInjector != null;
    this.iPersonalMembersInjector = iPersonalMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IPersonal get() {
    return MembersInjectors.injectMembers(
        iPersonalMembersInjector, new IPersonal(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IPersonal> create(
      MembersInjector<IPersonal> iPersonalMembersInjector,
      Provider<PersonalModel> mModelProvider,
      Provider<PersonalContart.View> mViewProvider) {
    return new IPersonal_Factory(iPersonalMembersInjector, mModelProvider, mViewProvider);
  }
}
