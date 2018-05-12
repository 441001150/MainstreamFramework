package com.runen.wnhz.runen.di.module;

import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CourseModule_ProvideViewFactory implements Factory<CourseContart.View> {
  private final CourseModule module;

  public CourseModule_ProvideViewFactory(CourseModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public CourseContart.View get() {
    return Preconditions.checkNotNull(
        module.provideView(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CourseContart.View> create(CourseModule module) {
    return new CourseModule_ProvideViewFactory(module);
  }
}
