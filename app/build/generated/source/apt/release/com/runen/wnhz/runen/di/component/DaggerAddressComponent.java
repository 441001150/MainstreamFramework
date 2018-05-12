package com.runen.wnhz.runen.di.component;

import com.runen.wnhz.runen.di.module.AddressModule;
import com.runen.wnhz.runen.di.module.AddressModule_ProvideModelFactory;
import com.runen.wnhz.runen.di.module.AddressModule_ProvideViewFactory;
import com.runen.wnhz.runen.presenter.Contart.AddressContart;
import com.runen.wnhz.runen.presenter.iPresenter.IAddressPersenter;
import com.runen.wnhz.runen.presenter.iPresenter.IAddressPersenter_Factory;
import com.runen.wnhz.runen.presenter.model.AddressModel;
import com.runen.wnhz.runen.service.ReceivingAddressApi;
import com.runen.wnhz.runen.ui.activity.mine.AddAddressActivity;
import com.runen.wnhz.runen.ui.activity.mine.AddAddressActivity_MembersInjector;
import com.runen.wnhz.runen.ui.activity.mine.ReceivingAddressActivity;
import com.runen.wnhz.runen.ui.activity.mine.ReceivingAddressActivity_MembersInjector;
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
public final class DaggerAddressComponent implements AddressComponent {
  private Provider<ReceivingAddressApi> receivingAddressApiProvider;

  private Provider<AddressModel> provideModelProvider;

  private Provider<AddressContart.View> provideViewProvider;

  private Provider<IAddressPersenter> iAddressPersenterProvider;

  private MembersInjector<ReceivingAddressActivity> receivingAddressActivityMembersInjector;

  private MembersInjector<AddAddressActivity> addAddressActivityMembersInjector;

  private DaggerAddressComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.receivingAddressApiProvider =
        new Factory<ReceivingAddressApi>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public ReceivingAddressApi get() {
            return Preconditions.checkNotNull(
                applicationComponent.receivingAddressApi(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideModelProvider =
        AddressModule_ProvideModelFactory.create(
            builder.addressModule, receivingAddressApiProvider);

    this.provideViewProvider = AddressModule_ProvideViewFactory.create(builder.addressModule);

    this.iAddressPersenterProvider =
        IAddressPersenter_Factory.create(
            MembersInjectors.<IAddressPersenter>noOp(), provideModelProvider, provideViewProvider);

    this.receivingAddressActivityMembersInjector =
        ReceivingAddressActivity_MembersInjector.create(iAddressPersenterProvider);

    this.addAddressActivityMembersInjector =
        AddAddressActivity_MembersInjector.create(iAddressPersenterProvider);
  }

  @Override
  public void initJect(ReceivingAddressActivity activity) {
    receivingAddressActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void initJect(AddAddressActivity activity) {
    addAddressActivityMembersInjector.injectMembers(activity);
  }

  public static final class Builder {
    private AddressModule addressModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public AddressComponent build() {
      if (addressModule == null) {
        throw new IllegalStateException(AddressModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerAddressComponent(this);
    }

    public Builder addressModule(AddressModule addressModule) {
      this.addressModule = Preconditions.checkNotNull(addressModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
