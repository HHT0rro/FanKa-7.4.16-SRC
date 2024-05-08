package com.google.common.collect;

import com.google.common.collect.d1;
import com.google.common.collect.k0;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Synchronized {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        public transient Collection<Collection<V>> asMapValues;

        public SynchronizedAsMap(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                }
                set = this.asMapEntrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.asMapValues == null) {
                    this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                }
                collection = this.asMapValues;
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> q10;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                q10 = collection == null ? null : Synchronized.q(collection, this.mutex);
            }
            return q10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends f1<Collection<V>, Collection<V>> {
            public a(Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.f1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<V> a(Collection<V> collection) {
                return Synchronized.q(collection, SynchronizedAsMapValues.this.mutex);
            }
        }

        public SynchronizedAsMapValues(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Collection<V>> iterator2() {
            return new a(super.iterator2());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements k<K, V> {
        private static final long serialVersionUID = 0;
        private transient k<V, K> inverse;
        private transient Set<V> valueSet;

        @Override // com.google.common.collect.k
        public V forcePut(K k10, V v2) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k10, v2);
            }
            return forcePut;
        }

        @Override // com.google.common.collect.k
        public k<V, K> inverse() {
            k<V, K> kVar;
            synchronized (this.mutex) {
                if (this.inverse == null) {
                    this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                }
                kVar = this.inverse;
            }
            return kVar;
        }

        private SynchronizedBiMap(k<K, V> kVar, Object obj, k<V, K> kVar2) {
            super(kVar, obj);
            this.inverse = kVar2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                if (this.valueSet == null) {
                    this.valueSet = Synchronized.n(delegate().values(), this.mutex);
                }
                set = this.valueSet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public k<K, V> delegate() {
            return (k) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e2) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e2);
            }
            return add;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return delegate().iterator2();
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v2);
            }
            return value;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedList(List<E> list, Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i10, E e2) {
            synchronized (this.mutex) {
                delegate().add(i10, e2);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i10, collection);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.List
        public E get(int i10) {
            E e2;
            synchronized (this.mutex) {
                e2 = delegate().get(i10);
            }
            return e2;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int i10) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i10);
            }
            return remove;
        }

        @Override // java.util.List
        public E set(int i10, E e2) {
            E e10;
            synchronized (this.mutex) {
                e10 = delegate().set(i10, e2);
            }
            return e10;
        }

        @Override // java.util.List
        public List<E> subList(int i10, int i11) {
            List<E> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(delegate().subList(i10, i11), this.mutex);
            }
            return h10;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int i10) {
            return delegate().listIterator(i10);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements i0<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedListMultimap(i0<K, V> i0Var, Object obj) {
            super(i0Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedListMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedListMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public List<V> get(K k10) {
            List<V> h10;
            synchronized (this.mutex) {
                h10 = Synchronized.h(delegate().get((i0<K, V>) k10), this.mutex);
            }
            return h10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((i0<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public i0<K, V> delegate() {
            return (i0) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, V>> entrySet;
        public transient Set<K> keySet;
        public transient Collection<V> values;

        public SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public V get(Object obj) {
            V v2;
            synchronized (this.mutex) {
                v2 = delegate().get(obj);
            }
            return v2;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.n(delegate().h(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // java.util.Map
        public V put(K k10, V v2) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k10, v2);
            }
            return put;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements j0<K, V> {
        private static final long serialVersionUID = 0;
        public transient Map<K, Collection<V>> asMap;
        public transient Collection<Map.Entry<K, V>> entries;
        public transient Set<K> keySet;
        public transient k0<K> keys;
        public transient Collection<V> valuesCollection;

        public SynchronizedMultimap(j0<K, V> j0Var, Object obj) {
            super(j0Var, obj);
        }

        @Override // com.google.common.collect.j0
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.asMap == null) {
                    this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                }
                map = this.asMap;
            }
            return map;
        }

        @Override // com.google.common.collect.j0
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.j0
        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        @Override // com.google.common.collect.j0
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        @Override // com.google.common.collect.j0
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.j0
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.entries == null) {
                    this.entries = Synchronized.q(delegate().entries(), this.mutex);
                }
                collection = this.entries;
            }
            return collection;
        }

        @Override // com.google.common.collect.j0
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public Collection<V> get(K k10) {
            Collection<V> q10;
            synchronized (this.mutex) {
                q10 = Synchronized.q(delegate().get(k10), this.mutex);
            }
            return q10;
        }

        @Override // com.google.common.collect.j0
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.j0
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.j0
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.r(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // com.google.common.collect.j0
        public k0<K> keys() {
            k0<K> k0Var;
            synchronized (this.mutex) {
                if (this.keys == null) {
                    this.keys = Synchronized.j(delegate().keys(), this.mutex);
                }
                k0Var = this.keys;
            }
            return k0Var;
        }

        @Override // com.google.common.collect.j0
        public boolean put(K k10, V v2) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k10, v2);
            }
            return put;
        }

        @Override // com.google.common.collect.j0
        public boolean putAll(K k10, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k10, iterable);
            }
            return putAll;
        }

        @Override // com.google.common.collect.j0
        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k10, iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.j0
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.j0
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = Synchronized.g(delegate().values(), this.mutex);
                }
                collection = this.valuesCollection;
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public j0<K, V> delegate() {
            return (j0) super.delegate();
        }

        @Override // com.google.common.collect.j0
        public boolean putAll(j0<? extends K, ? extends V> j0Var) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(j0Var);
            }
            return putAll;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object delegate;
        public final Object mutex;

        public SynchronizedObject(Object obj, Object obj2) {
            this.delegate = com.google.common.base.o.r(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }

        Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        public SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements w0<K, V> {
        private static final long serialVersionUID = 0;
        public transient Set<Map.Entry<K, V>> entrySet;

        public SynchronizedSetMultimap(w0<K, V> w0Var, Object obj) {
            super(w0Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.n(delegate().entries(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public Set<V> get(K k10) {
            Set<V> n10;
            synchronized (this.mutex) {
                n10 = Synchronized.n(delegate().get((w0<K, V>) k10), this.mutex);
            }
            return n10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((w0<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public w0<K, V> delegate() {
            return (w0) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements c1<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSetMultimap(c1<K, V> c1Var, Object obj) {
            super(c1Var, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.c1
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Set get(Object obj) {
            return get((SynchronizedSortedSetMultimap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
            return replaceValues((SynchronizedSortedSetMultimap<K, V>) obj, iterable);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public SortedSet<V> get(K k10) {
            SortedSet<V> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().get((c1<K, V>) k10), this.mutex);
            }
            return p10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.j0
        public SortedSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((c1<K, V>) k10, (Iterable) iterable);
            }
            return replaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public c1<K, V> delegate() {
            return (c1) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements d1<R, C, V> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements com.google.common.base.g<Map<C, V>, Map<C, V>> {
            public a() {
            }

            @Override // com.google.common.base.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V> apply(Map<C, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b implements com.google.common.base.g<Map<R, V>, Map<R, V>> {
            public b() {
            }

            @Override // com.google.common.base.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V> apply(Map<R, V> map) {
                return Synchronized.i(map, SynchronizedTable.this.mutex);
            }
        }

        public SynchronizedTable(d1<R, C, V> d1Var, Object obj) {
            super(d1Var, obj);
        }

        @Override // com.google.common.collect.d1
        public Set<d1.a<R, C, V>> cellSet() {
            Set<d1.a<R, C, V>> n10;
            synchronized (this.mutex) {
                n10 = Synchronized.n(delegate().cellSet(), this.mutex);
            }
            return n10;
        }

        @Override // com.google.common.collect.d1
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.d1
        public Map<R, V> column(C c4) {
            Map<R, V> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(delegate().column(c4), this.mutex);
            }
            return i10;
        }

        @Override // com.google.common.collect.d1
        public Set<C> columnKeySet() {
            Set<C> n10;
            synchronized (this.mutex) {
                n10 = Synchronized.n(delegate().columnKeySet(), this.mutex);
            }
            return n10;
        }

        @Override // com.google.common.collect.d1
        public Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(Maps.D(delegate().columnMap(), new b()), this.mutex);
            }
            return i10;
        }

        @Override // com.google.common.collect.d1
        public boolean contains(Object obj, Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        @Override // com.google.common.collect.d1
        public boolean containsColumn(Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        @Override // com.google.common.collect.d1
        public boolean containsRow(Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        @Override // com.google.common.collect.d1
        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        @Override // com.google.common.collect.d1
        public boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // com.google.common.collect.d1
        public V get(Object obj, Object obj2) {
            V v2;
            synchronized (this.mutex) {
                v2 = delegate().get(obj, obj2);
            }
            return v2;
        }

        @Override // com.google.common.collect.d1
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.d1
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        @Override // com.google.common.collect.d1
        public V put(R r10, C c4, V v2) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r10, c4, v2);
            }
            return put;
        }

        @Override // com.google.common.collect.d1
        public void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
            synchronized (this.mutex) {
                delegate().putAll(d1Var);
            }
        }

        @Override // com.google.common.collect.d1
        public V remove(Object obj, Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        @Override // com.google.common.collect.d1
        public Map<C, V> row(R r10) {
            Map<C, V> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(delegate().row(r10), this.mutex);
            }
            return i10;
        }

        @Override // com.google.common.collect.d1
        public Set<R> rowKeySet() {
            Set<R> n10;
            synchronized (this.mutex) {
                n10 = Synchronized.n(delegate().rowKeySet(), this.mutex);
            }
            return n10;
        }

        @Override // com.google.common.collect.d1
        public Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> i10;
            synchronized (this.mutex) {
                i10 = Synchronized.i(Maps.D(delegate().rowMap(), new a()), this.mutex);
            }
            return i10;
        }

        @Override // com.google.common.collect.d1
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.d1
        public Collection<V> values() {
            Collection<V> g3;
            synchronized (this.mutex) {
                g3 = Synchronized.g(delegate().values(), this.mutex);
            }
            return g3;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        public d1<R, C, V> delegate() {
            return (d1) super.delegate();
        }
    }

    public static <E> Collection<E> g(Collection<E> collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    public static <E> List<E> h(List<E> list, Object obj) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list, obj);
        }
        return new SynchronizedList(list, obj);
    }

    public static <K, V> Map<K, V> i(Map<K, V> map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    public static <E> k0<E> j(k0<E> k0Var, Object obj) {
        return ((k0Var instanceof SynchronizedMultiset) || (k0Var instanceof ImmutableMultiset)) ? k0Var : new SynchronizedMultiset(k0Var, obj);
    }

    public static <K, V> NavigableMap<K, V> k(NavigableMap<K, V> navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    public static <E> NavigableSet<E> l(NavigableSet<E> navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    public static <K, V> Map.Entry<K, V> m(Map.Entry<K, V> entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    public static <E> Set<E> n(Set<E> set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    public static <K, V> SortedMap<K, V> o(SortedMap<K, V> sortedMap, Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    public static <E> SortedSet<E> p(SortedSet<E> sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    public static <E> Collection<E> q(Collection<E> collection, Object obj) {
        if (collection instanceof SortedSet) {
            return p((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return n((Set) collection, obj);
        }
        if (collection instanceof List) {
            return h((List) collection, obj);
        }
        return g(collection, obj);
    }

    public static <E> Set<E> r(Set<E> set, Object obj) {
        if (set instanceof SortedSet) {
            return p((SortedSet) set, obj);
        }
        return n(set, obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements k0<E> {
        private static final long serialVersionUID = 0;
        public transient Set<E> elementSet;
        public transient Set<k0.a<E>> entrySet;

        public SynchronizedMultiset(k0<E> k0Var, Object obj) {
            super(k0Var, obj);
        }

        @Override // com.google.common.collect.k0
        public int add(E e2, int i10) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e2, i10);
            }
            return add;
        }

        @Override // com.google.common.collect.k0
        public int count(Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        @Override // com.google.common.collect.k0
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                if (this.elementSet == null) {
                    this.elementSet = Synchronized.r(delegate().elementSet(), this.mutex);
                }
                set = this.elementSet;
            }
            return set;
        }

        @Override // com.google.common.collect.k0
        public Set<k0.a<E>> entrySet() {
            Set<k0.a<E>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.r(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        @Override // com.google.common.collect.k0
        public int remove(Object obj, int i10) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i10);
            }
            return remove;
        }

        @Override // com.google.common.collect.k0
        public int setCount(E e2, int i10) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e2, i10);
            }
            return count;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public k0<E> delegate() {
            return (k0) super.delegate();
        }

        @Override // com.google.common.collect.k0
        public boolean setCount(E e2, int i10, int i11) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e2, i10, i11);
            }
            return count;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedQueue(Queue<E> queue, Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e2) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e2);
            }
            return offer;
        }

        @Override // java.util.Queue
        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        @Override // java.util.Queue
        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        @Override // java.util.Queue
        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k10) {
            SortedMap<K, V> o10;
            synchronized (this.mutex) {
                o10 = Synchronized.o(delegate().headMap(k10), this.mutex);
            }
            return o10;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k10, K k11) {
            SortedMap<K, V> o10;
            synchronized (this.mutex) {
                o10 = Synchronized.o(delegate().subMap(k10, k11), this.mutex);
            }
            return o10;
        }

        public SortedMap<K, V> tailMap(K k10) {
            SortedMap<K, V> o10;
            synchronized (this.mutex) {
                o10 = Synchronized.o(delegate().tailMap(k10), this.mutex);
            }
            return o10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedDeque(Deque<E> deque, Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(E e2) {
            synchronized (this.mutex) {
                delegate().addFirst(e2);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e2) {
            synchronized (this.mutex) {
                delegate().addLast(e2);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e2) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e2);
            }
            return offerFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e2) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e2);
            }
            return offerLast;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        @Override // java.util.Deque
        public E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.Deque
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        @Override // java.util.Deque
        public void push(E e2) {
            synchronized (this.mutex) {
                delegate().push(e2);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        public transient NavigableSet<K> descendingKeySet;
        public transient NavigableMap<K, V> descendingMap;
        public transient NavigableSet<K> navigableKeySet;

        public SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().ceilingEntry(k10), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k10);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.descendingKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> l10 = Synchronized.l(delegate().descendingKeySet(), this.mutex);
                this.descendingKeySet = l10;
                return l10;
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                NavigableMap<K, V> navigableMap = this.descendingMap;
                if (navigableMap != null) {
                    return navigableMap;
                }
                NavigableMap<K, V> k10 = Synchronized.k(delegate().descendingMap(), this.mutex);
                this.descendingMap = k10;
                return k10;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().firstEntry(), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().floorEntry(k10), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k10);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            NavigableMap<K, V> k11;
            synchronized (this.mutex) {
                k11 = Synchronized.k(delegate().headMap(k10, z10), this.mutex);
            }
            return k11;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().higherEntry(k10), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k10);
            }
            return higherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().lastEntry(), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().lowerEntry(k10), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k10);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                NavigableSet<K> navigableSet = this.navigableKeySet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<K> l10 = Synchronized.l(delegate().navigableKeySet(), this.mutex);
                this.navigableKeySet = l10;
                return l10;
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().pollFirstEntry(), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> m10;
            synchronized (this.mutex) {
                m10 = Synchronized.m(delegate().pollLastEntry(), this.mutex);
            }
            return m10;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            NavigableMap<K, V> k12;
            synchronized (this.mutex) {
                k12 = Synchronized.k(delegate().subMap(k10, z10, k11, z11), this.mutex);
            }
            return k12;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            NavigableMap<K, V> k11;
            synchronized (this.mutex) {
                k11 = Synchronized.k(delegate().tailMap(k10, z10), this.mutex);
            }
            return k11;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        public transient NavigableSet<E> descendingSet;

        public SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e2);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                NavigableSet<E> navigableSet = this.descendingSet;
                if (navigableSet != null) {
                    return navigableSet;
                }
                NavigableSet<E> l10 = Synchronized.l(delegate().descendingSet(), this.mutex);
                this.descendingSet = l10;
                return l10;
            }
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e2);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z10) {
            NavigableSet<E> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(delegate().headSet(e2, z10), this.mutex);
            }
            return l10;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e2);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e2);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11) {
            NavigableSet<E> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(delegate().subSet(e2, z10, e10, z11), this.mutex);
            }
            return l10;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z10) {
            NavigableSet<E> l10;
            synchronized (this.mutex) {
                l10 = Synchronized.l(delegate().tailSet(e2, z10), this.mutex);
            }
            return l10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e2) {
            return headSet(e2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e2) {
            return tailSet(e2, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e2, E e10) {
            return subSet(e2, true, e10, false);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        public SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e2) {
            SortedSet<E> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().headSet(e2), this.mutex);
            }
            return p10;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e2, E e10) {
            SortedSet<E> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().subSet(e2, e10), this.mutex);
            }
            return p10;
        }

        public SortedSet<E> tailSet(E e2) {
            SortedSet<E> p10;
            synchronized (this.mutex) {
                p10 = Synchronized.p(delegate().tailSet(e2), this.mutex);
            }
            return p10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends f1<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* renamed from: com.google.common.collect.Synchronized$SynchronizedAsMapEntries$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0236a extends w<K, Collection<V>> {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f26506b;

                public C0236a(Map.Entry entry) {
                    this.f26506b = entry;
                }

                @Override // com.google.common.collect.z
                /* renamed from: o */
                public Map.Entry<K, Collection<V>> delegate() {
                    return this.f26506b;
                }

                @Override // com.google.common.collect.w, java.util.Map.Entry
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public Collection<V> getValue() {
                    return Synchronized.q((Collection) this.f26506b.getValue(), SynchronizedAsMapEntries.this.mutex);
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.f1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
                return new C0236a(entry);
            }
        }

        public SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean f10;
            synchronized (this.mutex) {
                f10 = Maps.f(delegate(), obj);
            }
            return f10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            boolean a10;
            synchronized (this.mutex) {
                a10 = n.a(delegate(), collection);
            }
            return a10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean a10;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                a10 = Sets.a(delegate(), obj);
            }
            return a10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, Collection<V>>> iterator2() {
            return new a(super.iterator2());
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean v2;
            synchronized (this.mutex) {
                v2 = Maps.v(delegate(), obj);
            }
            return v2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean s2;
            synchronized (this.mutex) {
                s2 = Iterators.s(delegate().iterator2(), collection);
            }
            return s2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean t2;
            synchronized (this.mutex) {
                t2 = Iterators.t(delegate().iterator2(), collection);
            }
            return t2;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] f10;
            synchronized (this.mutex) {
                f10 = m0.f(delegate());
            }
            return f10;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) m0.g(delegate(), tArr);
            }
            return tArr2;
        }
    }
}
