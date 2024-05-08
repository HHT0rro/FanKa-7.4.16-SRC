package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import jdk.internal.misc.SharedSecrets;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final VarHandle ALLOCATIONSPINLOCK;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final long serialVersionUID = 5595510919245408276L;
    private volatile transient int allocationSpinLock;
    private transient Comparator<? super E> comparator;
    private final ReentrantLock lock;
    private final Condition notEmpty;

    /* renamed from: q, reason: collision with root package name */
    private PriorityQueue<E> f50501q;
    private transient Object[] queue;
    private transient int size;

    public PriorityBlockingQueue() {
        this(11, null);
    }

    public PriorityBlockingQueue(int initialCapacity) {
        this(initialCapacity, null);
    }

    public PriorityBlockingQueue(int initialCapacity, Comparator<? super E> comparator) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.comparator = comparator;
        this.queue = new Object[Math.max(1, initialCapacity)];
    }

    public PriorityBlockingQueue(Collection<? extends E> c4) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        boolean heapify = true;
        boolean screen = true;
        if (c4 instanceof SortedSet) {
            SortedSet<? extends E> ss = (SortedSet) c4;
            this.comparator = ss.comparator();
            heapify = false;
        } else if (c4 instanceof PriorityBlockingQueue) {
            PriorityBlockingQueue<? extends E> pq = (PriorityBlockingQueue) c4;
            this.comparator = pq.comparator();
            screen = false;
            if (pq.getClass() == PriorityBlockingQueue.class) {
                heapify = false;
            }
        }
        Object[] es = c4.toArray();
        int n10 = es.length;
        es = es.getClass() != Object[].class ? Arrays.copyOf(es, n10, Object[].class) : es;
        if (screen && (n10 == 1 || this.comparator != null)) {
            for (Object e2 : es) {
                if (e2 == null) {
                    throw new NullPointerException();
                }
            }
        }
        this.queue = ensureNonEmpty(es);
        this.size = n10;
        if (heapify) {
            heapify();
        }
    }

    private static Object[] ensureNonEmpty(Object[] es) {
        return es.length > 0 ? es : new Object[1];
    }

    private void tryGrow(Object[] array, int oldCap) {
        int growth;
        this.lock.unlock();
        Object[] newArray = null;
        if (this.allocationSpinLock == 0 && (boolean) ALLOCATIONSPINLOCK.compareAndSet(this, 0, 1)) {
            if (oldCap < 64) {
                growth = oldCap + 2;
            } else {
                growth = oldCap >> 1;
            }
            try {
                int newCap = ArraysSupport.newLength(oldCap, 1, growth);
                if (this.queue == array) {
                    newArray = new Object[newCap];
                }
            } finally {
                this.allocationSpinLock = 0;
            }
        }
        if (newArray == null) {
            Thread.yield();
        }
        this.lock.lock();
        if (newArray != null && this.queue == array) {
            this.queue = newArray;
            System.arraycopy(array, 0, newArray, 0, oldCap);
        }
    }

    private E dequeue() {
        Object[] objArr = this.queue;
        E e2 = (E) objArr[0];
        if (e2 != null) {
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

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return offer(e2);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        int n10;
        Object[] es;
        if (e2 == null) {
            throw new NullPointerException();
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        while (true) {
            n10 = this.size;
            es = this.queue;
            int cap = es.length;
            if (n10 >= cap) {
                tryGrow(es, cap);
            } else {
                try {
                    break;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }
        }
        Comparator<? super E> cmp = this.comparator;
        if (cmp == null) {
            siftUpComparable(n10, e2, es);
        } else {
            siftUpUsingComparator(n10, e2, es, cmp);
        }
        this.size = n10 + 1;
        this.notEmpty.signal();
        lock.unlock();
        return true;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) {
        offer(e2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) {
        return offer(e2);
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (true) {
            try {
                E result = dequeue();
                if (result != null) {
                    return result;
                }
                this.notEmpty.await();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E result;
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (true) {
            try {
                result = dequeue();
                if (result != null || nanos <= 0) {
                    break;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                lock.unlock();
            }
        }
        return result;
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return (E) this.queue[0];
        } finally {
            reentrantLock.unlock();
        }
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.size;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
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

    private void removeAt(int i10) {
        Object[] es = this.queue;
        int n10 = this.size - 1;
        if (n10 == i10) {
            es[i10] = null;
        } else {
            Object obj = es[n10];
            es[n10] = null;
            Comparator<? super E> cmp = this.comparator;
            if (cmp == null) {
                siftDownComparable(i10, obj, es, n10);
            } else {
                siftDownUsingComparator(i10, obj, es, n10, cmp);
            }
            if (es[i10] == obj) {
                if (cmp == null) {
                    siftUpComparable(i10, obj, es);
                } else {
                    siftUpUsingComparator(i10, obj, es, cmp);
                }
            }
        }
        this.size = n10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int i10 = indexOf(o10);
            if (i10 != -1) {
                removeAt(i10);
                lock.unlock();
                return true;
            }
            lock.unlock();
            return false;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
    
        removeAt(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void removeEq(java.lang.Object r6) {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.lock
            r0.lock()
            java.lang.Object[] r1 = r5.queue     // Catch: java.lang.Throwable -> L1c
            r2 = 0
            int r3 = r5.size     // Catch: java.lang.Throwable -> L1c
        La:
            if (r2 >= r3) goto L17
            r4 = r1[r2]     // Catch: java.lang.Throwable -> L1c
            if (r6 != r4) goto L14
            r5.removeAt(r2)     // Catch: java.lang.Throwable -> L1c
            goto L17
        L14:
            int r2 = r2 + 1
            goto La
        L17:
            r0.unlock()
            return
        L1c:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.PriorityBlockingQueue.removeEq(java.lang.Object):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return indexOf(o10) != -1;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return Helpers.collectionToString(this);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c4) {
        return drainTo(c4, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c4, int maxElements) {
        Objects.requireNonNull(c4);
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        if (maxElements <= 0) {
            return 0;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n10 = Math.min(this.size, maxElements);
            for (int i10 = 0; i10 < n10; i10++) {
                c4.add(this.queue[0]);
                dequeue();
            }
            return n10;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] es = this.queue;
            int n10 = this.size;
            for (int i10 = 0; i10 < n10; i10++) {
                es[i10] = null;
            }
            this.size = 0;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return Arrays.copyOf(this.queue, this.size);
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            if (tArr.length < i10) {
                return (T[]) Arrays.copyOf(this.queue, i10, tArr.getClass());
            }
            System.arraycopy(this.queue, 0, tArr, 0, i10);
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr(toArray());
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class Itr implements Iterator<E> {
        final Object[] array;
        int cursor;
        int lastRet = -1;

        Itr(Object[] array) {
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.array.length;
        }

        @Override // java.util.Iterator
        public E next() {
            int i10 = this.cursor;
            Object[] objArr = this.array;
            if (i10 >= objArr.length) {
                throw new NoSuchElementException();
            }
            this.cursor = i10 + 1;
            this.lastRet = i10;
            return (E) objArr[i10];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.lastRet;
            if (i10 < 0) {
                throw new IllegalStateException();
            }
            PriorityBlockingQueue.this.removeEq(this.array[i10]);
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            Object[] es = this.array;
            int i10 = this.cursor;
            if (i10 < es.length) {
                this.lastRet = -1;
                this.cursor = es.length;
                for (int i11 = i10; i11 < es.length; i11++) {
                    action.accept(es[i11]);
                }
                this.lastRet = es.length - 1;
            }
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        this.lock.lock();
        try {
            PriorityQueue<E> priorityQueue = new PriorityQueue<>(Math.max(this.size, 1), this.comparator);
            this.f50501q = priorityQueue;
            priorityQueue.addAll(this);
            s2.defaultWriteObject();
        } finally {
            this.f50501q = null;
            this.lock.unlock();
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        try {
            s2.defaultReadObject();
            int sz = this.f50501q.size();
            SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, sz);
            this.queue = new Object[Math.max(1, sz)];
            this.comparator = this.f50501q.comparator();
            addAll(this.f50501q);
        } finally {
            this.f50501q = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class PBQSpliterator implements Spliterator<E> {
        Object[] array;
        int fence;
        int index;

        PBQSpliterator() {
        }

        PBQSpliterator(Object[] array, int index, int fence) {
            this.array = array;
            this.index = index;
            this.fence = fence;
        }

        private int getFence() {
            if (this.array == null) {
                Object[] array = PriorityBlockingQueue.this.toArray();
                this.array = array;
                this.fence = array.length;
            }
            return this.fence;
        }

        @Override // java.util.Spliterator
        public PriorityBlockingQueue<E>.PBQSpliterator trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            PriorityBlockingQueue priorityBlockingQueue = PriorityBlockingQueue.this;
            Object[] objArr = this.array;
            this.index = mid;
            return new PBQSpliterator(objArr, lo, mid);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            int hi = getFence();
            int lo = this.index;
            Object[] es = this.array;
            this.index = hi;
            for (int i10 = lo; i10 < hi; i10++) {
                action.accept(es[i10]);
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            int fence = getFence();
            int i10 = this.index;
            if (fence > i10 && i10 >= 0) {
                Object[] objArr = this.array;
                this.index = i10 + 1;
                action.accept(objArr[i10]);
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

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new PBQSpliterator();
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.PriorityBlockingQueue$$ExternalSyntheticLambda1
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.PriorityBlockingQueue$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return PriorityBlockingQueue.lambda$retainAll$1(Collection.this, obj);
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
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] es = this.queue;
            int end = this.size;
            int i10 = 0;
            while (i10 < end && !filter.test(es[i10])) {
                i10++;
            }
            if (i10 >= end) {
                return false;
            }
            int beg = i10;
            long[] deathRow = nBits(end - beg);
            deathRow[0] = 1;
            for (int i11 = beg + 1; i11 < end; i11++) {
                if (filter.test(es[i11])) {
                    setBit(deathRow, i11 - beg);
                }
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
            lock.unlock();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] es = this.queue;
            int n10 = this.size;
            for (int i10 = 0; i10 < n10; i10++) {
                action.accept(es[i10]);
            }
        } finally {
            lock.unlock();
        }
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            ALLOCATIONSPINLOCK = l10.findVarHandle(PriorityBlockingQueue.class, "allocationSpinLock", Integer.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
