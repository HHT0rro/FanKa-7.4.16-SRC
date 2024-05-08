package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>, Cloneable, Serializable {
    private static final int ENTRIES = 2;
    private static final int KEYS = 0;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int VALUES = 1;
    private static final long serialVersionUID = 1421746759512286392L;
    private transient int count;
    private volatile transient Set<Map.Entry<K, V>> entrySet;
    private volatile transient Set<K> keySet;
    private float loadFactor;
    private transient int modCount;
    private transient HashtableEntry<?, ?>[] table;
    private int threshold;
    private volatile transient Collection<V> values;

    public Hashtable(int initialCapacity, float loadFactor) {
        this.modCount = 0;
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (loadFactor <= 0.0f || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
        }
        initialCapacity = initialCapacity == 0 ? 1 : initialCapacity;
        this.loadFactor = loadFactor;
        this.table = new HashtableEntry[initialCapacity];
        this.threshold = Math.min(initialCapacity, 2147483640);
    }

    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public Hashtable() {
        this(11, 0.75f);
    }

    public Hashtable(Map<? extends K, ? extends V> t2) {
        this(Math.max(t2.size() * 2, 11), 0.75f);
        putAll(t2);
    }

    Hashtable(Void dummy) {
        this.modCount = 0;
    }

    @Override // java.util.Dictionary, java.util.Map
    public synchronized int size() {
        return this.count;
    }

    @Override // java.util.Dictionary, java.util.Map
    public synchronized boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.util.Dictionary
    public synchronized Enumeration<K> keys() {
        return (Enumeration<K>) getEnumeration(0);
    }

    @Override // java.util.Dictionary
    public synchronized Enumeration<V> elements() {
        return (Enumeration<V>) getEnumeration(1);
    }

    public synchronized boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        HashtableEntry<?, ?>[] tab = this.table;
        int i10 = tab.length;
        while (true) {
            int i11 = i10 - 1;
            if (i10 <= 0) {
                return false;
            }
            for (HashtableEntry<?, ?> e2 = tab[i11]; e2 != null; e2 = e2.next) {
                if (e2.value.equals(value)) {
                    return true;
                }
            }
            i10 = i11;
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return contains(value);
    }

    @Override // java.util.Map
    public synchronized boolean containsKey(Object key) {
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> e2 = tab[index]; e2 != null; e2 = e2.next) {
            if (e2.hash == hash && e2.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Dictionary, java.util.Map
    public synchronized V get(Object key) {
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> e2 = tab[index]; e2 != null; e2 = e2.next) {
            if (e2.hash == hash && e2.key.equals(key)) {
                return e2.value;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void rehash() {
        int length = this.table.length;
        HashtableEntry[] hashtableEntryArr = this.table;
        int i10 = (length << 1) + 1;
        if (i10 - 2147483639 > 0) {
            if (length == 2147483639) {
                return;
            } else {
                i10 = 2147483639;
            }
        }
        HashtableEntry<?, ?>[] hashtableEntryArr2 = new HashtableEntry[i10];
        this.modCount++;
        this.threshold = (int) Math.min(i10 * this.loadFactor, 2.14748365E9f);
        this.table = hashtableEntryArr2;
        int i11 = length;
        while (true) {
            int i12 = i11 - 1;
            if (i11 > 0) {
                HashtableEntry hashtableEntry = hashtableEntryArr[i12];
                while (hashtableEntry != null) {
                    HashtableEntry hashtableEntry2 = hashtableEntry;
                    hashtableEntry = hashtableEntry.next;
                    int i13 = (hashtableEntry2.hash & Integer.MAX_VALUE) % i10;
                    hashtableEntry2.next = (HashtableEntry<K, V>) hashtableEntryArr2[i13];
                    hashtableEntryArr2[i13] = hashtableEntry2;
                }
                i11 = i12;
            } else {
                return;
            }
        }
    }

    private void addEntry(int hash, K key, V value, int index) {
        HashtableEntry<?, ?>[] tab = this.table;
        if (this.count >= this.threshold) {
            rehash();
            tab = this.table;
            hash = key.hashCode();
            index = (Integer.MAX_VALUE & hash) % tab.length;
        }
        tab[index] = new HashtableEntry<>(hash, key, value, tab[index]);
        this.count++;
        this.modCount++;
    }

    @Override // java.util.Dictionary, java.util.Map
    public synchronized V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> hashtableEntry = tab[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hash && hashtableEntry.key.equals(key)) {
                V old = hashtableEntry.value;
                hashtableEntry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    @Override // java.util.Dictionary, java.util.Map
    public synchronized V remove(Object obj) {
        HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
        int hashCode = obj.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        HashtableEntry<?, ?> hashtableEntry = null;
        for (HashtableEntry<?, ?> hashtableEntry2 = hashtableEntryArr[length]; hashtableEntry2 != null; hashtableEntry2 = hashtableEntry2.next) {
            if (hashtableEntry2.hash != hashCode || !hashtableEntry2.key.equals(obj)) {
                hashtableEntry = hashtableEntry2;
            } else {
                if (hashtableEntry != null) {
                    hashtableEntry.next = (HashtableEntry<K, V>) hashtableEntry2.next;
                } else {
                    hashtableEntryArr[length] = hashtableEntry2.next;
                }
                this.modCount++;
                this.count--;
                V v2 = hashtableEntry2.value;
                hashtableEntry2.value = null;
                return v2;
            }
        }
        return null;
    }

    public synchronized void putAll(Map<? extends K, ? extends V> t2) {
        for (Map.Entry<? extends K, ? extends V> e2 : t2.entrySet()) {
            put(e2.getKey(), e2.getValue());
        }
    }

    public synchronized void clear() {
        HashtableEntry<?, ?>[] tab = this.table;
        int index = tab.length;
        while (true) {
            index--;
            if (index >= 0) {
                tab[index] = null;
            } else {
                int index2 = this.modCount;
                this.modCount = index2 + 1;
                this.count = 0;
            }
        }
    }

    public synchronized Object clone() {
        Hashtable<?, ?> t2;
        t2 = cloneHashtable();
        t2.table = new HashtableEntry[this.table.length];
        int i10 = this.table.length;
        while (true) {
            int i11 = i10 - 1;
            HashtableEntry<?, ?> hashtableEntry = null;
            if (i10 > 0) {
                HashtableEntry<?, ?>[] hashtableEntryArr = t2.table;
                HashtableEntry<?, ?> hashtableEntry2 = this.table[i11];
                if (hashtableEntry2 != null) {
                    hashtableEntry = (HashtableEntry) hashtableEntry2.clone();
                }
                hashtableEntryArr[i11] = hashtableEntry;
                i10 = i11;
            } else {
                t2.keySet = null;
                t2.entrySet = null;
                t2.values = null;
                t2.modCount = 0;
            }
        }
        return t2;
    }

    final Hashtable<?, ?> cloneHashtable() {
        try {
            return (Hashtable) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public synchronized String toString() {
        int max = size() - 1;
        if (max == -1) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map.Entry<K, V>> it = entrySet().iterator2();
        sb2.append('{');
        int i10 = 0;
        while (true) {
            Map.Entry<K, V> e2 = it.next();
            K key = e2.getKey();
            V value = e2.getValue();
            sb2.append(key == this ? "(this Map)" : key.toString());
            sb2.append('=');
            sb2.append(value == this ? "(this Map)" : value.toString());
            if (i10 == max) {
                return sb2.append('}').toString();
            }
            sb2.append(", ");
            i10++;
        }
    }

    private <T> Enumeration<T> getEnumeration(int type) {
        if (this.count == 0) {
            return Collections.emptyEnumeration();
        }
        return new Enumerator(type, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Iterator<T> getIterator(int type) {
        if (this.count == 0) {
            return Collections.emptyIterator();
        }
        return new Enumerator(type, true);
    }

    /* renamed from: keySet */
    public Set<K> h() {
        if (this.keySet == null) {
            this.keySet = Collections.synchronizedSet(new KeySet(), this);
        }
        return this.keySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return Hashtable.this.getIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Hashtable.this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return Hashtable.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return Hashtable.this.remove(o10) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = Collections.synchronizedSet(new EntrySet(), this);
        }
        return this.entrySet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return Hashtable.this.getIterator(2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> o10) {
            return super.add((EntrySet) o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o10;
            Object key = entry.getKey();
            HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
            int hash = key.hashCode();
            int index = (Integer.MAX_VALUE & hash) % hashtableEntryArr.length;
            for (HashtableEntry<K, V> hashtableEntry = hashtableEntryArr[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
                if (hashtableEntry.hash == hash && hashtableEntry.equals(entry)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o10;
            Object key = entry.getKey();
            HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
            int hash = key.hashCode();
            int index = (Integer.MAX_VALUE & hash) % hashtableEntryArr.length;
            HashtableEntry<K, V> prev = null;
            for (HashtableEntry<K, V> e2 = hashtableEntryArr[index]; e2 != null; e2 = e2.next) {
                if (e2.hash != hash || !e2.equals(entry)) {
                    prev = e2;
                } else {
                    if (prev != null) {
                        prev.next = e2.next;
                    } else {
                        hashtableEntryArr[index] = e2.next;
                    }
                    e2.value = null;
                    Hashtable.this.modCount++;
                    Hashtable.this.count--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Hashtable.this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }
    }

    public Collection<V> values() {
        if (this.values == null) {
            this.values = Collections.synchronizedCollection(new ValueCollection(), this);
        }
        return this.values;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ValueCollection extends AbstractCollection<V> {
        private ValueCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return Hashtable.this.getIterator(1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Hashtable.this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return Hashtable.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Hashtable.this.clear();
        }
    }

    @Override // java.util.Map
    public synchronized boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof Map)) {
            return false;
        }
        Map<?, ?> t2 = (Map) o10;
        if (t2.size() != size()) {
            return false;
        }
        try {
            try {
            } catch (NullPointerException e2) {
                return false;
            }
        } catch (ClassCastException e10) {
        }
        try {
            for (Map.Entry<K, V> e11 : entrySet()) {
                K key = e11.getKey();
                V value = e11.getValue();
                if (value == null) {
                    if (t2.get(key) != null || !t2.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(t2.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e12) {
            return false;
        }
    }

    @Override // java.util.Map
    public synchronized int hashCode() {
        int h10 = 0;
        if (this.count != 0) {
            float f10 = this.loadFactor;
            if (f10 >= 0.0f) {
                this.loadFactor = -f10;
                HashtableEntry<?, ?>[] tab = this.table;
                for (HashtableEntry<?, ?> entry : tab) {
                    for (; entry != null; entry = entry.next) {
                        h10 += entry.hashCode();
                    }
                }
                this.loadFactor = -this.loadFactor;
                return h10;
            }
        }
        return 0;
    }

    public synchronized V getOrDefault(Object key, V defaultValue) {
        V result;
        result = get(key);
        return result == null ? defaultValue : result;
    }

    public synchronized void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Objects.requireNonNull(biConsumer);
        int i10 = this.modCount;
        for (HashtableEntry<?, ?> hashtableEntry : this.table) {
            while (hashtableEntry != null) {
                biConsumer.accept(hashtableEntry.key, hashtableEntry.value);
                hashtableEntry = hashtableEntry.next;
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public synchronized void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        int i10 = this.modCount;
        for (HashtableEntry<?, ?> hashtableEntry : this.table) {
            while (hashtableEntry != null) {
                hashtableEntry.value = (V) Objects.requireNonNull(biFunction.apply(hashtableEntry.key, hashtableEntry.value));
                hashtableEntry = hashtableEntry.next;
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    public synchronized V putIfAbsent(K key, V value) {
        Objects.requireNonNull(value);
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> hashtableEntry = tab[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hash && hashtableEntry.key.equals(key)) {
                V old = hashtableEntry.value;
                if (old == null) {
                    hashtableEntry.value = value;
                }
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    public synchronized boolean remove(Object obj, Object obj2) {
        Objects.requireNonNull(obj2);
        HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
        int hashCode = obj.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        HashtableEntry<?, ?> hashtableEntry = null;
        for (HashtableEntry<?, ?> hashtableEntry2 = hashtableEntryArr[length]; hashtableEntry2 != null; hashtableEntry2 = hashtableEntry2.next) {
            if (hashtableEntry2.hash != hashCode || !hashtableEntry2.key.equals(obj) || !hashtableEntry2.value.equals(obj2)) {
                hashtableEntry = hashtableEntry2;
            } else {
                if (hashtableEntry != null) {
                    hashtableEntry.next = (HashtableEntry<K, V>) hashtableEntry2.next;
                } else {
                    hashtableEntryArr[length] = hashtableEntry2.next;
                }
                hashtableEntry2.value = null;
                this.modCount++;
                this.count--;
                return true;
            }
        }
        return false;
    }

    public synchronized boolean replace(K key, V oldValue, V newValue) {
        Objects.requireNonNull(oldValue);
        Objects.requireNonNull(newValue);
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> hashtableEntry = tab[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hash && hashtableEntry.key.equals(key)) {
                if (!hashtableEntry.value.equals(oldValue)) {
                    return false;
                }
                hashtableEntry.value = newValue;
                return true;
            }
        }
        return false;
    }

    public synchronized V replace(K key, V value) {
        Objects.requireNonNull(value);
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> hashtableEntry = tab[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hash && hashtableEntry.key.equals(key)) {
                V oldValue = hashtableEntry.value;
                hashtableEntry.value = value;
                return oldValue;
            }
        }
        return null;
    }

    public synchronized V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        HashtableEntry<?, ?>[] tab = this.table;
        int hash = key.hashCode();
        int index = (Integer.MAX_VALUE & hash) % tab.length;
        for (HashtableEntry<?, ?> hashtableEntry = tab[index]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hash && hashtableEntry.key.equals(key)) {
                return hashtableEntry.value;
            }
        }
        int mc2 = this.modCount;
        V newValue = mappingFunction.apply(key);
        if (mc2 != this.modCount) {
            throw new ConcurrentModificationException();
        }
        if (newValue != null) {
            addEntry(hash, key, newValue, index);
        }
        return newValue;
    }

    public synchronized V computeIfPresent(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
        int hashCode = k10.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        HashtableEntry<?, ?> hashtableEntry = null;
        for (HashtableEntry<?, ?> hashtableEntry2 = hashtableEntryArr[length]; hashtableEntry2 != null; hashtableEntry2 = hashtableEntry2.next) {
            if (hashtableEntry2.hash != hashCode || !hashtableEntry2.key.equals(k10)) {
                hashtableEntry = hashtableEntry2;
            } else {
                int i10 = this.modCount;
                V apply = biFunction.apply(k10, hashtableEntry2.value);
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (apply == null) {
                    if (hashtableEntry != null) {
                        hashtableEntry.next = (HashtableEntry<K, V>) hashtableEntry2.next;
                    } else {
                        hashtableEntryArr[length] = hashtableEntry2.next;
                    }
                    this.modCount = i10 + 1;
                    this.count--;
                } else {
                    hashtableEntry2.value = apply;
                }
                return apply;
            }
        }
        return null;
    }

    public synchronized V compute(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
        int hashCode = k10.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        HashtableEntry<?, ?> hashtableEntry = null;
        for (HashtableEntry<?, ?> hashtableEntry2 = hashtableEntryArr[length]; hashtableEntry2 != null; hashtableEntry2 = hashtableEntry2.next) {
            if (hashtableEntry2.hash != hashCode || !Objects.equals(hashtableEntry2.key, k10)) {
                hashtableEntry = hashtableEntry2;
            } else {
                int i10 = this.modCount;
                V apply = biFunction.apply(k10, hashtableEntry2.value);
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (apply == null) {
                    if (hashtableEntry != null) {
                        hashtableEntry.next = (HashtableEntry<K, V>) hashtableEntry2.next;
                    } else {
                        hashtableEntryArr[length] = hashtableEntry2.next;
                    }
                    this.modCount = i10 + 1;
                    this.count--;
                } else {
                    hashtableEntry2.value = apply;
                }
                return apply;
            }
        }
        int i11 = this.modCount;
        V apply2 = biFunction.apply(k10, null);
        if (i11 != this.modCount) {
            throw new ConcurrentModificationException();
        }
        if (apply2 != null) {
            addEntry(hashCode, k10, apply2, length);
        }
        return apply2;
    }

    public synchronized V merge(K k10, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
        int hashCode = k10.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        HashtableEntry<?, ?> hashtableEntry = null;
        for (HashtableEntry<?, ?> hashtableEntry2 = hashtableEntryArr[length]; hashtableEntry2 != null; hashtableEntry2 = hashtableEntry2.next) {
            if (hashtableEntry2.hash != hashCode || !hashtableEntry2.key.equals(k10)) {
                hashtableEntry = hashtableEntry2;
            } else {
                int i10 = this.modCount;
                V apply = biFunction.apply(hashtableEntry2.value, v2);
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (apply == null) {
                    if (hashtableEntry != null) {
                        hashtableEntry.next = (HashtableEntry<K, V>) hashtableEntry2.next;
                    } else {
                        hashtableEntryArr[length] = hashtableEntry2.next;
                    }
                    this.modCount = i10 + 1;
                    this.count--;
                } else {
                    hashtableEntry2.value = apply;
                }
                return apply;
            }
        }
        if (v2 != null) {
            addEntry(hashCode, k10, v2, length);
        }
        return v2;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        writeHashtable(s2);
    }

    void writeHashtable(ObjectOutputStream s2) throws IOException {
        HashtableEntry<Object, Object> entryStack = null;
        synchronized (this) {
            s2.defaultWriteObject();
            s2.writeInt(this.table.length);
            s2.writeInt(this.count);
            for (HashtableEntry<?, ?> entry : this.table) {
                for (; entry != null; entry = entry.next) {
                    entryStack = new HashtableEntry<>(0, entry.key, entry.value, entryStack);
                }
            }
        }
        while (entryStack != null) {
            s2.writeObject(entryStack.key);
            s2.writeObject(entryStack.value);
            entryStack = entryStack.next;
        }
    }

    final void defaultWriteHashtable(ObjectOutputStream s2, int length, float loadFactor) throws IOException {
        this.threshold = Math.min(length, 2147483640);
        this.loadFactor = loadFactor;
        s2.defaultWriteObject();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        readHashtable(s2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void readHashtable(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        float f10 = this.loadFactor;
        if (f10 <= 0.0f || Float.isNaN(f10)) {
            throw new StreamCorruptedException("Illegal Load: " + this.loadFactor);
        }
        int origlength = s2.readInt();
        int elements = s2.readInt();
        if (elements < 0) {
            throw new StreamCorruptedException("Illegal # of Elements: " + elements);
        }
        int origlength2 = Math.max(origlength, ((int) (elements / this.loadFactor)) + 1);
        int length = ((int) (((elements / 20) + elements) / this.loadFactor)) + 3;
        if (length > elements && (length & 1) == 0) {
            length--;
        }
        int length2 = Math.min(length, origlength2);
        if (length2 < 0) {
            length2 = origlength2;
        }
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Map.Entry[].class, length2);
        this.table = new HashtableEntry[length2];
        this.threshold = (int) Math.min(length2 * this.loadFactor, 2.14748365E9f);
        this.count = 0;
        while (elements > 0) {
            reconstitutionPut(this.table, s2.readObject(), s2.readObject());
            elements--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reconstitutionPut(HashtableEntry<?, ?>[] hashtableEntryArr, K k10, V v2) throws StreamCorruptedException {
        if (v2 == null) {
            throw new StreamCorruptedException();
        }
        int hashCode = k10.hashCode();
        int length = (Integer.MAX_VALUE & hashCode) % hashtableEntryArr.length;
        for (HashtableEntry<K, V> hashtableEntry = (HashtableEntry<K, V>) hashtableEntryArr[length]; hashtableEntry != null; hashtableEntry = hashtableEntry.next) {
            if (hashtableEntry.hash == hashCode && hashtableEntry.key.equals(k10)) {
                throw new StreamCorruptedException();
            }
        }
        hashtableEntryArr[length] = new HashtableEntry(hashCode, k10, v2, hashtableEntryArr[length]);
        this.count++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HashtableEntry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        HashtableEntry<K, V> next;
        V value;

        protected HashtableEntry(int hash, K key, V value, HashtableEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Object clone() {
            int i10 = this.hash;
            K k10 = this.key;
            V v2 = this.value;
            HashtableEntry<K, V> hashtableEntry = this.next;
            return new HashtableEntry(i10, k10, v2, hashtableEntry == null ? null : (HashtableEntry) hashtableEntry.clone());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            K k10 = this.key;
            if (k10 == null) {
                if (e2.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(e2.getKey())) {
                return false;
            }
            V v2 = this.value;
            if (v2 == null) {
                if (e2.getValue() != null) {
                    return false;
                }
            } else if (!v2.equals(e2.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.hash ^ Objects.hashCode(this.value);
        }

        public String toString() {
            return this.key.toString() + "=" + this.value.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Enumerator<T> implements Enumeration<T>, Iterator<T> {
        HashtableEntry<?, ?> entry;
        protected int expectedModCount;
        int index;
        final boolean iterator;
        HashtableEntry<?, ?> lastReturned;
        HashtableEntry<?, ?>[] table;
        final int type;

        Enumerator(int type, boolean iterator) {
            HashtableEntry<?, ?>[] hashtableEntryArr = Hashtable.this.table;
            this.table = hashtableEntryArr;
            this.index = hashtableEntryArr.length;
            this.expectedModCount = Hashtable.this.modCount;
            this.type = type;
            this.iterator = iterator;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            HashtableEntry<?, ?> e2 = this.entry;
            int i10 = this.index;
            HashtableEntry<?, ?>[] t2 = this.table;
            while (e2 == null && i10 > 0) {
                i10--;
                e2 = t2[i10];
            }
            this.entry = e2;
            this.index = i10;
            return e2 != null;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.Hashtable$HashtableEntry] */
        @Override // java.util.Enumeration
        public T nextElement() {
            HashtableEntry<?, ?> hashtableEntry = this.entry;
            int i10 = this.index;
            HashtableEntry<?, ?>[] hashtableEntryArr = this.table;
            while (hashtableEntry == null && i10 > 0) {
                i10--;
                hashtableEntry = hashtableEntryArr[i10];
            }
            this.entry = hashtableEntry;
            this.index = i10;
            if (hashtableEntry != null) {
                this.lastReturned = hashtableEntry;
                ?? r32 = (T) hashtableEntry;
                this.entry = r32.next;
                int i11 = this.type;
                return i11 == 0 ? r32.key : i11 == 1 ? r32.value : r32;
            }
            throw new NoSuchElementException("Hashtable Enumerator");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            if (Hashtable.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.iterator) {
                throw new UnsupportedOperationException();
            }
            if (this.lastReturned == null) {
                throw new IllegalStateException("Hashtable Enumerator");
            }
            if (Hashtable.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            synchronized (Hashtable.this) {
                HashtableEntry<K, V>[] hashtableEntryArr = Hashtable.this.table;
                int index = (this.lastReturned.hash & Integer.MAX_VALUE) % hashtableEntryArr.length;
                HashtableEntry<K, V> prev = null;
                for (HashtableEntry<K, V> e2 = hashtableEntryArr[index]; e2 != null; e2 = e2.next) {
                    if (e2 != this.lastReturned) {
                        prev = e2;
                    } else {
                        if (prev == null) {
                            hashtableEntryArr[index] = e2.next;
                        } else {
                            prev.next = e2.next;
                        }
                        this.expectedModCount++;
                        this.lastReturned = null;
                        Hashtable.this.modCount++;
                        Hashtable hashtable = Hashtable.this;
                        hashtable.count--;
                    }
                }
                throw new ConcurrentModificationException();
            }
        }
    }
}
