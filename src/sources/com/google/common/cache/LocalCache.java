package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: x, reason: collision with root package name */
    public static final Logger f26026x = Logger.getLogger(LocalCache.class.getName());

    /* renamed from: y, reason: collision with root package name */
    public static final s<Object, Object> f26027y = new a();

    /* renamed from: z, reason: collision with root package name */
    public static final Queue<?> f26028z = new b();

    /* renamed from: b, reason: collision with root package name */
    public final int f26029b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26030c;

    /* renamed from: d, reason: collision with root package name */
    public final Segment<K, V>[] f26031d;

    /* renamed from: e, reason: collision with root package name */
    public final int f26032e;

    /* renamed from: f, reason: collision with root package name */
    public final Equivalence<Object> f26033f;

    /* renamed from: g, reason: collision with root package name */
    public final Equivalence<Object> f26034g;

    /* renamed from: h, reason: collision with root package name */
    public final Strength f26035h;

    /* renamed from: i, reason: collision with root package name */
    public final Strength f26036i;

    /* renamed from: j, reason: collision with root package name */
    public final long f26037j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.common.cache.j<K, V> f26038k;

    /* renamed from: l, reason: collision with root package name */
    public final long f26039l;

    /* renamed from: m, reason: collision with root package name */
    public final long f26040m;

    /* renamed from: n, reason: collision with root package name */
    public final long f26041n;

    /* renamed from: o, reason: collision with root package name */
    public final Queue<RemovalNotification<K, V>> f26042o;

    /* renamed from: p, reason: collision with root package name */
    public final com.google.common.cache.i<K, V> f26043p;

    /* renamed from: q, reason: collision with root package name */
    public final com.google.common.base.v f26044q;

    /* renamed from: r, reason: collision with root package name */
    public final EntryFactory f26045r;

    /* renamed from: s, reason: collision with root package name */
    public final com.google.common.cache.b f26046s;

    /* renamed from: t, reason: collision with root package name */
    public final CacheLoader<? super K, V> f26047t;

    /* renamed from: u, reason: collision with root package name */
    public Set<K> f26048u;

    /* renamed from: v, reason: collision with root package name */
    public Collection<V> f26049v;

    /* renamed from: w, reason: collision with root package name */
    public Set<Map.Entry<K, V>> f26050w;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.common.cache.LocalCache$EntryFactory, still in use, count: 1, list:
  (r0v0 com.google.common.cache.LocalCache$EntryFactory) from 0x0058: FILLED_NEW_ARRAY 
  (r0v0 com.google.common.cache.LocalCache$EntryFactory)
  (r1v1 com.google.common.cache.LocalCache$EntryFactory)
  (r3v1 com.google.common.cache.LocalCache$EntryFactory)
  (r5v1 com.google.common.cache.LocalCache$EntryFactory)
  (r7v1 com.google.common.cache.LocalCache$EntryFactory)
  (r9v1 com.google.common.cache.LocalCache$EntryFactory)
  (r11v1 com.google.common.cache.LocalCache$EntryFactory)
  (r13v1 com.google.common.cache.LocalCache$EntryFactory)
 A[WRAPPED] elemType: com.google.common.cache.LocalCache$EntryFactory
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:238)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new o(k10, i10, hVar);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new m(k10, i10, hVar);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new q(k10, i10, hVar);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new n(k10, i10, hVar);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new w(segment.keyReferenceQueue, k10, i10, hVar);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new u(segment.keyReferenceQueue, k10, i10, hVar);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new y(segment.keyReferenceQueue, k10, i10, hVar);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new v(segment.keyReferenceQueue, k10, i10, hVar);
            }
        };

        public static final int ACCESS_MASK = 1;
        public static final int WEAK_MASK = 4;
        public static final int WRITE_MASK = 2;
        public static final EntryFactory[] factories = {new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new o(k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new m(k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new q(k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new n(k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new w(segment.keyReferenceQueue, k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new u(segment.keyReferenceQueue, k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new y(segment.keyReferenceQueue, k10, i10, hVar);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
                com.google.common.cache.h<K, V> copyEntry = super.copyEntry(segment, hVar, hVar2);
                copyAccessEntry(hVar, copyEntry);
                copyWriteEntry(hVar, copyEntry);
                return copyEntry;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            public <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
                return new v(segment.keyReferenceQueue, k10, i10, hVar);
            }
        }};

        static {
        }

        private EntryFactory() {
        }

        public static EntryFactory getFactory(Strength strength, boolean z10, boolean z11) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z10 ? 1 : 0) | (z11 ? 2 : 0)];
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        public <K, V> void copyAccessEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            hVar2.setAccessTime(hVar.getAccessTime());
            LocalCache.c(hVar.getPreviousInAccessQueue(), hVar2);
            LocalCache.c(hVar2, hVar.getNextInAccessQueue());
            LocalCache.x(hVar);
        }

        public <K, V> com.google.common.cache.h<K, V> copyEntry(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            return newEntry(segment, hVar.getKey(), hVar.getHash(), hVar2);
        }

        public <K, V> void copyWriteEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            hVar2.setWriteTime(hVar.getWriteTime());
            LocalCache.d(hVar.getPreviousInWriteQueue(), hVar2);
            LocalCache.d(hVar2, hVar.getNextInWriteQueue());
            LocalCache.y(hVar);
        }

        public abstract <K, V> com.google.common.cache.h<K, V> newEntry(Segment<K, V> segment, K k10, int i10, com.google.common.cache.h<K, V> hVar);

        public /* synthetic */ EntryFactory(a aVar) {
            this(r1, r2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements com.google.common.cache.f<K, V> {
        private static final long serialVersionUID = 1;
        public transient com.google.common.cache.f<K, V> autoDelegate;

        public LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = (com.google.common.cache.f<K, V>) recreateCacheBuilder().b(this.loader);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }

        @Override // com.google.common.cache.f, com.google.common.base.g
        public final V apply(K k10) {
            return this.autoDelegate.apply(k10);
        }

        @Override // com.google.common.cache.f
        public V get(K k10) throws ExecutionException {
            return this.autoDelegate.get(k10);
        }

        @Override // com.google.common.cache.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.f
        public V getUnchecked(K k10) {
            return this.autoDelegate.getUnchecked(k10);
        }

        @Override // com.google.common.cache.f
        public void refresh(K k10) {
            this.autoDelegate.refresh(k10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements com.google.common.cache.f<K, V> {
        private static final long serialVersionUID = 1;

        public LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super(new LocalCache(cacheBuilder, (CacheLoader) com.google.common.base.o.r(cacheLoader)), null);
        }

        @Override // com.google.common.cache.f, com.google.common.base.g
        public final V apply(K k10) {
            return getUnchecked(k10);
        }

        @Override // com.google.common.cache.f
        public V get(K k10) throws ExecutionException {
            return this.localCache.p(k10);
        }

        @Override // com.google.common.cache.f
        public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
            return this.localCache.l(iterable);
        }

        @Override // com.google.common.cache.f
        public V getUnchecked(K k10) {
            try {
                return get(k10);
            } catch (ExecutionException e2) {
                throw new UncheckedExecutionException(e2.getCause());
            }
        }

        @Override // com.google.common.cache.f
        public void refresh(K k10) {
            this.localCache.F(k10);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        public Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class LocalManualCache<K, V> implements com.google.common.cache.c<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        public final LocalCache<K, V> localCache;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends CacheLoader<Object, V> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Callable f26051a;

            public a(LocalManualCache localManualCache, Callable callable) {
                this.f26051a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public V load(Object obj) throws Exception {
                return (V) this.f26051a.call();
            }
        }

        public /* synthetic */ LocalManualCache(LocalCache localCache, a aVar) {
            this(localCache);
        }

        @Override // com.google.common.cache.c
        public ConcurrentMap<K, V> asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.c
        public void cleanUp() {
            this.localCache.b();
        }

        @Override // com.google.common.cache.c
        public V get(K k10, Callable<? extends V> callable) throws ExecutionException {
            com.google.common.base.o.r(callable);
            return this.localCache.k(k10, new a(this, callable));
        }

        @Override // com.google.common.cache.c
        public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
            return this.localCache.m(iterable);
        }

        @Override // com.google.common.cache.c
        public V getIfPresent(Object obj) {
            return this.localCache.n(obj);
        }

        @Override // com.google.common.cache.c
        public void invalidate(Object obj) {
            com.google.common.base.o.r(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.c
        public void invalidateAll(Iterable<?> iterable) {
            this.localCache.r(iterable);
        }

        @Override // com.google.common.cache.c
        public void put(K k10, V v2) {
            this.localCache.put(k10, v2);
        }

        @Override // com.google.common.cache.c
        public void putAll(Map<? extends K, ? extends V> map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.c
        public long size() {
            return this.localCache.u();
        }

        @Override // com.google.common.cache.c
        public com.google.common.cache.d stats() {
            com.google.common.cache.a aVar = new com.google.common.cache.a();
            aVar.g(this.localCache.f26046s);
            for (Segment<K, V> segment : this.localCache.f26031d) {
                aVar.g(segment.statsCounter);
            }
            return aVar.f();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // com.google.common.cache.c
        public void invalidateAll() {
            this.localCache.clear();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.localCache = localCache;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ManualSerializationProxy<K, V> extends com.google.common.cache.e<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        public final int concurrencyLevel;
        public transient com.google.common.cache.c<K, V> delegate;
        public final long expireAfterAccessNanos;
        public final long expireAfterWriteNanos;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final CacheLoader<? super K, V> loader;
        public final long maxWeight;
        public final com.google.common.cache.i<? super K, ? super V> removalListener;
        public final com.google.common.base.v ticker;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;
        public final com.google.common.cache.j<K, V> weigher;

        public ManualSerializationProxy(LocalCache<K, V> localCache) {
            this(localCache.f26035h, localCache.f26036i, localCache.f26033f, localCache.f26034g, localCache.f26040m, localCache.f26039l, localCache.f26037j, localCache.f26038k, localCache.f26032e, localCache.f26043p, localCache.f26044q, localCache.f26047t);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = (com.google.common.cache.c<K, V>) recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K, V> cacheBuilder = (CacheBuilder<K, V>) CacheBuilder.y().A(this.keyStrength).B(this.valueStrength).v(this.keyEquivalence).D(this.valueEquivalence).e(this.concurrencyLevel).z(this.removalListener);
            cacheBuilder.f26005a = false;
            long j10 = this.expireAfterWriteNanos;
            if (j10 > 0) {
                cacheBuilder.g(j10, TimeUnit.NANOSECONDS);
            }
            long j11 = this.expireAfterAccessNanos;
            if (j11 > 0) {
                cacheBuilder.f(j11, TimeUnit.NANOSECONDS);
            }
            com.google.common.cache.j jVar = this.weigher;
            if (jVar != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilder.E(jVar);
                long j12 = this.maxWeight;
                if (j12 != -1) {
                    cacheBuilder.x(j12);
                }
            } else {
                long j13 = this.maxWeight;
                if (j13 != -1) {
                    cacheBuilder.w(j13);
                }
            }
            com.google.common.base.v vVar = this.ticker;
            if (vVar != null) {
                cacheBuilder.C(vVar);
            }
            return cacheBuilder;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j10, long j11, long j12, com.google.common.cache.j<K, V> jVar, int i10, com.google.common.cache.i<? super K, ? super V> iVar, com.google.common.base.v vVar, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j10;
            this.expireAfterAccessNanos = j11;
            this.maxWeight = j12;
            this.weigher = jVar;
            this.concurrencyLevel = i10;
            this.removalListener = iVar;
            this.ticker = (vVar == com.google.common.base.v.b() || vVar == CacheBuilder.f26003t) ? null : vVar;
            this.loader = cacheLoader;
        }

        @Override // com.google.common.cache.e, com.google.common.collect.z
        public com.google.common.cache.c<K, V> delegate() {
            return this.delegate;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum NullEntry implements com.google.common.cache.h<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.h
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.h
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNext() {
            return null;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.h
        public s<Object, Object> getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.h
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.h
        public void setAccessTime(long j10) {
        }

        @Override // com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<Object, Object> hVar) {
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<Object, Object> sVar) {
        }

        @Override // com.google.common.cache.h
        public void setWriteTime(long j10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v2, int i10) {
                if (i10 == 1) {
                    return new p(v2);
                }
                return new a0(v2, i10);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v2, int i10) {
                if (i10 == 1) {
                    return new l(segment.valueReferenceQueue, v2, hVar);
                }
                return new z(segment.valueReferenceQueue, v2, hVar, i10);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            public <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v2, int i10) {
                if (i10 == 1) {
                    return new x(segment.valueReferenceQueue, v2, hVar);
                }
                return new b0(segment.valueReferenceQueue, v2, hVar, i10);
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> s<K, V> referenceValue(Segment<K, V> segment, com.google.common.cache.h<K, V> hVar, V v2, int i10);

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements s<Object, Object> {
        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<Object, Object> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<Object, Object> d(ReferenceQueue<Object> referenceQueue, Object obj, com.google.common.cache.h<Object, Object> hVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a0<K, V> extends p<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f26057c;

        public a0(V v2, int i10) {
            super(v2);
            this.f26057c = i10;
        }

        @Override // com.google.common.cache.LocalCache.p, com.google.common.cache.LocalCache.s
        public int getWeight() {
            return this.f26057c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractQueue<Object> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Object> iterator2() {
            return ImmutableSet.of().iterator2();
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b0<K, V> extends x<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f26058c;

        public b0(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar, int i10) {
            super(referenceQueue, v2, hVar);
            this.f26058c = i10;
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return new b0(referenceQueue, v2, hVar, this.f26058c);
        }

        @Override // com.google.common.cache.LocalCache.x, com.google.common.cache.LocalCache.s
        public int getWeight() {
            return this.f26058c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class c<T> extends AbstractSet<T> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c0<K, V> extends AbstractQueue<com.google.common.cache.h<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26060b = new a(this);

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends d<K, V> {

            /* renamed from: b, reason: collision with root package name */
            public com.google.common.cache.h<K, V> f26061b = this;

            /* renamed from: c, reason: collision with root package name */
            public com.google.common.cache.h<K, V> f26062c = this;

            public a(c0 c0Var) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getNextInWriteQueue() {
                return this.f26061b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
                return this.f26062c;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
                this.f26061b = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
                this.f26062c = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setWriteTime(long j10) {
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends com.google.common.collect.g<com.google.common.cache.h<K, V>> {
            public b(com.google.common.cache.h hVar) {
                super(hVar);
            }

            @Override // com.google.common.collect.g
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.h<K, V> a(com.google.common.cache.h<K, V> hVar) {
                com.google.common.cache.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
                if (nextInWriteQueue == c0.this.f26060b) {
                    return null;
                }
                return nextInWriteQueue;
            }
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.h<K, V> hVar) {
            LocalCache.d(hVar.getPreviousInWriteQueue(), hVar.getNextInWriteQueue());
            LocalCache.d(this.f26060b.getPreviousInWriteQueue(), hVar);
            LocalCache.d(hVar, this.f26060b);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> peek() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f26060b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f26060b) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f26060b.getNextInWriteQueue();
            while (true) {
                com.google.common.cache.h<K, V> hVar = this.f26060b;
                if (nextInWriteQueue != hVar) {
                    com.google.common.cache.h<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.y(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    hVar.setNextInWriteQueue(hVar);
                    com.google.common.cache.h<K, V> hVar2 = this.f26060b;
                    hVar2.setPreviousInWriteQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ((com.google.common.cache.h) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> poll() {
            com.google.common.cache.h<K, V> nextInWriteQueue = this.f26060b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f26060b) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f26060b.getNextInWriteQueue() == this.f26060b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<com.google.common.cache.h<K, V>> iterator2() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            com.google.common.cache.h hVar = (com.google.common.cache.h) obj;
            com.google.common.cache.h<K, V> previousInWriteQueue = hVar.getPreviousInWriteQueue();
            com.google.common.cache.h<K, V> nextInWriteQueue = hVar.getNextInWriteQueue();
            LocalCache.d(previousInWriteQueue, nextInWriteQueue);
            LocalCache.y(hVar);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i10 = 0;
            for (com.google.common.cache.h<K, V> nextInWriteQueue = this.f26060b.getNextInWriteQueue(); nextInWriteQueue != this.f26060b; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i10++;
            }
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class d<K, V> implements com.google.common.cache.h<K, V> {
        @Override // com.google.common.cache.h
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public K getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public s<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setAccessTime(long j10) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setWriteTime(long j10) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class d0 implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26064b;

        /* renamed from: c, reason: collision with root package name */
        public V f26065c;

        public d0(K k10, V v2) {
            this.f26064b = k10;
            this.f26065c = v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f26064b.equals(entry.getKey()) && this.f26065c.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f26064b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f26065c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f26064b.hashCode() ^ this.f26065c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = (V) LocalCache.this.put(this.f26064b, v2);
            this.f26065c = v2;
            return v10;
        }

        public String toString() {
            String valueOf = String.valueOf(getKey());
            String valueOf2 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("=");
            sb2.append(valueOf2);
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e<K, V> extends AbstractQueue<com.google.common.cache.h<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26067b = new a(this);

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends d<K, V> {

            /* renamed from: b, reason: collision with root package name */
            public com.google.common.cache.h<K, V> f26068b = this;

            /* renamed from: c, reason: collision with root package name */
            public com.google.common.cache.h<K, V> f26069c = this;

            public a(e eVar) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getNextInAccessQueue() {
                return this.f26068b;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
                return this.f26069c;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setAccessTime(long j10) {
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
                this.f26068b = hVar;
            }

            @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
            public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
                this.f26069c = hVar;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends com.google.common.collect.g<com.google.common.cache.h<K, V>> {
            public b(com.google.common.cache.h hVar) {
                super(hVar);
            }

            @Override // com.google.common.collect.g
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.h<K, V> a(com.google.common.cache.h<K, V> hVar) {
                com.google.common.cache.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
                if (nextInAccessQueue == e.this.f26067b) {
                    return null;
                }
                return nextInAccessQueue;
            }
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.h<K, V> hVar) {
            LocalCache.c(hVar.getPreviousInAccessQueue(), hVar.getNextInAccessQueue());
            LocalCache.c(this.f26067b.getPreviousInAccessQueue(), hVar);
            LocalCache.c(hVar, this.f26067b);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> peek() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f26067b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f26067b) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f26067b.getNextInAccessQueue();
            while (true) {
                com.google.common.cache.h<K, V> hVar = this.f26067b;
                if (nextInAccessQueue != hVar) {
                    com.google.common.cache.h<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.x(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    hVar.setNextInAccessQueue(hVar);
                    com.google.common.cache.h<K, V> hVar2 = this.f26067b;
                    hVar2.setPreviousInAccessQueue(hVar2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ((com.google.common.cache.h) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.h<K, V> poll() {
            com.google.common.cache.h<K, V> nextInAccessQueue = this.f26067b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f26067b) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f26067b.getNextInAccessQueue() == this.f26067b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<com.google.common.cache.h<K, V>> iterator2() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            com.google.common.cache.h hVar = (com.google.common.cache.h) obj;
            com.google.common.cache.h<K, V> previousInAccessQueue = hVar.getPreviousInAccessQueue();
            com.google.common.cache.h<K, V> nextInAccessQueue = hVar.getNextInAccessQueue();
            LocalCache.c(previousInAccessQueue, nextInAccessQueue);
            LocalCache.x(hVar);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i10 = 0;
            for (com.google.common.cache.h<K, V> nextInAccessQueue = this.f26067b.getNextInAccessQueue(); nextInAccessQueue != this.f26067b; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i10++;
            }
            return i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class f extends LocalCache<K, V>.h<Map.Entry<K, V>> {
        public f(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class g extends LocalCache<K, V>.c<Map.Entry<K, V>> {
        public g() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f26034g.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new f(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class h<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f26072b;

        /* renamed from: c, reason: collision with root package name */
        public int f26073c = -1;

        /* renamed from: d, reason: collision with root package name */
        public Segment<K, V> f26074d;

        /* renamed from: e, reason: collision with root package name */
        public AtomicReferenceArray<com.google.common.cache.h<K, V>> f26075e;

        /* renamed from: f, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26076f;

        /* renamed from: g, reason: collision with root package name */
        public LocalCache<K, V>.d0 f26077g;

        /* renamed from: h, reason: collision with root package name */
        public LocalCache<K, V>.d0 f26078h;

        public h() {
            this.f26072b = LocalCache.this.f26031d.length - 1;
            a();
        }

        public final void a() {
            this.f26077g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f26072b;
                if (i10 < 0) {
                    return;
                }
                Segment<K, V>[] segmentArr = LocalCache.this.f26031d;
                this.f26072b = i10 - 1;
                Segment<K, V> segment = segmentArr[i10];
                this.f26074d = segment;
                if (segment.count != 0) {
                    this.f26075e = this.f26074d.table;
                    this.f26073c = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(com.google.common.cache.h<K, V> hVar) {
            boolean z10;
            try {
                long a10 = LocalCache.this.f26044q.a();
                K key = hVar.getKey();
                Object o10 = LocalCache.this.o(hVar, a10);
                if (o10 != null) {
                    this.f26077g = new d0(key, o10);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return z10;
            } finally {
                this.f26074d.postReadCleanup();
            }
        }

        public LocalCache<K, V>.d0 c() {
            LocalCache<K, V>.d0 d0Var = this.f26077g;
            if (d0Var != null) {
                this.f26078h = d0Var;
                a();
                return this.f26078h;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            com.google.common.cache.h<K, V> hVar = this.f26076f;
            if (hVar == null) {
                return false;
            }
            while (true) {
                this.f26076f = hVar.getNext();
                com.google.common.cache.h<K, V> hVar2 = this.f26076f;
                if (hVar2 == null) {
                    return false;
                }
                if (b(hVar2)) {
                    return true;
                }
                hVar = this.f26076f;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f26073c;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.f26075e;
                this.f26073c = i10 - 1;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i10);
                this.f26076f = hVar;
                if (hVar != null && (b(hVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26077g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.o.x(this.f26078h != null);
            LocalCache.this.remove(this.f26078h.getKey());
            this.f26078h = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class i extends LocalCache<K, V>.h<K> {
        public i(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class j extends LocalCache<K, V>.c<K> {
        public j() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new i(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class k<K, V> implements s<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public volatile s<K, V> f26081b;

        /* renamed from: c, reason: collision with root package name */
        public final com.google.common.util.concurrent.t<V> f26082c;

        /* renamed from: d, reason: collision with root package name */
        public final com.google.common.base.r f26083d;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements com.google.common.base.g<V, V> {
            public a() {
            }

            @Override // com.google.common.base.g
            public V apply(V v2) {
                k.this.i(v2);
                return v2;
            }
        }

        public k() {
            this(LocalCache.K());
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v2) {
            if (v2 != null) {
                i(v2);
            } else {
                this.f26081b = LocalCache.K();
            }
        }

        @Override // com.google.common.cache.LocalCache.s
        public V c() throws ExecutionException {
            return (V) com.google.common.util.concurrent.w.a(this.f26082c);
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return this;
        }

        public long e() {
            return this.f26083d.e(TimeUnit.NANOSECONDS);
        }

        public final com.google.common.util.concurrent.n<V> f(Throwable th) {
            return com.google.common.util.concurrent.i.b(th);
        }

        public s<K, V> g() {
            return this.f26081b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f26081b.get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return this.f26081b.getWeight();
        }

        public com.google.common.util.concurrent.n<V> h(K k10, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f26083d.h();
                V v2 = this.f26081b.get();
                if (v2 == null) {
                    V load = cacheLoader.load(k10);
                    return i(load) ? this.f26082c : com.google.common.util.concurrent.i.c(load);
                }
                com.google.common.util.concurrent.n<V> reload = cacheLoader.reload(k10, v2);
                if (reload == null) {
                    return com.google.common.util.concurrent.i.c(null);
                }
                return com.google.common.util.concurrent.i.d(reload, new a(), com.google.common.util.concurrent.p.a());
            } catch (Throwable th) {
                com.google.common.util.concurrent.n<V> f10 = j(th) ? this.f26082c : f(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return f10;
            }
        }

        public boolean i(V v2) {
            return this.f26082c.set(v2);
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return this.f26081b.isActive();
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return true;
        }

        public boolean j(Throwable th) {
            return this.f26082c.setException(th);
        }

        public k(s<K, V> sVar) {
            this.f26082c = com.google.common.util.concurrent.t.a();
            this.f26083d = com.google.common.base.r.d();
            this.f26081b = sVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class l<K, V> extends SoftReference<V> implements s<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26085b;

        public l(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            super(v2, referenceQueue);
            this.f26085b = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return this.f26085b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v2) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return new l(referenceQueue, v2, hVar);
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class m<K, V> extends o<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public volatile long f26086f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26087g;

        /* renamed from: h, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26088h;

        public m(K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(k10, i10, hVar);
            this.f26086f = Long.MAX_VALUE;
            this.f26087g = LocalCache.w();
            this.f26088h = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getAccessTime() {
            return this.f26086f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f26087g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f26088h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setAccessTime(long j10) {
            this.f26086f = j10;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26087g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26088h = hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class n<K, V> extends o<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public volatile long f26089f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26090g;

        /* renamed from: h, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26091h;

        /* renamed from: i, reason: collision with root package name */
        public volatile long f26092i;

        /* renamed from: j, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26093j;

        /* renamed from: k, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26094k;

        public n(K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(k10, i10, hVar);
            this.f26089f = Long.MAX_VALUE;
            this.f26090g = LocalCache.w();
            this.f26091h = LocalCache.w();
            this.f26092i = Long.MAX_VALUE;
            this.f26093j = LocalCache.w();
            this.f26094k = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getAccessTime() {
            return this.f26089f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f26090g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f26093j;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f26091h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.f26094k;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getWriteTime() {
            return this.f26092i;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setAccessTime(long j10) {
            this.f26089f = j10;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26090g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26093j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26091h = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26094k = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setWriteTime(long j10) {
            this.f26092i = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class o<K, V> extends d<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26095b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26096c;

        /* renamed from: d, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26097d;

        /* renamed from: e, reason: collision with root package name */
        public volatile s<K, V> f26098e = LocalCache.K();

        public o(K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            this.f26095b = k10;
            this.f26096c = i10;
            this.f26097d = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public int getHash() {
            return this.f26096c;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public K getKey() {
            return this.f26095b;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            return this.f26097d;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public s<K, V> getValueReference() {
            return this.f26098e;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            this.f26098e = sVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class p<K, V> implements s<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final V f26099b;

        public p(V v2) {
            this.f26099b = v2;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v2) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public V c() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.s
        public V get() {
            return this.f26099b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class q<K, V> extends o<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public volatile long f26100f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26101g;

        /* renamed from: h, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26102h;

        public q(K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(k10, i10, hVar);
            this.f26100f = Long.MAX_VALUE;
            this.f26101g = LocalCache.w();
            this.f26102h = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f26101g;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.f26102h;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public long getWriteTime() {
            return this.f26100f;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26101g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26102h = hVar;
        }

        @Override // com.google.common.cache.LocalCache.d, com.google.common.cache.h
        public void setWriteTime(long j10) {
            this.f26100f = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class r extends LocalCache<K, V>.h<V> {
        public r(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface s<K, V> {
        com.google.common.cache.h<K, V> a();

        void b(V v2);

        V c() throws ExecutionException;

        s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar);

        V get();

        int getWeight();

        boolean isActive();

        boolean isLoading();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class t extends AbstractCollection<V> {
        public t() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new r(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.J(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) LocalCache.J(this).toArray(eArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class u<K, V> extends w<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f26104e;

        /* renamed from: f, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26105f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26106g;

        public u(ReferenceQueue<K> referenceQueue, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k10, i10, hVar);
            this.f26104e = Long.MAX_VALUE;
            this.f26105f = LocalCache.w();
            this.f26106g = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getAccessTime() {
            return this.f26104e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f26105f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f26106g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setAccessTime(long j10) {
            this.f26104e = j10;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26105f = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26106g = hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class v<K, V> extends w<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f26107e;

        /* renamed from: f, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26108f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26109g;

        /* renamed from: h, reason: collision with root package name */
        public volatile long f26110h;

        /* renamed from: i, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26111i;

        /* renamed from: j, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26112j;

        public v(ReferenceQueue<K> referenceQueue, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k10, i10, hVar);
            this.f26107e = Long.MAX_VALUE;
            this.f26108f = LocalCache.w();
            this.f26109g = LocalCache.w();
            this.f26110h = Long.MAX_VALUE;
            this.f26111i = LocalCache.w();
            this.f26112j = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getAccessTime() {
            return this.f26107e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            return this.f26108f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f26111i;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            return this.f26109g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.f26112j;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getWriteTime() {
            return this.f26110h;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setAccessTime(long j10) {
            this.f26107e = j10;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26108f = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26111i = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26109g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26112j = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setWriteTime(long j10) {
            this.f26110h = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class w<K, V> extends WeakReference<K> implements com.google.common.cache.h<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final int f26113b;

        /* renamed from: c, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26114c;

        /* renamed from: d, reason: collision with root package name */
        public volatile s<K, V> f26115d;

        public w(ReferenceQueue<K> referenceQueue, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(k10, referenceQueue);
            this.f26115d = LocalCache.K();
            this.f26113b = i10;
            this.f26114c = hVar;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public int getHash() {
            return this.f26113b;
        }

        @Override // com.google.common.cache.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNext() {
            return this.f26114c;
        }

        public com.google.common.cache.h<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public s<K, V> getValueReference() {
            return this.f26115d;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j10) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.h
        public void setValueReference(s<K, V> sVar) {
            this.f26115d = sVar;
        }

        public void setWriteTime(long j10) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class x<K, V> extends WeakReference<V> implements s<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final com.google.common.cache.h<K, V> f26116b;

        public x(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            super(v2, referenceQueue);
            this.f26116b = hVar;
        }

        @Override // com.google.common.cache.LocalCache.s
        public com.google.common.cache.h<K, V> a() {
            return this.f26116b;
        }

        @Override // com.google.common.cache.LocalCache.s
        public void b(V v2) {
        }

        @Override // com.google.common.cache.LocalCache.s
        public V c() {
            return get();
        }

        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return new x(referenceQueue, v2, hVar);
        }

        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.s
        public boolean isLoading() {
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class y<K, V> extends w<K, V> {

        /* renamed from: e, reason: collision with root package name */
        public volatile long f26117e;

        /* renamed from: f, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26118f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.common.cache.h<K, V> f26119g;

        public y(ReferenceQueue<K> referenceQueue, K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            super(referenceQueue, k10, i10, hVar);
            this.f26117e = Long.MAX_VALUE;
            this.f26118f = LocalCache.w();
            this.f26119g = LocalCache.w();
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getNextInWriteQueue() {
            return this.f26118f;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public com.google.common.cache.h<K, V> getPreviousInWriteQueue() {
            return this.f26119g;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public long getWriteTime() {
            return this.f26117e;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setNextInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26118f = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setPreviousInWriteQueue(com.google.common.cache.h<K, V> hVar) {
            this.f26119g = hVar;
        }

        @Override // com.google.common.cache.LocalCache.w, com.google.common.cache.h
        public void setWriteTime(long j10) {
            this.f26117e = j10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class z<K, V> extends l<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public final int f26120c;

        public z(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar, int i10) {
            super(referenceQueue, v2, hVar);
            this.f26120c = i10;
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public s<K, V> d(ReferenceQueue<V> referenceQueue, V v2, com.google.common.cache.h<K, V> hVar) {
            return new z(referenceQueue, v2, hVar, this.f26120c);
        }

        @Override // com.google.common.cache.LocalCache.l, com.google.common.cache.LocalCache.s
        public int getWeight() {
            return this.f26120c;
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> concurrentLinkedQueue;
        this.f26032e = Math.min(cacheBuilder.h(), 65536);
        Strength m10 = cacheBuilder.m();
        this.f26035h = m10;
        this.f26036i = cacheBuilder.t();
        this.f26033f = cacheBuilder.l();
        this.f26034g = cacheBuilder.s();
        long n10 = cacheBuilder.n();
        this.f26037j = n10;
        this.f26038k = (com.google.common.cache.j<K, V>) cacheBuilder.u();
        this.f26039l = cacheBuilder.i();
        this.f26040m = cacheBuilder.j();
        this.f26041n = cacheBuilder.o();
        CacheBuilder.NullListener nullListener = (com.google.common.cache.i<K, V>) cacheBuilder.p();
        this.f26043p = nullListener;
        if (nullListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = g();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        }
        this.f26042o = concurrentLinkedQueue;
        this.f26044q = cacheBuilder.r(D());
        this.f26045r = EntryFactory.getFactory(m10, L(), P());
        this.f26046s = cacheBuilder.q().get();
        this.f26047t = cacheLoader;
        int min = Math.min(cacheBuilder.k(), 1073741824);
        if (h() && !f()) {
            min = (int) Math.min(min, n10);
        }
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (i12 < this.f26032e && (!h() || i12 * 20 <= this.f26037j)) {
            i13++;
            i12 <<= 1;
        }
        this.f26030c = 32 - i13;
        this.f26029b = i12 - 1;
        this.f26031d = v(i12);
        int i14 = min / i12;
        while (i11 < (i14 * i12 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        if (h()) {
            long j10 = this.f26037j;
            long j11 = i12;
            long j12 = (j10 / j11) + 1;
            long j13 = j10 % j11;
            while (true) {
                Segment<K, V>[] segmentArr = this.f26031d;
                if (i10 >= segmentArr.length) {
                    return;
                }
                if (i10 == j13) {
                    j12--;
                }
                segmentArr[i10] = e(i11, j12, cacheBuilder.q().get());
                i10++;
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f26031d;
                if (i10 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i10] = e(i11, -1L, cacheBuilder.q().get());
                i10++;
            }
        }
    }

    public static int H(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    public static <E> ArrayList<E> J(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator2());
        return arrayList;
    }

    public static <K, V> s<K, V> K() {
        return (s<K, V>) f26027y;
    }

    public static <K, V> void c(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
        hVar.setNextInAccessQueue(hVar2);
        hVar2.setPreviousInAccessQueue(hVar);
    }

    public static <K, V> void d(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
        hVar.setNextInWriteQueue(hVar2);
        hVar2.setPreviousInWriteQueue(hVar);
    }

    public static <E> Queue<E> g() {
        return (Queue<E>) f26028z;
    }

    public static <K, V> com.google.common.cache.h<K, V> w() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void x(com.google.common.cache.h<K, V> hVar) {
        com.google.common.cache.h<K, V> w3 = w();
        hVar.setNextInAccessQueue(w3);
        hVar.setPreviousInAccessQueue(w3);
    }

    public static <K, V> void y(com.google.common.cache.h<K, V> hVar) {
        com.google.common.cache.h<K, V> w3 = w();
        hVar.setNextInWriteQueue(w3);
        hVar.setPreviousInWriteQueue(w3);
    }

    public void A(com.google.common.cache.h<K, V> hVar) {
        int hash = hVar.getHash();
        I(hash).reclaimKey(hVar, hash);
    }

    public void B(s<K, V> sVar) {
        com.google.common.cache.h<K, V> a10 = sVar.a();
        int hash = a10.getHash();
        I(hash).reclaimValue(a10.getKey(), hash, sVar);
    }

    public boolean C() {
        return i();
    }

    public boolean D() {
        return E() || C();
    }

    public boolean E() {
        return j() || G();
    }

    public void F(K k10) {
        int q10 = q(com.google.common.base.o.r(k10));
        I(q10).refresh(k10, q10, this.f26047t, false);
    }

    public boolean G() {
        return this.f26041n > 0;
    }

    public Segment<K, V> I(int i10) {
        return this.f26031d[(i10 >>> this.f26030c) & this.f26029b];
    }

    public boolean L() {
        return M() || C();
    }

    public boolean M() {
        return i() || h();
    }

    public boolean N() {
        return this.f26035h != Strength.STRONG;
    }

    public boolean O() {
        return this.f26036i != Strength.STRONG;
    }

    public boolean P() {
        return Q() || E();
    }

    public boolean Q() {
        return j();
    }

    public void b() {
        for (Segment<K, V> segment : this.f26031d) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.f26031d) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int q10 = q(obj);
        return I(q10).containsKey(obj, q10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long a10 = this.f26044q.a();
        Segment<K, V>[] segmentArr = this.f26031d;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            long j11 = 0;
            int length = segmentArr.length;
            int i11 = 0;
            while (i11 < length) {
                Segment<K, V> segment = segmentArr[i11];
                int i12 = segment.count;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = segment.table;
                for (int i13 = 0; i13 < atomicReferenceArray.length(); i13++) {
                    com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i13);
                    while (hVar != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(hVar, a10);
                        long j12 = a10;
                        if (liveValue != null && this.f26034g.equivalent(obj, liveValue)) {
                            return true;
                        }
                        hVar = hVar.getNext();
                        segmentArr = segmentArr2;
                        a10 = j12;
                    }
                }
                j11 += segment.modCount;
                i11++;
                a10 = a10;
            }
            long j13 = a10;
            Segment<K, V>[] segmentArr3 = segmentArr;
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
            segmentArr = segmentArr3;
            a10 = j13;
        }
        return false;
    }

    public Segment<K, V> e(int i10, long j10, com.google.common.cache.b bVar) {
        return new Segment<>(this, i10, j10, bVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f26050w;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f26050w = gVar;
        return gVar;
    }

    public boolean f() {
        return this.f26038k != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int q10 = q(obj);
        return I(q10).get(obj, q10);
    }

    @Override // java.util.Map
    public V getOrDefault(Object obj, V v2) {
        V v10 = get(obj);
        return v10 != null ? v10 : v2;
    }

    public boolean h() {
        return this.f26037j >= 0;
    }

    public boolean i() {
        return this.f26039l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f26031d;
        long j10 = 0;
        for (int i10 = 0; i10 < segmentArr.length; i10++) {
            if (segmentArr[i10].count != 0) {
                return false;
            }
            j10 += segmentArr[i10].modCount;
        }
        if (j10 == 0) {
            return true;
        }
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j10 -= segmentArr[i11].modCount;
        }
        return j10 == 0;
    }

    public boolean j() {
        return this.f26040m > 0;
    }

    public V k(K k10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int q10 = q(com.google.common.base.o.r(k10));
        return I(q10).get(k10, q10, cacheLoader);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = this.f26048u;
        if (set != null) {
            return set;
        }
        j jVar = new j();
        this.f26048u = jVar;
        return jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> l(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap s2 = Maps.s();
        LinkedHashSet g3 = Sets.g();
        int i10 = 0;
        int i11 = 0;
        for (K k10 : iterable) {
            Object obj = get(k10);
            if (!s2.containsKey(k10)) {
                s2.put(k10, obj);
                if (obj == null) {
                    i11++;
                    g3.add(k10);
                } else {
                    i10++;
                }
            }
        }
        try {
            if (!g3.isEmpty()) {
                try {
                    Map t2 = t(Collections.unmodifiableSet(g3), this.f26047t);
                    for (Object obj2 : g3) {
                        Object obj3 = t2.get(obj2);
                        if (obj3 != null) {
                            s2.put(obj2, obj3);
                        } else {
                            String valueOf = String.valueOf(obj2);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
                            sb2.append("loadAll failed to return a value for ");
                            sb2.append(valueOf);
                            throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
                        }
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj4 : g3) {
                        i11--;
                        s2.put(obj4, k(obj4, this.f26047t));
                    }
                }
            }
            return ImmutableMap.copyOf((Map) s2);
        } finally {
            this.f26046s.a(i10);
            this.f26046s.d(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableMap<K, V> m(Iterable<?> iterable) {
        ImmutableMap.b builder = ImmutableMap.builder();
        int i10 = 0;
        int i11 = 0;
        for (Object obj : iterable) {
            V v2 = get(obj);
            if (v2 == null) {
                i11++;
            } else {
                builder.g(obj, v2);
                i10++;
            }
        }
        this.f26046s.a(i10);
        this.f26046s.d(i11);
        return builder.c();
    }

    public V n(Object obj) {
        int q10 = q(com.google.common.base.o.r(obj));
        V v2 = I(q10).get(obj, q10);
        if (v2 == null) {
            this.f26046s.d(1);
        } else {
            this.f26046s.a(1);
        }
        return v2;
    }

    public V o(com.google.common.cache.h<K, V> hVar, long j10) {
        V v2;
        if (hVar.getKey() == null || (v2 = hVar.getValueReference().get()) == null || s(hVar, j10)) {
            return null;
        }
        return v2;
    }

    public V p(K k10) throws ExecutionException {
        return k(k10, this.f26047t);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v2);
        int q10 = q(k10);
        return I(q10).put(k10, q10, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k10, V v2) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v2);
        int q10 = q(k10);
        return I(q10).put(k10, q10, v2, true);
    }

    public int q(Object obj) {
        return H(this.f26033f.hash(obj));
    }

    public void r(Iterable<?> iterable) {
        Iterator<?> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            remove(iterator2.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int q10 = q(obj);
        return I(q10).remove(obj, q10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v2, V v10) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v10);
        if (v2 == null) {
            return false;
        }
        int q10 = q(k10);
        return I(q10).replace(k10, q10, v2, v10);
    }

    public boolean s(com.google.common.cache.h<K, V> hVar, long j10) {
        com.google.common.base.o.r(hVar);
        if (!i() || j10 - hVar.getAccessTime() < this.f26039l) {
            return j() && j10 - hVar.getWriteTime() >= this.f26040m;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.l(u());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<K, V> t(java.util.Set<? extends K> r7, com.google.common.cache.CacheLoader<? super K, V> r8) throws java.util.concurrent.ExecutionException {
        /*
            r6 = this;
            com.google.common.base.o.r(r8)
            com.google.common.base.o.r(r7)
            com.google.common.base.r r0 = com.google.common.base.r.c()
            r1 = 1
            r2 = 0
            java.util.Map r7 = r8.loadAll(r7)     // Catch: java.lang.Throwable -> La2 java.lang.Error -> La5 java.lang.Exception -> Lac java.lang.RuntimeException -> Lb3 java.lang.InterruptedException -> Lba com.google.common.cache.CacheLoader.UnsupportedLoadingOperationException -> Lc8
            if (r7 == 0) goto L76
            r0.i()
            java.util.Set r3 = r7.entrySet()
            java.util.Iterator r3 = r3.iterator2()
        L1d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L3c
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r5 == 0) goto L3a
            if (r4 != 0) goto L36
            goto L3a
        L36:
            r6.put(r5, r4)
            goto L1d
        L3a:
            r2 = 1
            goto L1d
        L3c:
            if (r2 != 0) goto L4a
            com.google.common.cache.b r8 = r6.f26046s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r8.c(r0)
            return r7
        L4a:
            com.google.common.cache.b r7 = r6.f26046s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r7.e(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r0 = r8.length()
            int r0 = r0 + 42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r8)
            java.lang.String r8 = " returned null keys or values from loadAll"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.<init>(r8)
            throw r7
        L76:
            com.google.common.cache.b r7 = r6.f26046s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r7.e(r0)
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r7 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r0 = r8.length()
            int r0 = r0 + 31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r8)
            java.lang.String r8 = " returned null map from loadAll"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.<init>(r8)
            throw r7
        La2:
            r7 = move-exception
            r1 = 0
            goto Lcb
        La5:
            r7 = move-exception
            com.google.common.util.concurrent.ExecutionError r8 = new com.google.common.util.concurrent.ExecutionError     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lac:
            r7 = move-exception
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lb3:
            r7 = move-exception
            com.google.common.util.concurrent.UncheckedExecutionException r8 = new com.google.common.util.concurrent.UncheckedExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lba:
            r7 = move-exception
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> La2
            r8.interrupt()     // Catch: java.lang.Throwable -> La2
            java.util.concurrent.ExecutionException r8 = new java.util.concurrent.ExecutionException     // Catch: java.lang.Throwable -> La2
            r8.<init>(r7)     // Catch: java.lang.Throwable -> La2
            throw r8     // Catch: java.lang.Throwable -> La2
        Lc8:
            r7 = move-exception
            throw r7     // Catch: java.lang.Throwable -> Lca
        Lca:
            r7 = move-exception
        Lcb:
            if (r1 != 0) goto Ld8
            com.google.common.cache.b r8 = r6.f26046s
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r0 = r0.e(r1)
            r8.e(r0)
        Ld8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.t(java.util.Set, com.google.common.cache.CacheLoader):java.util.Map");
    }

    public long u() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.f26031d.length; i10++) {
            j10 += Math.max(0, r0[i10].count);
        }
        return j10;
    }

    public final Segment<K, V>[] v(int i10) {
        return new Segment[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f26049v;
        if (collection != null) {
            return collection;
        }
        t tVar = new t();
        this.f26049v = tVar;
        return tVar;
    }

    public void z() {
        while (true) {
            RemovalNotification<K, V> poll = this.f26042o.poll();
            if (poll == null) {
                return;
            }
            try {
                this.f26043p.onRemoval(poll);
            } catch (Throwable th) {
                f26026x.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int q10 = q(obj);
        return I(q10).remove(obj, q10, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v2) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v2);
        int q10 = q(k10);
        return I(q10).replace(k10, q10, v2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Segment<K, V> extends ReentrantLock {
        public final Queue<com.google.common.cache.h<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public final Queue<com.google.common.cache.h<K, V>> recencyQueue;
        public final com.google.common.cache.b statsCounter;
        public volatile AtomicReferenceArray<com.google.common.cache.h<K, V>> table;
        public int threshold;
        public long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        public final Queue<com.google.common.cache.h<K, V>> writeQueue;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f26052b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f26053c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ k f26054d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ com.google.common.util.concurrent.n f26055e;

            public a(Object obj, int i10, k kVar, com.google.common.util.concurrent.n nVar) {
                this.f26052b = obj;
                this.f26053c = i10;
                this.f26054d = kVar;
                this.f26055e = nVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Segment.this.getAndRecordStats(this.f26052b, this.f26053c, this.f26054d, this.f26055e);
                } catch (Throwable th) {
                    LocalCache.f26026x.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.f26054d.j(th);
                }
            }
        }

        public Segment(LocalCache<K, V> localCache, int i10, long j10, com.google.common.cache.b bVar) {
            Queue<com.google.common.cache.h<K, V>> g3;
            Queue<com.google.common.cache.h<K, V>> g10;
            Queue<com.google.common.cache.h<K, V>> g11;
            this.map = localCache;
            this.maxSegmentWeight = j10;
            this.statsCounter = (com.google.common.cache.b) com.google.common.base.o.r(bVar);
            initTable(newEntryArray(i10));
            this.keyReferenceQueue = localCache.N() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.O() ? new ReferenceQueue<>() : null;
            if (localCache.M()) {
                g3 = new ConcurrentLinkedQueue<>();
            } else {
                g3 = LocalCache.g();
            }
            this.recencyQueue = g3;
            if (localCache.Q()) {
                g10 = new c0<>();
            } else {
                g10 = LocalCache.g();
            }
            this.writeQueue = g10;
            if (localCache.M()) {
                g11 = new e<>();
            } else {
                g11 = LocalCache.g();
            }
            this.accessQueue = g11;
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f26044q.a());
            runUnlockedCleanup();
        }

        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.f26044q.a());
                    AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        for (com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i10); hVar != null; hVar = hVar.getNext()) {
                            if (hVar.getValueReference().isActive()) {
                                K key = hVar.getKey();
                                V v2 = hVar.getValueReference().get();
                                if (key != null && v2 != null) {
                                    removalCause = RemovalCause.EXPLICIT;
                                    enqueueNotification(key, hVar.getHash(), v2, hVar.getValueReference().getWeight(), removalCause);
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, hVar.getHash(), v2, hVar.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        atomicReferenceArray.set(i11, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        public void clearReferenceQueues() {
            if (this.map.N()) {
                clearKeyReferenceQueue();
            }
            if (this.map.O()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        public boolean containsKey(Object obj, int i10) {
            try {
                if (this.count == 0) {
                    return false;
                }
                com.google.common.cache.h<K, V> liveEntry = getLiveEntry(obj, i10, this.map.f26044q.a());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    long a10 = this.map.f26044q.a();
                    AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i10); hVar != null; hVar = hVar.getNext()) {
                            V liveValue = getLiveValue(hVar, a10);
                            if (liveValue != null && this.map.f26034g.equivalent(obj, liveValue)) {
                                postReadCleanup();
                                return true;
                            }
                        }
                    }
                }
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public com.google.common.cache.h<K, V> copyEntry(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            if (hVar.getKey() == null) {
                return null;
            }
            s<K, V> valueReference = hVar.getValueReference();
            V v2 = valueReference.get();
            if (v2 == null && valueReference.isActive()) {
                return null;
            }
            com.google.common.cache.h<K, V> copyEntry = this.map.f26045r.copyEntry(this, hVar, hVar2);
            copyEntry.setValueReference(valueReference.d(this.valueReferenceQueue, v2, copyEntry));
            return copyEntry;
        }

        public void drainKeyReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.A((com.google.common.cache.h) poll);
                i10++;
            } while (i10 != 16);
        }

        public void drainRecencyQueue() {
            while (true) {
                com.google.common.cache.h<K, V> poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        public void drainReferenceQueues() {
            if (this.map.N()) {
                drainKeyReferenceQueue();
            }
            if (this.map.O()) {
                drainValueReferenceQueue();
            }
        }

        public void drainValueReferenceQueue() {
            int i10 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.B((s) poll);
                i10++;
            } while (i10 != 16);
        }

        public void enqueueNotification(K k10, int i10, V v2, int i11, RemovalCause removalCause) {
            this.totalWeight -= i11;
            if (removalCause.wasEvicted()) {
                this.statsCounter.b();
            }
            if (this.map.f26042o != LocalCache.f26028z) {
                this.map.f26042o.offer(RemovalNotification.create(k10, v2, removalCause));
            }
        }

        public void evictEntries(com.google.common.cache.h<K, V> hVar) {
            if (this.map.h()) {
                drainRecencyQueue();
                if (hVar.getValueReference().getWeight() > this.maxSegmentWeight && !removeEntry(hVar, hVar.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    com.google.common.cache.h<K, V> nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void expand() {
            AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            AtomicReferenceArray<com.google.common.cache.h<K, V>> newEntryArray = newEntryArray(length << 1);
            this.threshold = (newEntryArray.length() * 3) / 4;
            int length2 = newEntryArray.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(i11);
                if (hVar != null) {
                    com.google.common.cache.h<K, V> next = hVar.getNext();
                    int hash = hVar.getHash() & length2;
                    if (next == null) {
                        newEntryArray.set(hash, hVar);
                    } else {
                        com.google.common.cache.h<K, V> hVar2 = hVar;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar2 = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        newEntryArray.set(hash, hVar2);
                        while (hVar != hVar2) {
                            int hash3 = hVar.getHash() & length2;
                            com.google.common.cache.h<K, V> copyEntry = copyEntry(hVar, newEntryArray.get(hash3));
                            if (copyEntry != null) {
                                newEntryArray.set(hash3, copyEntry);
                            } else {
                                removeCollectedEntry(hVar);
                                i10--;
                            }
                            hVar = hVar.getNext();
                        }
                    }
                }
            }
            this.table = newEntryArray;
            this.count = i10;
        }

        public void expireEntries(long j10) {
            com.google.common.cache.h<K, V> peek;
            com.google.common.cache.h<K, V> peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.s(peek, j10)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.s(peek2, j10)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(K k10, int i10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            com.google.common.cache.h<K, V> entry;
            com.google.common.base.o.r(k10);
            com.google.common.base.o.r(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(k10, i10)) != null) {
                        long a10 = this.map.f26044q.a();
                        V liveValue = getLiveValue(entry, a10);
                        if (liveValue != null) {
                            recordRead(entry, a10);
                            this.statsCounter.a(1);
                            return scheduleRefresh(entry, k10, i10, liveValue, a10, cacheLoader);
                        }
                        s<K, V> valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            return waitForLoadingValue(entry, k10, valueReference);
                        }
                    }
                    return lockedGetOrLoad(k10, i10, cacheLoader);
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (!(cause instanceof Error)) {
                        if (cause instanceof RuntimeException) {
                            throw new UncheckedExecutionException(cause);
                        }
                        throw e2;
                    }
                    throw new ExecutionError((Error) cause);
                }
            } finally {
                postReadCleanup();
            }
        }

        public V getAndRecordStats(K k10, int i10, k<K, V> kVar, com.google.common.util.concurrent.n<V> nVar) throws ExecutionException {
            V v2;
            try {
                v2 = (V) com.google.common.util.concurrent.w.a(nVar);
            } catch (Throwable th) {
                th = th;
                v2 = null;
            }
            try {
                if (v2 != null) {
                    this.statsCounter.c(kVar.e());
                    storeLoadedValue(k10, i10, kVar, v2);
                    return v2;
                }
                String valueOf = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                sb2.append("CacheLoader returned null for key ");
                sb2.append(valueOf);
                sb2.append(".");
                throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
            } catch (Throwable th2) {
                th = th2;
                if (v2 == null) {
                    this.statsCounter.e(kVar.e());
                    removeLoadingValue(k10, i10, kVar);
                }
                throw th;
            }
        }

        public com.google.common.cache.h<K, V> getEntry(Object obj, int i10) {
            for (com.google.common.cache.h<K, V> first = getFirst(i10); first != null; first = first.getNext()) {
                if (first.getHash() == i10) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f26033f.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public com.google.common.cache.h<K, V> getFirst(int i10) {
            return this.table.get(i10 & (r0.length() - 1));
        }

        public com.google.common.cache.h<K, V> getLiveEntry(Object obj, int i10, long j10) {
            com.google.common.cache.h<K, V> entry = getEntry(obj, i10);
            if (entry == null) {
                return null;
            }
            if (!this.map.s(entry, j10)) {
                return entry;
            }
            tryExpireEntries(j10);
            return null;
        }

        public V getLiveValue(com.google.common.cache.h<K, V> hVar, long j10) {
            if (hVar.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v2 = hVar.getValueReference().get();
            if (v2 == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.s(hVar, j10)) {
                return v2;
            }
            tryExpireEntries(j10);
            return null;
        }

        public com.google.common.cache.h<K, V> getNextEvictable() {
            for (com.google.common.cache.h<K, V> hVar : this.accessQueue) {
                if (hVar.getValueReference().getWeight() > 0) {
                    return hVar;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.f()) {
                int i10 = this.threshold;
                if (i10 == this.maxSegmentWeight) {
                    this.threshold = i10 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        public k<K, V> insertLoadingValueReference(K k10, int i10, boolean z10) {
            lock();
            try {
                long a10 = this.map.f26044q.a();
                preWriteCleanup(a10);
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.h<K, V> hVar = (com.google.common.cache.h) atomicReferenceArray.get(length);
                for (com.google.common.cache.h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                        s<K, V> valueReference = hVar2.getValueReference();
                        if (!valueReference.isLoading() && (!z10 || a10 - hVar2.getWriteTime() >= this.map.f26041n)) {
                            this.modCount++;
                            k<K, V> kVar = new k<>(valueReference);
                            hVar2.setValueReference(kVar);
                            return kVar;
                        }
                        return null;
                    }
                }
                this.modCount++;
                k<K, V> kVar2 = new k<>();
                com.google.common.cache.h<K, V> newEntry = newEntry(k10, i10, hVar);
                newEntry.setValueReference(kVar2);
                atomicReferenceArray.set(length, newEntry);
                return kVar2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public com.google.common.util.concurrent.n<V> loadAsync(K k10, int i10, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) {
            com.google.common.util.concurrent.n<V> h10 = kVar.h(k10, cacheLoader);
            h10.addListener(new a(k10, i10, kVar, h10), com.google.common.util.concurrent.p.a());
            return h10;
        }

        public V loadSync(K k10, int i10, k<K, V> kVar, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return getAndRecordStats(k10, i10, kVar, kVar.h(k10, cacheLoader));
        }

        public V lockedGetOrLoad(K k10, int i10, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            k<K, V> kVar;
            s<K, V> sVar;
            boolean z10;
            V loadSync;
            lock();
            try {
                long a10 = this.map.f26044q.a();
                preWriteCleanup(a10);
                int i11 = this.count - 1;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    kVar = null;
                    if (hVar2 == null) {
                        sVar = null;
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                        s<K, V> valueReference = hVar2.getValueReference();
                        if (valueReference.isLoading()) {
                            z10 = false;
                            sVar = valueReference;
                        } else {
                            V v2 = valueReference.get();
                            if (v2 == null) {
                                enqueueNotification(key, i10, v2, valueReference.getWeight(), RemovalCause.COLLECTED);
                            } else if (this.map.s(hVar2, a10)) {
                                enqueueNotification(key, i10, v2, valueReference.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(hVar2, a10);
                                this.statsCounter.a(1);
                                return v2;
                            }
                            this.writeQueue.remove(hVar2);
                            this.accessQueue.remove(hVar2);
                            this.count = i11;
                            sVar = valueReference;
                        }
                    } else {
                        hVar2 = hVar2.getNext();
                    }
                }
                z10 = true;
                if (z10) {
                    kVar = new k<>();
                    if (hVar2 == null) {
                        hVar2 = newEntry(k10, i10, hVar);
                        hVar2.setValueReference(kVar);
                        atomicReferenceArray.set(length, hVar2);
                    } else {
                        hVar2.setValueReference(kVar);
                    }
                }
                if (z10) {
                    try {
                        synchronized (hVar2) {
                            loadSync = loadSync(k10, i10, kVar, cacheLoader);
                        }
                        return loadSync;
                    } finally {
                        this.statsCounter.d(1);
                    }
                }
                return waitForLoadingValue(hVar2, k10, sVar);
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public com.google.common.cache.h<K, V> newEntry(K k10, int i10, com.google.common.cache.h<K, V> hVar) {
            return this.map.f26045r.newEntry(this, com.google.common.base.o.r(k10), i10, hVar);
        }

        public AtomicReferenceArray<com.google.common.cache.h<K, V>> newEntryArray(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public void preWriteCleanup(long j10) {
            runLockedCleanup(j10);
        }

        public V put(K k10, int i10, V v2, boolean z10) {
            int i11;
            lock();
            try {
                long a10 = this.map.f26044q.a();
                preWriteCleanup(a10);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v10 = valueReference.get();
                            if (v10 != null) {
                                if (z10) {
                                    recordLockedRead(hVar2, a10);
                                } else {
                                    this.modCount++;
                                    enqueueNotification(k10, i10, v10, valueReference.getWeight(), RemovalCause.REPLACED);
                                    setValue(hVar2, k10, v2, a10);
                                    evictEntries(hVar2);
                                }
                                return v10;
                            }
                            this.modCount++;
                            if (valueReference.isActive()) {
                                enqueueNotification(k10, i10, v10, valueReference.getWeight(), RemovalCause.COLLECTED);
                                setValue(hVar2, k10, v2, a10);
                                i11 = this.count;
                            } else {
                                setValue(hVar2, k10, v2, a10);
                                i11 = this.count + 1;
                            }
                            this.count = i11;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        com.google.common.cache.h<K, V> newEntry = newEntry(k10, i10, hVar);
                        setValue(newEntry, k10, v2, a10);
                        atomicReferenceArray.set(length, newEntry);
                        this.count++;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimKey(com.google.common.cache.h<K, V> hVar, int i10) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.h<K, V> hVar2 = atomicReferenceArray.get(length);
                for (com.google.common.cache.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                    if (hVar3 == hVar) {
                        this.modCount++;
                        com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i10, hVar3.getValueReference().get(), hVar3.getValueReference(), RemovalCause.COLLECTED);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeValueFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k10, int i10, s<K, V> sVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                for (com.google.common.cache.h<K, V> hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                        if (hVar2.getValueReference() == sVar) {
                            this.modCount++;
                            com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar, hVar2, key, i10, sVar.get(), sVar, RemovalCause.COLLECTED);
                            int i11 = this.count - 1;
                            atomicReferenceArray.set(length, removeValueFromChain);
                            this.count = i11;
                            return true;
                        }
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        public void recordLockedRead(com.google.common.cache.h<K, V> hVar, long j10) {
            if (this.map.C()) {
                hVar.setAccessTime(j10);
            }
            this.accessQueue.add(hVar);
        }

        public void recordRead(com.google.common.cache.h<K, V> hVar, long j10) {
            if (this.map.C()) {
                hVar.setAccessTime(j10);
            }
            this.recencyQueue.add(hVar);
        }

        public void recordWrite(com.google.common.cache.h<K, V> hVar, int i10, long j10) {
            drainRecencyQueue();
            this.totalWeight += i10;
            if (this.map.C()) {
                hVar.setAccessTime(j10);
            }
            if (this.map.E()) {
                hVar.setWriteTime(j10);
            }
            this.accessQueue.add(hVar);
            this.writeQueue.add(hVar);
        }

        public V refresh(K k10, int i10, CacheLoader<? super K, V> cacheLoader, boolean z10) {
            k<K, V> insertLoadingValueReference = insertLoadingValueReference(k10, i10, z10);
            if (insertLoadingValueReference == null) {
                return null;
            }
            com.google.common.util.concurrent.n<V> loadAsync = loadAsync(k10, i10, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return (V) com.google.common.util.concurrent.w.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r12 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            r2 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r11.modCount++;
            r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.count - 1;
            r0.set(r1, r13);
            r11.count = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
        
            return r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        
            if (r9.isActive() == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        
            r2 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public V remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.v r0 = r0.f26044q     // Catch: java.lang.Throwable -> L78
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L78
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L78
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.h<K, V>> r0 = r11.table     // Catch: java.lang.Throwable -> L78
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L78
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L78
                r4 = r2
                com.google.common.cache.h r4 = (com.google.common.cache.h) r4     // Catch: java.lang.Throwable -> L78
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6c
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L78
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L78
                if (r3 != r13) goto L73
                if (r6 == 0) goto L73
                com.google.common.cache.LocalCache<K, V> r3 = r11.map     // Catch: java.lang.Throwable -> L78
                com.google.common.base.Equivalence<java.lang.Object> r3 = r3.f26033f     // Catch: java.lang.Throwable -> L78
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L73
                com.google.common.cache.LocalCache$s r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L78
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L78
                if (r12 == 0) goto L46
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L78
            L44:
                r10 = r2
                goto L4f
            L46:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L78
                if (r3 == 0) goto L6c
                com.google.common.cache.RemovalCause r2 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L78
                goto L44
            L4f:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L78
                r3 = r11
                r7 = r13
                r8 = r12
                com.google.common.cache.h r13 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L78
                int r2 = r11.count     // Catch: java.lang.Throwable -> L78
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L78
                r11.count = r2     // Catch: java.lang.Throwable -> L78
                r11.unlock()
                r11.postWriteCleanup()
                return r12
            L6c:
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L73:
                com.google.common.cache.h r5 = r5.getNext()     // Catch: java.lang.Throwable -> L78
                goto L1f
            L78:
                r12 = move-exception
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        public void removeCollectedEntry(com.google.common.cache.h<K, V> hVar) {
            enqueueNotification(hVar.getKey(), hVar.getHash(), hVar.getValueReference().get(), hVar.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(hVar);
            this.accessQueue.remove(hVar);
        }

        public boolean removeEntry(com.google.common.cache.h<K, V> hVar, int i10, RemovalCause removalCause) {
            AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i10;
            com.google.common.cache.h<K, V> hVar2 = atomicReferenceArray.get(length);
            for (com.google.common.cache.h<K, V> hVar3 = hVar2; hVar3 != null; hVar3 = hVar3.getNext()) {
                if (hVar3 == hVar) {
                    this.modCount++;
                    com.google.common.cache.h<K, V> removeValueFromChain = removeValueFromChain(hVar2, hVar3, hVar3.getKey(), i10, hVar3.getValueReference().get(), hVar3.getValueReference(), removalCause);
                    int i11 = this.count - 1;
                    atomicReferenceArray.set(length, removeValueFromChain);
                    this.count = i11;
                    return true;
                }
            }
            return false;
        }

        public com.google.common.cache.h<K, V> removeEntryFromChain(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2) {
            int i10 = this.count;
            com.google.common.cache.h<K, V> next = hVar2.getNext();
            while (hVar != hVar2) {
                com.google.common.cache.h<K, V> copyEntry = copyEntry(hVar, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(hVar);
                    i10--;
                }
                hVar = hVar.getNext();
            }
            this.count = i10;
            return next;
        }

        public boolean removeLoadingValue(K k10, int i10, k<K, V> kVar) {
            lock();
            try {
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 == null) {
                        break;
                    }
                    K key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                        if (hVar2.getValueReference() == kVar) {
                            if (kVar.isActive()) {
                                hVar2.setValueReference(kVar.g());
                            } else {
                                atomicReferenceArray.set(length, removeEntryFromChain(hVar, hVar2));
                            }
                            return true;
                        }
                    } else {
                        hVar2 = hVar2.getNext();
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public com.google.common.cache.h<K, V> removeValueFromChain(com.google.common.cache.h<K, V> hVar, com.google.common.cache.h<K, V> hVar2, K k10, int i10, V v2, s<K, V> sVar, RemovalCause removalCause) {
            enqueueNotification(k10, i10, v2, sVar.getWeight(), removalCause);
            this.writeQueue.remove(hVar2);
            this.accessQueue.remove(hVar2);
            if (sVar.isLoading()) {
                sVar.b(null);
                return hVar;
            }
            return removeEntryFromChain(hVar, hVar2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean replace(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.v r1 = r1.f26044q     // Catch: java.lang.Throwable -> Lb5
                long r7 = r1.a()     // Catch: java.lang.Throwable -> Lb5
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> Lb5
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.h<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> Lb5
                int r1 = r10.length()     // Catch: java.lang.Throwable -> Lb5
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch: java.lang.Throwable -> Lb5
                r2 = r1
                com.google.common.cache.h r2 = (com.google.common.cache.h) r2     // Catch: java.lang.Throwable -> Lb5
                r13 = r2
            L24:
                r14 = 0
                if (r13 == 0) goto L69
                java.lang.Object r4 = r13.getKey()     // Catch: java.lang.Throwable -> Lb5
                int r1 = r13.getHash()     // Catch: java.lang.Throwable -> Lb5
                if (r1 != r0) goto Lab
                if (r4 == 0) goto Lab
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26033f     // Catch: java.lang.Throwable -> Lb5
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto Lad
                com.google.common.cache.LocalCache$s r16 = r13.getValueReference()     // Catch: java.lang.Throwable -> Lb5
                java.lang.Object r6 = r16.get()     // Catch: java.lang.Throwable -> Lb5
                if (r6 != 0) goto L70
                boolean r1 = r16.isActive()     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto L69
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.h r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lb5
                int r1 = r9.count     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch: java.lang.Throwable -> Lb5
                r9.count = r1     // Catch: java.lang.Throwable -> Lb5
            L69:
                r17.unlock()
                r17.postWriteCleanup()
                return r14
            L70:
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> Lb5
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26034g     // Catch: java.lang.Throwable -> Lb5
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> Lb5
                if (r1 == 0) goto La7
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> Lb5
                int r1 = r1 + r11
                r9.modCount = r1     // Catch: java.lang.Throwable -> Lb5
                int r5 = r16.getWeight()     // Catch: java.lang.Throwable -> Lb5
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Lb5
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb5
                r9.evictEntries(r13)     // Catch: java.lang.Throwable -> Lb5
                r17.unlock()
                r17.postWriteCleanup()
                return r11
            La7:
                r9.recordLockedRead(r13, r7)     // Catch: java.lang.Throwable -> Lb5
                goto L69
            Lab:
                r15 = r18
            Lad:
                r3 = r20
                com.google.common.cache.h r13 = r13.getNext()     // Catch: java.lang.Throwable -> Lb5
                goto L24
            Lb5:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        public void runLockedCleanup(long j10) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j10);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.z();
        }

        public V scheduleRefresh(com.google.common.cache.h<K, V> hVar, K k10, int i10, V v2, long j10, CacheLoader<? super K, V> cacheLoader) {
            V refresh;
            return (!this.map.G() || j10 - hVar.getWriteTime() <= this.map.f26041n || hVar.getValueReference().isLoading() || (refresh = refresh(k10, i10, cacheLoader, true)) == null) ? v2 : refresh;
        }

        public void setValue(com.google.common.cache.h<K, V> hVar, K k10, V v2, long j10) {
            s<K, V> valueReference = hVar.getValueReference();
            int weigh = this.map.f26038k.weigh(k10, v2);
            com.google.common.base.o.y(weigh >= 0, "Weights must be non-negative");
            hVar.setValueReference(this.map.f26036i.referenceValue(this, hVar, v2, weigh));
            recordWrite(hVar, weigh, j10);
            valueReference.b(v2);
        }

        public boolean storeLoadedValue(K k10, int i10, k<K, V> kVar, V v2) {
            lock();
            try {
                long a10 = this.map.f26044q.a();
                preWriteCleanup(a10);
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    expand();
                    i11 = this.count + 1;
                }
                int i12 = i11;
                AtomicReferenceArray<com.google.common.cache.h<K, V>> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                com.google.common.cache.h<K, V> hVar = atomicReferenceArray.get(length);
                com.google.common.cache.h<K, V> hVar2 = hVar;
                while (true) {
                    if (hVar2 != null) {
                        K key = hVar2.getKey();
                        if (hVar2.getHash() == i10 && key != null && this.map.f26033f.equivalent(k10, key)) {
                            s<K, V> valueReference = hVar2.getValueReference();
                            V v10 = valueReference.get();
                            if (kVar != valueReference && (v10 != null || valueReference == LocalCache.f26027y)) {
                                enqueueNotification(k10, i10, v2, 0, RemovalCause.REPLACED);
                                return false;
                            }
                            this.modCount++;
                            if (kVar.isActive()) {
                                enqueueNotification(k10, i10, v10, kVar.getWeight(), v10 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                                i12--;
                            }
                            setValue(hVar2, k10, v2, a10);
                            this.count = i12;
                            evictEntries(hVar2);
                        } else {
                            hVar2 = hVar2.getNext();
                        }
                    } else {
                        this.modCount++;
                        com.google.common.cache.h<K, V> newEntry = newEntry(k10, i10, hVar);
                        setValue(newEntry, k10, v2, a10);
                        atomicReferenceArray.set(length, newEntry);
                        this.count = i12;
                        evictEntries(newEntry);
                        break;
                    }
                }
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j10) {
            if (tryLock()) {
                try {
                    expireEntries(j10);
                } finally {
                    unlock();
                }
            }
        }

        public V waitForLoadingValue(com.google.common.cache.h<K, V> hVar, K k10, s<K, V> sVar) throws ExecutionException {
            if (sVar.isLoading()) {
                com.google.common.base.o.B(!Thread.holdsLock(hVar), "Recursive load of: %s", k10);
                try {
                    V c4 = sVar.c();
                    if (c4 != null) {
                        recordRead(hVar, this.map.f26044q.a());
                        return c4;
                    }
                    String valueOf = String.valueOf(k10);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
                    sb2.append("CacheLoader returned null for key ");
                    sb2.append(valueOf);
                    sb2.append(".");
                    throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
                } finally {
                    this.statsCounter.d(1);
                }
            }
            throw new AssertionError();
        }

        public V get(Object obj, int i10) {
            try {
                if (this.count != 0) {
                    long a10 = this.map.f26044q.a();
                    com.google.common.cache.h<K, V> liveEntry = getLiveEntry(obj, i10, a10);
                    if (liveEntry == null) {
                        return null;
                    }
                    V v2 = liveEntry.getValueReference().get();
                    if (v2 != null) {
                        recordRead(liveEntry, a10);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i10, v2, a10, this.map.f26047t);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        
            r10 = r6.getValueReference();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        
            if (r12.map.f26034g.equivalent(r15, r9) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        
            r12.modCount++;
            r14 = removeValueFromChain(r5, r6, r7, r14, r9, r10, r13);
            r15 = r12.count - 1;
            r0.set(r1, r14);
            r12.count = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006d, code lost:
        
            if (r13 != com.google.common.cache.RemovalCause.EXPLICIT) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
        
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        
            if (r9 != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        
            if (r10.isActive() == false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache<K, V> r0 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.v r0 = r0.f26044q     // Catch: java.lang.Throwable -> L84
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L84
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L84
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.h<K, V>> r0 = r12.table     // Catch: java.lang.Throwable -> L84
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L84
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L84
                r5 = r3
                com.google.common.cache.h r5 = (com.google.common.cache.h) r5     // Catch: java.lang.Throwable -> L84
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L78
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L84
                int r4 = r6.getHash()     // Catch: java.lang.Throwable -> L84
                if (r4 != r14) goto L7f
                if (r7 == 0) goto L7f
                com.google.common.cache.LocalCache<K, V> r4 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.f26033f     // Catch: java.lang.Throwable -> L84
                boolean r4 = r4.equivalent(r13, r7)     // Catch: java.lang.Throwable -> L84
                if (r4 == 0) goto L7f
                com.google.common.cache.LocalCache$s r10 = r6.getValueReference()     // Catch: java.lang.Throwable -> L84
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.LocalCache<K, V> r13 = r12.map     // Catch: java.lang.Throwable -> L84
                com.google.common.base.Equivalence<java.lang.Object> r13 = r13.f26034g     // Catch: java.lang.Throwable -> L84
                boolean r13 = r13.equivalent(r15, r9)     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L4d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                goto L57
            L4d:
                if (r9 != 0) goto L78
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L84
                if (r13 == 0) goto L78
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L84
            L57:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L84
                int r15 = r15 + r2
                r12.modCount = r15     // Catch: java.lang.Throwable -> L84
                r4 = r12
                r8 = r14
                r11 = r13
                com.google.common.cache.h r14 = r4.removeValueFromChain(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L84
                int r15 = r12.count     // Catch: java.lang.Throwable -> L84
                int r15 = r15 - r2
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L84
                r12.count = r15     // Catch: java.lang.Throwable -> L84
                com.google.common.cache.RemovalCause r14 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L84
                if (r13 != r14) goto L70
                goto L71
            L70:
                r2 = 0
            L71:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L78:
                r12.unlock()
                r12.postWriteCleanup()
                return r3
            L7f:
                com.google.common.cache.h r6 = r6.getNext()     // Catch: java.lang.Throwable -> L84
                goto L1f
            L84:
                r13 = move-exception
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public V replace(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.v r1 = r1.f26044q     // Catch: java.lang.Throwable -> La7
                long r7 = r1.a()     // Catch: java.lang.Throwable -> La7
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> La7
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.h<K, V>> r10 = r9.table     // Catch: java.lang.Throwable -> La7
                int r1 = r10.length()     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> La7
                r2 = r1
                com.google.common.cache.h r2 = (com.google.common.cache.h) r2     // Catch: java.lang.Throwable -> La7
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6c
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> La7
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> La7
                if (r1 != r0) goto L9f
                if (r4 == 0) goto L9f
                com.google.common.cache.LocalCache<K, V> r1 = r9.map     // Catch: java.lang.Throwable -> La7
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.f26033f     // Catch: java.lang.Throwable -> La7
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto La1
                com.google.common.cache.LocalCache$s r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> La7
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> La7
                if (r16 != 0) goto L73
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> La7
                if (r1 == 0) goto L6c
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.h r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La7
                int r1 = r9.count     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> La7
                r9.count = r1     // Catch: java.lang.Throwable -> La7
            L6c:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L73:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> La7
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> La7
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> La7
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La7
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La7
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> La7
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            L9f:
                r14 = r18
            La1:
                com.google.common.cache.h r12 = r12.getNext()     // Catch: java.lang.Throwable -> La7
                goto L24
            La7:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }
}
