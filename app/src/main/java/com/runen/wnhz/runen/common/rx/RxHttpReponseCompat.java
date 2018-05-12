package com.runen.wnhz.runen.common.rx;
import com.runen.wnhz.runen.common.exception.ApiException;
import com.runen.wnhz.runen.data.entity.BaseEntity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**

 */

public class RxHttpReponseCompat {


    public static  <T> Observable.Transformer<BaseEntity<T>,T> compatResult(){


        return  new Observable.Transformer<BaseEntity<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseEntity<T>> baseBeanObservable) {
                
                return baseBeanObservable.flatMap(new Func1<BaseEntity<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseEntity<T> tBaseBean) {
                        
                        if(tBaseBean.success()){


                           return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {

                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    }
                                    catch (Exception e){
                                        subscriber.onError(e);
                                    }


                                }
                            });


                        }
                        else {
                            return  Observable.error(new ApiException(tBaseBean.getRe(),tBaseBean.getInfo()));
                        }

                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };


    }
}
