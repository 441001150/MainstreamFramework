package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.SettingCotart;
import com.runen.wnhz.runen.presenter.model.SettingModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ISettingPersenter_Factory implements Factory<ISettingPersenter> {
  private final MembersInjector<ISettingPersenter> iSettingPersenterMembersInjector;

  private final Provider<SettingModel> mModelProvider;

  private final Provider<SettingCotart.View> mViewProvider;

  public ISettingPersenter_Factory(
      MembersInjector<ISettingPersenter> iSettingPersenterMembersInjector,
      Provider<SettingModel> mModelProvider,
      Provider<SettingCotart.View> mViewProvider) {
    assert iSettingPersenterMembersInjector != null;
    this.iSettingPersenterMembersInjector = iSettingPersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public ISettingPersenter get() {
    return MembersInjectors.injectMembers(
        iSettingPersenterMembersInjector,
        new ISettingPersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<ISettingPersenter> create(
      MembersInjector<ISettingPersenter> iSettingPersenterMembersInjector,
      Provider<SettingModel> mModelProvider,
      Provider<SettingCotart.View> mViewProvider) {
    return new ISettingPersenter_Factory(
        iSettingPersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
