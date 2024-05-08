package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;
    public Disposable upstream;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        T t2 = ((DeferredScalarDisposable) this).value;
        if (t2 != null) {
            ((DeferredScalarDisposable) this).value = null;
            complete(t2);
        } else {
            complete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ((DeferredScalarDisposable) this).value = null;
        error(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }
}
