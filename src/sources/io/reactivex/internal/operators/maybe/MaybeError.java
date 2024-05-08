package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaybeError<T> extends Maybe<T> {
    public final Throwable error;

    public MaybeError(Throwable th) {
        this.error = th;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onError(this.error);
    }
}
