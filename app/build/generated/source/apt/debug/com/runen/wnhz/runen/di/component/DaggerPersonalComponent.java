package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.PersonalModule;
import com.runen.wnhz.runen.di.module.PersonalModule_ProvidePersonalModelFactory;
import com.runen.wnhz.runen.di.module.PersonalModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.PersonalContart;
import com.runen.wnhz.runen.presenter.iPresenter.IPersonal;
import com.runen.wnhz.runen.presenter.iPresenter.IPersonal_Factory;
import com.runen.wnhz.runen.presenter.model.PersonalModel;
import com.runen.wnhz.runen.service.PersonalCenterApi;
import com.runen.wnhz.runen.ui.activity.mine.ChangePasswordActivity;
import com.runen.wnhz.runen.ui.activity.mine.ChangePasswordActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.mine.PersonalCenterActivity;
import com.runen.wnhz.runen.ui.activity.mine.PersonalCenterActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.mine.PersonalDataActivity;
import com.runen.wnhz.runen.ui.activity.mine.PersonalDataActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.mine.UpdateNameActivity;
import com.runen.wnhz.runen.ui.activity.mine.UpdateNameActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.personal.UploadImageActivity;
import com.runen.wnhz.runen.ui.activity.personal.UploadImageActivity_MembersInjector;
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
public final class DaggerPersonalComponent implements PersonalComponent {
  private Provider<PersonalCenterApi> personalCenterApiProvider;

  private Provider<PersonalModel> providePersonalModelProvider;

  private Provider<PersonalContart.View> provideViewProvider;

  private Provider<IPersonal> iPersonalProvider;

  private MembersInjector<PersonalCenterActivity> personalCenterActivityMembersInjector;

  private MembersInjector<PersonalDataActivity> personalDataActivityMembersInjector;

  private MembersInjector<ChangePasswordActivity> changePasswordActivityMembersInjector;

  private MembersInjector<UpdateNameActivity> updateNameActivityMembersInjector;

  private MembersInjector<UploadImageActivity> uploadImageActivityMembersInjector;

  private DaggerPersonalComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.personalCenterApiProvider =
        new Factory<PersonalCenterApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public PersonalCenterApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.personalCenterApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providePersonalModelProvider =
        PersonalModule_ProvidePersonalModelFactory.create(
            builder.personalModule, personalCenterApiProvider);

    this.provideViewProvider = PersonalModule_ProvideViewFactory.create(builder.personalModule);

    this.iPersonalProvider =
        IPersonal_Factory.create(
            MembersInjectors.<IPersonal>noOp(), providePersonalModelProvider, provideViewProvider);

    this.personalCenterActivityMembersInjector =
        PersonalCenterActivity_MembersInjector.create(iPersonalProvider);

    this.personalDataActivityMembersInjector =
        PersonalDataActivity_MembersInjector.create(iPersonalProvider);

    this.changePasswordActivityMembersInjector =
        ChangePasswordActivity_MembersInjector.create(iPersonalProvider);

    this.updateNameActivityMembersInjector =
        UpdateNameActivity_MembersInjector.create(iPersonalProvider);

    this.uploadImageActivityMembersInjector =
        UploadImageActivity_MembersInjector.create(iPersonalProvider);
  }

  @Override
  public void inject(PersonalCenterActivity activity) {
    personalCenterActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(PersonalDataActivity activity) {
    personalDataActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(ChangePasswordActivity activity) {
    changePasswordActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(UpdateNameActivity activity) {
    updateNameActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(UploadImageActivity activity) {
    uploadImageActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private PersonalModule personalModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public PersonalComponent build() {
      if (personalModule == null) {
        throw new IllegalStateException(PersonalModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerPersonalComponent(this);
    }

    public Builder personalModule(PersonalModule personalModule) {
      this.personalModule = Preconditions.checkNotNull(personalModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
