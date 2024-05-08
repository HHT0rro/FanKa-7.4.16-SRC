package com.google.common.collect;

import com.google.common.collect.d1;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ForwardingTable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e0<R, C, V> extends z implements d1<R, C, V> {
    public Set<d1.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(C c4) {
        return delegate().column(c4);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.d1
    public boolean contains(Object obj, Object obj2) {
        return delegate().contains(obj, obj2);
    }

    @Override // com.google.common.collect.d1
    public boolean containsColumn(Object obj) {
        return delegate().containsColumn(obj);
    }

    @Override // com.google.common.collect.d1
    public boolean containsRow(Object obj) {
        return delegate().containsRow(obj);
    }

    @Override // com.google.common.collect.d1
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.z
    public abstract d1<R, C, V> delegate();

    @Override // com.google.common.collect.d1
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // com.google.common.collect.d1
    public V get(Object obj, Object obj2) {
        return delegate().get(obj, obj2);
    }

    @Override // com.google.common.collect.d1
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.d1
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public V put(R r10, C c4, V v2) {
        return delegate().put(r10, c4, v2);
    }

    public void putAll(d1<? extends R, ? extends C, ? extends V> d1Var) {
        delegate().putAll(d1Var);
    }

    public V remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public Map<C, V> row(R r10) {
        return delegate().row(r10);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.d1
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
