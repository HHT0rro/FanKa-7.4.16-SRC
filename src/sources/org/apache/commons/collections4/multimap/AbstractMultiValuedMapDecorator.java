package org.apache.commons.collections4.multimap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractMultiValuedMapDecorator<K, V> implements MultiValuedMap<K, V>, Serializable {
    private static final long serialVersionUID = 20150612;
    private final MultiValuedMap<K, V> map;

    public AbstractMultiValuedMapDecorator(MultiValuedMap<K, V> multiValuedMap) {
        Objects.requireNonNull(multiValuedMap, "MultiValuedMap must not be null.");
        this.map = multiValuedMap;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        return decorated().asMap();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsMapping(Object obj, Object obj2) {
        return decorated().containsMapping(obj, obj2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    public MultiValuedMap<K, V> decorated() {
        return this.map;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        return decorated().entries();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K k10) {
        return decorated().get(k10);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return decorated().keySet();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        return decorated().keys();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k10, V v2) {
        return decorated().put(k10, v2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        return decorated().putAll(k10, iterable);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object obj, Object obj2) {
        return decorated().removeMapping(obj, obj2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public int size() {
        return decorated().size();
    }

    public String toString() {
        return decorated().toString();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        return decorated().values();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        return decorated().putAll(map);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        return decorated().putAll(multiValuedMap);
    }
}
