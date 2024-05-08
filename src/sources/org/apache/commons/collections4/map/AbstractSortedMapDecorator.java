package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        public SortedMapIterator(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) this.iterator).hasPrevious();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            this.entry = (Map.Entry) ((ListIterator) this.iterator).previous();
            return getKey();
        }

        @Override // org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter, org.apache.commons.collections4.ResettableIterator
        public synchronized void reset() {
            super.reset();
            this.iterator = new ListIteratorWrapper(this.iterator);
        }
    }

    public AbstractSortedMapDecorator() {
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    public SortedMap<K, V> headMap(K k10) {
        return decorated().headMap(k10);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    public K nextKey(K k10) {
        Iterator<K> iterator2 = tailMap(k10).h().iterator2();
        iterator2.next();
        if (iterator2.hasNext()) {
            return iterator2.next();
        }
        return null;
    }

    public K previousKey(K k10) {
        SortedMap<K, V> headMap = headMap(k10);
        if (headMap.isEmpty()) {
            return null;
        }
        return headMap.lastKey();
    }

    public SortedMap<K, V> subMap(K k10, K k11) {
        return decorated().subMap(k10, k11);
    }

    public SortedMap<K, V> tailMap(K k10) {
        return decorated().tailMap(k10);
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public SortedMap<K, V> decorated() {
        return (SortedMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SortedMapIterator(entrySet());
    }
}
