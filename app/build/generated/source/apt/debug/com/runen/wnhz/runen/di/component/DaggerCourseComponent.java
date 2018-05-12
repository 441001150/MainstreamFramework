package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.CourseModule;
import com.runen.wnhz.runen.di.module.CourseModule_ProvideHomedelFactory;
import com.runen.wnhz.runen.di.module.CourseModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.CourseContart;
import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter;
import com.runen.wnhz.runen.presenter.iPresenter.ICoursePersenter_Factory;
import com.runen.wnhz.runen.presenter.model.CourseModel;
import com.runen.wnhz.runen.service.MyCourseApi;
import com.runen.wnhz.runen.ui.activity.mine.MyCollectionActivity;
import com.runen.wnhz.runen.ui.activity.mine.MyCollectionActivity_MembersInjector;
import com.runen.wnhz.runen.ui.fragment.minem.DownloadedFragment;
import com.runen.wnhz.runen.ui.fragment.minem.DownloadedFragment_MembersInjector;
import com.runen.wnhz.runen.ui.fragment.minem.LearningFragment;
import com.runen.wnhz.runen.ui.fragment.minem.LearningFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCourseComponent implements CourseComponent {
  private Provider<MyCourseApi> myCourseApiProvider;

  private Provider<CourseModel> provideHomedelProvider;

  private Provider<CourseContart.View> provideViewProvider;

  private Provider<ICoursePersenter> iCoursePersenterProvider;

  private MembersInjector<LearningFragment> learningFragmentMembersInjector;

  private MembersInjector<DownloadedFragment> downloadedFragmentMembersInjector;

  private MembersInjector<MyCollectionActivity> myCollectionActivityMembersInjector;

  private DaggerCourseComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.myCourseApiProvider =
        new Factory<MyCourseApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public MyCourseApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.myCourseApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideHomedelProvider =
        CourseModule_ProvideHomedelFactory.create(builder.courseModule, myCourseApiProvider);

    this.provideViewProvider = CourseModule_ProvideViewFactory.create(builder.courseModule);

    this.iCoursePersenterProvider =
        ICoursePersenter_Factory.create(
            MembersInjectors.<ICoursePersenter>noOp(), provideHomedelProvider, provideViewProvider);

    this.learningFragmentMembersInjector =
        LearningFragment_MembersInjector.create(iCoursePersenterProvider);

    this.downloadedFragmentMembersInjector =
        DownloadedFragment_MembersInjector.create(iCoursePersenterProvider);

    this.myCollectionActivityMembersInjector =
        MyCollectionActivity_MembersInjector.create(iCoursePersenterProvider);
  }

  @Override
  public void initject(LearningFragment LearningFragment) {
    learningFragmentMembersInjector.injectMembers(LearningFragment);
  }

  @Override
  public void intject(DownloadedFragment fragment) {
    downloadedFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void initject(MyCollectionActivity activity) {
    myCollectionActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private CourseModule courseModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public CourseComponent build() {
      if (courseModule == null) {
        throw new IllegalStateException(CourseModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerCourseComponent(this);
    }

    public Builder courseModule(CourseModule courseModule) {
      this.courseModule = Preconditions.checkNotNull(courseModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
