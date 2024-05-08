package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.common.collect.k0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Multimaps {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        public transient com.google.common.base.t<? extends List<V>> factory;

        public CustomListMultimap(Map<K, Collection<V>> map, com.google.common.base.t<? extends List<V>> tVar) {
            super(map);
            this.factory = (com.google.common.base.t) com.google.common.base.o.r(tVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.t) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;
        public transient com.google.common.base.t<? extends Collection<V>> factory;

        public CustomMultimap(Map<K, Collection<V>> map, com.google.common.base.t<? extends Collection<V>> tVar) {
            super(map);
            this.factory = (com.google.common.base.t) com.google.common.base.o.r(tVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.t) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.j((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            if (collection instanceof List) {
                return Collections.unmodifiableList((List) collection);
            }
            return Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k10, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(k10, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k10, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k10, (SortedSet) collection, null);
            }
            if (collection instanceof Set) {
                return new AbstractMapBasedMultimap.n(k10, (Set) collection);
            }
            return new AbstractMapBasedMultimap.k(k10, collection, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        public transient com.google.common.base.t<? extends Set<V>> factory;

        public CustomSetMultimap(Map<K, Collection<V>> map, com.google.common.base.t<? extends Set<V>> tVar) {
            super(map);
            this.factory = (com.google.common.base.t) com.google.common.base.o.r(tVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.t) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.j((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Collection<V> wrapCollection(K k10, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.m(k10, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.o(k10, (SortedSet) collection, null);
            }
            return new AbstractMapBasedMultimap.n(k10, (Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MapMultimap<K, V> extends com.google.common.collect.c<K, V> implements w0<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        public final Map<K, V> map;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends Sets.b<V> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f26441b;

            /* renamed from: com.google.common.collect.Multimaps$MapMultimap$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0228a implements Iterator<V> {

                /* renamed from: b, reason: collision with root package name */
                public int f26443b;

                public C0228a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f26443b == 0) {
                        a aVar = a.this;
                        if (MapMultimap.this.map.containsKey(aVar.f26441b)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public V next() {
                    if (hasNext()) {
                        this.f26443b++;
                        a aVar = a.this;
                        return (V) l0.a(MapMultimap.this.map.get(aVar.f26441b));
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public void remove() {
                    m.e(this.f26443b == 1);
                    this.f26443b = -1;
                    a aVar = a.this;
                    MapMultimap.this.map.remove(aVar.f26441b);
                }
            }

            public a(Object obj) {
                this.f26441b = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<V> iterator2() {
                return new C0228a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapMultimap.this.map.containsKey(this.f26441b) ? 1 : 0;
            }
        }

        public MapMultimap(Map<K, V> map) {
            this.map = (Map) com.google.common.base.o.r(map);
        }

        @Override // com.google.common.collect.j0
        public void clear() {
            this.map.clear();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean containsEntry(Object obj, Object obj2) {
            return this.map.entrySet().contains(Maps.j(obj, obj2));
        }

        @Override // com.google.common.collect.j0
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.c
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError((Object) "unreachable");
        }

        @Override // com.google.common.collect.c
        public Set<K> createKeySet() {
            return this.map.h();
        }

        @Override // com.google.common.collect.c
        public k0<K> createKeys() {
            return new c(this);
        }

        @Override // com.google.common.collect.c
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // com.google.common.collect.c
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator2();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((MapMultimap<K, V>) obj);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean put(K k10, V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean putAll(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean remove(Object obj, Object obj2) {
            return this.map.entrySet().remove(Maps.j(obj, obj2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((MapMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.j0
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // com.google.common.collect.j0
        public Set<V> get(K k10) {
            return new a(k10);
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public boolean putAll(j0<? extends K, ? extends V> j0Var) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j0
        public Set<V> removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.c, com.google.common.collect.j0
        public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements i0<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableListMultimap(i0<K, V> i0Var) {
            super(i0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public List<V> get(K k10) {
            return Collections.unmodifiableList(delegate().get((i0<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public List<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.z
        public i0<K, V> delegate() {
            return (i0) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableMultimap<K, V> extends x<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        public final j0<K, V> delegate;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient k0<K> keys;
        public transient Map<K, Collection<V>> map;
        public transient Collection<V> values;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements com.google.common.base.g<Collection<V>, Collection<V>> {
            public a(UnmodifiableMultimap unmodifiableMultimap) {
            }

            @Override // com.google.common.base.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<V> apply(Collection<V> collection) {
                return Multimaps.f(collection);
            }
        }

        public UnmodifiableMultimap(j0<K, V> j0Var) {
            this.delegate = (j0) com.google.common.base.o.r(j0Var);
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.map;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.D(this.delegate.asMap(), new a(this)));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> e2 = Multimaps.e(this.delegate.entries());
            this.entries = e2;
            return e2;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Collection<V> get(K k10) {
            return Multimaps.f(this.delegate.get(k10));
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public k0<K> keys() {
            k0<K> k0Var = this.keys;
            if (k0Var != null) {
                return k0Var;
            }
            k0<K> o10 = Multisets.o(this.delegate.keys());
            this.keys = o10;
            return o10;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public boolean put(K k10, V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public boolean putAll(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Collection<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.z
        public j0<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.x, com.google.common.collect.j0
        public boolean putAll(j0<? extends K, ? extends V> j0Var) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements w0<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSetMultimap(w0<K, V> w0Var) {
            super(w0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public Set<Map.Entry<K, V>> entries() {
            return Maps.H(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public Set<V> get(K k10) {
            return Collections.unmodifiableSet(delegate().get((w0<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public Set<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.z
        public w0<K, V> delegate() {
            return (w0) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements c1<K, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableSortedSetMultimap(c1<K, V> c1Var) {
            super(c1Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.c1
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((UnmodifiableSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((UnmodifiableSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public SortedSet<V> get(K k10) {
            return Collections.unmodifiableSortedSet(delegate().get((c1<K, V>) k10));
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public SortedSet<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.j0
        public SortedSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.x, com.google.common.collect.z
        public c1<K, V> delegate() {
            return (c1) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<K, V> extends Maps.u<K, Collection<V>> {

        /* renamed from: e, reason: collision with root package name */
        public final j0<K, V> f26445e;

        /* renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0229a extends Maps.j<K, Collection<V>> {

            /* renamed from: com.google.common.collect.Multimaps$a$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0230a implements com.google.common.base.g<K, Collection<V>> {
                public C0230a() {
                }

                @Override // com.google.common.base.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Collection<V> apply(K k10) {
                    return a.this.f26445e.get(k10);
                }
            }

            public C0229a() {
            }

            @Override // com.google.common.collect.Maps.j
            public Map<K, Collection<V>> b() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, Collection<V>>> iterator2() {
                return Maps.d(a.this.f26445e.keySet(), new C0230a());
            }

            @Override // com.google.common.collect.Maps.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.g(entry.getKey());
                return true;
            }
        }

        public a(j0<K, V> j0Var) {
            this.f26445e = (j0) com.google.common.base.o.r(j0Var);
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0229a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f26445e.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f26445e.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.f26445e.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.f26445e.removeAll(obj);
            }
            return null;
        }

        public void g(Object obj) {
            this.f26445e.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f26445e.isEmpty();
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return this.f26445e.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26445e.keySet().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract j0<K, V> b();

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
            return b().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c<K, V> extends d<K> {

        /* renamed from: b, reason: collision with root package name */
        public final j0<K, V> f26448b;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends f1<Map.Entry<K, Collection<V>>, k0.a<K>> {

            /* renamed from: com.google.common.collect.Multimaps$c$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0231a extends Multisets.b<K> {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f26449b;

                public C0231a(a aVar, Map.Entry entry) {
                    this.f26449b = entry;
                }

                @Override // com.google.common.collect.k0.a
                public int getCount() {
                    return ((Collection) this.f26449b.getValue()).size();
                }

                @Override // com.google.common.collect.k0.a
                public K getElement() {
                    return (K) this.f26449b.getKey();
                }
            }

            public a(c cVar, Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.f1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public k0.a<K> a(Map.Entry<K, Collection<V>> entry) {
                return new C0231a(this, entry);
            }
        }

        public c(j0<K, V> j0Var) {
            this.f26448b = j0Var;
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f26448b.clear();
        }

        @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f26448b.containsKey(obj);
        }

        @Override // com.google.common.collect.k0
        public int count(Object obj) {
            Collection collection = (Collection) Maps.x(this.f26448b.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.d
        public int distinctElements() {
            return this.f26448b.asMap().size();
        }

        @Override // com.google.common.collect.d
        public Iterator<K> elementIterator() {
            throw new AssertionError((Object) "should never be called");
        }

        @Override // com.google.common.collect.d, com.google.common.collect.k0
        public Set<K> elementSet() {
            return this.f26448b.keySet();
        }

        @Override // com.google.common.collect.d
        public Iterator<k0.a<K>> entryIterator() {
            return new a(this, this.f26448b.asMap().entrySet().iterator2());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return Maps.m(this.f26448b.entries().iterator2());
        }

        @Override // com.google.common.collect.d, com.google.common.collect.k0
        public int remove(Object obj, int i10) {
            m.b(i10, "occurrences");
            if (i10 == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.x(this.f26448b.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i10 >= size) {
                collection.clear();
            } else {
                Iterator iterator2 = collection.iterator2();
                for (int i11 = 0; i11 < i10; i11++) {
                    iterator2.next();
                    iterator2.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f26448b.size();
        }
    }

    public static boolean c(j0<?, ?> j0Var, Object obj) {
        if (obj == j0Var) {
            return true;
        }
        if (obj instanceof j0) {
            return j0Var.asMap().equals(((j0) obj).asMap());
        }
        return false;
    }

    public static <K, V> i0<K, V> d(Map<K, Collection<V>> map, com.google.common.base.t<? extends List<V>> tVar) {
        return new CustomListMultimap(map, tVar);
    }

    public static <K, V> Collection<Map.Entry<K, V>> e(Collection<Map.Entry<K, V>> collection) {
        if (collection instanceof Set) {
            return Maps.H((Set) collection);
        }
        return new Maps.r(Collections.unmodifiableCollection(collection));
    }

    public static <V> Collection<V> f(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List) collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        public transient com.google.common.base.t<? extends SortedSet<V>> factory;
        public transient Comparator<? super V> valueComparator;

        public CustomSortedSetMultimap(Map<K, Collection<V>> map, com.google.common.base.t<? extends SortedSet<V>> tVar) {
            super(map);
            this.factory = (com.google.common.base.t) com.google.common.base.o.r(tVar);
            this.valueComparator = tVar.get().comparator();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            com.google.common.base.t<? extends SortedSet<V>> tVar = (com.google.common.base.t) objectInputStream.readObject();
            this.factory = tVar;
            this.valueComparator = tVar.get().comparator();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.c1
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }
}
