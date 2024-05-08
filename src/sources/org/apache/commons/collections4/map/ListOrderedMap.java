package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V>, Serializable {
    private static final long serialVersionUID = 2728177751851003750L;
    private final List<K> insertOrder;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySetView<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private Set<Map.Entry<K, V>> entrySet;
        private final List<K> insertOrder;
        private final ListOrderedMap<K, V> parent;

        public EntrySetView(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            this.parent = listOrderedMap;
            this.insertOrder = list;
        }

        private Set<Map.Entry<K, V>> getEntrySet() {
            if (this.entrySet == null) {
                this.entrySet = this.parent.decorated().entrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return getEntrySet().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return getEntrySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return getEntrySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return getEntrySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.parent.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new ListOrderedIterator(this.parent, this.insertOrder);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !getEntrySet().contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return getEntrySet().toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySetView<K> extends AbstractSet<K> {
        private final ListOrderedMap<K, Object> parent;

        public KeySetView(ListOrderedMap<K, ?> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(this.parent.entrySet().iterator2()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.KeySetView.1
                @Override // java.util.Iterator
                public K next() {
                    return getIterator().next().getKey();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ListOrderedIterator<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
        private K last;
        private final ListOrderedMap<K, V> parent;

        public ListOrderedIterator(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            super(list.iterator2());
            this.last = null;
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.parent.decorated().remove(this.last);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            K next = getIterator().next();
            this.last = next;
            return new ListOrderedMapEntry(this.parent, next);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ListOrderedMapEntry<K, V> extends AbstractMapEntry<K, V> {
        private final ListOrderedMap<K, V> parent;

        public ListOrderedMapEntry(ListOrderedMap<K, V> listOrderedMap, K k10) {
            super(k10, null);
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.parent.get(getKey());
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V v2) {
            return this.parent.decorated().put(getKey(), v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ListOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<K> iterator;
        private final ListOrderedMap<K, V> parent;
        private K last = null;
        private boolean readable = false;

        public ListOrderedMapIterator(ListOrderedMap<K, V> listOrderedMap) {
            this.parent = listOrderedMap;
            this.iterator = ((ListOrderedMap) listOrderedMap).insertOrder.listIterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.readable) {
                return this.last;
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.readable) {
                return this.parent.get(this.last);
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            K next = this.iterator.next();
            this.last = next;
            this.readable = true;
            return next;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            K previous = this.iterator.previous();
            this.last = previous;
            this.readable = true;
            return previous;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.readable) {
                this.iterator.remove();
                this.parent.map.remove(this.last);
                this.readable = false;
                return;
            }
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = ((ListOrderedMap) this.parent).insertOrder.listIterator();
            this.last = null;
            this.readable = false;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            if (this.readable) {
                return this.parent.map.put(this.last, v2);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }

        public String toString() {
            if (!this.readable) {
                return "Iterator[]";
            }
            return "Iterator[" + ((Object) getKey()) + "=" + ((Object) getValue()) + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ValuesView<V> extends AbstractList<V> {
        private final ListOrderedMap<Object, V> parent;

        public ValuesView(ListOrderedMap<?, V> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public V get(int i10) {
            return this.parent.getValue(i10);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(this.parent.entrySet().iterator2()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.ValuesView.1
                @Override // java.util.Iterator
                public V next() {
                    return getIterator().next().getValue();
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public V remove(int i10) {
            return this.parent.remove(i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public V set(int i10, V v2) {
            return this.parent.setValue(i10, v2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> map) {
        return new ListOrderedMap<>(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public List<K> asList() {
        return keyList();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        decorated().clear();
        this.insertOrder.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (size() != 0) {
            return this.insertOrder.get(0);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K get(int i10) {
        return this.insertOrder.get(i10);
    }

    public V getValue(int i10) {
        return get(this.insertOrder.get(i10));
    }

    public int indexOf(Object obj) {
        return this.insertOrder.indexOf(obj);
    }

    public List<K> keyList() {
        return UnmodifiableList.unmodifiableList(this.insertOrder);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return new KeySetView(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (size() != 0) {
            return this.insertOrder.get(size() - 1);
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        int indexOf = this.insertOrder.indexOf(obj);
        if (indexOf < 0 || indexOf >= size() - 1) {
            return null;
        }
        return this.insertOrder.get(indexOf + 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        int indexOf = this.insertOrder.indexOf(obj);
        if (indexOf > 0) {
            return this.insertOrder.get(indexOf - 1);
        }
        return null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        if (decorated().containsKey(k10)) {
            return decorated().put(k10, v2);
        }
        V put = decorated().put(k10, v2);
        this.insertOrder.add(k10);
        return put;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object obj) {
        if (!decorated().containsKey(obj)) {
            return null;
        }
        V remove = decorated().remove(obj);
        this.insertOrder.remove(obj);
        return remove;
    }

    public V setValue(int i10, V v2) {
        return put(this.insertOrder.get(i10), v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        boolean z10 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            if (key == this) {
                key = "(this Map)";
            }
            sb2.append(key);
            sb2.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb2.append(value);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public List<V> valueList() {
        return new ValuesView(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        return new ValuesView(this);
    }

    public ListOrderedMap(Map<K, V> map) {
        super(map);
        ArrayList arrayList = new ArrayList();
        this.insertOrder = arrayList;
        arrayList.addAll(decorated().h());
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new ListOrderedMapIterator(this);
    }

    public void putAll(int i10, Map<? extends K, ? extends V> map) {
        if (i10 >= 0 && i10 <= this.insertOrder.size()) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                boolean containsKey = containsKey(entry.getKey());
                put(i10, entry.getKey(), entry.getValue());
                if (containsKey) {
                    i10 = indexOf(entry.getKey());
                }
                i10++;
            }
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.insertOrder.size());
    }

    public V remove(int i10) {
        return remove(get(i10));
    }

    public V put(int i10, K k10, V v2) {
        if (i10 >= 0 && i10 <= this.insertOrder.size()) {
            Map<K, V> decorated = decorated();
            if (decorated.containsKey(k10)) {
                V remove = decorated.remove(k10);
                int indexOf = this.insertOrder.indexOf(k10);
                this.insertOrder.remove(indexOf);
                if (indexOf < i10) {
                    i10--;
                }
                this.insertOrder.add(i10, k10);
                decorated.put(k10, v2);
                return remove;
            }
            this.insertOrder.add(i10, k10);
            decorated.put(k10, v2);
            return null;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + this.insertOrder.size());
    }
}
