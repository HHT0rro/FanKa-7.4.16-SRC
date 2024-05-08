package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    public final BiFunction<R, ? super T, R> reducer;
    public final R seed;
    public final ObservableSource<T> source;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        public final SingleObserver<? super R> downstream;
        public final BiFunction<R, ? super T, R> reducer;
        public Disposable upstream;
        public R value;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r10) {
            this.downstream = singleObserver;
            this.value = r10;
            this.reducer = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            R r10 = this.value;
            if (r10 != null) {
                this.value = null;
                this.downstream.onSuccess(r10);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.value != null) {
                this.value = null;
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            R r10 = this.value;
            if (r10 != null) {
                try {
                    this.value = (R) ObjectHelper.requireNonNull(this.reducer.apply(r10, t2), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r10, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seed = r10;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new ReduceSeedObserver(singleObserver, this.reducer, this.seed));
    }
}
