package com.google.common.collect;

import com.google.common.collect.k0;
import com.google.common.collect.v0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import sun.security.x509.PolicyMappingsExtension;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableMultimap<K, V> extends j<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    public final transient int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        public final ImmutableMultimap<K, V> multimap;

        public EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public i1<Map.Entry<K, V>> iterator2() {
            return this.multimap.entryIterator();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Keys extends ImmutableMultiset<K> {
        public Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public k0.a<K> getEntry(int i10) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i10);
            return Multisets.g(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class KeysSerializedForm implements Serializable {
        public final ImmutableMultimap<?, ?> multimap;

        public KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        public Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i10) {
            i1<? extends ImmutableCollection<V>> iterator2 = this.multimap.map.values().iterator2();
            while (iterator2.hasNext()) {
                i10 = iterator2.next().copyIntoArray(objArr, i10);
            }
            return i10;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public i1<V> iterator2() {
            return this.multimap.valueIterator();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends i1<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f26274b;

        /* renamed from: c, reason: collision with root package name */
        public K f26275c = null;

        /* renamed from: d, reason: collision with root package name */
        public Iterator<V> f26276d = Iterators.h();

        public a() {
            this.f26274b = ImmutableMultimap.this.map.entrySet().iterator2();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f26276d.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f26274b.next();
                this.f26275c = next.getKey();
                this.f26276d = next.getValue().iterator2();
            }
            K k10 = this.f26275c;
            Objects.requireNonNull(k10);
            return Maps.j(k10, this.f26276d.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26276d.hasNext() || this.f26274b.hasNext();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends i1<V> {

        /* renamed from: b, reason: collision with root package name */
        public Iterator<? extends ImmutableCollection<V>> f26278b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator<V> f26279c = Iterators.h();

        public b() {
            this.f26278b = ImmutableMultimap.this.map.values().iterator2();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26279c.hasNext() || this.f26278b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f26279c.hasNext()) {
                this.f26279c = this.f26278b.next().iterator2();
            }
            return this.f26279c.next();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f26281a = q0.h();

        /* renamed from: b, reason: collision with root package name */
        public Comparator<? super K> f26282b;

        /* renamed from: c, reason: collision with root package name */
        public Comparator<? super V> f26283c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f26281a.entrySet();
            Comparator<? super K> comparator = this.f26282b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.f26283c);
        }

        public Collection<V> b() {
            return new ArrayList();
        }

        public c<K, V> c(K k10, V v2) {
            m.a(k10, v2);
            Collection<V> collection = this.f26281a.get(k10);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f26281a;
                Collection<V> b4 = b();
                map.put(k10, b4);
                collection = b4;
            }
            collection.add(v2);
            return this;
        }

        public c<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public c<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                d(iterator2.next());
            }
            return this;
        }

        public c<K, V> f(K k10, Iterable<? extends V> iterable) {
            if (k10 == null) {
                String valueOf = String.valueOf(g0.n(iterable));
                throw new NullPointerException(valueOf.length() != 0 ? "null key in entry: null=".concat(valueOf) : new String("null key in entry: null="));
            }
            Collection<V> collection = this.f26281a.get(k10);
            if (collection != null) {
                for (V v2 : iterable) {
                    m.a(k10, v2);
                    collection.add(v2);
                }
                return this;
            }
            Iterator<? extends V> iterator2 = iterable.iterator2();
            if (!iterator2.hasNext()) {
                return this;
            }
            Collection<V> b4 = b();
            while (iterator2.hasNext()) {
                V next = iterator2.next();
                m.a(k10, next);
                b4.add(next);
            }
            this.f26281a.put(k10, b4);
            return this;
        }

        public c<K, V> g(K k10, V... vArr) {
            return f(k10, Arrays.asList(vArr));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final v0.b<ImmutableMultimap> f26284a = v0.a(ImmutableMultimap.class, PolicyMappingsExtension.MAP);

        /* renamed from: b, reason: collision with root package name */
        public static final v0.b<ImmutableMultimap> f26285b = v0.a(ImmutableMultimap.class, "size");
    }

    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i10) {
        this.map = immutableMap;
        this.size = i10;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(j0<? extends K, ? extends V> j0Var) {
        if (j0Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) j0Var;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((j0) j0Var);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError((Object) "should never be called");
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        throw new AssertionError((Object) "unreachable");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j0
    public abstract ImmutableCollection<V> get(K k10);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public final boolean put(K k10, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public final boolean putAll(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.j0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v2) {
        return ImmutableListMultimap.of((Object) k10, (Object) v2);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.c
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    @Override // com.google.common.collect.c
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.c
    public i1<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public ImmutableSet<K> keySet() {
        return this.map.h();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public final boolean putAll(j0<? extends K, ? extends V> j0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j0
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c
    public i1<V> valueIterator() {
        return new b();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v2, K k11, V v10) {
        return ImmutableListMultimap.of((Object) k10, (Object) v2, (Object) k11, (Object) v10);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11) {
        return ImmutableListMultimap.of((Object) k10, (Object) v2, (Object) k11, (Object) v10, (Object) k12, (Object) v11);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12) {
        return ImmutableListMultimap.of((Object) k10, (Object) v2, (Object) k11, (Object) v10, (Object) k12, (Object) v11, (Object) k13, (Object) v12);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v2, K k11, V v10, K k12, V v11, K k13, V v12, K k14, V v13) {
        return ImmutableListMultimap.of((Object) k10, (Object) v2, (Object) k11, (Object) v10, (Object) k12, (Object) v11, (Object) k13, (Object) v12, (Object) k14, (Object) v13);
    }
}
