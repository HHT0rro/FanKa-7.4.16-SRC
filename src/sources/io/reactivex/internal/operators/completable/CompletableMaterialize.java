package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

@Experimental
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CompletableMaterialize<T> extends Single<Notification<T>> {
    public final Completable source;

    public CompletableMaterialize(Completable completable) {
        this.source = completable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
