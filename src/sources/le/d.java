package le;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;

/* compiled from: ResultObservable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d<T> extends Observable<Result<T>> {

    /* renamed from: b, reason: collision with root package name */
    public final Observable<Response<T>> f51707b;

    /* compiled from: ResultObservable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a<R> implements Observer<Response<R>> {

        /* renamed from: b, reason: collision with root package name */
        public final Observer<? super Result<R>> f51708b;

        public a(Observer<? super Result<R>> observer) {
            this.f51708b = observer;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Response<R> response) {
            this.f51708b.onNext(Result.response(response));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f51708b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                this.f51708b.onNext(Result.error(th));
                this.f51708b.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f51708b.onError(th2);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f51708b.onSubscribe(disposable);
        }
    }

    public d(Observable<Response<T>> observable) {
        this.f51707b = observable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Result<T>> observer) {
        this.f51707b.subscribe(new a(observer));
    }
}
