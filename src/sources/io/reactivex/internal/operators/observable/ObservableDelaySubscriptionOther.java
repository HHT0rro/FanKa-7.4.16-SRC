package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    public final ObservableSource<? extends T> main;
    public final ObservableSource<U> other;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class DelayObserver implements Observer<U> {
        public final Observer<? super T> child;
        public boolean done;
        public final SequentialDisposable serial;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class OnComplete implements Observer<T> {
            public OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                DelayObserver.this.child.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DelayObserver.this.child.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(T t2) {
                DelayObserver.this.child.onNext(t2);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.serial.update(disposable);
            }
        }

        public DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.serial = sequentialDisposable;
            this.child = observer;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            ObservableDelaySubscriptionOther.this.main.subscribe(new OnComplete());
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.child.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(U u10) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.serial.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.main = observableSource;
        this.other = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.other.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
