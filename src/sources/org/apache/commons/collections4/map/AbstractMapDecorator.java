package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractMapDecorator<K, V> extends AbstractIterableMap<K, V> {
    public transient Map<K, V> map;

    public AbstractMapDecorator() {
    }

    @Override // java.util.Map
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    public Map<K, V> decorated() {
        return this.map;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return decorated().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return decorated().h();
    }

    @Override // java.util.Map
    public V put(K k10, V v2) {
        return decorated().put(k10, v2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return decorated().values();
    }

    public AbstractMapDecorator(Map<K, V> map) {
        Objects.requireNonNull(map, "Map must not be null.");
        this.map = map;
    }
}
