package java.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final Object NULL_KEY = new Object();
    private transient Set<Map.Entry<K, V>> entrySet;
    private final float loadFactor;
    int modCount;
    private final ReferenceQueue<Object> queue;
    private int size;
    Entry<K, V>[] table;
    private int threshold;

    private Entry<K, V>[] newTable(int n10) {
        return new Entry[n10];
    }

    public WeakHashMap(int initialCapacity, float loadFactor) {
        this.queue = new ReferenceQueue<>();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Initial Capacity: " + initialCapacity);
        }
        initialCapacity = initialCapacity > 1073741824 ? 1073741824 : initialCapacity;
        if (loadFactor <= 0.0f || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal Load factor: " + loadFactor);
        }
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        this.table = newTable(capacity);
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
    }

    public WeakHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public WeakHashMap() {
        this(16, 0.75f);
    }

    public WeakHashMap(Map<? extends K, ? extends V> m10) {
        this(Math.max((int) ((m10.size() / 0.75f) + 1.0f), 16), 0.75f);
        putAll(m10);
    }

    private static Object maskNull(Object key) {
        return key == null ? NULL_KEY : key;
    }

    static Object unmaskNull(Object key) {
        if (key == NULL_KEY) {
            return null;
        }
        return key;
    }

    private boolean matchesKey(Entry<K, V> e2, Object key) {
        if (e2.refersTo(key)) {
            return true;
        }
        Object k10 = e2.get();
        return k10 != null && key.equals(k10);
    }

    final int hash(Object k10) {
        int h10 = k10.hashCode();
        int h11 = h10 ^ ((h10 >>> 20) ^ (h10 >>> 12));
        return ((h11 >>> 7) ^ h11) ^ (h11 >>> 4);
    }

    private static int indexFor(int h10, int length) {
        return (length - 1) & h10;
    }

    private void expungeStaleEntries() {
        while (true) {
            Object x10 = this.queue.poll();
            if (x10 != null) {
                synchronized (this.queue) {
                    Entry<K, V> e2 = (Entry) x10;
                    int i10 = indexFor(e2.hash, this.table.length);
                    Entry<K, V> prev = this.table[i10];
                    Entry<K, V> p10 = prev;
                    while (true) {
                        if (p10 == null) {
                            break;
                        }
                        Entry<K, V> next = p10.next;
                        if (p10 == e2) {
                            if (prev == e2) {
                                this.table[i10] = next;
                            } else {
                                prev.next = next;
                            }
                            e2.value = null;
                            this.size--;
                        } else {
                            prev = p10;
                            p10 = next;
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private Entry<K, V>[] getTable() {
        expungeStaleEntries();
        return this.table;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        if (this.size == 0) {
            return 0;
        }
        expungeStaleEntries();
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        Object k10 = maskNull(key);
        int h10 = hash(k10);
        Entry<K, V>[] tab = getTable();
        int index = indexFor(h10, tab.length);
        for (Entry<K, V> e2 = tab[index]; e2 != null; e2 = e2.next) {
            if (e2.hash == h10 && matchesKey(e2, k10)) {
                return e2.value;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    Entry<K, V> getEntry(Object key) {
        Object k10 = maskNull(key);
        int h10 = hash(k10);
        Entry<K, V>[] tab = getTable();
        int index = indexFor(h10, tab.length);
        Entry<K, V> e2 = tab[index];
        while (e2 != null && (e2.hash != h10 || !matchesKey(e2, k10))) {
            e2 = e2.next;
        }
        return e2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        Object k10 = maskNull(key);
        int h10 = hash(k10);
        Entry<K, V>[] tab = getTable();
        int i10 = indexFor(h10, tab.length);
        for (Entry<K, V> e2 = tab[i10]; e2 != null; e2 = e2.next) {
            if (h10 == e2.hash && matchesKey(e2, k10)) {
                V oldValue = e2.value;
                if (value != oldValue) {
                    e2.value = value;
                }
                return oldValue;
            }
        }
        this.modCount++;
        Entry<K, V> e10 = tab[i10];
        tab[i10] = new Entry<>(k10, value, this.queue, h10, e10);
        int i11 = this.size + 1;
        this.size = i11;
        if (i11 >= this.threshold) {
            resize(tab.length * 2);
            return null;
        }
        return null;
    }

    void resize(int newCapacity) {
        Entry<K, V>[] oldTable = getTable();
        int oldCapacity = oldTable.length;
        if (oldCapacity == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] newTable = newTable(newCapacity);
        transfer(oldTable, newTable);
        this.table = newTable;
        if (this.size >= this.threshold / 2) {
            this.threshold = (int) (newCapacity * this.loadFactor);
            return;
        }
        expungeStaleEntries();
        transfer(newTable, oldTable);
        this.table = oldTable;
    }

    private void transfer(Entry<K, V>[] src, Entry<K, V>[] dest) {
        for (int j10 = 0; j10 < src.length; j10++) {
            Entry<K, V> e2 = src[j10];
            src[j10] = null;
            while (e2 != null) {
                Entry<K, V> next = e2.next;
                if (e2.refersTo(null)) {
                    e2.next = null;
                    e2.value = null;
                    this.size--;
                } else {
                    int i10 = indexFor(e2.hash, dest.length);
                    e2.next = dest[i10];
                    dest[i10] = e2;
                }
                e2 = next;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        int numKeysToBeAdded = m10.size();
        if (numKeysToBeAdded == 0) {
            return;
        }
        if (numKeysToBeAdded > this.threshold) {
            int targetCapacity = (int) ((numKeysToBeAdded / this.loadFactor) + 1.0f);
            if (targetCapacity > 1073741824) {
                targetCapacity = 1073741824;
            }
            int newCapacity = this.table.length;
            while (newCapacity < targetCapacity) {
                newCapacity <<= 1;
            }
            if (newCapacity > this.table.length) {
                resize(newCapacity);
            }
        }
        for (Map.Entry<? extends K, ? extends V> e2 : m10.entrySet()) {
            put(e2.getKey(), e2.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        Object k10 = maskNull(key);
        int h10 = hash(k10);
        Entry<K, V>[] tab = getTable();
        int i10 = indexFor(h10, tab.length);
        Entry<K, V> prev = tab[i10];
        Entry<K, V> e2 = prev;
        while (e2 != null) {
            Entry<K, V> next = e2.next;
            if (h10 == e2.hash && matchesKey(e2, k10)) {
                this.modCount++;
                this.size--;
                if (prev == e2) {
                    tab[i10] = next;
                } else {
                    prev.next = next;
                }
                return e2.value;
            }
            prev = e2;
            e2 = next;
        }
        return null;
    }

    boolean removeMapping(Object o10) {
        if (!(o10 instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> entry = (Map.Entry) o10;
        Entry<K, V>[] tab = getTable();
        Object k10 = maskNull(entry.getKey());
        int h10 = hash(k10);
        int i10 = indexFor(h10, tab.length);
        Entry<K, V> prev = tab[i10];
        Entry<K, V> e2 = prev;
        while (e2 != null) {
            Entry<K, V> next = e2.next;
            if (h10 == e2.hash && e2.equals(entry)) {
                this.modCount++;
                this.size--;
                if (prev == e2) {
                    tab[i10] = next;
                } else {
                    prev.next = next;
                }
                return true;
            }
            prev = e2;
            e2 = next;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        do {
        } while (this.queue.poll() != null);
        this.modCount++;
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        do {
        } while (this.queue.poll() != null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            return containsNullValue();
        }
        Entry<K, V>[] tab = getTable();
        int i10 = tab.length;
        while (true) {
            int i11 = i10 - 1;
            if (i10 > 0) {
                for (Entry<K, V> e2 = tab[i11]; e2 != null; e2 = e2.next) {
                    if (value.equals(e2.value)) {
                        return true;
                    }
                }
                i10 = i11;
            } else {
                return false;
            }
        }
    }

    private boolean containsNullValue() {
        Entry<K, V>[] tab = getTable();
        int i10 = tab.length;
        while (true) {
            int i11 = i10 - 1;
            if (i10 > 0) {
                for (Entry<K, V> e2 = tab[i11]; e2 != null; e2 = e2.next) {
                    if (e2.value == null) {
                        return true;
                    }
                }
                i10 = i11;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Entry<K, V> extends WeakReference<Object> implements Map.Entry<K, V> {
        final int hash;
        Entry<K, V> next;
        V value;

        Entry(Object key, V value, ReferenceQueue<Object> queue, int hash, Entry<K, V> next) {
            super(key, queue);
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) WeakHashMap.unmaskNull(get());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            K k12 = getKey();
            Object k22 = e2.getKey();
            if (k12 == k22 || (k12 != null && k12.equals(k22))) {
                V v12 = getValue();
                Object v2 = e2.getValue();
                if (v12 == v2) {
                    return true;
                }
                if (v12 != null && v12.equals(v2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = getKey();
            V v2 = getValue();
            return Objects.hashCode(k10) ^ Objects.hashCode(v2);
        }

        public String toString() {
            return ((Object) getKey()) + "=" + ((Object) getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class HashIterator<T> implements Iterator<T> {
        private Object currentKey;
        private Entry<K, V> entry;
        private int expectedModCount;
        private int index;
        private Entry<K, V> lastReturned;
        private Object nextKey;

        HashIterator() {
            this.expectedModCount = WeakHashMap.this.modCount;
            this.index = WeakHashMap.this.isEmpty() ? 0 : WeakHashMap.this.table.length;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Entry<K, V>[] t2 = WeakHashMap.this.table;
            while (this.nextKey == null) {
                Entry<K, V> e2 = this.entry;
                int i10 = this.index;
                while (e2 == null && i10 > 0) {
                    i10--;
                    e2 = t2[i10];
                }
                this.entry = e2;
                this.index = i10;
                if (e2 == null) {
                    this.currentKey = null;
                    return false;
                }
                Object obj = e2.get();
                this.nextKey = obj;
                if (obj == null) {
                    this.entry = this.entry.next;
                }
            }
            return true;
        }

        protected Entry<K, V> nextEntry() {
            if (WeakHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.nextKey == null && !hasNext()) {
                throw new NoSuchElementException();
            }
            Entry<K, V> entry = this.entry;
            this.lastReturned = entry;
            this.entry = entry.next;
            this.currentKey = this.nextKey;
            this.nextKey = null;
            return this.lastReturned;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            if (WeakHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            WeakHashMap.this.remove(this.currentKey);
            this.expectedModCount = WeakHashMap.this.modCount;
            this.lastReturned = null;
            this.currentKey = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class ValueIterator extends WeakHashMap<K, V>.HashIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class KeyIterator extends WeakHashMap<K, V>.HashIterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class EntryIterator extends WeakHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> ks = this.keySet;
        if (ks == null) {
            Set<K> ks2 = new KeySet();
            this.keySet = ks2;
            return ks2;
        }
        return ks;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return WeakHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return WeakHashMap.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (WeakHashMap.this.containsKey(o10)) {
                WeakHashMap.this.remove(o10);
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            WeakHashMap.this.clear();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            return new KeySpliterator(WeakHashMap.this, 0, -1, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs == null) {
            Collection<V> vs2 = new Values();
            this.values = vs2;
            return vs2;
        }
        return vs;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return WeakHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return WeakHashMap.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            WeakHashMap.this.clear();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return new ValueSpliterator(WeakHashMap.this, 0, -1, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
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
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                if (WeakHashMap.this.getEntry(e2.getKey()) != null && WeakHashMap.this.getEntry(e2.getKey()).equals(e2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return WeakHashMap.this.removeMapping(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return WeakHashMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            WeakHashMap.this.clear();
        }

        private List<Map.Entry<K, V>> deepCopy() {
            List<Map.Entry<K, V>> list = new ArrayList<>(size());
            Iterator<Map.Entry<K, V>> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<K, V> e2 = iterator2.next();
                list.add(new AbstractMap.SimpleEntry<>(e2));
            }
            return list;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return deepCopy().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) deepCopy().toArray(tArr);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(WeakHashMap.this, 0, -1, 0, 0);
        }
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Objects.requireNonNull(biConsumer);
        int i10 = this.modCount;
        for (Entry<K, V> entry : getTable()) {
            while (entry != null) {
                Object obj = entry.get();
                if (obj != null) {
                    biConsumer.accept((Object) unmaskNull(obj), entry.value);
                }
                entry = entry.next;
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        int i10 = this.modCount;
        for (Entry<K, V> entry : getTable()) {
            while (entry != null) {
                Object obj = entry.get();
                if (obj != null) {
                    entry.value = biFunction.apply((Object) unmaskNull(obj), entry.value);
                }
                entry = entry.next;
                if (i10 != this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class WeakHashMapSpliterator<K, V> {
        Entry<K, V> current;
        int est;
        int expectedModCount;
        int fence;
        int index;
        final WeakHashMap<K, V> map;

        WeakHashMapSpliterator(WeakHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            this.map = m10;
            this.index = origin;
            this.fence = fence;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getFence() {
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            WeakHashMap<K, V> m10 = this.map;
            this.est = m10.size();
            this.expectedModCount = m10.modCount;
            int hi2 = m10.table.length;
            this.fence = hi2;
            return hi2;
        }

        public final long estimateSize() {
            getFence();
            return this.est;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class KeySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<K> {
        KeySpliterator(WeakHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            WeakHashMap<K, V> weakHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new KeySpliterator<>(weakHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            int i10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            WeakHashMap<K, V> weakHashMap = this.map;
            Entry<K, V>[] entryArr = weakHashMap.table;
            int i11 = this.fence;
            int i12 = i11;
            if (i11 < 0) {
                i10 = weakHashMap.modCount;
                this.expectedModCount = i10;
                int length = entryArr.length;
                this.fence = length;
                i12 = length;
            } else {
                i10 = this.expectedModCount;
            }
            if (entryArr.length >= i12) {
                int i13 = this.index;
                int i14 = i13;
                if (i13 >= 0) {
                    this.index = i12;
                    if (i14 < i12 || this.current != null) {
                        Entry<K, V> entry = this.current;
                        this.current = null;
                        while (true) {
                            if (entry == null) {
                                entry = entryArr[i14];
                                i14++;
                            } else {
                                Object obj = entry.get();
                                entry = entry.next;
                                if (obj != null) {
                                    consumer.accept((Object) WeakHashMap.unmaskNull(obj));
                                }
                            }
                            if (entry == null && i14 >= i12) {
                                break;
                            }
                        }
                    }
                }
            }
            if (weakHashMap.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Entry<K, V>[] entryArr = this.map.table;
            int length = entryArr.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current != null || this.index < fence) {
                    if (this.current == null) {
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.current = entryArr[i10];
                    } else {
                        Object obj = this.current.get();
                        this.current = this.current.next;
                        if (obj != null) {
                            consumer.accept((Object) WeakHashMap.unmaskNull(obj));
                            if (this.map.modCount != this.expectedModCount) {
                                throw new ConcurrentModificationException();
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ValueSpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<V> {
        ValueSpliterator(WeakHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            WeakHashMap<K, V> weakHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new ValueSpliterator<>(weakHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> consumer) {
            int i10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            WeakHashMap<K, V> weakHashMap = this.map;
            Entry<K, V>[] entryArr = weakHashMap.table;
            int i11 = this.fence;
            int i12 = i11;
            if (i11 < 0) {
                i10 = weakHashMap.modCount;
                this.expectedModCount = i10;
                int length = entryArr.length;
                this.fence = length;
                i12 = length;
            } else {
                i10 = this.expectedModCount;
            }
            if (entryArr.length >= i12) {
                int i13 = this.index;
                int i14 = i13;
                if (i13 >= 0) {
                    this.index = i12;
                    if (i14 < i12 || this.current != null) {
                        Entry<K, V> entry = this.current;
                        this.current = null;
                        while (true) {
                            if (entry == null) {
                                entry = entryArr[i14];
                                i14++;
                            } else {
                                Object obj = entry.get();
                                V v2 = entry.value;
                                entry = entry.next;
                                if (obj != null) {
                                    consumer.accept(v2);
                                }
                            }
                            if (entry == null && i14 >= i12) {
                                break;
                            }
                        }
                    }
                }
            }
            if (weakHashMap.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Entry<K, V>[] entryArr = this.map.table;
            int length = entryArr.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current != null || this.index < fence) {
                    if (this.current == null) {
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.current = entryArr[i10];
                    } else {
                        Object obj = this.current.get();
                        V v2 = this.current.value;
                        this.current = this.current.next;
                        if (obj != null) {
                            consumer.accept(v2);
                            if (this.map.modCount != this.expectedModCount) {
                                throw new ConcurrentModificationException();
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntrySpliterator<K, V> extends WeakHashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        EntrySpliterator(WeakHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            WeakHashMap<K, V> weakHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new EntrySpliterator<>(weakHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            int mc2;
            if (action == null) {
                throw new NullPointerException();
            }
            WeakHashMap<K, V> m10 = this.map;
            Entry<K, V>[] tab = m10.table;
            int i10 = this.fence;
            int hi = i10;
            if (i10 < 0) {
                mc2 = m10.modCount;
                this.expectedModCount = mc2;
                int length = tab.length;
                this.fence = length;
                hi = length;
            } else {
                mc2 = this.expectedModCount;
            }
            if (tab.length >= hi) {
                int i11 = this.index;
                int i12 = i11;
                if (i11 >= 0) {
                    this.index = hi;
                    if (i12 < hi || this.current != null) {
                        Entry<K, V> p10 = this.current;
                        this.current = null;
                        while (true) {
                            if (p10 == null) {
                                p10 = tab[i12];
                                i12++;
                            } else {
                                Object x10 = p10.get();
                                V v2 = p10.value;
                                p10 = p10.next;
                                if (x10 != null) {
                                    action.accept(new AbstractMap.SimpleImmutableEntry(WeakHashMap.unmaskNull(x10), v2));
                                }
                            }
                            if (p10 == null && i12 >= hi) {
                                break;
                            }
                        }
                    }
                }
            }
            if (m10.modCount != mc2) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Entry<K, V>[] tab = this.map.table;
            int length = tab.length;
            int hi = getFence();
            if (length < hi || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current != null || this.index < hi) {
                    if (this.current == null) {
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.current = tab[i10];
                    } else {
                        Object x10 = this.current.get();
                        V v2 = this.current.value;
                        this.current = this.current.next;
                        if (x10 != null) {
                            action.accept(new AbstractMap.SimpleImmutableEntry(WeakHashMap.unmaskNull(x10), v2));
                            if (this.map.modCount != this.expectedModCount) {
                                throw new ConcurrentModificationException();
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 1;
        }
    }
}
