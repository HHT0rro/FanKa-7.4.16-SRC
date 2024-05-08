package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t2, T t10) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
