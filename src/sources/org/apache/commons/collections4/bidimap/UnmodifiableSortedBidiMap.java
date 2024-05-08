package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.SortedBidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnmodifiableSortedBidiMap<K, V> extends AbstractSortedBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableSortedBidiMap<V, K> inverse;

    private UnmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> sortedBidiMap) {
        super(sortedBidiMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> SortedBidiMap<K, V> unmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> sortedBidiMap) {
        return sortedBidiMap instanceof Unmodifiable ? sortedBidiMap : new UnmodifiableSortedBidiMap(sortedBidiMap);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k10) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().headMap(k10));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return UnmodifiableSet.unmodifiableSet(super.h());
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k10, K k11) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().subMap(k10, k11));
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractSortedBidiMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k10) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(decorated().tailMap(k10));
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(decorated().mapIterator());
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<V> values() {
        return UnmodifiableSet.unmodifiableSet(super.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.bidimap.AbstractSortedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public SortedBidiMap<V, K> inverseBidiMap() {
        if (this.inverse == null) {
            UnmodifiableSortedBidiMap<V, K> unmodifiableSortedBidiMap = new UnmodifiableSortedBidiMap<>(decorated().inverseBidiMap());
            this.inverse = unmodifiableSortedBidiMap;
            unmodifiableSortedBidiMap.inverse = this;
        }
        return this.inverse;
    }
}
