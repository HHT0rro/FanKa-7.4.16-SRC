package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaybeErrorCallable<T> extends Maybe<T> {
    public final Callable<? extends Throwable> errorSupplier;

    public MaybeErrorCallable(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        maybeObserver.onError(th);
    }
}