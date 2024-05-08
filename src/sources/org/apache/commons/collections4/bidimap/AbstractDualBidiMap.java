package org.apache.commons.collections4.bidimap;

import androidx.core.util.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDualBidiMap<K, V> implements BidiMap<K, V> {
    public transient Set<Map.Entry<K, V>> entrySet;
    public transient BidiMap<V, K> inverseBidiMap;
    public transient Set<K> keySet;
    public transient Map<K, V> normalMap;
    public transient Map<V, K> reverseMap;
    public transient Set<V> values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class BidiMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        public Iterator<Map.Entry<K, V>> iterator;
        public final AbstractDualBidiMap<K, V> parent;
        public Map.Entry<K, V> last = null;
        public boolean canRemove = false;

        public BidiMapIterator(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = abstractDualBidiMap.normalMap.entrySet().iterator2();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            Map.Entry<K, V> entry = this.last;
            if (entry != null) {
                return entry.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> entry = this.last;
            if (entry != null) {
                return entry.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> next = this.iterator.next();
            this.last = next;
            this.canRemove = true;
            return next.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                V value = this.last.getValue();
                this.iterator.remove();
                this.parent.reverseMap.remove(value);
                this.last = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = this.parent.normalMap.entrySet().iterator2();
            this.last = null;
            this.canRemove = false;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            if (this.last != null) {
                if (this.parent.reverseMap.containsKey(v2) && this.parent.reverseMap.get(v2) != this.last.getKey()) {
                    throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
                }
                return (V) this.parent.put(this.last.getKey(), v2);
            }
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (this.last == null) {
                return "MapIterator[]";
            }
            return "MapIterator[" + ((Object) getKey()) + "=" + ((Object) getValue()) + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySet<K, V> extends View<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4040410962603292348L;

        public EntrySet(AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.entrySet(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return this.parent.createEntrySetIterator(super.iterator2());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (this.parent.containsKey(key)) {
                V v2 = this.parent.normalMap.get(key);
                Object value = entry.getValue();
                if (v2 != null ? v2.equals(value) : value == null) {
                    this.parent.normalMap.remove(key);
                    this.parent.reverseMap.remove(v2);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySetIterator<K, V> extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        public boolean canRemove;
        public Map.Entry<K, V> last;
        public final AbstractDualBidiMap<K, V> parent;

        public EntrySetIterator(Iterator<Map.Entry<K, V>> it, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(it);
            this.last = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                V value = this.last.getValue();
                super.remove();
                this.parent.reverseMap.remove(value);
                this.last = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            MapEntry mapEntry = new MapEntry((Map.Entry) super.next(), this.parent);
            this.last = mapEntry;
            this.canRemove = true;
            return mapEntry;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySet<K> extends View<K, Object, K> implements Set<K> {
        private static final long serialVersionUID = -7107935777385040694L;

        public KeySet(AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.h(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.normalMap.containsKey(obj);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return this.parent.createKeySetIterator(super.iterator2());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.parent.normalMap.containsKey(obj)) {
                return false;
            }
            this.parent.reverseMap.remove(this.parent.normalMap.remove(obj));
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySetIterator<K> extends AbstractIteratorDecorator<K> {
        public boolean canRemove;
        public K lastKey;
        public final AbstractDualBidiMap<K, ?> parent;

        public KeySetIterator(Iterator<K> it, AbstractDualBidiMap<K, ?> abstractDualBidiMap) {
            super(it);
            this.lastKey = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public K next() {
            K k10 = (K) super.next();
            this.lastKey = k10;
            this.canRemove = true;
            return k10;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                Object obj = this.parent.normalMap.get(this.lastKey);
                super.remove();
                this.parent.reverseMap.remove(obj);
                this.lastKey = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MapEntry<K, V> extends AbstractMapEntryDecorator<K, V> {
        public final AbstractDualBidiMap<K, V> parent;

        public MapEntry(Map.Entry<K, V> entry, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(entry);
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V v2) {
            K key = getKey();
            if (this.parent.reverseMap.containsKey(v2) && this.parent.reverseMap.get(v2) != key) {
                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
            }
            this.parent.put(key, v2);
            return (V) super.setValue(v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Values<V> extends View<Object, V, V> implements Set<V> {
        private static final long serialVersionUID = 4023777119829639864L;

        public Values(AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(abstractDualBidiMap.normalMap.values(), abstractDualBidiMap);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.reverseMap.containsKey(obj);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return this.parent.createValuesIterator(super.iterator2());
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.parent.reverseMap.containsKey(obj)) {
                return false;
            }
            this.parent.normalMap.remove(this.parent.reverseMap.remove(obj));
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ValuesIterator<V> extends AbstractIteratorDecorator<V> {
        public boolean canRemove;
        public V lastValue;
        public final AbstractDualBidiMap<Object, V> parent;

        public ValuesIterator(Iterator<V> it, AbstractDualBidiMap<?, V> abstractDualBidiMap) {
            super(it);
            this.lastValue = null;
            this.canRemove = false;
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public V next() {
            V v2 = (V) super.next();
            this.lastValue = v2;
            this.canRemove = true;
            return v2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                super.remove();
                this.parent.reverseMap.remove(this.lastValue);
                this.lastValue = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class View<K, V, E> extends AbstractCollectionDecorator<E> {
        private static final long serialVersionUID = 4621510560119690639L;
        public final AbstractDualBidiMap<K, V> parent;

        public View(Collection<E> collection, AbstractDualBidiMap<K, V> abstractDualBidiMap) {
            super(collection);
            this.parent = abstractDualBidiMap;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return obj == this || decorated().equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return decorated().hashCode();
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean z10 = false;
            if (!this.parent.isEmpty() && !collection.isEmpty()) {
                Iterator<?> iterator2 = collection.iterator2();
                while (iterator2.hasNext()) {
                    z10 |= remove(iterator2.next());
                }
            }
            return z10;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
        public boolean removeIf(Predicate<? super E> predicate) {
            boolean z10 = false;
            if (!this.parent.isEmpty() && !a.a(predicate)) {
                Iterator<E> iterator2 = iterator2();
                while (iterator2.hasNext()) {
                    if (predicate.test(iterator2.next())) {
                        iterator2.remove();
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean z10 = false;
            if (this.parent.isEmpty()) {
                return false;
            }
            if (collection.isEmpty()) {
                this.parent.clear();
                return true;
            }
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                if (!collection.contains(iterator2.next())) {
                    iterator2.remove();
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public AbstractDualBidiMap() {
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
    }

    @Override // java.util.Map
    public void clear() {
        this.normalMap.clear();
        this.reverseMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.normalMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.reverseMap.containsKey(obj);
    }

    public abstract BidiMap<V, K> createBidiMap(Map<V, K> map, Map<K, V> map2, BidiMap<K, V> bidiMap);

    public Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> it) {
        return new EntrySetIterator(it, this);
    }

    public Iterator<K> createKeySetIterator(Iterator<K> it) {
        return new KeySetIterator(it, this);
    }

    public Iterator<V> createValuesIterator(Iterator<V> it) {
        return new ValuesIterator(it, this);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.normalMap.equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.normalMap.get(obj);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K getKey(Object obj) {
        return this.reverseMap.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.normalMap.hashCode();
    }

    @Override // org.apache.commons.collections4.BidiMap
    public BidiMap<V, K> inverseBidiMap() {
        if (this.inverseBidiMap == null) {
            this.inverseBidiMap = createBidiMap(this.reverseMap, this.normalMap, this);
        }
        return this.inverseBidiMap;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.normalMap.isEmpty();
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return new BidiMapIterator(this);
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public V put(K k10, V v2) {
        if (this.normalMap.containsKey(k10)) {
            this.reverseMap.remove(this.normalMap.get(k10));
        }
        if (this.reverseMap.containsKey(v2)) {
            this.normalMap.remove(this.reverseMap.get(v2));
        }
        V put = this.normalMap.put(k10, v2);
        this.reverseMap.put(v2, k10);
        return put;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        if (!this.normalMap.containsKey(obj)) {
            return null;
        }
        V remove = this.normalMap.remove(obj);
        this.reverseMap.remove(remove);
        return remove;
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        if (!this.reverseMap.containsKey(obj)) {
            return null;
        }
        K remove = this.reverseMap.remove(obj);
        this.normalMap.remove(remove);
        return remove;
    }

    @Override // java.util.Map
    public int size() {
        return this.normalMap.size();
    }

    public String toString() {
        return this.normalMap.toString();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map
    public Set<V> values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    public AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2) {
        this.inverseBidiMap = null;
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = map;
        this.reverseMap = map2;
    }

    public AbstractDualBidiMap(Map<K, V> map, Map<V, K> map2, BidiMap<V, K> bidiMap) {
        this.keySet = null;
        this.values = null;
        this.entrySet = null;
        this.normalMap = map;
        this.reverseMap = map2;
        this.inverseBidiMap = bidiMap;
    }
}
