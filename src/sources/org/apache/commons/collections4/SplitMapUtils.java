package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SplitMapUtils {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class WrappedGet<K, V> implements IterableMap<K, V>, Unmodifiable {
        private final Get<K, V> get;

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.get.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.get.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return UnmodifiableEntrySet.unmodifiableEntrySet(this.get.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedGet) && ((WrappedGet) obj).get.equals(this.get);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.get.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.get.hashCode() | 360074000;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.get.isEmpty();
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return UnmodifiableSet.unmodifiableSet(this.get.keySet());
        }

        @Override // org.apache.commons.collections4.IterableGet
        public MapIterator<K, V> mapIterator() {
            MapIterator<K, V> entrySetToMapIteratorAdapter;
            Get<K, V> get = this.get;
            if (get instanceof IterableGet) {
                entrySetToMapIteratorAdapter = ((IterableGet) get).mapIterator();
            } else {
                entrySetToMapIteratorAdapter = new EntrySetToMapIteratorAdapter(get.entrySet());
            }
            return UnmodifiableMapIterator.unmodifiableMapIterator(entrySetToMapIteratorAdapter);
        }

        @Override // java.util.Map
        public V put(K k10, V v2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            return this.get.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.get.size();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return UnmodifiableCollection.unmodifiableCollection(this.get.values());
        }

        private WrappedGet(Get<K, V> get) {
            this.get = get;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class WrappedPut<K, V> implements Map<K, V>, Put<K, V> {
        private final Put<K, V> put;

        @Override // java.util.Map
        public void clear() {
            this.put.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedPut) && ((WrappedPut) obj).put.equals(this.put);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.put.hashCode() | 360220320;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V put(K k10, V v2) {
            return (V) this.put.put(k10, v2);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.put.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int size() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            throw new UnsupportedOperationException();
        }

        private WrappedPut(Put<K, V> put) {
            this.put = put;
        }
    }

    private SplitMapUtils() {
    }

    public static <K, V> IterableMap<K, V> readableMap(Get<K, V> get) {
        Objects.requireNonNull(get, "Get must not be null");
        if (get instanceof Map) {
            return get instanceof IterableMap ? (IterableMap) get : MapUtils.iterableMap((Map) get);
        }
        return new WrappedGet(get);
    }

    public static <K, V> Map<K, V> writableMap(Put<K, V> put) {
        Objects.requireNonNull(put, "Put must not be null");
        if (put instanceof Map) {
            return (Map) put;
        }
        return new WrappedPut(put);
    }
}
