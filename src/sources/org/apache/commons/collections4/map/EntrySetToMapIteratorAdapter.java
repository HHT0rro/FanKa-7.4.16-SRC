package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    public transient Map.Entry<K, V> entry;
    public Set<Map.Entry<K, V>> entrySet;
    public transient Iterator<Map.Entry<K, V>> iterator;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> set) {
        this.entrySet = set;
        reset();
    }

    public synchronized Map.Entry<K, V> current() {
        Map.Entry<K, V> entry;
        entry = this.entry;
        if (entry == null) {
            throw new IllegalStateException();
        }
        return entry;
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        return current().getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return current().getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        this.entry = this.iterator.next();
        return getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
        this.entry = null;
    }

    public synchronized void reset() {
        this.iterator = this.entrySet.iterator2();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v2) {
        return current().setValue(v2);
    }
}
