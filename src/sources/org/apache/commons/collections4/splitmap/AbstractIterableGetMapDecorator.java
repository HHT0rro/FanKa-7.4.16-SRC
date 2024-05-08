package org.apache.commons.collections4.splitmap;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AbstractIterableGetMapDecorator<K, V> implements IterableGet<K, V> {
    public transient Map<K, V> map;

    public AbstractIterableGetMapDecorator(Map<K, V> map) {
        Objects.requireNonNull(map, "Map must not be null.");
        this.map = map;
    }

    @Override // org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    @Override // org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    public Map<K, V> decorated() {
        return this.map;
    }

    @Override // org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.Get
    public V get(Object obj) {
        return decorated().get(obj);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return decorated().h();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }

    @Override // org.apache.commons.collections4.Get
    public V remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // org.apache.commons.collections4.Get
    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    @Override // org.apache.commons.collections4.Get
    public Collection<V> values() {
        return decorated().values();
    }

    public AbstractIterableGetMapDecorator() {
    }
}
