package java.util;

import android.compat.Compatibility;
import dalvik.system.VMRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import jdk.internal.misc.SharedSecrets;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    public static final long PRIORITY_QUEUE_OFFER_NON_COMPARABLE_ONE_ELEMENT = 289878283;
    private static final long serialVersionUID = -7720805057305804111L;
    private final Comparator<? super E> comparator;
    transient int modCount;
    transient Object[] queue;
    int size;

    public PriorityQueue() {
        this(11, null);
    }

    public PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityQueue(Comparator<? super E> comparator) {
        this(11, comparator);
    }

    public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public PriorityQueue(Collection<? extends E> c4) {
        if (c4 instanceof SortedSet) {
            SortedSet<? extends E> ss = (SortedSet) c4;
            this.comparator = ss.comparator();
            initElementsFromCollection(ss);
        } else if (c4 instanceof PriorityQueue) {
            PriorityQueue<? extends E> pq = (PriorityQueue) c4;
            this.comparator = pq.comparator();
            initFromPriorityQueue(pq);
        } else {
            this.comparator = null;
            initFromCollection(c4);
        }
    }

    public PriorityQueue(PriorityQueue<? extends E> priorityQueue) {
        this.comparator = priorityQueue.comparator();
        initFromPriorityQueue(priorityQueue);
    }

    public PriorityQueue(SortedSet<? extends E> sortedSet) {
        this.comparator = sortedSet.comparator();
        initElementsFromCollection(sortedSet);
    }

    private static Object[] ensureNonEmpty(Object[] es) {
        return es.length > 0 ? es : new Object[1];
    }

    private void initFromPriorityQueue(PriorityQueue<? extends E> c4) {
        if (c4.getClass() == PriorityQueue.class) {
            this.queue = ensureNonEmpty(c4.toArray());
            this.size = c4.size();
        } else {
            initFromCollection(c4);
        }
    }

    private void initElementsFromCollection(Collection<? extends E> c4) {
        Object[] es = c4.toArray();
        int len = es.length;
        if (c4.getClass() != ArrayList.class) {
            es = Arrays.copyOf(es, len, Object[].class);
        }
        if (len == 1 || this.comparator != null) {
            for (Object e2 : es) {
                if (e2 == null) {
                    throw new NullPointerException();
                }
            }
        }
        this.queue = ensureNonEmpty(es);
        this.size = len;
    }

    private void initFromCollection(Collection<? extends E> c4) {
        initElementsFromCollection(c4);
        heapify();
    }

    private void grow(int minCapacity) {
        int oldCapacity = this.queue.length;
        int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity - oldCapacity, oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);
        this.queue = Arrays.copyOf(this.queue, newCapacity);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return offer(e2);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        this.modCount++;
        int i10 = this.size;
        if (i10 >= this.queue.length) {
            grow(i10 + 1);
        }
        if (i10 == 0) {
            boolean usePreAndroidUBehavior = VMRuntime.getSdkVersion() < 34 || !Compatibility.isChangeEnabled(PRIORITY_QUEUE_OFFER_NON_COMPARABLE_ONE_ELEMENT);
            if (usePreAndroidUBehavior) {
                this.queue[0] = e2;
            } else {
                siftUp(i10, e2);
            }
        } else {
            siftUp(i10, e2);
        }
        this.size = i10 + 1;
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        return (E) this.queue[0];
    }

    private int indexOf(Object o10) {
        if (o10 != null) {
            Object[] es = this.queue;
            int n10 = this.size;
            for (int i10 = 0; i10 < n10; i10++) {
                if (o10.equals(es[i10])) {
                    return i10;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        int i10 = indexOf(o10);
        if (i10 == -1) {
            return false;
        }
        removeAt(i10);
        return true;
    }

    void removeEq(Object o10) {
        Object[] es = this.queue;
        int n10 = this.size;
        for (int i10 = 0; i10 < n10; i10++) {
            if (o10 == es[i10]) {
                removeAt(i10);
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return indexOf(o10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int i10 = this.size;
        if (tArr.length < i10) {
            return (T[]) Arrays.copyOf(this.queue, i10, tArr.getClass());
        }
        System.arraycopy(this.queue, 0, tArr, 0, i10);
        if (tArr.length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private final class Itr implements Iterator<E> {
        private int cursor;
        private int expectedModCount;
        private ArrayDeque<E> forgetMeNot;
        private int lastRet = -1;
        private E lastRetElt;

        Itr() {
            this.expectedModCount = PriorityQueue.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            ArrayDeque<E> arrayDeque;
            return this.cursor < PriorityQueue.this.size || !((arrayDeque = this.forgetMeNot) == null || arrayDeque.isEmpty());
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.expectedModCount != PriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.cursor < PriorityQueue.this.size) {
                Object[] objArr = PriorityQueue.this.queue;
                int i10 = this.cursor;
                this.cursor = i10 + 1;
                this.lastRet = i10;
                return (E) objArr[i10];
            }
            ArrayDeque<E> arrayDeque = this.forgetMeNot;
            if (arrayDeque != null) {
                this.lastRet = -1;
                E poll = arrayDeque.poll();
                this.lastRetElt = poll;
                if (poll != null) {
                    return poll;
                }
            }
            throw new NoSuchElementException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            if (this.expectedModCount != PriorityQueue.this.modCount) {
                throw new ConcurrentModificationException();
            }
            int i10 = this.lastRet;
            if (i10 != -1) {
                Object removeAt = PriorityQueue.this.removeAt(i10);
                this.lastRet = -1;
                if (removeAt == null) {
                    this.cursor--;
                } else {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque<>();
                    }
                    this.forgetMeNot.add(removeAt);
                }
            } else {
                E e2 = this.lastRetElt;
                if (e2 != null) {
                    PriorityQueue.this.removeEq(e2);
                    this.lastRetElt = null;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.expectedModCount = PriorityQueue.this.modCount;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Object[] es = this.queue;
        int n10 = this.size;
        for (int i10 = 0; i10 < n10; i10++) {
            es[i10] = null;
        }
        this.size = 0;
    }

    @Override // java.util.Queue
    public E poll() {
        Object[] objArr = this.queue;
        E e2 = (E) objArr[0];
        if (e2 != null) {
            this.modCount++;
            int i10 = this.size - 1;
            this.size = i10;
            Object obj = objArr[i10];
            objArr[i10] = null;
            if (i10 > 0) {
                Comparator<? super E> comparator = this.comparator;
                if (comparator == null) {
                    siftDownComparable(0, obj, objArr, i10);
                } else {
                    siftDownUsingComparator(0, obj, objArr, i10, comparator);
                }
            }
        }
        return e2;
    }

    E removeAt(int i10) {
        Object[] objArr = this.queue;
        this.modCount++;
        int i11 = this.size - 1;
        this.size = i11;
        if (i11 == i10) {
            objArr[i10] = null;
        } else {
            E e2 = (E) objArr[i11];
            objArr[i11] = null;
            siftDown(i10, e2);
            if (objArr[i10] == e2) {
                siftUp(i10, e2);
                if (objArr[i10] != e2) {
                    return e2;
                }
            }
        }
        return null;
    }

    private void siftUp(int k10, E x10) {
        Comparator<? super E> comparator = this.comparator;
        if (comparator != null) {
            siftUpUsingComparator(k10, x10, this.queue, comparator);
        } else {
            siftUpComparable(k10, x10, this.queue);
        }
    }

    private static <T> void siftUpComparable(int k10, T x10, Object[] objArr) {
        Comparable<? super T> key = (Comparable) x10;
        while (k10 > 0) {
            int parent = (k10 - 1) >>> 1;
            Object e2 = objArr[parent];
            if (key.compareTo(e2) >= 0) {
                break;
            }
            objArr[k10] = e2;
            k10 = parent;
        }
        objArr[k10] = key;
    }

    private static <T> void siftUpUsingComparator(int k10, T x10, Object[] es, Comparator<? super T> cmp) {
        while (k10 > 0) {
            int parent = (k10 - 1) >>> 1;
            Object e2 = es[parent];
            if (cmp.compare(x10, e2) >= 0) {
                break;
            }
            es[k10] = e2;
            k10 = parent;
        }
        es[k10] = x10;
    }

    private void siftDown(int k10, E x10) {
        Comparator<? super E> comparator = this.comparator;
        if (comparator != null) {
            siftDownUsingComparator(k10, x10, this.queue, this.size, comparator);
        } else {
            siftDownComparable(k10, x10, this.queue, this.size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void siftDownComparable(int k10, T x10, Object[] objArr, int n10) {
        Comparable<? super T> key = (Comparable) x10;
        int half = n10 >>> 1;
        while (k10 < half) {
            int child = (k10 << 1) + 1;
            Object c4 = objArr[child];
            int right = child + 1;
            if (right < n10 && ((Comparable) c4).compareTo(objArr[right]) > 0) {
                child = right;
                c4 = objArr[right];
            }
            if (key.compareTo(c4) <= 0) {
                break;
            }
            objArr[k10] = c4;
            k10 = child;
        }
        objArr[k10] = key;
    }

    private static <T> void siftDownUsingComparator(int k10, T x10, Object[] es, int n10, Comparator<? super T> cmp) {
        int half = n10 >>> 1;
        while (k10 < half) {
            int child = (k10 << 1) + 1;
            Object c4 = es[child];
            int right = child + 1;
            if (right < n10 && cmp.compare(c4, es[right]) > 0) {
                child = right;
                c4 = es[right];
            }
            if (cmp.compare(x10, c4) <= 0) {
                break;
            }
            es[k10] = c4;
            k10 = child;
        }
        es[k10] = x10;
    }

    private void heapify() {
        Object[] es = this.queue;
        int n10 = this.size;
        int i10 = (n10 >>> 1) - 1;
        Comparator<? super E> cmp = this.comparator;
        if (cmp == null) {
            while (i10 >= 0) {
                siftDownComparable(i10, es[i10], es, n10);
                i10--;
            }
        } else {
            while (i10 >= 0) {
                siftDownUsingComparator(i10, es[i10], es, n10, cmp);
                i10--;
            }
        }
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(Math.max(2, this.size + 1));
        Object[] es = this.queue;
        int n10 = this.size;
        for (int i10 = 0; i10 < n10; i10++) {
            s2.writeObject(es[i10]);
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        s2.readInt();
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, this.size);
        Object[] es = new Object[Math.max(this.size, 1)];
        this.queue = es;
        int n10 = this.size;
        for (int i10 = 0; i10 < n10; i10++) {
            es[i10] = s2.readObject();
        }
        heapify();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator<E> spliterator() {
        return new PriorityQueueSpliterator(0, -1, 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class PriorityQueueSpliterator implements Spliterator<E> {
        private int expectedModCount;
        private int fence;
        private int index;

        PriorityQueueSpliterator(int origin, int fence, int expectedModCount) {
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() {
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            this.expectedModCount = PriorityQueue.this.modCount;
            int hi2 = PriorityQueue.this.size;
            this.fence = hi2;
            return hi2;
        }

        @Override // java.util.Spliterator
        public PriorityQueue<E>.PriorityQueueSpliterator trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            PriorityQueue priorityQueue = PriorityQueue.this;
            this.index = mid;
            return new PriorityQueueSpliterator(lo, mid, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.fence < 0) {
                this.fence = PriorityQueue.this.size;
                this.expectedModCount = PriorityQueue.this.modCount;
            }
            Object[] es = PriorityQueue.this.queue;
            int hi = this.fence;
            this.index = hi;
            for (int i10 = this.index; i10 < hi; i10++) {
                Object obj = es[i10];
                if (obj == null) {
                    break;
                }
                action.accept(obj);
            }
            if (PriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.fence < 0) {
                this.fence = PriorityQueue.this.size;
                this.expectedModCount = PriorityQueue.this.modCount;
            }
            int i10 = this.index;
            if (i10 < this.fence) {
                this.index = i10 + 1;
                Object obj = PriorityQueue.this.queue[i10];
                if (obj == null || PriorityQueue.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                action.accept(obj);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getFence() - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16704;
        }
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.PriorityQueue$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = Collection.this.contains(obj);
                return contains;
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.PriorityQueue$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PriorityQueue.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    private static long[] nBits(int n10) {
        return new long[((n10 - 1) >> 6) + 1];
    }

    private static void setBit(long[] bits, int i10) {
        int i11 = i10 >> 6;
        bits[i11] = bits[i11] | (1 << i10);
    }

    private static boolean isClear(long[] bits, int i10) {
        return (bits[i10 >> 6] & (1 << i10)) == 0;
    }

    private boolean bulkRemove(Predicate<? super E> filter) {
        int expectedModCount = this.modCount + 1;
        this.modCount = expectedModCount;
        Object[] es = this.queue;
        int end = this.size;
        int i10 = 0;
        while (i10 < end && !filter.test(es[i10])) {
            i10++;
        }
        if (i10 >= end) {
            if (this.modCount == expectedModCount) {
                return false;
            }
            throw new ConcurrentModificationException();
        }
        int beg = i10;
        long[] deathRow = nBits(end - beg);
        deathRow[0] = 1;
        for (int i11 = beg + 1; i11 < end; i11++) {
            if (filter.test(es[i11])) {
                setBit(deathRow, i11 - beg);
            }
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        int w3 = beg;
        for (int i12 = beg; i12 < end; i12++) {
            if (isClear(deathRow, i12 - beg)) {
                es[w3] = es[i12];
                w3++;
            }
        }
        this.size = w3;
        for (int i13 = w3; i13 < end; i13++) {
            es[i13] = null;
        }
        heapify();
        return true;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        int expectedModCount = this.modCount;
        Object[] es = this.queue;
        int n10 = this.size;
        for (int i10 = 0; i10 < n10; i10++) {
            action.accept(es[i10]);
        }
        int i11 = this.modCount;
        if (expectedModCount != i11) {
            throw new ConcurrentModificationException();
        }
    }
}
