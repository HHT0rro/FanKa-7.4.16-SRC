package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SingletonMap<K, V> implements OrderedMap<K, V>, BoundedMap<K, V>, KeyValue<K, V>, Serializable, Cloneable {
    private static final long serialVersionUID = -8931271118676803261L;
    private final K key;
    private V value;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SingletonMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private final SingletonMap<K, V> parent;
        private boolean hasNext = true;
        private boolean canGetSet = false;

        public SingletonMapIterator(SingletonMap<K, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.canGetSet) {
                return this.parent.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.canGetSet) {
                return this.parent.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return !this.hasNext;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (this.hasNext) {
                this.hasNext = false;
                this.canGetSet = true;
                return this.parent.getKey();
            }
            throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            if (!this.hasNext) {
                this.hasNext = true;
                return this.parent.getKey();
            }
            throw new NoSuchElementException(AbstractHashedMap.NO_PREVIOUS_ENTRY);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.hasNext = true;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            if (this.canGetSet) {
                return this.parent.setValue(v2);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }

        public String toString() {
            if (this.hasNext) {
                return "Iterator[]";
            }
            return "Iterator[" + ((Object) getKey()) + "=" + ((Object) getValue()) + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SingletonValues<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap<?, V> parent;

        public SingletonValues(SingletonMap<?, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new SingletonIterator(this.parent.getValue(), false);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }
    }

    public SingletonMap() {
        this.key = null;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry<K, V> next = map.entrySet().iterator2().next();
        return isEqualKey(next.getKey()) && isEqualValue(next.getValue());
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return getKey();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (isEqualKey(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return false;
    }

    public boolean isEqualKey(Object obj) {
        return obj == null ? getKey() == null : obj.equals(getKey());
    }

    public boolean isEqualValue(Object obj) {
        return obj == null ? getValue() == null : obj.equals(getValue());
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return true;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return Collections.singleton(this.key);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return getKey();
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return 1;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k10) {
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k10) {
        return null;
    }

    @Override // java.util.Map
    public V put(K k10, V v2) {
        if (isEqualKey(k10)) {
            return setValue(v2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator2().next();
                put(next.getKey(), next.getValue());
                return;
            }
            throw new IllegalArgumentException("The map size must be 0 or 1");
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public V setValue(V v2) {
        V v10 = this.value;
        this.value = v2;
        return v10;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append('{');
        sb2.append(getKey() == this ? "(this Map)" : getKey());
        sb2.append('=');
        sb2.append(getValue() != this ? getValue() : "(this Map)");
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new SingletonValues(this);
    }

    public SingletonMap<K, V> clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SingletonMapIterator(this);
    }

    public SingletonMap(K k10, V v2) {
        this.key = k10;
        this.value = v2;
    }

    public SingletonMap(KeyValue<K, V> keyValue) {
        this.key = keyValue.getKey();
        this.value = keyValue.getValue();
    }

    public SingletonMap(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public SingletonMap(Map<? extends K, ? extends V> map) {
        if (map.size() == 1) {
            Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator2().next();
            this.key = next.getKey();
            this.value = next.getValue();
            return;
        }
        throw new IllegalArgumentException("The map size must be 1");
    }
}
