package io.reactivex.internal.util;

import io.reactivex.Observer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(Observer<? super U> observer, T t2);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i10);
}
