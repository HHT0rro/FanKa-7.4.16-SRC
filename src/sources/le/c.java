package le;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Response;

/* compiled from: CallExecuteObservable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class c<T> extends Observable<Response<T>> {

    /* renamed from: b, reason: collision with root package name */
    public final retrofit2.b<T> f51704b;

    /* compiled from: CallExecuteObservable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a implements Disposable {

        /* renamed from: b, reason: collision with root package name */
        public final retrofit2.b<?> f51705b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f51706c;

        public a(retrofit2.b<?> bVar) {
            this.f51705b = bVar;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f51706c = true;
            this.f51705b.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f51706c;
        }
    }

    public c(retrofit2.b<T> bVar) {
        this.f51704b = bVar;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z10;
        retrofit2.b<T> clone = this.f51704b.clone();
        a aVar = new a(clone);
        observer.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            Response<T> execute = clone.execute();
            if (!aVar.isDisposed()) {
                observer.onNext(execute);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                observer.onComplete();
            } catch (Throwable th) {
                th = th;
                z10 = true;
                Exceptions.throwIfFatal(th);
                if (z10) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    observer.onError(th);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z10 = false;
        }
    }
}
