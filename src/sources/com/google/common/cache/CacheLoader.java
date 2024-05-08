package com.google.common.cache;

import com.google.common.base.o;
import com.google.common.base.t;
import com.google.common.util.concurrent.n;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class CacheLoader<K, V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.g<K, V> computingFunction;

        public FunctionToCacheLoader(com.google.common.base.g<K, V> gVar) {
            this.computingFunction = (com.google.common.base.g) o.r(gVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k10) {
            return (V) this.computingFunction.apply(o.r(k10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final t<V> computingSupplier;

        public SupplierToCacheLoader(t<V> tVar) {
            this.computingSupplier = (t) o.r(tVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            o.r(obj);
            return this.computingSupplier.get();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends CacheLoader<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f26022b;

        /* renamed from: com.google.common.cache.CacheLoader$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class CallableC0226a implements Callable<V> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f26023b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Object f26024c;

            public CallableC0226a(Object obj, Object obj2) {
                this.f26023b = obj;
                this.f26024c = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.f26023b, this.f26024c).get();
            }
        }

        public a(Executor executor) {
            this.f26022b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k10) throws Exception {
            return (V) CacheLoader.this.load(k10);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public n<V> reload(K k10, V v2) throws Exception {
            com.google.common.util.concurrent.o a10 = com.google.common.util.concurrent.o.a(new CallableC0226a(k10, v2));
            this.f26022b.execute(a10);
            return a10;
        }
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        o.r(cacheLoader);
        o.r(executor);
        return new a(executor);
    }

    public static <K, V> CacheLoader<K, V> from(com.google.common.base.g<K, V> gVar) {
        return new FunctionToCacheLoader(gVar);
    }

    public abstract V load(K k10) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    public n<V> reload(K k10, V v2) throws Exception {
        o.r(k10);
        o.r(v2);
        return com.google.common.util.concurrent.i.c(load(k10));
    }

    public static <V> CacheLoader<Object, V> from(t<V> tVar) {
        return new SupplierToCacheLoader(tVar);
    }
}
