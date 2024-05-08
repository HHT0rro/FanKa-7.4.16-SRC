package java.util.concurrent;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.zip.ZipUtils;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final int ABASE;
    private static final int ASHIFT;
    private static final long BASECOUNT;
    private static final long CELLSBUSY;
    private static final long CELLVALUE;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int HASH_BITS = Integer.MAX_VALUE;
    private static final float LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_ARRAY_SIZE = 2147483639;
    private static final int MAX_RESIZERS = 65535;
    private static final int MIN_TRANSFER_STRIDE = 16;
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int MOVED = -1;
    static final int RESERVED = -3;
    private static final int RESIZE_STAMP_BITS = 16;
    private static final int RESIZE_STAMP_SHIFT = 16;
    private static final long SIZECTL;
    private static final long TRANSFERINDEX;
    static final int TREEBIN = -2;
    static final int TREEIFY_THRESHOLD = 8;
    private static final Unsafe U;
    static final int UNTREEIFY_THRESHOLD = 6;
    private static final long serialVersionUID = 7249069246763182397L;
    private volatile transient long baseCount;
    private volatile transient int cellsBusy;
    private volatile transient CounterCell[] counterCells;
    private transient EntrySetView<K, V> entrySet;
    private transient KeySetView<K, V> keySet;
    private volatile transient Node<K, V>[] nextTable;
    private volatile transient int sizeCtl;
    volatile transient Node<K, V>[] table;
    private volatile transient int transferIndex;
    private transient ValuesView<K, V> values;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField(DBDefinition.SEGMENT_TABLE_NAME, Segment[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public /* bridge */ /* synthetic */ Set<K> h() {
        return (KeySetView) h();
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        U = unsafe;
        SIZECTL = unsafe.objectFieldOffset(ConcurrentHashMap.class, "sizeCtl");
        TRANSFERINDEX = unsafe.objectFieldOffset(ConcurrentHashMap.class, "transferIndex");
        BASECOUNT = unsafe.objectFieldOffset(ConcurrentHashMap.class, "baseCount");
        CELLSBUSY = unsafe.objectFieldOffset(ConcurrentHashMap.class, "cellsBusy");
        CELLVALUE = unsafe.objectFieldOffset(CounterCell.class, "value");
        ABASE = unsafe.arrayBaseOffset(Node[].class);
        int scale = unsafe.arrayIndexScale(Node[].class);
        if (((scale - 1) & scale) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        ASHIFT = 31 - Integer.numberOfLeadingZeros(scale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        volatile Node<K, V> next;
        volatile V val;

        Node(int hash, K key, V val) {
            this.hash = hash;
            this.key = key;
            this.val = val;
        }

        Node(int hash, K key, V val, Node<K, V> next) {
            this(hash, key, val);
            this.next = next;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public final String toString() {
            return Helpers.mapEntryToString(this.key, this.val);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object o10) {
            Map.Entry<?, ?> e2;
            Object k10;
            Object v2;
            K k11;
            Object u10;
            return (o10 instanceof Map.Entry) && (k10 = (e2 = (Map.Entry) o10).getKey()) != null && (v2 = e2.getValue()) != null && (k10 == (k11 = this.key) || k10.equals(k11)) && (v2 == (u10 = this.val) || v2.equals(u10));
        }

        Node<K, V> find(int h10, Object k10) {
            Node<K, V> node;
            K ek;
            Node<K, V> e2 = this;
            if (k10 == null) {
                return null;
            }
            do {
                if (e2.hash == h10 && ((ek = e2.key) == k10 || (ek != null && k10.equals(ek)))) {
                    return e2;
                }
                node = e2.next;
                e2 = node;
            } while (node != null);
            return null;
        }
    }

    static final int spread(int h10) {
        return ((h10 >>> 16) ^ h10) & Integer.MAX_VALUE;
    }

    private static final int tableSizeFor(int c4) {
        int n10 = (-1) >>> Integer.numberOfLeadingZeros(c4 - 1);
        if (n10 < 0) {
            return 1;
        }
        if (n10 >= 1073741824) {
            return 1073741824;
        }
        return n10 + 1;
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

    static final <K, V> Node<K, V> tabAt(Node<K, V>[] tab, int i10) {
        return (Node) U.getReferenceAcquire(tab, (i10 << ASHIFT) + ABASE);
    }

    static final <K, V> boolean casTabAt(Node<K, V>[] tab, int i10, Node<K, V> c4, Node<K, V> v2) {
        return U.compareAndSetReference(tab, (i10 << ASHIFT) + ABASE, c4, v2);
    }

    static final <K, V> void setTabAt(Node<K, V>[] tab, int i10, Node<K, V> v2) {
        U.putReferenceRelease(tab, (i10 << ASHIFT) + ABASE, v2);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int initialCapacity) {
        this(initialCapacity, 0.75f, 1);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> m10) {
        this.sizeCtl = 16;
        putAll(m10);
    }

    public ConcurrentHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, 1);
    }

    public ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) {
        if (loadFactor <= 0.0f || initialCapacity < 0 || concurrencyLevel <= 0) {
            throw new IllegalArgumentException();
        }
        long size = (long) (((initialCapacity < concurrencyLevel ? concurrencyLevel : initialCapacity) / loadFactor) + 1.0d);
        int cap = size >= 1073741824 ? 1073741824 : tableSizeFor((int) size);
        this.sizeCtl = cap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long n10 = sumCount();
        if (n10 < 0) {
            return 0;
        }
        if (n10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return Integer.MAX_VALUE;
        }
        return (int) n10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return sumCount() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        int n10;
        K ek;
        int h10 = spread(key.hashCode());
        Node<K, V>[] tab = this.table;
        if (tab != null && (n10 = tab.length) > 0) {
            Node<K, V> tabAt = tabAt(tab, (n10 - 1) & h10);
            Node<K, V> e2 = tabAt;
            if (tabAt != null) {
                int eh = e2.hash;
                if (eh == h10) {
                    K ek2 = e2.key;
                    if (ek2 == key || (ek2 != null && key.equals(ek2))) {
                        return e2.val;
                    }
                } else if (eh < 0) {
                    Node<K, V> p10 = e2.find(h10, key);
                    if (p10 != null) {
                        return p10.val;
                    }
                    return null;
                }
                while (true) {
                    Node<K, V> node = e2.next;
                    e2 = node;
                    if (node == null) {
                        break;
                    }
                    if (e2.hash != h10 || ((ek = e2.key) != key && (ek == null || !key.equals(ek)))) {
                    }
                }
                return e2.val;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] t2 = this.table;
        if (t2 != null) {
            Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
            while (true) {
                Node<K, V> p10 = it.advance();
                if (p10 == null) {
                    break;
                }
                V v2 = p10.val;
                if (v2 == value) {
                    return true;
                }
                if (v2 != null && value.equals(v2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        return putVal(key, value, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ad, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00bb, code lost:
    
        addCount(1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00c0, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final V putVal(K r13, V r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.putVal(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        tryPresize(m10.size());
        for (Map.Entry<? extends K, ? extends V> e2 : m10.entrySet()) {
            putVal(e2.getKey(), e2.getValue(), false);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        return replaceNode(key, null, null);
    }

    final V replaceNode(Object key, V value, Object cv) {
        int i10;
        Node<K, V> f10;
        TreeNode<K, V> p10;
        Node<K, V> node;
        K ek;
        Object obj = key;
        int hash = spread(key.hashCode());
        Node<K, V>[] tab = this.table;
        while (tab != null) {
            int n10 = tab.length;
            if (n10 != 0 && (f10 = tabAt(tab, (i10 = (n10 - 1) & hash))) != null) {
                int fh = f10.hash;
                if (fh == -1) {
                    tab = helpTransfer(tab, f10);
                } else {
                    V oldVal = null;
                    boolean validated = false;
                    synchronized (f10) {
                        if (tabAt(tab, i10) == f10) {
                            if (fh >= 0) {
                                validated = true;
                                Node<K, V> e2 = f10;
                                Node<K, V> pred = null;
                                do {
                                    if (e2.hash != hash || ((ek = e2.key) != obj && (ek == null || !obj.equals(ek)))) {
                                        pred = e2;
                                        node = e2.next;
                                        e2 = node;
                                    }
                                    V ev = e2.val;
                                    if (cv == null || cv == ev || (ev != null && cv.equals(ev))) {
                                        oldVal = ev;
                                        if (value != null) {
                                            e2.val = value;
                                        } else if (pred != null) {
                                            pred.next = e2.next;
                                        } else {
                                            setTabAt(tab, i10, e2.next);
                                        }
                                    }
                                } while (node != null);
                            } else if (f10 instanceof TreeBin) {
                                validated = true;
                                TreeBin<K, V> t2 = (TreeBin) f10;
                                TreeNode<K, V> r10 = t2.root;
                                if (r10 != null && (p10 = r10.findTreeNode(hash, obj, null)) != null) {
                                    V pv = p10.val;
                                    if (cv == null || cv == pv || (pv != null && cv.equals(pv))) {
                                        oldVal = pv;
                                        if (value != null) {
                                            p10.val = value;
                                        } else if (t2.removeTreeNode(p10)) {
                                            setTabAt(tab, i10, untreeify(t2.first));
                                        }
                                    }
                                }
                            } else if (f10 instanceof ReservationNode) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                    }
                    if (validated) {
                        if (oldVal != null) {
                            if (value == null) {
                                addCount(-1L, -1);
                            }
                            return oldVal;
                        }
                        return null;
                    }
                }
                obj = key;
            } else {
                return null;
            }
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x004c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        /*
            r10 = this;
            r0 = 0
            r2 = 0
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r3 = r10.table
        L5:
            r4 = -1
            if (r3 == 0) goto L4f
            int r5 = r3.length
            if (r2 >= r5) goto L4f
            java.util.concurrent.ConcurrentHashMap$Node r5 = tabAt(r3, r2)
            if (r5 != 0) goto L14
            int r2 = r2 + 1
            goto L4b
        L14:
            int r6 = r5.hash
            r7 = r6
            if (r6 != r4) goto L1f
            java.util.concurrent.ConcurrentHashMap$Node[] r3 = r10.helpTransfer(r3, r5)
            r2 = 0
            goto L4b
        L1f:
            monitor-enter(r5)
            java.util.concurrent.ConcurrentHashMap$Node r4 = tabAt(r3, r2)     // Catch: java.lang.Throwable -> L4c
            if (r4 != r5) goto L4a
            r4 = 0
            if (r7 < 0) goto L2b
            r6 = r5
            goto L36
        L2b:
            boolean r6 = r5 instanceof java.util.concurrent.ConcurrentHashMap.TreeBin     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L35
            r6 = r5
            java.util.concurrent.ConcurrentHashMap$TreeBin r6 = (java.util.concurrent.ConcurrentHashMap.TreeBin) r6     // Catch: java.lang.Throwable -> L4c
            java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> r6 = r6.first     // Catch: java.lang.Throwable -> L4c
            goto L36
        L35:
            r6 = r4
        L36:
        L37:
            if (r6 == 0) goto L40
            r8 = 1
            long r0 = r0 - r8
            java.util.concurrent.ConcurrentHashMap$Node<K, V> r8 = r6.next     // Catch: java.lang.Throwable -> L4c
            r6 = r8
            goto L37
        L40:
            int r8 = r2 + 1
            setTabAt(r3, r2, r4)     // Catch: java.lang.Throwable -> L47
            r2 = r8
            goto L4a
        L47:
            r4 = move-exception
            r2 = r8
            goto L4d
        L4a:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
        L4b:
            goto L5
        L4c:
            r4 = move-exception
        L4d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
            throw r4
        L4f:
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 == 0) goto L58
            r10.addCount(r0, r4)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.clear():void");
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        KeySetView<K, V> ks = this.keySet;
        if (ks != null) {
            return ks;
        }
        KeySetView<K, V> keySetView = new KeySetView<>(this, null);
        this.keySet = keySetView;
        return keySetView;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        ValuesView<K, V> vs = this.values;
        if (vs != null) {
            return vs;
        }
        ValuesView<K, V> valuesView = new ValuesView<>(this);
        this.values = valuesView;
        return valuesView;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySetView<K, V> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySetView<K, V> entrySetView = new EntrySetView<>(this);
        this.entrySet = entrySetView;
        return entrySetView;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int h10 = 0;
        Node<K, V>[] t2 = this.table;
        if (t2 != null) {
            Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
            while (true) {
                Node<K, V> p10 = it.advance();
                if (p10 == null) {
                    break;
                }
                h10 += p10.key.hashCode() ^ p10.val.hashCode();
            }
        }
        return h10;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        Node<K, V>[] t2 = this.table;
        int f10 = t2 == null ? 0 : t2.length;
        Traverser<K, V> it = new Traverser<>(t2, f10, 0, f10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        Node<K, V> advance = it.advance();
        Node<K, V> p10 = advance;
        if (advance != null) {
            while (true) {
                K k10 = p10.key;
                V v2 = p10.val;
                sb2.append(k10 == this ? "(this Map)" : k10);
                sb2.append('=');
                sb2.append(v2 != this ? v2 : "(this Map)");
                Node<K, V> advance2 = it.advance();
                p10 = advance2;
                if (advance2 == null) {
                    break;
                }
                sb2.append(',').append(' ');
            }
        }
        return sb2.append('}').toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object o10) {
        Object mv;
        Object v2;
        if (o10 != this) {
            if (!(o10 instanceof Map)) {
                return false;
            }
            Map<?, ?> m10 = (Map) o10;
            Node<K, V>[] t2 = this.table;
            int f10 = t2 == null ? 0 : t2.length;
            Traverser<K, V> it = new Traverser<>(t2, f10, 0, f10);
            while (true) {
                Node<K, V> p10 = it.advance();
                if (p10 != null) {
                    V val = p10.val;
                    Object v10 = m10.get(p10.key);
                    if (v10 == null || (v10 != val && !v10.equals(val))) {
                        break;
                    }
                } else {
                    for (Map.Entry<K, V> entry : m10.entrySet()) {
                        Object mk = entry.getKey();
                        if (mk == null || (mv = entry.getValue()) == null || (v2 = get(mk)) == null || (mv != v2 && !mv.equals(v2))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class Segment<K, V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;

        Segment(float lf) {
            this.loadFactor = lf;
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        int sshift = 0;
        int ssize = 1;
        while (ssize < 16) {
            sshift++;
            ssize <<= 1;
        }
        int segmentShift = 32 - sshift;
        int segmentMask = ssize - 1;
        Segment<K, V>[] segments = new Segment[16];
        for (int i10 = 0; i10 < segments.length; i10++) {
            segments[i10] = new Segment<>(0.75f);
        }
        ObjectOutputStream.PutField streamFields = s2.putFields();
        streamFields.put(DBDefinition.SEGMENT_TABLE_NAME, segments);
        streamFields.put("segmentShift", segmentShift);
        streamFields.put("segmentMask", segmentMask);
        s2.writeFields();
        Node<K, V>[] t2 = this.table;
        if (t2 != null) {
            Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
            while (true) {
                Node<K, V> p10 = it.advance();
                if (p10 == null) {
                    break;
                }
                s2.writeObject(p10.key);
                s2.writeObject(p10.val);
            }
        }
        s2.writeObject(null);
        s2.writeObject(null);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        Node<K, V> first;
        long size;
        long ts;
        int mask;
        boolean insertAtFront;
        K qk;
        long j10;
        this.sizeCtl = -1;
        s2.defaultReadObject();
        long size2 = 0;
        Node<K, V> p10 = null;
        while (true) {
            Object readObject = s2.readObject();
            Object readObject2 = s2.readObject();
            if (readObject == null || readObject2 == null) {
                break;
            }
            p10 = new Node<>(spread(readObject.hashCode()), readObject, readObject2, p10);
            size2++;
        }
        if (size2 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long ts2 = (long) ((((float) size2) / 0.75f) + 1.0d);
        int n10 = ts2 >= 1073741824 ? 1073741824 : tableSizeFor((int) ts2);
        Node<K, V>[] tab = new Node[n10];
        int mask2 = n10 - 1;
        long added = 0;
        while (p10 != null) {
            Node<K, V> next = p10.next;
            int h10 = p10.hash;
            int j11 = h10 & mask2;
            Node<K, V> first2 = tabAt(tab, j11);
            if (first2 == null) {
                ts = ts2;
                mask = mask2;
                insertAtFront = true;
                first = first2;
                size = size2;
            } else {
                K k10 = p10.key;
                first = first2;
                size = size2;
                if (first.hash < 0) {
                    if (((TreeBin) first).putTreeVal(h10, k10, p10.val) == null) {
                        added++;
                    }
                    insertAtFront = false;
                    ts = ts2;
                    mask = mask2;
                } else {
                    int binCount = 0;
                    boolean insertAtFront2 = true;
                    Node<K, V> q10 = first;
                    while (q10 != null) {
                        ts = ts2;
                        if (q10.hash == h10 && ((qk = q10.key) == k10 || (qk != null && k10.equals(qk)))) {
                            insertAtFront2 = false;
                            break;
                        } else {
                            binCount++;
                            q10 = q10.next;
                            ts2 = ts;
                        }
                    }
                    ts = ts2;
                    if (insertAtFront2 && binCount >= 8) {
                        boolean insertAtFront3 = false;
                        added++;
                        p10.next = first;
                        TreeNode<K, V> hd2 = null;
                        Node<K, V> q11 = p10;
                        TreeNode<K, V> tl = null;
                        while (q11 != null) {
                            boolean insertAtFront4 = insertAtFront3;
                            K k11 = k10;
                            int mask3 = mask2;
                            TreeNode<K, V> t2 = new TreeNode<>(q11.hash, q11.key, q11.val, null, null);
                            t2.prev = tl;
                            if (tl == null) {
                                hd2 = t2;
                            } else {
                                tl.next = t2;
                            }
                            tl = t2;
                            q11 = q11.next;
                            insertAtFront3 = insertAtFront4;
                            k10 = k11;
                            mask2 = mask3;
                        }
                        insertAtFront = insertAtFront3;
                        mask = mask2;
                        setTabAt(tab, j11, new TreeBin(hd2));
                    } else {
                        mask = mask2;
                        insertAtFront = insertAtFront2;
                    }
                }
            }
            if (!insertAtFront) {
                j10 = 1;
            } else {
                j10 = 1;
                added++;
                p10.next = first;
                setTabAt(tab, j11, p10);
            }
            p10 = next;
            size2 = size;
            ts2 = ts;
            mask2 = mask;
        }
        this.table = tab;
        this.sizeCtl = n10 - (n10 >>> 2);
        this.baseCount = added;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K key, V value) {
        return putVal(key, value, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object key, Object value) {
        if (key != null) {
            return (value == null || replaceNode(key, null, value) == null) ? false : true;
        }
        throw new NullPointerException();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K key, V oldValue, V newValue) {
        if (key == null || oldValue == null || newValue == null) {
            throw new NullPointerException();
        }
        return replaceNode(key, newValue, oldValue) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        return replaceNode(key, value, null);
    }

    @Override // java.util.Map
    public V getOrDefault(Object key, V defaultValue) {
        V v2 = get(key);
        return v2 == null ? defaultValue : v2;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        if (biConsumer == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance != null) {
                    biConsumer.accept(advance.key, advance.val);
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        V v2;
        if (biFunction == null) {
            throw new NullPointerException();
        }
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance != null) {
                    V v10 = advance.val;
                    K k10 = advance.key;
                    do {
                        V apply = biFunction.apply(k10, v10);
                        if (apply == null) {
                            throw new NullPointerException();
                        }
                        if (replaceNode(k10, apply, v10) == null) {
                            v2 = get(k10);
                            v10 = (Object) v2;
                        }
                    } while (v2 != null);
                } else {
                    return;
                }
            }
        }
    }

    boolean removeEntryIf(Predicate<? super Map.Entry<K, V>> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        boolean removed = false;
        Node<K, V>[] t2 = this.table;
        if (t2 != null) {
            Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
            while (true) {
                Node<K, V> p10 = it.advance();
                if (p10 == null) {
                    break;
                }
                K k10 = p10.key;
                V v2 = p10.val;
                Map.Entry<K, V> e2 = new AbstractMap.SimpleImmutableEntry<>(k10, v2);
                if (function.test(e2) && replaceNode(k10, null, v2) != null) {
                    removed = true;
                }
            }
        }
        return removed;
    }

    boolean removeValueIf(Predicate<? super V> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        boolean z10 = false;
        Node<K, V>[] nodeArr = this.table;
        if (nodeArr != null) {
            Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
            while (true) {
                Node<K, V> advance = traverser.advance();
                if (advance == null) {
                    break;
                }
                K k10 = advance.key;
                V v2 = advance.val;
                if (predicate.test(v2) && replaceNode(k10, null, v2) != null) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00f9, code lost:
    
        if (r1 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00fb, code lost:
    
        addCount(1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0100, code lost:
    
        return r1;
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V computeIfAbsent(K r14, java.util.function.Function<? super K, ? extends V> r15) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b0, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V computeIfPresent(K r14, java.util.function.BiFunction<? super K, ? super V, ? extends V> r15) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x00b3, code lost:
    
        r5 = r20.apply(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00b8, code lost:
    
        if (r5 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00bc, code lost:
    
        if (r0.next != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00be, code lost:
    
        r6 = 1;
        r0.next = new java.util.concurrent.ConcurrentHashMap.Node<>(r4, r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00ce, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V compute(K r19, java.util.function.BiFunction<? super K, ? super V, ? extends V> r20) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0117, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:? -> B:53:0x0137). Please report as a decompilation issue!!! */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V merge(K r19, V r20, java.util.function.BiFunction<? super V, ? super V, ? extends V> r21) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public boolean contains(Object value) {
        return containsValue(value);
    }

    public Enumeration<K> keys() {
        Node<K, V>[] t2 = this.table;
        int f10 = t2 == null ? 0 : t2.length;
        return new KeyIterator(t2, f10, 0, f10, this);
    }

    public Enumeration<V> elements() {
        Node<K, V>[] t2 = this.table;
        int f10 = t2 == null ? 0 : t2.length;
        return new ValueIterator(t2, f10, 0, f10, this);
    }

    public long mappingCount() {
        long n10 = sumCount();
        if (n10 < 0) {
            return 0L;
        }
        return n10;
    }

    public static <K> KeySetView<K, Boolean> newKeySet() {
        return new KeySetView<>(new ConcurrentHashMap(), Boolean.TRUE);
    }

    public static <K> KeySetView<K, Boolean> newKeySet(int initialCapacity) {
        return new KeySetView<>(new ConcurrentHashMap(initialCapacity), Boolean.TRUE);
    }

    public KeySetView<K, V> keySet(V mappedValue) {
        if (mappedValue == null) {
            throw new NullPointerException();
        }
        return new KeySetView<>(this, mappedValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ForwardingNode<K, V> extends Node<K, V> {
        final Node<K, V>[] nextTable;

        ForwardingNode(Node<K, V>[] tab) {
            super(-1, null, null);
            this.nextTable = tab;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int h10, Object k10) {
            int n10;
            Node<K, V> node;
            K ek;
            Node<K, V>[] tab = this.nextTable;
            while (k10 != null && tab != null && (n10 = tab.length) != 0) {
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(tab, (n10 - 1) & h10);
                Node<K, V> e2 = tabAt;
                if (tabAt == null) {
                    break;
                }
                do {
                    int eh = e2.hash;
                    if (eh == h10 && ((ek = e2.key) == k10 || (ek != null && k10.equals(ek)))) {
                        return e2;
                    }
                    if (eh < 0) {
                        if (e2 instanceof ForwardingNode) {
                            tab = ((ForwardingNode) e2).nextTable;
                        } else {
                            return e2.find(h10, k10);
                        }
                    } else {
                        node = e2.next;
                        e2 = node;
                    }
                } while (node != null);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ReservationNode<K, V> extends Node<K, V> {
        ReservationNode() {
            super(-3, null, null);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int h10, Object k10) {
            return null;
        }
    }

    static final int resizeStamp(int n10) {
        return Integer.numberOfLeadingZeros(n10) | 32768;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x003a, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.concurrent.ConcurrentHashMap.Node<K, V>[] initTable() {
        /*
            r9 = this;
        L1:
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r0 = r9.table
            r1 = r0
            if (r0 == 0) goto L9
            int r0 = r1.length
            if (r0 != 0) goto L3a
        L9:
            int r0 = r9.sizeCtl
            r8 = r0
            if (r0 >= 0) goto L12
            java.lang.Thread.yield()
            goto L1
        L12:
            jdk.internal.misc.Unsafe r2 = java.util.concurrent.ConcurrentHashMap.U
            long r4 = java.util.concurrent.ConcurrentHashMap.SIZECTL
            r7 = -1
            r3 = r9
            r6 = r8
            boolean r0 = r2.compareAndSetInt(r3, r4, r6, r7)
            if (r0 == 0) goto L1
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r0 = r9.table     // Catch: java.lang.Throwable -> L3b
            r1 = r0
            if (r0 == 0) goto L27
            int r0 = r1.length     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L36
        L27:
            if (r8 <= 0) goto L2b
            r0 = r8
            goto L2d
        L2b:
            r0 = 16
        L2d:
            java.util.concurrent.ConcurrentHashMap$Node[] r2 = new java.util.concurrent.ConcurrentHashMap.Node[r0]     // Catch: java.lang.Throwable -> L3b
            r1 = r2
            r9.table = r2     // Catch: java.lang.Throwable -> L3b
            int r3 = r0 >>> 2
            int r8 = r0 - r3
        L36:
            r9.sizeCtl = r8
        L3a:
            return r1
        L3b:
            r0 = move-exception
            r9.sizeCtl = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.initTable():java.util.concurrent.ConcurrentHashMap$Node[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r0.compareAndSetLong(r23, r2, r4, r6) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addCount(long r24, int r26) {
        /*
            r23 = this;
            r8 = r23
            r9 = r24
            r11 = r26
            java.util.concurrent.ConcurrentHashMap$CounterCell[] r0 = r8.counterCells
            r12 = r0
            if (r0 != 0) goto L1d
            jdk.internal.misc.Unsafe r0 = java.util.concurrent.ConcurrentHashMap.U
            long r2 = java.util.concurrent.ConcurrentHashMap.BASECOUNT
            long r4 = r8.baseCount
            r13 = r4
            long r6 = r13 + r9
            r15 = r6
            r1 = r23
            boolean r0 = r0.compareAndSetLong(r1, r2, r4, r6)
            if (r0 != 0) goto L4d
        L1d:
            r0 = 1
            if (r12 == 0) goto Lb1
            int r1 = r12.length
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
            if (r1 < 0) goto Lb1
            int r1 = java.util.concurrent.ThreadLocalRandom.getProbe()
            r1 = r1 & r3
            r1 = r12[r1]
            r4 = r1
            if (r1 == 0) goto Lb1
            jdk.internal.misc.Unsafe r13 = java.util.concurrent.ConcurrentHashMap.U
            long r15 = java.util.concurrent.ConcurrentHashMap.CELLVALUE
            long r5 = r4.value
            r21 = r5
            long r19 = r21 + r9
            r14 = r4
            r17 = r5
            boolean r1 = r13.compareAndSetLong(r14, r15, r17, r19)
            r0 = r1
            if (r1 != 0) goto L46
            goto Lb1
        L46:
            if (r11 > r2) goto L49
            return
        L49:
            long r15 = r23.sumCount()
        L4d:
            if (r11 < 0) goto Lb0
        L4f:
            int r0 = r8.sizeCtl
            r6 = r0
            long r0 = (long) r0
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 < 0) goto Lb0
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r0 = r8.table
            r7 = r0
            if (r0 == 0) goto Lb0
            int r0 = r7.length
            r13 = r0
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r1) goto Lb0
            int r0 = resizeStamp(r13)
            int r14 = r0 << 16
            if (r6 >= 0) goto L96
            r0 = 65535(0xffff, float:9.1834E-41)
            int r0 = r0 + r14
            if (r6 == r0) goto Lb0
            int r0 = r14 + 1
            if (r6 == r0) goto Lb0
            java.util.concurrent.ConcurrentHashMap$Node<K, V>[] r0 = r8.nextTable
            r5 = r0
            if (r0 == 0) goto L94
            int r0 = r8.transferIndex
            if (r0 > 0) goto L7e
            goto Lb0
        L7e:
            jdk.internal.misc.Unsafe r0 = java.util.concurrent.ConcurrentHashMap.U
            long r2 = java.util.concurrent.ConcurrentHashMap.SIZECTL
            int r17 = r6 + 1
            r1 = r23
            r4 = r6
            r11 = r5
            r5 = r17
            boolean r0 = r0.compareAndSetInt(r1, r2, r4, r5)
            if (r0 == 0) goto La9
            r8.transfer(r7, r11)
            goto La9
        L94:
            r11 = r5
            goto Lb0
        L96:
            jdk.internal.misc.Unsafe r0 = java.util.concurrent.ConcurrentHashMap.U
            long r2 = java.util.concurrent.ConcurrentHashMap.SIZECTL
            int r5 = r14 + 2
            r1 = r23
            r4 = r6
            boolean r0 = r0.compareAndSetInt(r1, r2, r4, r5)
            if (r0 == 0) goto La9
            r0 = 0
            r8.transfer(r7, r0)
        La9:
            long r15 = r23.sumCount()
            r11 = r26
            goto L4f
        Lb0:
            return
        Lb1:
            r8.fullAddCount(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.addCount(long, int):void");
    }

    final Node<K, V>[] helpTransfer(Node<K, V>[] tab, Node<K, V> f10) {
        Node<K, V>[] nextTab;
        int sc2;
        if (tab != null && (f10 instanceof ForwardingNode) && (nextTab = ((ForwardingNode) f10).nextTable) != null) {
            int rs = resizeStamp(tab.length) << 16;
            while (true) {
                if (nextTab != this.nextTable || this.table != tab || (sc2 = this.sizeCtl) >= 0 || sc2 == 65535 + rs || sc2 == rs + 1 || this.transferIndex <= 0) {
                    break;
                }
                if (U.compareAndSetInt(this, SIZECTL, sc2, sc2 + 1)) {
                    transfer(tab, nextTab);
                    break;
                }
            }
            return nextTab;
        }
        return this.table;
    }

    private final void tryPresize(int size) {
        int n10;
        int c4 = size >= 536870912 ? 1073741824 : tableSizeFor((size >>> 1) + size + 1);
        while (true) {
            int i10 = this.sizeCtl;
            int sc2 = i10;
            if (i10 >= 0) {
                Node<K, V>[] tab = this.table;
                if (tab == null || (n10 = tab.length) == 0) {
                    int n11 = sc2 > c4 ? sc2 : c4;
                    if (U.compareAndSetInt(this, SIZECTL, sc2, -1)) {
                        try {
                            if (this.table == tab) {
                                Node<K, V>[] nt = new Node[n11];
                                this.table = nt;
                                sc2 = n11 - (n11 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = sc2;
                        }
                    } else {
                        continue;
                    }
                } else if (c4 > sc2 && n10 < 1073741824) {
                    if (tab == this.table) {
                        int rs = resizeStamp(n10);
                        if (U.compareAndSetInt(this, SIZECTL, sc2, (rs << 16) + 2)) {
                            transfer(tab, null);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final void transfer(Node<K, V>[] tab, Node<K, V>[] nextTab) {
        Node<K, V>[] nextTab2;
        int stride;
        int nextn;
        char c4;
        int fh;
        int stride2;
        int nextn2;
        Node<K, V> hn;
        Node<K, V> ln;
        Node<K, V> lastRun;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int n10 = tab.length;
        int i10 = NCPU;
        int i11 = 1;
        int i12 = i10 > 1 ? (n10 >>> 3) / i10 : n10;
        int stride3 = i12;
        char c10 = 16;
        int stride4 = i12 < 16 ? 16 : stride3;
        if (nextTab == null) {
            try {
                Node<K, V>[] nextTab3 = new Node[n10 << 1];
                concurrentHashMap.nextTable = nextTab3;
                concurrentHashMap.transferIndex = n10;
                nextTab2 = nextTab3;
            } catch (Throwable th) {
                concurrentHashMap.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            nextTab2 = nextTab;
        }
        int nextn3 = nextTab2.length;
        ForwardingNode<K, V> fwd = new ForwardingNode<>(nextTab2);
        boolean advance = true;
        boolean finishing = false;
        int i13 = 0;
        int bound = 0;
        while (true) {
            if (advance) {
                int i14 = i13 - 1;
                if (i14 >= bound || finishing) {
                    i13 = i14;
                    advance = false;
                    bound = bound;
                } else {
                    int nextIndex = concurrentHashMap.transferIndex;
                    if (nextIndex <= 0) {
                        i13 = -1;
                        advance = false;
                    } else {
                        Unsafe unsafe = U;
                        long j10 = TRANSFERINDEX;
                        int nextBound = nextIndex > stride4 ? nextIndex - stride4 : 0;
                        int bound2 = bound;
                        if (unsafe.compareAndSetInt(this, j10, nextIndex, nextBound)) {
                            i13 = nextIndex - 1;
                            advance = false;
                            bound = nextBound;
                        } else {
                            i13 = i14;
                            bound = bound2;
                        }
                    }
                }
            } else {
                int bound3 = bound;
                if (i13 < 0 || i13 >= n10) {
                    stride = stride4;
                    nextn = nextn3;
                } else if (i13 + n10 >= nextn3) {
                    stride = stride4;
                    nextn = nextn3;
                } else {
                    Node<K, V> f10 = tabAt(tab, i13);
                    if (f10 == null) {
                        advance = casTabAt(tab, i13, null, fwd);
                        fh = i11;
                        c4 = c10;
                        stride = stride4;
                        nextn = nextn3;
                    } else {
                        int i15 = f10.hash;
                        int fh2 = i15;
                        if (i15 == -1) {
                            advance = true;
                            fh = i11;
                            c4 = c10;
                            stride = stride4;
                            nextn = nextn3;
                        } else {
                            synchronized (f10) {
                                try {
                                    if (tabAt(tab, i13) != f10) {
                                        stride = stride4;
                                        nextn = nextn3;
                                    } else if (fh2 >= 0) {
                                        int runBit = fh2 & n10;
                                        Node<K, V> lastRun2 = f10;
                                        try {
                                            for (Node<K, V> p10 = f10.next; p10 != null; p10 = p10.next) {
                                                try {
                                                    int b4 = p10.hash & n10;
                                                    if (b4 != runBit) {
                                                        runBit = b4;
                                                        lastRun2 = p10;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    throw th;
                                                }
                                            }
                                            if (runBit == 0) {
                                                ln = lastRun2;
                                                hn = null;
                                            } else {
                                                hn = lastRun2;
                                                ln = null;
                                            }
                                            Node<K, V> p11 = f10;
                                            while (p11 != lastRun2) {
                                                int ph = p11.hash;
                                                int runBit2 = runBit;
                                                K pk = p11.key;
                                                int fh3 = fh2;
                                                try {
                                                    V pv = p11.val;
                                                    if ((ph & n10) == 0) {
                                                        lastRun = lastRun2;
                                                        ln = new Node<>(ph, pk, pv, ln);
                                                    } else {
                                                        lastRun = lastRun2;
                                                        hn = new Node<>(ph, pk, pv, hn);
                                                    }
                                                    p11 = p11.next;
                                                    fh2 = fh3;
                                                    runBit = runBit2;
                                                    lastRun2 = lastRun;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    throw th;
                                                }
                                            }
                                            setTabAt(nextTab2, i13, ln);
                                            setTabAt(nextTab2, i13 + n10, hn);
                                            setTabAt(tab, i13, fwd);
                                            advance = true;
                                            stride = stride4;
                                            nextn = nextn3;
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    } else {
                                        try {
                                            if (f10 instanceof TreeBin) {
                                                TreeBin<K, V> t2 = (TreeBin) f10;
                                                Node<K, V> e2 = t2.first;
                                                int hc2 = 0;
                                                int lc2 = 0;
                                                TreeNode<K, V> hiTail = null;
                                                TreeNode<K, V> hiTail2 = null;
                                                TreeNode<K, V> loTail = null;
                                                TreeNode<K, V> lo = null;
                                                while (e2 != null) {
                                                    int stride5 = stride4;
                                                    try {
                                                        stride2 = e2.hash;
                                                        nextn2 = nextn3;
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                    }
                                                    try {
                                                        TreeNode<K, V> p12 = new TreeNode<>(stride2, e2.key, e2.val, null, null);
                                                        if ((stride2 & n10) == 0) {
                                                            p12.prev = loTail;
                                                            if (loTail == null) {
                                                                lo = p12;
                                                            } else {
                                                                loTail.next = p12;
                                                            }
                                                            loTail = p12;
                                                            lc2++;
                                                        } else {
                                                            p12.prev = hiTail;
                                                            if (hiTail == null) {
                                                                hiTail2 = p12;
                                                            } else {
                                                                hiTail.next = p12;
                                                            }
                                                            hiTail = p12;
                                                            hc2++;
                                                        }
                                                        e2 = e2.next;
                                                        stride4 = stride5;
                                                        nextn3 = nextn2;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        throw th;
                                                    }
                                                }
                                                stride = stride4;
                                                nextn = nextn3;
                                                Node<K, V> ln2 = lc2 <= 6 ? untreeify(lo) : hc2 != 0 ? new TreeBin<>(lo) : t2;
                                                Node<K, V> hn2 = hc2 <= 6 ? untreeify(hiTail2) : lc2 != 0 ? new TreeBin<>(hiTail2) : t2;
                                                setTabAt(nextTab2, i13, ln2);
                                                setTabAt(nextTab2, i13 + n10, hn2);
                                                setTabAt(tab, i13, fwd);
                                                advance = true;
                                            } else {
                                                stride = stride4;
                                                nextn = nextn3;
                                                if (f10 instanceof ReservationNode) {
                                                    throw new IllegalStateException("Recursive update");
                                                }
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                        }
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                }
                            }
                            concurrentHashMap = this;
                            fh = 1;
                            c4 = 16;
                        }
                    }
                    i11 = fh;
                    c10 = c4;
                    bound = bound3;
                    stride4 = stride;
                    nextn3 = nextn;
                }
                if (finishing) {
                    this.nextTable = null;
                    this.table = nextTab2;
                    this.sizeCtl = (n10 << 1) - (n10 >>> 1);
                    return;
                }
                concurrentHashMap = this;
                Unsafe unsafe2 = U;
                long j11 = SIZECTL;
                int sc2 = concurrentHashMap.sizeCtl;
                int i16 = i13;
                if (unsafe2.compareAndSetInt(this, j11, sc2, sc2 - 1)) {
                    c4 = 16;
                    if (sc2 - 2 != (resizeStamp(n10) << 16)) {
                        return;
                    }
                    fh = 1;
                    advance = true;
                    finishing = true;
                    i13 = n10;
                } else {
                    fh = 1;
                    c4 = 16;
                    i13 = i16;
                }
                i11 = fh;
                c10 = c4;
                bound = bound3;
                stride4 = stride;
                nextn3 = nextn;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CounterCell {
        volatile long value;

        CounterCell(long x10) {
            this.value = x10;
        }
    }

    final long sumCount() {
        CounterCell[] cs = this.counterCells;
        long sum = this.baseCount;
        if (cs != null) {
            for (CounterCell c4 : cs) {
                if (c4 != null) {
                    sum += c4.value;
                }
            }
        }
        return sum;
    }

    private final void fullAddCount(long x10, boolean wasUncontended) {
        boolean wasUncontended2;
        int n10;
        CounterCell c4;
        int m10;
        int probe = ThreadLocalRandom.getProbe();
        int h10 = probe;
        if (probe != 0) {
            wasUncontended2 = wasUncontended;
        } else {
            ThreadLocalRandom.localInit();
            h10 = ThreadLocalRandom.getProbe();
            wasUncontended2 = true;
        }
        boolean wasUncontended3 = wasUncontended2;
        int h11 = h10;
        boolean collide = false;
        while (true) {
            CounterCell[] cs = this.counterCells;
            if (cs != null && (n10 = cs.length) > 0) {
                CounterCell c10 = cs[(n10 - 1) & h11];
                if (c10 == null) {
                    if (this.cellsBusy != 0) {
                        c4 = c10;
                    } else {
                        CounterCell r10 = new CounterCell(x10);
                        if (this.cellsBusy != 0) {
                            c4 = c10;
                        } else {
                            c4 = c10;
                            if (U.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                                boolean created = false;
                                try {
                                    CounterCell[] rs = this.counterCells;
                                    if (rs != null && (m10 = rs.length) > 0) {
                                        int j10 = (m10 - 1) & h11;
                                        if (rs[j10] == null) {
                                            rs[j10] = r10;
                                            created = true;
                                        }
                                    }
                                    if (created) {
                                        return;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                    collide = false;
                    h11 = ThreadLocalRandom.advanceProbe(h11);
                } else {
                    if (!wasUncontended3) {
                        wasUncontended3 = true;
                    } else {
                        Unsafe unsafe = U;
                        long j11 = CELLVALUE;
                        long v2 = c10.value;
                        if (!unsafe.compareAndSetLong(c10, j11, v2, v2 + x10)) {
                            if (this.counterCells == cs && n10 < NCPU) {
                                if (!collide) {
                                    collide = true;
                                } else if (this.cellsBusy == 0 && unsafe.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                                    try {
                                        if (this.counterCells == cs) {
                                            this.counterCells = (CounterCell[]) Arrays.copyOf(cs, n10 << 1);
                                        }
                                        this.cellsBusy = 0;
                                        collide = false;
                                    } finally {
                                    }
                                }
                            }
                            collide = false;
                        } else {
                            return;
                        }
                    }
                    h11 = ThreadLocalRandom.advanceProbe(h11);
                }
            } else {
                int h12 = this.cellsBusy;
                if (h12 == 0 && this.counterCells == cs && U.compareAndSetInt(this, CELLSBUSY, 0, 1)) {
                    boolean init = false;
                    try {
                        if (this.counterCells == cs) {
                            CounterCell[] rs2 = new CounterCell[2];
                            rs2[h11 & 1] = new CounterCell(x10);
                            this.counterCells = rs2;
                            init = true;
                        }
                        if (init) {
                            return;
                        }
                    } finally {
                    }
                } else {
                    Unsafe unsafe2 = U;
                    long j12 = BASECOUNT;
                    long v10 = this.baseCount;
                    if (unsafe2.compareAndSetLong(this, j12, v10, v10 + x10)) {
                        return;
                    }
                }
            }
        }
    }

    private final void treeifyBin(Node<K, V>[] tab, int index) {
        if (tab != null) {
            int n10 = tab.length;
            if (n10 < 64) {
                tryPresize(n10 << 1);
                return;
            }
            Node<K, V> b4 = tabAt(tab, index);
            if (b4 != null && b4.hash >= 0) {
                synchronized (b4) {
                    if (tabAt(tab, index) == b4) {
                        TreeNode<K, V> hd2 = null;
                        TreeNode<K, V> tl = null;
                        for (Node<K, V> e2 = b4; e2 != null; e2 = e2.next) {
                            TreeNode<K, V> p10 = new TreeNode<>(e2.hash, e2.key, e2.val, null, null);
                            p10.prev = tl;
                            if (tl == null) {
                                hd2 = p10;
                            } else {
                                tl.next = p10;
                            }
                            tl = p10;
                        }
                        setTabAt(tab, index, new TreeBin(hd2));
                    }
                }
            }
        }
    }

    static <K, V> Node<K, V> untreeify(Node<K, V> b4) {
        Node<K, V> hd2 = null;
        Node<K, V> tl = null;
        for (Node<K, V> q10 = b4; q10 != null; q10 = q10.next) {
            Node<K, V> p10 = new Node<>(q10.hash, q10.key, q10.val);
            if (tl == null) {
                hd2 = p10;
            } else {
                tl.next = p10;
            }
            tl = p10;
        }
        return hd2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TreeNode<K, V> extends Node<K, V> {
        TreeNode<K, V> left;
        TreeNode<K, V> parent;
        TreeNode<K, V> prev;
        boolean red;
        TreeNode<K, V> right;

        TreeNode(int hash, K key, V val, Node<K, V> next, TreeNode<K, V> parent) {
            super(hash, key, val, next);
            this.parent = parent;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        Node<K, V> find(int h10, Object k10) {
            return findTreeNode(h10, k10, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x002f, code lost:
        
            if (r3 != null) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> findTreeNode(int r8, java.lang.Object r9, java.lang.Class<?> r10) {
            /*
                r7 = this;
                if (r9 == 0) goto L4c
                r0 = r7
            L3:
                java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> r1 = r0.left
                java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> r2 = r0.right
                int r3 = r0.hash
                r4 = r3
                if (r3 <= r8) goto Le
                r0 = r1
                goto L48
            Le:
                if (r4 >= r8) goto L12
                r0 = r2
                goto L48
            L12:
                K r3 = r0.key
                r5 = r3
                if (r3 == r9) goto L4b
                if (r5 == 0) goto L20
                boolean r3 = r9.equals(r5)
                if (r3 == 0) goto L20
                goto L4b
            L20:
                if (r1 != 0) goto L24
                r0 = r2
                goto L48
            L24:
                if (r2 != 0) goto L28
                r0 = r1
                goto L48
            L28:
                if (r10 != 0) goto L31
                java.lang.Class r3 = java.util.concurrent.ConcurrentHashMap.comparableClassFor(r9)
                r10 = r3
                if (r3 == 0) goto L3f
            L31:
                int r3 = java.util.concurrent.ConcurrentHashMap.compareComparables(r10, r9, r5)
                r6 = r3
                if (r3 == 0) goto L3f
                if (r6 >= 0) goto L3c
                r3 = r1
                goto L3d
            L3c:
                r3 = r2
            L3d:
                r0 = r3
                goto L48
            L3f:
                java.util.concurrent.ConcurrentHashMap$TreeNode r3 = r2.findTreeNode(r8, r9, r10)
                r6 = r3
                if (r3 == 0) goto L47
                return r6
            L47:
                r0 = r1
            L48:
                if (r0 != 0) goto L3
                goto L4c
            L4b:
                return r0
            L4c:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeNode.findTreeNode(int, java.lang.Object, java.lang.Class):java.util.concurrent.ConcurrentHashMap$TreeNode");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TreeBin<K, V> extends Node<K, V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long LOCKSTATE = ConcurrentHashMap.U.objectFieldOffset(TreeBin.class, "lockState");
        static final int READER = 4;
        static final int WAITER = 2;
        static final int WRITER = 1;
        volatile TreeNode<K, V> first;
        volatile int lockState;
        TreeNode<K, V> root;
        volatile Thread waiter;

        static int tieBreakOrder(Object a10, Object b4) {
            int d10;
            if (a10 != null && b4 != null && (d10 = a10.getClass().getName().compareTo(b4.getClass().getName())) != 0) {
                return d10;
            }
            int d11 = System.identityHashCode(a10) <= System.identityHashCode(b4) ? -1 : 1;
            return d11;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0036, code lost:
        
            if (r9 != null) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        TreeBin(java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> r14) {
            /*
                r13 = this;
                r0 = -2
                r1 = 0
                r13.<init>(r0, r1, r1)
                r13.first = r14
                r0 = 0
                r2 = r14
            L9:
                if (r2 == 0) goto L61
                java.util.concurrent.ConcurrentHashMap$Node<K, V> r3 = r2.next
                java.util.concurrent.ConcurrentHashMap$TreeNode r3 = (java.util.concurrent.ConcurrentHashMap.TreeNode) r3
                r2.right = r1
                r2.left = r1
                if (r0 != 0) goto L1c
                r2.parent = r1
                r4 = 0
                r2.red = r4
                r0 = r2
                goto L5e
            L1c:
                K r4 = r2.key
                int r5 = r2.hash
                r6 = 0
                r7 = r0
            L22:
                K r8 = r7.key
                int r9 = r7.hash
                r10 = r9
                if (r9 <= r5) goto L2b
                r9 = -1
                goto L45
            L2b:
                if (r10 >= r5) goto L2f
                r9 = 1
                goto L45
            L2f:
                if (r6 != 0) goto L38
                java.lang.Class r9 = java.util.concurrent.ConcurrentHashMap.comparableClassFor(r4)
                r6 = r9
                if (r9 == 0) goto L3f
            L38:
                int r9 = java.util.concurrent.ConcurrentHashMap.compareComparables(r6, r4, r8)
                r11 = r9
                if (r9 != 0) goto L44
            L3f:
                int r9 = tieBreakOrder(r4, r8)
                goto L45
            L44:
                r9 = r11
            L45:
                r11 = r7
                if (r9 > 0) goto L4b
                java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> r12 = r7.left
                goto L4d
            L4b:
                java.util.concurrent.ConcurrentHashMap$TreeNode<K, V> r12 = r7.right
            L4d:
                r7 = r12
                if (r12 != 0) goto L60
                r2.parent = r11
                if (r9 > 0) goto L57
                r11.left = r2
                goto L59
            L57:
                r11.right = r2
            L59:
                java.util.concurrent.ConcurrentHashMap$TreeNode r0 = balanceInsertion(r0, r2)
            L5e:
                r2 = r3
                goto L9
            L60:
                goto L22
            L61:
                r13.root = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeBin.<init>(java.util.concurrent.ConcurrentHashMap$TreeNode):void");
        }

        private final void lockRoot() {
            if (!ConcurrentHashMap.U.compareAndSetInt(this, LOCKSTATE, 0, 1)) {
                contendedLock();
            }
        }

        private final void unlockRoot() {
            this.lockState = 0;
        }

        private final void contendedLock() {
            boolean waiting = false;
            while (true) {
                int s2 = this.lockState;
                if ((s2 & (-3)) == 0) {
                    if (ConcurrentHashMap.U.compareAndSetInt(this, LOCKSTATE, s2, 1)) {
                        break;
                    }
                } else if ((s2 & 2) == 0) {
                    if (ConcurrentHashMap.U.compareAndSetInt(this, LOCKSTATE, s2, s2 | 2)) {
                        waiting = true;
                        this.waiter = Thread.currentThread();
                    }
                } else if (waiting) {
                    LockSupport.park(this);
                }
            }
            if (waiting) {
                this.waiter = null;
            }
        }

        @Override // java.util.concurrent.ConcurrentHashMap.Node
        final Node<K, V> find(int h10, Object k10) {
            K ek;
            Thread w3;
            Thread w10;
            TreeNode<K, V> p10 = null;
            if (k10 != null) {
                Node<K, V> e2 = this.first;
                while (e2 != null) {
                    int s2 = this.lockState;
                    if ((s2 & 3) != 0) {
                        if (e2.hash == h10 && ((ek = e2.key) == k10 || (ek != null && k10.equals(ek)))) {
                            return e2;
                        }
                        e2 = e2.next;
                    } else {
                        Unsafe unsafe = ConcurrentHashMap.U;
                        long j10 = LOCKSTATE;
                        if (unsafe.compareAndSetInt(this, j10, s2, s2 + 4)) {
                            try {
                                TreeNode<K, V> r10 = this.root;
                                if (r10 != null) {
                                    p10 = r10.findTreeNode(h10, k10, null);
                                }
                                if (ConcurrentHashMap.U.getAndAddInt(this, j10, -4) == 6 && (w10 = this.waiter) != null) {
                                    LockSupport.unpark(w10);
                                }
                                return p10;
                            } catch (Throwable th) {
                                if (ConcurrentHashMap.U.getAndAddInt(this, LOCKSTATE, -4) == 6 && (w3 = this.waiter) != null) {
                                    LockSupport.unpark(w3);
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x004a, code lost:
        
            if (r2 != null) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> putTreeVal(int r17, K r18, V r19) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ConcurrentHashMap.TreeBin.putTreeVal(int, java.lang.Object, java.lang.Object):java.util.concurrent.ConcurrentHashMap$TreeNode");
        }

        final boolean removeTreeNode(TreeNode<K, V> p10) {
            TreeNode<K, V> rl;
            TreeNode<K, V> replacement;
            TreeNode<K, V> pp;
            TreeNode<K, V> next = (TreeNode) p10.next;
            TreeNode<K, V> pred = p10.prev;
            if (pred == null) {
                this.first = next;
            } else {
                pred.next = next;
            }
            if (next != null) {
                next.prev = pred;
            }
            if (this.first == null) {
                this.root = null;
                return true;
            }
            TreeNode<K, V> treeNode = this.root;
            TreeNode<K, V> r10 = treeNode;
            if (treeNode == null || r10.right == null || (rl = r10.left) == null || rl.left == null) {
                return true;
            }
            lockRoot();
            try {
                TreeNode<K, V> pl = p10.left;
                TreeNode<K, V> pr = p10.right;
                if (pl != null && pr != null) {
                    TreeNode<K, V> s2 = pr;
                    while (true) {
                        TreeNode<K, V> sl = s2.left;
                        if (sl == null) {
                            break;
                        }
                        s2 = sl;
                    }
                    boolean c4 = s2.red;
                    s2.red = p10.red;
                    p10.red = c4;
                    TreeNode<K, V> sr = s2.right;
                    TreeNode<K, V> pp2 = p10.parent;
                    if (s2 == pr) {
                        p10.parent = s2;
                        s2.right = p10;
                    } else {
                        TreeNode<K, V> sp = s2.parent;
                        p10.parent = sp;
                        if (sp != null) {
                            if (s2 == sp.left) {
                                sp.left = p10;
                            } else {
                                sp.right = p10;
                            }
                        }
                        s2.right = pr;
                        if (pr != null) {
                            pr.parent = s2;
                        }
                    }
                    p10.left = null;
                    p10.right = sr;
                    if (sr != null) {
                        sr.parent = p10;
                    }
                    s2.left = pl;
                    if (pl != null) {
                        pl.parent = s2;
                    }
                    s2.parent = pp2;
                    if (pp2 == null) {
                        r10 = s2;
                    } else if (p10 == pp2.left) {
                        pp2.left = s2;
                    } else {
                        pp2.right = s2;
                    }
                    if (sr != null) {
                        replacement = sr;
                    } else {
                        replacement = p10;
                    }
                } else if (pl != null) {
                    replacement = pl;
                } else if (pr != null) {
                    replacement = pr;
                } else {
                    replacement = p10;
                }
                if (replacement != p10) {
                    TreeNode<K, V> pp3 = p10.parent;
                    replacement.parent = pp3;
                    if (pp3 == null) {
                        r10 = replacement;
                    } else if (p10 == pp3.left) {
                        pp3.left = replacement;
                    } else {
                        pp3.right = replacement;
                    }
                    p10.parent = null;
                    p10.right = null;
                    p10.left = null;
                }
                this.root = p10.red ? r10 : balanceDeletion(r10, replacement);
                if (p10 == replacement && (pp = p10.parent) != null) {
                    if (p10 == pp.left) {
                        pp.left = null;
                    } else if (p10 == pp.right) {
                        pp.right = null;
                    }
                    p10.parent = null;
                }
                unlockRoot();
                return false;
            } catch (Throwable th) {
                unlockRoot();
                throw th;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TableStack<K, V> {
        int index;
        int length;
        TableStack<K, V> next;
        Node<K, V>[] tab;

        TableStack() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Traverser<K, V> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int index;
        Node<K, V> next = null;
        TableStack<K, V> spare;
        TableStack<K, V> stack;
        Node<K, V>[] tab;

        Traverser(Node<K, V>[] tab, int size, int index, int limit) {
            this.tab = tab;
            this.baseSize = size;
            this.index = index;
            this.baseIndex = index;
            this.baseLimit = limit;
        }

        final Node<K, V> advance() {
            Node<K, V>[] t2;
            int n10;
            int i10;
            Node<K, V> node = this.next;
            Node<K, V> e2 = node;
            if (node != null) {
                e2 = e2.next;
            }
            while (e2 == null) {
                if (this.baseIndex >= this.baseLimit || (t2 = this.tab) == null || (n10 = t2.length) <= (i10 = this.index) || i10 < 0) {
                    this.next = null;
                    return null;
                }
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(t2, i10);
                e2 = tabAt;
                if (tabAt != null && e2.hash < 0) {
                    if (e2 instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) e2).nextTable;
                        e2 = null;
                        pushState(t2, i10, n10);
                    } else if (e2 instanceof TreeBin) {
                        e2 = ((TreeBin) e2).first;
                    } else {
                        e2 = null;
                    }
                }
                if (this.stack != null) {
                    recoverState(n10);
                } else {
                    int i11 = this.baseSize + i10;
                    this.index = i11;
                    if (i11 >= n10) {
                        int i12 = this.baseIndex + 1;
                        this.baseIndex = i12;
                        this.index = i12;
                    }
                }
            }
            this.next = e2;
            return e2;
        }

        private void pushState(Node<K, V>[] t2, int i10, int n10) {
            TableStack<K, V> s2 = this.spare;
            if (s2 != null) {
                this.spare = s2.next;
            } else {
                s2 = new TableStack<>();
            }
            s2.tab = t2;
            s2.length = n10;
            s2.index = i10;
            s2.next = this.stack;
            this.stack = s2;
        }

        private void recoverState(int n10) {
            TableStack<K, V> s2;
            while (true) {
                s2 = this.stack;
                if (s2 == null) {
                    break;
                }
                int i10 = this.index;
                int len = s2.length;
                int i11 = i10 + len;
                this.index = i11;
                if (i11 < n10) {
                    break;
                }
                n10 = len;
                this.index = s2.index;
                this.tab = s2.tab;
                s2.tab = null;
                TableStack<K, V> next = s2.next;
                s2.next = this.spare;
                this.stack = next;
                this.spare = s2;
            }
            if (s2 == null) {
                int i12 = this.index + this.baseSize;
                this.index = i12;
                if (i12 >= n10) {
                    int i13 = this.baseIndex + 1;
                    this.baseIndex = i13;
                    this.index = i13;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BaseIterator<K, V> extends Traverser<K, V> {
        Node<K, V> lastReturned;
        final ConcurrentHashMap<K, V> map;

        BaseIterator(Node<K, V>[] tab, int size, int index, int limit, ConcurrentHashMap<K, V> map) {
            super(tab, size, index, limit);
            this.map = map;
            advance();
        }

        public final boolean hasNext() {
            return this.next != null;
        }

        public final boolean hasMoreElements() {
            return this.next != null;
        }

        public final void remove() {
            Node<K, V> p10 = this.lastReturned;
            if (p10 == null) {
                throw new IllegalStateException();
            }
            this.lastReturned = null;
            this.map.replaceNode(p10.key, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class KeyIterator<K, V> extends BaseIterator<K, V> implements Iterator<K>, Enumeration<K> {
        KeyIterator(Node<K, V>[] tab, int size, int index, int limit, ConcurrentHashMap<K, V> map) {
            super(tab, size, index, limit, map);
        }

        @Override // java.util.Iterator
        public final K next() {
            Node<K, V> p10 = this.next;
            if (p10 == null) {
                throw new NoSuchElementException();
            }
            K k10 = p10.key;
            this.lastReturned = p10;
            advance();
            return k10;
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ValueIterator<K, V> extends BaseIterator<K, V> implements Iterator<V>, Enumeration<V> {
        ValueIterator(Node<K, V>[] tab, int size, int index, int limit, ConcurrentHashMap<K, V> map) {
            super(tab, size, index, limit, map);
        }

        @Override // java.util.Iterator
        public final V next() {
            Node<K, V> p10 = this.next;
            if (p10 == null) {
                throw new NoSuchElementException();
            }
            V v2 = p10.val;
            this.lastReturned = p10;
            advance();
            return v2;
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntryIterator<K, V> extends BaseIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntryIterator(Node<K, V>[] tab, int size, int index, int limit, ConcurrentHashMap<K, V> map) {
            super(tab, size, index, limit, map);
        }

        @Override // java.util.Iterator
        public final Map.Entry<K, V> next() {
            Node<K, V> p10 = this.next;
            if (p10 == null) {
                throw new NoSuchElementException();
            }
            K k10 = p10.key;
            V v2 = p10.val;
            this.lastReturned = p10;
            advance();
            return new MapEntry(k10, v2, this.map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class MapEntry<K, V> implements Map.Entry<K, V> {
        final K key;
        final ConcurrentHashMap<K, V> map;
        V val;

        MapEntry(K key, V val, ConcurrentHashMap<K, V> map) {
            this.key = key;
            this.val = val;
            this.map = map;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.key.hashCode() ^ this.val.hashCode();
        }

        public String toString() {
            return Helpers.mapEntryToString(this.key, this.val);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            Map.Entry<?, ?> e2;
            Object k10;
            Object v2;
            K k11;
            V v10;
            return (o10 instanceof Map.Entry) && (k10 = (e2 = (Map.Entry) o10).getKey()) != null && (v2 = e2.getValue()) != null && (k10 == (k11 = this.key) || k10.equals(k11)) && (v2 == (v10 = this.val) || v2.equals(v10));
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V v2 = this.val;
            this.val = value;
            this.map.put(this.key, value);
            return v2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class KeySpliterator<K, V> extends Traverser<K, V> implements Spliterator<K> {
        long est;

        KeySpliterator(Node<K, V>[] tab, int size, int index, int limit, long est) {
            super(tab, size, index, limit);
            this.est = est;
        }

        @Override // java.util.Spliterator
        public KeySpliterator<K, V> trySplit() {
            int i10 = this.baseIndex;
            int f10 = this.baseLimit;
            int h10 = (i10 + f10) >>> 1;
            if (h10 <= i10) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i11 = this.baseSize;
            this.baseLimit = h10;
            long j10 = this.est >>> 1;
            this.est = j10;
            return new KeySpliterator<>(nodeArr, i11, h10, f10, j10);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    consumer.accept(advance.key);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            consumer.accept(advance.key);
            return true;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4353;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ValueSpliterator<K, V> extends Traverser<K, V> implements Spliterator<V> {
        long est;

        ValueSpliterator(Node<K, V>[] tab, int size, int index, int limit, long est) {
            super(tab, size, index, limit);
            this.est = est;
        }

        @Override // java.util.Spliterator
        public ValueSpliterator<K, V> trySplit() {
            int i10 = this.baseIndex;
            int f10 = this.baseLimit;
            int h10 = (i10 + f10) >>> 1;
            if (h10 <= i10) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i11 = this.baseSize;
            this.baseLimit = h10;
            long j10 = this.est >>> 1;
            this.est = j10;
            return new ValueSpliterator<>(nodeArr, i11, h10, f10, j10);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> advance = advance();
                if (advance != null) {
                    consumer.accept(advance.val);
                } else {
                    return;
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V> advance = advance();
            if (advance == null) {
                return false;
            }
            consumer.accept(advance.val);
            return true;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4352;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntrySpliterator<K, V> extends Traverser<K, V> implements Spliterator<Map.Entry<K, V>> {
        long est;
        final ConcurrentHashMap<K, V> map;

        EntrySpliterator(Node<K, V>[] tab, int size, int index, int limit, long est, ConcurrentHashMap<K, V> map) {
            super(tab, size, index, limit);
            this.map = map;
            this.est = est;
        }

        @Override // java.util.Spliterator
        public EntrySpliterator<K, V> trySplit() {
            int i10 = this.baseIndex;
            int f10 = this.baseLimit;
            int h10 = (i10 + f10) >>> 1;
            if (h10 <= i10) {
                return null;
            }
            Node<K, V>[] nodeArr = this.tab;
            int i11 = this.baseSize;
            this.baseLimit = h10;
            long j10 = this.est >>> 1;
            this.est = j10;
            return new EntrySpliterator<>(nodeArr, i11, h10, f10, j10, this.map);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            while (true) {
                Node<K, V> p10 = advance();
                if (p10 != null) {
                    action.accept(new MapEntry(p10.key, p10.val, this.map));
                } else {
                    return;
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V> p10 = advance();
            if (p10 == null) {
                return false;
            }
            action.accept(new MapEntry(p10.key, p10.val, this.map));
            return true;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4353;
        }
    }

    final int batchFor(long b4) {
        if (b4 == Long.MAX_VALUE) {
            return 0;
        }
        long n10 = sumCount();
        if (n10 <= 1 || n10 < b4) {
            return 0;
        }
        int sp = ForkJoinPool.getCommonPoolParallelism() << 2;
        if (b4 > 0) {
            long n11 = n10 / b4;
            if (n11 < sp) {
                return (int) n11;
            }
        }
        return sp;
    }

    public void forEach(long parallelismThreshold, BiConsumer<? super K, ? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachMappingTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    public <U> void forEach(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedMappingTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    public <U> U search(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchMappingsTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public <U> U reduce(long parallelismThreshold, BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    public double reduceToDouble(long parallelismThreshold, ToDoubleBiFunction<? super K, ? super V> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().doubleValue();
    }

    public long reduceToLong(long parallelismThreshold, ToLongBiFunction<? super K, ? super V> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().longValue();
    }

    public int reduceToInt(long parallelismThreshold, ToIntBiFunction<? super K, ? super V> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceMappingsToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().intValue();
    }

    public void forEachKey(long parallelismThreshold, Consumer<? super K> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachKeyTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachKey(long parallelismThreshold, Function<? super K, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedKeyTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    public <U> U searchKeys(long parallelismThreshold, Function<? super K, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public K reduceKeys(long parallelismThreshold, BiFunction<? super K, ? super K, ? extends K> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return new ReduceKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    public <U> U reduceKeys(long parallelismThreshold, Function<? super K, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    public double reduceKeysToDouble(long parallelismThreshold, ToDoubleFunction<? super K> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().doubleValue();
    }

    public long reduceKeysToLong(long parallelismThreshold, ToLongFunction<? super K> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().longValue();
    }

    public int reduceKeysToInt(long parallelismThreshold, ToIntFunction<? super K> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceKeysToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().intValue();
    }

    public void forEachValue(long parallelismThreshold, Consumer<? super V> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachValueTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachValue(long parallelismThreshold, Function<? super V, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedValueTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    public <U> U searchValues(long parallelismThreshold, Function<? super V, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public V reduceValues(long parallelismThreshold, BiFunction<? super V, ? super V, ? extends V> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return new ReduceValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    public <U> U reduceValues(long parallelismThreshold, Function<? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    public double reduceValuesToDouble(long parallelismThreshold, ToDoubleFunction<? super V> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().doubleValue();
    }

    public long reduceValuesToLong(long parallelismThreshold, ToLongFunction<? super V> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().longValue();
    }

    public int reduceValuesToInt(long parallelismThreshold, ToIntFunction<? super V> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceValuesToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().intValue();
    }

    public void forEachEntry(long parallelismThreshold, Consumer<? super Map.Entry<K, V>> action) {
        if (action == null) {
            throw new NullPointerException();
        }
        new ForEachEntryTask(null, batchFor(parallelismThreshold), 0, 0, this.table, action).invoke();
    }

    public <U> void forEachEntry(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> transformer, Consumer<? super U> action) {
        if (transformer == null || action == null) {
            throw new NullPointerException();
        }
        new ForEachTransformedEntryTask(null, batchFor(parallelismThreshold), 0, 0, this.table, transformer, action).invoke();
    }

    public <U> U searchEntries(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> searchFunction) {
        if (searchFunction == null) {
            throw new NullPointerException();
        }
        return new SearchEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, searchFunction, new AtomicReference()).invoke();
    }

    public Map.Entry<K, V> reduceEntries(long parallelismThreshold, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer) {
        if (reducer == null) {
            throw new NullPointerException();
        }
        return new ReduceEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, reducer).invoke();
    }

    public <U> U reduceEntries(long parallelismThreshold, Function<Map.Entry<K, V>, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, reducer).invoke();
    }

    public double reduceEntriesToDouble(long parallelismThreshold, ToDoubleFunction<Map.Entry<K, V>> transformer, double basis, DoubleBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToDoubleTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().doubleValue();
    }

    public long reduceEntriesToLong(long parallelismThreshold, ToLongFunction<Map.Entry<K, V>> transformer, long basis, LongBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToLongTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().longValue();
    }

    public int reduceEntriesToInt(long parallelismThreshold, ToIntFunction<Map.Entry<K, V>> transformer, int basis, IntBinaryOperator reducer) {
        if (transformer == null || reducer == null) {
            throw new NullPointerException();
        }
        return new MapReduceEntriesToIntTask(null, batchFor(parallelismThreshold), 0, 0, this.table, null, transformer, basis, reducer).invoke().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class CollectionView<K, V, E> implements Collection<E>, Serializable {
        private static final String OOME_MSG = "Required array size too large";
        private static final long serialVersionUID = 7249069246763182397L;
        final ConcurrentHashMap<K, V> map;

        @Override // java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public abstract Iterator<E> iterator2();

        @Override // java.util.Collection, java.util.Set
        public abstract boolean remove(Object obj);

        CollectionView(ConcurrentHashMap<K, V> map) {
            this.map = map;
        }

        public ConcurrentHashMap<K, V> getMap() {
            return this.map;
        }

        @Override // java.util.Collection, java.util.Set
        public final void clear() {
            this.map.clear();
        }

        @Override // java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Collection, java.util.Set
        public final Object[] toArray() {
            long sz = this.map.mappingCount();
            if (sz > 2147483639) {
                throw new OutOfMemoryError(OOME_MSG);
            }
            int n10 = (int) sz;
            Object[] r10 = new Object[n10];
            int i10 = 0;
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                E e2 = iterator2.next();
                if (i10 == n10) {
                    if (n10 >= 2147483639) {
                        throw new OutOfMemoryError(OOME_MSG);
                    }
                    if (n10 >= 1073741819) {
                        n10 = 2147483639;
                    } else {
                        n10 += (n10 >>> 1) + 1;
                    }
                    r10 = Arrays.copyOf(r10, n10);
                }
                r10[i10] = e2;
                i10++;
            }
            return i10 == n10 ? r10 : Arrays.copyOf(r10, i10);
        }

        @Override // java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] tArr) {
            long mappingCount = this.map.mappingCount();
            if (mappingCount > 2147483639) {
                throw new OutOfMemoryError(OOME_MSG);
            }
            int i10 = (int) mappingCount;
            Object[] objArr = tArr.length >= i10 ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10);
            int length = objArr.length;
            int i11 = 0;
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                E next = iterator2.next();
                if (i11 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError(OOME_MSG);
                    }
                    if (length >= 1073741819) {
                        length = 2147483639;
                    } else {
                        length += (length >>> 1) + 1;
                    }
                    objArr = (T[]) Arrays.copyOf(objArr, length);
                }
                objArr[i11] = next;
                i11++;
            }
            if (tArr != objArr || i11 >= length) {
                return i11 == length ? objArr : (T[]) Arrays.copyOf(objArr, i11);
            }
            objArr[i11] = null;
            return (T[]) objArr;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            Iterator<E> it = iterator2();
            if (it.hasNext()) {
                while (true) {
                    Object e2 = it.next();
                    sb2.append(e2 == this ? "(this Collection)" : e2);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb2.append(',').append(' ');
                }
            }
            return sb2.append(']').toString();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> c4) {
            if (c4 != this) {
                for (Object e2 : c4) {
                    if (e2 == null || !contains(e2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            if (c4 == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Node<K, V>[] t2 = this.map.table;
            if (t2 == null) {
                return false;
            }
            if ((c4 instanceof Set) && c4.size() > t2.length) {
                Iterator<E> iterator2 = iterator2();
                while (iterator2.hasNext()) {
                    if (c4.contains(iterator2.next())) {
                        iterator2.remove();
                        modified = true;
                    }
                }
            } else {
                for (Object e2 : c4) {
                    modified |= remove(e2);
                }
            }
            return modified;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> c4) {
            if (c4 == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Iterator<E> it = iterator2();
            while (it.hasNext()) {
                if (!c4.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class KeySetView<K, V> extends CollectionView<K, V, K> implements Set<K>, Serializable {
        private static final long serialVersionUID = 7249069246763182397L;
        private final V value;

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView
        public /* bridge */ /* synthetic */ ConcurrentHashMap getMap() {
            return super.getMap();
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return super.removeAll(collection);
        }

        KeySetView(ConcurrentHashMap<K, V> map, V value) {
            super(map);
            this.value = value;
        }

        public V getMappedValue() {
            return this.value;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.map.containsKey(o10);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.map.remove(o10) != null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            ConcurrentHashMap<K, V> m10 = this.map;
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new KeyIterator(t2, f10, 0, f10, m10);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K e2) {
            V v2 = this.value;
            if (v2 != null) {
                return this.map.putVal(e2, v2, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> c4) {
            boolean added = false;
            V v2 = this.value;
            if (v2 == null) {
                throw new UnsupportedOperationException();
            }
            for (K e2 : c4) {
                if (this.map.putVal(e2, v2, true) == null) {
                    added = true;
                }
            }
            return added;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int h10 = 0;
            Iterator<K> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                K e2 = iterator2.next();
                h10 += e2.hashCode();
            }
            return h10;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            Set<?> c4;
            return (o10 instanceof Set) && ((c4 = (Set) o10) == this || (containsAll(c4) && c4.containsAll(this)));
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<K> spliterator() {
            ConcurrentHashMap<K, V> m10 = this.map;
            long n10 = m10.sumCount();
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new KeySpliterator(t2, f10, 0, f10, n10 < 0 ? 0L : n10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        consumer.accept(advance.key);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ValuesView<K, V> extends CollectionView<K, V, V> implements Collection<V>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        ValuesView(ConcurrentHashMap<K, V> map) {
            super(map);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public final boolean contains(Object o10) {
            return this.map.containsValue(o10);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public final boolean remove(Object o10) {
            if (o10 != null) {
                Iterator<V> it = iterator2();
                while (it.hasNext()) {
                    if (o10.equals(it.next())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public final Iterator<V> iterator2() {
            ConcurrentHashMap<K, V> m10 = this.map;
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new ValueIterator(t2, f10, 0, f10, m10);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean add(V e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(Collection<? extends V> c4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            if (c4 == null) {
                throw new NullPointerException();
            }
            boolean modified = false;
            Iterator<V> it = iterator2();
            while (it.hasNext()) {
                if (c4.contains(it.next())) {
                    it.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super V> filter) {
            return this.map.removeValueIf(filter);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            ConcurrentHashMap<K, V> m10 = this.map;
            long n10 = m10.sumCount();
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new ValueSpliterator(t2, f10, 0, f10, n10 < 0 ? 0L : n10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] nodeArr = this.map.table;
            if (nodeArr != null) {
                Traverser traverser = new Traverser(nodeArr, nodeArr.length, 0, nodeArr.length);
                while (true) {
                    Node<K, V> advance = traverser.advance();
                    if (advance != null) {
                        consumer.accept(advance.val);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EntrySetView<K, V> extends CollectionView<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>>, Serializable {
        private static final long serialVersionUID = 2249069246763182397L;

        EntrySetView(ConcurrentHashMap<K, V> map) {
            super(map);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            Map.Entry<?, ?> e2;
            Object k10;
            Object r10;
            Object v2;
            return (!(o10 instanceof Map.Entry) || (k10 = (e2 = (Map.Entry) o10).getKey()) == null || (r10 = this.map.get(k10)) == null || (v2 = e2.getValue()) == null || (v2 != r10 && !v2.equals(r10))) ? false : true;
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Map.Entry<?, ?> e2;
            Object k10;
            Object v2;
            return (o10 instanceof Map.Entry) && (k10 = (e2 = (Map.Entry) o10).getKey()) != null && (v2 = e2.getValue()) != null && this.map.remove(k10, v2);
        }

        @Override // java.util.concurrent.ConcurrentHashMap.CollectionView, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            ConcurrentHashMap<K, V> m10 = this.map;
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new EntryIterator(t2, f10, 0, f10, m10);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> e2) {
            return this.map.putVal(e2.getKey(), e2.getValue(), false) == null;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> c4) {
            boolean added = false;
            for (Map.Entry<K, V> e2 : c4) {
                if (add((Map.Entry) e2)) {
                    added = true;
                }
            }
            return added;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super Map.Entry<K, V>> filter) {
            return this.map.removeEntryIf(filter);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            int h10 = 0;
            Node<K, V>[] t2 = this.map.table;
            if (t2 != null) {
                Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
                while (true) {
                    Node<K, V> p10 = it.advance();
                    if (p10 == null) {
                        break;
                    }
                    h10 += p10.hashCode();
                }
            }
            return h10;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object o10) {
            Set<?> c4;
            return (o10 instanceof Set) && ((c4 = (Set) o10) == this || (containsAll(c4) && c4.containsAll(this)));
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            ConcurrentHashMap<K, V> m10 = this.map;
            long n10 = m10.sumCount();
            Node<K, V>[] t2 = m10.table;
            int f10 = t2 == null ? 0 : t2.length;
            return new EntrySpliterator(t2, f10, 0, f10, n10 < 0 ? 0L : n10, m10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Node<K, V>[] t2 = this.map.table;
            if (t2 != null) {
                Traverser<K, V> it = new Traverser<>(t2, t2.length, 0, t2.length);
                while (true) {
                    Node<K, V> p10 = it.advance();
                    if (p10 != null) {
                        action.accept(new MapEntry(p10.key, p10.val, this.map));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static abstract class BulkTask<K, V, R> extends CountedCompleter<R> {
        int baseIndex;
        int baseLimit;
        final int baseSize;
        int batch;
        int index;
        Node<K, V> next;
        TableStack<K, V> spare;
        TableStack<K, V> stack;
        Node<K, V>[] tab;

        BulkTask(BulkTask<K, V, ?> par, int b4, int i10, int f10, Node<K, V>[] t2) {
            super(par);
            this.batch = b4;
            this.baseIndex = i10;
            this.index = i10;
            this.tab = t2;
            if (t2 == null) {
                this.baseLimit = 0;
                this.baseSize = 0;
            } else if (par == null) {
                int length = t2.length;
                this.baseLimit = length;
                this.baseSize = length;
            } else {
                this.baseLimit = f10;
                this.baseSize = par.baseSize;
            }
        }

        final Node<K, V> advance() {
            Node<K, V>[] t2;
            int n10;
            int i10;
            Node<K, V> node = this.next;
            Node<K, V> e2 = node;
            if (node != null) {
                e2 = e2.next;
            }
            while (e2 == null) {
                if (this.baseIndex >= this.baseLimit || (t2 = this.tab) == null || (n10 = t2.length) <= (i10 = this.index) || i10 < 0) {
                    this.next = null;
                    return null;
                }
                Node<K, V> tabAt = ConcurrentHashMap.tabAt(t2, i10);
                e2 = tabAt;
                if (tabAt != null && e2.hash < 0) {
                    if (e2 instanceof ForwardingNode) {
                        this.tab = ((ForwardingNode) e2).nextTable;
                        e2 = null;
                        pushState(t2, i10, n10);
                    } else if (e2 instanceof TreeBin) {
                        e2 = ((TreeBin) e2).first;
                    } else {
                        e2 = null;
                    }
                }
                if (this.stack != null) {
                    recoverState(n10);
                } else {
                    int i11 = this.baseSize + i10;
                    this.index = i11;
                    if (i11 >= n10) {
                        int i12 = this.baseIndex + 1;
                        this.baseIndex = i12;
                        this.index = i12;
                    }
                }
            }
            this.next = e2;
            return e2;
        }

        private void pushState(Node<K, V>[] t2, int i10, int n10) {
            TableStack<K, V> s2 = this.spare;
            if (s2 != null) {
                this.spare = s2.next;
            } else {
                s2 = new TableStack<>();
            }
            s2.tab = t2;
            s2.length = n10;
            s2.index = i10;
            s2.next = this.stack;
            this.stack = s2;
        }

        private void recoverState(int n10) {
            TableStack<K, V> s2;
            while (true) {
                s2 = this.stack;
                if (s2 == null) {
                    break;
                }
                int i10 = this.index;
                int len = s2.length;
                int i11 = i10 + len;
                this.index = i11;
                if (i11 < n10) {
                    break;
                }
                n10 = len;
                this.index = s2.index;
                this.tab = s2.tab;
                s2.tab = null;
                TableStack<K, V> next = s2.next;
                s2.next = this.spare;
                this.stack = next;
                this.spare = s2;
            }
            if (s2 == null) {
                int i12 = this.index + this.baseSize;
                this.index = i12;
                if (i12 >= n10) {
                    int i13 = this.baseIndex + 1;
                    this.baseIndex = i13;
                    this.index = i13;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachKeyTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super K> action;

        ForEachKeyTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Consumer<? super K> action) {
            super(p10, b4, i10, f10, t2);
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super K> consumer = this.action;
            if (consumer != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachKeyTask(this, i13, i12, i11, this.tab, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        consumer.accept(advance.key);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachValueTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super V> action;

        ForEachValueTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Consumer<? super V> action) {
            super(p10, b4, i10, f10, t2);
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super V> consumer = this.action;
            if (consumer != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachValueTask(this, i13, i12, i11, this.tab, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        consumer.accept(advance.val);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachEntryTask<K, V> extends BulkTask<K, V, Void> {
        final Consumer<? super Map.Entry<K, V>> action;

        ForEachEntryTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Consumer<? super Map.Entry<K, V>> action) {
            super(p10, b4, i10, f10, t2);
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super Map.Entry<K, V>> action = this.action;
            if (action != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    new ForEachEntryTask(this, i11, h10, f10, this.tab, action).fork();
                }
                while (true) {
                    Node<K, V> p10 = advance();
                    if (p10 != null) {
                        action.accept(p10);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachMappingTask<K, V> extends BulkTask<K, V, Void> {
        final BiConsumer<? super K, ? super V> action;

        ForEachMappingTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, BiConsumer<? super K, ? super V> action) {
            super(p10, b4, i10, f10, t2);
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiConsumer<? super K, ? super V> biConsumer = this.action;
            if (biConsumer != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachMappingTask(this, i13, i12, i11, this.tab, biConsumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        biConsumer.accept(advance.key, advance.val);
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachTransformedKeyTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super K, ? extends U> transformer;

        ForEachTransformedKeyTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<? super K, ? extends U> transformer, Consumer<? super U> action) {
            super(p10, b4, i10, f10, t2);
            this.transformer = transformer;
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> consumer;
            Function<? super K, ? extends U> function = this.transformer;
            if (function != null && (consumer = this.action) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachTransformedKeyTask(this, i13, i12, i11, this.tab, function, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        U apply = function.apply(advance.key);
                        if (apply != null) {
                            consumer.accept(apply);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachTransformedValueTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<? super V, ? extends U> transformer;

        ForEachTransformedValueTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<? super V, ? extends U> transformer, Consumer<? super U> action) {
            super(p10, b4, i10, f10, t2);
            this.transformer = transformer;
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> consumer;
            Function<? super V, ? extends U> function = this.transformer;
            if (function != null && (consumer = this.action) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachTransformedValueTask(this, i13, i12, i11, this.tab, function, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        U apply = function.apply(advance.val);
                        if (apply != null) {
                            consumer.accept(apply);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachTransformedEntryTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        ForEachTransformedEntryTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<Map.Entry<K, V>, ? extends U> transformer, Consumer<? super U> action) {
            super(p10, b4, i10, f10, t2);
            this.transformer = transformer;
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> consumer;
            Function<Map.Entry<K, V>, ? extends U> function = this.transformer;
            if (function != null && (consumer = this.action) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachTransformedEntryTask(this, i13, i12, i11, this.tab, function, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        U apply = function.apply(advance);
                        if (apply != null) {
                            consumer.accept(apply);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ForEachTransformedMappingTask<K, V, U> extends BulkTask<K, V, Void> {
        final Consumer<? super U> action;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        ForEachTransformedMappingTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, BiFunction<? super K, ? super V, ? extends U> transformer, Consumer<? super U> action) {
            super(p10, b4, i10, f10, t2);
            this.transformer = transformer;
            this.action = action;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Consumer<? super U> consumer;
            BiFunction<? super K, ? super V, ? extends U> biFunction = this.transformer;
            if (biFunction != null && (consumer = this.action) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new ForEachTransformedMappingTask(this, i13, i12, i11, this.tab, biFunction, consumer).fork();
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance != null) {
                        U apply = biFunction.apply(advance.key, advance.val);
                        if (apply != null) {
                            consumer.accept(apply);
                        }
                    } else {
                        propagateCompletion();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SearchKeysTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super K, ? extends U> searchFunction;

        SearchKeysTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<? super K, ? extends U> searchFunction, AtomicReference<U> result) {
            super(p10, b4, i10, f10, t2);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Function<? super K, ? extends U> function = this.searchFunction;
            if (function != null && (atomicReference = this.result) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    if (atomicReference.get() != null) {
                        return;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new SearchKeysTask(this, i13, i12, i11, this.tab, function, atomicReference).fork();
                }
                while (atomicReference.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U apply = function.apply(advance.key);
                    if (apply != null) {
                        if (atomicReference.compareAndSet(null, apply)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SearchValuesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<? super V, ? extends U> searchFunction;

        SearchValuesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<? super V, ? extends U> searchFunction, AtomicReference<U> result) {
            super(p10, b4, i10, f10, t2);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            Function<? super V, ? extends U> function = this.searchFunction;
            if (function != null && (atomicReference = this.result) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    if (atomicReference.get() != null) {
                        return;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new SearchValuesTask(this, i13, i12, i11, this.tab, function, atomicReference).fork();
                }
                while (atomicReference.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U apply = function.apply(advance.val);
                    if (apply != null) {
                        if (atomicReference.compareAndSet(null, apply)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SearchEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final Function<Map.Entry<K, V>, ? extends U> searchFunction;

        SearchEntriesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, Function<Map.Entry<K, V>, ? extends U> searchFunction, AtomicReference<U> result) {
            super(p10, b4, i10, f10, t2);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> result;
            Function<Map.Entry<K, V>, ? extends U> searchFunction = this.searchFunction;
            if (searchFunction != null && (result = this.result) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        break;
                    }
                    if (result.get() != null) {
                        return;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    new SearchEntriesTask(this, i11, h10, f10, this.tab, searchFunction, result).fork();
                }
                while (result.get() == null) {
                    Node<K, V> p10 = advance();
                    if (p10 == null) {
                        propagateCompletion();
                        return;
                    }
                    U u10 = searchFunction.apply(p10);
                    if (u10 != null) {
                        if (result.compareAndSet(null, u10)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SearchMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        final AtomicReference<U> result;
        final BiFunction<? super K, ? super V, ? extends U> searchFunction;

        SearchMappingsTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, BiFunction<? super K, ? super V, ? extends U> searchFunction, AtomicReference<U> result) {
            super(p10, b4, i10, f10, t2);
            this.searchFunction = searchFunction;
            this.result = result;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result.get();
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            AtomicReference<U> atomicReference;
            BiFunction<? super K, ? super V, ? extends U> biFunction = this.searchFunction;
            if (biFunction != null && (atomicReference = this.result) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    if (atomicReference.get() != null) {
                        return;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    new SearchMappingsTask(this, i13, i12, i11, this.tab, biFunction, atomicReference).fork();
                }
                while (atomicReference.get() == null) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        propagateCompletion();
                        return;
                    }
                    U apply = biFunction.apply(advance.key, advance.val);
                    if (apply != null) {
                        if (atomicReference.compareAndSet(null, apply)) {
                            quietlyCompleteRoot();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ReduceKeysTask<K, V> extends BulkTask<K, V, K> {
        ReduceKeysTask<K, V> nextRight;
        final BiFunction<? super K, ? super K, ? extends K> reducer;
        K result;
        ReduceKeysTask<K, V> rights;

        ReduceKeysTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, ReduceKeysTask<K, V> nextRight, BiFunction<? super K, ? super K, ? extends K> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final K getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, K] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super K, ? super K, ? extends K> biFunction = this.reducer;
            if (biFunction != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    ReduceKeysTask<K, V> reduceKeysTask = new ReduceKeysTask<>(this, i13, i12, i11, this.tab, this.rights, biFunction);
                    this.rights = reduceKeysTask;
                    reduceKeysTask.fork();
                }
                Object obj = (K) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (K) advance.key;
                    obj = (K) (obj == null ? obj2 : obj2 == null ? obj : biFunction.apply(obj, obj2));
                }
                this.result = (K) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    ReduceKeysTask reduceKeysTask2 = (ReduceKeysTask) firstComplete;
                    ReduceKeysTask<K, V> reduceKeysTask3 = reduceKeysTask2.rights;
                    while (reduceKeysTask3 != null) {
                        K k10 = reduceKeysTask3.result;
                        if (k10 != 0) {
                            Object obj3 = (K) reduceKeysTask2.result;
                            reduceKeysTask2.result = obj3 == null ? k10 : biFunction.apply(obj3, k10);
                        }
                        ReduceKeysTask<K, V> reduceKeysTask4 = reduceKeysTask3.nextRight;
                        reduceKeysTask2.rights = reduceKeysTask4;
                        reduceKeysTask3 = reduceKeysTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ReduceValuesTask<K, V> extends BulkTask<K, V, V> {
        ReduceValuesTask<K, V> nextRight;
        final BiFunction<? super V, ? super V, ? extends V> reducer;
        V result;
        ReduceValuesTask<K, V> rights;

        ReduceValuesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, ReduceValuesTask<K, V> nextRight, BiFunction<? super V, ? super V, ? extends V> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final V getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [V, java.lang.Object] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super V, ? super V, ? extends V> biFunction = this.reducer;
            if (biFunction != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    ReduceValuesTask<K, V> reduceValuesTask = new ReduceValuesTask<>(this, i13, i12, i11, this.tab, this.rights, biFunction);
                    this.rights = reduceValuesTask;
                    reduceValuesTask.fork();
                }
                Object obj = (V) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (V) advance.val;
                    obj = (V) (obj == null ? obj2 : biFunction.apply(obj, obj2));
                }
                this.result = (V) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    ReduceValuesTask reduceValuesTask2 = (ReduceValuesTask) firstComplete;
                    ReduceValuesTask<K, V> reduceValuesTask3 = reduceValuesTask2.rights;
                    while (reduceValuesTask3 != null) {
                        V v2 = reduceValuesTask3.result;
                        if (v2 != 0) {
                            Object obj3 = (V) reduceValuesTask2.result;
                            reduceValuesTask2.result = obj3 == null ? v2 : biFunction.apply(obj3, v2);
                        }
                        ReduceValuesTask<K, V> reduceValuesTask4 = reduceValuesTask3.nextRight;
                        reduceValuesTask2.rights = reduceValuesTask4;
                        reduceValuesTask3 = reduceValuesTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class ReduceEntriesTask<K, V> extends BulkTask<K, V, Map.Entry<K, V>> {
        ReduceEntriesTask<K, V> nextRight;
        final BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer;
        Map.Entry<K, V> result;
        ReduceEntriesTask<K, V> rights;

        ReduceEntriesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, ReduceEntriesTask<K, V> nextRight, BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Map.Entry<K, V> getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<Map.Entry<K, V>, Map.Entry<K, V>, ? extends Map.Entry<K, V>> reducer = this.reducer;
            if (reducer != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    ReduceEntriesTask<K, V> reduceEntriesTask = new ReduceEntriesTask<>(this, i11, h10, f10, this.tab, this.rights, reducer);
                    this.rights = reduceEntriesTask;
                    reduceEntriesTask.fork();
                }
                Map.Entry<K, V> r10 = null;
                while (true) {
                    Node<K, V> p10 = advance();
                    if (p10 == null) {
                        break;
                    } else {
                        r10 = r10 == null ? p10 : reducer.apply(r10, p10);
                    }
                }
                this.result = r10;
                for (CountedCompleter<?> c4 = firstComplete(); c4 != null; c4 = c4.nextComplete()) {
                    ReduceEntriesTask<K, V> t2 = (ReduceEntriesTask) c4;
                    ReduceEntriesTask<K, V> s2 = t2.rights;
                    while (s2 != null) {
                        Map.Entry<K, V> sr = s2.result;
                        if (sr != null) {
                            Map.Entry<K, V> tr = t2.result;
                            t2.result = tr == null ? sr : reducer.apply(tr, sr);
                        }
                        ReduceEntriesTask<K, V> reduceEntriesTask2 = s2.nextRight;
                        t2.rights = reduceEntriesTask2;
                        s2 = reduceEntriesTask2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceKeysTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceKeysTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceKeysTask<K, V, U> rights;
        final Function<? super K, ? extends U> transformer;

        MapReduceKeysTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceKeysTask<K, V, U> nextRight, Function<? super K, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [U, java.lang.Object] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> biFunction;
            Function<? super K, ? extends U> function = this.transformer;
            if (function != null && (biFunction = this.reducer) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceKeysTask<K, V, U> mapReduceKeysTask = new MapReduceKeysTask<>(this, i13, i12, i11, this.tab, this.rights, function, biFunction);
                    this.rights = mapReduceKeysTask;
                    mapReduceKeysTask.fork();
                }
                Object obj = (U) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (U) function.apply((K) advance.key);
                    if (obj2 != null) {
                        obj = (U) (obj == null ? obj2 : biFunction.apply(obj, obj2));
                    }
                }
                this.result = (U) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceKeysTask mapReduceKeysTask2 = (MapReduceKeysTask) firstComplete;
                    MapReduceKeysTask<K, V, U> mapReduceKeysTask3 = mapReduceKeysTask2.rights;
                    while (mapReduceKeysTask3 != null) {
                        U u10 = mapReduceKeysTask3.result;
                        if (u10 != 0) {
                            Object obj3 = (U) mapReduceKeysTask2.result;
                            mapReduceKeysTask2.result = obj3 == null ? u10 : biFunction.apply(obj3, u10);
                        }
                        MapReduceKeysTask<K, V, U> mapReduceKeysTask4 = mapReduceKeysTask3.nextRight;
                        mapReduceKeysTask2.rights = mapReduceKeysTask4;
                        mapReduceKeysTask3 = mapReduceKeysTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceValuesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceValuesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceValuesTask<K, V, U> rights;
        final Function<? super V, ? extends U> transformer;

        MapReduceValuesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceValuesTask<K, V, U> nextRight, Function<? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [U, java.lang.Object] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> biFunction;
            Function<? super V, ? extends U> function = this.transformer;
            if (function != null && (biFunction = this.reducer) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceValuesTask<K, V, U> mapReduceValuesTask = new MapReduceValuesTask<>(this, i13, i12, i11, this.tab, this.rights, function, biFunction);
                    this.rights = mapReduceValuesTask;
                    mapReduceValuesTask.fork();
                }
                Object obj = (U) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (U) function.apply((V) advance.val);
                    if (obj2 != null) {
                        obj = (U) (obj == null ? obj2 : biFunction.apply(obj, obj2));
                    }
                }
                this.result = (U) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceValuesTask mapReduceValuesTask2 = (MapReduceValuesTask) firstComplete;
                    MapReduceValuesTask<K, V, U> mapReduceValuesTask3 = mapReduceValuesTask2.rights;
                    while (mapReduceValuesTask3 != null) {
                        U u10 = mapReduceValuesTask3.result;
                        if (u10 != 0) {
                            Object obj3 = (U) mapReduceValuesTask2.result;
                            mapReduceValuesTask2.result = obj3 == null ? u10 : biFunction.apply(obj3, u10);
                        }
                        MapReduceValuesTask<K, V, U> mapReduceValuesTask4 = mapReduceValuesTask3.nextRight;
                        mapReduceValuesTask2.rights = mapReduceValuesTask4;
                        mapReduceValuesTask3 = mapReduceValuesTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceEntriesTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceEntriesTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceEntriesTask<K, V, U> rights;
        final Function<Map.Entry<K, V>, ? extends U> transformer;

        MapReduceEntriesTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceEntriesTask<K, V, U> nextRight, Function<Map.Entry<K, V>, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [U, java.lang.Object] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> biFunction;
            Function<Map.Entry<K, V>, ? extends U> function = this.transformer;
            if (function != null && (biFunction = this.reducer) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceEntriesTask<K, V, U> mapReduceEntriesTask = new MapReduceEntriesTask<>(this, i13, i12, i11, this.tab, this.rights, function, biFunction);
                    this.rights = mapReduceEntriesTask;
                    mapReduceEntriesTask.fork();
                }
                Object obj = (U) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (U) function.apply(advance);
                    if (obj2 != null) {
                        obj = (U) (obj == null ? obj2 : biFunction.apply(obj, obj2));
                    }
                }
                this.result = (U) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceEntriesTask mapReduceEntriesTask2 = (MapReduceEntriesTask) firstComplete;
                    MapReduceEntriesTask<K, V, U> mapReduceEntriesTask3 = mapReduceEntriesTask2.rights;
                    while (mapReduceEntriesTask3 != null) {
                        U u10 = mapReduceEntriesTask3.result;
                        if (u10 != 0) {
                            Object obj3 = (U) mapReduceEntriesTask2.result;
                            mapReduceEntriesTask2.result = obj3 == null ? u10 : biFunction.apply(obj3, u10);
                        }
                        MapReduceEntriesTask<K, V, U> mapReduceEntriesTask4 = mapReduceEntriesTask3.nextRight;
                        mapReduceEntriesTask2.rights = mapReduceEntriesTask4;
                        mapReduceEntriesTask3 = mapReduceEntriesTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceMappingsTask<K, V, U> extends BulkTask<K, V, U> {
        MapReduceMappingsTask<K, V, U> nextRight;
        final BiFunction<? super U, ? super U, ? extends U> reducer;
        U result;
        MapReduceMappingsTask<K, V, U> rights;
        final BiFunction<? super K, ? super V, ? extends U> transformer;

        MapReduceMappingsTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceMappingsTask<K, V, U> nextRight, BiFunction<? super K, ? super V, ? extends U> transformer, BiFunction<? super U, ? super U, ? extends U> reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final U getRawResult() {
            return this.result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [U, java.lang.Object] */
        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            BiFunction<? super U, ? super U, ? extends U> biFunction;
            BiFunction<? super K, ? super V, ? extends U> biFunction2 = this.transformer;
            if (biFunction2 != null && (biFunction = this.reducer) != null) {
                int i10 = this.baseIndex;
                while (this.batch > 0) {
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceMappingsTask<K, V, U> mapReduceMappingsTask = new MapReduceMappingsTask<>(this, i13, i12, i11, this.tab, this.rights, biFunction2, biFunction);
                    this.rights = mapReduceMappingsTask;
                    mapReduceMappingsTask.fork();
                }
                Object obj = (U) null;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    }
                    Object obj2 = (U) biFunction2.apply((K) advance.key, (V) advance.val);
                    if (obj2 != null) {
                        obj = (U) (obj == null ? obj2 : biFunction.apply(obj, obj2));
                    }
                }
                this.result = (U) obj;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceMappingsTask mapReduceMappingsTask2 = (MapReduceMappingsTask) firstComplete;
                    MapReduceMappingsTask<K, V, U> mapReduceMappingsTask3 = mapReduceMappingsTask2.rights;
                    while (mapReduceMappingsTask3 != null) {
                        U u10 = mapReduceMappingsTask3.result;
                        if (u10 != 0) {
                            Object obj3 = (U) mapReduceMappingsTask2.result;
                            mapReduceMappingsTask2.result = obj3 == null ? u10 : biFunction.apply(obj3, u10);
                        }
                        MapReduceMappingsTask<K, V, U> mapReduceMappingsTask4 = mapReduceMappingsTask3.nextRight;
                        mapReduceMappingsTask2.rights = mapReduceMappingsTask4;
                        mapReduceMappingsTask3 = mapReduceMappingsTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceKeysToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceKeysToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceKeysToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super K> transformer;

        MapReduceKeysToDoubleTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceKeysToDoubleTask<K, V> nextRight, ToDoubleFunction<? super K> transformer, double basis, DoubleBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator doubleBinaryOperator;
            ToDoubleFunction<? super K> toDoubleFunction;
            ToDoubleFunction<? super K> toDoubleFunction2 = this.transformer;
            ToDoubleFunction<? super K> toDoubleFunction3 = toDoubleFunction2;
            if (toDoubleFunction2 != null && (doubleBinaryOperator = this.reducer) != null) {
                double d10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toDoubleFunction = toDoubleFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toDoubleFunction = toDoubleFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask = new MapReduceKeysToDoubleTask<>(this, i13, i12, i11, this.tab, this.rights, toDoubleFunction3, d10, doubleBinaryOperator);
                    this.rights = mapReduceKeysToDoubleTask;
                    mapReduceKeysToDoubleTask.fork();
                    toDoubleFunction3 = toDoubleFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        d10 = doubleBinaryOperator.applyAsDouble(d10, toDoubleFunction.applyAsDouble(advance.key));
                    }
                }
                this.result = d10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceKeysToDoubleTask mapReduceKeysToDoubleTask2 = (MapReduceKeysToDoubleTask) firstComplete;
                    MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask2.rights;
                    while (mapReduceKeysToDoubleTask3 != null) {
                        mapReduceKeysToDoubleTask2.result = doubleBinaryOperator.applyAsDouble(mapReduceKeysToDoubleTask2.result, mapReduceKeysToDoubleTask3.result);
                        MapReduceKeysToDoubleTask<K, V> mapReduceKeysToDoubleTask4 = mapReduceKeysToDoubleTask3.nextRight;
                        mapReduceKeysToDoubleTask2.rights = mapReduceKeysToDoubleTask4;
                        mapReduceKeysToDoubleTask3 = mapReduceKeysToDoubleTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceValuesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceValuesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceValuesToDoubleTask<K, V> rights;
        final ToDoubleFunction<? super V> transformer;

        MapReduceValuesToDoubleTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceValuesToDoubleTask<K, V> nextRight, ToDoubleFunction<? super V> transformer, double basis, DoubleBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator doubleBinaryOperator;
            ToDoubleFunction<? super V> toDoubleFunction;
            ToDoubleFunction<? super V> toDoubleFunction2 = this.transformer;
            ToDoubleFunction<? super V> toDoubleFunction3 = toDoubleFunction2;
            if (toDoubleFunction2 != null && (doubleBinaryOperator = this.reducer) != null) {
                double d10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toDoubleFunction = toDoubleFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toDoubleFunction = toDoubleFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask = new MapReduceValuesToDoubleTask<>(this, i13, i12, i11, this.tab, this.rights, toDoubleFunction3, d10, doubleBinaryOperator);
                    this.rights = mapReduceValuesToDoubleTask;
                    mapReduceValuesToDoubleTask.fork();
                    toDoubleFunction3 = toDoubleFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        d10 = doubleBinaryOperator.applyAsDouble(d10, toDoubleFunction.applyAsDouble(advance.val));
                    }
                }
                this.result = d10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceValuesToDoubleTask mapReduceValuesToDoubleTask2 = (MapReduceValuesToDoubleTask) firstComplete;
                    MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask2.rights;
                    while (mapReduceValuesToDoubleTask3 != null) {
                        mapReduceValuesToDoubleTask2.result = doubleBinaryOperator.applyAsDouble(mapReduceValuesToDoubleTask2.result, mapReduceValuesToDoubleTask3.result);
                        MapReduceValuesToDoubleTask<K, V> mapReduceValuesToDoubleTask4 = mapReduceValuesToDoubleTask3.nextRight;
                        mapReduceValuesToDoubleTask2.rights = mapReduceValuesToDoubleTask4;
                        mapReduceValuesToDoubleTask3 = mapReduceValuesToDoubleTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceEntriesToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceEntriesToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceEntriesToDoubleTask<K, V> rights;
        final ToDoubleFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToDoubleTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceEntriesToDoubleTask<K, V> nextRight, ToDoubleFunction<Map.Entry<K, V>> transformer, double basis, DoubleBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator reducer;
            ToDoubleFunction<Map.Entry<K, V>> transformer;
            ToDoubleFunction<Map.Entry<K, V>> toDoubleFunction = this.transformer;
            ToDoubleFunction<Map.Entry<K, V>> transformer2 = toDoubleFunction;
            if (toDoubleFunction != null && (reducer = this.reducer) != null) {
                double r10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask = new MapReduceEntriesToDoubleTask<>(this, i11, h10, f10, this.tab, this.rights, transformer2, r10, reducer);
                    this.rights = mapReduceEntriesToDoubleTask;
                    mapReduceEntriesToDoubleTask.fork();
                    transformer2 = transformer2;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> p10 = advance();
                    if (p10 == null) {
                        break;
                    } else {
                        r10 = reducer.applyAsDouble(r10, transformer.applyAsDouble(p10));
                    }
                }
                this.result = r10;
                for (CountedCompleter<?> c4 = firstComplete(); c4 != null; c4 = c4.nextComplete()) {
                    MapReduceEntriesToDoubleTask<K, V> t2 = (MapReduceEntriesToDoubleTask) c4;
                    MapReduceEntriesToDoubleTask<K, V> s2 = t2.rights;
                    while (s2 != null) {
                        t2.result = reducer.applyAsDouble(t2.result, s2.result);
                        MapReduceEntriesToDoubleTask<K, V> mapReduceEntriesToDoubleTask2 = s2.nextRight;
                        t2.rights = mapReduceEntriesToDoubleTask2;
                        s2 = mapReduceEntriesToDoubleTask2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceMappingsToDoubleTask<K, V> extends BulkTask<K, V, Double> {
        final double basis;
        MapReduceMappingsToDoubleTask<K, V> nextRight;
        final DoubleBinaryOperator reducer;
        double result;
        MapReduceMappingsToDoubleTask<K, V> rights;
        final ToDoubleBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToDoubleTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceMappingsToDoubleTask<K, V> nextRight, ToDoubleBiFunction<? super K, ? super V> transformer, double basis, DoubleBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Double getRawResult() {
            return Double.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            DoubleBinaryOperator doubleBinaryOperator;
            ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction;
            ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction2 = this.transformer;
            ToDoubleBiFunction<? super K, ? super V> toDoubleBiFunction3 = toDoubleBiFunction2;
            if (toDoubleBiFunction2 != null && (doubleBinaryOperator = this.reducer) != null) {
                double d10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toDoubleBiFunction = toDoubleBiFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toDoubleBiFunction = toDoubleBiFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask = new MapReduceMappingsToDoubleTask<>(this, i13, i12, i11, this.tab, this.rights, toDoubleBiFunction3, d10, doubleBinaryOperator);
                    this.rights = mapReduceMappingsToDoubleTask;
                    mapReduceMappingsToDoubleTask.fork();
                    toDoubleBiFunction3 = toDoubleBiFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        d10 = doubleBinaryOperator.applyAsDouble(d10, toDoubleBiFunction.applyAsDouble(advance.key, advance.val));
                    }
                }
                this.result = d10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceMappingsToDoubleTask mapReduceMappingsToDoubleTask2 = (MapReduceMappingsToDoubleTask) firstComplete;
                    MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask2.rights;
                    while (mapReduceMappingsToDoubleTask3 != null) {
                        mapReduceMappingsToDoubleTask2.result = doubleBinaryOperator.applyAsDouble(mapReduceMappingsToDoubleTask2.result, mapReduceMappingsToDoubleTask3.result);
                        MapReduceMappingsToDoubleTask<K, V> mapReduceMappingsToDoubleTask4 = mapReduceMappingsToDoubleTask3.nextRight;
                        mapReduceMappingsToDoubleTask2.rights = mapReduceMappingsToDoubleTask4;
                        mapReduceMappingsToDoubleTask3 = mapReduceMappingsToDoubleTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceKeysToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceKeysToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceKeysToLongTask<K, V> rights;
        final ToLongFunction<? super K> transformer;

        MapReduceKeysToLongTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceKeysToLongTask<K, V> nextRight, ToLongFunction<? super K> transformer, long basis, LongBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator longBinaryOperator;
            ToLongFunction<? super K> toLongFunction;
            ToLongFunction<? super K> toLongFunction2 = this.transformer;
            ToLongFunction<? super K> toLongFunction3 = toLongFunction2;
            if (toLongFunction2 != null && (longBinaryOperator = this.reducer) != null) {
                long j10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toLongFunction = toLongFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toLongFunction = toLongFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask = new MapReduceKeysToLongTask<>(this, i13, i12, i11, this.tab, this.rights, toLongFunction3, j10, longBinaryOperator);
                    this.rights = mapReduceKeysToLongTask;
                    mapReduceKeysToLongTask.fork();
                    toLongFunction3 = toLongFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        j10 = longBinaryOperator.applyAsLong(j10, toLongFunction.applyAsLong(advance.key));
                    }
                }
                this.result = j10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceKeysToLongTask mapReduceKeysToLongTask2 = (MapReduceKeysToLongTask) firstComplete;
                    MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask3 = mapReduceKeysToLongTask2.rights;
                    while (mapReduceKeysToLongTask3 != null) {
                        mapReduceKeysToLongTask2.result = longBinaryOperator.applyAsLong(mapReduceKeysToLongTask2.result, mapReduceKeysToLongTask3.result);
                        MapReduceKeysToLongTask<K, V> mapReduceKeysToLongTask4 = mapReduceKeysToLongTask3.nextRight;
                        mapReduceKeysToLongTask2.rights = mapReduceKeysToLongTask4;
                        mapReduceKeysToLongTask3 = mapReduceKeysToLongTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceValuesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceValuesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceValuesToLongTask<K, V> rights;
        final ToLongFunction<? super V> transformer;

        MapReduceValuesToLongTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceValuesToLongTask<K, V> nextRight, ToLongFunction<? super V> transformer, long basis, LongBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator longBinaryOperator;
            ToLongFunction<? super V> toLongFunction;
            ToLongFunction<? super V> toLongFunction2 = this.transformer;
            ToLongFunction<? super V> toLongFunction3 = toLongFunction2;
            if (toLongFunction2 != null && (longBinaryOperator = this.reducer) != null) {
                long j10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toLongFunction = toLongFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toLongFunction = toLongFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask = new MapReduceValuesToLongTask<>(this, i13, i12, i11, this.tab, this.rights, toLongFunction3, j10, longBinaryOperator);
                    this.rights = mapReduceValuesToLongTask;
                    mapReduceValuesToLongTask.fork();
                    toLongFunction3 = toLongFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        j10 = longBinaryOperator.applyAsLong(j10, toLongFunction.applyAsLong(advance.val));
                    }
                }
                this.result = j10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceValuesToLongTask mapReduceValuesToLongTask2 = (MapReduceValuesToLongTask) firstComplete;
                    MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask3 = mapReduceValuesToLongTask2.rights;
                    while (mapReduceValuesToLongTask3 != null) {
                        mapReduceValuesToLongTask2.result = longBinaryOperator.applyAsLong(mapReduceValuesToLongTask2.result, mapReduceValuesToLongTask3.result);
                        MapReduceValuesToLongTask<K, V> mapReduceValuesToLongTask4 = mapReduceValuesToLongTask3.nextRight;
                        mapReduceValuesToLongTask2.rights = mapReduceValuesToLongTask4;
                        mapReduceValuesToLongTask3 = mapReduceValuesToLongTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceEntriesToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceEntriesToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceEntriesToLongTask<K, V> rights;
        final ToLongFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToLongTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceEntriesToLongTask<K, V> nextRight, ToLongFunction<Map.Entry<K, V>> transformer, long basis, LongBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator reducer;
            ToLongFunction<Map.Entry<K, V>> transformer;
            ToLongFunction<Map.Entry<K, V>> toLongFunction = this.transformer;
            ToLongFunction<Map.Entry<K, V>> transformer2 = toLongFunction;
            if (toLongFunction != null && (reducer = this.reducer) != null) {
                long r10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        transformer = transformer2;
                        break;
                    }
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        transformer = transformer2;
                        break;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask = new MapReduceEntriesToLongTask<>(this, i11, h10, f10, this.tab, this.rights, transformer2, r10, reducer);
                    this.rights = mapReduceEntriesToLongTask;
                    mapReduceEntriesToLongTask.fork();
                    transformer2 = transformer2;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> p10 = advance();
                    if (p10 == null) {
                        break;
                    } else {
                        r10 = reducer.applyAsLong(r10, transformer.applyAsLong(p10));
                    }
                }
                this.result = r10;
                for (CountedCompleter<?> c4 = firstComplete(); c4 != null; c4 = c4.nextComplete()) {
                    MapReduceEntriesToLongTask<K, V> t2 = (MapReduceEntriesToLongTask) c4;
                    MapReduceEntriesToLongTask<K, V> s2 = t2.rights;
                    while (s2 != null) {
                        t2.result = reducer.applyAsLong(t2.result, s2.result);
                        MapReduceEntriesToLongTask<K, V> mapReduceEntriesToLongTask2 = s2.nextRight;
                        t2.rights = mapReduceEntriesToLongTask2;
                        s2 = mapReduceEntriesToLongTask2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceMappingsToLongTask<K, V> extends BulkTask<K, V, Long> {
        final long basis;
        MapReduceMappingsToLongTask<K, V> nextRight;
        final LongBinaryOperator reducer;
        long result;
        MapReduceMappingsToLongTask<K, V> rights;
        final ToLongBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToLongTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceMappingsToLongTask<K, V> nextRight, ToLongBiFunction<? super K, ? super V> transformer, long basis, LongBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Long getRawResult() {
            return Long.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            LongBinaryOperator longBinaryOperator;
            ToLongBiFunction<? super K, ? super V> toLongBiFunction;
            ToLongBiFunction<? super K, ? super V> toLongBiFunction2 = this.transformer;
            ToLongBiFunction<? super K, ? super V> toLongBiFunction3 = toLongBiFunction2;
            if (toLongBiFunction2 != null && (longBinaryOperator = this.reducer) != null) {
                long j10 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        toLongBiFunction = toLongBiFunction3;
                        break;
                    }
                    int i11 = this.baseLimit;
                    int i12 = (i11 + i10) >>> 1;
                    if (i12 <= i10) {
                        toLongBiFunction = toLongBiFunction3;
                        break;
                    }
                    addToPendingCount(1);
                    int i13 = this.batch >>> 1;
                    this.batch = i13;
                    this.baseLimit = i12;
                    MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask = new MapReduceMappingsToLongTask<>(this, i13, i12, i11, this.tab, this.rights, toLongBiFunction3, j10, longBinaryOperator);
                    this.rights = mapReduceMappingsToLongTask;
                    mapReduceMappingsToLongTask.fork();
                    toLongBiFunction3 = toLongBiFunction3;
                    i10 = i10;
                }
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        j10 = longBinaryOperator.applyAsLong(j10, toLongBiFunction.applyAsLong(advance.key, advance.val));
                    }
                }
                this.result = j10;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceMappingsToLongTask mapReduceMappingsToLongTask2 = (MapReduceMappingsToLongTask) firstComplete;
                    MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask2.rights;
                    while (mapReduceMappingsToLongTask3 != null) {
                        mapReduceMappingsToLongTask2.result = longBinaryOperator.applyAsLong(mapReduceMappingsToLongTask2.result, mapReduceMappingsToLongTask3.result);
                        MapReduceMappingsToLongTask<K, V> mapReduceMappingsToLongTask4 = mapReduceMappingsToLongTask3.nextRight;
                        mapReduceMappingsToLongTask2.rights = mapReduceMappingsToLongTask4;
                        mapReduceMappingsToLongTask3 = mapReduceMappingsToLongTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceKeysToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceKeysToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceKeysToIntTask<K, V> rights;
        final ToIntFunction<? super K> transformer;

        MapReduceKeysToIntTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceKeysToIntTask<K, V> nextRight, ToIntFunction<? super K> transformer, int basis, IntBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator intBinaryOperator;
            int i10;
            ToIntFunction<? super K> toIntFunction = this.transformer;
            if (toIntFunction != null && (intBinaryOperator = this.reducer) != null) {
                int i11 = this.basis;
                int i12 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        i10 = i11;
                        break;
                    }
                    int i13 = this.baseLimit;
                    int i14 = (i13 + i12) >>> 1;
                    if (i14 <= i12) {
                        i10 = i11;
                        break;
                    }
                    addToPendingCount(1);
                    int i15 = this.batch >>> 1;
                    this.batch = i15;
                    this.baseLimit = i14;
                    MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask = new MapReduceKeysToIntTask<>(this, i15, i14, i13, this.tab, this.rights, toIntFunction, i11, intBinaryOperator);
                    this.rights = mapReduceKeysToIntTask;
                    mapReduceKeysToIntTask.fork();
                    i11 = i11;
                }
                int i16 = i10;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        i16 = intBinaryOperator.applyAsInt(i16, toIntFunction.applyAsInt(advance.key));
                    }
                }
                this.result = i16;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceKeysToIntTask mapReduceKeysToIntTask2 = (MapReduceKeysToIntTask) firstComplete;
                    MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask3 = mapReduceKeysToIntTask2.rights;
                    while (mapReduceKeysToIntTask3 != null) {
                        mapReduceKeysToIntTask2.result = intBinaryOperator.applyAsInt(mapReduceKeysToIntTask2.result, mapReduceKeysToIntTask3.result);
                        MapReduceKeysToIntTask<K, V> mapReduceKeysToIntTask4 = mapReduceKeysToIntTask3.nextRight;
                        mapReduceKeysToIntTask2.rights = mapReduceKeysToIntTask4;
                        mapReduceKeysToIntTask3 = mapReduceKeysToIntTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceValuesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceValuesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceValuesToIntTask<K, V> rights;
        final ToIntFunction<? super V> transformer;

        MapReduceValuesToIntTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceValuesToIntTask<K, V> nextRight, ToIntFunction<? super V> transformer, int basis, IntBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator intBinaryOperator;
            int i10;
            ToIntFunction<? super V> toIntFunction = this.transformer;
            if (toIntFunction != null && (intBinaryOperator = this.reducer) != null) {
                int i11 = this.basis;
                int i12 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        i10 = i11;
                        break;
                    }
                    int i13 = this.baseLimit;
                    int i14 = (i13 + i12) >>> 1;
                    if (i14 <= i12) {
                        i10 = i11;
                        break;
                    }
                    addToPendingCount(1);
                    int i15 = this.batch >>> 1;
                    this.batch = i15;
                    this.baseLimit = i14;
                    MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask = new MapReduceValuesToIntTask<>(this, i15, i14, i13, this.tab, this.rights, toIntFunction, i11, intBinaryOperator);
                    this.rights = mapReduceValuesToIntTask;
                    mapReduceValuesToIntTask.fork();
                    i11 = i11;
                }
                int i16 = i10;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        i16 = intBinaryOperator.applyAsInt(i16, toIntFunction.applyAsInt(advance.val));
                    }
                }
                this.result = i16;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceValuesToIntTask mapReduceValuesToIntTask2 = (MapReduceValuesToIntTask) firstComplete;
                    MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask3 = mapReduceValuesToIntTask2.rights;
                    while (mapReduceValuesToIntTask3 != null) {
                        mapReduceValuesToIntTask2.result = intBinaryOperator.applyAsInt(mapReduceValuesToIntTask2.result, mapReduceValuesToIntTask3.result);
                        MapReduceValuesToIntTask<K, V> mapReduceValuesToIntTask4 = mapReduceValuesToIntTask3.nextRight;
                        mapReduceValuesToIntTask2.rights = mapReduceValuesToIntTask4;
                        mapReduceValuesToIntTask3 = mapReduceValuesToIntTask4;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceEntriesToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceEntriesToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceEntriesToIntTask<K, V> rights;
        final ToIntFunction<Map.Entry<K, V>> transformer;

        MapReduceEntriesToIntTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceEntriesToIntTask<K, V> nextRight, ToIntFunction<Map.Entry<K, V>> transformer, int basis, IntBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator reducer;
            int r10;
            ToIntFunction<Map.Entry<K, V>> transformer = this.transformer;
            if (transformer != null && (reducer = this.reducer) != null) {
                int r11 = this.basis;
                int i10 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        r10 = r11;
                        break;
                    }
                    int f10 = this.baseLimit;
                    int h10 = (f10 + i10) >>> 1;
                    if (h10 <= i10) {
                        r10 = r11;
                        break;
                    }
                    addToPendingCount(1);
                    int i11 = this.batch >>> 1;
                    this.batch = i11;
                    this.baseLimit = h10;
                    MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask = new MapReduceEntriesToIntTask<>(this, i11, h10, f10, this.tab, this.rights, transformer, r11, reducer);
                    this.rights = mapReduceEntriesToIntTask;
                    mapReduceEntriesToIntTask.fork();
                    r11 = r11;
                }
                int r12 = r10;
                while (true) {
                    Node<K, V> p10 = advance();
                    if (p10 == null) {
                        break;
                    } else {
                        r12 = reducer.applyAsInt(r12, transformer.applyAsInt(p10));
                    }
                }
                this.result = r12;
                for (CountedCompleter<?> c4 = firstComplete(); c4 != null; c4 = c4.nextComplete()) {
                    MapReduceEntriesToIntTask<K, V> t2 = (MapReduceEntriesToIntTask) c4;
                    MapReduceEntriesToIntTask<K, V> s2 = t2.rights;
                    while (s2 != null) {
                        t2.result = reducer.applyAsInt(t2.result, s2.result);
                        MapReduceEntriesToIntTask<K, V> mapReduceEntriesToIntTask2 = s2.nextRight;
                        t2.rights = mapReduceEntriesToIntTask2;
                        s2 = mapReduceEntriesToIntTask2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class MapReduceMappingsToIntTask<K, V> extends BulkTask<K, V, Integer> {
        final int basis;
        MapReduceMappingsToIntTask<K, V> nextRight;
        final IntBinaryOperator reducer;
        int result;
        MapReduceMappingsToIntTask<K, V> rights;
        final ToIntBiFunction<? super K, ? super V> transformer;

        MapReduceMappingsToIntTask(BulkTask<K, V, ?> p10, int b4, int i10, int f10, Node<K, V>[] t2, MapReduceMappingsToIntTask<K, V> nextRight, ToIntBiFunction<? super K, ? super V> transformer, int basis, IntBinaryOperator reducer) {
            super(p10, b4, i10, f10, t2);
            this.nextRight = nextRight;
            this.transformer = transformer;
            this.basis = basis;
            this.reducer = reducer;
        }

        @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
        public final Integer getRawResult() {
            return Integer.valueOf(this.result);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            IntBinaryOperator intBinaryOperator;
            int i10;
            ToIntBiFunction<? super K, ? super V> toIntBiFunction = this.transformer;
            if (toIntBiFunction != null && (intBinaryOperator = this.reducer) != null) {
                int i11 = this.basis;
                int i12 = this.baseIndex;
                while (true) {
                    if (this.batch <= 0) {
                        i10 = i11;
                        break;
                    }
                    int i13 = this.baseLimit;
                    int i14 = (i13 + i12) >>> 1;
                    if (i14 <= i12) {
                        i10 = i11;
                        break;
                    }
                    addToPendingCount(1);
                    int i15 = this.batch >>> 1;
                    this.batch = i15;
                    this.baseLimit = i14;
                    MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask = new MapReduceMappingsToIntTask<>(this, i15, i14, i13, this.tab, this.rights, toIntBiFunction, i11, intBinaryOperator);
                    this.rights = mapReduceMappingsToIntTask;
                    mapReduceMappingsToIntTask.fork();
                    i11 = i11;
                }
                int i16 = i10;
                while (true) {
                    Node<K, V> advance = advance();
                    if (advance == null) {
                        break;
                    } else {
                        i16 = intBinaryOperator.applyAsInt(i16, toIntBiFunction.applyAsInt(advance.key, advance.val));
                    }
                }
                this.result = i16;
                for (CountedCompleter<?> firstComplete = firstComplete(); firstComplete != null; firstComplete = firstComplete.nextComplete()) {
                    MapReduceMappingsToIntTask mapReduceMappingsToIntTask2 = (MapReduceMappingsToIntTask) firstComplete;
                    MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask2.rights;
                    while (mapReduceMappingsToIntTask3 != null) {
                        mapReduceMappingsToIntTask2.result = intBinaryOperator.applyAsInt(mapReduceMappingsToIntTask2.result, mapReduceMappingsToIntTask3.result);
                        MapReduceMappingsToIntTask<K, V> mapReduceMappingsToIntTask4 = mapReduceMappingsToIntTask3.nextRight;
                        mapReduceMappingsToIntTask2.rights = mapReduceMappingsToIntTask4;
                        mapReduceMappingsToIntTask3 = mapReduceMappingsToIntTask4;
                    }
                }
            }
        }
    }
}
