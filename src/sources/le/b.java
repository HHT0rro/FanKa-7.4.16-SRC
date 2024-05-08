package le;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b<T> extends Observable<Response<T>> {

    /* renamed from: b, reason: collision with root package name */
    public final retrofit2.b<T> f51699b;

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<T> implements Disposable, retrofit2.d<T> {

        /* renamed from: b, reason: collision with root package name */
        public final retrofit2.b<?> f51700b;

        /* renamed from: c, reason: collision with root package name */
        public final Observer<? super Response<T>> f51701c;

        /* renamed from: d, reason: collision with root package name */
        public volatile boolean f51702d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f51703e = false;

        public a(retrofit2.b<?> bVar, Observer<? super Response<T>> observer) {
            this.f51700b = bVar;
            this.f51701c = observer;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> bVar, Throwable th) {
            if (bVar.isCanceled()) {
                return;
            }
            try {
                this.f51701c.onError(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> bVar, Response<T> response) {
            if (this.f51702d) {
                return;
            }
            try {
                this.f51701c.onNext(response);
                if (this.f51702d) {
                    return;
                }
                this.f51703e = true;
                this.f51701c.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (this.f51703e) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (this.f51702d) {
                    return;
                }
                try {
                    this.f51701c.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f51702d = true;
            this.f51700b.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f51702d;
        }
    }

    public b(retrofit2.b<T> bVar) {
        this.f51699b = bVar;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        retrofit2.b<T> clone = this.f51699b.clone();
        a aVar = new a(clone, observer);
        observer.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        clone.b(aVar);
    }
}
