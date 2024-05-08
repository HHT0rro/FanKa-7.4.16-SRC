package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Flat3Map<K, V> implements IterableMap<K, V>, Serializable, Cloneable {
    private static final long serialVersionUID = -6701087419741928296L;
    private transient AbstractHashedMap<K, V> delegateMap;
    private transient int hash1;
    private transient int hash2;
    private transient int hash3;
    private transient K key1;
    private transient K key2;
    private transient K key3;
    private transient int size;
    private transient V value1;
    private transient V value2;
    private transient V value3;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class EntryIterator<K, V> {
        private final Flat3Map<K, V> parent;
        private int nextIndex = 0;
        private FlatMapEntry<K, V> currentEntry = null;

        public EntryIterator(Flat3Map<K, V> flat3Map) {
            this.parent = flat3Map;
        }

        public boolean hasNext() {
            return this.nextIndex < ((Flat3Map) this.parent).size;
        }

        public Map.Entry<K, V> nextEntry() {
            if (hasNext()) {
                Flat3Map<K, V> flat3Map = this.parent;
                int i10 = this.nextIndex + 1;
                this.nextIndex = i10;
                FlatMapEntry<K, V> flatMapEntry = new FlatMapEntry<>(flat3Map, i10);
                this.currentEntry = flatMapEntry;
                return flatMapEntry;
            }
            throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
        }

        public void remove() {
            FlatMapEntry<K, V> flatMapEntry = this.currentEntry;
            if (flatMapEntry != null) {
                flatMapEntry.setRemoved(true);
                this.parent.remove(this.currentEntry.getKey());
                this.nextIndex--;
                this.currentEntry = null;
                return;
            }
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final Flat3Map<K, V> parent;

        public EntrySet(Flat3Map<K, V> flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            if (((Flat3Map) this.parent).delegateMap != null) {
                return ((Flat3Map) this.parent).delegateMap.entrySet().iterator2();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new EntrySetIterator(this.parent);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Object key = ((Map.Entry) obj).getKey();
            boolean containsKey = this.parent.containsKey(key);
            this.parent.remove(key);
            return containsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySetIterator<K, V> extends EntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public EntrySetIterator(Flat3Map<K, V> flat3Map) {
            super(flat3Map);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class FlatMapEntry<K, V> implements Map.Entry<K, V> {
        private final int index;
        private final Flat3Map<K, V> parent;
        private volatile boolean removed = false;

        public FlatMapEntry(Flat3Map<K, V> flat3Map, int i10) {
            this.parent = flat3Map;
            this.index = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.removed || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K key = getKey();
            V value = getValue();
            if (key == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!key.equals(entry.getKey())) {
                return false;
            }
            if (value == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!value.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (!this.removed) {
                int i10 = this.index;
                if (i10 == 1) {
                    return (K) ((Flat3Map) this.parent).key1;
                }
                if (i10 == 2) {
                    return (K) ((Flat3Map) this.parent).key2;
                }
                if (i10 == 3) {
                    return (K) ((Flat3Map) this.parent).key3;
                }
                throw new IllegalStateException("Invalid map index: " + this.index);
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (!this.removed) {
                int i10 = this.index;
                if (i10 == 1) {
                    return (V) ((Flat3Map) this.parent).value1;
                }
                if (i10 == 2) {
                    return (V) ((Flat3Map) this.parent).value2;
                }
                if (i10 == 3) {
                    return (V) ((Flat3Map) this.parent).value3;
                }
                throw new IllegalStateException("Invalid map index: " + this.index);
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (this.removed) {
                return 0;
            }
            K key = getKey();
            V value = getValue();
            return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
        }

        public void setRemoved(boolean z10) {
            this.removed = z10;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            if (!this.removed) {
                V value = getValue();
                int i10 = this.index;
                if (i10 == 1) {
                    ((Flat3Map) this.parent).value1 = v2;
                } else if (i10 == 2) {
                    ((Flat3Map) this.parent).value2 = v2;
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException("Invalid map index: " + this.index);
                    }
                    ((Flat3Map) this.parent).value3 = v2;
                }
                return value;
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }

        public String toString() {
            if (this.removed) {
                return "";
            }
            return ((Object) getKey()) + "=" + ((Object) getValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class FlatMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
        private final Flat3Map<K, V> parent;
        private int nextIndex = 0;
        private boolean canRemove = false;

        public FlatMapIterator(Flat3Map<K, V> flat3Map) {
            this.parent = flat3Map;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return (K) ((Flat3Map) this.parent).key1;
                }
                if (i10 == 2) {
                    return (K) ((Flat3Map) this.parent).key2;
                }
                if (i10 == 3) {
                    return (K) ((Flat3Map) this.parent).key3;
                }
                throw new IllegalStateException("Invalid map index: " + this.nextIndex);
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return (V) ((Flat3Map) this.parent).value1;
                }
                if (i10 == 2) {
                    return (V) ((Flat3Map) this.parent).value2;
                }
                if (i10 == 3) {
                    return (V) ((Flat3Map) this.parent).value3;
                }
                throw new IllegalStateException("Invalid map index: " + this.nextIndex);
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < ((Flat3Map) this.parent).size;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (hasNext()) {
                this.canRemove = true;
                this.nextIndex++;
                return getKey();
            }
            throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                this.parent.remove(getKey());
                this.nextIndex--;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.nextIndex = 0;
            this.canRemove = false;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            if (this.canRemove) {
                V value = getValue();
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    ((Flat3Map) this.parent).value1 = v2;
                } else if (i10 == 2) {
                    ((Flat3Map) this.parent).value2 = v2;
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException("Invalid map index: " + this.nextIndex);
                    }
                    ((Flat3Map) this.parent).value3 = v2;
                }
                return value;
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }

        public String toString() {
            if (!this.canRemove) {
                return "Iterator[]";
            }
            return "Iterator[" + ((Object) getKey()) + "=" + ((Object) getValue()) + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySet<K> extends AbstractSet<K> {
        private final Flat3Map<K, ?> parent;

        public KeySet(Flat3Map<K, ?> flat3Map) {
            this.parent = flat3Map;
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
            if (((Flat3Map) this.parent).delegateMap != null) {
                return ((Flat3Map) this.parent).delegateMap.h().iterator2();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new KeySetIterator(this.parent);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean containsKey = this.parent.containsKey(obj);
            this.parent.remove(obj);
            return containsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySetIterator<K> extends EntryIterator<K, Object> implements Iterator<K> {
        public KeySetIterator(Flat3Map<K, ?> flat3Map) {
            super(flat3Map);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Values<V> extends AbstractCollection<V> {
        private final Flat3Map<?, V> parent;

        public Values(Flat3Map<?, V> flat3Map) {
            this.parent = flat3Map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            if (((Flat3Map) this.parent).delegateMap != null) {
                return ((Flat3Map) this.parent).delegateMap.values().iterator2();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.emptyIterator();
            }
            return new ValuesIterator(this.parent);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ValuesIterator<V> extends EntryIterator<Object, V> implements Iterator<V> {
        public ValuesIterator(Flat3Map<?, V> flat3Map) {
            super(flat3Map);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    public Flat3Map() {
    }

    private void convertToMap() {
        AbstractHashedMap<K, V> createDelegateMap = createDelegateMap();
        this.delegateMap = createDelegateMap;
        int i10 = this.size;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        createDelegateMap.put(this.key3, this.value3);
                    } else {
                        throw new IllegalStateException("Invalid map index: " + this.size);
                    }
                }
                this.delegateMap.put(this.key2, this.value2);
            }
            this.delegateMap.put(this.key1, this.value1);
        }
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt > 3) {
            this.delegateMap = createDelegateMap();
        }
        while (readInt > 0) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
            readInt--;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    @Override // java.util.Map
    public void clear() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            abstractHashedMap.clear();
            this.delegateMap = null;
            return;
        }
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsKey(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return false;
                    }
                    if (this.key3 == null) {
                        return true;
                    }
                }
                if (this.key2 == null) {
                    return true;
                }
            }
            return this.key1 == null;
        }
        if (this.size <= 0) {
            return false;
        }
        int hashCode = obj.hashCode();
        int i11 = this.size;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return false;
                }
                if (this.hash3 == hashCode && obj.equals(this.key3)) {
                    return true;
                }
            }
            if (this.hash2 == hashCode && obj.equals(this.key2)) {
                return true;
            }
        }
        return this.hash1 == hashCode && obj.equals(this.key1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsValue(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return false;
                    }
                    if (this.value3 == null) {
                        return true;
                    }
                }
                if (this.value2 == null) {
                    return true;
                }
            }
            return this.value1 == null;
        }
        int i11 = this.size;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return false;
                }
                if (obj.equals(this.value3)) {
                    return true;
                }
            }
            if (obj.equals(this.value2)) {
                return true;
            }
        }
        return obj.equals(this.value1);
    }

    public AbstractHashedMap<K, V> createDelegateMap() {
        return new HashedMap();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.entrySet();
        }
        return new EntrySet(this);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.equals(obj);
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.size != map.size()) {
            return false;
        }
        int i10 = this.size;
        if (i10 > 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (!map.containsKey(this.key3)) {
                            return false;
                        }
                        Object obj2 = map.get(this.key3);
                        V v2 = this.value3;
                        if (v2 != null ? !v2.equals(obj2) : obj2 != null) {
                            return false;
                        }
                    }
                }
                if (!map.containsKey(this.key2)) {
                    return false;
                }
                Object obj3 = map.get(this.key2);
                V v10 = this.value2;
                if (v10 != null ? !v10.equals(obj3) : obj3 != null) {
                    return false;
                }
            }
            if (!map.containsKey(this.key1)) {
                return false;
            }
            Object obj4 = map.get(this.key1);
            V v11 = this.value1;
            if (v11 != null ? !v11.equals(obj4) : obj4 != null) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.get(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    if (this.key3 == null) {
                        return this.value3;
                    }
                }
                if (this.key2 == null) {
                    return this.value2;
                }
            }
            if (this.key1 == null) {
                return this.value1;
            }
            return null;
        }
        if (this.size <= 0) {
            return null;
        }
        int hashCode = obj.hashCode();
        int i11 = this.size;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return null;
                }
                if (this.hash3 == hashCode && obj.equals(this.key3)) {
                    return this.value3;
                }
            }
            if (this.hash2 == hashCode && obj.equals(this.key2)) {
                return this.value2;
            }
        }
        if (this.hash1 == hashCode && obj.equals(this.key1)) {
            return this.value1;
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        int i10;
        int i11;
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.hashCode();
        }
        int i12 = this.size;
        if (i12 == 0) {
            return 0;
        }
        if (i12 != 1) {
            if (i12 == 2) {
                i11 = 0;
            } else if (i12 == 3) {
                int i13 = this.hash3;
                V v2 = this.value3;
                i11 = (i13 ^ (v2 == null ? 0 : v2.hashCode())) + 0;
            } else {
                throw new IllegalStateException("Invalid map index: " + this.size);
            }
            int i14 = this.hash2;
            V v10 = this.value2;
            i10 = i11 + (i14 ^ (v10 == null ? 0 : v10.hashCode()));
        } else {
            i10 = 0;
        }
        int i15 = this.hash1;
        V v11 = this.value1;
        return ((v11 != null ? v11.hashCode() : 0) ^ i15) + i10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.h();
        }
        return new KeySet(this);
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.mapIterator();
        }
        if (this.size == 0) {
            return EmptyMapIterator.emptyMapIterator();
        }
        return new FlatMapIterator(this);
    }

    @Override // java.util.Map
    public V put(K k10, V v2) {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.put(k10, v2);
        }
        if (k10 == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (this.key3 == null) {
                            V v10 = this.value3;
                            this.value3 = v2;
                            return v10;
                        }
                    }
                }
                if (this.key2 == null) {
                    V v11 = this.value2;
                    this.value2 = v2;
                    return v11;
                }
            }
            if (this.key1 == null) {
                V v12 = this.value1;
                this.value1 = v2;
                return v12;
            }
        } else if (this.size > 0) {
            int hashCode = k10.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (this.hash3 == hashCode && k10.equals(this.key3)) {
                            V v13 = this.value3;
                            this.value3 = v2;
                            return v13;
                        }
                    }
                }
                if (this.hash2 == hashCode && k10.equals(this.key2)) {
                    V v14 = this.value2;
                    this.value2 = v2;
                    return v14;
                }
            }
            if (this.hash1 == hashCode && k10.equals(this.key1)) {
                V v15 = this.value1;
                this.value1 = v2;
                return v15;
            }
        }
        int i12 = this.size;
        if (i12 == 0) {
            this.hash1 = k10 != null ? k10.hashCode() : 0;
            this.key1 = k10;
            this.value1 = v2;
        } else if (i12 == 1) {
            this.hash2 = k10 != null ? k10.hashCode() : 0;
            this.key2 = k10;
            this.value2 = v2;
        } else {
            if (i12 != 2) {
                convertToMap();
                this.delegateMap.put(k10, v2);
                return null;
            }
            this.hash3 = k10 != null ? k10.hashCode() : 0;
            this.key3 = k10;
            this.value3 = v2;
        }
        this.size++;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            abstractHashedMap.putAll(map);
            return;
        }
        if (size < 4) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return;
        }
        convertToMap();
        this.delegateMap.putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.remove(obj);
        }
        int i10 = this.size;
        if (i10 == 0) {
            return null;
        }
        if (obj == null) {
            if (i10 != 1) {
                if (i10 == 2) {
                    K k10 = this.key2;
                    if (k10 == null) {
                        V v2 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return v2;
                    }
                    if (this.key1 != null) {
                        return null;
                    }
                    V v10 = this.value1;
                    this.hash1 = this.hash2;
                    this.key1 = k10;
                    this.value1 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return v10;
                }
                if (i10 == 3) {
                    K k11 = this.key3;
                    if (k11 == null) {
                        V v11 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return v11;
                    }
                    if (this.key2 == null) {
                        V v12 = this.value2;
                        this.hash2 = this.hash3;
                        this.key2 = k11;
                        this.value2 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return v12;
                    }
                    if (this.key1 != null) {
                        return null;
                    }
                    V v13 = this.value1;
                    this.hash1 = this.hash3;
                    this.key1 = k11;
                    this.value1 = this.value3;
                    this.hash3 = 0;
                    this.key3 = null;
                    this.value3 = null;
                    this.size = 2;
                    return v13;
                }
            } else if (this.key1 == null) {
                V v14 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return v14;
            }
        } else if (i10 > 0) {
            int hashCode = obj.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 == 2) {
                    if (this.hash2 == hashCode && obj.equals(this.key2)) {
                        V v15 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return v15;
                    }
                    if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                        return null;
                    }
                    V v16 = this.value1;
                    this.hash1 = this.hash2;
                    this.key1 = this.key2;
                    this.value1 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return v16;
                }
                if (i11 == 3) {
                    if (this.hash3 == hashCode && obj.equals(this.key3)) {
                        V v17 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return v17;
                    }
                    if (this.hash2 == hashCode && obj.equals(this.key2)) {
                        V v18 = this.value2;
                        this.hash2 = this.hash3;
                        this.key2 = this.key3;
                        this.value2 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return v18;
                    }
                    if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                        return null;
                    }
                    V v19 = this.value1;
                    this.hash1 = this.hash3;
                    this.key1 = this.key3;
                    this.value1 = this.value3;
                    this.hash3 = 0;
                    this.key3 = null;
                    this.value3 = null;
                    this.size = 2;
                    return v19;
                }
            } else if (this.hash1 == hashCode && obj.equals(this.key1)) {
                V v20 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return v20;
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.size();
        }
        return this.size;
    }

    public String toString() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.toString();
        }
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append('{');
        int i10 = this.size;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    Object obj = this.key3;
                    if (obj == this) {
                        obj = "(this Map)";
                    }
                    sb2.append(obj);
                    sb2.append('=');
                    Object obj2 = this.value3;
                    if (obj2 == this) {
                        obj2 = "(this Map)";
                    }
                    sb2.append(obj2);
                    sb2.append(',');
                } else {
                    throw new IllegalStateException("Invalid map index: " + this.size);
                }
            }
            Object obj3 = this.key2;
            if (obj3 == this) {
                obj3 = "(this Map)";
            }
            sb2.append(obj3);
            sb2.append('=');
            Object obj4 = this.value2;
            if (obj4 == this) {
                obj4 = "(this Map)";
            }
            sb2.append(obj4);
            sb2.append(',');
        }
        Object obj5 = this.key1;
        if (obj5 == this) {
            obj5 = "(this Map)";
        }
        sb2.append(obj5);
        sb2.append('=');
        V v2 = this.value1;
        sb2.append(v2 != this ? v2 : "(this Map)");
        sb2.append('}');
        return sb2.toString();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        AbstractHashedMap<K, V> abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.values();
        }
        return new Values(this);
    }

    public Flat3Map(Map<? extends K, ? extends V> map) {
        putAll(map);
    }

    public Flat3Map<K, V> clone() {
        try {
            Flat3Map<K, V> flat3Map = (Flat3Map) super.clone();
            AbstractHashedMap<K, V> abstractHashedMap = flat3Map.delegateMap;
            if (abstractHashedMap != null) {
                flat3Map.delegateMap = abstractHashedMap.clone();
            }
            return flat3Map;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }
}
