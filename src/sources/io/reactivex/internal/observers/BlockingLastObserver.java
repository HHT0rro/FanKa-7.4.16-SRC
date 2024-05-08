package io.reactivex.internal.observers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.value = null;
        this.error = th;
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t2) {
        this.value = t2;
    }
}
