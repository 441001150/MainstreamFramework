package com.runen.wnhz.runen.presenter.iPresenter;

import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.model.CourseModel;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ICoursePersenter_Factory implements Factory<ICoursePersenter> {
  private final MembersInjector<ICoursePersenter> iCoursePersenterMembersInjector;

  private final Provider<CourseModel> mModelProvider;

  private final Provider<CourseContart.View> mViewProvider;

  public ICoursePersenter_Factory(
      MembersInjector<ICoursePersenter> iCoursePersenterMembersInjector,
      Provider<CourseModel> mModelProvider,
      Provider<CourseContart.View> mViewProvider) {
    assert iCoursePersenterMembersInjector != null;
    this.iCoursePersenterMembersInjector = iCoursePersenterMembersInjector;
    assert mModelProvider != null;
    this.mModelProvider = mModelProvider;
    assert mViewProvider != null;
    this.mViewProvider = mViewProvider;
  }

  @Override
  public ICoursePersenter get() {
    return MembersInjectors.injectMembers(
        iCoursePersenterMembersInjector,
        new ICoursePersenter(mModelProvider.get(), mViewProvider.get()));
  }

  public static Factory<ICoursePersenter> create(
      MembersInjector<ICoursePersenter> iCoursePersenterMembersInjector,
      Provider<CourseModel> mModelProvider,
      Provider<CourseContart.View> mViewProvider) {
    return new ICoursePersenter_Factory(
        iCoursePersenterMembersInjector, mModelProvider, mViewProvider);
  }
}
