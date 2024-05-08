package java.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    private static final long serialVersionUID = 3801124242820219131L;
    final boolean accessOrder;
    transient LinkedHashMapEntry<K, V> head;
    transient LinkedHashMapEntry<K, V> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class LinkedHashMapEntry<K, V> extends HashMap.Node<K, V> {
        LinkedHashMapEntry<K, V> after;
        LinkedHashMapEntry<K, V> before;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LinkedHashMapEntry(int hash, K key, V value, HashMap.Node<K, V> next) {
            super(hash, key, value, next);
        }
    }

    private void linkNodeLast(LinkedHashMapEntry<K, V> p10) {
        LinkedHashMapEntry<K, V> last = this.tail;
        this.tail = p10;
        if (last == null) {
            this.head = p10;
        } else {
            p10.before = last;
            last.after = p10;
        }
    }

    private void transferLinks(LinkedHashMapEntry<K, V> src, LinkedHashMapEntry<K, V> dst) {
        LinkedHashMapEntry<K, V> b4 = src.before;
        dst.before = b4;
        LinkedHashMapEntry<K, V> a10 = src.after;
        dst.after = a10;
        if (b4 == null) {
            this.head = dst;
        } else {
            b4.after = dst;
        }
        if (a10 == null) {
            this.tail = dst;
        } else {
            a10.before = dst;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.HashMap
    public void reinitialize() {
        super.reinitialize();
        this.tail = null;
        this.head = null;
    }

    @Override // java.util.HashMap
    HashMap.Node<K, V> newNode(int hash, K key, V value, HashMap.Node<K, V> e2) {
        LinkedHashMapEntry<K, V> p10 = new LinkedHashMapEntry<>(hash, key, value, e2);
        linkNodeLast(p10);
        return p10;
    }

    @Override // java.util.HashMap
    HashMap.Node<K, V> replacementNode(HashMap.Node<K, V> p10, HashMap.Node<K, V> next) {
        LinkedHashMapEntry<K, V> q10 = (LinkedHashMapEntry) p10;
        LinkedHashMapEntry<K, V> t2 = new LinkedHashMapEntry<>(q10.hash, q10.key, q10.value, next);
        transferLinks(q10, t2);
        return t2;
    }

    @Override // java.util.HashMap
    HashMap.TreeNode<K, V> newTreeNode(int hash, K key, V value, HashMap.Node<K, V> next) {
        HashMap.TreeNode<K, V> p10 = new HashMap.TreeNode<>(hash, key, value, next);
        linkNodeLast(p10);
        return p10;
    }

    @Override // java.util.HashMap
    HashMap.TreeNode<K, V> replacementTreeNode(HashMap.Node<K, V> p10, HashMap.Node<K, V> next) {
        LinkedHashMapEntry<K, V> q10 = (LinkedHashMapEntry) p10;
        HashMap.TreeNode<K, V> t2 = new HashMap.TreeNode<>(q10.hash, q10.key, q10.value, next);
        transferLinks(q10, t2);
        return t2;
    }

    @Override // java.util.HashMap
    void afterNodeRemoval(HashMap.Node<K, V> e2) {
        LinkedHashMapEntry<K, V> p10 = (LinkedHashMapEntry) e2;
        LinkedHashMapEntry<K, V> b4 = p10.before;
        LinkedHashMapEntry<K, V> a10 = p10.after;
        p10.after = null;
        p10.before = null;
        if (b4 == null) {
            this.head = a10;
        } else {
            b4.after = a10;
        }
        if (a10 == null) {
            this.tail = b4;
        } else {
            a10.before = b4;
        }
    }

    @Override // java.util.HashMap
    void afterNodeInsertion(boolean evict) {
        LinkedHashMapEntry<K, V> first;
        if (evict && (first = this.head) != null && removeEldestEntry(first)) {
            K key = first.key;
            removeNode(hash(key), key, null, false, true);
        }
    }

    @Override // java.util.HashMap
    void afterNodeAccess(HashMap.Node<K, V> e2) {
        if (this.accessOrder) {
            LinkedHashMapEntry<K, V> linkedHashMapEntry = this.tail;
            LinkedHashMapEntry<K, V> last = linkedHashMapEntry;
            if (linkedHashMapEntry != e2) {
                LinkedHashMapEntry<K, V> p10 = (LinkedHashMapEntry) e2;
                LinkedHashMapEntry<K, V> b4 = p10.before;
                LinkedHashMapEntry<K, V> a10 = p10.after;
                p10.after = null;
                if (b4 == null) {
                    this.head = a10;
                } else {
                    b4.after = a10;
                }
                if (a10 != null) {
                    a10.before = b4;
                } else {
                    last = b4;
                }
                if (last == null) {
                    this.head = p10;
                } else {
                    p10.before = last;
                    last.after = p10;
                }
                this.tail = p10;
                this.modCount++;
            }
        }
    }

    @Override // java.util.HashMap
    void internalWriteEntries(ObjectOutputStream s2) throws IOException {
        for (LinkedHashMapEntry<K, V> e2 = this.head; e2 != null; e2 = e2.after) {
            s2.writeObject(e2.key);
            s2.writeObject(e2.value);
        }
    }

    public LinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        this.accessOrder = false;
    }

    public LinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        this.accessOrder = false;
    }

    public LinkedHashMap() {
        this.accessOrder = false;
    }

    public LinkedHashMap(Map<? extends K, ? extends V> m10) {
        this.accessOrder = false;
        putMapEntries(m10, false);
    }

    public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        for (LinkedHashMapEntry<K, V> e2 = this.head; e2 != null; e2 = e2.after) {
            V v2 = e2.value;
            if (v2 == value) {
                return true;
            }
            if (value != null && value.equals(v2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        HashMap.Node<K, V> e2 = getNode(key);
        if (e2 == null) {
            return null;
        }
        if (this.accessOrder) {
            afterNodeAccess(e2);
        }
        return e2.value;
    }

    @Override // java.util.HashMap, java.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        HashMap.Node<K, V> e2 = getNode(key);
        if (e2 == null) {
            return defaultValue;
        }
        if (this.accessOrder) {
            afterNodeAccess(e2);
        }
        return e2.value;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.tail = null;
        this.head = null;
    }

    public Map.Entry<K, V> eldest() {
        return this.head;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks == null) {
            Set<K> ks2 = new LinkedKeySet();
            this.keySet = ks2;
            return ks2;
        }
        return ks;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LinkedKeySet extends AbstractSet<K> {
        LinkedKeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<K> iterator2() {
            return new LinkedKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            return LinkedHashMap.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object key) {
            return LinkedHashMap.this.removeNode(HashMap.hash(key), key, null, false, true) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<K> spliterator() {
            return Spliterators.spliterator(this, 81);
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            int i10 = LinkedHashMap.this.modCount;
            for (LinkedHashMapEntry<K, V> linkedHashMapEntry = LinkedHashMap.this.head; linkedHashMapEntry != null && LinkedHashMap.this.modCount == i10; linkedHashMapEntry = linkedHashMapEntry.after) {
                consumer.accept(linkedHashMapEntry.key);
            }
            if (LinkedHashMap.this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs == null) {
            Collection<V> vs2 = new LinkedValues();
            this.values = vs2;
            return vs2;
        }
        return vs;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LinkedValues extends AbstractCollection<V> {
        LinkedValues() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<V> iterator2() {
            return new LinkedValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            return LinkedHashMap.this.containsValue(o10);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<V> spliterator() {
            return Spliterators.spliterator(this, 80);
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            int i10 = LinkedHashMap.this.modCount;
            for (LinkedHashMapEntry<K, V> linkedHashMapEntry = LinkedHashMap.this.head; linkedHashMapEntry != null && LinkedHashMap.this.modCount == i10; linkedHashMapEntry = linkedHashMapEntry.after) {
                consumer.accept(linkedHashMapEntry.value);
            }
            if (LinkedHashMap.this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        LinkedEntrySet linkedEntrySet = new LinkedEntrySet();
        this.entrySet = linkedEntrySet;
        return linkedEntrySet;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LinkedEntrySet extends AbstractSet<Map.Entry<K, V>> {
        LinkedEntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedHashMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<Map.Entry<K, V>> iterator2() {
            return new LinkedEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            Object key = e2.getKey();
            HashMap.Node<K, V> candidate = LinkedHashMap.this.getNode(key);
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
            return LinkedHashMap.this.removeNode(HashMap.hash(key), key, value, true, true) != null;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Spliterator<Map.Entry<K, V>> spliterator() {
            return Spliterators.spliterator(this, 81);
        }

        @Override // java.lang.Iterable
        public final void forEach(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int mc2 = LinkedHashMap.this.modCount;
            for (LinkedHashMapEntry<K, V> e2 = LinkedHashMap.this.head; e2 != null && mc2 == LinkedHashMap.this.modCount; e2 = e2.after) {
                action.accept(e2);
            }
            if (LinkedHashMap.this.modCount != mc2) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        int i10 = this.modCount;
        for (LinkedHashMapEntry<K, V> linkedHashMapEntry = this.head; this.modCount == i10 && linkedHashMapEntry != null; linkedHashMapEntry = linkedHashMapEntry.after) {
            biConsumer.accept(linkedHashMapEntry.key, linkedHashMapEntry.value);
        }
        if (this.modCount != i10) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.HashMap, java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        if (biFunction == null) {
            throw new NullPointerException();
        }
        int i10 = this.modCount;
        for (LinkedHashMapEntry<K, V> linkedHashMapEntry = this.head; this.modCount == i10 && linkedHashMapEntry != null; linkedHashMapEntry = linkedHashMapEntry.after) {
            linkedHashMapEntry.value = biFunction.apply(linkedHashMapEntry.key, linkedHashMapEntry.value);
        }
        if (this.modCount != i10) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class LinkedHashIterator {
        LinkedHashMapEntry<K, V> current = null;
        int expectedModCount;
        LinkedHashMapEntry<K, V> next;

        LinkedHashIterator() {
            this.next = LinkedHashMap.this.head;
            this.expectedModCount = LinkedHashMap.this.modCount;
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        final LinkedHashMapEntry<K, V> nextNode() {
            LinkedHashMapEntry<K, V> e2 = this.next;
            if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (e2 == null) {
                throw new NoSuchElementException();
            }
            this.current = e2;
            this.next = e2.after;
            return e2;
        }

        public final void remove() {
            HashMap.Node<K, V> p10 = this.current;
            if (p10 == null) {
                throw new IllegalStateException();
            }
            if (LinkedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.current = null;
            LinkedHashMap.this.removeNode(p10.hash, p10.key, null, false, false);
            this.expectedModCount = LinkedHashMap.this.modCount;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LinkedKeyIterator extends LinkedHashMap<K, V>.LinkedHashIterator implements Iterator<K> {
        LinkedKeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final K next() {
            return nextNode().getKey();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LinkedValueIterator extends LinkedHashMap<K, V>.LinkedHashIterator implements Iterator<V> {
        LinkedValueIterator() {
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
    final class LinkedEntryIterator extends LinkedHashMap<K, V>.LinkedHashIterator implements Iterator<Map.Entry<K, V>> {
        LinkedEntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            return nextNode();
        }
    }
}
