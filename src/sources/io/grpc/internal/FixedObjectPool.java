package io.grpc.internal;

import com.google.common.base.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FixedObjectPool<T> implements ObjectPool<T> {
    private final T object;

    public FixedObjectPool(T t2) {
        this.object = (T) o.s(t2, "object");
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return this.object;
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object obj) {
        return null;
    }
}
