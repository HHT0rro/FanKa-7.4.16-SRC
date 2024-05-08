package io.reactivex.internal.operators.single;

import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

@Experimental
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SingleMaterialize<T> extends Single<Notification<T>> {
    public final Single<T> source;

    public SingleMaterialize(Single<T> single) {
        this.source = single;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
