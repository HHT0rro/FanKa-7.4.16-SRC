package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableLastSingle<T> extends Single<T> {
    public final T defaultItem;
    public final ObservableSource<T> source;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LastObserver<T> implements Observer<T>, Disposable {
        public final T defaultItem;
        public final SingleObserver<? super T> downstream;
        public T item;
        public Disposable upstream;

        public LastObserver(SingleObserver<? super T> singleObserver, T t2) {
            this.downstream = singleObserver;
            this.defaultItem = t2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            T t2 = this.item;
            if (t2 != null) {
                this.item = null;
                this.downstream.onSuccess(t2);
                return;
            }
            T t10 = this.defaultItem;
            if (t10 != null) {
                this.downstream.onSuccess(t10);
            } else {
                this.downstream.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.item = null;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            this.item = t2;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t2) {
        this.source = observableSource;
        this.defaultItem = t2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastObserver(singleObserver, this.defaultItem));
    }
}
