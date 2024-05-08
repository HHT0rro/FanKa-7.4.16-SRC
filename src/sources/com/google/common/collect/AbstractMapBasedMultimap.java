package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.c;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends com.google.common.collect.c<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends AbstractMapBasedMultimap<K, V>.d<V> {
        public a(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        public V a(K k10, V v2) {
            return v2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractMapBasedMultimap<K, V>.d<Map.Entry<K, V>> {
        public b(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(K k10, V v2) {
            return Maps.j(k10, v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends Maps.u<K, Collection<V>> {

        /* renamed from: e, reason: collision with root package name */
        public final transient Map<K, Collection<V>> f26150e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends Maps.j<K, Collection<V>> {
            public a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> b() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return com.google.common.collect.n.c(c.this.f26150e.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, Collection<V>>> iterator2() {
                return new b();
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: b, reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f26153b;

            /* renamed from: c, reason: collision with root package name */
            public Collection<V> f26154c;

            public b() {
                this.f26153b = c.this.f26150e.entrySet().iterator2();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f26153b.next();
                this.f26154c = next.getValue();
                return c.this.f(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26153b.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.o.y(this.f26154c != null, "no calls to next() since the last call to remove()");
                this.f26153b.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f26154c.size());
                this.f26154c.clear();
                this.f26154c = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            this.f26150e = map;
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f26150e == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.w(this.f26150e, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.x(this.f26150e, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f26150e.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(remove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return createCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f26150e.equals(obj);
        }

        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.j(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f26150e.hashCode();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26150e.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f26150e.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f26156b;

        /* renamed from: c, reason: collision with root package name */
        public K f26157c = null;

        /* renamed from: d, reason: collision with root package name */
        public Collection<V> f26158d = null;

        /* renamed from: e, reason: collision with root package name */
        public Iterator<V> f26159e = Iterators.j();

        public d() {
            this.f26156b = AbstractMapBasedMultimap.this.map.entrySet().iterator2();
        }

        public abstract T a(K k10, V v2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26156b.hasNext() || this.f26159e.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f26159e.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f26156b.next();
                this.f26157c = next.getKey();
                Collection<V> value = next.getValue();
                this.f26158d = value;
                this.f26159e = value.iterator2();
            }
            return a(l0.a(this.f26157c), this.f26159e.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f26159e.remove();
            Collection<V> collection = this.f26158d;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f26156b.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e extends Maps.m<K, Collection<V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Iterator<K> {

            /* renamed from: b, reason: collision with root package name */
            public Map.Entry<K, Collection<V>> f26162b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Iterator f26163c;

            public a(Iterator it) {
                this.f26163c = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26163c.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f26163c.next();
                this.f26162b = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.base.o.y(this.f26162b != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f26162b.getValue();
                this.f26163c.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, value.size());
                value.clear();
                this.f26162b = null;
            }
        }

        public e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.d(iterator2());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return c().h().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || c().h().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return c().h().hashCode();
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new a(c().entrySet().iterator2());
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i10;
            Collection<V> remove = c().remove(obj);
            if (remove != null) {
                i10 = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i10);
            } else {
                i10 = 0;
            }
            return i10 > 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class f extends AbstractMapBasedMultimap<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k10) {
            Map.Entry<K, Collection<V>> ceilingEntry = i().ceilingEntry(k10);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return i().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k10) {
            Map.Entry<K, Collection<V>> floorEntry = i().floorEntry(k10);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return i().floorKey(k10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k10) {
            Map.Entry<K, Collection<V>> higherEntry = i().higherEntry(k10);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return i().higherKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> g() {
            return new g(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(K k10) {
            return headMap(k10, false);
        }

        public Map.Entry<K, Collection<V>> l(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> createCollection = AbstractMapBasedMultimap.this.createCollection();
            createCollection.addAll(next.getValue());
            it.remove();
            return Maps.j(next.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(createCollection));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k10) {
            Map.Entry<K, Collection<V>> lowerEntry = i().lowerEntry(k10);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return i().lowerKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return h();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return l(entrySet().iterator2());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return l(descendingMap().entrySet().iterator2());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k10, boolean z10) {
            return new f(i().headMap(k10, z10));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.i, com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k10, boolean z10, K k11, boolean z11) {
            return new f(i().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k10, boolean z10) {
            return new f(i().tailMap(k10, z10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class g extends AbstractMapBasedMultimap<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k10) {
            return c().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator2();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(c().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return c().floorKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> c() {
            return (NavigableMap) super.c();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return c().higherKey(k10);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.j, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return c().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Iterators.r(iterator2());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Iterators.r(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return new g(c().headMap(k10, z10));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return new g(c().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return new g(c().tailMap(k10, z10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h extends AbstractMapBasedMultimap<K, V>.l implements RandomAccess {
        public h(AbstractMapBasedMultimap abstractMapBasedMultimap, K k10, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, list, kVar);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class i extends AbstractMapBasedMultimap<K, V>.c implements SortedMap<K, Collection<V>> {

        /* renamed from: g, reason: collision with root package name */
        public SortedSet<K> f26167g;

        public i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().firstKey();
        }

        @Override // com.google.common.collect.Maps.u
        public SortedSet<K> g() {
            return new j(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.c, com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        public SortedSet<K> h() {
            SortedSet<K> sortedSet = this.f26167g;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> g3 = g();
            this.f26167g = g3;
            return g3;
        }

        public SortedMap<K, Collection<V>> headMap(K k10) {
            return new i(i().headMap(k10));
        }

        public SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.f26150e;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k10, K k11) {
            return new i(i().subMap(k10, k11));
        }

        public SortedMap<K, Collection<V>> tailMap(K k10) {
            return new i(i().tailMap(k10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class j extends AbstractMapBasedMultimap<K, V>.e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> c() {
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
            return new j(c().headMap(k10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k10, K k11) {
            return new j(c().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(K k10) {
            return new j(c().tailMap(k10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class m extends AbstractMapBasedMultimap<K, V>.o implements NavigableSet<V> {
        public m(K k10, NavigableSet<V> navigableSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v2) {
            return l().ceiling(v2);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(l().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return n(l().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v2) {
            return l().floor(v2);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v2, boolean z10) {
            return n(l().headSet(v2, z10));
        }

        @Override // java.util.NavigableSet
        public V higher(V v2) {
            return l().higher(v2);
        }

        @Override // java.util.NavigableSet
        public V lower(V v2) {
            return l().lower(v2);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.o
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableSet<V> l() {
            return (NavigableSet) super.l();
        }

        public final NavigableSet<V> n(NavigableSet<V> navigableSet) {
            return new m(this.f26170b, navigableSet, c() == null ? this : c());
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) Iterators.r(iterator2());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) Iterators.r(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v2, boolean z10, V v10, boolean z11) {
            return n(l().subSet(v2, z10, v10, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v2, boolean z10) {
            return n(l().tailSet(v2, z10));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class n extends AbstractMapBasedMultimap<K, V>.k implements Set<V> {
        public n(K k10, Set<V> set) {
            super(k10, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean h10 = Sets.h((Set) this.f26171c, collection);
            if (h10) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f26171c.size() - size);
                i();
            }
            return h10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class o extends AbstractMapBasedMultimap<K, V>.k implements SortedSet<V> {
        public o(K k10, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return l().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            h();
            return l().first();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<V> headSet(V v2) {
            h();
            return new o(g(), l().headSet(v2), c() == null ? this : c());
        }

        public SortedSet<V> l() {
            return (SortedSet) f();
        }

        @Override // java.util.SortedSet
        public V last() {
            h();
            return l().last();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<V> subSet(V v2, V v10) {
            h();
            return new o(g(), l().subSet(v2, v10), c() == null ? this : c());
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<V> tailSet(V v2) {
            h();
            return new o(g(), l().tailSet(v2), c() == null ? this : c());
        }
    }

    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.o.d(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i10 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.totalSize + i10;
        abstractMapBasedMultimap.totalSize = i11;
        return i11;
    }

    public static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i10) {
        int i11 = abstractMapBasedMultimap.totalSize - i10;
        abstractMapBasedMultimap.totalSize = i11;
        return i11;
    }

    private Collection<V> getOrCreateCollection(K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection != null) {
            return collection;
        }
        Collection<V> createCollection = createCollection(k10);
        this.map.put(k10, createCollection);
        return createCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> iteratorOrListIterator(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.y(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.j0
    public void clear() {
        Iterator<Collection<V>> iterator2 = this.map.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.j0
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.map);
    }

    abstract Collection<V> createCollection();

    public Collection<V> createCollection(K k10) {
        return createCollection();
    }

    @Override // com.google.common.collect.c
    public Collection<Map.Entry<K, V>> createEntries() {
        if (this instanceof w0) {
            return new c.b(this);
        }
        return new c.a();
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.c
    public k0<K> createKeys() {
        return new Multimaps.c(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new i((SortedMap) this.map);
        }
        return new c(this.map);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new j((SortedMap) this.map);
        }
        return new e(this.map);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.c
    public Collection<V> createValues() {
        return new c.C0237c();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // com.google.common.collect.j0
    public Collection<V> get(K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection == null) {
            collection = createCollection(k10);
        }
        return wrapCollection(k10, collection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public boolean put(K k10, V v2) {
        Collection<V> collection = this.map.get(k10);
        if (collection == null) {
            Collection<V> createCollection = createCollection(k10);
            if (createCollection.add(v2)) {
                this.totalSize++;
                this.map.put(k10, createCollection);
                return true;
            }
            throw new AssertionError((Object) "New Collection violated the Collection spec");
        }
        if (!collection.add(v2)) {
            return false;
        }
        this.totalSize++;
        return true;
    }

    @Override // com.google.common.collect.j0
    public Collection<V> removeAll(Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection createCollection = createCollection();
        createCollection.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        Iterator<? extends V> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return removeAll(k10);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k10);
        Collection<V> createCollection = createCollection();
        createCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (iterator2.hasNext()) {
            if (orCreateCollection.add(iterator2.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.o.d(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.j0
    public int size() {
        return this.totalSize;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.c
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(K k10, Collection<V> collection) {
        return new k(k10, collection, null);
    }

    public final List<V> wrapList(K k10, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
        if (list instanceof RandomAccess) {
            return new h(this, k10, list, kVar);
        }
        return new l(k10, list, kVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class k extends AbstractCollection<V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26170b;

        /* renamed from: c, reason: collision with root package name */
        public Collection<V> f26171c;

        /* renamed from: d, reason: collision with root package name */
        public final AbstractMapBasedMultimap<K, V>.k f26172d;

        /* renamed from: e, reason: collision with root package name */
        public final Collection<V> f26173e;

        public k(K k10, Collection<V> collection, AbstractMapBasedMultimap<K, V>.k kVar) {
            this.f26170b = k10;
            this.f26171c = collection;
            this.f26172d = kVar;
            this.f26173e = kVar == null ? null : kVar.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v2) {
            h();
            boolean isEmpty = this.f26171c.isEmpty();
            boolean add = this.f26171c.add(v2);
            if (add) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    b();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f26171c.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f26171c.size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        public void b() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f26172d;
            if (kVar != null) {
                kVar.b();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f26170b, this.f26171c);
            }
        }

        public AbstractMapBasedMultimap<K, V>.k c() {
            return this.f26172d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f26171c.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            h();
            return this.f26171c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            h();
            return this.f26171c.containsAll(collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            h();
            return this.f26171c.equals(obj);
        }

        public Collection<V> f() {
            return this.f26171c;
        }

        K g() {
            return this.f26170b;
        }

        public void h() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.k kVar = this.f26172d;
            if (kVar != null) {
                kVar.h();
                if (this.f26172d.f() != this.f26173e) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f26171c.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f26170b)) == null) {
                    return;
                }
                this.f26171c = collection;
            }
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            h();
            return this.f26171c.hashCode();
        }

        public void i() {
            AbstractMapBasedMultimap<K, V>.k kVar = this.f26172d;
            if (kVar != null) {
                kVar.i();
            } else if (this.f26171c.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f26170b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            h();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            h();
            boolean remove = this.f26171c.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                i();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f26171c.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f26171c.size() - size);
                i();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.o.r(collection);
            int size = size();
            boolean retainAll = this.f26171c.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f26171c.size() - size);
                i();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            h();
            return this.f26171c.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            h();
            return this.f26171c.toString();
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Iterator<V> {

            /* renamed from: b, reason: collision with root package name */
            public final Iterator<V> f26175b;

            /* renamed from: c, reason: collision with root package name */
            public final Collection<V> f26176c;

            public a() {
                Collection<V> collection = k.this.f26171c;
                this.f26176c = collection;
                this.f26175b = AbstractMapBasedMultimap.iteratorOrListIterator(collection);
            }

            public Iterator<V> a() {
                b();
                return this.f26175b;
            }

            public void b() {
                k.this.h();
                if (k.this.f26171c != this.f26176c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f26175b.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f26175b.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f26175b.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                k.this.i();
            }

            public a(Iterator<V> it) {
                this.f26176c = k.this.f26171c;
                this.f26175b = it;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class l extends AbstractMapBasedMultimap<K, V>.k implements List<V> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends AbstractMapBasedMultimap<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v2) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v2);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    l.this.b();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v2) {
                c().set(v2);
            }

            public a(int i10) {
                super(l.this.l().listIterator(i10));
            }
        }

        public l(K k10, List<V> list, AbstractMapBasedMultimap<K, V>.k kVar) {
            super(k10, list, kVar);
        }

        @Override // java.util.List
        public void add(int i10, V v2) {
            h();
            boolean isEmpty = f().isEmpty();
            l().add(i10, v2);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = l().addAll(i10, collection);
            if (addAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, f().size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        @Override // java.util.List
        public V get(int i10) {
            h();
            return l().get(i10);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            h();
            return l().indexOf(obj);
        }

        public List<V> l() {
            return (List) f();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            h();
            return l().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            h();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i10) {
            h();
            V remove = l().remove(i10);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            i();
            return remove;
        }

        @Override // java.util.List
        public V set(int i10, V v2) {
            h();
            return l().set(i10, v2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            h();
            return AbstractMapBasedMultimap.this.wrapList(g(), l().subList(i10, i11), c() == null ? this : c());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            h();
            return new a(i10);
        }
    }
}
