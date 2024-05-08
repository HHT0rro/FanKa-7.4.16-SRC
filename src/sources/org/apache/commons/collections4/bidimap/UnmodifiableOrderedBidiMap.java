package org.apache.commons.collections4.bidimap;

import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnmodifiableOrderedBidiMap<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements Unmodifiable {
    private UnmodifiableOrderedBidiMap<V, K> inverse;

    private UnmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> orderedBidiMap) {
        super(orderedBidiMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> OrderedBidiMap<K, V> unmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> orderedBidiMap) {
        return orderedBidiMap instanceof Unmodifiable ? orderedBidiMap : new UnmodifiableOrderedBidiMap(orderedBidiMap);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        if (this.inverse == null) {
            UnmodifiableOrderedBidiMap<V, K> unmodifiableOrderedBidiMap = new UnmodifiableOrderedBidiMap<>(decorated().inverseBidiMap());
            this.inverse = unmodifiableOrderedBidiMap;
            unmodifiableOrderedBidiMap.inverse = this;
        }
        return this.inverse;
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

    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.BidiMap
    public OrderedBidiMap<V, K> inverseBidiMap() {
        return inverseOrderedBidiMap();
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractOrderedBidiMapDecorator, org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(decorated().mapIterator());
    }

    @Override // org.apache.commons.collections4.bidimap.AbstractBidiMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<V> values() {
        return UnmodifiableSet.unmodifiableSet(super.values());
    }
}
