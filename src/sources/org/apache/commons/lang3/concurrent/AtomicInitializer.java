package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t2 = this.reference.get();
        if (t2 != null) {
            return t2;
        }
        T initialize = initialize();
        return !this.reference.compareAndSet(null, initialize) ? this.reference.get() : initialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
