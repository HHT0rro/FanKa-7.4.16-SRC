package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ImmutableClassToInstanceMap<B> extends v<Class<? extends B>, B> implements Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b<B> {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableMap.b<Class<? extends B>, B> f26256a = ImmutableMap.builder();

        public static <B, T extends B> T b(Class<T> cls, B b4) {
            return (T) com.google.common.primitives.d.d(cls).cast(b4);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> d10 = this.f26256a.d();
            if (d10.isEmpty()) {
                return ImmutableClassToInstanceMap.of();
            }
            return new ImmutableClassToInstanceMap<>(d10);
        }

        public <T extends B> b<B> c(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.f26256a.g(key, b(key, entry.getValue()));
            }
            return this;
        }
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new b().c(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(com.google.common.base.o.r(cls));
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t2) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t2) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t2));
    }

    @Override // com.google.common.collect.v, com.google.common.collect.z
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
