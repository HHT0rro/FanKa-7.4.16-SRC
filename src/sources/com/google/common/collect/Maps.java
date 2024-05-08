package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Maps {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.collect.k<A, B> bimap;

        public BiMapConverter(com.google.common.collect.k<A, B> kVar) {
            this.bimap = (com.google.common.collect.k) com.google.common.base.o.r(kVar);
        }

        private static <X, Y> Y convert(com.google.common.collect.k<X, Y> kVar, X x10) {
            Y y10 = kVar.get(x10);
            com.google.common.base.o.m(y10 != null, "No non-null mapping present for input: %s", x10);
            return y10;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b4) {
            return (A) convert(this.bimap.inverse(), b4);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a10) {
            return (B) convert(this.bimap, a10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.bimap);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
            sb2.append("Maps.asConverter(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum EntryFunction implements com.google.common.base.g<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.g
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.collect.Maps.EntryFunction, com.google.common.base.g
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        @Override // com.google.common.base.g
        public abstract /* synthetic */ Object apply(Map.Entry<?, ?> entry);

        /* synthetic */ EntryFunction(c cVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableBiMap<K, V> extends v<K, V> implements com.google.common.collect.k<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        public final com.google.common.collect.k<? extends K, ? extends V> delegate;
        public com.google.common.collect.k<V, K> inverse;
        public final Map<K, V> unmodifiableMap;
        public transient Set<V> values;

        public UnmodifiableBiMap(com.google.common.collect.k<? extends K, ? extends V> kVar, com.google.common.collect.k<V, K> kVar2) {
            this.unmodifiableMap = Collections.unmodifiableMap(kVar);
            this.delegate = kVar;
            this.inverse = kVar2;
        }

        @Override // com.google.common.collect.k
        public V forcePut(K k10, V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.k
        public com.google.common.collect.k<V, K> inverse() {
            com.google.common.collect.k<V, K> kVar = this.inverse;
            if (kVar != null) {
                return kVar;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.v, com.google.common.collect.z
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.v, java.util.Map
        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableNavigableMap<K, V> extends c0<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            return Maps.J(this.delegate.ceilingEntry(k10));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return this.delegate.ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.j(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.J(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            return Maps.J(this.delegate.floorEntry(k10));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return this.delegate.floorKey(k10);
        }

        @Override // com.google.common.collect.c0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            return Maps.J(this.delegate.higherEntry(k10));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return this.delegate.higherKey(k10);
        }

        @Override // com.google.common.collect.v, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.J(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            return Maps.J(this.delegate.lowerEntry(k10));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return this.delegate.lowerKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.j(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.c0, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            return Maps.I(this.delegate.headMap(k10, z10));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            return Maps.I(this.delegate.subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            return Maps.I(this.delegate.tailMap(k10, z10));
        }

        public UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        @Override // com.google.common.collect.c0, com.google.common.collect.v, com.google.common.collect.z
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a<K, V2> extends com.google.common.collect.b<K, V2> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f26417b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f26418c;

        public a(Map.Entry entry, k kVar) {
            this.f26417b = entry;
            this.f26418c = kVar;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return (K) this.f26417b.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V2 getValue() {
            return (V2) this.f26418c.a(this.f26417b.getKey(), this.f26417b.getValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b<K, V1, V2> implements com.google.common.base.g<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f26419b;

        public b(k kVar) {
            this.f26419b = kVar;
        }

        @Override // com.google.common.base.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
            return Maps.C(this.f26419b, entry);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c<K, V> extends f1<Map.Entry<K, V>, K> {
        public c(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.f1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d<K, V> extends f1<Map.Entry<K, V>, V> {
        public d(Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.f1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e<K, V> extends f1<K, Map.Entry<K, V>> {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.g f26420c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Iterator it, com.google.common.base.g gVar) {
            super(it);
            this.f26420c = gVar;
        }

        @Override // com.google.common.collect.f1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k10) {
            return Maps.j(k10, this.f26420c.apply(k10));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class f<K, V> extends com.google.common.collect.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f26421b;

        public f(Map.Entry entry) {
            this.f26421b = entry;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return (K) this.f26421b.getKey();
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return (V) this.f26421b.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class g<K, V> extends i1<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator f26422b;

        public g(Iterator it) {
            this.f26422b = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return Maps.F((Map.Entry) this.f26422b.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26422b.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h<K, V1, V2> implements k<K, V1, V2> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.common.base.g f26423a;

        public h(com.google.common.base.g gVar) {
            this.f26423a = gVar;
        }

        @Override // com.google.common.collect.Maps.k
        public V2 a(K k10, V1 v12) {
            return (V2) this.f26423a.apply(v12);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class i<K, V> extends v<K, V> implements NavigableMap<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public transient Comparator<? super K> f26424b;

        /* renamed from: c, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f26425c;

        /* renamed from: d, reason: collision with root package name */
        public transient NavigableSet<K> f26426d;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, V> b() {
                return i.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                return i.this.p();
            }
        }

        public static <T> Ordering<T> r(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            return q().floorEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return q().floorKey(k10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f26424b;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = q().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering r10 = r(comparator2);
            this.f26424b = r10;
            return r10;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return q().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return q();
        }

        @Override // com.google.common.collect.v, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f26425c;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> o10 = o();
            this.f26425c = o10;
            return o10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return q().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return q().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            return q().ceilingEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return q().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            return q().tailMap(k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            return q().lowerEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return q().lowerKey(k10);
        }

        @Override // com.google.common.collect.v, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return q().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return q().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            return q().higherEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return q().higherKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f26426d;
            if (navigableSet != null) {
                return navigableSet;
            }
            n nVar = new n(this);
            this.f26426d = nVar;
            return nVar;
        }

        public Set<Map.Entry<K, V>> o() {
            return new a();
        }

        public abstract Iterator<Map.Entry<K, V>> p();

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return q().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return q().pollFirstEntry();
        }

        public abstract NavigableMap<K, V> q();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            return q().subMap(k11, z11, k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            return q().headMap(k10, z10).descendingMap();
        }

        @Override // com.google.common.collect.z
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.v, java.util.Map
        public Collection<V> values() {
            return new t(this);
        }

        @Override // com.google.common.collect.v, com.google.common.collect.z
        public final Map<K, V> delegate() {
            return q();
        }

        @Override // java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class j<K, V> extends Sets.b<Map.Entry<K, V>> {
        public abstract Map<K, V> b();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object x10 = Maps.x(b(), key);
            if (com.google.common.base.l.a(x10, entry.getValue())) {
                return x10 != null || b().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return b().h().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.o.r(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.i(this, collection.iterator2());
            }
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.o.r(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet e2 = Sets.e(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        e2.add(((Map.Entry) obj).getKey());
                    }
                }
                return b().h().retainAll(e2);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface k<K, V1, V2> {
        V2 a(K k10, V1 v12);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class l<K, V> extends AbstractMap<K, V> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends j<K, V> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, V> b() {
                return l.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                return l.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.d(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class m<K, V> extends Sets.b<K> {

        /* renamed from: b, reason: collision with root package name */
        public final Map<K, V> f26429b;

        public m(Map<K, V> map) {
            this.f26429b = (Map) com.google.common.base.o.r(map);
        }

        /* renamed from: b */
        public Map<K, V> c() {
            return this.f26429b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return Maps.m(c().entrySet().iterator2());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            c().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class n<K, V> extends o<K, V> implements NavigableSet<K> {
        public n(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k10) {
            return b().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator2();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return b().descendingKeySet();
        }

        @Override // com.google.common.collect.Maps.o
        /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> c() {
            return (NavigableMap) this.f26429b;
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return b().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return b().headMap(k10, z10).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return b().higherKey(k10);
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return b().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.n(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.n(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return b().subMap(k10, z10, k11, z11).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return b().tailMap(k10, z10).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Maps.o, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class o<K, V> extends m<K, V> implements SortedSet<K> {
        public o(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // com.google.common.collect.Maps.m
        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k10) {
            return new o(c().headMap(k10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k10, K k11) {
            return new o(c().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(K k10) {
            return new o(c().tailMap(k10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class p<K, V1, V2> extends l<K, V2> {

        /* renamed from: b, reason: collision with root package name */
        public final Map<K, V1> f26430b;

        /* renamed from: c, reason: collision with root package name */
        public final k<? super K, ? super V1, V2> f26431c;

        public p(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
            this.f26430b = (Map) com.google.common.base.o.r(map);
            this.f26431c = (k) com.google.common.base.o.r(kVar);
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.x(this.f26430b.entrySet().iterator2(), Maps.b(this.f26431c));
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f26430b.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f26430b.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object obj) {
            V1 v12 = this.f26430b.get(obj);
            if (v12 != null || this.f26430b.containsKey(obj)) {
                return this.f26431c.a(obj, (Object) l0.a(v12));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return this.f26430b.h();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object obj) {
            if (this.f26430b.containsKey(obj)) {
                return this.f26431c.a(obj, (Object) l0.a(this.f26430b.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26430b.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new t(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class q<K, V1, V2> extends p<K, V1, V2> implements SortedMap<K, V2> {
        public q(SortedMap<K, V1> sortedMap, k<? super K, ? super V1, V2> kVar) {
            super(sortedMap, kVar);
        }

        public SortedMap<K, V1> b() {
            return (SortedMap) this.f26430b;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return b().firstKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> headMap(K k10) {
            return Maps.B(b().headMap(k10), this.f26431c);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return b().lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> subMap(K k10, K k11) {
            return Maps.B(b().subMap(k10, k11), this.f26431c);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> tailMap(K k10) {
            return Maps.B(b().tailMap(k10), this.f26431c);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class r<K, V> extends com.google.common.collect.s<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f26432b;

        public r(Collection<Map.Entry<K, V>> collection) {
            this.f26432b = collection;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return Maps.G(this.f26432b.iterator2());
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.z
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f26432b;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class s<K, V> extends r<K, V> implements Set<Map.Entry<K, V>> {
        public s(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class t<K, V> extends AbstractCollection<V> {

        /* renamed from: b, reason: collision with root package name */
        public final Map<K, V> f26433b;

        public t(Map<K, V> map) {
            this.f26433b = (Map) com.google.common.base.o.r(map);
        }

        public final Map<K, V> b() {
            return this.f26433b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return b().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return Maps.L(b().entrySet().iterator2());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (com.google.common.base.l.a(obj, entry.getValue())) {
                        b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.google.common.base.o.r(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = Sets.d();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d10.add(entry.getKey());
                    }
                }
                return b().h().removeAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.google.common.base.o.r(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = Sets.d();
                for (Map.Entry<K, V> entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        d10.add(entry.getKey());
                    }
                }
                return b().h().retainAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class u<K, V> extends AbstractMap<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public transient Set<Map.Entry<K, V>> f26434b;

        /* renamed from: c, reason: collision with root package name */
        public transient Set<K> f26435c;

        /* renamed from: d, reason: collision with root package name */
        public transient Collection<V> f26436d;

        abstract Set<Map.Entry<K, V>> a();

        /* renamed from: b */
        public Set<K> g() {
            return new m(this);
        }

        public Collection<V> c() {
            return new t(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f26434b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a10 = a();
            this.f26434b = a10;
            return a10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            Set<K> set = this.f26435c;
            if (set != null) {
                return set;
            }
            Set<K> g3 = g();
            this.f26435c = g3;
            return g3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f26436d;
            if (collection != null) {
                return collection;
            }
            Collection<V> c4 = c();
            this.f26436d = c4;
            return c4;
        }
    }

    public static <K, V1, V2> Map<K, V2> A(Map<K, V1> map, k<? super K, ? super V1, V2> kVar) {
        return new p(map, kVar);
    }

    public static <K, V1, V2> SortedMap<K, V2> B(SortedMap<K, V1> sortedMap, k<? super K, ? super V1, V2> kVar) {
        return new q(sortedMap, kVar);
    }

    public static <V2, K, V1> Map.Entry<K, V2> C(k<? super K, ? super V1, V2> kVar, Map.Entry<K, V1> entry) {
        com.google.common.base.o.r(kVar);
        com.google.common.base.o.r(entry);
        return new a(entry, kVar);
    }

    public static <K, V1, V2> Map<K, V2> D(Map<K, V1> map, com.google.common.base.g<? super V1, V2> gVar) {
        return A(map, c(gVar));
    }

    public static <K, V1, V2> SortedMap<K, V2> E(SortedMap<K, V1> sortedMap, com.google.common.base.g<? super V1, V2> gVar) {
        return B(sortedMap, c(gVar));
    }

    public static <K, V> Map.Entry<K, V> F(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.o.r(entry);
        return new f(entry);
    }

    public static <K, V> i1<Map.Entry<K, V>> G(Iterator<Map.Entry<K, V>> it) {
        return new g(it);
    }

    public static <K, V> Set<Map.Entry<K, V>> H(Set<Map.Entry<K, V>> set) {
        return new s(Collections.unmodifiableSet(set));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> NavigableMap<K, V> I(NavigableMap<K, ? extends V> navigableMap) {
        com.google.common.base.o.r(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    public static <K, V> Map.Entry<K, V> J(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return F(entry);
    }

    public static <V> com.google.common.base.g<Map.Entry<?, V>, V> K() {
        return EntryFunction.VALUE;
    }

    public static <K, V> Iterator<V> L(Iterator<Map.Entry<K, V>> it) {
        return new d(it);
    }

    public static <V> V M(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> com.google.common.base.p<Map.Entry<?, V>> N(com.google.common.base.p<? super V> pVar) {
        return Predicates.c(pVar, K());
    }

    public static <K, V1, V2> com.google.common.base.g<Map.Entry<K, V1>, Map.Entry<K, V2>> b(k<? super K, ? super V1, V2> kVar) {
        com.google.common.base.o.r(kVar);
        return new b(kVar);
    }

    public static <K, V1, V2> k<K, V1, V2> c(com.google.common.base.g<? super V1, V2> gVar) {
        com.google.common.base.o.r(gVar);
        return new h(gVar);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> d(Set<K> set, com.google.common.base.g<? super K, V> gVar) {
        return new e(set.iterator2(), gVar);
    }

    public static int e(int i10) {
        if (i10 < 3) {
            com.google.common.collect.m.b(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> boolean f(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(F((Map.Entry) obj));
        }
        return false;
    }

    public static boolean g(Map<?, ?> map, Object obj) {
        return Iterators.f(m(map.entrySet().iterator2()), obj);
    }

    public static boolean h(Map<?, ?> map, Object obj) {
        return Iterators.f(L(map.entrySet().iterator2()), obj);
    }

    public static boolean i(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> j(K k10, V v2) {
        return new ImmutableEntry(k10, v2);
    }

    public static <E> ImmutableMap<E, Integer> k(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        Iterator<E> iterator2 = collection.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            bVar.g(iterator2.next(), Integer.valueOf(i10));
            i10++;
        }
        return bVar.d();
    }

    public static <K> com.google.common.base.g<Map.Entry<K, ?>, K> l() {
        return EntryFunction.KEY;
    }

    public static <K, V> Iterator<K> m(Iterator<Map.Entry<K, V>> it) {
        return new c(it);
    }

    public static <K> K n(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> com.google.common.base.p<Map.Entry<K, ?>> o(com.google.common.base.p<? super K> pVar) {
        return Predicates.c(pVar, l());
    }

    public static <K, V> HashMap<K, V> p() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> q(int i10) {
        return new HashMap<>(e(i10));
    }

    public static <K, V> IdentityHashMap<K, V> r() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> s() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> t(int i10) {
        return new LinkedHashMap<>(e(i10));
    }

    public static <K, V> void u(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> boolean v(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(F((Map.Entry) obj));
        }
        return false;
    }

    public static boolean w(Map<?, ?> map, Object obj) {
        com.google.common.base.o.r(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V x(Map<?, V> map, Object obj) {
        com.google.common.base.o.r(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V y(Map<?, V> map, Object obj) {
        com.google.common.base.o.r(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String z(Map<?, ?> map) {
        StringBuilder b4 = com.google.common.collect.n.b(map.size());
        b4.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                b4.append(", ");
            }
            z10 = false;
            b4.append(entry.getKey());
            b4.append('=');
            b4.append(entry.getValue());
        }
        b4.append('}');
        return b4.toString();
    }
}
