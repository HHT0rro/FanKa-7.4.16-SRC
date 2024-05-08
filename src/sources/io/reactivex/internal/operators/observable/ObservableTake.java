package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    public final long limit;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class TakeObserver<T> implements Observer<T>, Disposable {
        public boolean done;
        public final Observer<? super T> downstream;
        public long remaining;
        public Disposable upstream;

        public TakeObserver(Observer<? super T> observer, long j10) {
            this.downstream = observer;
            this.remaining = j10;
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
            if (this.done) {
                return;
            }
            this.done = true;
            this.upstream.dispose();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            if (this.done) {
                return;
            }
            long j10 = this.remaining;
            long j11 = j10 - 1;
            this.remaining = j11;
            if (j10 > 0) {
                boolean z10 = j11 == 0;
                this.downstream.onNext(t2);
                if (z10) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (this.remaining == 0) {
                    this.done = true;
                    disposable.dispose();
                    EmptyDisposable.complete(this.downstream);
                    return;
                }
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource<T> observableSource, long j10) {
        super(observableSource);
        this.limit = j10;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeObserver(observer, this.limit));
    }
}
