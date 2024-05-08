package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final long serialVersionUID = 362498820763181265L;
    transient Set<Map.Entry<K, V>> entrySet;
    final float loadFactor;
    transient int modCount;
    transient int size;
    transient Node<K, V>[] table;
    int threshold;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        Node<K, V> next;
        V value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        public final String toString() {
            return ((Object) this.key) + "=" + ((Object) this.value);
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                if (Objects.equals(this.key, e2.getKey()) && Objects.equals(this.value, e2.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h10 = key.hashCode();
        return h10 ^ (h10 >>> 16);
    }

    static Class<?> comparableClassFor(Object x10) {
        Type[] as;
        if (x10 instanceof Comparable) {
            Class<?> c4 = x10.getClass();
            if (c4 == String.class) {
                return c4;
            }
            Type[] ts = c4.getGenericInterfaces();
            if (ts != null) {
                for (Type t2 : ts) {
                    if (t2 instanceof ParameterizedType) {
                        ParameterizedType p10 = (ParameterizedType) t2;
                        if (p10.getRawType() == Comparable.class && (as = p10.getActualTypeArguments()) != null && as.length == 1 && as[0] == c4) {
                            return c4;
                        }
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    static int compareComparables(Class<?> kc2, Object k10, Object x10) {
        if (x10 == null || x10.getClass() != kc2) {
            return 0;
        }
        return ((Comparable) k10).compareTo(x10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int tableSizeFor(int cap) {
        int n10 = (-1) >>> Integer.numberOfLeadingZeros(cap - 1);
        if (n10 < 0) {
            return 1;
        }
        if (n10 >= 1073741824) {
            return 1073741824;
        }
        return n10 + 1;
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        initialCapacity = initialCapacity > 1073741824 ? 1073741824 : initialCapacity;
        if (loadFactor <= 0.0f || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public HashMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public HashMap() {
        this.loadFactor = 0.75f;
    }

    public HashMap(Map<? extends K, ? extends V> m10) {
        this.loadFactor = 0.75f;
        putMapEntries(m10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void putMapEntries(Map<? extends K, ? extends V> m10, boolean evict) {
        int s2 = m10.size();
        if (s2 > 0) {
            if (this.table == null) {
                float ft = (s2 / this.loadFactor) + 1.0f;
                int t2 = ft < 1.07374182E9f ? (int) ft : 1073741824;
                if (t2 > this.threshold) {
                    this.threshold = tableSizeFor(t2);
                }
            } else {
                while (s2 > this.threshold && this.table.length < 1073741824) {
                    resize();
                }
            }
            for (Map.Entry<? extends K, ? extends V> e2 : m10.entrySet()) {
                K key = e2.getKey();
                V value = e2.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        Node<K, V> e2 = getNode(key);
        if (e2 == null) {
            return null;
        }
        return e2.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Node<K, V> getNode(Object key) {
        int n10;
        Node<K, V> node;
        K k10;
        K k11;
        Node<K, V>[] tab = this.table;
        if (tab != null && (n10 = tab.length) > 0) {
            int hash = hash(key);
            Node<K, V> first = tab[(n10 - 1) & hash];
            if (first != null) {
                if (first.hash == hash && ((k11 = first.key) == key || (key != null && key.equals(k11)))) {
                    return first;
                }
                Node<K, V> node2 = first.next;
                Node<K, V> e2 = node2;
                if (node2 != null) {
                    if (first instanceof TreeNode) {
                        return ((TreeNode) first).getTreeNode(hash, key);
                    }
                    do {
                        if (e2.hash == hash && ((k10 = e2.key) == key || (key != null && key.equals(k10)))) {
                            return e2;
                        }
                        node = e2.next;
                        e2 = node;
                    } while (node != null);
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        int n10;
        Node<K, V> e2;
        Node<K, V> e10;
        K k10;
        K k11;
        int n11;
        Node<K, V>[] tab2 = this.table;
        if (tab2 == null || (n11 = tab2.length) == 0) {
            Node<K, V>[] tab3 = resize();
            tab = tab3;
            n10 = tab3.length;
        } else {
            tab = tab2;
            n10 = n11;
        }
        int i10 = (n10 - 1) & hash;
        Node<K, V> node = tab[i10];
        Node<K, V> p10 = node;
        if (node == null) {
            tab[i10] = newNode(hash, key, value, null);
        } else {
            if (p10.hash == hash && ((k11 = p10.key) == key || (key != null && key.equals(k11)))) {
                e10 = p10;
            } else if (p10 instanceof TreeNode) {
                e10 = ((TreeNode) p10).putTreeVal(this, tab, hash, key, value);
            } else {
                int binCount = 0;
                while (true) {
                    e2 = p10.next;
                    if (e2 == null) {
                        p10.next = newNode(hash, key, value, null);
                        if (binCount >= 7) {
                            treeifyBin(tab, hash);
                        }
                    } else {
                        if (e2.hash == hash && ((k10 = e2.key) == key || (key != null && key.equals(k10)))) {
                            break;
                        }
                        p10 = e2;
                        binCount++;
                    }
                }
                e10 = e2;
            }
            if (e10 != null) {
                V oldValue = e10.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e10.value = value;
                }
                afterNodeAccess(e10);
                return oldValue;
            }
        }
        this.modCount++;
        int i11 = this.size + 1;
        this.size = i11;
        if (i11 > this.threshold) {
            resize();
        }
        afterNodeInsertion(evict);
        return null;
    }

    final Node<K, V>[] resize() {
        int newCap;
        Node<K, V> next;
        Node<K, V>[] oldTab = this.table;
        int oldCap = oldTab == null ? 0 : oldTab.length;
        int oldThr = this.threshold;
        int newThr = 0;
        int i10 = Integer.MAX_VALUE;
        if (oldCap > 0) {
            if (oldCap >= 1073741824) {
                this.threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            int i11 = oldCap << 1;
            newCap = i11;
            if (i11 < 1073741824 && oldCap >= 16) {
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = 16;
            newThr = 12;
        }
        if (newThr == 0) {
            float ft = newCap * this.loadFactor;
            if (newCap < 1073741824 && ft < 1.07374182E9f) {
                i10 = (int) ft;
            }
            newThr = i10;
        }
        this.threshold = newThr;
        Node<K, V>[] newTab = new Node[newCap];
        this.table = newTab;
        if (oldTab != null) {
            for (int j10 = 0; j10 < oldCap; j10++) {
                Node<K, V> node = oldTab[j10];
                Node<K, V> e2 = node;
                if (node != null) {
                    oldTab[j10] = null;
                    if (e2.next == null) {
                        newTab[e2.hash & (newCap - 1)] = e2;
                    } else if (e2 instanceof TreeNode) {
                        ((TreeNode) e2).split(this, newTab, j10, oldCap);
                    } else {
                        Node<K, V> loHead = null;
                        Node<K, V> loTail = null;
                        Node<K, V> hiHead = null;
                        Node<K, V> hiTail = null;
                        do {
                            next = e2.next;
                            if ((e2.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e2;
                                } else {
                                    loTail.next = e2;
                                }
                                loTail = e2;
                            } else {
                                if (hiTail == null) {
                                    hiHead = e2;
                                } else {
                                    hiTail.next = e2;
                                }
                                hiTail = e2;
                            }
                            e2 = next;
                        } while (next != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j10] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j10 + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    final void treeifyBin(Node<K, V>[] tab, int hash) {
        int n10;
        Node<K, V> node;
        if (tab == null || (n10 = tab.length) < 64) {
            resize();
            return;
        }
        int index = (n10 - 1) & hash;
        Node<K, V> node2 = tab[index];
        Node<K, V> e2 = node2;
        if (node2 != null) {
            TreeNode<K, V> hd2 = null;
            TreeNode<K, V> tl = null;
            do {
                TreeNode<K, V> p10 = replacementTreeNode(e2, null);
                if (tl == null) {
                    hd2 = p10;
                } else {
                    p10.prev = tl;
                    tl.next = p10;
                }
                tl = p10;
                node = e2.next;
                e2 = node;
            } while (node != null);
            tab[index] = hd2;
            if (hd2 != null) {
                hd2.treeify(tab);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        putMapEntries(m10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        Node<K, V> e2 = removeNode(hash(key), key, null, false, true);
        if (e2 == null) {
            return null;
        }
        return e2.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Node<K, V> removeNode(int hash, Object key, Object value, boolean matchValue, boolean movable) {
        int n10;
        Node<K, V> node;
        K k10;
        V v2;
        K k11;
        Node<K, V>[] tab = this.table;
        if (tab == null || (n10 = tab.length) <= 0) {
            return null;
        }
        int index = (n10 - 1) & hash;
        Node<K, V> node2 = tab[index];
        Node<K, V> p10 = node2;
        if (node2 != null) {
            Node<K, V> node3 = null;
            if (p10.hash == hash && ((k11 = p10.key) == key || (key != null && key.equals(k11)))) {
                node3 = p10;
            } else {
                Node<K, V> node4 = p10.next;
                Node<K, V> e2 = node4;
                if (node4 != null) {
                    if (p10 instanceof TreeNode) {
                        node3 = ((TreeNode) p10).getTreeNode(hash, key);
                    }
                    do {
                        if (e2.hash == hash && ((k10 = e2.key) == key || (key != null && key.equals(k10)))) {
                            node3 = e2;
                            break;
                        }
                        p10 = e2;
                        node = e2.next;
                        e2 = node;
                    } while (node != null);
                }
            }
            if (node3 != null) {
                if (!matchValue || (v2 = node3.value) == value || (value != null && value.equals(v2))) {
                    if (node3 instanceof TreeNode) {
                        ((TreeNode) node3).removeTreeNode(this, tab, movable);
                    } else if (node3 == p10) {
                        tab[index] = node3.next;
                    } else {
                        p10.next = node3.next;
                    }
                    this.modCount++;
                    this.size--;
                    afterNodeRemoval(node3);
                    return node3;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Node<K, V>[] tab = this.table;
        if (tab != null && this.size > 0) {
            this.size = 0;
            for (int i10 = 0; i10 < tab.length; i10++) {
                tab[i10] = null;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        Node<K, V>[] tab = this.table;
        if (tab != null && this.size > 0) {
            for (Node<K, V> e2 : tab) {
                for (; e2 != null; e2 = e2.next) {
                    V v2 = e2.value;
                    if (v2 != value) {
                        if (value != null && value.equals(v2)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
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

    final <T> T[] prepareArray(T[] tArr) {
        int i10 = this.size;
        if (tArr.length < i10) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
        }
        if (tArr.length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    <T> T[] keysToArray(T[] tArr) {
        Node<K, V>[] tab;
        int idx = 0;
        if (this.size > 0 && (tab = this.table) != null) {
            for (Node<K, V> e2 : tab) {
                while (e2 != null) {
                    tArr[idx] = e2.key;
                    e2 = e2.next;
                    idx++;
                }
            }
        }
        return tArr;
    }

    <T> T[] valuesToArray(T[] tArr) {
        Node<K, V>[] tab;
        int idx = 0;
        if (this.size > 0 && (tab = this.table) != null) {
            for (Node<K, V> e2 : tab) {
                while (e2 != null) {
                    tArr[idx] = e2.value;
                    e2 = e2.next;
                    idx++;
                }
            }
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return HashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<K> iterator2() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            return HashMap.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object key) {
            return HashMap.this.removeNode(HashMap.hash(key), key, null, false, true) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<K> spliterator() {
            return new KeySpliterator(HashMap.this, 0, -1, 0, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            HashMap hashMap = HashMap.this;
            return hashMap.keysToArray(new Object[hashMap.size]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            HashMap hashMap = HashMap.this;
            return (T[]) hashMap.keysToArray(hashMap.prepareArray(tArr));
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super K> consumer) {
            Node<K, V>[] nodeArr;
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (HashMap.this.size > 0 && (nodeArr = HashMap.this.table) != null) {
                int i10 = HashMap.this.modCount;
                for (int i11 = 0; i11 < nodeArr.length && HashMap.this.modCount == i10; i11++) {
                    for (Node<K, V> node = nodeArr[i11]; node != null; node = node.next) {
                        consumer.accept(node.key);
                    }
                }
                if (HashMap.this.modCount != i10) {
                    throw new ConcurrentModificationException();
                }
            }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return HashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<V> iterator2() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            return HashMap.this.containsValue(o10);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<V> spliterator() {
            return new ValueSpliterator(HashMap.this, 0, -1, 0, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            HashMap hashMap = HashMap.this;
            return hashMap.valuesToArray(new Object[hashMap.size]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            HashMap hashMap = HashMap.this;
            return (T[]) hashMap.valuesToArray(hashMap.prepareArray(tArr));
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super V> consumer) {
            Node<K, V>[] nodeArr;
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (HashMap.this.size > 0 && (nodeArr = HashMap.this.table) != null) {
                int i10 = HashMap.this.modCount;
                for (int i11 = 0; i11 < nodeArr.length && HashMap.this.modCount == i10; i11++) {
                    for (Node<K, V> node = nodeArr[i11]; node != null; node = node.next) {
                        consumer.accept(node.value);
                    }
                }
                if (HashMap.this.modCount != i10) {
                    throw new ConcurrentModificationException();
                }
            }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return HashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            HashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<Map.Entry<K, V>> iterator2() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            Object key = e2.getKey();
            Node<K, V> candidate = HashMap.this.getNode(key);
            return candidate != null && candidate.equals(e2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            Object key = e2.getKey();
            Object value = e2.getValue();
            return HashMap.this.removeNode(HashMap.hash(key), key, value, true, true) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<Map.Entry<K, V>> spliterator() {
            return new EntrySpliterator(HashMap.this, 0, -1, 0, 0);
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super Map.Entry<K, V>> action) {
            Node<K, V>[] tab;
            if (action == null) {
                throw new NullPointerException();
            }
            if (HashMap.this.size > 0 && (tab = HashMap.this.table) != null) {
                int mc2 = HashMap.this.modCount;
                for (int i10 = 0; i10 < tab.length && HashMap.this.modCount == mc2; i10++) {
                    for (Node<K, V> e2 = tab[i10]; e2 != null; e2 = e2.next) {
                        action.accept(e2);
                    }
                }
                if (HashMap.this.modCount != mc2) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    @Override // java.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> e2 = getNode(key);
        return e2 == null ? defaultValue : e2.value;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K key, V value) {
        return putVal(hash(key), key, value, true, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object key, Object value) {
        return removeNode(hash(key), key, value, true, true) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K key, V oldValue, V newValue) {
        Node<K, V> e2 = getNode(key);
        if (e2 != null) {
            V v2 = e2.value;
            if (v2 == oldValue || (v2 != null && v2.equals(oldValue))) {
                e2.value = newValue;
                afterNodeAccess(e2);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K key, V value) {
        Node<K, V> e2 = getNode(key);
        if (e2 != null) {
            V oldValue = e2.value;
            e2.value = value;
            afterNodeAccess(e2);
            return oldValue;
        }
        return null;
    }

    @Override // java.util.Map
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Node<K, V>[] tab;
        int n10;
        int binCount;
        TreeNode<K, V> t2;
        Node<K, V> old;
        int mc2;
        V v2;
        Node<K, V> node;
        K k10;
        V oldValue;
        Node<K, V>[] tab2;
        int n11;
        if (mappingFunction == null) {
            throw new NullPointerException();
        }
        int hash = hash(key);
        int binCount2 = 0;
        TreeNode<K, V> t10 = null;
        Node<K, V> old2 = null;
        if (this.size > this.threshold || (tab2 = this.table) == null || (n11 = tab2.length) == 0) {
            Node<K, V>[] tab3 = resize();
            tab = tab3;
            n10 = tab3.length;
        } else {
            tab = tab2;
            n10 = n11;
        }
        int i10 = (n10 - 1) & hash;
        Node<K, V> first = tab[i10];
        if (first == null) {
            binCount = 0;
            t2 = null;
            old = null;
        } else {
            if (first instanceof TreeNode) {
                TreeNode<K, V> treeNode = (TreeNode) first;
                t10 = treeNode;
                old2 = treeNode.getTreeNode(hash, key);
            } else {
                Node<K, V> e2 = first;
                do {
                    if (e2.hash == hash && ((k10 = e2.key) == key || (key != null && key.equals(k10)))) {
                        old2 = e2;
                        break;
                    }
                    binCount2++;
                    node = e2.next;
                    e2 = node;
                } while (node != null);
            }
            if (old2 != null && (oldValue = old2.value) != null) {
                afterNodeAccess(old2);
                return oldValue;
            }
            binCount = binCount2;
            t2 = t10;
            old = old2;
        }
        int mc3 = this.modCount;
        V v10 = mappingFunction.apply(key);
        if (mc3 != this.modCount) {
            throw new ConcurrentModificationException();
        }
        if (v10 == null) {
            return null;
        }
        if (old != null) {
            old.value = v10;
            afterNodeAccess(old);
            return v10;
        }
        if (t2 != null) {
            mc2 = mc3;
            t2.putTreeVal(this, tab, hash, key, v10);
            v2 = v10;
        } else {
            mc2 = mc3;
            v2 = v10;
            tab[i10] = newNode(hash, key, v2, first);
            if (binCount >= 7) {
                treeifyBin(tab, hash);
            }
        }
        this.modCount = mc2 + 1;
        this.size++;
        afterNodeInsertion(true);
        return v2;
    }

    @Override // java.util.Map
    public V computeIfPresent(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        V v2;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        Node<K, V> node = getNode(k10);
        if (node != null && (v2 = node.value) != null) {
            int i10 = this.modCount;
            V apply = biFunction.apply(k10, v2);
            if (i10 != this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (apply != null) {
                node.value = apply;
                afterNodeAccess(node);
                return apply;
            }
            removeNode(hash(k10), k10, null, false, true);
            return null;
        }
        return null;
    }

    @Override // java.util.Map
    public V compute(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Node<K, V>[] nodeArr;
        int length;
        int i10;
        TreeNode treeNode;
        Node<K, V> node;
        V v2;
        Node<K, V> node2;
        K k11;
        Node<K, V>[] nodeArr2;
        int length2;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        int hash = hash(k10);
        int i11 = 0;
        if (this.size > this.threshold || (nodeArr2 = this.table) == null || (length2 = nodeArr2.length) == 0) {
            Node<K, V>[] resize = resize();
            nodeArr = resize;
            length = resize.length;
        } else {
            nodeArr = nodeArr2;
            length = length2;
        }
        int i12 = (length - 1) & hash;
        Node<K, V> node3 = nodeArr[i12];
        if (node3 == null) {
            i10 = 0;
            treeNode = null;
            node = null;
        } else if (node3 instanceof TreeNode) {
            TreeNode treeNode2 = (TreeNode) node3;
            i10 = 0;
            treeNode = treeNode2;
            node = treeNode2.getTreeNode(hash, k10);
        } else {
            Node<K, V> node4 = node3;
            do {
                if (node4.hash == hash && ((k11 = node4.key) == k10 || (k10 != null && k10.equals(k11)))) {
                    i10 = i11;
                    treeNode = null;
                    node = node4;
                    break;
                }
                i11++;
                node2 = node4.next;
                node4 = node2;
            } while (node2 != null);
            i10 = i11;
            treeNode = null;
            node = null;
        }
        V v10 = node == null ? null : node.value;
        int i13 = this.modCount;
        V apply = biFunction.apply(k10, (Object) v10);
        if (i13 != this.modCount) {
            throw new ConcurrentModificationException();
        }
        if (node != null) {
            if (apply != null) {
                node.value = apply;
                afterNodeAccess(node);
                return apply;
            }
            removeNode(hash, k10, null, false, true);
            return apply;
        }
        if (apply == null) {
            return apply;
        }
        if (treeNode != null) {
            treeNode.putTreeVal(this, nodeArr, hash, k10, apply);
            v2 = apply;
        } else {
            v2 = apply;
            nodeArr[i12] = newNode(hash, k10, v2, node3);
            if (i10 >= 7) {
                treeifyBin(nodeArr, hash);
            }
        }
        this.modCount = i13 + 1;
        this.size++;
        afterNodeInsertion(true);
        return v2;
    }

    @Override // java.util.Map
    public V merge(K k10, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        Node<K, V>[] nodeArr;
        int length;
        int i10;
        TreeNode treeNode;
        Node<K, V> node;
        V v10;
        Node<K, V> node2;
        K k11;
        Node<K, V>[] nodeArr2;
        int length2;
        if (v2 == null || biFunction == null) {
            throw new NullPointerException();
        }
        int hash = hash(k10);
        int i11 = 0;
        if (this.size > this.threshold || (nodeArr2 = this.table) == null || (length2 = nodeArr2.length) == 0) {
            Node<K, V>[] resize = resize();
            nodeArr = resize;
            length = resize.length;
        } else {
            nodeArr = nodeArr2;
            length = length2;
        }
        int i12 = (length - 1) & hash;
        Node<K, V> node3 = nodeArr[i12];
        if (node3 == null) {
            i10 = 0;
            treeNode = null;
            node = null;
        } else if (node3 instanceof TreeNode) {
            TreeNode treeNode2 = (TreeNode) node3;
            i10 = 0;
            treeNode = treeNode2;
            node = treeNode2.getTreeNode(hash, k10);
        } else {
            Node<K, V> node4 = node3;
            do {
                if (node4.hash == hash && ((k11 = node4.key) == k10 || (k10 != null && k10.equals(k11)))) {
                    i10 = i11;
                    treeNode = null;
                    node = node4;
                    break;
                }
                i11++;
                node2 = node4.next;
                node4 = node2;
            } while (node2 != null);
            i10 = i11;
            treeNode = null;
            node = null;
        }
        if (node == null) {
            if (treeNode != null) {
                treeNode.putTreeVal(this, nodeArr, hash, k10, v2);
            } else {
                nodeArr[i12] = newNode(hash, k10, v2, node3);
                if (i10 >= 7) {
                    treeifyBin(nodeArr, hash);
                }
            }
            this.modCount++;
            this.size++;
            afterNodeInsertion(true);
            return v2;
        }
        if (node.value != null) {
            int i13 = this.modCount;
            V apply = biFunction.apply(node.value, v2);
            if (i13 != this.modCount) {
                throw new ConcurrentModificationException();
            }
            v10 = apply;
        } else {
            v10 = v2;
        }
        if (v10 != null) {
            node.value = v10;
            afterNodeAccess(node);
            return v10;
        }
        V v11 = v10;
        removeNode(hash, k10, null, false, true);
        return v11;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Node<K, V>[] nodeArr;
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        if (this.size > 0 && (nodeArr = this.table) != null) {
            int i10 = this.modCount;
            for (int i11 = 0; i11 < nodeArr.length && i10 == this.modCount; i11++) {
                for (Node<K, V> node = nodeArr[i11]; node != null; node = node.next) {
                    biConsumer.accept(node.key, node.value);
                }
            }
            if (this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Node<K, V>[] nodeArr;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        if (this.size > 0 && (nodeArr = this.table) != null) {
            int i10 = this.modCount;
            for (Node<K, V> node : nodeArr) {
                for (; node != null; node = node.next) {
                    node.value = biFunction.apply(node.key, node.value);
                }
            }
            if (this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            HashMap<K, V> result = (HashMap) super.clone();
            result.reinitialize();
            result.putMapEntries(this, false);
            return result;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float loadFactor() {
        return this.loadFactor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int capacity() {
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            return nodeArr.length;
        }
        int i10 = this.threshold;
        if (i10 > 0) {
            return i10;
        }
        return 16;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        int buckets = capacity();
        s2.defaultWriteObject();
        s2.writeInt(buckets);
        s2.writeInt(this.size);
        internalWriteEntries(s2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        int tableSizeFor;
        s2.defaultReadObject();
        reinitialize();
        float f10 = this.loadFactor;
        if (f10 <= 0.0f || Float.isNaN(f10)) {
            throw new InvalidObjectException("Illegal load factor: " + this.loadFactor);
        }
        s2.readInt();
        int mappings = s2.readInt();
        if (mappings < 0) {
            throw new InvalidObjectException("Illegal mappings count: " + mappings);
        }
        if (mappings > 0) {
            float lf = Math.min(Math.max(0.25f, this.loadFactor), 4.0f);
            float fc2 = (mappings / lf) + 1.0f;
            if (fc2 < 16.0f) {
                tableSizeFor = 16;
            } else if (fc2 >= 1.07374182E9f) {
                tableSizeFor = 1073741824;
            } else {
                tableSizeFor = tableSizeFor((int) fc2);
            }
            int cap = tableSizeFor;
            float ft = cap * lf;
            this.threshold = (cap >= 1073741824 || ft >= 1.07374182E9f) ? Integer.MAX_VALUE : (int) ft;
            Node<K, V>[] tab = new Node[cap];
            this.table = tab;
            for (int i10 = 0; i10 < mappings; i10++) {
                Object readObject = s2.readObject();
                putVal(hash(readObject), readObject, s2.readObject(), false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class HashIterator {
        Node<K, V> current;
        int expectedModCount;
        int index;
        Node<K, V> next;

        HashIterator() {
            Node<K, V> node;
            this.expectedModCount = HashMap.this.modCount;
            Node<K, V>[] t2 = HashMap.this.table;
            this.next = null;
            this.current = null;
            this.index = 0;
            if (t2 == null || HashMap.this.size <= 0) {
                return;
            }
            do {
                int i10 = this.index;
                if (i10 >= t2.length) {
                    return;
                }
                this.index = i10 + 1;
                node = t2[i10];
                this.next = node;
            } while (node == null);
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            r4.index = r1 + 1;
            r1 = r1[r1];
            r4.next = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            if (r1 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            if (r1 != null) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        
            r1 = r4.index;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        
            if (r1 >= r1.length) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.HashMap.Node<K, V> nextNode() {
            /*
                r4 = this;
                java.util.HashMap$Node<K, V> r0 = r4.next
                java.util.HashMap r1 = java.util.HashMap.this
                int r1 = r1.modCount
                int r2 = r4.expectedModCount
                if (r1 != r2) goto L31
                if (r0 == 0) goto L2b
                r4.current = r0
                java.util.HashMap$Node<K, V> r1 = r0.next
                r4.next = r1
                if (r1 != 0) goto L2a
                java.util.HashMap r1 = java.util.HashMap.this
                java.util.HashMap$Node<K, V>[] r1 = r1.table
                r2 = r1
                if (r1 == 0) goto L2a
            L1b:
                int r1 = r4.index
                int r3 = r2.length
                if (r1 >= r3) goto L2a
                int r3 = r1 + 1
                r4.index = r3
                r1 = r2[r1]
                r4.next = r1
                if (r1 == 0) goto L1b
            L2a:
                return r0
            L2b:
                java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
                r1.<init>()
                throw r1
            L31:
                java.util.ConcurrentModificationException r1 = new java.util.ConcurrentModificationException
                r1.<init>()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.HashIterator.nextNode():java.util.HashMap$Node");
        }

        public final void remove() {
            Node<K, V> p10 = this.current;
            if (p10 == null) {
                throw new IllegalStateException();
            }
            if (HashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.current = null;
            HashMap.this.removeNode(p10.hash, p10.key, null, false, false);
            this.expectedModCount = HashMap.this.modCount;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class KeyIterator extends HashMap<K, V>.HashIterator implements Iterator<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final K next() {
            return nextNode().key;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class ValueIterator extends HashMap<K, V>.HashIterator implements Iterator<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final V next() {
            return nextNode().value;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class EntryIterator extends HashMap<K, V>.HashIterator implements Iterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            return nextNode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class HashMapSpliterator<K, V> {
        Node<K, V> current;
        int est;
        int expectedModCount;
        int fence;
        int index;
        final HashMap<K, V> map;

        HashMapSpliterator(HashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
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
            HashMap<K, V> m10 = this.map;
            this.est = m10.size;
            this.expectedModCount = m10.modCount;
            Node<K, V>[] tab = m10.table;
            int hi2 = tab == null ? 0 : tab.length;
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
    static final class KeySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySpliterator(HashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid || this.current != null) {
                return null;
            }
            HashMap<K, V> hashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new KeySpliterator<>(hashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            int i10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            HashMap<K, V> hashMap = this.map;
            Node<K, V>[] nodeArr = hashMap.table;
            int i11 = this.fence;
            int i12 = i11;
            if (i11 < 0) {
                i10 = hashMap.modCount;
                this.expectedModCount = i10;
                int length = nodeArr == null ? 0 : nodeArr.length;
                this.fence = length;
                i12 = length;
            } else {
                i10 = this.expectedModCount;
            }
            if (nodeArr == null || nodeArr.length < i12) {
                return;
            }
            int i13 = this.index;
            int i14 = i13;
            if (i13 >= 0) {
                this.index = i12;
                if (i14 < i12 || this.current != null) {
                    Node<K, V> node = this.current;
                    this.current = null;
                    while (true) {
                        if (node == null) {
                            node = nodeArr[i14];
                            i14++;
                        } else {
                            consumer.accept(node.key);
                            node = node.next;
                        }
                        if (node == null && i14 >= i12) {
                            break;
                        }
                    }
                    if (hashMap.modCount != i10) {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return false;
            }
            int length = nodeArr.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current != null || this.index < fence) {
                    if (this.current == null) {
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.current = nodeArr[i10];
                    } else {
                        K k10 = this.current.key;
                        this.current = this.current.next;
                        consumer.accept(k10);
                        if (this.map.modCount != this.expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
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
    static final class ValueSpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<V> {
        ValueSpliterator(HashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid || this.current != null) {
                return null;
            }
            HashMap<K, V> hashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new ValueSpliterator<>(hashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> consumer) {
            int i10;
            if (consumer == null) {
                throw new NullPointerException();
            }
            HashMap<K, V> hashMap = this.map;
            Node<K, V>[] nodeArr = hashMap.table;
            int i11 = this.fence;
            int i12 = i11;
            if (i11 < 0) {
                i10 = hashMap.modCount;
                this.expectedModCount = i10;
                int length = nodeArr == null ? 0 : nodeArr.length;
                this.fence = length;
                i12 = length;
            } else {
                i10 = this.expectedModCount;
            }
            if (nodeArr == null || nodeArr.length < i12) {
                return;
            }
            int i13 = this.index;
            int i14 = i13;
            if (i13 >= 0) {
                this.index = i12;
                if (i14 < i12 || this.current != null) {
                    Node<K, V> node = this.current;
                    this.current = null;
                    while (true) {
                        if (node == null) {
                            node = nodeArr[i14];
                            i14++;
                        } else {
                            consumer.accept(node.value);
                            node = node.next;
                        }
                        if (node == null && i14 >= i12) {
                            break;
                        }
                    }
                    if (hashMap.modCount != i10) {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr == null) {
                return false;
            }
            int length = nodeArr.length;
            int fence = getFence();
            if (length < fence || this.index < 0) {
                return false;
            }
            while (true) {
                if (this.current != null || this.index < fence) {
                    if (this.current == null) {
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.current = nodeArr[i10];
                    } else {
                        V v2 = this.current.value;
                        this.current = this.current.next;
                        consumer.accept(v2);
                        if (this.map.modCount != this.expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
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
    static final class EntrySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        EntrySpliterator(HashMap<K, V> m10, int origin, int fence, int est, int expectedModCount) {
            super(m10, origin, fence, est, expectedModCount);
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid || this.current != null) {
                return null;
            }
            HashMap<K, V> hashMap = this.map;
            this.index = mid;
            int i10 = this.est >>> 1;
            this.est = i10;
            return new EntrySpliterator<>(hashMap, lo, mid, i10, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            int mc2;
            if (action == null) {
                throw new NullPointerException();
            }
            HashMap<K, V> m10 = this.map;
            Node<K, V>[] tab = m10.table;
            int i10 = this.fence;
            int hi = i10;
            if (i10 < 0) {
                mc2 = m10.modCount;
                this.expectedModCount = mc2;
                int length = tab == null ? 0 : tab.length;
                this.fence = length;
                hi = length;
            } else {
                mc2 = this.expectedModCount;
            }
            if (tab == null || tab.length < hi) {
                return;
            }
            int i11 = this.index;
            int i12 = i11;
            if (i11 >= 0) {
                this.index = hi;
                if (i12 < hi || this.current != null) {
                    Node<K, V> p10 = this.current;
                    this.current = null;
                    while (true) {
                        if (p10 == null) {
                            p10 = tab[i12];
                            i12++;
                        } else {
                            action.accept(p10);
                            p10 = p10.next;
                        }
                        if (p10 == null && i12 >= hi) {
                            break;
                        }
                    }
                    if (m10.modCount != mc2) {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] tab = this.map.table;
            if (tab == null) {
                return false;
            }
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
                        Node<K, V> e2 = this.current;
                        this.current = this.current.next;
                        action.accept(e2);
                        if (this.map.modCount != this.expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return ((this.fence < 0 || this.est == this.map.size) ? 64 : 0) | 1;
        }
    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    Node<K, V> replacementNode(Node<K, V> p10, Node<K, V> next) {
        return new Node<>(p10.hash, p10.key, p10.value, next);
    }

    TreeNode<K, V> newTreeNode(int hash, K key, V value, Node<K, V> next) {
        return new TreeNode<>(hash, key, value, next);
    }

    TreeNode<K, V> replacementTreeNode(Node<K, V> p10, Node<K, V> next) {
        return new TreeNode<>(p10.hash, p10.key, p10.value, next);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reinitialize() {
        this.table = null;
        this.entrySet = null;
        this.keySet = null;
        this.values = null;
        this.modCount = 0;
        this.threshold = 0;
        this.size = 0;
    }

    void afterNodeAccess(Node<K, V> p10) {
    }

    void afterNodeInsertion(boolean evict) {
    }

    void afterNodeRemoval(Node<K, V> p10) {
    }

    void internalWriteEntries(ObjectOutputStream s2) throws IOException {
        Node<K, V>[] tab;
        if (this.size > 0 && (tab = this.table) != null) {
            for (Node<K, V> e2 : tab) {
                for (; e2 != null; e2 = e2.next) {
                    s2.writeObject(e2.key);
                    s2.writeObject(e2.value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TreeNode<K, V> extends LinkedHashMap.LinkedHashMapEntry<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TreeNode(int hash, K key, V val, Node<K, V> next) {
            super(hash, key, val, next);
        }

        final TreeNode<K, V> root() {
            TreeNode<K, V> r10 = this;
            while (true) {
                TreeNode<K, V> p10 = r10.parent;
                if (p10 == null) {
                    return r10;
                }
                r10 = p10;
            }
        }

        static <K, V> void moveRootToFront(Node<K, V>[] tab, TreeNode<K, V> root) {
            int n10;
            if (root != null && tab != null && (n10 = tab.length) > 0) {
                int index = (n10 - 1) & root.hash;
                TreeNode<K, V> first = (TreeNode) tab[index];
                if (root != first) {
                    tab[index] = root;
                    TreeNode<K, V> rp = root.prev;
                    Node<K, V> rn = root.next;
                    if (rn != null) {
                        ((TreeNode) rn).prev = rp;
                    }
                    if (rp != null) {
                        rp.next = rn;
                    }
                    if (first != null) {
                        first.prev = root;
                    }
                    root.next = first;
                    root.prev = null;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x002d, code lost:
        
            if (r3 != null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.HashMap.TreeNode<K, V> find(int r8, java.lang.Object r9, java.lang.Class<?> r10) {
            /*
                r7 = this;
                r0 = r7
            L1:
                java.util.HashMap$TreeNode<K, V> r1 = r0.left
                java.util.HashMap$TreeNode<K, V> r2 = r0.right
                int r3 = r0.hash
                r4 = r3
                if (r3 <= r8) goto Lc
                r0 = r1
                goto L46
            Lc:
                if (r4 >= r8) goto L10
                r0 = r2
                goto L46
            L10:
                K r3 = r0.key
                r5 = r3
                if (r3 == r9) goto L4a
                if (r9 == 0) goto L1e
                boolean r3 = r9.equals(r5)
                if (r3 == 0) goto L1e
                goto L4a
            L1e:
                if (r1 != 0) goto L22
                r0 = r2
                goto L46
            L22:
                if (r2 != 0) goto L26
                r0 = r1
                goto L46
            L26:
                if (r10 != 0) goto L2f
                java.lang.Class r3 = java.util.HashMap.comparableClassFor(r9)
                r10 = r3
                if (r3 == 0) goto L3d
            L2f:
                int r3 = java.util.HashMap.compareComparables(r10, r9, r5)
                r6 = r3
                if (r3 == 0) goto L3d
                if (r6 >= 0) goto L3a
                r3 = r1
                goto L3b
            L3a:
                r3 = r2
            L3b:
                r0 = r3
                goto L46
            L3d:
                java.util.HashMap$TreeNode r3 = r2.find(r8, r9, r10)
                r6 = r3
                if (r3 == 0) goto L45
                return r6
            L45:
                r0 = r1
            L46:
                if (r0 != 0) goto L1
                r1 = 0
                return r1
            L4a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.TreeNode.find(int, java.lang.Object, java.lang.Class):java.util.HashMap$TreeNode");
        }

        final TreeNode<K, V> getTreeNode(int h10, Object k10) {
            return (this.parent != null ? root() : this).find(h10, k10, null);
        }

        static int tieBreakOrder(Object a10, Object b4) {
            int d10;
            if (a10 != null && b4 != null && (d10 = a10.getClass().getName().compareTo(b4.getClass().getName())) != 0) {
                return d10;
            }
            int d11 = System.identityHashCode(a10) <= System.identityHashCode(b4) ? -1 : 1;
            return d11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0030, code lost:
        
            if (r8 != null) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void treeify(java.util.HashMap.Node<K, V>[] r13) {
            /*
                r12 = this;
                r0 = 0
                r1 = r12
            L2:
                if (r1 == 0) goto L5b
                java.util.HashMap$Node<K, V> r2 = r1.next
                java.util.HashMap$TreeNode r2 = (java.util.HashMap.TreeNode) r2
                r3 = 0
                r1.right = r3
                r1.left = r3
                if (r0 != 0) goto L16
                r1.parent = r3
                r3 = 0
                r1.red = r3
                r0 = r1
                goto L58
            L16:
                K r3 = r1.key
                int r4 = r1.hash
                r5 = 0
                r6 = r0
            L1c:
                K r7 = r6.key
                int r8 = r6.hash
                r9 = r8
                if (r8 <= r4) goto L25
                r8 = -1
                goto L3f
            L25:
                if (r9 >= r4) goto L29
                r8 = 1
                goto L3f
            L29:
                if (r5 != 0) goto L32
                java.lang.Class r8 = java.util.HashMap.comparableClassFor(r3)
                r5 = r8
                if (r8 == 0) goto L39
            L32:
                int r8 = java.util.HashMap.compareComparables(r5, r3, r7)
                r10 = r8
                if (r8 != 0) goto L3e
            L39:
                int r8 = tieBreakOrder(r3, r7)
                goto L3f
            L3e:
                r8 = r10
            L3f:
                r10 = r6
                if (r8 > 0) goto L45
                java.util.HashMap$TreeNode<K, V> r11 = r6.left
                goto L47
            L45:
                java.util.HashMap$TreeNode<K, V> r11 = r6.right
            L47:
                r6 = r11
                if (r11 != 0) goto L5a
                r1.parent = r10
                if (r8 > 0) goto L51
                r10.left = r1
                goto L53
            L51:
                r10.right = r1
            L53:
                java.util.HashMap$TreeNode r0 = balanceInsertion(r0, r1)
            L58:
                r1 = r2
                goto L2
            L5a:
                goto L1c
            L5b:
                moveRootToFront(r13, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.TreeNode.treeify(java.util.HashMap$Node[]):void");
        }

        final Node<K, V> untreeify(HashMap<K, V> map) {
            Node<K, V> hd2 = null;
            Node<K, V> tl = null;
            for (Node<K, V> q10 = this; q10 != null; q10 = q10.next) {
                Node<K, V> p10 = map.replacementNode(q10, null);
                if (tl == null) {
                    hd2 = p10;
                } else {
                    tl.next = p10;
                }
                tl = p10;
            }
            return hd2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x002e, code lost:
        
            if (r4 != null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.HashMap.TreeNode<K, V> putTreeVal(java.util.HashMap<K, V> r11, java.util.HashMap.Node<K, V>[] r12, int r13, K r14, V r15) {
            /*
                r10 = this;
                r0 = 0
                r1 = 0
                java.util.HashMap$TreeNode<K, V> r2 = r10.parent
                if (r2 == 0) goto Lb
                java.util.HashMap$TreeNode r2 = r10.root()
                goto Lc
            Lb:
                r2 = r10
            Lc:
                r3 = r2
            Ld:
                int r4 = r3.hash
                r5 = r4
                if (r4 <= r13) goto L14
                r4 = -1
                goto L59
            L14:
                if (r5 >= r13) goto L18
                r4 = 1
                goto L59
            L18:
                K r4 = r3.key
                r6 = r4
                if (r4 == r14) goto L88
                if (r14 == 0) goto L27
                boolean r4 = r14.equals(r6)
                if (r4 == 0) goto L27
                goto L88
            L27:
                if (r0 != 0) goto L30
                java.lang.Class r4 = java.util.HashMap.comparableClassFor(r14)
                r0 = r4
                if (r4 == 0) goto L37
            L30:
                int r4 = java.util.HashMap.compareComparables(r0, r14, r6)
                r7 = r4
                if (r4 != 0) goto L58
            L37:
                if (r1 != 0) goto L53
                r1 = 1
                java.util.HashMap$TreeNode<K, V> r4 = r3.left
                r7 = r4
                if (r4 == 0) goto L46
                java.util.HashMap$TreeNode r4 = r7.find(r13, r14, r0)
                r8 = r4
                if (r4 != 0) goto L52
            L46:
                java.util.HashMap$TreeNode<K, V> r4 = r3.right
                r7 = r4
                if (r4 == 0) goto L53
                java.util.HashMap$TreeNode r4 = r7.find(r13, r14, r0)
                r8 = r4
                if (r4 == 0) goto L53
            L52:
                return r8
            L53:
                int r4 = tieBreakOrder(r14, r6)
                goto L59
            L58:
                r4 = r7
            L59:
                r6 = r3
                if (r4 > 0) goto L5f
                java.util.HashMap$TreeNode<K, V> r7 = r3.left
                goto L61
            L5f:
                java.util.HashMap$TreeNode<K, V> r7 = r3.right
            L61:
                r3 = r7
                if (r7 != 0) goto L87
                java.util.HashMap$Node<K, V> r7 = r6.next
                java.util.HashMap$TreeNode r8 = r11.newTreeNode(r13, r14, r15, r7)
                if (r4 > 0) goto L6f
                r6.left = r8
                goto L71
            L6f:
                r6.right = r8
            L71:
                r6.next = r8
                r8.prev = r6
                r8.parent = r6
                if (r7 == 0) goto L7e
                r9 = r7
                java.util.HashMap$TreeNode r9 = (java.util.HashMap.TreeNode) r9
                r9.prev = r8
            L7e:
                java.util.HashMap$TreeNode r9 = balanceInsertion(r2, r8)
                moveRootToFront(r12, r9)
                r9 = 0
                return r9
            L87:
                goto Ld
            L88:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.HashMap.TreeNode.putTreeVal(java.util.HashMap, java.util.HashMap$Node[], int, java.lang.Object, java.lang.Object):java.util.HashMap$TreeNode");
        }

        final void removeTreeNode(HashMap<K, V> map, Node<K, V>[] tab, boolean movable) {
            int n10;
            TreeNode<K, V> replacement;
            if (tab != null && (n10 = tab.length) != 0) {
                int index = (n10 - 1) & this.hash;
                TreeNode<K, V> first = (TreeNode) tab[index];
                TreeNode<K, V> root = first;
                TreeNode<K, V> succ = (TreeNode) this.next;
                TreeNode<K, V> pred = this.prev;
                if (pred == null) {
                    first = succ;
                    tab[index] = succ;
                } else {
                    pred.next = succ;
                }
                if (succ != null) {
                    succ.prev = pred;
                }
                if (first == null) {
                    return;
                }
                if (root.parent != null) {
                    root = root.root();
                }
                if (root != null) {
                    if (movable) {
                        if (root.right != null) {
                            TreeNode<K, V> rl = root.left;
                            if (rl == null || rl.left == null) {
                            }
                        }
                    }
                    TreeNode<K, V> pl = this.left;
                    TreeNode<K, V> pr = this.right;
                    if (pl != null && pr != null) {
                        TreeNode<K, V> s2 = pr;
                        while (true) {
                            TreeNode<K, V> sl = s2.left;
                            if (sl == null) {
                                break;
                            } else {
                                s2 = sl;
                            }
                        }
                        boolean c4 = s2.red;
                        s2.red = this.red;
                        this.red = c4;
                        TreeNode<K, V> sr = s2.right;
                        TreeNode<K, V> pp = this.parent;
                        if (s2 == pr) {
                            this.parent = s2;
                            s2.right = this;
                        } else {
                            TreeNode<K, V> sp = s2.parent;
                            this.parent = sp;
                            if (sp != null) {
                                if (s2 == sp.left) {
                                    sp.left = this;
                                } else {
                                    sp.right = this;
                                }
                            }
                            s2.right = pr;
                            if (pr != null) {
                                pr.parent = s2;
                            }
                        }
                        this.left = null;
                        this.right = sr;
                        if (sr != null) {
                            sr.parent = this;
                        }
                        s2.left = pl;
                        if (pl != null) {
                            pl.parent = s2;
                        }
                        s2.parent = pp;
                        if (pp != null) {
                            if (this == pp.left) {
                                pp.left = s2;
                            } else {
                                pp.right = s2;
                            }
                        } else {
                            root = s2;
                        }
                        if (sr != null) {
                            replacement = sr;
                        } else {
                            replacement = this;
                        }
                    } else if (pl != null) {
                        replacement = pl;
                    } else if (pr != null) {
                        replacement = pr;
                    } else {
                        replacement = this;
                    }
                    if (replacement != this) {
                        TreeNode<K, V> pp2 = this.parent;
                        replacement.parent = pp2;
                        if (pp2 != null) {
                            if (this == pp2.left) {
                                pp2.left = replacement;
                            } else {
                                pp2.right = replacement;
                            }
                        } else {
                            root = replacement;
                            replacement.red = false;
                        }
                        this.parent = null;
                        this.right = null;
                        this.left = null;
                    }
                    TreeNode<K, V> r10 = this.red ? root : balanceDeletion(root, replacement);
                    if (replacement == this) {
                        TreeNode<K, V> pp3 = this.parent;
                        this.parent = null;
                        if (pp3 != null) {
                            if (this != pp3.left) {
                                if (this == pp3.right) {
                                    pp3.right = null;
                                }
                            } else {
                                pp3.left = null;
                            }
                        }
                    }
                    if (movable) {
                        moveRootToFront(tab, r10);
                        return;
                    }
                    return;
                }
                tab[index] = first.untreeify(map);
            }
        }

        final void split(HashMap<K, V> map, Node<K, V>[] tab, int index, int bit) {
            TreeNode<K, V> loHead = null;
            TreeNode<K, V> loTail = null;
            TreeNode<K, V> hiHead = null;
            TreeNode<K, V> hiTail = null;
            int lc2 = 0;
            int hc2 = 0;
            TreeNode<K, V> e2 = this;
            while (e2 != null) {
                TreeNode<K, V> next = (TreeNode) e2.next;
                e2.next = null;
                if ((e2.hash & bit) == 0) {
                    e2.prev = loTail;
                    if (loTail == null) {
                        loHead = e2;
                    } else {
                        loTail.next = e2;
                    }
                    loTail = e2;
                    lc2++;
                } else {
                    e2.prev = hiTail;
                    if (hiTail == null) {
                        hiHead = e2;
                    } else {
                        hiTail.next = e2;
                    }
                    hiTail = e2;
                    hc2++;
                }
                e2 = next;
            }
            if (loHead != null) {
                if (lc2 <= 6) {
                    tab[index] = loHead.untreeify(map);
                } else {
                    tab[index] = loHead;
                    if (hiHead != null) {
                        loHead.treeify(tab);
                    }
                }
            }
            if (hiHead != null) {
                if (hc2 <= 6) {
                    tab[index + bit] = hiHead.untreeify(map);
                    return;
                }
                tab[index + bit] = hiHead;
                if (loHead != null) {
                    hiHead.treeify(tab);
                }
            }
        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> root, TreeNode<K, V> p10) {
            TreeNode<K, V> r10;
            if (p10 != null && (r10 = p10.right) != null) {
                TreeNode<K, V> rl = r10.left;
                p10.right = rl;
                if (rl != null) {
                    rl.parent = p10;
                }
                TreeNode<K, V> pp = p10.parent;
                r10.parent = pp;
                if (pp == null) {
                    root = r10;
                    r10.red = false;
                } else if (pp.left == p10) {
                    pp.left = r10;
                } else {
                    pp.right = r10;
                }
                r10.left = p10;
                p10.parent = r10;
            }
            return root;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> root, TreeNode<K, V> p10) {
            TreeNode<K, V> l10;
            if (p10 != null && (l10 = p10.left) != null) {
                TreeNode<K, V> lr = l10.right;
                p10.left = lr;
                if (lr != null) {
                    lr.parent = p10;
                }
                TreeNode<K, V> pp = p10.parent;
                l10.parent = pp;
                if (pp == null) {
                    root = l10;
                    l10.red = false;
                } else if (pp.right == p10) {
                    pp.right = l10;
                } else {
                    pp.left = l10;
                }
                l10.right = p10;
                p10.parent = l10;
            }
            return root;
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> root, TreeNode<K, V> x10) {
            x10.red = true;
            while (true) {
                TreeNode<K, V> treeNode = x10.parent;
                TreeNode<K, V> xp = treeNode;
                if (treeNode == null) {
                    x10.red = false;
                    return x10;
                }
                if (!xp.red) {
                    break;
                }
                TreeNode<K, V> treeNode2 = xp.parent;
                TreeNode<K, V> xpp = treeNode2;
                if (treeNode2 == null) {
                    break;
                }
                TreeNode<K, V> xppl = xpp.left;
                if (xp == xppl) {
                    TreeNode<K, V> xppr = xpp.right;
                    if (xppr != null && xppr.red) {
                        xppr.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x10 = xpp;
                    } else {
                        if (x10 == xp.right) {
                            x10 = xp;
                            root = rotateLeft(root, xp);
                            TreeNode<K, V> treeNode3 = x10.parent;
                            xp = treeNode3;
                            xpp = treeNode3 != null ? xp.parent : null;
                        }
                        if (xp != null) {
                            xp.red = false;
                            if (xpp != null) {
                                xpp.red = true;
                                root = rotateRight(root, xpp);
                            }
                        }
                    }
                } else if (xppl != null && xppl.red) {
                    xppl.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x10 = xpp;
                } else {
                    if (x10 == xp.left) {
                        x10 = xp;
                        root = rotateRight(root, xp);
                        TreeNode<K, V> treeNode4 = x10.parent;
                        xp = treeNode4;
                        xpp = treeNode4 != null ? xp.parent : null;
                    }
                    if (xp != null) {
                        xp.red = false;
                        if (xpp != null) {
                            xpp.red = true;
                            root = rotateLeft(root, xpp);
                        }
                    }
                }
            }
            return root;
        }

        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> root, TreeNode<K, V> x10) {
            while (x10 != null && x10 != root) {
                TreeNode<K, V> treeNode = x10.parent;
                TreeNode<K, V> xp = treeNode;
                if (treeNode == null) {
                    x10.red = false;
                    return x10;
                }
                if (x10.red) {
                    x10.red = false;
                    return root;
                }
                TreeNode<K, V> treeNode2 = xp.left;
                TreeNode<K, V> xpl = treeNode2;
                if (treeNode2 == x10) {
                    TreeNode<K, V> treeNode3 = xp.right;
                    TreeNode<K, V> xpr = treeNode3;
                    if (treeNode3 != null && xpr.red) {
                        xpr.red = false;
                        xp.red = true;
                        root = rotateLeft(root, xp);
                        TreeNode<K, V> treeNode4 = x10.parent;
                        xp = treeNode4;
                        xpr = treeNode4 == null ? null : xp.right;
                    }
                    if (xpr == null) {
                        x10 = xp;
                    } else {
                        TreeNode<K, V> sl = xpr.left;
                        TreeNode<K, V> sr = xpr.right;
                        if ((sr == null || !sr.red) && (sl == null || !sl.red)) {
                            xpr.red = true;
                            x10 = xp;
                        } else {
                            if (sr == null || !sr.red) {
                                if (sl != null) {
                                    sl.red = false;
                                }
                                xpr.red = true;
                                root = rotateRight(root, xpr);
                                TreeNode<K, V> treeNode5 = x10.parent;
                                xp = treeNode5;
                                xpr = treeNode5 != null ? xp.right : null;
                            }
                            if (xpr != null) {
                                xpr.red = xp == null ? false : xp.red;
                                TreeNode<K, V> sr2 = xpr.right;
                                if (sr2 != null) {
                                    sr2.red = false;
                                }
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateLeft(root, xp);
                            }
                            x10 = root;
                        }
                    }
                } else {
                    if (xpl != null && xpl.red) {
                        xpl.red = false;
                        xp.red = true;
                        root = rotateRight(root, xp);
                        TreeNode<K, V> treeNode6 = x10.parent;
                        xp = treeNode6;
                        xpl = treeNode6 == null ? null : xp.left;
                    }
                    if (xpl == null) {
                        x10 = xp;
                    } else {
                        TreeNode<K, V> sl2 = xpl.left;
                        TreeNode<K, V> sr3 = xpl.right;
                        if ((sl2 == null || !sl2.red) && (sr3 == null || !sr3.red)) {
                            xpl.red = true;
                            x10 = xp;
                        } else {
                            if (sl2 == null || !sl2.red) {
                                if (sr3 != null) {
                                    sr3.red = false;
                                }
                                xpl.red = true;
                                root = rotateLeft(root, xpl);
                                TreeNode<K, V> treeNode7 = x10.parent;
                                xp = treeNode7;
                                xpl = treeNode7 != null ? xp.left : null;
                            }
                            if (xpl != null) {
                                xpl.red = xp == null ? false : xp.red;
                                TreeNode<K, V> sl3 = xpl.left;
                                if (sl3 != null) {
                                    sl3.red = false;
                                }
                            }
                            if (xp != null) {
                                xp.red = false;
                                root = rotateRight(root, xp);
                            }
                            x10 = root;
                        }
                    }
                }
            }
            return root;
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> t2) {
            TreeNode<K, V> tp = t2.parent;
            TreeNode<K, V> tl = t2.left;
            TreeNode<K, V> tr = t2.right;
            TreeNode<K, V> tb2 = t2.prev;
            TreeNode<K, V> tn = (TreeNode) t2.next;
            if (tb2 != null && tb2.next != t2) {
                return false;
            }
            if (tn != null && tn.prev != t2) {
                return false;
            }
            if (tp != null && t2 != tp.left && t2 != tp.right) {
                return false;
            }
            if (tl != null && (tl.parent != t2 || tl.hash > t2.hash)) {
                return false;
            }
            if (tr != null && (tr.parent != t2 || tr.hash < t2.hash)) {
                return false;
            }
            if (t2.red && tl != null && tl.red && tr != null && tr.red) {
                return false;
            }
            if (tl != null && !checkInvariants(tl)) {
                return false;
            }
            if (tr != null && !checkInvariants(tr)) {
                return false;
            }
            return true;
        }
    }
}
