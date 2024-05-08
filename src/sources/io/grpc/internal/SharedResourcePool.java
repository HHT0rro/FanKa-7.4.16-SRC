package io.grpc.internal;

import io.grpc.internal.SharedResourceHolder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SharedResourcePool<T> implements ObjectPool<T> {
    private final SharedResourceHolder.Resource<T> resource;

    private SharedResourcePool(SharedResourceHolder.Resource<T> resource) {
        this.resource = resource;
    }

    public static <T> SharedResourcePool<T> forResource(SharedResourceHolder.Resource<T> resource) {
        return new SharedResourcePool<>(resource);
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return (T) SharedResourceHolder.get(this.resource);
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object obj) {
        SharedResourceHolder.release(this.resource, obj);
        return null;
    }
}
