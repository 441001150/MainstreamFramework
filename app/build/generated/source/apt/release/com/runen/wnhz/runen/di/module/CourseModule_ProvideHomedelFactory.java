package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.model.CourseModel;
import com.runen.wnhz.runen.service.MyCourseApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CourseModule_ProvideHomedelFactory implements Factory<CourseModel> {
  private final CourseModule module;

  private final Provider<MyCourseApi> myCourseApiProvider;

  public CourseModule_ProvideHomedelFactory(
      CourseModule module, Provider<MyCourseApi> myCourseApiProvider) {
    assert module != null;
    this.module = module;
    assert myCourseApiProvider != null;
    this.myCourseApiProvider = myCourseApiProvider;
  }

  @Override
  public CourseModel get() {
    return Preconditions.checkNotNull(
        module.provideHomedel(myCourseApiProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CourseModel> create(
      CourseModule module, Provider<MyCourseApi> myCourseApiProvider) {
    return new CourseModule_ProvideHomedelFactory(module, myCourseApiProvider);
  }
}
