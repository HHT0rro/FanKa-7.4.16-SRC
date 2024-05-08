package org.apache.commons.lang3.concurrent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile T object = (T) NO_INIT;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t2 = this.object;
        Object obj = NO_INIT;
        if (t2 == obj) {
            synchronized (this) {
                t2 = this.object;
                if (t2 == obj) {
                    t2 = initialize();
                    this.object = t2;
                }
            }
        }
        return t2;
    }

    public abstract T initialize() throws ConcurrentException;
}
