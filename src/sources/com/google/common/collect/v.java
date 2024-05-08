package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: ForwardingMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class v<K, V> extends z implements Map<K, V> {
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.z
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    /* renamed from: keySet */
    public Set<K> h() {
        return delegate().h();
    }

    public V put(K k10, V v2) {
        return delegate().put(k10, v2);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.d(entrySet().iterator2());
    }

    public boolean standardContainsKey(Object obj) {
        return Maps.g(this, obj);
    }

    public boolean standardContainsValue(Object obj) {
        return Maps.h(this, obj);
    }

    public boolean standardEquals(Object obj) {
        return Maps.i(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator2().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.u(this, map);
    }

    public V standardRemove(Object obj) {
        Iterator<Map.Entry<K, V>> iterator2 = entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<K, V> next = iterator2.next();
            if (com.google.common.base.l.a(next.getKey(), obj)) {
                V value = next.getValue();
                iterator2.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return Maps.z(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
