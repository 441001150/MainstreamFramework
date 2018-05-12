package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.FeedContart;
import com.runen.wnhz.runen.presenter.model.FeedModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class IFeedPersenter_Factory implements Factory<IFeedPersenter> {
  private final MembersInjector<IFeedPersenter> iFeedPersenterMembersInjector;

  private final Provider<FeedModel> mModelProvider;

  private final Provider<FeedContart.View> mViewProvider;

  public IFeedPersenter_Factory(
      MembersInjector<IFeedPersenter> iFeedPersenterMembersInjector,
      Provider<FeedModel> mModelProvider,
      Provider<FeedContart.View> mViewProvider) {
    assert iFeedPersenterMembersInjector != null;
    this.iFeedPersenterMembersInjector = iFeedPersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public IFeedPersenter get() {
    return MembersInjectors.injectMembers(
        iFeedPersenterMembersInjector,
        new IFeedPersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<IFeedPersenter> create(
      MembersInjector<IFeedPersenter> iFeedPersenterMembersInjector,
      Provider<FeedModel> mModelProvider,
      Provider<FeedContart.View> mViewProvider) {
    return new IFeedPersenter_Factory(iFeedPersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
