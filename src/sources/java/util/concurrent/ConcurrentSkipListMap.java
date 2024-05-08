package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConcurrentSkipListMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Cloneable, Serializable {
    private static final VarHandle ADDER;
    private static final int EQ = 1;
    private static final int GT = 0;
    private static final VarHandle HEAD;
    private static final int LT = 2;
    private static final VarHandle NEXT;
    private static final VarHandle RIGHT;
    private static final VarHandle VAL;
    private static final long serialVersionUID = -8627078645895051609L;
    private transient LongAdder adder;
    final Comparator<? super K> comparator;
    private transient SubMap<K, V> descendingMap;
    private transient EntrySet<K, V> entrySet;
    private transient Index<K, V> head;
    private transient KeySet<K, V> keySet;
    private transient Values<K, V> values;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z10) {
        return headMap((ConcurrentSkipListMap<K, V>) obj, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap((ConcurrentSkipListMap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        return subMap((boolean) obj, z10, (boolean) obj2, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z10) {
        return tailMap((ConcurrentSkipListMap<K, V>) obj, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap((ConcurrentSkipListMap<K, V>) obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node<K, V> {
        final K key;
        Node<K, V> next;
        V val;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.val = value;
            this.next = next;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Index<K, V> {
        final Index<K, V> down;
        final Node<K, V> node;
        Index<K, V> right;

        Index(Node<K, V> node, Index<K, V> down, Index<K, V> right) {
            this.node = node;
            this.down = down;
            this.right = right;
        }
    }

    static int cpr(Comparator c4, Object x10, Object y10) {
        return c4 != null ? c4.compare(x10, y10) : ((Comparable) x10).compareTo(y10);
    }

    final Node<K, V> baseHead() {
        VarHandle.acquireFence();
        Index<K, V> h10 = this.head;
        if (h10 == null) {
            return null;
        }
        return h10.node;
    }

    static <K, V> void unlinkNode(Node<K, V> b4, Node<K, V> n10) {
        Node<K, V> p10;
        if (b4 == null || n10 == null) {
            return;
        }
        while (true) {
            Node<K, V> f10 = n10.next;
            if (f10 != null && f10.key == null) {
                p10 = f10.next;
                break;
            } else if ((boolean) NEXT.compareAndSet(n10, f10, new Node(null, null, f10))) {
                p10 = f10;
                break;
            }
        }
        (boolean) NEXT.compareAndSet(b4, n10, p10);
    }

    private void addCount(long c4) {
        LongAdder a10;
        VarHandle varHandle;
        LongAdder longAdder;
        do {
            LongAdder longAdder2 = this.adder;
            a10 = longAdder2;
            if (longAdder2 != null) {
                break;
            }
            varHandle = ADDER;
            longAdder = new LongAdder();
            a10 = longAdder;
        } while (!(boolean) varHandle.compareAndSet(this, null, longAdder));
        a10.add(c4);
    }

    final long getAdderCount() {
        LongAdder a10;
        VarHandle varHandle;
        LongAdder longAdder;
        do {
            LongAdder longAdder2 = this.adder;
            a10 = longAdder2;
            if (longAdder2 != null) {
                break;
            }
            varHandle = ADDER;
            longAdder = new LongAdder();
            a10 = longAdder;
        } while (!(boolean) varHandle.compareAndSet(this, null, longAdder));
        long c4 = a10.sum();
        if (c4 <= 0) {
            return 0L;
        }
        return c4;
    }

    private Node<K, V> findPredecessor(Object key, Comparator<? super K> cmp) {
        K k10;
        VarHandle.acquireFence();
        Index<K, V> index = this.head;
        Index<K, V> q10 = index;
        if (index == null || key == null) {
            return null;
        }
        while (true) {
            Index<K, V> r10 = q10.right;
            if (r10 != null) {
                Node<K, V> p10 = r10.node;
                if (p10 == null || (k10 = p10.key) == null || p10.val == null) {
                    (boolean) RIGHT.compareAndSet(q10, r10, r10.right);
                } else if (cpr(cmp, key, k10) > 0) {
                    q10 = r10;
                }
            }
            Index<K, V> d10 = q10.down;
            if (d10 != null) {
                q10 = d10;
            } else {
                return q10.node;
            }
        }
    }

    private Node<K, V> findNode(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Comparator<? super K> cmp = this.comparator;
        while (true) {
            Node<K, V> findPredecessor = findPredecessor(key, cmp);
            Node<K, V> b4 = findPredecessor;
            if (findPredecessor == null) {
                return null;
            }
            while (true) {
                Node<K, V> n10 = b4.next;
                if (n10 != null) {
                    K k10 = n10.key;
                    if (k10 == null) {
                        break;
                    }
                    if (n10.val == null) {
                        unlinkNode(b4, n10);
                    } else {
                        int c4 = cpr(cmp, key, k10);
                        if (c4 > 0) {
                            b4 = n10;
                        } else {
                            if (c4 == 0) {
                                return n10;
                            }
                            return null;
                        }
                    }
                } else {
                    return null;
                }
            }
        }
    }

    private V doGet(Object key) {
        int c4;
        K k10;
        V v2;
        VarHandle.acquireFence();
        if (key == null) {
            throw new NullPointerException();
        }
        Comparator<? super K> cmp = this.comparator;
        Index<K, V> index = this.head;
        Index<K, V> q10 = index;
        if (index == null) {
            return null;
        }
        while (true) {
            Index<K, V> r10 = q10.right;
            if (r10 != null) {
                Node<K, V> p10 = r10.node;
                if (p10 == null || (k10 = p10.key) == null || (v2 = p10.val) == null) {
                    (boolean) RIGHT.compareAndSet(q10, r10, r10.right);
                } else {
                    int c10 = cpr(cmp, key, k10);
                    if (c10 > 0) {
                        q10 = r10;
                    } else if (c10 == 0) {
                        return v2;
                    }
                }
            }
            Index<K, V> d10 = q10.down;
            if (d10 != null) {
                q10 = d10;
            } else {
                Node<K, V> node = q10.node;
                Node<K, V> b4 = node;
                if (node == null) {
                    return null;
                }
                while (true) {
                    Node<K, V> n10 = b4.next;
                    if (n10 == null) {
                        return null;
                    }
                    K k11 = n10.key;
                    V v10 = n10.val;
                    if (v10 == null || k11 == null || (c4 = cpr(cmp, key, k11)) > 0) {
                        b4 = n10;
                    } else {
                        if (c4 != 0) {
                            return null;
                        }
                        return v10;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0097, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private V doPut(K r18, V r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.doPut(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    static <K, V> boolean addIndices(Index<K, V> q10, int skips, Index<K, V> x10, Comparator<? super K> cmp) {
        Node<K, V> z10;
        K key;
        int c4;
        K k10;
        if (x10 != null && (z10 = x10.node) != null && (key = z10.key) != null && q10 != null) {
            boolean retrying = false;
            while (true) {
                Index<K, V> r10 = q10.right;
                if (r10 != null) {
                    Node<K, V> p10 = r10.node;
                    if (p10 == null || (k10 = p10.key) == null || p10.val == null) {
                        (boolean) RIGHT.compareAndSet(q10, r10, r10.right);
                        c4 = 0;
                    } else {
                        int cpr = cpr(cmp, key, k10);
                        c4 = cpr;
                        if (cpr > 0) {
                            q10 = r10;
                        } else if (c4 == 0) {
                            break;
                        }
                    }
                } else {
                    c4 = -1;
                }
                if (c4 < 0) {
                    Index<K, V> d10 = q10.down;
                    if (d10 != null && skips > 0) {
                        skips--;
                        q10 = d10;
                    } else {
                        if (d10 != null && !retrying && !addIndices(d10, 0, x10.down, cmp)) {
                            break;
                        }
                        x10.right = r10;
                        if ((boolean) RIGHT.compareAndSet(q10, r10, x10)) {
                            return true;
                        }
                        retrying = true;
                    }
                }
            }
        }
        return false;
    }

    final V doRemove(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException();
        }
        Comparator<? super K> cmp = this.comparator;
        V result = null;
        loop0: while (true) {
            Node<K, V> findPredecessor = findPredecessor(key, cmp);
            Node<K, V> b4 = findPredecessor;
            if (findPredecessor == null || result != null) {
                break;
            }
            while (true) {
                Node<K, V> n10 = b4.next;
                if (n10 == null) {
                    break loop0;
                }
                K k10 = n10.key;
                if (k10 != null) {
                    V v2 = n10.val;
                    if (v2 == null) {
                        unlinkNode(b4, n10);
                    } else {
                        int c4 = cpr(cmp, key, k10);
                        if (c4 > 0) {
                            b4 = n10;
                        } else {
                            if (c4 < 0 || (value != null && !value.equals(v2))) {
                                break loop0;
                            }
                            if ((boolean) VAL.compareAndSet(n10, v2, null)) {
                                result = v2;
                                unlinkNode(b4, n10);
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (result != null) {
            tryReduceLevel();
            addCount(-1L);
        }
        return result;
    }

    private void tryReduceLevel() {
        Index<K, V> d10;
        Index<K, V> e2;
        Index<K, V> h10 = this.head;
        if (h10 != null && h10.right == null && (d10 = h10.down) != null && d10.right == null && (e2 = d10.down) != null && e2.right == null) {
            VarHandle varHandle = HEAD;
            if ((boolean) varHandle.compareAndSet(this, h10, d10) && h10.right != null) {
                (boolean) varHandle.compareAndSet(this, d10, h10);
            }
        }
    }

    final Node<K, V> findFirst() {
        Node<K, V> b4 = baseHead();
        if (b4 == null) {
            return null;
        }
        while (true) {
            Node<K, V> n10 = b4.next;
            if (n10 != null) {
                if (n10.val != null) {
                    return n10;
                }
                unlinkNode(b4, n10);
            } else {
                return null;
            }
        }
    }

    final AbstractMap.SimpleImmutableEntry<K, V> findFirstEntry() {
        Node<K, V> b4 = baseHead();
        if (b4 == null) {
            return null;
        }
        while (true) {
            Node<K, V> n10 = b4.next;
            if (n10 != null) {
                V v2 = n10.val;
                if (v2 == null) {
                    unlinkNode(b4, n10);
                } else {
                    return new AbstractMap.SimpleImmutableEntry<>(n10.key, v2);
                }
            } else {
                return null;
            }
        }
    }

    private AbstractMap.SimpleImmutableEntry<K, V> doRemoveFirstEntry() {
        Node<K, V> b4 = baseHead();
        if (b4 != null) {
            while (true) {
                Node<K, V> n10 = b4.next;
                if (n10 == null) {
                    break;
                }
                V v2 = n10.val;
                if (v2 == null || (boolean) VAL.compareAndSet(n10, v2, null)) {
                    K k10 = n10.key;
                    unlinkNode(b4, n10);
                    if (v2 != null) {
                        tryReduceLevel();
                        findPredecessor(k10, this.comparator);
                        addCount(-1L);
                        return new AbstractMap.SimpleImmutableEntry<>(k10, v2);
                    }
                }
            }
        }
        return null;
    }

    final Node<K, V> findLast() {
        while (true) {
            VarHandle.acquireFence();
            Index<K, V> index = this.head;
            Index<K, V> q10 = index;
            if (index != null) {
                while (true) {
                    Index<K, V> r10 = q10.right;
                    if (r10 != null) {
                        Node<K, V> p10 = r10.node;
                        if (p10 == null || p10.val == null) {
                            (boolean) RIGHT.compareAndSet(q10, r10, r10.right);
                        } else {
                            q10 = r10;
                        }
                    } else {
                        Index<K, V> d10 = q10.down;
                        if (d10 == null) {
                            break;
                        }
                        q10 = d10;
                    }
                }
                Node<K, V> b4 = q10.node;
                if (b4 != null) {
                    while (true) {
                        Node<K, V> n10 = b4.next;
                        if (n10 == null) {
                            if (b4.key != null) {
                                return b4;
                            }
                            return null;
                        }
                        if (n10.key == null) {
                            break;
                        }
                        if (n10.val == null) {
                            unlinkNode(b4, n10);
                        } else {
                            b4 = n10;
                        }
                    }
                }
            } else {
                return null;
            }
        }
    }

    final AbstractMap.SimpleImmutableEntry<K, V> findLastEntry() {
        Node<K, V> n10;
        V v2;
        do {
            n10 = findLast();
            if (n10 == null) {
                return null;
            }
            v2 = n10.val;
        } while (v2 == null);
        return new AbstractMap.SimpleImmutableEntry<>(n10.key, v2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0001, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003f, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map.Entry<K, V> doRemoveLastEntry() {
        /*
            r7 = this;
        L1:
            java.lang.invoke.VarHandle.acquireFence()
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r0 = r7.head
            r1 = r0
            r2 = 0
            if (r0 != 0) goto Lb
            goto L3f
        Lb:
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r0 = r1.right
            r3 = r0
            if (r0 == 0) goto L29
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r3.node
            r4 = r0
            if (r0 == 0) goto L20
            V r0 = r4.val
            if (r0 != 0) goto L1a
            goto L20
        L1a:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r4.next
            if (r0 == 0) goto L29
            r1 = r3
            goto Lb
        L20:
            java.lang.invoke.VarHandle r0 = java.util.concurrent.ConcurrentSkipListMap.RIGHT
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r5 = r3.right
            (boolean) r0.compareAndSet(r1, r3, r5)
            goto Lb
        L29:
            java.util.concurrent.ConcurrentSkipListMap$Index<K, V> r0 = r1.down
            r4 = r0
            if (r0 == 0) goto L30
            r1 = r4
            goto Lb
        L30:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r0 = r1.node
            if (r0 == 0) goto L75
        L35:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r3 = r0.next
            r4 = r3
            if (r3 != 0) goto L40
            K r3 = r0.key
            if (r3 != 0) goto L75
        L3f:
            return r2
        L40:
            K r3 = r4.key
            r5 = r3
            if (r3 != 0) goto L46
            goto L75
        L46:
            V r3 = r4.val
            r6 = r3
            if (r3 != 0) goto L4f
            unlinkNode(r0, r4)
            goto L74
        L4f:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r3 = r4.next
            if (r3 == 0) goto L55
            r0 = r4
            goto L74
        L55:
            java.lang.invoke.VarHandle r3 = java.util.concurrent.ConcurrentSkipListMap.VAL
            boolean r3 = (boolean) r3.compareAndSet(r4, r6, r2)
            if (r3 == 0) goto L74
            unlinkNode(r0, r4)
            r7.tryReduceLevel()
            java.util.Comparator<? super K> r2 = r7.comparator
            r7.findPredecessor(r5, r2)
            r2 = -1
            r7.addCount(r2)
            java.util.AbstractMap$SimpleImmutableEntry r2 = new java.util.AbstractMap$SimpleImmutableEntry
            r2.<init>(r5, r6)
            return r2
        L74:
            goto L35
        L75:
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.doRemoveLastEntry():java.util.Map$Entry");
    }

    final Node<K, V> findNear(K key, int rel, Comparator<? super K> cmp) {
        Node<K, V> result;
        if (key == null) {
            throw new NullPointerException();
        }
        loop0: while (true) {
            Node<K, V> findPredecessor = findPredecessor(key, cmp);
            Node<K, V> b4 = findPredecessor;
            if (findPredecessor == null) {
                return null;
            }
            while (true) {
                result = b4.next;
                if (result == null) {
                    if ((rel & 2) != 0 && b4.key != null) {
                        result = b4;
                    }
                    return result;
                }
                K k10 = result.key;
                if (k10 == null) {
                    break;
                }
                if (result.val == null) {
                    unlinkNode(b4, result);
                } else {
                    int c4 = cpr(cmp, key, k10);
                    if ((c4 != 0 || (rel & 1) == 0) && (c4 >= 0 || (rel & 2) != 0)) {
                        if (c4 <= 0 && (rel & 2) != 0) {
                            return b4.key != null ? b4 : null;
                        }
                        b4 = result;
                    }
                }
            }
        }
        return result;
    }

    final AbstractMap.SimpleImmutableEntry<K, V> findNearEntry(K key, int rel, Comparator<? super K> cmp) {
        Node<K, V> n10;
        V v2;
        do {
            n10 = findNear(key, rel, cmp);
            if (n10 == null) {
                return null;
            }
            v2 = n10.val;
        } while (v2 == null);
        return new AbstractMap.SimpleImmutableEntry<>(n10.key, v2);
    }

    public ConcurrentSkipListMap() {
        this.comparator = null;
    }

    public ConcurrentSkipListMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    public ConcurrentSkipListMap(Map<? extends K, ? extends V> m10) {
        this.comparator = null;
        putAll(m10);
    }

    public ConcurrentSkipListMap(SortedMap<K, ? extends V> m10) {
        this.comparator = m10.comparator();
        buildFromSorted(m10);
    }

    @Override // java.util.AbstractMap
    public ConcurrentSkipListMap<K, V> clone() {
        try {
            ConcurrentSkipListMap<K, V> clone = (ConcurrentSkipListMap) super.clone();
            clone.keySet = null;
            clone.entrySet = null;
            clone.values = null;
            clone.descendingMap = null;
            clone.adder = null;
            clone.buildFromSorted(this);
            return clone;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void buildFromSorted(SortedMap<K, ? extends V> sortedMap) {
        if (sortedMap == null) {
            throw new NullPointerException();
        }
        Index[] indexArr = new Index[64];
        Node node = null;
        Node<K, V> node2 = new Node<>(null, null, null);
        Index<K, V> index = new Index<>(node2, null, null);
        indexArr[0] = index;
        long j10 = 0;
        for (Map.Entry<K, ? extends V> entry : sortedMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new NullPointerException();
            }
            Node<K, V> node3 = new Node<>(key, value, node);
            node2.next = node3;
            node2 = node3;
            long j11 = j10 + 1;
            j10 = j11;
            if ((j11 & 3) == 0) {
                long j12 = j10 >>> 2;
                int i10 = 0;
                Index<K, V> index2 = null;
                Index index3 = node;
                while (true) {
                    index2 = new Index<>(node3, index2, index3);
                    Index index4 = indexArr[i10];
                    if (index4 == null) {
                        Index<K, V> index5 = new Index<>(index.node, index, index2);
                        indexArr[i10] = index5;
                        index = index5;
                    } else {
                        index4.right = index2;
                        indexArr[i10] = index2;
                    }
                    int i11 = i10 + 1;
                    if (i11 < indexArr.length) {
                        long j13 = j12 >>> 1;
                        j12 = j13;
                        if ((j13 & 1) == 0) {
                            break;
                        }
                        i10 = i11;
                        index3 = 0;
                    }
                }
            }
            node = null;
        }
        if (j10 != 0) {
            VarHandle.releaseFence();
            addCount(j10);
            this.head = index;
            VarHandle.fullFence();
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Node<K, V> baseHead = baseHead();
        Node<K, V> b4 = baseHead;
        if (baseHead != null) {
            while (true) {
                Node<K, V> n10 = b4.next;
                if (n10 == null) {
                    break;
                }
                V v2 = n10.val;
                if (v2 != null) {
                    s2.writeObject(n10.key);
                    s2.writeObject(v2);
                }
                b4 = n10;
            }
        }
        s2.writeObject(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Index[] indexArr = new Index[64];
        Node node = null;
        Node<K, V> node2 = new Node<>(null, null, null);
        Index<K, V> index = new Index<>(node2, null, null);
        indexArr[0] = index;
        Comparator<? super K> comparator = this.comparator;
        Object obj = null;
        long j10 = 0;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                if (j10 != 0) {
                    VarHandle.releaseFence();
                    addCount(j10);
                    this.head = index;
                    VarHandle.fullFence();
                    return;
                }
                return;
            }
            Object readObject2 = objectInputStream.readObject();
            if (readObject2 == null) {
                throw new NullPointerException();
            }
            if (obj != null && cpr(comparator, obj, readObject) > 0) {
                throw new IllegalStateException("out of order");
            }
            obj = readObject;
            Node<K, V> node3 = new Node<>(readObject, readObject2, node);
            node2.next = node3;
            node2 = node3;
            long j11 = j10 + 1;
            j10 = j11;
            if ((j11 & 3) == 0) {
                long j12 = j10 >>> 2;
                int i10 = 0;
                Index<K, V> index2 = null;
                Index index3 = node;
                while (true) {
                    index2 = new Index<>(node3, index2, index3);
                    Index index4 = indexArr[i10];
                    if (index4 == null) {
                        Index<K, V> index5 = new Index<>(index.node, index, index2);
                        indexArr[i10] = index5;
                        index = index5;
                    } else {
                        index4.right = index2;
                        indexArr[i10] = index2;
                    }
                    int i11 = i10 + 1;
                    if (i11 < indexArr.length) {
                        long j13 = j12 >>> 1;
                        j12 = j13;
                        if ((j13 & 1) == 0) {
                            break;
                        }
                        i10 = i11;
                        index3 = 0;
                    }
                }
            }
            node = null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return doGet(key) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        return doGet(key);
    }

    @Override // java.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        V v2 = doGet(key);
        return v2 == null ? defaultValue : v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return doPut(key, value, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        return doRemove(key, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<K, V> baseHead = baseHead();
        Node<K, V> b4 = baseHead;
        if (baseHead == null) {
            return false;
        }
        while (true) {
            Node<K, V> n10 = b4.next;
            if (n10 != null) {
                V v2 = n10.val;
                if (v2 != null && value.equals(v2)) {
                    return true;
                }
                b4 = n10;
            } else {
                return false;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        if (baseHead() == null) {
            return 0;
        }
        long c4 = getAdderCount();
        if (c4 >= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) c4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return findFirst() == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        VarHandle.acquireFence();
        while (true) {
            Index<K, V> h10 = this.head;
            if (h10 != null) {
                Index<K, V> r10 = h10.right;
                if (r10 != null) {
                    (boolean) RIGHT.compareAndSet(h10, r10, null);
                } else {
                    Index<K, V> d10 = h10.down;
                    if (d10 != null) {
                        (boolean) HEAD.compareAndSet(this, h10, d10);
                    } else {
                        long count = 0;
                        Node<K, V> b4 = h10.node;
                        if (b4 != null) {
                            while (true) {
                                Node<K, V> n10 = b4.next;
                                if (n10 == null) {
                                    break;
                                }
                                V v2 = n10.val;
                                V v10 = v2;
                                if (v2 != null && (boolean) VAL.compareAndSet(n10, v10, null)) {
                                    count--;
                                    v10 = null;
                                }
                                if (v10 == null) {
                                    unlinkNode(b4, n10);
                                }
                            }
                        }
                        if (count != 0) {
                            addCount(count);
                        } else {
                            return;
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.Map
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V r10;
        if (key == null || mappingFunction == null) {
            throw new NullPointerException();
        }
        V v2 = doGet(key);
        if (v2 != null || (r10 = mappingFunction.apply(key)) == null) {
            return v2;
        }
        V p10 = doPut(key, r10, true);
        return p10 == null ? r10 : p10;
    }

    @Override // java.util.Map
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (key == null || remappingFunction == null) {
            throw new NullPointerException();
        }
        while (true) {
            Node<K, V> n10 = findNode(key);
            if (n10 != null) {
                Object obj = n10.val;
                if (obj != null) {
                    V r10 = remappingFunction.apply(key, obj);
                    if (r10 != null) {
                        if ((boolean) VAL.compareAndSet(n10, obj, r10)) {
                            return r10;
                        }
                    } else if (doRemove(key, obj) != null) {
                        return null;
                    }
                }
            } else {
                return null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        return null;
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V compute(K r6, java.util.function.BiFunction<? super K, ? super V, ? extends V> r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L3b
            if (r7 == 0) goto L3b
        L4:
            java.util.concurrent.ConcurrentSkipListMap$Node r0 = r5.findNode(r6)
            r1 = r0
            r2 = 0
            if (r0 != 0) goto L1c
            java.lang.Object r0 = r7.apply(r6, r2)
            r3 = r0
            if (r0 != 0) goto L14
            goto L39
        L14:
            r0 = 1
            java.lang.Object r0 = r5.doPut(r6, r3, r0)
            if (r0 != 0) goto L3a
            return r3
        L1c:
            V r0 = r1.val
            r3 = r0
            if (r0 == 0) goto L3a
            java.lang.Object r0 = r7.apply(r6, r3)
            r4 = r0
            if (r0 == 0) goto L32
            java.lang.invoke.VarHandle r0 = java.util.concurrent.ConcurrentSkipListMap.VAL
            boolean r0 = (boolean) r0.compareAndSet(r1, r3, r4)
            if (r0 == 0) goto L3a
            return r4
        L32:
            java.lang.Object r0 = r5.doRemove(r6, r3)
            if (r0 == 0) goto L3a
        L39:
            return r2
        L3a:
            goto L4
        L3b:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        if (key == null || value == null || remappingFunction == null) {
            throw new NullPointerException();
        }
        while (true) {
            Node<K, V> n10 = findNode(key);
            if (n10 == null) {
                if (doPut(key, value, true) == null) {
                    return value;
                }
            } else {
                Object obj = n10.val;
                if (obj == null) {
                    continue;
                } else {
                    V r10 = remappingFunction.apply(obj, value);
                    if (r10 != null) {
                        if ((boolean) VAL.compareAndSet(n10, obj, r10)) {
                            return r10;
                        }
                    } else if (doRemove(key, obj) != null) {
                        return null;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public NavigableSet<K> h() {
        KeySet<K, V> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySet<K, V> keySet = new KeySet<>(this);
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        KeySet<K, V> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySet<K, V> keySet = new KeySet<>(this);
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Values<K, V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        Values<K, V> values = new Values<>(this);
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet<K, V> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet<K, V> entrySet = new EntrySet<>(this);
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> descendingMap() {
        ConcurrentNavigableMap<K, V> dm = this.descendingMap;
        if (dm != null) {
            return dm;
        }
        SubMap<K, V> subMap = new SubMap<>(this, null, false, null, false, true);
        this.descendingMap = subMap;
        return subMap;
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
    
        return false;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 1
            if (r14 != r13) goto L4
            return r0
        L4:
            boolean r1 = r14 instanceof java.util.Map
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = r14
            java.util.Map r1 = (java.util.Map) r1
            java.util.Comparator<? super K> r3 = r13.comparator     // Catch: java.lang.Throwable -> Lbd
            java.util.Set r4 = r1.entrySet()     // Catch: java.lang.Throwable -> Lbd
            java.util.Iterator r4 = r4.iterator2()     // Catch: java.lang.Throwable -> Lbd
            boolean r5 = r1 instanceof java.util.SortedMap     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L6e
            r5 = r1
            java.util.SortedMap r5 = (java.util.SortedMap) r5     // Catch: java.lang.Throwable -> Lbd
            java.util.Comparator r5 = r5.comparator()     // Catch: java.lang.Throwable -> Lbd
            if (r5 != r3) goto L6e
            java.util.concurrent.ConcurrentSkipListMap$Node r5 = r13.baseHead()     // Catch: java.lang.Throwable -> Lbd
            r6 = r5
            if (r5 == 0) goto L68
        L2b:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r5 = r6.next     // Catch: java.lang.Throwable -> Lbd
            r7 = r5
            if (r5 == 0) goto L68
            V r5 = r7.val     // Catch: java.lang.Throwable -> Lbd
            r8 = r5
            if (r5 == 0) goto L66
            K r5 = r7.key     // Catch: java.lang.Throwable -> Lbd
            r9 = r5
            if (r5 == 0) goto L66
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lbd
            if (r5 != 0) goto L41
            return r2
        L41:
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lbd
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r10 = r5.getKey()     // Catch: java.lang.Throwable -> Lbd
            java.lang.Object r11 = r5.getValue()     // Catch: java.lang.Throwable -> Lbd
            if (r10 == 0) goto L65
            if (r11 != 0) goto L54
            goto L65
        L54:
            int r12 = cpr(r3, r9, r10)     // Catch: java.lang.ClassCastException -> L63 java.lang.Throwable -> Lbd
            if (r12 == 0) goto L5b
            return r2
        L5b:
            boolean r12 = r11.equals(r8)     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            if (r12 != 0) goto L66
            return r2
        L63:
            r0 = move-exception
            return r2
        L65:
            return r2
        L66:
            r6 = r7
            goto L2b
        L68:
            boolean r2 = r4.hasNext()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r0 = r0 ^ r2
            return r0
        L6e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            if (r5 == 0) goto L96
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            java.lang.Object r7 = r5.getValue()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            if (r6 == 0) goto L95
            if (r7 == 0) goto L95
            java.lang.Object r8 = r13.get(r6)     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r9 = r8
            if (r8 == 0) goto L95
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            if (r8 != 0) goto L94
            goto L95
        L94:
            goto L6e
        L95:
            return r2
        L96:
            java.util.concurrent.ConcurrentSkipListMap$Node r5 = r13.baseHead()     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r6 = r5
            if (r5 == 0) goto Lbc
        L9d:
            java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r5 = r6.next     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r7 = r5
            if (r5 == 0) goto Lbc
            V r5 = r7.val     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r8 = r5
            if (r5 == 0) goto Lba
            K r5 = r7.key     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r9 = r5
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r1.get(r9)     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            r10 = r5
            if (r5 == 0) goto Lb9
            boolean r5 = r10.equals(r8)     // Catch: java.lang.Throwable -> Lbd java.lang.Throwable -> Lbd
            if (r5 != 0) goto Lba
        Lb9:
            return r2
        Lba:
            r6 = r7
            goto L9d
        Lbc:
            return r0
        Lbd:
            r0 = move-exception
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.equals(java.lang.Object):boolean");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        return doPut(key, value, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object key, Object value) {
        if (key != null) {
            return (value == null || doRemove(key, value) == null) ? false : true;
        }
        throw new NullPointerException();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new NullPointerException();
        }
        while (true) {
            Node<K, V> n10 = findNode(key);
            if (n10 == null) {
                return false;
            }
            V v2 = n10.val;
            if (v2 != null) {
                if (!oldValue.equals(v2)) {
                    return false;
                }
                if ((boolean) VAL.compareAndSet(n10, v2, newValue)) {
                    return true;
                }
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        while (true) {
            Node<K, V> n10 = findNode(key);
            if (n10 == null) {
                return null;
            }
            V v2 = n10.val;
            if (v2 != null && (boolean) VAL.compareAndSet(n10, v2, value)) {
                return v2;
            }
        }
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return this.comparator;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Node<K, V> n10 = findFirst();
        if (n10 == null) {
            throw new NoSuchElementException();
        }
        return n10.key;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Node<K, V> n10 = findLast();
        if (n10 == null) {
            throw new NoSuchElementException();
        }
        return n10.key;
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        if (fromKey == null || toKey == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, fromKey, fromInclusive, toKey, toInclusive, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        if (toKey == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, null, false, toKey, inclusive, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        if (fromKey == null) {
            throw new NullPointerException();
        }
        return new SubMap(this, fromKey, inclusive, null, false, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> subMap(K fromKey, K toKey) {
        return subMap((boolean) fromKey, true, (boolean) toKey, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> headMap(K toKey) {
        return headMap((ConcurrentSkipListMap<K, V>) toKey, false);
    }

    @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
    public ConcurrentNavigableMap<K, V> tailMap(K fromKey) {
        return tailMap((ConcurrentSkipListMap<K, V>) fromKey, true);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K key) {
        return findNearEntry(key, 2, this.comparator);
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K key) {
        Node<K, V> n10 = findNear(key, 2, this.comparator);
        if (n10 == null) {
            return null;
        }
        return n10.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K key) {
        return findNearEntry(key, 3, this.comparator);
    }

    @Override // java.util.NavigableMap
    public K floorKey(K key) {
        Node<K, V> n10 = findNear(key, 3, this.comparator);
        if (n10 == null) {
            return null;
        }
        return n10.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K key) {
        return findNearEntry(key, 1, this.comparator);
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K key) {
        Node<K, V> n10 = findNear(key, 1, this.comparator);
        if (n10 == null) {
            return null;
        }
        return n10.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K key) {
        return findNearEntry(key, 0, this.comparator);
    }

    @Override // java.util.NavigableMap
    public K higherKey(K key) {
        Node<K, V> n10 = findNear(key, 0, this.comparator);
        if (n10 == null) {
            return null;
        }
        return n10.key;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return findFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return findLastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return doRemoveFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return doRemoveLastEntry();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class Iter<T> implements Iterator<T> {
        Node<K, V> lastReturned;
        Node<K, V> next;
        V nextValue;

        Iter() {
            advance(ConcurrentSkipListMap.this.baseHead());
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        final void advance(Node<K, V> b4) {
            Node<K, V> n10 = null;
            V v2 = null;
            this.lastReturned = b4;
            if (b4 != null) {
                while (true) {
                    Node<K, V> node = b4.next;
                    n10 = node;
                    if (node == null) {
                        break;
                    }
                    V v10 = n10.val;
                    v2 = v10;
                    if (v10 != null) {
                        break;
                    } else {
                        b4 = n10;
                    }
                }
            }
            this.nextValue = v2;
            this.next = n10;
        }

        @Override // java.util.Iterator
        public final void remove() {
            K k10;
            Node<K, V> n10 = this.lastReturned;
            if (n10 == null || (k10 = n10.key) == null) {
                throw new IllegalStateException();
            }
            ConcurrentSkipListMap.this.remove(k10);
            this.lastReturned = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class ValueIterator extends ConcurrentSkipListMap<K, V>.Iter<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            V v2 = this.nextValue;
            if (v2 == null) {
                throw new NoSuchElementException();
            }
            advance(this.next);
            return v2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class KeyIterator extends ConcurrentSkipListMap<K, V>.Iter<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            Node<K, V> n10 = this.next;
            if (n10 == null) {
                throw new NoSuchElementException();
            }
            K k10 = n10.key;
            advance(n10);
            return k10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class EntryIterator extends ConcurrentSkipListMap<K, V>.Iter<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            Node<K, V> n10 = this.next;
            if (n10 == null) {
                throw new NoSuchElementException();
            }
            K k10 = n10.key;
            V v2 = this.nextValue;
            advance(n10);
            return new AbstractMap.SimpleImmutableEntry(k10, v2);
        }
    }

    static final <E> List<E> toList(Collection<E> c4) {
        ArrayList<E> list = new ArrayList<>();
        for (E e2 : c4) {
            list.add(e2);
        }
        return list;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeySet<K, V> extends AbstractSet<K> implements NavigableSet<K> {

        /* renamed from: m */
        final ConcurrentNavigableMap<K, V> f50494m;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet((KeySet<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet((KeySet<K, V>) obj);
        }

        KeySet(ConcurrentNavigableMap<K, V> map) {
            this.f50494m = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50494m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50494m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50494m.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50494m.remove(o10) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50494m.clear();
        }

        @Override // java.util.NavigableSet
        public K lower(K e2) {
            return this.f50494m.lowerKey(e2);
        }

        @Override // java.util.NavigableSet
        public K floor(K e2) {
            return this.f50494m.floorKey(e2);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K e2) {
            return this.f50494m.ceilingKey(e2);
        }

        @Override // java.util.NavigableSet
        public K higher(K e2) {
            return this.f50494m.higherKey(e2);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return this.f50494m.comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return this.f50494m.firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return this.f50494m.lastKey();
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            Map.Entry<K, V> e2 = this.f50494m.pollFirstEntry();
            if (e2 == null) {
                return null;
            }
            return e2.getKey();
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            Map.Entry<K, V> e2 = this.f50494m.pollLastEntry();
            if (e2 == null) {
                return null;
            }
            return e2.getKey();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50494m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap) concurrentNavigableMap;
                Objects.requireNonNull(concurrentSkipListMap);
                return new KeyIterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapKeyIterator();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof Set)) {
                return false;
            }
            Collection<?> c4 = (Collection) o10;
            try {
                if (containsAll(c4)) {
                    if (c4.containsAll(this)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException e2) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator2();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive) {
            return new KeySet(this.f50494m.subMap((boolean) fromElement, fromInclusive, (boolean) toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K toElement, boolean inclusive) {
            return new KeySet(this.f50494m.headMap((ConcurrentNavigableMap<K, V>) toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K fromElement, boolean inclusive) {
            return new KeySet(this.f50494m.tailMap((ConcurrentNavigableMap<K, V>) fromElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K fromElement, K toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K toElement) {
            return headSet(toElement, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K fromElement) {
            return tailSet(fromElement, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new KeySet(this.f50494m.descendingMap());
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50494m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                return ((ConcurrentSkipListMap) concurrentNavigableMap).keySpliterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapKeyIterator();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Values<K, V> extends AbstractCollection<V> {

        /* renamed from: m */
        final ConcurrentNavigableMap<K, V> f50496m;

        Values(ConcurrentNavigableMap<K, V> map) {
            this.f50496m = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50496m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap) concurrentNavigableMap;
                Objects.requireNonNull(concurrentSkipListMap);
                return new ValueIterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50496m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50496m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50496m.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50496m.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50496m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                return ((ConcurrentSkipListMap) concurrentNavigableMap).valueSpliterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapValueIterator();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super V> predicate) {
            if (predicate == null) {
                throw new NullPointerException();
            }
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50496m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                return ((ConcurrentSkipListMap) concurrentNavigableMap).removeValueIf(predicate);
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            SubMap.SubMapEntryIterator subMapEntryIterator = new SubMap.SubMapEntryIterator();
            boolean z10 = false;
            while (subMapEntryIterator.hasNext()) {
                Map.Entry<K, V> next = subMapEntryIterator.next();
                V value = next.getValue();
                if (predicate.test(value) && this.f50496m.remove(next.getKey(), value)) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: m */
        final ConcurrentNavigableMap<K, V> f50493m;

        EntrySet(ConcurrentNavigableMap<K, V> map) {
            this.f50493m = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50493m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                ConcurrentSkipListMap concurrentSkipListMap = (ConcurrentSkipListMap) concurrentNavigableMap;
                Objects.requireNonNull(concurrentSkipListMap);
                return new EntryIterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            V v2 = this.f50493m.get(e2.getKey());
            return v2 != null && v2.equals(e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            return this.f50493m.remove(e2.getKey(), e2.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50493m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50493m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50493m.clear();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof Set)) {
                return false;
            }
            Collection<?> c4 = (Collection) o10;
            try {
                if (containsAll(c4)) {
                    if (c4.containsAll(this)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException e2) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentSkipListMap.toList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ConcurrentSkipListMap.toList(this).toArray(tArr);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50493m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                return ((ConcurrentSkipListMap) concurrentNavigableMap).entrySpliterator();
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            return new SubMap.SubMapEntryIterator();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Map.Entry<K, V>> filter) {
            if (filter == null) {
                throw new NullPointerException();
            }
            ConcurrentNavigableMap<K, V> concurrentNavigableMap = this.f50493m;
            if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
                return ((ConcurrentSkipListMap) concurrentNavigableMap).removeEntryIf(filter);
            }
            SubMap subMap = (SubMap) concurrentNavigableMap;
            Objects.requireNonNull(subMap);
            Iterator<Map.Entry<K, V>> it = new SubMap.SubMapEntryIterator();
            boolean removed = false;
            while (it.hasNext()) {
                Map.Entry<K, V> e2 = it.next();
                if (filter.test(e2) && this.f50493m.remove(e2.getKey(), e2.getValue())) {
                    removed = true;
                }
            }
            return removed;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SubMap<K, V> extends AbstractMap<K, V> implements ConcurrentNavigableMap<K, V>, Serializable {
        private static final long serialVersionUID = -7647078645895051609L;
        private transient EntrySet<K, V> entrySetView;
        private final K hi;
        private final boolean hiInclusive;
        final boolean isDescending;
        private transient KeySet<K, V> keySetView;
        private final K lo;
        private final boolean loInclusive;

        /* renamed from: m */
        final ConcurrentSkipListMap<K, V> f50495m;
        private transient Values<K, V> valuesView;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object obj, boolean z10) {
            return headMap((SubMap<K, V>) obj, z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap headMap(Object obj) {
            return headMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap headMap(Object obj, boolean z10) {
            return headMap((SubMap<K, V>) obj, z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
            return subMap((boolean) obj, z10, (boolean) obj2, z11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
            return subMap((boolean) obj, z10, (boolean) obj2, z11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object obj, boolean z10) {
            return tailMap((SubMap<K, V>) obj, z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap tailMap(Object obj) {
            return tailMap((SubMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ ConcurrentNavigableMap tailMap(Object obj, boolean z10) {
            return tailMap((SubMap<K, V>) obj, z10);
        }

        SubMap(ConcurrentSkipListMap<K, V> map, K fromKey, boolean fromInclusive, K toKey, boolean toInclusive, boolean isDescending) {
            Comparator<? super K> cmp = map.comparator;
            if (fromKey != null && toKey != null && ConcurrentSkipListMap.cpr(cmp, fromKey, toKey) > 0) {
                throw new IllegalArgumentException("inconsistent range");
            }
            this.f50495m = map;
            this.lo = fromKey;
            this.hi = toKey;
            this.loInclusive = fromInclusive;
            this.hiInclusive = toInclusive;
            this.isDescending = isDescending;
        }

        boolean tooLow(Object key, Comparator<? super K> cmp) {
            int c4;
            K k10 = this.lo;
            return k10 != null && ((c4 = ConcurrentSkipListMap.cpr(cmp, key, k10)) < 0 || (c4 == 0 && !this.loInclusive));
        }

        boolean tooHigh(Object key, Comparator<? super K> cmp) {
            int c4;
            K k10 = this.hi;
            return k10 != null && ((c4 = ConcurrentSkipListMap.cpr(cmp, key, k10)) > 0 || (c4 == 0 && !this.hiInclusive));
        }

        boolean inBounds(Object key, Comparator<? super K> cmp) {
            return (tooLow(key, cmp) || tooHigh(key, cmp)) ? false : true;
        }

        void checkKeyBounds(K key, Comparator<? super K> cmp) {
            if (key == null) {
                throw new NullPointerException();
            }
            if (!inBounds(key, cmp)) {
                throw new IllegalArgumentException("key out of range");
            }
        }

        boolean isBeforeEnd(Node<K, V> n10, Comparator<? super K> cmp) {
            K k10;
            if (n10 == null) {
                return false;
            }
            if (this.hi == null || (k10 = n10.key) == null) {
                return true;
            }
            int c4 = ConcurrentSkipListMap.cpr(cmp, k10, this.hi);
            return c4 < 0 || (c4 == 0 && this.hiInclusive);
        }

        Node<K, V> loNode(Comparator<? super K> cmp) {
            K k10 = this.lo;
            if (k10 == null) {
                return this.f50495m.findFirst();
            }
            if (this.loInclusive) {
                return this.f50495m.findNear(k10, 1, cmp);
            }
            return this.f50495m.findNear(k10, 0, cmp);
        }

        Node<K, V> hiNode(Comparator<? super K> cmp) {
            K k10 = this.hi;
            if (k10 == null) {
                return this.f50495m.findLast();
            }
            if (this.hiInclusive) {
                return this.f50495m.findNear(k10, 3, cmp);
            }
            return this.f50495m.findNear(k10, 2, cmp);
        }

        K lowestKey() {
            Comparator<? super K> cmp = this.f50495m.comparator;
            Node<K, V> n10 = loNode(cmp);
            if (isBeforeEnd(n10, cmp)) {
                return n10.key;
            }
            throw new NoSuchElementException();
        }

        K highestKey() {
            Comparator<? super K> cmp = this.f50495m.comparator;
            Node<K, V> n10 = hiNode(cmp);
            if (n10 != null) {
                K last = n10.key;
                if (inBounds(last, cmp)) {
                    return last;
                }
            }
            throw new NoSuchElementException();
        }

        Map.Entry<K, V> lowestEntry() {
            Node<K, V> n10;
            V v2;
            Comparator<? super K> cmp = this.f50495m.comparator;
            do {
                n10 = loNode(cmp);
                if (n10 == null || !isBeforeEnd(n10, cmp)) {
                    return null;
                }
                v2 = n10.val;
            } while (v2 == null);
            return new AbstractMap.SimpleImmutableEntry(n10.key, v2);
        }

        Map.Entry<K, V> highestEntry() {
            Node<K, V> n10;
            V v2;
            Comparator<? super K> cmp = this.f50495m.comparator;
            do {
                n10 = hiNode(cmp);
                if (n10 == null || !inBounds(n10.key, cmp)) {
                    return null;
                }
                v2 = n10.val;
            } while (v2 == null);
            return new AbstractMap.SimpleImmutableEntry(n10.key, v2);
        }

        Map.Entry<K, V> removeLowest() {
            K k10;
            V v2;
            Comparator<? super K> cmp = this.f50495m.comparator;
            do {
                Node<K, V> n10 = loNode(cmp);
                if (n10 == null) {
                    return null;
                }
                k10 = n10.key;
                if (!inBounds(k10, cmp)) {
                    return null;
                }
                v2 = this.f50495m.doRemove(k10, null);
            } while (v2 == null);
            return new AbstractMap.SimpleImmutableEntry(k10, v2);
        }

        Map.Entry<K, V> removeHighest() {
            K k10;
            V v2;
            Comparator<? super K> cmp = this.f50495m.comparator;
            do {
                Node<K, V> n10 = hiNode(cmp);
                if (n10 == null) {
                    return null;
                }
                k10 = n10.key;
                if (!inBounds(k10, cmp)) {
                    return null;
                }
                v2 = this.f50495m.doRemove(k10, null);
            } while (v2 == null);
            return new AbstractMap.SimpleImmutableEntry(k10, v2);
        }

        Map.Entry<K, V> getNearEntry(K key, int rel) {
            Comparator<? super K> cmp = this.f50495m.comparator;
            if (this.isDescending) {
                if ((rel & 2) == 0) {
                    rel |= 2;
                } else {
                    rel &= -3;
                }
            }
            if (tooLow(key, cmp)) {
                if ((rel & 2) != 0) {
                    return null;
                }
                return lowestEntry();
            }
            if (tooHigh(key, cmp)) {
                if ((rel & 2) != 0) {
                    return highestEntry();
                }
                return null;
            }
            AbstractMap.SimpleImmutableEntry<K, V> e2 = this.f50495m.findNearEntry(key, rel, cmp);
            if (e2 == null || !inBounds(e2.getKey(), cmp)) {
                return null;
            }
            return e2;
        }

        K getNearKey(K key, int rel) {
            Node<K, V> n10;
            Node<K, V> n11;
            Comparator<? super K> cmp = this.f50495m.comparator;
            if (this.isDescending) {
                if ((rel & 2) == 0) {
                    rel |= 2;
                } else {
                    rel &= -3;
                }
            }
            if (tooLow(key, cmp)) {
                if ((rel & 2) == 0) {
                    Node<K, V> n12 = loNode(cmp);
                    if (isBeforeEnd(n12, cmp)) {
                        return n12.key;
                    }
                }
                return null;
            }
            if (tooHigh(key, cmp)) {
                if ((rel & 2) != 0 && (n11 = hiNode(cmp)) != null) {
                    K last = n11.key;
                    if (inBounds(last, cmp)) {
                        return last;
                    }
                }
                return null;
            }
            do {
                n10 = this.f50495m.findNear(key, rel, cmp);
                if (n10 == null || !inBounds(n10.key, cmp)) {
                    return null;
                }
            } while (n10.val == null);
            return n10.key;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            if (key != null) {
                return inBounds(key, this.f50495m.comparator) && this.f50495m.containsKey(key);
            }
            throw new NullPointerException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            if (key == null) {
                throw new NullPointerException();
            }
            if (inBounds(key, this.f50495m.comparator)) {
                return this.f50495m.get(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K key, V value) {
            checkKeyBounds(key, this.f50495m.comparator);
            return this.f50495m.put(key, value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            if (inBounds(key, this.f50495m.comparator)) {
                return this.f50495m.remove(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Comparator<? super K> cmp = this.f50495m.comparator;
            long count = 0;
            for (Node<K, V> n10 = loNode(cmp); isBeforeEnd(n10, cmp); n10 = n10.next) {
                if (n10.val != null) {
                    count++;
                }
            }
            if (count >= ZipUtils.UPPER_UNIXTIME_BOUND) {
                return Integer.MAX_VALUE;
            }
            return (int) count;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            Comparator<? super K> cmp = this.f50495m.comparator;
            return !isBeforeEnd(loNode(cmp), cmp);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Comparator<? super K> cmp = this.f50495m.comparator;
            for (Node<K, V> n10 = loNode(cmp); isBeforeEnd(n10, cmp); n10 = n10.next) {
                V v2 = n10.val;
                if (v2 != null && value.equals(v2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Comparator<? super K> cmp = this.f50495m.comparator;
            for (Node<K, V> n10 = loNode(cmp); isBeforeEnd(n10, cmp); n10 = n10.next) {
                if (n10.val != null) {
                    this.f50495m.remove(n10.key);
                }
            }
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            checkKeyBounds(key, this.f50495m.comparator);
            return this.f50495m.putIfAbsent(key, value);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            return inBounds(key, this.f50495m.comparator) && this.f50495m.remove(key, value);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            checkKeyBounds(key, this.f50495m.comparator);
            return this.f50495m.replace(key, oldValue, newValue);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            checkKeyBounds(key, this.f50495m.comparator);
            return this.f50495m.replace(key, value);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> cmp = this.f50495m.comparator();
            if (this.isDescending) {
                return Collections.reverseOrder(cmp);
            }
            return cmp;
        }

        SubMap<K, V> newSubMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            Comparator<? super K> cmp = this.f50495m.comparator;
            if (this.isDescending) {
                fromKey = toKey;
                toKey = fromKey;
                fromInclusive = toInclusive;
                toInclusive = fromInclusive;
            }
            K tk = this.lo;
            if (tk != null) {
                if (fromKey == null) {
                    fromKey = this.lo;
                    fromInclusive = this.loInclusive;
                } else {
                    int c4 = ConcurrentSkipListMap.cpr(cmp, fromKey, tk);
                    if (c4 < 0 || (c4 == 0 && !this.loInclusive && fromInclusive)) {
                        throw new IllegalArgumentException("key out of range");
                    }
                }
            }
            K k10 = this.hi;
            if (k10 != null) {
                if (toKey == null) {
                    toKey = this.hi;
                    toInclusive = this.hiInclusive;
                } else {
                    int c10 = ConcurrentSkipListMap.cpr(cmp, toKey, k10);
                    if (c10 > 0 || (c10 == 0 && !this.hiInclusive && toInclusive)) {
                        throw new IllegalArgumentException("key out of range");
                    }
                }
            }
            return new SubMap<>(this.f50495m, fromKey, fromInclusive, toKey, toInclusive, this.isDescending);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            if (fromKey == null || toKey == null) {
                throw new NullPointerException();
            }
            return newSubMap(fromKey, fromInclusive, toKey, toInclusive);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> headMap(K toKey, boolean inclusive) {
            if (toKey == null) {
                throw new NullPointerException();
            }
            return newSubMap(null, false, toKey, inclusive);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> tailMap(K fromKey, boolean inclusive) {
            if (fromKey == null) {
                throw new NullPointerException();
            }
            return newSubMap(fromKey, inclusive, null, false);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> subMap(K fromKey, K toKey) {
            return subMap((boolean) fromKey, true, (boolean) toKey, false);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> headMap(K toKey) {
            return headMap((SubMap<K, V>) toKey, false);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> tailMap(K fromKey) {
            return tailMap((SubMap<K, V>) fromKey, true);
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public SubMap<K, V> descendingMap() {
            return new SubMap<>(this.f50495m, this.lo, this.loInclusive, this.hi, this.hiInclusive, !this.isDescending);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            return getNearEntry(key, 1);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return getNearKey(key, 1);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            return getNearEntry(key, 2);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return getNearKey(key, 2);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            return getNearEntry(key, 3);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return getNearKey(key, 3);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            return getNearEntry(key, 0);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return getNearKey(key, 0);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.isDescending ? highestKey() : lowestKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.isDescending ? lowestKey() : highestKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return this.isDescending ? highestEntry() : lowestEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return this.isDescending ? lowestEntry() : highestEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return this.isDescending ? removeHighest() : removeLowest();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return this.isDescending ? removeLowest() : removeHighest();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public NavigableSet<K> h() {
            KeySet<K, V> ks = this.keySetView;
            if (ks != null) {
                return ks;
            }
            KeySet<K, V> keySet = new KeySet<>(this);
            this.keySetView = keySet;
            return keySet;
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            KeySet<K, V> ks = this.keySetView;
            if (ks != null) {
                return ks;
            }
            KeySet<K, V> keySet = new KeySet<>(this);
            this.keySetView = keySet;
            return keySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Values<K, V> vs = this.valuesView;
            if (vs != null) {
                return vs;
            }
            Values<K, V> values = new Values<>(this);
            this.valuesView = values;
            return values;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            EntrySet<K, V> es = this.entrySetView;
            if (es != null) {
                return es;
            }
            EntrySet<K, V> entrySet = new EntrySet<>(this);
            this.entrySetView = entrySet;
            return entrySet;
        }

        @Override // java.util.concurrent.ConcurrentNavigableMap, java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public abstract class SubMapIter<T> implements Iterator<T>, Spliterator<T> {
            Node<K, V> lastReturned;
            Node<K, V> next;
            V nextValue;

            SubMapIter() {
                V x10;
                VarHandle.acquireFence();
                Comparator<? super K> cmp = SubMap.this.f50495m.comparator;
                do {
                    Node<K, V> hiNode = SubMap.this.isDescending ? SubMap.this.hiNode(cmp) : SubMap.this.loNode(cmp);
                    this.next = hiNode;
                    if (hiNode != null) {
                        x10 = hiNode.val;
                    } else {
                        return;
                    }
                } while (x10 == null);
                if (!SubMap.this.inBounds(this.next.key, cmp)) {
                    this.next = null;
                } else {
                    this.nextValue = x10;
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.next != null;
            }

            final void advance() {
                Node<K, V> node = this.next;
                if (node == null) {
                    throw new NoSuchElementException();
                }
                this.lastReturned = node;
                if (SubMap.this.isDescending) {
                    descend();
                } else {
                    ascend();
                }
            }

            private void ascend() {
                V x10;
                Comparator<? super K> cmp = SubMap.this.f50495m.comparator;
                do {
                    Node<K, V> node = this.next.next;
                    this.next = node;
                    if (node != null) {
                        x10 = node.val;
                    } else {
                        return;
                    }
                } while (x10 == null);
                if (SubMap.this.tooHigh(this.next.key, cmp)) {
                    this.next = null;
                } else {
                    this.nextValue = x10;
                }
            }

            private void descend() {
                V x10;
                Comparator<? super K> cmp = SubMap.this.f50495m.comparator;
                do {
                    Node<K, V> findNear = SubMap.this.f50495m.findNear(this.lastReturned.key, 2, cmp);
                    this.next = findNear;
                    if (findNear != null) {
                        x10 = findNear.val;
                    } else {
                        return;
                    }
                } while (x10 == null);
                if (SubMap.this.tooLow(this.next.key, cmp)) {
                    this.next = null;
                } else {
                    this.nextValue = x10;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                Node<K, V> l10 = this.lastReturned;
                if (l10 == null) {
                    throw new IllegalStateException();
                }
                SubMap.this.f50495m.remove(l10.key);
                this.lastReturned = null;
            }

            @Override // java.util.Spliterator
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                if (hasNext()) {
                    consumer.accept(next());
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super T> consumer) {
                while (hasNext()) {
                    consumer.accept(next());
                }
            }

            @Override // java.util.Spliterator
            public long estimateSize() {
                return Long.MAX_VALUE;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class SubMapValueIterator extends SubMap<K, V>.SubMapIter<V> {
            SubMapValueIterator() {
                super();
            }

            @Override // java.util.Iterator
            public V next() {
                V v2 = this.nextValue;
                advance();
                return v2;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return 0;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class SubMapKeyIterator extends SubMap<K, V>.SubMapIter<K> {
            public SubMapKeyIterator() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                Node<K, V> n10 = this.next;
                advance();
                return n10.key;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return 21;
            }

            @Override // java.util.Spliterator
            public final Comparator<? super K> getComparator() {
                return SubMap.this.comparator();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        final class SubMapEntryIterator extends SubMap<K, V>.SubMapIter<Map.Entry<K, V>> {
            SubMapEntryIterator() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                Node<K, V> n10 = this.next;
                V v2 = this.nextValue;
                advance();
                return new AbstractMap.SimpleImmutableEntry(n10.key, v2);
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                return 1;
            }
        }
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        Node<K, V> baseHead = baseHead();
        Node<K, V> node = baseHead;
        if (baseHead == null) {
            return;
        }
        while (true) {
            Node<K, V> node2 = node.next;
            if (node2 != null) {
                V v2 = node2.val;
                if (v2 != null) {
                    biConsumer.accept(node2.key, v2);
                }
                node = node2;
            } else {
                return;
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Object obj;
        V apply;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        Node<K, V> baseHead = baseHead();
        Node<K, V> node = baseHead;
        if (baseHead == null) {
            return;
        }
        while (true) {
            Node<K, V> node2 = node.next;
            if (node2 == null) {
                return;
            }
            do {
                obj = node2.val;
                if (obj == null) {
                    break;
                }
                apply = biFunction.apply(node2.key, obj);
                if (apply == null) {
                    throw new NullPointerException();
                }
                node = node2;
            } while (!(boolean) VAL.compareAndSet(node2, obj, apply));
            node = node2;
        }
    }

    boolean removeEntryIf(Predicate<? super Map.Entry<K, V>> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        boolean removed = false;
        Node<K, V> baseHead = baseHead();
        Node<K, V> b4 = baseHead;
        if (baseHead != null) {
            while (true) {
                Node<K, V> n10 = b4.next;
                if (n10 == null) {
                    break;
                }
                V v2 = n10.val;
                if (v2 != null) {
                    K k10 = n10.key;
                    Map.Entry<K, V> e2 = new AbstractMap.SimpleImmutableEntry<>(k10, v2);
                    if (function.test(e2) && remove(k10, v2)) {
                        removed = true;
                    }
                }
                b4 = n10;
            }
        }
        return removed;
    }

    boolean removeValueIf(Predicate<? super V> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        boolean z10 = false;
        Node<K, V> baseHead = baseHead();
        Node<K, V> node = baseHead;
        if (baseHead != null) {
            while (true) {
                Node<K, V> node2 = node.next;
                if (node2 == null) {
                    break;
                }
                V v2 = node2.val;
                if (v2 != null && predicate.test(v2) && remove(node2.key, v2)) {
                    z10 = true;
                }
                node = node2;
            }
        }
        return z10;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class CSLMSpliterator<K, V> {
        final Comparator<? super K> comparator;
        Node<K, V> current;
        long est;
        final K fence;
        Index<K, V> row;

        CSLMSpliterator(Comparator<? super K> comparator, Index<K, V> row, Node<K, V> origin, K fence, long est) {
            this.comparator = comparator;
            this.row = row;
            this.current = origin;
            this.fence = fence;
            this.est = est;
        }

        public final long estimateSize() {
            return this.est;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeySpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<K> {
        KeySpliterator(Comparator<? super K> comparator, Index<K, V> row, Node<K, V> origin, K fence, long est) {
            super(comparator, row, origin, fence, est);
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            K ek;
            Node<K, V> b4;
            Node<K, V> n10;
            K sk;
            Comparator<? super K> cmp = this.comparator;
            K f10 = this.fence;
            Node<K, V> e2 = this.current;
            if (e2 != null && (ek = e2.key) != null) {
                Index<K, V> q10 = this.row;
                while (q10 != null) {
                    Index<K, V> s2 = q10.right;
                    if (s2 != null && (b4 = s2.node) != null && (n10 = b4.next) != null && n10.val != null && (sk = n10.key) != null && ConcurrentSkipListMap.cpr(cmp, sk, ek) > 0 && (f10 == null || ConcurrentSkipListMap.cpr(cmp, sk, f10) < 0)) {
                        this.current = n10;
                        Index<K, V> r10 = q10.down;
                        this.row = s2.right != null ? s2 : s2.down;
                        this.est -= this.est >>> 2;
                        return new KeySpliterator<>(cmp, r10, e2, sk, this.est);
                    }
                    Index<K, V> index = q10.down;
                    this.row = index;
                    q10 = index;
                }
                return null;
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Comparator<? super K> comparator = this.comparator;
            K k10 = this.fence;
            this.current = null;
            for (Node<K, V> node = this.current; node != null; node = node.next) {
                K k11 = node.key;
                if (k11 == null || k10 == null || ConcurrentSkipListMap.cpr(comparator, k10, k11) > 0) {
                    if (node.val != null) {
                        consumer.accept(k11);
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        
            r5.current = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        
            return false;
         */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super K> r6) {
            /*
                r5 = this;
                if (r6 == 0) goto L2d
                java.util.Comparator<? super K> r0 = r5.comparator
                K r1 = r5.fence
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r5.current
            L8:
                if (r2 == 0) goto L29
                K r3 = r2.key
                r4 = r3
                if (r3 == 0) goto L19
                if (r1 == 0) goto L19
                int r3 = java.util.concurrent.ConcurrentSkipListMap.cpr(r0, r1, r4)
                if (r3 > 0) goto L19
                r2 = 0
                goto L29
            L19:
                V r3 = r2.val
                if (r3 == 0) goto L26
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r3 = r2.next
                r5.current = r3
                r6.accept(r4)
                r3 = 1
                return r3
            L26:
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r2.next
                goto L8
            L29:
                r5.current = r2
                r3 = 0
                return r3
            L2d:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.KeySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4373;
        }

        @Override // java.util.Spliterator
        public final Comparator<? super K> getComparator() {
            return this.comparator;
        }
    }

    public final KeySpliterator<K, V> keySpliterator() {
        Node<K, V> n10;
        long est;
        VarHandle.acquireFence();
        Index<K, V> h10 = this.head;
        if (h10 == null) {
            n10 = null;
            est = 0;
        } else {
            n10 = h10.node;
            est = getAdderCount();
        }
        return new KeySpliterator<>(this.comparator, h10, n10, null, est);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ValueSpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<V> {
        ValueSpliterator(Comparator<? super K> comparator, Index<K, V> row, Node<K, V> origin, K fence, long est) {
            super(comparator, row, origin, fence, est);
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            K ek;
            Node<K, V> b4;
            Node<K, V> n10;
            K sk;
            Comparator<? super K> cmp = this.comparator;
            K f10 = this.fence;
            Node<K, V> e2 = this.current;
            if (e2 != null && (ek = e2.key) != null) {
                Index<K, V> q10 = this.row;
                while (q10 != null) {
                    Index<K, V> s2 = q10.right;
                    if (s2 != null && (b4 = s2.node) != null && (n10 = b4.next) != null && n10.val != null && (sk = n10.key) != null && ConcurrentSkipListMap.cpr(cmp, sk, ek) > 0 && (f10 == null || ConcurrentSkipListMap.cpr(cmp, sk, f10) < 0)) {
                        this.current = n10;
                        Index<K, V> r10 = q10.down;
                        this.row = s2.right != null ? s2 : s2.down;
                        this.est -= this.est >>> 2;
                        return new ValueSpliterator<>(cmp, r10, e2, sk, this.est);
                    }
                    Index<K, V> index = q10.down;
                    this.row = index;
                    q10 = index;
                }
                return null;
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Comparator<? super K> comparator = this.comparator;
            K k10 = this.fence;
            this.current = null;
            for (Node<K, V> node = this.current; node != null; node = node.next) {
                K k11 = node.key;
                if (k11 == null || k10 == null || ConcurrentSkipListMap.cpr(comparator, k10, k11) > 0) {
                    V v2 = node.val;
                    if (v2 != null) {
                        consumer.accept(v2);
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r6.current = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            return false;
         */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super V> r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L2e
                java.util.Comparator<? super K> r0 = r6.comparator
                K r1 = r6.fence
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r6.current
            L8:
                if (r2 == 0) goto L2a
                K r3 = r2.key
                r4 = r3
                if (r3 == 0) goto L19
                if (r1 == 0) goto L19
                int r3 = java.util.concurrent.ConcurrentSkipListMap.cpr(r0, r1, r4)
                if (r3 > 0) goto L19
                r2 = 0
                goto L2a
            L19:
                V r3 = r2.val
                r5 = r3
                if (r3 == 0) goto L27
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r3 = r2.next
                r6.current = r3
                r7.accept(r5)
                r3 = 1
                return r3
            L27:
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r2.next
                goto L8
            L2a:
                r6.current = r2
                r3 = 0
                return r3
            L2e:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.ValueSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    final ValueSpliterator<K, V> valueSpliterator() {
        Node<K, V> n10;
        long est;
        VarHandle.acquireFence();
        Index<K, V> h10 = this.head;
        if (h10 == null) {
            n10 = null;
            est = 0;
        } else {
            n10 = h10.node;
            est = getAdderCount();
        }
        return new ValueSpliterator<>(this.comparator, h10, n10, null, est);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class EntrySpliterator<K, V> extends CSLMSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {
        EntrySpliterator(Comparator<? super K> comparator, Index<K, V> row, Node<K, V> origin, K fence, long est) {
            super(comparator, row, origin, fence, est);
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            K ek;
            Node<K, V> b4;
            Node<K, V> n10;
            K sk;
            Comparator<? super K> cmp = this.comparator;
            K f10 = this.fence;
            Node<K, V> e2 = this.current;
            if (e2 != null && (ek = e2.key) != null) {
                Index<K, V> q10 = this.row;
                while (q10 != null) {
                    Index<K, V> s2 = q10.right;
                    if (s2 != null && (b4 = s2.node) != null && (n10 = b4.next) != null && n10.val != null && (sk = n10.key) != null && ConcurrentSkipListMap.cpr(cmp, sk, ek) > 0 && (f10 == null || ConcurrentSkipListMap.cpr(cmp, sk, f10) < 0)) {
                        this.current = n10;
                        Index<K, V> r10 = q10.down;
                        this.row = s2.right != null ? s2 : s2.down;
                        this.est -= this.est >>> 2;
                        return new EntrySpliterator<>(cmp, r10, e2, sk, this.est);
                    }
                    Index<K, V> index = q10.down;
                    this.row = index;
                    q10 = index;
                }
                return null;
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Comparator<? super K> cmp = this.comparator;
            K f10 = this.fence;
            this.current = null;
            for (Node<K, V> e2 = this.current; e2 != null; e2 = e2.next) {
                K k10 = e2.key;
                if (k10 == null || f10 == null || ConcurrentSkipListMap.cpr(cmp, f10, k10) > 0) {
                    V v2 = e2.val;
                    if (v2 != null) {
                        action.accept(new AbstractMap.SimpleImmutableEntry(k10, v2));
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        
            r6.current = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        
            return false;
         */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super java.util.Map.Entry<K, V>> r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L33
                java.util.Comparator<? super K> r0 = r6.comparator
                K r1 = r6.fence
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r6.current
            L8:
                if (r2 == 0) goto L2f
                K r3 = r2.key
                r4 = r3
                if (r3 == 0) goto L19
                if (r1 == 0) goto L19
                int r3 = java.util.concurrent.ConcurrentSkipListMap.cpr(r0, r1, r4)
                if (r3 > 0) goto L19
                r2 = 0
                goto L2f
            L19:
                V r3 = r2.val
                r5 = r3
                if (r3 == 0) goto L2c
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r3 = r2.next
                r6.current = r3
                java.util.AbstractMap$SimpleImmutableEntry r3 = new java.util.AbstractMap$SimpleImmutableEntry
                r3.<init>(r4, r5)
                r7.accept(r3)
                r3 = 1
                return r3
            L2c:
                java.util.concurrent.ConcurrentSkipListMap$Node<K, V> r2 = r2.next
                goto L8
            L2f:
                r6.current = r2
                r3 = 0
                return r3
            L33:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentSkipListMap.EntrySpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4373;
        }

        @Override // java.util.Spliterator
        public final Comparator<Map.Entry<K, V>> getComparator() {
            if (this.comparator != null) {
                return Map.Entry.comparingByKey(this.comparator);
            }
            return new ConcurrentSkipListMap$EntrySpliterator$$ExternalSyntheticLambda0();
        }

        public static /* synthetic */ int lambda$getComparator$d5a01062$1(Map.Entry e12, Map.Entry e2) {
            Comparable<? super K> k12 = (Comparable) e12.getKey();
            return k12.compareTo(e2.getKey());
        }
    }

    final EntrySpliterator<K, V> entrySpliterator() {
        Node<K, V> n10;
        long est;
        VarHandle.acquireFence();
        Index<K, V> h10 = this.head;
        if (h10 == null) {
            n10 = null;
            est = 0;
        } else {
            n10 = h10.node;
            est = getAdderCount();
        }
        return new EntrySpliterator<>(this.comparator, h10, n10, null, est);
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            HEAD = l10.findVarHandle(ConcurrentSkipListMap.class, "head", Index.class);
            ADDER = l10.findVarHandle(ConcurrentSkipListMap.class, "adder", LongAdder.class);
            NEXT = l10.findVarHandle(Node.class, "next", Node.class);
            VAL = l10.findVarHandle(Node.class, "val", Object.class);
            RIGHT = l10.findVarHandle(Index.class, "right", Index.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
