package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.collect.MapMakerInternalMap.h;
import com.google.common.primitives.Ints;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MapMakerInternalMap<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    public static final int CONTAINS_VALUE_RETRIES = 3;
    public static final int DRAIN_MAX = 16;
    public static final int DRAIN_THRESHOLD = 63;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int MAX_SEGMENTS = 65536;
    public static final v<Object, Object, d> UNSET_WEAK_VALUE_REFERENCE = new a();
    private static final long serialVersionUID = 5;
    public final int concurrencyLevel;
    public final transient i<K, V, E, S> entryHelper;
    public transient Set<Map.Entry<K, V>> entrySet;
    public final Equivalence<Object> keyEquivalence;
    public transient Set<K> keySet;
    public final transient int segmentMask;
    public final transient int segmentShift;
    public final transient Segment<K, V, E, S>[] segments;
    public transient Collection<V> values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        public SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i10, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = readMapMaker(objectInputStream).i();
            readEntries(objectInputStream);
        }

        private Object readResolve() {
            return this.delegate;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            writeMapTo(objectOutputStream);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        /* synthetic */ Strength(a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {
        public StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public m<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (m) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {
        public StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public n<K, V> castForTesting(h<K, V, ?> hVar) {
            return (n) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, o<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v2) {
            return new w(this.queueForValues, v2, castForTesting((h) hVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public StrongKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            o<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = castForTesting.f26405e;
            castForTesting.f26405e = vVar;
            vVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public o<K, V> castForTesting(h<K, V, ?> hVar) {
            return (o) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyDummyValueSegment<K> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public r<K> castForTesting(h<K, MapMaker.Dummy, ?> hVar) {
            return (r) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyStrongValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public s<K, V> castForTesting(h<K, V, ?> hVar) {
            return (s) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
            super(mapMakerInternalMap, i10, i11);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            return this.queueForKeys;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            return this.queueForValues;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            return castForTesting((h) hVar).getValueReference();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeClearReferenceQueues() {
            clearReferenceQueue(this.queueForKeys);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void maybeDrainReferenceQueues() {
            drainKeyReferenceQueue(this.queueForKeys);
            drainValueReferenceQueue(this.queueForValues);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public v<K, V, t<K, V>> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v2) {
            return new w(this.queueForValues, v2, castForTesting((h) hVar));
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public WeakKeyWeakValueSegment<K, V> self() {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            t<K, V> castForTesting = castForTesting((h) hVar);
            v vVar2 = castForTesting.f26411d;
            castForTesting.f26411d = vVar;
            vVar2.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        public t<K, V> castForTesting(h<K, V, ?> hVar) {
            return (t) hVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements v<Object, Object, d> {
        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public v<Object, Object, d> b(ReferenceQueue<Object> referenceQueue, d dVar) {
            return this;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public Object get() {
            return null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<K, V, E extends h<K, V, E>> implements h<K, V, E> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26387b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26388c;

        /* renamed from: d, reason: collision with root package name */
        public final E f26389d;

        public b(K k10, int i10, E e2) {
            this.f26387b = k10;
            this.f26388c = i10;
            this.f26389d = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f26388c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return this.f26387b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f26389d;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class c<K, V, E extends h<K, V, E>> extends WeakReference<K> implements h<K, V, E> {

        /* renamed from: b, reason: collision with root package name */
        public final int f26390b;

        /* renamed from: c, reason: collision with root package name */
        public final E f26391c;

        public c(ReferenceQueue<K> referenceQueue, K k10, int i10, E e2) {
            super(k10, referenceQueue);
            this.f26390b = i10;
            this.f26391c = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            return this.f26390b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public K getKey() {
            return get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public E getNext() {
            return this.f26391c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d implements h<Object, Object, d> {
        public d() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d getNext() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public int getHash() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class e extends MapMakerInternalMap<K, V, E, S>.g<Map.Entry<K, V>> {
        public e(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class f extends l<Map.Entry<K, V>> {
        public f() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.valueEquivalence().equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new e(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class g<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f26393b;

        /* renamed from: c, reason: collision with root package name */
        public int f26394c = -1;

        /* renamed from: d, reason: collision with root package name */
        public Segment<K, V, E, S> f26395d;

        /* renamed from: e, reason: collision with root package name */
        public AtomicReferenceArray<E> f26396e;

        /* renamed from: f, reason: collision with root package name */
        public E f26397f;

        /* renamed from: g, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f26398g;

        /* renamed from: h, reason: collision with root package name */
        public MapMakerInternalMap<K, V, E, S>.x f26399h;

        public g() {
            this.f26393b = MapMakerInternalMap.this.segments.length - 1;
            a();
        }

        public final void a() {
            this.f26398g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i10 = this.f26393b;
                if (i10 < 0) {
                    return;
                }
                Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.segments;
                this.f26393b = i10 - 1;
                Segment<K, V, E, S> segment = segmentArr[i10];
                this.f26395d = segment;
                if (segment.count != 0) {
                    this.f26396e = this.f26395d.table;
                    this.f26394c = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e2) {
            boolean z10;
            try {
                Object key = e2.getKey();
                Object liveValue = MapMakerInternalMap.this.getLiveValue(e2);
                if (liveValue != null) {
                    this.f26398g = new x(key, liveValue);
                    z10 = true;
                } else {
                    z10 = false;
                }
                return z10;
            } finally {
                this.f26395d.postReadCleanup();
            }
        }

        public MapMakerInternalMap<K, V, E, S>.x c() {
            MapMakerInternalMap<K, V, E, S>.x xVar = this.f26398g;
            if (xVar != null) {
                this.f26399h = xVar;
                a();
                return this.f26399h;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            E e2 = this.f26397f;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.f26397f = (E) e2.getNext();
                E e10 = this.f26397f;
                if (e10 == null) {
                    return false;
                }
                if (b(e10)) {
                    return true;
                }
                e2 = this.f26397f;
            }
        }

        public boolean e() {
            while (true) {
                int i10 = this.f26394c;
                if (i10 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.f26396e;
                this.f26394c = i10 - 1;
                E e2 = atomicReferenceArray.get(i10);
                this.f26397f = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26398g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.m.e(this.f26399h != null);
            MapMakerInternalMap.this.remove(this.f26399h.getKey());
            this.f26399h = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface h<K, V, E extends h<K, V, E>> {
        int getHash();

        K getKey();

        E getNext();

        V getValue();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface i<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> {
        void a(S s2, E e2, V v2);

        Strength b();

        E c(S s2, E e2, E e10);

        Strength d();

        E e(S s2, K k10, int i10, E e2);

        S f(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class j extends MapMakerInternalMap<K, V, E, S>.g<K> {
        public j(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class k extends l<K> {
        public k() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new j(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class l<E> extends AbstractSet<E> {
        public l() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        public /* synthetic */ l(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class m<K> extends b<K, MapMaker.Dummy, m<K>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?> f26402a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f26402a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public m<K> c(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, m<K> mVar2) {
                return mVar.a(mVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public m<K> e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k10, int i10, m<K> mVar) {
                return new m<>(k10, i10, mVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, m<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, m<K> mVar, MapMaker.Dummy dummy) {
            }
        }

        public m(K k10, int i10, m<K> mVar) {
            super(k10, i10, mVar);
        }

        public m<K> a(m<K> mVar) {
            return new m<>(this.f26387b, this.f26388c, mVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class n<K, V> extends b<K, V, n<K, V>> {

        /* renamed from: e, reason: collision with root package name */
        public volatile V f26403e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K, V> implements i<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f26404a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f26404a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public n<K, V> c(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, n<K, V> nVar2) {
                return nVar.a(nVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public n<K, V> e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k10, int i10, n<K, V> nVar) {
                return new n<>(k10, i10, nVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, n<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, n<K, V> nVar, V v2) {
                nVar.b(v2);
            }
        }

        public n(K k10, int i10, n<K, V> nVar) {
            super(k10, i10, nVar);
            this.f26403e = null;
        }

        public n<K, V> a(n<K, V> nVar) {
            n<K, V> nVar2 = new n<>(this.f26387b, this.f26388c, nVar);
            nVar2.f26403e = this.f26403e;
            return nVar2;
        }

        public void b(V v2) {
            this.f26403e = v2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f26403e;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class o<K, V> extends b<K, V, o<K, V>> implements u<K, V, o<K, V>> {

        /* renamed from: e, reason: collision with root package name */
        public volatile v<K, V, o<K, V>> f26405e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K, V> implements i<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f26406a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f26406a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public o<K, V> c(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, o<K, V> oVar2) {
                if (Segment.isCollected(oVar)) {
                    return null;
                }
                return oVar.c(((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues, oVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public o<K, V> e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k10, int i10, o<K, V> oVar) {
                return new o<>(k10, i10, oVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, o<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, o<K, V> oVar, V v2) {
                oVar.d(v2, ((StrongKeyWeakValueSegment) strongKeyWeakValueSegment).queueForValues);
            }
        }

        public o(K k10, int i10, o<K, V> oVar) {
            super(k10, i10, oVar);
            this.f26405e = MapMakerInternalMap.unsetWeakValueReference();
        }

        public o<K, V> c(ReferenceQueue<V> referenceQueue, o<K, V> oVar) {
            o<K, V> oVar2 = new o<>(this.f26387b, this.f26388c, oVar);
            oVar2.f26405e = this.f26405e.b(referenceQueue, oVar2);
            return oVar2;
        }

        public void d(V v2, ReferenceQueue<V> referenceQueue) {
            v<K, V, o<K, V>> vVar = this.f26405e;
            this.f26405e = new w(referenceQueue, v2, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f26405e.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, o<K, V>> getValueReference() {
            return this.f26405e;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class p extends MapMakerInternalMap<K, V, E, S>.g<V> {
        public p(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().getValue();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class q extends AbstractCollection<V> {
        public q() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new p(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.toArrayList(this).toArray(tArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class r<K> extends c<K, MapMaker.Dummy, r<K>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K> implements i<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?> f26408a = new a<>();

            public static <K> a<K> h() {
                return (a<K>) f26408a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public r<K> c(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, r<K> rVar2) {
                if (rVar.getKey() == null) {
                    return null;
                }
                return rVar.a(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, rVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public r<K> e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k10, int i10, r<K> rVar) {
                return new r<>(((WeakKeyDummyValueSegment) weakKeyDummyValueSegment).queueForKeys, k10, i10, rVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment<K> f(MapMakerInternalMap<K, MapMaker.Dummy, r<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, r<K> rVar, MapMaker.Dummy dummy) {
            }
        }

        public r(ReferenceQueue<K> referenceQueue, K k10, int i10, r<K> rVar) {
            super(referenceQueue, k10, i10, rVar);
        }

        public r<K> a(ReferenceQueue<K> referenceQueue, r<K> rVar) {
            return new r<>(referenceQueue, getKey(), this.f26390b, rVar);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class s<K, V> extends c<K, V, s<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public volatile V f26409d;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K, V> implements i<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f26410a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f26410a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public s<K, V> c(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, s<K, V> sVar2) {
                if (sVar.getKey() == null) {
                    return null;
                }
                return sVar.a(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, sVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public s<K, V> e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k10, int i10, s<K, V> sVar) {
                return new s<>(((WeakKeyStrongValueSegment) weakKeyStrongValueSegment).queueForKeys, k10, i10, sVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment<K, V> f(MapMakerInternalMap<K, V, s<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, s<K, V> sVar, V v2) {
                sVar.b(v2);
            }
        }

        public s(ReferenceQueue<K> referenceQueue, K k10, int i10, s<K, V> sVar) {
            super(referenceQueue, k10, i10, sVar);
            this.f26409d = null;
        }

        public s<K, V> a(ReferenceQueue<K> referenceQueue, s<K, V> sVar) {
            s<K, V> sVar2 = new s<>(referenceQueue, getKey(), this.f26390b, sVar);
            sVar2.b(this.f26409d);
            return sVar2;
        }

        public void b(V v2) {
            this.f26409d = v2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f26409d;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class t<K, V> extends c<K, V, t<K, V>> implements u<K, V, t<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public volatile v<K, V, t<K, V>> f26411d;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class a<K, V> implements i<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public static final a<?, ?> f26412a = new a<>();

            public static <K, V> a<K, V> h() {
                return (a<K, V>) f26412a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength b() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            public Strength d() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public t<K, V> c(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, t<K, V> tVar2) {
                if (tVar.getKey() == null || Segment.isCollected(tVar)) {
                    return null;
                }
                return tVar.c(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues, tVar2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public t<K, V> e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k10, int i10, t<K, V> tVar) {
                return new t<>(((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForKeys, k10, i10, tVar);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment<K, V> f(MapMakerInternalMap<K, V, t<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i10, int i11) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i10, i11);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.i
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public void a(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, t<K, V> tVar, V v2) {
                tVar.d(v2, ((WeakKeyWeakValueSegment) weakKeyWeakValueSegment).queueForValues);
            }
        }

        public t(ReferenceQueue<K> referenceQueue, K k10, int i10, t<K, V> tVar) {
            super(referenceQueue, k10, i10, tVar);
            this.f26411d = MapMakerInternalMap.unsetWeakValueReference();
        }

        public t<K, V> c(ReferenceQueue<K> referenceQueue, ReferenceQueue<V> referenceQueue2, t<K, V> tVar) {
            t<K, V> tVar2 = new t<>(referenceQueue, getKey(), this.f26390b, tVar);
            tVar2.f26411d = this.f26411d.b(referenceQueue2, tVar2);
            return tVar2;
        }

        public void d(V v2, ReferenceQueue<V> referenceQueue) {
            v<K, V, t<K, V>> vVar = this.f26411d;
            this.f26411d = new w(referenceQueue, v2, this);
            vVar.clear();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.h
        public V getValue() {
            return this.f26411d.get();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.u
        public v<K, V, t<K, V>> getValueReference() {
            return this.f26411d;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface u<K, V, E extends h<K, V, E>> extends h<K, V, E> {
        v<K, V, E> getValueReference();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface v<K, V, E extends h<K, V, E>> {
        E a();

        v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        V get();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class w<K, V, E extends h<K, V, E>> extends WeakReference<V> implements v<K, V, E> {

        /* renamed from: b, reason: collision with root package name */
        public final E f26413b;

        public w(ReferenceQueue<V> referenceQueue, V v2, E e2) {
            super(v2, referenceQueue);
            this.f26413b = e2;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public E a() {
            return this.f26413b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.v
        public v<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            return new w(referenceQueue, get(), e2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class x extends com.google.common.collect.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26414b;

        /* renamed from: c, reason: collision with root package name */
        public V f26415c;

        public x(K k10, V v2) {
            this.f26414b = k10;
            this.f26415c = v2;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f26414b.equals(entry.getKey()) && this.f26415c.equals(entry.getValue());
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f26414b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f26415c;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public int hashCode() {
            return this.f26414b.hashCode() ^ this.f26415c.hashCode();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = (V) MapMakerInternalMap.this.put(this.f26414b, v2);
            this.f26415c = v2;
            return v10;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, i<K, V, E, S> iVar) {
        this.concurrencyLevel = Math.min(mapMaker.b(), 65536);
        this.keyEquivalence = mapMaker.d();
        this.entryHelper = iVar;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i10 = 0;
        int i11 = 1;
        int i12 = 1;
        int i13 = 0;
        while (i12 < this.concurrencyLevel) {
            i13++;
            i12 <<= 1;
        }
        this.segmentShift = 32 - i13;
        this.segmentMask = i12 - 1;
        this.segments = newSegmentArray(i12);
        int i14 = min / i12;
        while (i11 < (i12 * i14 < min ? i14 + 1 : i14)) {
            i11 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.segments;
            if (i10 >= segmentArr.length) {
                return;
            }
            segmentArr[i10] = createSegment(i11, -1);
            i10++;
        }
    }

    public static <K, V> MapMakerInternalMap<K, V, ? extends h<K, V, ?>, ?> create(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, n.a.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, o.a.h());
        }
        Strength e10 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e10 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, s.a.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, t.a.h());
        }
        throw new AssertionError();
    }

    public static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends h<K, MapMaker.Dummy, ?>, ?> createWithDummyValues(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, m.a.h());
        }
        Strength e10 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e10 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, r.a.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    public static int rehash(int i10) {
        int i11 = i10 + ((i10 << 15) ^ (-12931));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (i14 << 2) + (i14 << 14);
        return i15 ^ (i15 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ArrayList<E> toArrayList(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator2());
        return arrayList;
    }

    public static <K, V, E extends h<K, V, E>> v<K, V, E> unsetWeakValueReference() {
        return (v<K, V, E>) UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V, E, S> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).containsKey(obj, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.segments;
        long j10 = -1;
        int i10 = 0;
        while (i10 < 3) {
            long j11 = 0;
            for (StrongKeyDummyValueSegment strongKeyDummyValueSegment : segmentArr) {
                int i11 = strongKeyDummyValueSegment.count;
                AtomicReferenceArray<E> atomicReferenceArray = strongKeyDummyValueSegment.table;
                for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                    for (E e2 = atomicReferenceArray.get(i12); e2 != null; e2 = e2.getNext()) {
                        Object liveValue = strongKeyDummyValueSegment.getLiveValue(e2);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j11 += strongKeyDummyValueSegment.modCount;
            }
            if (j11 == j10) {
                return false;
            }
            i10++;
            j10 = j11;
        }
        return false;
    }

    public E copyEntry(E e2, E e10) {
        return segmentFor(e2.getHash()).copyEntry(e2, e10);
    }

    public Segment<K, V, E, S> createSegment(int i10, int i11) {
        return this.entryHelper.f(this, i10, i11);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.entrySet = fVar;
        return fVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).get(obj, hash);
    }

    public E getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).getEntry(obj, hash);
    }

    public V getLiveValue(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return (V) e2.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.segments;
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

    public boolean isLiveForTesting(h<K, V, ?> hVar) {
        return segmentFor(hVar.getHash()).getLiveValueForTesting(hVar) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.keySet = kVar;
        return kVar;
    }

    public Strength keyStrength() {
        return this.entryHelper.b();
    }

    public final Segment<K, V, E, S>[] newSegmentArray(int i10) {
        return new Segment[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v2);
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v2, false);
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
        int hash = hash(k10);
        return segmentFor(hash).put(k10, hash, v2, true);
    }

    public void reclaimKey(E e2) {
        int hash = e2.getHash();
        segmentFor(hash).reclaimKey(e2, hash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reclaimValue(v<K, V, E> vVar) {
        E a10 = vVar.a();
        int hash = a10.getHash();
        segmentFor(hash).reclaimValue(a10.getKey(), hash, vVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k10, V v2, V v10) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v10);
        if (v2 == null) {
            return false;
        }
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v2, v10);
    }

    public Segment<K, V, E, S> segmentFor(int i10) {
        return this.segments[(i10 >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = 0;
        for (int i10 = 0; i10 < this.segments.length; i10++) {
            j10 += r0[i10].count;
        }
        return Ints.l(j10);
    }

    public Equivalence<Object> valueEquivalence() {
        return this.entryHelper.d().defaultEquivalence();
    }

    public Strength valueStrength() {
        return this.entryHelper.d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        q qVar = new q();
        this.values = qVar;
        return qVar;
    }

    public Object writeReplace() {
        return new SerializationProxy(this.entryHelper.b(), this.entryHelper.d(), this.keyEquivalence, this.entryHelper.d().defaultEquivalence(), this.concurrencyLevel, this);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class AbstractSerializationProxy<K, V> extends com.google.common.collect.t<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        public final int concurrencyLevel;
        public transient ConcurrentMap<K, V> delegate;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;

        public AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i10, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i10;
            this.delegate = concurrentMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void readEntries(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject == null) {
                    return;
                }
                this.delegate.put(readObject, objectInputStream.readObject());
            }
        }

        public MapMaker readMapMaker(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.keyStrength).k(this.valueStrength).h(this.keyEquivalence).a(this.concurrencyLevel);
        }

        public void writeMapTo(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.delegate.size());
            for (Map.Entry<K, V> entry : this.delegate.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }

        @Override // com.google.common.collect.t, com.google.common.collect.v, com.google.common.collect.z
        public ConcurrentMap<K, V> delegate() {
            return this.delegate;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int hash = hash(obj);
        return segmentFor(hash).remove(obj, hash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k10, V v2) {
        com.google.common.base.o.r(k10);
        com.google.common.base.o.r(v2);
        int hash = hash(k10);
        return segmentFor(hash).replace(k10, hash, v2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class Segment<K, V, E extends h<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        public volatile int count;
        public final MapMakerInternalMap<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i10, int i11) {
            this.map = mapMakerInternalMap;
            this.maxSegmentSize = i11;
            initTable(newEntryArray(i10));
        }

        public static <K, V, E extends h<K, V, E>> boolean isCollected(E e2) {
            return e2.getValue() == null;
        }

        public abstract E castForTesting(h<K, V, ?> hVar);

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    for (int i10 = 0; i10 < atomicReferenceArray.length(); i10++) {
                        atomicReferenceArray.set(i10, null);
                    }
                    maybeClearReferenceQueues();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public <T> void clearReferenceQueue(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean clearValueForTesting(K k10, int i10, v<K, V, ? extends h<K, V, ?>> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((u) hVar2).getValueReference() != vVar) {
                            return false;
                        }
                        atomicReferenceArray.set(length, removeFromChain(hVar, hVar2));
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public boolean containsKey(Object obj, int i10) {
            try {
                boolean z10 = false;
                if (this.count == 0) {
                    return false;
                }
                E liveEntry = getLiveEntry(obj, i10);
                if (liveEntry != null) {
                    if (liveEntry.getValue() != null) {
                        z10 = true;
                    }
                }
                return z10;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean containsValue(Object obj) {
            try {
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        for (E e2 = atomicReferenceArray.get(i10); e2 != null; e2 = e2.getNext()) {
                            Object liveValue = getLiveValue(e2);
                            if (liveValue != null && this.map.valueEquivalence().equivalent(obj, liveValue)) {
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

        public E copyEntry(E e2, E e10) {
            return this.map.entryHelper.c(self(), e2, e10);
        }

        public E copyForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return this.map.entryHelper.c(self(), castForTesting(hVar), castForTesting(hVar2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainKeyReferenceQueue(ReferenceQueue<K> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimKey((h) poll);
                i10++;
            } while (i10 != 16);
        }

        public void drainValueReferenceQueue(ReferenceQueue<V> referenceQueue) {
            int i10 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll == null) {
                    return;
                }
                this.map.reclaimValue((v) poll);
                i10++;
            } while (i10 != 16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void expand() {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i10 = this.count;
            ArrayCompositeDisposable arrayCompositeDisposable = (AtomicReferenceArray<E>) newEntryArray(length << 1);
            this.threshold = (arrayCompositeDisposable.length() * 3) / 4;
            int length2 = arrayCompositeDisposable.length() - 1;
            for (int i11 = 0; i11 < length; i11++) {
                E e2 = atomicReferenceArray.get(i11);
                if (e2 != null) {
                    h next = e2.getNext();
                    int hash = e2.getHash() & length2;
                    if (next == null) {
                        arrayCompositeDisposable.set(hash, e2);
                    } else {
                        h hVar = e2;
                        while (next != null) {
                            int hash2 = next.getHash() & length2;
                            if (hash2 != hash) {
                                hVar = next;
                                hash = hash2;
                            }
                            next = next.getNext();
                        }
                        arrayCompositeDisposable.set(hash, hVar);
                        while (e2 != hVar) {
                            int hash3 = e2.getHash() & length2;
                            h copyEntry = copyEntry(e2, (h) arrayCompositeDisposable.get(hash3));
                            if (copyEntry != null) {
                                arrayCompositeDisposable.set(hash3, copyEntry);
                            } else {
                                i10--;
                            }
                            e2 = e2.getNext();
                        }
                    }
                }
            }
            this.table = arrayCompositeDisposable;
            this.count = i10;
        }

        public V get(Object obj, int i10) {
            try {
                E liveEntry = getLiveEntry(obj, i10);
                if (liveEntry == null) {
                    return null;
                }
                V v2 = (V) liveEntry.getValue();
                if (v2 == null) {
                    tryDrainReferenceQueues();
                }
                return v2;
            } finally {
                postReadCleanup();
            }
        }

        public E getEntry(Object obj, int i10) {
            if (this.count == 0) {
                return null;
            }
            for (E first = getFirst(i10); first != null; first = (E) first.getNext()) {
                if (first.getHash() == i10) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public E getFirst(int i10) {
            return this.table.get(i10 & (r0.length() - 1));
        }

        public ReferenceQueue<K> getKeyReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public E getLiveEntry(Object obj, int i10) {
            return getEntry(obj, i10);
        }

        public V getLiveValue(E e2) {
            if (e2.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v2 = (V) e2.getValue();
            if (v2 != null) {
                return v2;
            }
            tryDrainReferenceQueues();
            return null;
        }

        public V getLiveValueForTesting(h<K, V, ?> hVar) {
            return getLiveValue(castForTesting(hVar));
        }

        public ReferenceQueue<V> getValueReferenceQueueForTesting() {
            throw new AssertionError();
        }

        public v<K, V, E> getWeakValueReferenceForTesting(h<K, V, ?> hVar) {
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<E> atomicReferenceArray) {
            int length = (atomicReferenceArray.length() * 3) / 4;
            this.threshold = length;
            if (length == this.maxSegmentSize) {
                this.threshold = length + 1;
            }
            this.table = atomicReferenceArray;
        }

        public void maybeClearReferenceQueues() {
        }

        public void maybeDrainReferenceQueues() {
        }

        public AtomicReferenceArray<E> newEntryArray(int i10) {
            return new AtomicReferenceArray<>(i10);
        }

        public E newEntryForTesting(K k10, int i10, h<K, V, ?> hVar) {
            return this.map.entryHelper.e(self(), k10, i10, castForTesting(hVar));
        }

        public v<K, V, E> newWeakValueReferenceForTesting(h<K, V, ?> hVar, V v2) {
            throw new AssertionError();
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                runCleanup();
            }
        }

        public void preWriteCleanup() {
            runLockedCleanup();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V put(K k10, int i10, V v2, boolean z10) {
            lock();
            try {
                preWriteCleanup();
                int i11 = this.count + 1;
                if (i11 > this.threshold) {
                    expand();
                    i11 = this.count + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v10 = (V) hVar2.getValue();
                        if (v10 == null) {
                            this.modCount++;
                            setValue(hVar2, v2);
                            this.count = this.count;
                            return null;
                        }
                        if (z10) {
                            return v10;
                        }
                        this.modCount++;
                        setValue(hVar2, v2);
                        return v10;
                    }
                }
                this.modCount++;
                h e2 = this.map.entryHelper.e(self(), k10, i10, hVar);
                setValue(e2, v2);
                atomicReferenceArray.set(length, e2);
                this.count = i11;
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimKey(E e2, int i10) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = i10 & (atomicReferenceArray.length() - 1);
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    if (hVar2 == e2) {
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean reclaimValue(K k10, int i10, v<K, V, E> vVar) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        if (((u) hVar2).getValueReference() != vVar) {
                            return false;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V remove(Object obj, int i10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        V v2 = (V) hVar2.getValue();
                        if (v2 == null && !isCollected(hVar2)) {
                            return null;
                        }
                        this.modCount++;
                        h removeFromChain = removeFromChain(hVar, hVar2);
                        int i11 = this.count - 1;
                        atomicReferenceArray.set(length, removeFromChain);
                        this.count = i11;
                        return v2;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean removeEntryForTesting(E e2) {
            int hash = e2.getHash();
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = hash & (atomicReferenceArray.length() - 1);
            h hVar = (h) atomicReferenceArray.get(length);
            for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                if (hVar2 == e2) {
                    this.modCount++;
                    h removeFromChain = removeFromChain(hVar, hVar2);
                    int i10 = this.count - 1;
                    atomicReferenceArray.set(length, removeFromChain);
                    this.count = i10;
                    return true;
                }
            }
            return false;
        }

        public E removeFromChain(E e2, E e10) {
            int i10 = this.count;
            E e11 = (E) e10.getNext();
            while (e2 != e10) {
                E copyEntry = copyEntry(e2, e11);
                if (copyEntry != null) {
                    e11 = copyEntry;
                } else {
                    i10--;
                }
                e2 = (E) e2.getNext();
            }
            this.count = i10;
            return e11;
        }

        public E removeFromChainForTesting(h<K, V, ?> hVar, h<K, V, ?> hVar2) {
            return removeFromChain(castForTesting(hVar), castForTesting(hVar2));
        }

        public boolean removeTableEntryForTesting(h<K, V, ?> hVar) {
            return removeEntryForTesting(castForTesting(hVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean replace(K k10, int i10, V v2, V v10) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        Object value = hVar2.getValue();
                        if (value == null) {
                            if (isCollected(hVar2)) {
                                this.modCount++;
                                h removeFromChain = removeFromChain(hVar, hVar2);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i11;
                            }
                            return false;
                        }
                        if (!this.map.valueEquivalence().equivalent(v2, value)) {
                            return false;
                        }
                        this.modCount++;
                        setValue(hVar2, v10);
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        public void runCleanup() {
            runLockedCleanup();
        }

        public void runLockedCleanup() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public abstract S self();

        public void setTableEntryForTesting(int i10, h<K, V, ?> hVar) {
            this.table.set(i10, castForTesting(hVar));
        }

        public void setValue(E e2, V v2) {
            this.map.entryHelper.a(self(), e2, v2);
        }

        public void setValueForTesting(h<K, V, ?> hVar, V v2) {
            this.map.entryHelper.a(self(), castForTesting(hVar), v2);
        }

        public void setWeakValueReferenceForTesting(h<K, V, ?> hVar, v<K, V, ? extends h<K, V, ?>> vVar) {
            throw new AssertionError();
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    maybeDrainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r8.map.valueEquivalence().equivalent(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        
            r8.modCount++;
            r9 = removeFromChain(r3, r4);
            r10 = r8.count - 1;
            r0.set(r1, r9);
            r8.count = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        
            if (isCollected(r4) == false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        
            return false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean remove(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.preWriteCleanup()     // Catch: java.lang.Throwable -> L69
                java.util.concurrent.atomic.AtomicReferenceArray<E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>> r0 = r8.table     // Catch: java.lang.Throwable -> L69
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L69
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$h r3 = (com.google.common.collect.MapMakerInternalMap.h) r3     // Catch: java.lang.Throwable -> L69
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L65
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L69
                int r7 = r4.getHash()     // Catch: java.lang.Throwable -> L69
                if (r7 != r10) goto L60
                if (r6 == 0) goto L60
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r7 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence<java.lang.Object> r7 = r7.keyEquivalence     // Catch: java.lang.Throwable -> L69
                boolean r6 = r7.equivalent(r9, r6)     // Catch: java.lang.Throwable -> L69
                if (r6 == 0) goto L60
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap<K, V, E extends com.google.common.collect.MapMakerInternalMap$h<K, V, E>, S extends com.google.common.collect.MapMakerInternalMap$Segment<K, V, E, S>> r10 = r8.map     // Catch: java.lang.Throwable -> L69
                com.google.common.base.Equivalence r10 = r10.valueEquivalence()     // Catch: java.lang.Throwable -> L69
                boolean r9 = r10.equivalent(r11, r9)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L41
                r5 = 1
                goto L47
            L41:
                boolean r9 = isCollected(r4)     // Catch: java.lang.Throwable -> L69
                if (r9 == 0) goto L5c
            L47:
                int r9 = r8.modCount     // Catch: java.lang.Throwable -> L69
                int r9 = r9 + r2
                r8.modCount = r9     // Catch: java.lang.Throwable -> L69
                com.google.common.collect.MapMakerInternalMap$h r9 = r8.removeFromChain(r3, r4)     // Catch: java.lang.Throwable -> L69
                int r10 = r8.count     // Catch: java.lang.Throwable -> L69
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L69
                r8.count = r10     // Catch: java.lang.Throwable -> L69
                r8.unlock()
                return r5
            L5c:
                r8.unlock()
                return r5
            L60:
                com.google.common.collect.MapMakerInternalMap$h r4 = r4.getNext()     // Catch: java.lang.Throwable -> L69
                goto L16
            L65:
                r8.unlock()
                return r5
            L69:
                r9 = move-exception
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V replace(K k10, int i10, V v2) {
            lock();
            try {
                preWriteCleanup();
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i10;
                h hVar = (h) atomicReferenceArray.get(length);
                for (h hVar2 = hVar; hVar2 != null; hVar2 = hVar2.getNext()) {
                    Object key = hVar2.getKey();
                    if (hVar2.getHash() == i10 && key != null && this.map.keyEquivalence.equivalent(k10, key)) {
                        V v10 = (V) hVar2.getValue();
                        if (v10 == null) {
                            if (isCollected(hVar2)) {
                                this.modCount++;
                                h removeFromChain = removeFromChain(hVar, hVar2);
                                int i11 = this.count - 1;
                                atomicReferenceArray.set(length, removeFromChain);
                                this.count = i11;
                            }
                            return null;
                        }
                        this.modCount++;
                        setValue(hVar2, v2);
                        return v10;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }
    }
}
