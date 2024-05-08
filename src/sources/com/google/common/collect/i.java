package com.google.common.collect;

import com.google.common.collect.d1;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: AbstractTable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class i<R, C, V> implements d1<R, C, V> {
    private transient Set<d1.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    /* compiled from: AbstractTable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends f1<d1.a<R, C, V>, V> {
        public a(i iVar, Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.f1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(d1.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* compiled from: AbstractTable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractSet<d1.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof d1.a)) {
                return false;
            }
            d1.a aVar = (d1.a) obj;
            Map map = (Map) Maps.x(i.this.rowMap(), aVar.getRowKey());
            return map != null && n.c(map.entrySet(), Maps.j(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<d1.a<R, C, V>> iterator2() {
            return i.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof d1.a)) {
                return false;
            }
            d1.a aVar = (d1.a) obj;
            Map map = (Map) Maps.x(i.this.rowMap(), aVar.getRowKey());
            return map != null && n.d(map.entrySet(), Maps.j(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    /* compiled from: AbstractTable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return i.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    public abstract Iterator<d1.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.d1
    public Set<d1.a<R, C, V>> cellSet() {
        Set<d1.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<d1.a<R, C, V>> createCellSet = createCellSet();
        this.cellSet = createCellSet;
        return createCellSet;
    }

    @Override // com.google.common.collect.d1
    public void clear() {
        Iterators.d(cellSet().iterator2());
    }

    @Override // com.google.common.collect.d1
    public Set<C> columnKeySet() {
        return columnMap().h();
    }

    @Override // com.google.common.collect.d1
    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        return map != null && Maps.w(map, obj2);
    }

    @Override // com.google.common.collect.d1
    public boolean containsColumn(Object obj) {
        return Maps.w(columnMap(), obj);
    }

    @Override // com.google.common.collect.d1
    public boolean containsRow(Object obj) {
        return Maps.w(rowMap(), obj);
    }

    @Override // com.google.common.collect.d1
    public boolean containsValue(Object obj) {
        Iterator<Map<C, V>> iterator2 = rowMap().values().iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<d1.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    @Override // com.google.common.collect.d1
    public boolean equals(Object obj) {
        return Tables.b(this, obj);
    }

    @Override // com.google.common.collect.d1
    public V get(Object obj, Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.x(map, obj2);
    }

    @Override // com.google.common.collect.d1
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // com.google.common.collect.d1
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.d1
    public V put(R r10, C c4, V v2) {
        return row(r10).put(c4, v2);
    }

    @Override // com.google.common.collect.d1
    public void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
        for (d1.a<? extends R, ? extends C, ? extends V> aVar : d1Var.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    @Override // com.google.common.collect.d1
    public V remove(Object obj, Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.y(map, obj2);
    }

    @Override // com.google.common.collect.d1
    public Set<R> rowKeySet() {
        return rowMap().h();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // com.google.common.collect.d1
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new a(this, cellSet().iterator2());
    }
}
