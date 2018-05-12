package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.MineContart;
import com.runen.wnhz.runen.presenter.model.MineModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IMinePersenter_Factory implements Factory<IMinePersenter> {
  private final MembersInjector<IMinePersenter> iMinePersenterMembersInjector;

  private final Provider<MineModel> mModelProvider;

  private final Provider<MineContart.View> mViewProvider;

  public IMinePersenter_Factory(
      MembersInjector<IMinePersenter> iMinePersenterMembersInjector,
      Provider<MineModel> mModelProvider,
      Provider<MineContart.View> mViewProvider) {
    assert iMinePersenterMembersInjector != null;
    this.iMinePersenterMembersInjector = iMinePersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IMinePersenter get() {
    return MembersInjectors.injectMembers(
        iMinePersenterMembersInjector,
        new IMinePersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IMinePersenter> create(
      MembersInjector<IMinePersenter> iMinePersenterMembersInjector,
      Provider<MineModel> mModelProvider,
      Provider<MineContart.View> mViewProvider) {
    return new IMinePersenter_Factory(iMinePersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
