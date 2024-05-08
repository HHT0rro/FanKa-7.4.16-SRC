package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {
    public final AtomicInteger clients = new AtomicInteger();
    public final Consumer<? super Disposable> connection;
    public final int numberOfObservers;
    public final ConnectableObservable<? extends T> source;

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i10, Consumer<? super Disposable> consumer) {
        this.source = connectableObservable;
        this.numberOfObservers = i10;
        this.connection = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer<? super Object>) observer);
        if (this.clients.incrementAndGet() == this.numberOfObservers) {
            this.source.connect(this.connection);
        }
    }
}
