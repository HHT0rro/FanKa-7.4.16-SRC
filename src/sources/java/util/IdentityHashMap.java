package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IdentityHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable, Cloneable {
    private static final int DEFAULT_CAPACITY = 32;
    private static final int MAXIMUM_CAPACITY = 536870912;
    private static final int MINIMUM_CAPACITY = 4;
    static final Object NULL_KEY = new Object();
    private static final long serialVersionUID = 8188218128353913216L;
    private transient Set<Map.Entry<K, V>> entrySet;
    transient int modCount;
    int size;
    transient Object[] table;

    private static Object maskNull(Object key) {
        return key == null ? NULL_KEY : key;
    }

    static final Object unmaskNull(Object key) {
        if (key == NULL_KEY) {
            return null;
        }
        return key;
    }

    public IdentityHashMap() {
        init(32);
    }

    public IdentityHashMap(int expectedMaxSize) {
        if (expectedMaxSize < 0) {
            throw new IllegalArgumentException("expectedMaxSize is negative: " + expectedMaxSize);
        }
        init(capacity(expectedMaxSize));
    }

    private static int capacity(int expectedMaxSize) {
        if (expectedMaxSize > 178956970) {
            return 536870912;
        }
        if (expectedMaxSize <= 2) {
            return 4;
        }
        return Integer.highestOneBit((expectedMaxSize << 1) + expectedMaxSize);
    }

    private void init(int initCapacity) {
        this.table = new Object[initCapacity * 2];
    }

    public IdentityHashMap(Map<? extends K, ? extends V> m10) {
        this((int) ((m10.size() + 1) * 1.1d));
        putAll(m10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hash(Object x10, int length) {
        int h10 = System.identityHashCode(x10);
        return ((h10 << 1) - (h10 << 8)) & (length - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int nextKeyIndex(int i10, int len) {
        if (i10 + 2 < len) {
            return i10 + 2;
        }
        return 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Object maskNull = maskNull(obj);
        Object[] objArr = this.table;
        int length = objArr.length;
        int hash = hash(maskNull, length);
        while (true) {
            Object obj2 = objArr[hash];
            if (obj2 == maskNull) {
                return (V) objArr[hash + 1];
            }
            if (obj2 == null) {
                return null;
            }
            hash = nextKeyIndex(hash, length);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        Object k10 = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i10 = hash(k10, len);
        while (true) {
            Object item = tab[i10];
            if (item == k10) {
                return true;
            }
            if (item == null) {
                return false;
            }
            i10 = nextKeyIndex(i10, len);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        Object[] tab = this.table;
        for (int i10 = 1; i10 < tab.length; i10 += 2) {
            if (tab[i10] == value && tab[i10 - 1] != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object key, Object value) {
        Object k10 = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i10 = hash(k10, len);
        while (true) {
            Object item = tab[i10];
            if (item == k10) {
                return tab[i10 + 1] == value;
            }
            if (item == null) {
                return false;
            }
            i10 = nextKeyIndex(i10, len);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r7.size + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (((r4 << 1) + r4) <= r2) goto L18;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V put(K r8, V r9) {
        /*
            r7 = this;
            java.lang.Object r0 = maskNull(r8)
        L4:
            java.lang.Object[] r1 = r7.table
            int r2 = r1.length
            int r3 = hash(r0, r2)
        Lb:
            r4 = r1[r3]
            r5 = r4
            if (r4 == 0) goto L20
            if (r5 != r0) goto L1b
            int r4 = r3 + 1
            r4 = r1[r4]
            int r6 = r3 + 1
            r1[r6] = r9
            return r4
        L1b:
            int r3 = nextKeyIndex(r3, r2)
            goto Lb
        L20:
            int r4 = r7.size
            int r4 = r4 + 1
            int r5 = r4 << 1
            int r5 = r5 + r4
            if (r5 <= r2) goto L30
            boolean r5 = r7.resize(r2)
            if (r5 == 0) goto L30
            goto L4
        L30:
            int r5 = r7.modCount
            int r5 = r5 + 1
            r7.modCount = r5
            r1[r3] = r0
            int r5 = r3 + 1
            r1[r5] = r9
            r7.size = r4
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.IdentityHashMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private boolean resize(int newCapacity) {
        int newLength = newCapacity * 2;
        Object[] oldTable = this.table;
        int oldLength = oldTable.length;
        if (oldLength == 1073741824) {
            if (this.size != 536870911) {
                return false;
            }
            throw new IllegalStateException("Capacity exhausted.");
        }
        if (oldLength >= newLength) {
            return false;
        }
        Object[] newTable = new Object[newLength];
        for (int j10 = 0; j10 < oldLength; j10 += 2) {
            Object key = oldTable[j10];
            if (key != null) {
                Object value = oldTable[j10 + 1];
                oldTable[j10] = null;
                oldTable[j10 + 1] = null;
                int i10 = hash(key, newLength);
                while (newTable[i10] != null) {
                    i10 = nextKeyIndex(i10, newLength);
                }
                newTable[i10] = key;
                newTable[i10 + 1] = value;
            }
        }
        this.table = newTable;
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        int n10 = m10.size();
        if (n10 == 0) {
            return;
        }
        if (n10 > this.size) {
            resize(capacity(n10));
        }
        for (Map.Entry<? extends K, ? extends V> e2 : m10.entrySet()) {
            put(e2.getKey(), e2.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Object maskNull = maskNull(obj);
        Object[] objArr = this.table;
        int length = objArr.length;
        int hash = hash(maskNull, length);
        while (true) {
            Object obj2 = objArr[hash];
            if (obj2 == maskNull) {
                this.modCount++;
                this.size--;
                V v2 = (V) objArr[hash + 1];
                objArr[hash + 1] = null;
                objArr[hash] = null;
                closeDeletion(hash);
                return v2;
            }
            if (obj2 == null) {
                return null;
            }
            hash = nextKeyIndex(hash, length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object key, Object value) {
        Object k10 = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i10 = hash(k10, len);
        while (true) {
            Object item = tab[i10];
            if (item == k10) {
                if (tab[i10 + 1] != value) {
                    return false;
                }
                this.modCount++;
                this.size--;
                tab[i10] = null;
                tab[i10 + 1] = null;
                closeDeletion(i10);
                return true;
            }
            if (item == null) {
                return false;
            }
            i10 = nextKeyIndex(i10, len);
        }
    }

    private void closeDeletion(int d10) {
        Object[] tab = this.table;
        int len = tab.length;
        int i10 = nextKeyIndex(d10, len);
        while (true) {
            Object item = tab[i10];
            if (item != null) {
                int r10 = hash(item, len);
                if ((i10 < r10 && (r10 <= d10 || d10 <= i10)) || (r10 <= d10 && d10 <= i10)) {
                    tab[d10] = item;
                    tab[d10 + 1] = tab[i10 + 1];
                    tab[i10] = null;
                    tab[i10 + 1] = null;
                    d10 = i10;
                }
                i10 = nextKeyIndex(i10, len);
            } else {
                return;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Object[] tab = this.table;
        for (int i10 = 0; i10 < tab.length; i10++) {
            tab[i10] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (o10 instanceof IdentityHashMap) {
            IdentityHashMap<?, ?> m10 = (IdentityHashMap) o10;
            if (m10.size() != this.size) {
                return false;
            }
            Object[] tab = m10.table;
            for (int i10 = 0; i10 < tab.length; i10 += 2) {
                Object k10 = tab[i10];
                if (k10 != null && !containsMapping(k10, tab[i10 + 1])) {
                    return false;
                }
            }
            return true;
        }
        if (o10 instanceof Map) {
            return entrySet().equals(((Map) o10).entrySet());
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int result = 0;
        Object[] tab = this.table;
        for (int i10 = 0; i10 < tab.length; i10 += 2) {
            Object key = tab[i10];
            if (key != null) {
                Object k10 = unmaskNull(key);
                result += System.identityHashCode(k10) ^ System.identityHashCode(tab[i10 + 1]);
            }
        }
        return result;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            IdentityHashMap<?, ?> m10 = (IdentityHashMap) super.clone();
            m10.entrySet = null;
            m10.table = (Object[]) this.table.clone();
            return m10;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class IdentityHashMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        int index;
        boolean indexValid;
        int lastReturnedIndex;
        Object[] traversalTable;

        private IdentityHashMapIterator() {
            this.index = IdentityHashMap.this.size != 0 ? 0 : IdentityHashMap.this.table.length;
            this.expectedModCount = IdentityHashMap.this.modCount;
            this.lastReturnedIndex = -1;
            this.traversalTable = IdentityHashMap.this.table;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Object[] tab = this.traversalTable;
            for (int i10 = this.index; i10 < tab.length; i10 += 2) {
                Object key = tab[i10];
                if (key != null) {
                    this.index = i10;
                    this.indexValid = true;
                    return true;
                }
            }
            int i11 = tab.length;
            this.index = i11;
            return false;
        }

        protected int nextIndex() {
            if (IdentityHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!this.indexValid && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.indexValid = false;
            int i10 = this.index;
            this.lastReturnedIndex = i10;
            this.index = i10 + 2;
            return i10;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturnedIndex == -1) {
                throw new IllegalStateException();
            }
            if (IdentityHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            IdentityHashMap identityHashMap = IdentityHashMap.this;
            int i10 = identityHashMap.modCount + 1;
            identityHashMap.modCount = i10;
            this.expectedModCount = i10;
            int deletedSlot = this.lastReturnedIndex;
            this.lastReturnedIndex = -1;
            this.index = deletedSlot;
            this.indexValid = false;
            Object[] tab = this.traversalTable;
            int len = tab.length;
            int d10 = deletedSlot;
            Object key = tab[d10];
            tab[d10] = null;
            tab[d10 + 1] = null;
            if (tab != IdentityHashMap.this.table) {
                IdentityHashMap.this.remove(key);
                this.expectedModCount = IdentityHashMap.this.modCount;
                return;
            }
            IdentityHashMap identityHashMap2 = IdentityHashMap.this;
            identityHashMap2.size--;
            int i11 = IdentityHashMap.nextKeyIndex(d10, len);
            while (true) {
                Object item = tab[i11];
                if (item != null) {
                    int r10 = IdentityHashMap.hash(item, len);
                    if ((i11 < r10 && (r10 <= d10 || d10 <= i11)) || (r10 <= d10 && d10 <= i11)) {
                        if (i11 < deletedSlot && d10 >= deletedSlot && this.traversalTable == IdentityHashMap.this.table) {
                            int remaining = len - deletedSlot;
                            Object[] newTable = new Object[remaining];
                            System.arraycopy(tab, deletedSlot, newTable, 0, remaining);
                            this.traversalTable = newTable;
                            this.index = 0;
                        }
                        tab[d10] = item;
                        tab[d10 + 1] = tab[i11 + 1];
                        tab[i11] = null;
                        tab[i11 + 1] = null;
                        d10 = i11;
                    }
                    i11 = IdentityHashMap.nextKeyIndex(i11, len);
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class KeyIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) IdentityHashMap.unmaskNull(this.traversalTable[nextIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ValueIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) this.traversalTable[nextIndex() + 1];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class EntryIterator extends IdentityHashMap<K, V>.IdentityHashMapIterator<Map.Entry<K, V>> {
        private IdentityHashMap<K, V>.EntryIterator.Entry lastReturnedEntry;

        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            IdentityHashMap<K, V>.EntryIterator.Entry entry = new Entry(nextIndex());
            this.lastReturnedEntry = entry;
            return entry;
        }

        @Override // java.util.IdentityHashMap.IdentityHashMapIterator, java.util.Iterator
        public void remove() {
            IdentityHashMap<K, V>.EntryIterator.Entry entry = this.lastReturnedEntry;
            this.lastReturnedIndex = entry == null ? -1 : ((Entry) entry).index;
            super.remove();
            ((Entry) this.lastReturnedEntry).index = this.lastReturnedIndex;
            this.lastReturnedEntry = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class Entry implements Map.Entry<K, V> {
            private int index;

            private Entry(int index) {
                this.index = index;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                checkIndexForEntryUse();
                return (K) IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]);
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                checkIndexForEntryUse();
                return (V) EntryIterator.this.traversalTable[this.index + 1];
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v2) {
                checkIndexForEntryUse();
                V v10 = (V) EntryIterator.this.traversalTable[this.index + 1];
                EntryIterator.this.traversalTable[this.index + 1] = v2;
                if (EntryIterator.this.traversalTable != IdentityHashMap.this.table) {
                    IdentityHashMap.this.put(EntryIterator.this.traversalTable[this.index], v2);
                }
                return v10;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object o10) {
                if (this.index < 0) {
                    return super.equals(o10);
                }
                if (o10 instanceof Map.Entry) {
                    Map.Entry<?, ?> e2 = (Map.Entry) o10;
                    if (e2.getKey() == IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]) && e2.getValue() == EntryIterator.this.traversalTable[this.index + 1]) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                if (EntryIterator.this.lastReturnedIndex < 0) {
                    return super.hashCode();
                }
                return System.identityHashCode(IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index])) ^ System.identityHashCode(EntryIterator.this.traversalTable[this.index + 1]);
            }

            public String toString() {
                if (this.index < 0) {
                    return super.toString();
                }
                return IdentityHashMap.unmaskNull(EntryIterator.this.traversalTable[this.index]) + "=" + EntryIterator.this.traversalTable[this.index + 1];
            }

            private void checkIndexForEntryUse() {
                if (this.index < 0) {
                    throw new IllegalStateException("Entry was removed");
                }
            }
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
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IdentityHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return IdentityHashMap.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            int oldSize = IdentityHashMap.this.size;
            IdentityHashMap.this.remove(o10);
            return IdentityHashMap.this.size != oldSize;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            Objects.requireNonNull(c4);
            boolean modified = false;
            Iterator<K> i10 = iterator2();
            while (i10.hasNext()) {
                if (c4.contains(i10.next())) {
                    i10.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IdentityHashMap.this.clear();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            int result = 0;
            Iterator<K> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                K key = iterator2.next();
                result += System.identityHashCode(key);
            }
            return result;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10 = IdentityHashMap.this.modCount;
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            Object[] objArr = IdentityHashMap.this.table;
            int i11 = 0;
            for (int i12 = 0; i12 < objArr.length; i12 += 2) {
                Object obj = objArr[i12];
                if (obj != null) {
                    if (i11 >= size) {
                        throw new ConcurrentModificationException();
                    }
                    tArr[i11] = IdentityHashMap.unmaskNull(obj);
                    i11++;
                }
            }
            if (i11 < size || i10 != IdentityHashMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (i11 < tArr.length) {
                tArr[i11] = null;
            }
            return tArr;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            return new KeySpliterator(IdentityHashMap.this, 0, -1, 0, 0);
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
            return IdentityHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return IdentityHashMap.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Iterator<V> i10 = iterator2();
            while (i10.hasNext()) {
                if (i10.next() == o10) {
                    i10.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IdentityHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10 = IdentityHashMap.this.modCount;
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            Object[] objArr = IdentityHashMap.this.table;
            int i11 = 0;
            for (int i12 = 0; i12 < objArr.length; i12 += 2) {
                if (objArr[i12] != null) {
                    if (i11 >= size) {
                        throw new ConcurrentModificationException();
                    }
                    tArr[i11] = objArr[i12 + 1];
                    i11++;
                }
            }
            if (i11 < size || i10 != IdentityHashMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (i11 < tArr.length) {
                tArr[i11] = null;
            }
            return tArr;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return new ValueSpliterator(IdentityHashMap.this, 0, -1, 0, 0);
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
                Map.Entry<?, ?> entry = (Map.Entry) o10;
                if (IdentityHashMap.this.containsMapping(entry.getKey(), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry) o10;
                if (IdentityHashMap.this.removeMapping(entry.getKey(), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IdentityHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            IdentityHashMap.this.clear();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            Objects.requireNonNull(c4);
            boolean modified = false;
            Iterator<Map.Entry<K, V>> i10 = iterator2();
            while (i10.hasNext()) {
                if (c4.contains(i10.next())) {
                    i10.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10 = IdentityHashMap.this.modCount;
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            Object[] objArr = IdentityHashMap.this.table;
            int i11 = 0;
            for (int i12 = 0; i12 < objArr.length; i12 += 2) {
                Object obj = objArr[i12];
                if (obj != null) {
                    if (i11 >= size) {
                        throw new ConcurrentModificationException();
                    }
                    tArr[i11] = new AbstractMap.SimpleEntry(IdentityHashMap.unmaskNull(obj), objArr[i12 + 1]);
                    i11++;
                }
            }
            if (i11 < size || i10 != IdentityHashMap.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (i11 < tArr.length) {
                tArr[i11] = null;
            }
            return tArr;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(IdentityHashMap.this, 0, -1, 0, 0);
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.size);
        Object[] tab = this.table;
        for (int i10 = 0; i10 < tab.length; i10 += 2) {
            Object key = tab[i10];
            if (key != null) {
                s2.writeObject(unmaskNull(key));
                s2.writeObject(tab[i10 + 1]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.readFields();
        int size = s2.readInt();
        if (size < 0) {
            throw new StreamCorruptedException("Illegal mappings count: " + size);
        }
        int cap = capacity(size);
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, cap * 2);
        this.size = size;
        init(cap);
        for (int i10 = 0; i10 < size; i10++) {
            putForCreate(s2.readObject(), s2.readObject());
        }
    }

    private void putForCreate(K key, V value) throws StreamCorruptedException {
        Object k10 = maskNull(key);
        Object[] tab = this.table;
        int len = tab.length;
        int i10 = hash(k10, len);
        while (true) {
            Object item = tab[i10];
            if (item != null) {
                if (item == k10) {
                    throw new StreamCorruptedException();
                }
                i10 = nextKeyIndex(i10, len);
            } else {
                tab[i10] = k10;
                tab[i10 + 1] = value;
                return;
            }
        }
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Objects.requireNonNull(biConsumer);
        int i10 = this.modCount;
        Object[] objArr = this.table;
        for (int i11 = 0; i11 < objArr.length; i11 += 2) {
            Object obj = objArr[i11];
            if (obj != null) {
                biConsumer.accept((Object) unmaskNull(obj), objArr[i11 + 1]);
            }
            if (this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        int i10 = this.modCount;
        Object[] objArr = this.table;
        for (int i11 = 0; i11 < objArr.length; i11 += 2) {
            Object obj = objArr[i11];
            if (obj != null) {
                objArr[i11 + 1] = biFunction.apply((Object) unmaskNull(obj), objArr[i11 + 1]);
            }
            if (this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class IdentityHashMapSpliterator<K, V> {
        int est;
        int expectedModCount;
        int fence;
        int index;
        final IdentityHashMap<K, V> map;

        IdentityHashMapSpliterator(IdentityHashMap<K, V> map, int origin, int fence, int est, int expectedModCount) {
            this.map = map;
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
            this.est = this.map.size;
            this.expectedModCount = this.map.modCount;
            int hi2 = this.map.table.length;
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
    static final class KeySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<K> {
        KeySpliterator(IdentityHashMap<K, V> map, int origin, int fence, int est, int expectedModCount) {
            super(map, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = ((lo + hi) >>> 1) & (-2);
            if (lo >= mid) {
                return null;
            }
            IdentityHashMap<K, V> identityHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new KeySpliterator<>(identityHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            Object[] objArr;
            if (consumer == null) {
                throw new NullPointerException();
            }
            IdentityHashMap<K, V> identityHashMap = this.map;
            if (identityHashMap != null && (objArr = identityHashMap.table) != null) {
                int i10 = this.index;
                if (i10 >= 0) {
                    int fence = getFence();
                    this.index = fence;
                    if (fence <= objArr.length) {
                        for (int i11 = i10; i11 < fence; i11 += 2) {
                            Object obj = objArr[i11];
                            if (obj != null) {
                                consumer.accept((Object) IdentityHashMap.unmaskNull(obj));
                            }
                        }
                        if (identityHashMap.modCount == this.expectedModCount) {
                            return;
                        }
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Object[] objArr = this.map.table;
            int fence = getFence();
            while (this.index < fence) {
                Object obj = objArr[this.index];
                this.index += 2;
                if (obj != null) {
                    consumer.accept((Object) IdentityHashMap.unmaskNull(obj));
                    if (this.map.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ((this.fence < 0 || this.est == this.map.size) ? 64 : 0) | 1;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ValueSpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<V> {
        ValueSpliterator(IdentityHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = ((lo + hi) >>> 1) & (-2);
            if (lo >= mid) {
                return null;
            }
            IdentityHashMap<K, V> identityHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new ValueSpliterator<>(identityHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> action) {
            Object[] a10;
            if (action == null) {
                throw new NullPointerException();
            }
            IdentityHashMap<K, V> m10 = this.map;
            if (m10 != null && (a10 = m10.table) != null) {
                int i10 = this.index;
                if (i10 >= 0) {
                    int hi = getFence();
                    this.index = hi;
                    if (hi <= a10.length) {
                        for (int i11 = i10; i11 < hi; i11 += 2) {
                            if (a10[i11] != null) {
                                action.accept(a10[i11 + 1]);
                            }
                        }
                        if (m10.modCount == this.expectedModCount) {
                            return;
                        }
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Object[] a10 = this.map.table;
            int hi = getFence();
            while (this.index < hi) {
                Object key = a10[this.index];
                Object obj = a10[this.index + 1];
                this.index += 2;
                if (key != null) {
                    action.accept(obj);
                    if (this.map.modCount == this.expectedModCount) {
                        return true;
                    }
                    throw new ConcurrentModificationException();
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.fence < 0 || this.est == this.map.size) ? 64 : 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntrySpliterator<K, V> extends IdentityHashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        EntrySpliterator(IdentityHashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = ((lo + hi) >>> 1) & (-2);
            if (lo >= mid) {
                return null;
            }
            IdentityHashMap<K, V> identityHashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new EntrySpliterator<>(identityHashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            Object[] a10;
            if (action == null) {
                throw new NullPointerException();
            }
            IdentityHashMap<K, V> m10 = this.map;
            if (m10 != null && (a10 = m10.table) != null) {
                int i10 = this.index;
                if (i10 >= 0) {
                    int hi = getFence();
                    this.index = hi;
                    if (hi <= a10.length) {
                        for (int i11 = i10; i11 < hi; i11 += 2) {
                            Object key = a10[i11];
                            if (key != null) {
                                action.accept(new AbstractMap.SimpleImmutableEntry(IdentityHashMap.unmaskNull(key), a10[i11 + 1]));
                            }
                        }
                        if (m10.modCount == this.expectedModCount) {
                            return;
                        }
                    }
                }
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Object[] a10 = this.map.table;
            int hi = getFence();
            while (this.index < hi) {
                Object key = a10[this.index];
                Object obj = a10[this.index + 1];
                this.index += 2;
                if (key != null) {
                    action.accept(new AbstractMap.SimpleImmutableEntry(IdentityHashMap.unmaskNull(key), obj));
                    if (this.map.modCount == this.expectedModCount) {
                        return true;
                    }
                    throw new ConcurrentModificationException();
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ((this.fence < 0 || this.est == this.map.size) ? 64 : 0) | 1;
        }
    }
}
