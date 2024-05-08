package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    public final T defaultValue;
    public final boolean errorOnFewer;
    public final long index;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        public long count;
        public final T defaultValue;
        public boolean done;
        public final Observer<? super T> downstream;
        public final boolean errorOnFewer;
        public final long index;
        public Disposable upstream;

        public ElementAtObserver(Observer<? super T> observer, long j10, T t2, boolean z10) {
            this.downstream = observer;
            this.index = j10;
            this.defaultValue = t2;
            this.errorOnFewer = z10;
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
            T t2 = this.defaultValue;
            if (t2 == null && this.errorOnFewer) {
                this.downstream.onError(new NoSuchElementException());
                return;
            }
            if (t2 != null) {
                this.downstream.onNext(t2);
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            if (this.done) {
                return;
            }
            long j10 = this.count;
            if (j10 == this.index) {
                this.done = true;
                this.upstream.dispose();
                this.downstream.onNext(t2);
                this.downstream.onComplete();
                return;
            }
            this.count = j10 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j10, T t2, boolean z10) {
        super(observableSource);
        this.index = j10;
        this.defaultValue = t2;
        this.errorOnFewer = z10;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.index, this.defaultValue, this.errorOnFewer));
    }
}
