package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_BUCKETS = 255;
    private final Node<K, V>[] buckets;
    private final Lock[] locks;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class BaseIterator {
        private int bucket;
        private final ArrayList<Map.Entry<K, V>> current;
        private Map.Entry<K, V> last;

        private BaseIterator() {
            this.current = new ArrayList<>();
        }

        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node<K, V> node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (this.current.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Map.Entry<K, V> nextEntry() {
            if (hasNext()) {
                Map.Entry<K, V> remove = this.current.remove(r0.size() - 1);
                this.last = remove;
                return remove;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Map.Entry<K, V> entry = this.last;
            if (entry != null) {
                StaticBucketMap.this.remove(entry.getKey());
                this.last = null;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class EntryIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class KeyIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                for (Node<K, V> node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                    K key = node.getKey();
                    if (key != obj && (key == null || !key.equals(obj))) {
                    }
                    StaticBucketMap.this.remove(key);
                    return true;
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Lock {
        public int size;

        private Lock() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Node<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        public K key;
        public Node<K, V> next;
        public V value;

        private Node() {
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.key;
            if (k10 != null ? k10.equals(entry.getKey()) : entry.getKey() == null) {
                V v2 = this.value;
                if (v2 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (v2.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
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
        public int hashCode() {
            K k10 = this.key;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v2 = this.value;
            return hashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = this.value;
            this.value = v2;
            return v10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ValueIterator extends StaticBucketMap<K, V>.BaseIterator implements Iterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().getValue();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int hashCode = obj.hashCode();
        int i10 = hashCode + (~(hashCode << 15));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = i13 + (~(i13 << 11));
        int length = (i14 ^ (i14 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    public void atomic(Runnable runnable) {
        Objects.requireNonNull(runnable);
        atomic(runnable, 0);
    }

    @Override // java.util.Map
    public void clear() {
        for (int i10 = 0; i10 < this.buckets.length; i10++) {
            Lock lock = this.locks[i10];
            synchronized (lock) {
                this.buckets[i10] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                K k10 = node.key;
                if (k10 != obj && (k10 == null || !k10.equals(obj))) {
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (int i10 = 0; i10 < this.buckets.length; i10++) {
            synchronized (this.locks[i10]) {
                for (Node<K, V> node = this.buckets[i10]; node != null; node = node.next) {
                    V v2 = node.value;
                    if (v2 != obj && (v2 == null || !v2.equals(obj))) {
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            for (Node<K, V> node = this.buckets[hash]; node != null; node = node.next) {
                K k10 = node.key;
                if (k10 != obj && (k10 == null || !k10.equals(obj))) {
                }
                return node.value;
            }
            return null;
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.buckets.length; i11++) {
            synchronized (this.locks[i11]) {
                for (Node<K, V> node = this.buckets[i11]; node != null; node = node.next) {
                    i10 += node.hashCode();
                }
            }
        }
        return i10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        return new KeySet();
    }

    @Override // java.util.Map
    public V put(K k10, V v2) {
        int hash = getHash(k10);
        synchronized (this.locks[hash]) {
            Node<K, V> node = this.buckets[hash];
            if (node == null) {
                Node<K, V> node2 = new Node<>();
                node2.key = k10;
                node2.value = v2;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node<K, V> node3 = node;
            while (node != null) {
                K k11 = node.key;
                if (k11 != k10 && (k11 == null || !k11.equals(k10))) {
                    node3 = node;
                    node = node.next;
                }
                V v10 = node.value;
                node.value = v2;
                return v10;
            }
            Node<K, V> node4 = new Node<>();
            node4.key = k10;
            node4.value = v2;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node<K, V> node = null;
            for (Node<K, V> node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                K k10 = node2.key;
                if (k10 != obj && (k10 == null || !k10.equals(obj))) {
                    node = node2;
                }
                if (node == null) {
                    this.buckets[hash] = node2.next;
                } else {
                    node.next = node2.next;
                }
                Lock lock = this.locks[hash];
                lock.size--;
                return node2.value;
            }
            return null;
        }
    }

    @Override // java.util.Map
    public int size() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.buckets.length; i11++) {
            synchronized (this.locks[i11]) {
                i10 += this.locks[i11].size;
            }
        }
        return i10;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return new Values();
    }

    public StaticBucketMap(int i10) {
        int max = Math.max(17, i10);
        max = max % 2 == 0 ? max - 1 : max;
        this.buckets = new Node[max];
        this.locks = new Lock[max];
        for (int i11 = 0; i11 < max; i11++) {
            this.locks[i11] = new Lock();
        }
    }

    private void atomic(Runnable runnable, int i10) {
        if (i10 >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i10]) {
            atomic(runnable, i10 + 1);
        }
    }
}
