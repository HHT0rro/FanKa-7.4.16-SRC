package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TreeMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Cloneable, Serializable {
    private static final boolean BLACK = true;
    private static final boolean RED = false;
    private static final Object UNBOUNDED = new Object();
    private static final long serialVersionUID = 919286545866124006L;
    private final Comparator<? super K> comparator;
    private transient NavigableMap<K, V> descendingMap;
    private transient TreeMap<K, V>.EntrySet entrySet;
    private transient int modCount;
    private transient KeySet<K> navigableKeySet;
    private transient TreeMapEntry<K, V> root;
    private transient int size;

    public TreeMap() {
        this.size = 0;
        this.modCount = 0;
        this.comparator = null;
    }

    public TreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator;
    }

    public TreeMap(Map<? extends K, ? extends V> m10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = null;
        putAll(m10);
    }

    public TreeMap(SortedMap<K, ? extends V> m10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = m10.comparator();
        try {
            buildFromSorted(m10.size(), m10.entrySet().iterator2(), null, null);
        } catch (IOException | ClassNotFoundException e2) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return getEntry(key) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        for (TreeMapEntry<K, V> e2 = getFirstEntry(); e2 != null; e2 = successor(e2)) {
            if (valEquals(value, e2.value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        TreeMapEntry<K, V> p10 = getEntry(key);
        if (p10 == null) {
            return null;
        }
        return p10.value;
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.comparator;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return (K) key(getFirstEntry());
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return (K) key(getLastEntry());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Comparator<?> c4;
        Comparator<?> comparator;
        int mapSize = map.size();
        if (this.size == 0 && mapSize != 0 && (map instanceof SortedMap) && ((c4 = ((SortedMap) map).comparator()) == (comparator = this.comparator) || (c4 != null && c4.equals(comparator)))) {
            this.modCount++;
            try {
                buildFromSorted(mapSize, map.entrySet().iterator2(), null, null);
                return;
            } catch (IOException | ClassNotFoundException e2) {
                return;
            }
        }
        super.putAll(map);
    }

    final TreeMapEntry<K, V> getEntry(Object key) {
        if (this.comparator != null) {
            return getEntryUsingComparator(key);
        }
        if (key == null) {
            throw new NullPointerException();
        }
        Comparable<? super K> k10 = (Comparable) key;
        TreeMapEntry<K, V> p10 = this.root;
        while (p10 != null) {
            int cmp = k10.compareTo(p10.key);
            if (cmp < 0) {
                p10 = p10.left;
            } else if (cmp > 0) {
                p10 = p10.right;
            } else {
                return p10;
            }
        }
        return null;
    }

    final TreeMapEntry<K, V> getEntryUsingComparator(Object obj) {
        Comparator<? super K> comparator = this.comparator;
        if (comparator != null) {
            TreeMapEntry<K, V> treeMapEntry = this.root;
            while (treeMapEntry != null) {
                int compare = comparator.compare(obj, treeMapEntry.key);
                if (compare < 0) {
                    treeMapEntry = treeMapEntry.left;
                } else if (compare > 0) {
                    treeMapEntry = treeMapEntry.right;
                } else {
                    return treeMapEntry;
                }
            }
            return null;
        }
        return null;
    }

    final TreeMapEntry<K, V> getCeilingEntry(K key) {
        TreeMapEntry<K, V> p10 = this.root;
        while (p10 != null) {
            int cmp = compare(key, p10.key);
            if (cmp < 0) {
                if (p10.left != null) {
                    p10 = p10.left;
                } else {
                    return p10;
                }
            } else if (cmp > 0) {
                if (p10.right != null) {
                    p10 = p10.right;
                } else {
                    TreeMapEntry<K, V> parent = p10.parent;
                    TreeMapEntry<K, V> ch = p10;
                    while (parent != null && ch == parent.right) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            } else {
                return p10;
            }
        }
        return null;
    }

    final TreeMapEntry<K, V> getFloorEntry(K key) {
        TreeMapEntry<K, V> p10 = this.root;
        while (p10 != null) {
            int cmp = compare(key, p10.key);
            if (cmp > 0) {
                if (p10.right != null) {
                    p10 = p10.right;
                } else {
                    return p10;
                }
            } else if (cmp < 0) {
                if (p10.left != null) {
                    p10 = p10.left;
                } else {
                    TreeMapEntry<K, V> parent = p10.parent;
                    TreeMapEntry<K, V> ch = p10;
                    while (parent != null && ch == parent.left) {
                        ch = parent;
                        parent = parent.parent;
                    }
                    return parent;
                }
            } else {
                return p10;
            }
        }
        return null;
    }

    final TreeMapEntry<K, V> getHigherEntry(K key) {
        TreeMapEntry<K, V> p10 = this.root;
        while (p10 != null) {
            int cmp = compare(key, p10.key);
            if (cmp < 0) {
                if (p10.left != null) {
                    p10 = p10.left;
                } else {
                    return p10;
                }
            } else if (p10.right != null) {
                p10 = p10.right;
            } else {
                TreeMapEntry<K, V> parent = p10.parent;
                TreeMapEntry<K, V> ch = p10;
                while (parent != null && ch == parent.right) {
                    ch = parent;
                    parent = parent.parent;
                }
                return parent;
            }
        }
        return null;
    }

    final TreeMapEntry<K, V> getLowerEntry(K key) {
        TreeMapEntry<K, V> p10 = this.root;
        while (p10 != null) {
            int cmp = compare(key, p10.key);
            if (cmp > 0) {
                if (p10.right != null) {
                    p10 = p10.right;
                } else {
                    return p10;
                }
            } else if (p10.left != null) {
                p10 = p10.left;
            } else {
                TreeMapEntry<K, V> parent = p10.parent;
                TreeMapEntry<K, V> ch = p10;
                while (parent != null && ch == parent.left) {
                    ch = parent;
                    parent = parent.parent;
                }
                return parent;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V put(K r9, V r10) {
        /*
            r8 = this;
            java.util.TreeMap$TreeMapEntry<K, V> r0 = r8.root
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L18
            r8.compare(r9, r9)
            java.util.TreeMap$TreeMapEntry r3 = new java.util.TreeMap$TreeMapEntry
            r3.<init>(r9, r10, r1)
            r8.root = r3
            r8.size = r2
            int r3 = r8.modCount
            int r3 = r3 + r2
            r8.modCount = r3
            return r1
        L18:
            java.util.Comparator<? super K> r3 = r8.comparator
            if (r3 == 0) goto L34
        L1c:
            r4 = r0
            K r5 = r0.key
            int r5 = r3.compare(r9, r5)
            if (r5 >= 0) goto L28
            java.util.TreeMap$TreeMapEntry<K, V> r0 = r0.left
            goto L2c
        L28:
            if (r5 <= 0) goto L2f
            java.util.TreeMap$TreeMapEntry<K, V> r0 = r0.right
        L2c:
            if (r0 != 0) goto L1c
            goto L4d
        L2f:
            java.lang.Object r1 = r0.setValue(r10)
            return r1
        L34:
            if (r9 == 0) goto L6c
            r4 = r9
            java.lang.Comparable r4 = (java.lang.Comparable) r4
        L39:
            r5 = r0
            K r6 = r0.key
            int r6 = r4.compareTo(r6)
            if (r6 >= 0) goto L45
            java.util.TreeMap$TreeMapEntry<K, V> r0 = r0.left
            goto L49
        L45:
            if (r6 <= 0) goto L67
            java.util.TreeMap$TreeMapEntry<K, V> r0 = r0.right
        L49:
            if (r0 != 0) goto L39
            r4 = r5
            r5 = r6
        L4d:
            java.util.TreeMap$TreeMapEntry r6 = new java.util.TreeMap$TreeMapEntry
            r6.<init>(r9, r10, r4)
            if (r5 >= 0) goto L57
            r4.left = r6
            goto L59
        L57:
            r4.right = r6
        L59:
            r8.fixAfterInsertion(r6)
            int r7 = r8.size
            int r7 = r7 + r2
            r8.size = r7
            int r7 = r8.modCount
            int r7 = r7 + r2
            r8.modCount = r7
            return r1
        L67:
            java.lang.Object r1 = r0.setValue(r10)
            return r1
        L6c:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TreeMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        TreeMapEntry<K, V> p10 = getEntry(key);
        if (p10 == null) {
            return null;
        }
        V oldValue = p10.value;
        deleteEntry(p10);
        return oldValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        this.size = 0;
        this.root = null;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            TreeMap<?, ?> clone = (TreeMap) super.clone();
            clone.root = null;
            clone.size = 0;
            clone.modCount = 0;
            clone.entrySet = null;
            clone.navigableKeySet = null;
            clone.descendingMap = null;
            try {
                clone.buildFromSorted(this.size, entrySet().iterator2(), null, null);
            } catch (IOException | ClassNotFoundException e2) {
            }
            return clone;
        } catch (CloneNotSupportedException e10) {
            throw new InternalError(e10);
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return exportEntry(getFirstEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return exportEntry(getLastEntry());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        TreeMapEntry<K, V> p10 = getFirstEntry();
        Map.Entry<K, V> result = exportEntry(p10);
        if (p10 != null) {
            deleteEntry(p10);
        }
        return result;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        TreeMapEntry<K, V> p10 = getLastEntry();
        Map.Entry<K, V> result = exportEntry(p10);
        if (p10 != null) {
            deleteEntry(p10);
        }
        return result;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K key) {
        return exportEntry(getLowerEntry(key));
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return (K) keyOrNull(getLowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K key) {
        return exportEntry(getFloorEntry(key));
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return (K) keyOrNull(getFloorEntry(k10));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K key) {
        return exportEntry(getCeilingEntry(key));
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return (K) keyOrNull(getCeilingEntry(k10));
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K key) {
        return exportEntry(getHigherEntry(key));
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return (K) keyOrNull(getHigherEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        KeySet<K> nks = this.navigableKeySet;
        if (nks != null) {
            return nks;
        }
        KeySet<K> keySet = new KeySet<>(this);
        this.navigableKeySet = keySet;
        return keySet;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
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

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        TreeMap<K, V>.EntrySet es = this.entrySet;
        if (es != null) {
            return es;
        }
        TreeMap<K, V>.EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        NavigableMap<K, V> km = this.descendingMap;
        if (km != null) {
            return km;
        }
        DescendingSubMap descendingSubMap = new DescendingSubMap(this, true, null, true, true, null, true);
        this.descendingMap = descendingSubMap;
        return descendingSubMap;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return new AscendingSubMap(this, false, fromKey, fromInclusive, false, toKey, toInclusive);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return new AscendingSubMap(this, true, null, true, false, toKey, inclusive);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return new AscendingSubMap(this, false, fromKey, inclusive, true, null, true);
    }

    @Override // java.util.NavigableMap
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    @Override // java.util.NavigableMap
    public SortedMap<K, V> headMap(K toKey) {
        return headMap(toKey, false);
    }

    @Override // java.util.NavigableMap
    public SortedMap<K, V> tailMap(K fromKey) {
        return tailMap(fromKey, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K key, V oldValue, V newValue) {
        TreeMapEntry<K, V> p10 = getEntry(key);
        if (p10 != null && Objects.equals(oldValue, p10.value)) {
            p10.value = newValue;
            return true;
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K key, V value) {
        TreeMapEntry<K, V> p10 = getEntry(key);
        if (p10 != null) {
            V oldValue = p10.value;
            p10.value = value;
            return oldValue;
        }
        return null;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Objects.requireNonNull(biConsumer);
        int i10 = this.modCount;
        for (TreeMapEntry<K, V> firstEntry = getFirstEntry(); firstEntry != null; firstEntry = successor(firstEntry)) {
            biConsumer.accept(firstEntry.key, firstEntry.value);
            if (i10 != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        int i10 = this.modCount;
        for (TreeMapEntry<K, V> firstEntry = getFirstEntry(); firstEntry != null; firstEntry = successor(firstEntry)) {
            firstEntry.value = biFunction.apply(firstEntry.key, firstEntry.value);
            if (i10 != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            TreeMap treeMap = TreeMap.this;
            return new ValueIterator(treeMap.getFirstEntry());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TreeMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return TreeMap.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            for (TreeMapEntry<K, V> e2 = TreeMap.this.getFirstEntry(); e2 != null; e2 = TreeMap.successor(e2)) {
                if (TreeMap.valEquals(e2.getValue(), o10)) {
                    TreeMap.this.deleteEntry(e2);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeMap.this.clear();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return new ValueSpliterator(TreeMap.this, null, null, 0, -1, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            TreeMap treeMap = TreeMap.this;
            return new EntryIterator(treeMap.getFirstEntry());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o10;
            Object value = entry.getValue();
            TreeMapEntry<K, V> p10 = TreeMap.this.getEntry(entry.getKey());
            return p10 != null && TreeMap.valEquals(p10.getValue(), value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o10;
            Object value = entry.getValue();
            TreeMapEntry<K, V> p10 = TreeMap.this.getEntry(entry.getKey());
            if (p10 == null || !TreeMap.valEquals(p10.getValue(), value)) {
                return false;
            }
            TreeMap.this.deleteEntry(p10);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TreeMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeMap.this.clear();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(TreeMap.this, null, null, 0, -1, 0);
        }
    }

    Iterator<K> keyIterator() {
        return new KeyIterator(getFirstEntry());
    }

    Iterator<K> descendingKeyIterator() {
        return new DescendingKeyIterator(getLastEntry());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeySet<E> extends AbstractSet<E> implements NavigableSet<E> {

        /* renamed from: m, reason: collision with root package name */
        private final NavigableMap<E, ?> f50485m;

        KeySet(NavigableMap<E, ?> map) {
            this.f50485m = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            NavigableMap<E, ?> navigableMap = this.f50485m;
            if (navigableMap instanceof TreeMap) {
                return ((TreeMap) navigableMap).keyIterator();
            }
            return ((NavigableSubMap) navigableMap).keyIterator();
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            NavigableMap<E, ?> navigableMap = this.f50485m;
            if (navigableMap instanceof TreeMap) {
                return ((TreeMap) navigableMap).descendingKeyIterator();
            }
            return ((NavigableSubMap) navigableMap).descendingKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50485m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50485m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50485m.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50485m.clear();
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.f50485m.lowerKey(e2);
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.f50485m.floorKey(e2);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.f50485m.ceilingKey(e2);
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.f50485m.higherKey(e2);
        }

        @Override // java.util.SortedSet
        public E first() {
            return this.f50485m.firstKey();
        }

        @Override // java.util.SortedSet
        public E last() {
            return this.f50485m.lastKey();
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.f50485m.comparator();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            Map.Entry<E, ?> e2 = this.f50485m.pollFirstEntry();
            if (e2 == null) {
                return null;
            }
            return e2.getKey();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            Map.Entry<E, ?> e2 = this.f50485m.pollLastEntry();
            if (e2 == null) {
                return null;
            }
            return e2.getKey();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            int oldSize = size();
            this.f50485m.remove(o10);
            return size() != oldSize;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return new KeySet(this.f50485m.subMap(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return new KeySet(this.f50485m.headMap(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return new KeySet(this.f50485m.tailMap(fromElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // java.util.NavigableSet
        public SortedSet<E> headSet(E toElement) {
            return headSet(toElement, false);
        }

        @Override // java.util.NavigableSet
        public SortedSet<E> tailSet(E fromElement) {
            return tailSet(fromElement, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new KeySet(this.f50485m.descendingMap());
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return TreeMap.keySpliteratorFor(this.f50485m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class PrivateEntryIterator<T> implements Iterator<T> {
        int expectedModCount;
        TreeMapEntry<K, V> lastReturned = null;
        TreeMapEntry<K, V> next;

        PrivateEntryIterator(TreeMapEntry<K, V> first) {
            this.expectedModCount = TreeMap.this.modCount;
            this.next = first;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        final TreeMapEntry<K, V> nextEntry() {
            TreeMapEntry<K, V> e2 = this.next;
            if (e2 == null) {
                throw new NoSuchElementException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = TreeMap.successor(e2);
            this.lastReturned = e2;
            return e2;
        }

        final TreeMapEntry<K, V> prevEntry() {
            TreeMapEntry<K, V> e2 = this.next;
            if (e2 == null) {
                throw new NoSuchElementException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = TreeMap.predecessor(e2);
            this.lastReturned = e2;
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastReturned.left != null && this.lastReturned.right != null) {
                this.next = this.lastReturned;
            }
            TreeMap.this.deleteEntry(this.lastReturned);
            this.expectedModCount = TreeMap.this.modCount;
            this.lastReturned = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class EntryIterator extends TreeMap<K, V>.PrivateEntryIterator<Map.Entry<K, V>> {
        EntryIterator(TreeMapEntry<K, V> first) {
            super(first);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class ValueIterator extends TreeMap<K, V>.PrivateEntryIterator<V> {
        ValueIterator(TreeMapEntry<K, V> first) {
            super(first);
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class KeyIterator extends TreeMap<K, V>.PrivateEntryIterator<K> {
        KeyIterator(TreeMapEntry<K, V> first) {
            super(first);
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class DescendingKeyIterator extends TreeMap<K, V>.PrivateEntryIterator<K> {
        DescendingKeyIterator(TreeMapEntry<K, V> first) {
            super(first);
        }

        @Override // java.util.Iterator
        public K next() {
            return prevEntry().key;
        }

        @Override // java.util.TreeMap.PrivateEntryIterator, java.util.Iterator
        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            if (TreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            TreeMap.this.deleteEntry(this.lastReturned);
            this.lastReturned = null;
            this.expectedModCount = TreeMap.this.modCount;
        }
    }

    final int compare(Object k12, Object k22) {
        Comparator<? super K> comparator = this.comparator;
        return comparator == null ? ((Comparable) k12).compareTo(k22) : comparator.compare(k12, k22);
    }

    static final boolean valEquals(Object o12, Object o22) {
        return o12 == null ? o22 == null : o12.equals(o22);
    }

    static <K, V> Map.Entry<K, V> exportEntry(TreeMapEntry<K, V> e2) {
        if (e2 == null) {
            return null;
        }
        return new AbstractMap.SimpleImmutableEntry(e2);
    }

    static <K, V> K keyOrNull(TreeMapEntry<K, V> e2) {
        if (e2 == null) {
            return null;
        }
        return e2.key;
    }

    static <K> K key(TreeMapEntry<K, ?> e2) {
        if (e2 == null) {
            throw new NoSuchElementException();
        }
        return e2.key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class NavigableSubMap<K, V> extends AbstractMap<K, V> implements NavigableMap<K, V>, Serializable {
        private static final long serialVersionUID = 2765629423043303731L;
        transient NavigableMap<K, V> descendingMapView;
        transient NavigableSubMap<K, V>.EntrySetView entrySetView;
        final boolean fromStart;
        final K hi;
        final boolean hiInclusive;
        final K lo;
        final boolean loInclusive;

        /* renamed from: m, reason: collision with root package name */
        final TreeMap<K, V> f50486m;
        transient KeySet<K> navigableKeySetView;
        final boolean toEnd;

        abstract Iterator<K> descendingKeyIterator();

        abstract Iterator<K> keyIterator();

        abstract Spliterator<K> keySpliterator();

        abstract TreeMapEntry<K, V> subCeiling(K k10);

        abstract TreeMapEntry<K, V> subFloor(K k10);

        abstract TreeMapEntry<K, V> subHigher(K k10);

        abstract TreeMapEntry<K, V> subHighest();

        abstract TreeMapEntry<K, V> subLower(K k10);

        abstract TreeMapEntry<K, V> subLowest();

        NavigableSubMap(TreeMap<K, V> m10, boolean fromStart, K lo, boolean loInclusive, boolean toEnd, K hi, boolean hiInclusive) {
            if (!fromStart && !toEnd) {
                if (m10.compare(lo, hi) > 0) {
                    throw new IllegalArgumentException("fromKey > toKey");
                }
            } else {
                if (!fromStart) {
                    m10.compare(lo, lo);
                }
                if (!toEnd) {
                    m10.compare(hi, hi);
                }
            }
            this.f50486m = m10;
            this.fromStart = fromStart;
            this.lo = lo;
            this.loInclusive = loInclusive;
            this.toEnd = toEnd;
            this.hi = hi;
            this.hiInclusive = hiInclusive;
        }

        final boolean tooLow(Object key) {
            if (!this.fromStart) {
                int c4 = this.f50486m.compare(key, this.lo);
                if (c4 < 0) {
                    return true;
                }
                if (c4 == 0 && !this.loInclusive) {
                    return true;
                }
                return false;
            }
            return false;
        }

        final boolean tooHigh(Object key) {
            if (!this.toEnd) {
                int c4 = this.f50486m.compare(key, this.hi);
                if (c4 > 0) {
                    return true;
                }
                if (c4 == 0 && !this.hiInclusive) {
                    return true;
                }
                return false;
            }
            return false;
        }

        final boolean inRange(Object key) {
            return (tooLow(key) || tooHigh(key)) ? false : true;
        }

        final boolean inClosedRange(Object key) {
            return (this.fromStart || this.f50486m.compare(key, this.lo) >= 0) && (this.toEnd || this.f50486m.compare(this.hi, key) >= 0);
        }

        final boolean inRange(Object key, boolean inclusive) {
            return inclusive ? inRange(key) : inClosedRange(key);
        }

        final TreeMapEntry<K, V> absLowest() {
            TreeMapEntry<K, V> e2;
            if (this.fromStart) {
                e2 = this.f50486m.getFirstEntry();
            } else {
                e2 = this.loInclusive ? this.f50486m.getCeilingEntry(this.lo) : this.f50486m.getHigherEntry(this.lo);
            }
            if (e2 == null || tooHigh(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absHighest() {
            TreeMapEntry<K, V> e2;
            if (this.toEnd) {
                e2 = this.f50486m.getLastEntry();
            } else {
                e2 = this.hiInclusive ? this.f50486m.getFloorEntry(this.hi) : this.f50486m.getLowerEntry(this.hi);
            }
            if (e2 == null || tooLow(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absCeiling(K key) {
            if (tooLow(key)) {
                return absLowest();
            }
            TreeMapEntry<K, V> e2 = this.f50486m.getCeilingEntry(key);
            if (e2 == null || tooHigh(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absHigher(K key) {
            if (tooLow(key)) {
                return absLowest();
            }
            TreeMapEntry<K, V> e2 = this.f50486m.getHigherEntry(key);
            if (e2 == null || tooHigh(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absFloor(K key) {
            if (tooHigh(key)) {
                return absHighest();
            }
            TreeMapEntry<K, V> e2 = this.f50486m.getFloorEntry(key);
            if (e2 == null || tooLow(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absLower(K key) {
            if (tooHigh(key)) {
                return absHighest();
            }
            TreeMapEntry<K, V> e2 = this.f50486m.getLowerEntry(key);
            if (e2 == null || tooLow(e2.key)) {
                return null;
            }
            return e2;
        }

        final TreeMapEntry<K, V> absHighFence() {
            if (this.toEnd) {
                return null;
            }
            if (this.hiInclusive) {
                return this.f50486m.getHigherEntry(this.hi);
            }
            return this.f50486m.getCeilingEntry(this.hi);
        }

        final TreeMapEntry<K, V> absLowFence() {
            if (this.fromStart) {
                return null;
            }
            if (this.loInclusive) {
                return this.f50486m.getLowerEntry(this.lo);
            }
            return this.f50486m.getFloorEntry(this.lo);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return (this.fromStart && this.toEnd) ? this.f50486m.isEmpty() : entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return (this.fromStart && this.toEnd) ? this.f50486m.size() : entrySet().size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object key) {
            return inRange(key) && this.f50486m.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final V put(K key, V value) {
            if (!inRange(key)) {
                throw new IllegalArgumentException("key out of range");
            }
            return this.f50486m.put(key, value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final V get(Object key) {
            if (inRange(key)) {
                return this.f50486m.get(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final V remove(Object key) {
            if (inRange(key)) {
                return this.f50486m.remove(key);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> ceilingEntry(K key) {
            return TreeMap.exportEntry(subCeiling(key));
        }

        @Override // java.util.NavigableMap
        public final K ceilingKey(K k10) {
            return (K) TreeMap.keyOrNull(subCeiling(k10));
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> higherEntry(K key) {
            return TreeMap.exportEntry(subHigher(key));
        }

        @Override // java.util.NavigableMap
        public final K higherKey(K k10) {
            return (K) TreeMap.keyOrNull(subHigher(k10));
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> floorEntry(K key) {
            return TreeMap.exportEntry(subFloor(key));
        }

        @Override // java.util.NavigableMap
        public final K floorKey(K k10) {
            return (K) TreeMap.keyOrNull(subFloor(k10));
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> lowerEntry(K key) {
            return TreeMap.exportEntry(subLower(key));
        }

        @Override // java.util.NavigableMap
        public final K lowerKey(K k10) {
            return (K) TreeMap.keyOrNull(subLower(k10));
        }

        @Override // java.util.SortedMap
        public final K firstKey() {
            return (K) TreeMap.key(subLowest());
        }

        @Override // java.util.SortedMap
        public final K lastKey() {
            return (K) TreeMap.key(subHighest());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> firstEntry() {
            return TreeMap.exportEntry(subLowest());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> lastEntry() {
            return TreeMap.exportEntry(subHighest());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            TreeMapEntry<K, V> e2 = subLowest();
            Map.Entry<K, V> result = TreeMap.exportEntry(e2);
            if (e2 != null) {
                this.f50486m.deleteEntry(e2);
            }
            return result;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            TreeMapEntry<K, V> e2 = subHighest();
            Map.Entry<K, V> result = TreeMap.exportEntry(e2);
            if (e2 != null) {
                this.f50486m.deleteEntry(e2);
            }
            return result;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> navigableKeySet() {
            KeySet<K> nksv = this.navigableKeySetView;
            if (nksv != null) {
                return nksv;
            }
            KeySet<K> keySet = new KeySet<>(this);
            this.navigableKeySetView = keySet;
            return keySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public final Set<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final SortedMap<K, V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // java.util.NavigableMap
        public final SortedMap<K, V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        public final SortedMap<K, V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        abstract class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
            private transient int size = -1;
            private transient int sizeModCount;

            EntrySetView() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                if (NavigableSubMap.this.fromStart && NavigableSubMap.this.toEnd) {
                    return NavigableSubMap.this.f50486m.size();
                }
                if (this.size == -1 || this.sizeModCount != ((TreeMap) NavigableSubMap.this.f50486m).modCount) {
                    this.sizeModCount = ((TreeMap) NavigableSubMap.this.f50486m).modCount;
                    this.size = 0;
                    Iterator<?> i10 = iterator2();
                    while (i10.hasNext()) {
                        this.size++;
                        i10.next();
                    }
                }
                return this.size;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                TreeMapEntry<K, V> n10 = NavigableSubMap.this.absLowest();
                return n10 == null || NavigableSubMap.this.tooHigh(n10.key);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o10) {
                TreeMapEntry<K, V> entry;
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry2 = (Map.Entry) o10;
                Object key = entry2.getKey();
                return NavigableSubMap.this.inRange(key) && (entry = NavigableSubMap.this.f50486m.getEntry(key)) != null && TreeMap.valEquals(entry.getValue(), entry2.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o10) {
                TreeMapEntry<K, V> node;
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> entry = (Map.Entry) o10;
                Object key = entry.getKey();
                if (!NavigableSubMap.this.inRange(key) || (node = NavigableSubMap.this.f50486m.getEntry(key)) == null || !TreeMap.valEquals(node.getValue(), entry.getValue())) {
                    return false;
                }
                NavigableSubMap.this.f50486m.deleteEntry(node);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public abstract class SubMapIterator<T> implements Iterator<T> {
            int expectedModCount;
            final Object fenceKey;
            TreeMapEntry<K, V> lastReturned = null;
            TreeMapEntry<K, V> next;

            SubMapIterator(TreeMapEntry<K, V> first, TreeMapEntry<K, V> fence) {
                this.expectedModCount = ((TreeMap) NavigableSubMap.this.f50486m).modCount;
                this.next = first;
                this.fenceKey = fence == null ? TreeMap.UNBOUNDED : fence.key;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                TreeMapEntry<K, V> treeMapEntry = this.next;
                return (treeMapEntry == null || treeMapEntry.key == this.fenceKey) ? false : true;
            }

            final TreeMapEntry<K, V> nextEntry() {
                TreeMapEntry<K, V> e2 = this.next;
                if (e2 == null || e2.key == this.fenceKey) {
                    throw new NoSuchElementException();
                }
                if (((TreeMap) NavigableSubMap.this.f50486m).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                this.next = TreeMap.successor(e2);
                this.lastReturned = e2;
                return e2;
            }

            final TreeMapEntry<K, V> prevEntry() {
                TreeMapEntry<K, V> e2 = this.next;
                if (e2 == null || e2.key == this.fenceKey) {
                    throw new NoSuchElementException();
                }
                if (((TreeMap) NavigableSubMap.this.f50486m).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                this.next = TreeMap.predecessor(e2);
                this.lastReturned = e2;
                return e2;
            }

            final void removeAscending() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                }
                if (((TreeMap) NavigableSubMap.this.f50486m).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.lastReturned.left != null && this.lastReturned.right != null) {
                    this.next = this.lastReturned;
                }
                NavigableSubMap.this.f50486m.deleteEntry(this.lastReturned);
                this.lastReturned = null;
                this.expectedModCount = ((TreeMap) NavigableSubMap.this.f50486m).modCount;
            }

            final void removeDescending() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                }
                if (((TreeMap) NavigableSubMap.this.f50486m).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                NavigableSubMap.this.f50486m.deleteEntry(this.lastReturned);
                this.lastReturned = null;
                this.expectedModCount = ((TreeMap) NavigableSubMap.this.f50486m).modCount;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class SubMapEntryIterator extends NavigableSubMap<K, V>.SubMapIterator<Map.Entry<K, V>> {
            SubMapEntryIterator(TreeMapEntry<K, V> first, TreeMapEntry<K, V> fence) {
                super(first, fence);
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return nextEntry();
            }

            @Override // java.util.Iterator
            public void remove() {
                removeAscending();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class DescendingSubMapEntryIterator extends NavigableSubMap<K, V>.SubMapIterator<Map.Entry<K, V>> {
            DescendingSubMapEntryIterator(TreeMapEntry<K, V> last, TreeMapEntry<K, V> fence) {
                super(last, fence);
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return prevEntry();
            }

            @Override // java.util.Iterator
            public void remove() {
                removeDescending();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class SubMapKeyIterator extends NavigableSubMap<K, V>.SubMapIterator<K> implements Spliterator<K> {
            SubMapKeyIterator(TreeMapEntry<K, V> first, TreeMapEntry<K, V> fence) {
                super(first, fence);
            }

            @Override // java.util.Iterator
            public K next() {
                return nextEntry().key;
            }

            @Override // java.util.Iterator
            public void remove() {
                removeAscending();
            }

            @Override // java.util.Spliterator
            public Spliterator<K> trySplit() {
                return null;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super K> consumer) {
                while (hasNext()) {
                    consumer.accept((Object) next());
                }
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super K> consumer) {
                if (hasNext()) {
                    consumer.accept((Object) next());
                    return true;
                }
                return false;
            }

            @Override // java.util.Spliterator
            public long estimateSize() {
                return Long.MAX_VALUE;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return 21;
            }

            @Override // java.util.Spliterator
            public final Comparator<? super K> getComparator() {
                return NavigableSubMap.this.comparator();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class DescendingSubMapKeyIterator extends NavigableSubMap<K, V>.SubMapIterator<K> implements Spliterator<K> {
            DescendingSubMapKeyIterator(TreeMapEntry<K, V> last, TreeMapEntry<K, V> fence) {
                super(last, fence);
            }

            @Override // java.util.Iterator
            public K next() {
                return prevEntry().key;
            }

            @Override // java.util.Iterator
            public void remove() {
                removeDescending();
            }

            @Override // java.util.Spliterator
            public Spliterator<K> trySplit() {
                return null;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super K> consumer) {
                while (hasNext()) {
                    consumer.accept((Object) next());
                }
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super K> consumer) {
                if (hasNext()) {
                    consumer.accept((Object) next());
                    return true;
                }
                return false;
            }

            @Override // java.util.Spliterator
            public long estimateSize() {
                return Long.MAX_VALUE;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return 17;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class AscendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866124060L;

        AscendingSubMap(TreeMap<K, V> m10, boolean fromStart, K lo, boolean loInclusive, boolean toEnd, K hi, boolean hiInclusive) {
            super(m10, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.f50486m.comparator();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            if (!inRange(fromKey, fromInclusive)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            if (!inRange(toKey, toInclusive)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new AscendingSubMap(this.f50486m, false, fromKey, fromInclusive, false, toKey, toInclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            if (!inRange(toKey) && (this.toEnd || this.f50486m.compare(toKey, this.hi) != 0 || this.hiInclusive || inclusive)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new AscendingSubMap(this.f50486m, this.fromStart, this.lo, this.loInclusive, false, toKey, inclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            if (!inRange(fromKey) && (this.fromStart || this.f50486m.compare(fromKey, this.lo) != 0 || this.loInclusive || inclusive)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            return new AscendingSubMap(this.f50486m, false, fromKey, inclusive, this.toEnd, this.hi, this.hiInclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> mv = this.descendingMapView;
            if (mv != null) {
                return mv;
            }
            DescendingSubMap descendingSubMap = new DescendingSubMap(this.f50486m, this.fromStart, this.lo, this.loInclusive, this.toEnd, this.hi, this.hiInclusive);
            this.descendingMapView = descendingSubMap;
            return descendingSubMap;
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Iterator<K> keyIterator() {
            return new NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Spliterator<K> keySpliterator() {
            return new NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Iterator<K> descendingKeyIterator() {
            return new NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class AscendingEntrySetView extends NavigableSubMap<K, V>.EntrySetView {
            AscendingEntrySetView() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                AscendingSubMap ascendingSubMap = AscendingSubMap.this;
                return new NavigableSubMap.SubMapEntryIterator(ascendingSubMap.absLowest(), AscendingSubMap.this.absHighFence());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            NavigableSubMap<K, V>.EntrySetView es = this.entrySetView;
            if (es != null) {
                return es;
            }
            AscendingEntrySetView ascendingEntrySetView = new AscendingEntrySetView();
            this.entrySetView = ascendingEntrySetView;
            return ascendingEntrySetView;
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subLowest() {
            return absLowest();
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subHighest() {
            return absHighest();
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subCeiling(K key) {
            return absCeiling(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subHigher(K key) {
            return absHigher(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subFloor(K key) {
            return absFloor(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subLower(K key) {
            return absLower(key);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DescendingSubMap<K, V> extends NavigableSubMap<K, V> {
        private static final long serialVersionUID = 912986545866120460L;
        private final Comparator<? super K> reverseComparator;

        DescendingSubMap(TreeMap<K, V> m10, boolean fromStart, K lo, boolean loInclusive, boolean toEnd, K hi, boolean hiInclusive) {
            super(m10, fromStart, lo, loInclusive, toEnd, hi, hiInclusive);
            this.reverseComparator = Collections.reverseOrder(((TreeMap) this.f50486m).comparator);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.reverseComparator;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            if (!inRange(fromKey, fromInclusive)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            if (!inRange(toKey, toInclusive)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new DescendingSubMap(this.f50486m, false, toKey, toInclusive, false, fromKey, fromInclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            if (!inRange(toKey) && (this.fromStart || this.f50486m.compare(toKey, this.lo) != 0 || this.loInclusive || inclusive)) {
                throw new IllegalArgumentException("toKey out of range");
            }
            return new DescendingSubMap(this.f50486m, false, toKey, inclusive, this.toEnd, this.hi, this.hiInclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            if (!inRange(fromKey) && (this.toEnd || this.f50486m.compare(fromKey, this.hi) != 0 || this.hiInclusive || inclusive)) {
                throw new IllegalArgumentException("fromKey out of range");
            }
            return new DescendingSubMap(this.f50486m, this.fromStart, this.lo, this.loInclusive, false, fromKey, inclusive);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            NavigableMap<K, V> mv = this.descendingMapView;
            if (mv != null) {
                return mv;
            }
            AscendingSubMap ascendingSubMap = new AscendingSubMap(this.f50486m, this.fromStart, this.lo, this.loInclusive, this.toEnd, this.hi, this.hiInclusive);
            this.descendingMapView = ascendingSubMap;
            return ascendingSubMap;
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Iterator<K> keyIterator() {
            return new NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Spliterator<K> keySpliterator() {
            return new NavigableSubMap.DescendingSubMapKeyIterator(absHighest(), absLowFence());
        }

        @Override // java.util.TreeMap.NavigableSubMap
        Iterator<K> descendingKeyIterator() {
            return new NavigableSubMap.SubMapKeyIterator(absLowest(), absHighFence());
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class DescendingEntrySetView extends NavigableSubMap<K, V>.EntrySetView {
            DescendingEntrySetView() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                DescendingSubMap descendingSubMap = DescendingSubMap.this;
                return new NavigableSubMap.DescendingSubMapEntryIterator(descendingSubMap.absHighest(), DescendingSubMap.this.absLowFence());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            NavigableSubMap<K, V>.EntrySetView es = this.entrySetView;
            if (es != null) {
                return es;
            }
            DescendingEntrySetView descendingEntrySetView = new DescendingEntrySetView();
            this.entrySetView = descendingEntrySetView;
            return descendingEntrySetView;
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subLowest() {
            return absHighest();
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subHighest() {
            return absLowest();
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subCeiling(K key) {
            return absFloor(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subHigher(K key) {
            return absLower(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subFloor(K key) {
            return absCeiling(key);
        }

        @Override // java.util.TreeMap.NavigableSubMap
        TreeMapEntry<K, V> subLower(K key) {
            return absHigher(key);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class SubMap extends AbstractMap<K, V> implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -6520786458950516097L;
        private K fromKey;
        private K toKey;
        private boolean fromStart = false;
        private boolean toEnd = false;

        private SubMap() {
        }

        private Object readResolve() {
            return new AscendingSubMap(TreeMap.this, this.fromStart, this.fromKey, true, this.toEnd, this.toKey, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new InternalError();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            throw new InternalError();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            throw new InternalError();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            throw new InternalError();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K toKey) {
            throw new InternalError();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K fromKey) {
            throw new InternalError();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            throw new InternalError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TreeMapEntry<K, V> implements Map.Entry<K, V> {
        boolean color = true;
        K key;
        TreeMapEntry<K, V> left;
        TreeMapEntry<K, V> parent;
        TreeMapEntry<K, V> right;
        V value;

        TreeMapEntry(K key, V value, TreeMapEntry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
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
            return TreeMap.valEquals(this.key, e2.getKey()) && TreeMap.valEquals(this.value, e2.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int keyHash = k10 == null ? 0 : k10.hashCode();
            V v2 = this.value;
            int valueHash = v2 != null ? v2.hashCode() : 0;
            return keyHash ^ valueHash;
        }

        public String toString() {
            return ((Object) this.key) + "=" + ((Object) this.value);
        }
    }

    final TreeMapEntry<K, V> getFirstEntry() {
        TreeMapEntry<K, V> p10 = this.root;
        if (p10 != null) {
            while (p10.left != null) {
                p10 = p10.left;
            }
        }
        return p10;
    }

    final TreeMapEntry<K, V> getLastEntry() {
        TreeMapEntry<K, V> p10 = this.root;
        if (p10 != null) {
            while (p10.right != null) {
                p10 = p10.right;
            }
        }
        return p10;
    }

    static <K, V> TreeMapEntry<K, V> successor(TreeMapEntry<K, V> t2) {
        if (t2 == null) {
            return null;
        }
        if (t2.right != null) {
            TreeMapEntry<K, V> p10 = t2.right;
            while (p10.left != null) {
                p10 = p10.left;
            }
            return p10;
        }
        TreeMapEntry<K, V> p11 = t2.parent;
        TreeMapEntry<K, V> ch = t2;
        while (p11 != null && ch == p11.right) {
            ch = p11;
            p11 = p11.parent;
        }
        return p11;
    }

    static <K, V> TreeMapEntry<K, V> predecessor(TreeMapEntry<K, V> t2) {
        if (t2 == null) {
            return null;
        }
        if (t2.left != null) {
            TreeMapEntry<K, V> p10 = t2.left;
            while (p10.right != null) {
                p10 = p10.right;
            }
            return p10;
        }
        TreeMapEntry<K, V> p11 = t2.parent;
        TreeMapEntry<K, V> ch = t2;
        while (p11 != null && ch == p11.left) {
            ch = p11;
            p11 = p11.parent;
        }
        return p11;
    }

    private static <K, V> boolean colorOf(TreeMapEntry<K, V> p10) {
        if (p10 == null) {
            return true;
        }
        return p10.color;
    }

    private static <K, V> TreeMapEntry<K, V> parentOf(TreeMapEntry<K, V> p10) {
        if (p10 == null) {
            return null;
        }
        return p10.parent;
    }

    private static <K, V> void setColor(TreeMapEntry<K, V> p10, boolean c4) {
        if (p10 != null) {
            p10.color = c4;
        }
    }

    private static <K, V> TreeMapEntry<K, V> leftOf(TreeMapEntry<K, V> p10) {
        if (p10 == null) {
            return null;
        }
        return p10.left;
    }

    private static <K, V> TreeMapEntry<K, V> rightOf(TreeMapEntry<K, V> p10) {
        if (p10 == null) {
            return null;
        }
        return p10.right;
    }

    private void rotateLeft(TreeMapEntry<K, V> p10) {
        if (p10 != null) {
            TreeMapEntry<K, V> r10 = p10.right;
            p10.right = r10.left;
            if (r10.left != null) {
                r10.left.parent = p10;
            }
            r10.parent = p10.parent;
            if (p10.parent == null) {
                this.root = r10;
            } else if (p10.parent.left == p10) {
                p10.parent.left = r10;
            } else {
                p10.parent.right = r10;
            }
            r10.left = p10;
            p10.parent = r10;
        }
    }

    private void rotateRight(TreeMapEntry<K, V> p10) {
        if (p10 != null) {
            TreeMapEntry<K, V> l10 = p10.left;
            p10.left = l10.right;
            if (l10.right != null) {
                l10.right.parent = p10;
            }
            l10.parent = p10.parent;
            if (p10.parent == null) {
                this.root = l10;
            } else if (p10.parent.right == p10) {
                p10.parent.right = l10;
            } else {
                p10.parent.left = l10;
            }
            l10.right = p10;
            p10.parent = l10;
        }
    }

    private void fixAfterInsertion(TreeMapEntry<K, V> x10) {
        x10.color = false;
        while (x10 != null && x10 != this.root && !x10.parent.color) {
            if (parentOf(x10) == leftOf(parentOf(parentOf(x10)))) {
                TreeMapEntry<K, V> y10 = rightOf(parentOf(parentOf(x10)));
                if (!colorOf(y10)) {
                    setColor(parentOf(x10), true);
                    setColor(y10, true);
                    setColor(parentOf(parentOf(x10)), false);
                    x10 = parentOf(parentOf(x10));
                } else {
                    if (x10 == rightOf(parentOf(x10))) {
                        x10 = parentOf(x10);
                        rotateLeft(x10);
                    }
                    setColor(parentOf(x10), true);
                    setColor(parentOf(parentOf(x10)), false);
                    rotateRight(parentOf(parentOf(x10)));
                }
            } else {
                TreeMapEntry<K, V> y11 = leftOf(parentOf(parentOf(x10)));
                if (!colorOf(y11)) {
                    setColor(parentOf(x10), true);
                    setColor(y11, true);
                    setColor(parentOf(parentOf(x10)), false);
                    x10 = parentOf(parentOf(x10));
                } else {
                    if (x10 == leftOf(parentOf(x10))) {
                        x10 = parentOf(x10);
                        rotateRight(x10);
                    }
                    setColor(parentOf(x10), true);
                    setColor(parentOf(parentOf(x10)), false);
                    rotateLeft(parentOf(parentOf(x10)));
                }
            }
        }
        this.root.color = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteEntry(TreeMapEntry<K, V> p10) {
        this.modCount++;
        this.size--;
        if (p10.left != null && p10.right != null) {
            TreeMapEntry<K, V> s2 = successor(p10);
            p10.key = s2.key;
            p10.value = s2.value;
            p10 = s2;
        }
        TreeMapEntry<K, V> replacement = p10.left != null ? p10.left : p10.right;
        if (replacement != null) {
            replacement.parent = p10.parent;
            if (p10.parent == null) {
                this.root = replacement;
            } else if (p10 == p10.parent.left) {
                p10.parent.left = replacement;
            } else {
                p10.parent.right = replacement;
            }
            p10.parent = null;
            p10.right = null;
            p10.left = null;
            if (p10.color) {
                fixAfterDeletion(replacement);
                return;
            }
            return;
        }
        if (p10.parent == null) {
            this.root = null;
            return;
        }
        if (p10.color) {
            fixAfterDeletion(p10);
        }
        if (p10.parent != null) {
            if (p10 == p10.parent.left) {
                p10.parent.left = null;
            } else if (p10 == p10.parent.right) {
                p10.parent.right = null;
            }
            p10.parent = null;
        }
    }

    private void fixAfterDeletion(TreeMapEntry<K, V> x10) {
        while (x10 != this.root && colorOf(x10)) {
            if (x10 == leftOf(parentOf(x10))) {
                TreeMapEntry<K, V> sib = rightOf(parentOf(x10));
                if (!colorOf(sib)) {
                    setColor(sib, true);
                    setColor(parentOf(x10), false);
                    rotateLeft(parentOf(x10));
                    sib = rightOf(parentOf(x10));
                }
                if (colorOf(leftOf(sib)) && colorOf(rightOf(sib))) {
                    setColor(sib, false);
                    x10 = parentOf(x10);
                } else {
                    if (colorOf(rightOf(sib))) {
                        setColor(leftOf(sib), true);
                        setColor(sib, false);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x10));
                    }
                    setColor(sib, colorOf(parentOf(x10)));
                    setColor(parentOf(x10), true);
                    setColor(rightOf(sib), true);
                    rotateLeft(parentOf(x10));
                    x10 = this.root;
                }
            } else {
                TreeMapEntry<K, V> sib2 = leftOf(parentOf(x10));
                if (!colorOf(sib2)) {
                    setColor(sib2, true);
                    setColor(parentOf(x10), false);
                    rotateRight(parentOf(x10));
                    sib2 = leftOf(parentOf(x10));
                }
                if (colorOf(rightOf(sib2)) && colorOf(leftOf(sib2))) {
                    setColor(sib2, false);
                    x10 = parentOf(x10);
                } else {
                    if (colorOf(leftOf(sib2))) {
                        setColor(rightOf(sib2), true);
                        setColor(sib2, false);
                        rotateLeft(sib2);
                        sib2 = leftOf(parentOf(x10));
                    }
                    setColor(sib2, colorOf(parentOf(x10)));
                    setColor(parentOf(x10), true);
                    setColor(leftOf(sib2), true);
                    rotateRight(parentOf(x10));
                    x10 = this.root;
                }
            }
        }
        setColor(x10, true);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.size);
        for (Map.Entry<K, V> e2 : entrySet()) {
            s2.writeObject(e2.getKey());
            s2.writeObject(e2.getValue());
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        int size = s2.readInt();
        buildFromSorted(size, null, s2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readTreeSet(int size, ObjectInputStream s2, V defaultVal) throws IOException, ClassNotFoundException {
        buildFromSorted(size, null, s2, defaultVal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAllForTreeSet(SortedSet<? extends K> set, V defaultVal) {
        try {
            buildFromSorted(set.size(), set.iterator2(), null, defaultVal);
        } catch (IOException | ClassNotFoundException e2) {
        }
    }

    private void buildFromSorted(int size, Iterator<?> it, ObjectInputStream str, V defaultVal) throws IOException, ClassNotFoundException {
        this.size = size;
        this.root = buildFromSorted(0, 0, size - 1, computeRedLevel(size), it, str, defaultVal);
    }

    private final TreeMapEntry<K, V> buildFromSorted(int level, int lo, int hi, int redLevel, Iterator<?> it, ObjectInputStream str, V defaultVal) throws IOException, ClassNotFoundException {
        Object readObject;
        Object obj;
        if (hi < lo) {
            return null;
        }
        int mid = (lo + hi) >>> 1;
        TreeMapEntry<K, V> left = null;
        if (lo < mid) {
            left = buildFromSorted(level + 1, lo, mid - 1, redLevel, it, str, defaultVal);
        }
        if (it != null) {
            if (defaultVal == null) {
                Map.Entry<?, ?> entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                readObject = entry.getValue();
                obj = key;
            } else {
                readObject = defaultVal;
                obj = it.next();
            }
        } else {
            Object readObject2 = str.readObject();
            readObject = defaultVal != null ? defaultVal : str.readObject();
            obj = readObject2;
        }
        TreeMapEntry<K, V> middle = new TreeMapEntry<>(obj, readObject, null);
        if (level == redLevel) {
            middle.color = false;
        }
        if (left != null) {
            middle.left = left;
            left.parent = middle;
        }
        if (mid < hi) {
            TreeMapEntry<K, V> right = buildFromSorted(level + 1, mid + 1, hi, redLevel, it, str, defaultVal);
            middle.right = right;
            right.parent = middle;
        }
        return middle;
    }

    private static int computeRedLevel(int size) {
        return 31 - Integer.numberOfLeadingZeros(size + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> Spliterator<K> keySpliteratorFor(NavigableMap<K, ?> m10) {
        if (m10 instanceof TreeMap) {
            TreeMap<K, Object> t2 = (TreeMap) m10;
            return t2.keySpliterator();
        }
        if (m10 instanceof DescendingSubMap) {
            DescendingSubMap<K, ?> dm = (DescendingSubMap) m10;
            TreeMap<K, V> treeMap = dm.f50486m;
            if (dm == ((TreeMap) treeMap).descendingMap) {
                return treeMap.descendingKeySpliterator();
            }
        }
        NavigableSubMap<K, ?> sm = (NavigableSubMap) m10;
        return sm.keySpliterator();
    }

    final Spliterator<K> keySpliterator() {
        return new KeySpliterator(this, null, null, 0, -1, 0);
    }

    final Spliterator<K> descendingKeySpliterator() {
        return new DescendingKeySpliterator(this, null, null, 0, -2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class TreeMapSpliterator<K, V> {
        TreeMapEntry<K, V> current;
        int est;
        int expectedModCount;
        TreeMapEntry<K, V> fence;
        int side;
        final TreeMap<K, V> tree;

        TreeMapSpliterator(TreeMap<K, V> tree, TreeMapEntry<K, V> origin, TreeMapEntry<K, V> fence, int side, int est, int expectedModCount) {
            this.tree = tree;
            this.current = origin;
            this.fence = fence;
            this.side = side;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getEstimate() {
            int s2 = this.est;
            if (s2 >= 0) {
                return s2;
            }
            TreeMap<K, V> t2 = this.tree;
            if (t2 != null) {
                this.current = s2 == -1 ? t2.getFirstEntry() : t2.getLastEntry();
                int s10 = ((TreeMap) t2).size;
                this.est = s10;
                this.expectedModCount = ((TreeMap) t2).modCount;
                return s10;
            }
            this.est = 0;
            return 0;
        }

        public final long estimateSize() {
            return getEstimate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<K> {
        KeySpliterator(TreeMap<K, V> tree, TreeMapEntry<K, V> origin, TreeMapEntry<K, V> fence, int side, int est, int expectedModCount) {
            super(tree, origin, fence, side, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            TreeMapEntry<K, V> treeMapEntry;
            if (this.est < 0) {
                getEstimate();
            }
            int d10 = this.side;
            TreeMapEntry<K, V> e2 = this.current;
            TreeMapEntry<K, V> f10 = this.fence;
            if (e2 == null || e2 == f10) {
                treeMapEntry = null;
            } else if (d10 == 0) {
                treeMapEntry = ((TreeMap) this.tree).root;
            } else if (d10 > 0) {
                treeMapEntry = e2.right;
            } else {
                treeMapEntry = (d10 >= 0 || f10 == null) ? null : f10.left;
            }
            TreeMapEntry<K, V> s2 = treeMapEntry;
            if (s2 == null || s2 == e2 || s2 == f10 || this.tree.compare(e2.key, s2.key) >= 0) {
                return null;
            }
            this.side = 1;
            TreeMap<K, V> treeMap = this.tree;
            this.current = s2;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new KeySpliterator<>(treeMap, e2, s2, -1, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.fence;
            TreeMapEntry<K, V> treeMapEntry2 = this.current;
            TreeMapEntry<K, V> treeMapEntry3 = treeMapEntry2;
            if (treeMapEntry2 != null && treeMapEntry3 != treeMapEntry) {
                this.current = treeMapEntry;
                do {
                    consumer.accept(treeMapEntry3.key);
                    TreeMapEntry<K, V> treeMapEntry4 = treeMapEntry3.right;
                    TreeMapEntry<K, V> treeMapEntry5 = treeMapEntry4;
                    if (treeMapEntry4 == null) {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry6 = treeMapEntry3.parent;
                            treeMapEntry5 = treeMapEntry6;
                            if (treeMapEntry6 == null || treeMapEntry3 != treeMapEntry5.right) {
                                break;
                            } else {
                                treeMapEntry3 = treeMapEntry5;
                            }
                        }
                    } else {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry7 = treeMapEntry5.left;
                            if (treeMapEntry7 == null) {
                                break;
                            } else {
                                treeMapEntry5 = treeMapEntry7;
                            }
                        }
                    }
                    treeMapEntry3 = treeMapEntry5;
                    if (treeMapEntry5 == null) {
                        break;
                    }
                } while (treeMapEntry3 != treeMapEntry);
                if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.current;
            if (treeMapEntry == null || treeMapEntry == this.fence) {
                return false;
            }
            this.current = TreeMap.successor(treeMapEntry);
            consumer.accept(treeMapEntry.key);
            if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.side == 0 ? 64 : 0) | 1 | 4 | 16;
        }

        @Override // java.util.Spliterator
        public final Comparator<? super K> getComparator() {
            return ((TreeMap) this.tree).comparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DescendingKeySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<K> {
        DescendingKeySpliterator(TreeMap<K, V> tree, TreeMapEntry<K, V> origin, TreeMapEntry<K, V> fence, int side, int est, int expectedModCount) {
            super(tree, origin, fence, side, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public DescendingKeySpliterator<K, V> trySplit() {
            TreeMapEntry<K, V> treeMapEntry;
            if (this.est < 0) {
                getEstimate();
            }
            int d10 = this.side;
            TreeMapEntry<K, V> e2 = this.current;
            TreeMapEntry<K, V> f10 = this.fence;
            if (e2 == null || e2 == f10) {
                treeMapEntry = null;
            } else if (d10 == 0) {
                treeMapEntry = ((TreeMap) this.tree).root;
            } else if (d10 < 0) {
                treeMapEntry = e2.left;
            } else {
                treeMapEntry = (d10 <= 0 || f10 == null) ? null : f10.right;
            }
            TreeMapEntry<K, V> s2 = treeMapEntry;
            if (s2 == null || s2 == e2 || s2 == f10 || this.tree.compare(e2.key, s2.key) <= 0) {
                return null;
            }
            this.side = 1;
            TreeMap<K, V> treeMap = this.tree;
            this.current = s2;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new DescendingKeySpliterator<>(treeMap, e2, s2, -1, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.fence;
            TreeMapEntry<K, V> treeMapEntry2 = this.current;
            TreeMapEntry<K, V> treeMapEntry3 = treeMapEntry2;
            if (treeMapEntry2 != null && treeMapEntry3 != treeMapEntry) {
                this.current = treeMapEntry;
                do {
                    consumer.accept(treeMapEntry3.key);
                    TreeMapEntry<K, V> treeMapEntry4 = treeMapEntry3.left;
                    TreeMapEntry<K, V> treeMapEntry5 = treeMapEntry4;
                    if (treeMapEntry4 == null) {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry6 = treeMapEntry3.parent;
                            treeMapEntry5 = treeMapEntry6;
                            if (treeMapEntry6 == null || treeMapEntry3 != treeMapEntry5.left) {
                                break;
                            } else {
                                treeMapEntry3 = treeMapEntry5;
                            }
                        }
                    } else {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry7 = treeMapEntry5.right;
                            if (treeMapEntry7 == null) {
                                break;
                            } else {
                                treeMapEntry5 = treeMapEntry7;
                            }
                        }
                    }
                    treeMapEntry3 = treeMapEntry5;
                    if (treeMapEntry5 == null) {
                        break;
                    }
                } while (treeMapEntry3 != treeMapEntry);
                if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.current;
            if (treeMapEntry == null || treeMapEntry == this.fence) {
                return false;
            }
            this.current = TreeMap.predecessor(treeMapEntry);
            consumer.accept(treeMapEntry.key);
            if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.side == 0 ? 64 : 0) | 1 | 16;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ValueSpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<V> {
        ValueSpliterator(TreeMap<K, V> tree, TreeMapEntry<K, V> origin, TreeMapEntry<K, V> fence, int side, int est, int expectedModCount) {
            super(tree, origin, fence, side, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            TreeMapEntry<K, V> treeMapEntry;
            if (this.est < 0) {
                getEstimate();
            }
            int d10 = this.side;
            TreeMapEntry<K, V> e2 = this.current;
            TreeMapEntry<K, V> f10 = this.fence;
            if (e2 == null || e2 == f10) {
                treeMapEntry = null;
            } else if (d10 == 0) {
                treeMapEntry = ((TreeMap) this.tree).root;
            } else if (d10 > 0) {
                treeMapEntry = e2.right;
            } else {
                treeMapEntry = (d10 >= 0 || f10 == null) ? null : f10.left;
            }
            TreeMapEntry<K, V> s2 = treeMapEntry;
            if (s2 == null || s2 == e2 || s2 == f10 || this.tree.compare(e2.key, s2.key) >= 0) {
                return null;
            }
            this.side = 1;
            TreeMap<K, V> treeMap = this.tree;
            this.current = s2;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new ValueSpliterator<>(treeMap, e2, s2, -1, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.fence;
            TreeMapEntry<K, V> treeMapEntry2 = this.current;
            TreeMapEntry<K, V> treeMapEntry3 = treeMapEntry2;
            if (treeMapEntry2 != null && treeMapEntry3 != treeMapEntry) {
                this.current = treeMapEntry;
                do {
                    consumer.accept(treeMapEntry3.value);
                    TreeMapEntry<K, V> treeMapEntry4 = treeMapEntry3.right;
                    TreeMapEntry<K, V> treeMapEntry5 = treeMapEntry4;
                    if (treeMapEntry4 == null) {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry6 = treeMapEntry3.parent;
                            treeMapEntry5 = treeMapEntry6;
                            if (treeMapEntry6 == null || treeMapEntry3 != treeMapEntry5.right) {
                                break;
                            } else {
                                treeMapEntry3 = treeMapEntry5;
                            }
                        }
                    } else {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry7 = treeMapEntry5.left;
                            if (treeMapEntry7 == null) {
                                break;
                            } else {
                                treeMapEntry5 = treeMapEntry7;
                            }
                        }
                    }
                    treeMapEntry3 = treeMapEntry5;
                    if (treeMapEntry5 == null) {
                        break;
                    }
                } while (treeMapEntry3 != treeMapEntry);
                if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> treeMapEntry = this.current;
            if (treeMapEntry == null || treeMapEntry == this.fence) {
                return false;
            }
            this.current = TreeMap.successor(treeMapEntry);
            consumer.accept(treeMapEntry.value);
            if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.side == 0 ? 64 : 0) | 16;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntrySpliterator<K, V> extends TreeMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        EntrySpliterator(TreeMap<K, V> tree, TreeMapEntry<K, V> origin, TreeMapEntry<K, V> fence, int side, int est, int expectedModCount) {
            super(tree, origin, fence, side, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            TreeMapEntry<K, V> treeMapEntry;
            if (this.est < 0) {
                getEstimate();
            }
            int d10 = this.side;
            TreeMapEntry<K, V> e2 = this.current;
            TreeMapEntry<K, V> f10 = this.fence;
            if (e2 == null || e2 == f10) {
                treeMapEntry = null;
            } else if (d10 == 0) {
                treeMapEntry = ((TreeMap) this.tree).root;
            } else if (d10 > 0) {
                treeMapEntry = e2.right;
            } else {
                treeMapEntry = (d10 >= 0 || f10 == null) ? null : f10.left;
            }
            TreeMapEntry<K, V> s2 = treeMapEntry;
            if (s2 == null || s2 == e2 || s2 == f10 || this.tree.compare(e2.key, s2.key) >= 0) {
                return null;
            }
            this.side = 1;
            TreeMap<K, V> treeMap = this.tree;
            this.current = s2;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new EntrySpliterator<>(treeMap, e2, s2, -1, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> f10 = this.fence;
            TreeMapEntry<K, V> treeMapEntry = this.current;
            TreeMapEntry<K, V> e2 = treeMapEntry;
            if (treeMapEntry != null && e2 != f10) {
                this.current = f10;
                do {
                    action.accept(e2);
                    TreeMapEntry<K, V> treeMapEntry2 = e2.right;
                    TreeMapEntry<K, V> p10 = treeMapEntry2;
                    if (treeMapEntry2 == null) {
                        while (true) {
                            TreeMapEntry<K, V> treeMapEntry3 = e2.parent;
                            p10 = treeMapEntry3;
                            if (treeMapEntry3 == null || e2 != p10.right) {
                                break;
                            } else {
                                e2 = p10;
                            }
                        }
                    } else {
                        while (true) {
                            TreeMapEntry<K, V> pl = p10.left;
                            if (pl == null) {
                                break;
                            } else {
                                p10 = pl;
                            }
                        }
                    }
                    e2 = p10;
                    if (p10 == null) {
                        break;
                    }
                } while (e2 != f10);
                if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.est < 0) {
                getEstimate();
            }
            TreeMapEntry<K, V> e2 = this.current;
            if (e2 == null || e2 == this.fence) {
                return false;
            }
            this.current = TreeMap.successor(e2);
            action.accept(e2);
            if (((TreeMap) this.tree).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            return true;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.side == 0 ? 64 : 0) | 1 | 4 | 16;
        }

        @Override // java.util.Spliterator
        public Comparator<Map.Entry<K, V>> getComparator() {
            return ((TreeMap) this.tree).comparator != null ? Map.Entry.comparingByKey(((TreeMap) this.tree).comparator) : new TreeMap$EntrySpliterator$$ExternalSyntheticLambda0();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int lambda$getComparator$d5a01062$1(Map.Entry e12, Map.Entry e2) {
            Comparable<? super K> k12 = (Comparable) e12.getKey();
            return k12.compareTo(e2.getKey());
        }
    }
}
