package le;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.HttpException;

/* compiled from: BodyObservable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a<T> extends Observable<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Observable<Response<T>> f51696b;

    /* compiled from: BodyObservable.java */
    /* renamed from: le.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0789a<R> implements Observer<Response<R>> {

        /* renamed from: b, reason: collision with root package name */
        public final Observer<? super R> f51697b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f51698c;

        public C0789a(Observer<? super R> observer) {
            this.f51697b = observer;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Response<R> response) {
            if (response.d()) {
                this.f51697b.onNext(response.a());
                return;
            }
            this.f51698c = true;
            HttpException httpException = new HttpException(response);
            try {
                this.f51697b.onError(httpException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(httpException, th));
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f51698c) {
                return;
            }
            this.f51697b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f51698c) {
                this.f51697b.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError((Object) "This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            RxJavaPlugins.onError(assertionError);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f51697b.onSubscribe(disposable);
        }
    }

    public a(Observable<Response<T>> observable) {
        this.f51696b = observable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.f51696b.subscribe(new C0789a(observer));
    }
}
