package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.collect.v0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ConcurrentHashMultiset<E> extends com.google.common.collect.d<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient ConcurrentMap<E, AtomicInteger> countMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractIterator<k0.a<E>> {

        /* renamed from: d, reason: collision with root package name */
        public final Iterator<Map.Entry<E, AtomicInteger>> f26223d;

        public b() {
            this.f26223d = ConcurrentHashMultiset.this.countMap.entrySet().iterator2();
        }

        @Override // com.google.common.collect.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public k0.a<E> a() {
            while (this.f26223d.hasNext()) {
                Map.Entry<E, AtomicInteger> next = this.f26223d.next();
                int i10 = next.getValue().get();
                if (i10 != 0) {
                    return Multisets.g(next.getKey(), i10);
                }
            }
            return b();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends u<k0.a<E>> {

        /* renamed from: b, reason: collision with root package name */
        public k0.a<E> f26225b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f26226c;

        public c(Iterator it) {
            this.f26226c = it;
        }

        @Override // com.google.common.collect.z
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public Iterator<k0.a<E>> delegate() {
            return this.f26226c;
        }

        @Override // com.google.common.collect.u, java.util.Iterator
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public k0.a<E> next() {
            k0.a<E> aVar = (k0.a) super.next();
            this.f26225b = aVar;
            return aVar;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.o.y(this.f26225b != null, "no calls to next() since the last call to remove()");
            ConcurrentHashMultiset.this.setCount(this.f26225b.getElement(), 0);
            this.f26225b = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends com.google.common.collect.d<E>.b {
        public d() {
            super();
        }

        @Override // com.google.common.collect.d.b, com.google.common.collect.Multisets.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset<E> b() {
            return ConcurrentHashMultiset.this;
        }

        public final List<k0.a<E>> f() {
            ArrayList o10 = Lists.o(size());
            Iterators.a(o10, iterator2());
            return o10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return f().toArray();
        }

        public /* synthetic */ d(ConcurrentHashMultiset concurrentHashMultiset, a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) f().toArray(tArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final v0.b<ConcurrentHashMultiset> f26229a = v0.a(ConcurrentHashMultiset.class, "countMap");
    }

    public ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        com.google.common.base.o.m(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e.f26229a.b(this, (ConcurrentMap) objectInputStream.readObject());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<E> snapshot() {
        ArrayList o10 = Lists.o(size());
        for (k0.a aVar : entrySet()) {
            Object element = aVar.getElement();
            for (int count = aVar.getCount(); count > 0; count--) {
                o10.add(element);
            }
        }
        return o10;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int add(E e2, int i10) {
        AtomicInteger atomicInteger;
        int i11;
        AtomicInteger atomicInteger2;
        com.google.common.base.o.r(e2);
        if (i10 == 0) {
            return count(e2);
        }
        m.d(i10, "occurrences");
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger == null && (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i10))) == null) {
                return 0;
            }
            do {
                i11 = atomicInteger.get();
                if (i11 != 0) {
                    try {
                    } catch (ArithmeticException unused) {
                        StringBuilder sb2 = new StringBuilder(65);
                        sb2.append("Overflow adding ");
                        sb2.append(i10);
                        sb2.append(" occurrences to a count of ");
                        sb2.append(i11);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                } else {
                    atomicInteger2 = new AtomicInteger(i10);
                    if (this.countMap.putIfAbsent(e2, atomicInteger2) == null) {
                        break;
                    }
                }
            } while (!atomicInteger.compareAndSet(i11, com.google.common.math.d.a(i11, i10)));
            return i11;
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.countMap.clear();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.k0
    public int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.d
    public Set<E> createElementSet() {
        return new a(this, this.countMap.h());
    }

    @Override // com.google.common.collect.d
    @Deprecated
    public Set<k0.a<E>> createEntrySet() {
        return new d(this, null);
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.countMap.size();
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        throw new AssertionError((Object) "should never be called");
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    public Iterator<k0.a<E>> entryIterator() {
        return new c(new b());
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int remove(Object obj, int i10) {
        int i11;
        int max;
        if (i10 == 0) {
            return count(obj);
        }
        m.d(i10, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 == 0) {
                return 0;
            }
            max = Math.max(0, i11 - i10);
        } while (!atomicInteger.compareAndSet(i11, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i11;
    }

    public boolean removeExactly(Object obj, int i10) {
        int i11;
        int i12;
        if (i10 == 0) {
            return true;
        }
        m.d(i10, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i11 = atomicInteger.get();
            if (i11 < i10) {
                return false;
            }
            i12 = i11 - i10;
        } while (!atomicInteger.compareAndSet(i11, i12));
        if (i12 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int setCount(E e2, int i10) {
        AtomicInteger atomicInteger;
        int i11;
        AtomicInteger atomicInteger2;
        com.google.common.base.o.r(e2);
        m.b(i10, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
            if (atomicInteger == null && (i10 == 0 || (atomicInteger = this.countMap.putIfAbsent(e2, new AtomicInteger(i10))) == null)) {
                return 0;
            }
            do {
                i11 = atomicInteger.get();
                if (i11 == 0) {
                    if (i10 != 0) {
                        atomicInteger2 = new AtomicInteger(i10);
                        if (this.countMap.putIfAbsent(e2, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i11, i10));
            if (i10 == 0) {
                this.countMap.remove(e2, atomicInteger);
            }
            return i11;
        } while (!this.countMap.replace(e2, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long j10 = 0;
        while (this.countMap.values().iterator2().hasNext()) {
            j10 += r0.next().get();
        }
        return Ints.l(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return snapshot().toArray();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends b0<E> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f26222b;

        public a(ConcurrentHashMultiset concurrentHashMultiset, Set set) {
            this.f26222b = set;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return obj != null && n.c(this.f26222b, obj);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return obj != null && n.d(this.f26222b, obj);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<E> delegate() {
            return this.f26222b;
        }
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        g0.a(create, iterable);
        return create;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) snapshot().toArray(tArr);
    }

    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public boolean setCount(E e2, int i10, int i11) {
        com.google.common.base.o.r(e2);
        m.b(i10, "oldCount");
        m.b(i11, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.x(this.countMap, e2);
        if (atomicInteger == null) {
            if (i10 != 0) {
                return false;
            }
            return i11 == 0 || this.countMap.putIfAbsent(e2, new AtomicInteger(i11)) == null;
        }
        int i12 = atomicInteger.get();
        if (i12 == i10) {
            if (i12 == 0) {
                if (i11 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i11);
                return this.countMap.putIfAbsent(e2, atomicInteger2) == null || this.countMap.replace(e2, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i12, i11)) {
                if (i11 == 0) {
                    this.countMap.remove(e2, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }
}
