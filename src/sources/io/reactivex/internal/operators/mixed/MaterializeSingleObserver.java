package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    public final SingleObserver<? super Notification<T>> downstream;
    public Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.downstream.onSuccess(Notification.createOnComplete());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.downstream.onSuccess(Notification.createOnError(th));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t2) {
        this.downstream.onSuccess(Notification.createOnNext(t2));
    }
}
