package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MaybeUnsafeCreate<T> extends AbstractMaybeWithUpstream<T, T> {
    public MaybeUnsafeCreate(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(maybeObserver);
    }
}
