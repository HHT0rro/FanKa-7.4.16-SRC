package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractMultimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c<K, V> implements j0<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient k0<K> keys;
    private transient Collection<V> values;

    /* compiled from: AbstractMultimap.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends Multimaps.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        public j0<K, V> b() {
            return c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return c.this.entryIterator();
        }
    }

    /* compiled from: AbstractMultimap.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        public b(c cVar) {
            super();
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

    /* compiled from: AbstractMultimap.java */
    /* renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class C0237c extends AbstractCollection<V> {
        public C0237c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return c.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.size();
        }
    }

    @Override // com.google.common.collect.j0
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    @Override // com.google.common.collect.j0
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.google.common.collect.j0
    public boolean containsValue(Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract k0<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // com.google.common.collect.j0
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> createEntries = createEntries();
        this.entries = createEntries;
        return createEntries;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // com.google.common.collect.j0
    public boolean equals(Object obj) {
        return Multimaps.c(this, obj);
    }

    @Override // com.google.common.collect.j0
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.j0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.j0
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    @Override // com.google.common.collect.j0
    public k0<K> keys() {
        k0<K> k0Var = this.keys;
        if (k0Var != null) {
            return k0Var;
        }
        k0<K> createKeys = createKeys();
        this.keys = createKeys;
        return createKeys;
    }

    @Override // com.google.common.collect.j0
    public boolean put(K k10, V v2) {
        return get(k10).add(v2);
    }

    @Override // com.google.common.collect.j0
    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        com.google.common.base.o.r(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k10).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k10), it);
    }

    @Override // com.google.common.collect.j0
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // com.google.common.collect.j0
    public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        com.google.common.base.o.r(iterable);
        Collection<V> removeAll = removeAll(k10);
        putAll(k10, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.L(entries().iterator());
    }

    @Override // com.google.common.collect.j0
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    @Override // com.google.common.collect.j0
    public boolean putAll(j0<? extends K, ? extends V> j0Var) {
        boolean z10 = false;
        for (Map.Entry<? extends K, ? extends V> entry : j0Var.entries()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }
}
