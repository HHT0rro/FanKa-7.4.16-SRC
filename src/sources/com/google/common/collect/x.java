package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ForwardingMultimap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class x<K, V> extends z implements j0<K, V> {
    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.j0
    public boolean containsEntry(Object obj, Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j0
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // com.google.common.collect.j0
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.z
    public abstract j0<K, V> delegate();

    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // com.google.common.collect.j0
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public Collection<V> get(K k10) {
        return delegate().get(k10);
    }

    @Override // com.google.common.collect.j0
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.j0
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public k0<K> keys() {
        return delegate().keys();
    }

    public boolean put(K k10, V v2) {
        return delegate().put(k10, v2);
    }

    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        return delegate().putAll(k10, iterable);
    }

    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    public Collection<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k10, iterable);
    }

    @Override // com.google.common.collect.j0
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public boolean putAll(j0<? extends K, ? extends V> j0Var) {
        return delegate().putAll(j0Var);
    }
}
