package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FixedSizeSortedMap<K, V> extends AbstractSortedMapDecorator<K, V> implements BoundedMap<K, V>, Serializable {
    private static final long serialVersionUID = 3126019624511683653L;

    public FixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        super(sortedMap);
    }

    public static <K, V> FixedSizeSortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return new FixedSizeSortedMap<>(sortedMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableSet.unmodifiableSet(this.map.entrySet());
    }

    public SortedMap<K, V> getSortedMap() {
        return (SortedMap) this.map;
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> headMap(K k10) {
        return new FixedSizeSortedMap(getSortedMap().headMap(k10));
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return true;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return UnmodifiableSet.unmodifiableSet(this.map.h());
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return size();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        if (this.map.containsKey(k10)) {
            return this.map.put(k10, v2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        if (!CollectionUtils.isSubCollection(map.h(), h())) {
            this.map.putAll(map);
            return;
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> subMap(K k10, K k11) {
        return new FixedSizeSortedMap(getSortedMap().subMap(k10, k11));
    }

    @Override // org.apache.commons.collections4.map.AbstractSortedMapDecorator, java.util.SortedMap, java.util.NavigableMap
    public SortedMap<K, V> tailMap(K k10) {
        return new FixedSizeSortedMap(getSortedMap().tailMap(k10));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(this.map.values());
    }
}
