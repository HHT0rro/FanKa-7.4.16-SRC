package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    public Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    public final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    public int modCount;
    public Node<K, V> root;
    public int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return a().f26894g;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public Node<K, V> f26885b;

        /* renamed from: c, reason: collision with root package name */
        public Node<K, V> f26886c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f26887d;

        public LinkedTreeMapIterator() {
            this.f26885b = LinkedTreeMap.this.header.f26892e;
            this.f26887d = LinkedTreeMap.this.modCount;
        }

        public final Node<K, V> a() {
            Node<K, V> node = this.f26885b;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.f26887d) {
                    this.f26885b = node.f26892e;
                    this.f26886c = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f26885b != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.f26886c;
            if (node != null) {
                LinkedTreeMap.this.removeInternal(node, true);
                this.f26886c = null;
                this.f26887d = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node<K, V> node, boolean z10) {
        while (node != null) {
            Node<K, V> node2 = node.f26890c;
            Node<K, V> node3 = node.f26891d;
            int i10 = node2 != null ? node2.f26896i : 0;
            int i11 = node3 != null ? node3.f26896i : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                Node<K, V> node4 = node3.f26890c;
                Node<K, V> node5 = node3.f26891d;
                int i13 = (node4 != null ? node4.f26896i : 0) - (node5 != null ? node5.f26896i : 0);
                if (i13 != -1 && (i13 != 0 || z10)) {
                    rotateRight(node3);
                    rotateLeft(node);
                } else {
                    rotateLeft(node);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                Node<K, V> node6 = node2.f26890c;
                Node<K, V> node7 = node2.f26891d;
                int i14 = (node6 != null ? node6.f26896i : 0) - (node7 != null ? node7.f26896i : 0);
                if (i14 != 1 && (i14 != 0 || z10)) {
                    rotateLeft(node2);
                    rotateRight(node);
                } else {
                    rotateRight(node);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                node.f26896i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                node.f26896i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            node = node.f26889b;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.f26889b;
        node.f26889b = null;
        if (node2 != null) {
            node2.f26889b = node3;
        }
        if (node3 != null) {
            if (node3.f26890c == node) {
                node3.f26890c = node2;
                return;
            } else {
                node3.f26891d = node2;
                return;
            }
        }
        this.root = node2;
    }

    private void rotateLeft(Node<K, V> node) {
        Node<K, V> node2 = node.f26890c;
        Node<K, V> node3 = node.f26891d;
        Node<K, V> node4 = node3.f26890c;
        Node<K, V> node5 = node3.f26891d;
        node.f26891d = node4;
        if (node4 != null) {
            node4.f26889b = node;
        }
        replaceInParent(node, node3);
        node3.f26890c = node;
        node.f26889b = node3;
        int max = Math.max(node2 != null ? node2.f26896i : 0, node4 != null ? node4.f26896i : 0) + 1;
        node.f26896i = max;
        node3.f26896i = Math.max(max, node5 != null ? node5.f26896i : 0) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node<K, V> node2 = node.f26890c;
        Node<K, V> node3 = node.f26891d;
        Node<K, V> node4 = node2.f26890c;
        Node<K, V> node5 = node2.f26891d;
        node.f26890c = node5;
        if (node5 != null) {
            node5.f26889b = node;
        }
        replaceInParent(node, node2);
        node2.f26891d = node;
        node.f26889b = node2;
        int max = Math.max(node3 != null ? node3.f26896i : 0, node5 != null ? node5.f26896i : 0) + 1;
        node.f26896i = max;
        node2.f26896i = Math.max(max, node4 != null ? node4.f26896i : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.f26893f = node;
        node.f26892e = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public Node<K, V> find(K k10, boolean z10) {
        int i10;
        Node<K, V> node;
        Comparator<? super K> comparator = this.comparator;
        Node<K, V> node2 = this.root;
        if (node2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k10 : null;
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(node2.f26894g);
                } else {
                    i10 = comparator.compare(k10, node2.f26894g);
                }
                if (i10 == 0) {
                    return node2;
                }
                Node<K, V> node3 = i10 < 0 ? node2.f26890c : node2.f26891d;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node2 == null) {
            if (comparator == NATURAL_ORDER && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            node = new Node<>(node2, k10, node4, node4.f26893f);
            this.root = node;
        } else {
            node = new Node<>(node2, k10, node4, node4.f26893f);
            if (i10 < 0) {
                node2.f26890c = node;
            } else {
                node2.f26891d = node;
            }
            rebalance(node2, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    public Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f26895h, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Node<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f26895h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        Objects.requireNonNull(k10, "key == null");
        Node<K, V> find = find(k10, true);
        V v10 = find.f26895h;
        find.f26895h = v2;
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f26895h;
        }
        return null;
    }

    public void removeInternal(Node<K, V> node, boolean z10) {
        int i10;
        if (z10) {
            Node<K, V> node2 = node.f26893f;
            node2.f26892e = node.f26892e;
            node.f26892e.f26893f = node2;
        }
        Node<K, V> node3 = node.f26890c;
        Node<K, V> node4 = node.f26891d;
        Node<K, V> node5 = node.f26889b;
        int i11 = 0;
        if (node3 != null && node4 != null) {
            Node<K, V> b4 = node3.f26896i > node4.f26896i ? node3.b() : node4.a();
            removeInternal(b4, false);
            Node<K, V> node6 = node.f26890c;
            if (node6 != null) {
                i10 = node6.f26896i;
                b4.f26890c = node6;
                node6.f26889b = b4;
                node.f26890c = null;
            } else {
                i10 = 0;
            }
            Node<K, V> node7 = node.f26891d;
            if (node7 != null) {
                i11 = node7.f26896i;
                b4.f26891d = node7;
                node7.f26889b = b4;
                node.f26891d = null;
            }
            b4.f26896i = Math.max(i10, i11) + 1;
            replaceInParent(node, b4);
            return;
        }
        if (node3 != null) {
            replaceInParent(node, node3);
            node.f26890c = null;
        } else if (node4 != null) {
            replaceInParent(node, node4);
            node.f26891d = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node5, false);
        this.size--;
        this.modCount++;
    }

    public Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public Node<K, V> f26889b;

        /* renamed from: c, reason: collision with root package name */
        public Node<K, V> f26890c;

        /* renamed from: d, reason: collision with root package name */
        public Node<K, V> f26891d;

        /* renamed from: e, reason: collision with root package name */
        public Node<K, V> f26892e;

        /* renamed from: f, reason: collision with root package name */
        public Node<K, V> f26893f;

        /* renamed from: g, reason: collision with root package name */
        public final K f26894g;

        /* renamed from: h, reason: collision with root package name */
        public V f26895h;

        /* renamed from: i, reason: collision with root package name */
        public int f26896i;

        public Node() {
            this.f26894g = null;
            this.f26893f = this;
            this.f26892e = this;
        }

        public Node<K, V> a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f26890c; node2 != null; node2 = node2.f26890c) {
                node = node2;
            }
            return node;
        }

        public Node<K, V> b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f26891d; node2 != null; node2 = node2.f26891d) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f26894g;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v2 = this.f26895h;
            if (v2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f26894g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f26895h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f26894g;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v2 = this.f26895h;
            return hashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = this.f26895h;
            this.f26895h = v2;
            return v10;
        }

        public String toString() {
            return ((Object) this.f26894g) + "=" + ((Object) this.f26895h);
        }

        public Node(Node<K, V> node, K k10, Node<K, V> node2, Node<K, V> node3) {
            this.f26889b = node;
            this.f26894g = k10;
            this.f26896i = 1;
            this.f26892e = node2;
            this.f26893f = node3;
            node3.f26892e = this;
            node2.f26893f = this;
        }
    }
}
