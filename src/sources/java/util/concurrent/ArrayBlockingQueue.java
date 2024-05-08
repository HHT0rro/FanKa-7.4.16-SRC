package java.util.concurrent;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final long serialVersionUID = -817911632652898426L;
    int count;
    final Object[] items;
    transient ArrayBlockingQueue<E>.Itrs itrs;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    int putIndex;
    int takeIndex;

    static final int inc(int i10, int modulus) {
        int i11 = i10 + 1;
        if (i11 >= modulus) {
            return 0;
        }
        return i11;
    }

    static final int dec(int i10, int modulus) {
        int i11 = i10 - 1;
        if (i11 < 0) {
            int i12 = modulus - 1;
            return i12;
        }
        return i11;
    }

    final E itemAt(int i10) {
        return (E) this.items[i10];
    }

    static <E> E itemAt(Object[] objArr, int i10) {
        return (E) objArr[i10];
    }

    private void enqueue(E e2) {
        Object[] items = this.items;
        int i10 = this.putIndex;
        items[i10] = e2;
        int i11 = i10 + 1;
        this.putIndex = i11;
        if (i11 == items.length) {
            this.putIndex = 0;
        }
        this.count++;
        this.notEmpty.signal();
    }

    private E dequeue() {
        Object[] objArr = this.items;
        int i10 = this.takeIndex;
        E e2 = (E) objArr[i10];
        objArr[i10] = null;
        int i11 = i10 + 1;
        this.takeIndex = i11;
        if (i11 == objArr.length) {
            this.takeIndex = 0;
        }
        this.count--;
        ArrayBlockingQueue<E>.Itrs itrs = this.itrs;
        if (itrs != null) {
            itrs.elementDequeued();
        }
        this.notFull.signal();
        return e2;
    }

    void removeAt(int removeIndex) {
        int pred;
        Object[] items = this.items;
        int i10 = this.takeIndex;
        if (removeIndex == i10) {
            items[i10] = null;
            int i11 = i10 + 1;
            this.takeIndex = i11;
            if (i11 == items.length) {
                this.takeIndex = 0;
            }
            this.count--;
            ArrayBlockingQueue<E>.Itrs itrs = this.itrs;
            if (itrs != null) {
                itrs.elementDequeued();
            }
        } else {
            int i12 = removeIndex;
            int putIndex = this.putIndex;
            while (true) {
                pred = i12;
                i12++;
                if (i12 == items.length) {
                    i12 = 0;
                }
                if (i12 == putIndex) {
                    break;
                } else {
                    items[pred] = items[i12];
                }
            }
            items[pred] = null;
            this.putIndex = pred;
            int i13 = this.count;
            this.count = i13 - 1;
            ArrayBlockingQueue<E>.Itrs itrs2 = this.itrs;
            if (itrs2 != null) {
                itrs2.removedAt(removeIndex);
            }
        }
        this.notFull.signal();
    }

    public ArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    public ArrayBlockingQueue(int capacity, boolean fair) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.items = new Object[capacity];
        ReentrantLock reentrantLock = new ReentrantLock(fair);
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
    }

    public ArrayBlockingQueue(int capacity, boolean fair, Collection<? extends E> c4) {
        this(capacity, fair);
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] items = this.items;
            int i10 = 0;
            try {
                for (E e2 : c4) {
                    int i11 = i10 + 1;
                    try {
                        items[i10] = Objects.requireNonNull(e2);
                        i10 = i11;
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        throw new IllegalArgumentException();
                    }
                }
                this.count = i10;
                this.putIndex = i10 == capacity ? 0 : i10;
            } catch (ArrayIndexOutOfBoundsException e11) {
            }
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return super.add(e2);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2);
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (this.count != this.items.length) {
                enqueue(e2);
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

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                this.notFull.await();
            } finally {
                lock.unlock();
            }
        }
        enqueue(e2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        Objects.requireNonNull(e2);
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (this.count == this.items.length) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    lock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }
        enqueue(e2);
        lock.unlock();
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.count == 0 ? null : dequeue();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (this.count == 0) {
            try {
                this.notEmpty.await();
            } finally {
                lock.unlock();
            }
        }
        return dequeue();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (this.count == 0) {
            try {
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    lock.unlock();
                    return null;
                }
            } finally {
                lock.unlock();
            }
        }
        return dequeue();
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return itemAt(this.takeIndex);
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.count;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.items.length - this.count;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        if (o10 == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (this.count > 0) {
                Object[] items = this.items;
                int i10 = this.takeIndex;
                int end = this.putIndex;
                int to = i10 < end ? end : items.length;
                while (true) {
                    if (i10 < to) {
                        if (!o10.equals(items[i10])) {
                            i10++;
                        } else {
                            removeAt(i10);
                            lock.unlock();
                            return true;
                        }
                    } else {
                        if (to == end) {
                            break;
                        }
                        i10 = 0;
                        to = end;
                    }
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (this.count > 0) {
                Object[] items = this.items;
                int i10 = this.takeIndex;
                int end = this.putIndex;
                int to = i10 < end ? end : items.length;
                while (true) {
                    if (i10 < to) {
                        if (!o10.equals(items[i10])) {
                            i10++;
                        } else {
                            lock.unlock();
                            return true;
                        }
                    } else {
                        if (to == end) {
                            break;
                        }
                        i10 = 0;
                        to = end;
                    }
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] items = this.items;
            int i10 = this.takeIndex;
            int end = this.count + i10;
            Object[] a10 = Arrays.copyOfRange(items, i10, end);
            int i11 = this.putIndex;
            if (end != i11) {
                System.arraycopy(items, 0, a10, items.length - this.takeIndex, i11);
            }
            return a10;
        } finally {
            lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] a10) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] items = this.items;
            int count = this.count;
            int firstLeg = Math.min(items.length - this.takeIndex, count);
            if (a10.length < count) {
                int i10 = this.takeIndex;
                a10 = Arrays.copyOfRange(items, i10, i10 + count, a10.getClass());
            } else {
                System.arraycopy(items, this.takeIndex, a10, 0, firstLeg);
                if (a10.length > count) {
                    a10[count] = null;
                }
            }
            if (firstLeg < count) {
                System.arraycopy(items, 0, a10, firstLeg, this.putIndex);
            }
            return a10;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return Helpers.collectionToString(this);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int i10 = this.count;
            if (i10 > 0) {
                circularClear(this.items, this.takeIndex, this.putIndex);
                this.takeIndex = this.putIndex;
                this.count = 0;
                ArrayBlockingQueue<E>.Itrs itrs = this.itrs;
                if (itrs != null) {
                    itrs.queueIsEmpty();
                }
                for (int k10 = i10; k10 > 0; k10--) {
                    if (!lock.hasWaiters(this.notFull)) {
                        break;
                    }
                    this.notFull.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private static void circularClear(Object[] items, int i10, int end) {
        int to = i10 < end ? end : items.length;
        while (true) {
            if (i10 < to) {
                items[i10] = null;
                i10++;
            } else if (to != end) {
                i10 = 0;
                to = end;
            } else {
                return;
            }
        }
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
        Object[] items = this.items;
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            int n10 = Math.min(maxElements, this.count);
            int take = this.takeIndex;
            int i10 = 0;
            while (i10 < n10) {
                try {
                    c4.add(items[take]);
                    items[take] = null;
                    take++;
                    if (take == items.length) {
                        take = 0;
                    }
                    i10++;
                } catch (Throwable th) {
                    if (i10 > 0) {
                        int i11 = this.count - i10;
                        this.count = i11;
                        this.takeIndex = take;
                        ArrayBlockingQueue<E>.Itrs itrs = this.itrs;
                        if (itrs != null) {
                            if (i11 == 0) {
                                itrs.queueIsEmpty();
                            } else if (i10 > take) {
                                itrs.takeIndexWrapped();
                            }
                        }
                        while (i10 > 0 && lock.hasWaiters(this.notFull)) {
                            this.notFull.signal();
                            i10--;
                        }
                    }
                    throw th;
                }
            }
            if (i10 > 0) {
                int i12 = this.count - i10;
                this.count = i12;
                this.takeIndex = take;
                ArrayBlockingQueue<E>.Itrs itrs2 = this.itrs;
                if (itrs2 != null) {
                    if (i12 == 0) {
                        itrs2.queueIsEmpty();
                    } else if (i10 > take) {
                        itrs2.takeIndexWrapped();
                    }
                }
                while (i10 > 0 && lock.hasWaiters(this.notFull)) {
                    this.notFull.signal();
                    i10--;
                }
            }
            return n10;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Itrs {
        private static final int LONG_SWEEP_PROBES = 16;
        private static final int SHORT_SWEEP_PROBES = 4;
        int cycles;
        private ArrayBlockingQueue<E>.Itrs.Node head;
        private ArrayBlockingQueue<E>.Itrs.Node sweeper;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class Node extends WeakReference<ArrayBlockingQueue<E>.Itr> {
            ArrayBlockingQueue<E>.Itrs.Node next;

            Node(ArrayBlockingQueue<E>.Itr iterator, ArrayBlockingQueue<E>.Itrs.Node next) {
                super(iterator);
                this.next = next;
            }
        }

        Itrs(ArrayBlockingQueue<E>.Itr initial) {
            register(initial);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            if (r3 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        
            r5 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            r9.sweeper = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void doSomeSweeping(boolean r10) {
            /*
                r9 = this;
                if (r10 == 0) goto L5
                r0 = 16
                goto L6
            L5:
                r0 = 4
            L6:
                java.util.concurrent.ArrayBlockingQueue<E>$Itrs$Node r1 = r9.sweeper
                if (r1 != 0) goto Lf
                r2 = 0
                java.util.concurrent.ArrayBlockingQueue<E>$Itrs$Node r3 = r9.head
                r4 = 1
                goto L13
            Lf:
                r2 = r1
                java.util.concurrent.ArrayBlockingQueue<E>$Itrs$Node r3 = r2.next
                r4 = 0
            L13:
                r5 = 0
                if (r0 <= 0) goto L4a
                if (r3 != 0) goto L1f
                if (r4 == 0) goto L1b
                goto L4a
            L1b:
                r2 = 0
                java.util.concurrent.ArrayBlockingQueue<E>$Itrs$Node r3 = r9.head
                r4 = 1
            L1f:
                java.lang.Object r6 = r3.get()
                java.util.concurrent.ArrayBlockingQueue$Itr r6 = (java.util.concurrent.ArrayBlockingQueue.Itr) r6
                java.util.concurrent.ArrayBlockingQueue<E>$Itrs$Node r7 = r3.next
                if (r6 == 0) goto L32
                boolean r8 = r6.isDetached()
                if (r8 == 0) goto L30
                goto L32
            L30:
                r2 = r3
                goto L46
            L32:
                r0 = 16
                r3.clear()
                r3.next = r5
                if (r2 != 0) goto L44
                r9.head = r7
                if (r7 != 0) goto L46
                java.util.concurrent.ArrayBlockingQueue r8 = java.util.concurrent.ArrayBlockingQueue.this
                r8.itrs = r5
                return
            L44:
                r2.next = r7
            L46:
                r3 = r7
                int r0 = r0 + (-1)
                goto L13
            L4a:
                if (r3 != 0) goto L4d
                goto L4e
            L4d:
                r5 = r2
            L4e:
                r9.sweeper = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ArrayBlockingQueue.Itrs.doSomeSweeping(boolean):void");
        }

        void register(ArrayBlockingQueue<E>.Itr itr) {
            this.head = new Node(itr, this.head);
        }

        void takeIndexWrapped() {
            this.cycles++;
            ArrayBlockingQueue<E>.Itrs.Node o10 = null;
            ArrayBlockingQueue<E>.Itrs.Node p10 = this.head;
            while (p10 != null) {
                ArrayBlockingQueue<E>.Itr it = p10.get();
                ArrayBlockingQueue<E>.Itrs.Node next = p10.next;
                if (it == null || it.takeIndexWrapped()) {
                    p10.clear();
                    p10.next = null;
                    if (o10 == null) {
                        this.head = next;
                    } else {
                        o10.next = next;
                    }
                } else {
                    o10 = p10;
                }
                p10 = next;
            }
            ArrayBlockingQueue<E>.Itrs.Node o11 = this.head;
            if (o11 == null) {
                ArrayBlockingQueue.this.itrs = null;
            }
        }

        void removedAt(int removedIndex) {
            ArrayBlockingQueue<E>.Itrs.Node o10 = null;
            ArrayBlockingQueue<E>.Itrs.Node p10 = this.head;
            while (p10 != null) {
                ArrayBlockingQueue<E>.Itr it = p10.get();
                ArrayBlockingQueue<E>.Itrs.Node next = p10.next;
                if (it == null || it.removedAt(removedIndex)) {
                    p10.clear();
                    p10.next = null;
                    if (o10 == null) {
                        this.head = next;
                    } else {
                        o10.next = next;
                    }
                } else {
                    o10 = p10;
                }
                p10 = next;
            }
            ArrayBlockingQueue<E>.Itrs.Node o11 = this.head;
            if (o11 == null) {
                ArrayBlockingQueue.this.itrs = null;
            }
        }

        void queueIsEmpty() {
            for (ArrayBlockingQueue<E>.Itrs.Node p10 = this.head; p10 != null; p10 = p10.next) {
                ArrayBlockingQueue<E>.Itr it = p10.get();
                if (it != null) {
                    p10.clear();
                    it.shutdown();
                }
            }
            this.head = null;
            ArrayBlockingQueue.this.itrs = null;
        }

        void elementDequeued() {
            if (ArrayBlockingQueue.this.count == 0) {
                queueIsEmpty();
            } else if (ArrayBlockingQueue.this.takeIndex == 0) {
                takeIndexWrapped();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Itr implements Iterator<E> {
        private static final int DETACHED = -3;
        private static final int NONE = -1;
        private static final int REMOVED = -2;
        private int cursor;
        private E lastItem;
        private int lastRet = -1;
        private int nextIndex;
        private E nextItem;
        private int prevCycles;
        private int prevTakeIndex;

        Itr() {
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (ArrayBlockingQueue.this.count == 0) {
                    this.cursor = -1;
                    this.nextIndex = -1;
                    this.prevTakeIndex = -3;
                } else {
                    int i10 = ArrayBlockingQueue.this.takeIndex;
                    this.prevTakeIndex = i10;
                    this.nextIndex = i10;
                    this.nextItem = (E) ArrayBlockingQueue.this.itemAt(i10);
                    this.cursor = incCursor(i10);
                    if (ArrayBlockingQueue.this.itrs == null) {
                        ArrayBlockingQueue.this.itrs = new Itrs(this);
                    } else {
                        ArrayBlockingQueue.this.itrs.register(this);
                        ArrayBlockingQueue.this.itrs.doSomeSweeping(false);
                    }
                    this.prevCycles = ArrayBlockingQueue.this.itrs.cycles;
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        boolean isDetached() {
            return this.prevTakeIndex < 0;
        }

        private int incCursor(int index) {
            int index2 = index + 1;
            if (index2 == ArrayBlockingQueue.this.items.length) {
                index2 = 0;
            }
            if (index2 == ArrayBlockingQueue.this.putIndex) {
                return -1;
            }
            return index2;
        }

        private boolean invalidated(int index, int prevTakeIndex, long dequeues, int length) {
            if (index < 0) {
                return false;
            }
            int distance = index - prevTakeIndex;
            if (distance < 0) {
                distance += length;
            }
            return dequeues > ((long) distance);
        }

        private void incorporateDequeues() {
            int cycles = ArrayBlockingQueue.this.itrs.cycles;
            int takeIndex = ArrayBlockingQueue.this.takeIndex;
            int prevCycles = this.prevCycles;
            int prevTakeIndex = this.prevTakeIndex;
            if (cycles != prevCycles || takeIndex != prevTakeIndex) {
                int len = ArrayBlockingQueue.this.items.length;
                long dequeues = ((cycles - prevCycles) * len) + (takeIndex - prevTakeIndex);
                if (invalidated(this.lastRet, prevTakeIndex, dequeues, len)) {
                    this.lastRet = -2;
                }
                if (invalidated(this.nextIndex, prevTakeIndex, dequeues, len)) {
                    this.nextIndex = -2;
                }
                if (invalidated(this.cursor, prevTakeIndex, dequeues, len)) {
                    this.cursor = takeIndex;
                }
                if (this.cursor < 0 && this.nextIndex < 0 && this.lastRet < 0) {
                    detach();
                } else {
                    this.prevCycles = cycles;
                    this.prevTakeIndex = takeIndex;
                }
            }
        }

        private void detach() {
            if (this.prevTakeIndex >= 0) {
                this.prevTakeIndex = -3;
                ArrayBlockingQueue.this.itrs.doSomeSweeping(true);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextItem != null) {
                return true;
            }
            noNext();
            return false;
        }

        private void noNext() {
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                    int i10 = this.lastRet;
                    if (i10 >= 0) {
                        this.lastItem = (E) ArrayBlockingQueue.this.itemAt(i10);
                        detach();
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public E next() {
            E e2 = this.nextItem;
            if (e2 == null) {
                throw new NoSuchElementException();
            }
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                }
                int i10 = this.nextIndex;
                this.lastRet = i10;
                int i11 = this.cursor;
                if (i11 >= 0) {
                    ArrayBlockingQueue arrayBlockingQueue = ArrayBlockingQueue.this;
                    this.nextIndex = i11;
                    this.nextItem = (E) arrayBlockingQueue.itemAt(i11);
                    this.cursor = incCursor(i11);
                } else {
                    this.nextIndex = -1;
                    this.nextItem = null;
                    if (i10 == -2) {
                        detach();
                    }
                }
                return e2;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            ReentrantLock reentrantLock = ArrayBlockingQueue.this.lock;
            reentrantLock.lock();
            try {
                E e2 = this.nextItem;
                if (e2 == null) {
                    return;
                }
                if (!isDetached()) {
                    incorporateDequeues();
                }
                consumer.accept(e2);
                if (!isDetached() && this.cursor >= 0) {
                    Object[] objArr = ArrayBlockingQueue.this.items;
                    int i10 = this.cursor;
                    int i11 = ArrayBlockingQueue.this.putIndex;
                    int length = i10 < i11 ? i11 : objArr.length;
                    while (true) {
                        if (i10 < length) {
                            consumer.accept((Object) ArrayBlockingQueue.itemAt(objArr, i10));
                            i10++;
                        } else {
                            if (length == i11) {
                                return;
                            }
                            i10 = 0;
                            length = i11;
                        }
                    }
                }
            } finally {
                this.lastRet = -1;
                this.nextIndex = -1;
                this.cursor = -1;
                this.lastItem = null;
                this.nextItem = null;
                detach();
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try {
                if (!isDetached()) {
                    incorporateDequeues();
                }
                int lastRet = this.lastRet;
                this.lastRet = -1;
                if (lastRet >= 0) {
                    if (!isDetached()) {
                        ArrayBlockingQueue.this.removeAt(lastRet);
                    } else {
                        E lastItem = this.lastItem;
                        this.lastItem = null;
                        if (ArrayBlockingQueue.this.itemAt(lastRet) == lastItem) {
                            ArrayBlockingQueue.this.removeAt(lastRet);
                        }
                    }
                } else if (lastRet == -1) {
                    throw new IllegalStateException();
                }
                if (this.cursor < 0 && this.nextIndex < 0) {
                    detach();
                }
            } finally {
                lock.unlock();
            }
        }

        void shutdown() {
            this.cursor = -1;
            if (this.nextIndex >= 0) {
                this.nextIndex = -2;
            }
            if (this.lastRet >= 0) {
                this.lastRet = -2;
                this.lastItem = null;
            }
            this.prevTakeIndex = -3;
        }

        private int distance(int index, int prevTakeIndex, int length) {
            int distance = index - prevTakeIndex;
            if (distance < 0) {
                return distance + length;
            }
            return distance;
        }

        boolean removedAt(int removedIndex) {
            if (isDetached()) {
                return true;
            }
            int takeIndex = ArrayBlockingQueue.this.takeIndex;
            int prevTakeIndex = this.prevTakeIndex;
            int len = ArrayBlockingQueue.this.items.length;
            int removedDistance = (((ArrayBlockingQueue.this.itrs.cycles - this.prevCycles) + (removedIndex < takeIndex ? 1 : 0)) * len) + (removedIndex - prevTakeIndex);
            int cursor = this.cursor;
            if (cursor >= 0) {
                int x10 = distance(cursor, prevTakeIndex, len);
                if (x10 == removedDistance) {
                    if (cursor == ArrayBlockingQueue.this.putIndex) {
                        cursor = -1;
                        this.cursor = -1;
                    }
                } else if (x10 > removedDistance) {
                    int dec = ArrayBlockingQueue.dec(cursor, len);
                    cursor = dec;
                    this.cursor = dec;
                }
            }
            int lastRet = this.lastRet;
            if (lastRet >= 0) {
                int x11 = distance(lastRet, prevTakeIndex, len);
                if (x11 == removedDistance) {
                    lastRet = -2;
                    this.lastRet = -2;
                } else if (x11 > removedDistance) {
                    int dec2 = ArrayBlockingQueue.dec(lastRet, len);
                    lastRet = dec2;
                    this.lastRet = dec2;
                }
            }
            int nextIndex = this.nextIndex;
            if (nextIndex >= 0) {
                int x12 = distance(nextIndex, prevTakeIndex, len);
                if (x12 == removedDistance) {
                    nextIndex = -2;
                    this.nextIndex = -2;
                } else if (x12 > removedDistance) {
                    int dec3 = ArrayBlockingQueue.dec(nextIndex, len);
                    nextIndex = dec3;
                    this.nextIndex = dec3;
                }
            }
            if (cursor >= 0 || nextIndex >= 0 || lastRet >= 0) {
                return false;
            }
            this.prevTakeIndex = -3;
            return true;
        }

        boolean takeIndexWrapped() {
            if (isDetached()) {
                return true;
            }
            if (ArrayBlockingQueue.this.itrs.cycles - this.prevCycles > 1) {
                shutdown();
                return true;
            }
            return false;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 4368);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.count > 0) {
                Object[] objArr = this.items;
                int i10 = this.takeIndex;
                int i11 = this.putIndex;
                int length = i10 < i11 ? i11 : objArr.length;
                while (true) {
                    if (i10 < length) {
                        consumer.accept((Object) itemAt(objArr, i10));
                        i10++;
                    } else {
                        if (length == i11) {
                            break;
                        }
                        i10 = 0;
                        length = i11;
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ArrayBlockingQueue$$ExternalSyntheticLambda0
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ArrayBlockingQueue$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ArrayBlockingQueue.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    private boolean bulkRemove(Predicate<? super E> predicate) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.itrs != null) {
                reentrantLock.unlock();
                return super.removeIf(predicate);
            }
            if (this.count > 0) {
                Object[] objArr = this.items;
                int i10 = this.takeIndex;
                int i11 = this.putIndex;
                int length = i10 < i11 ? i11 : objArr.length;
                while (true) {
                    if (i10 < length) {
                        if (predicate.test((Object) itemAt(objArr, i10))) {
                            return bulkRemoveModified(predicate, i10);
                        }
                        i10++;
                    } else {
                        if (length == i11) {
                            break;
                        }
                        i10 = 0;
                        length = i11;
                    }
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
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

    private int distanceNonEmpty(int i10, int j10) {
        int j11 = j10 - i10;
        return j11 <= 0 ? j11 + this.items.length : j11;
    }

    private boolean bulkRemoveModified(Predicate<? super E> predicate, int i10) {
        Object[] objArr = this.items;
        int length = this.items.length;
        int i11 = this.putIndex;
        long[] nBits = nBits(distanceNonEmpty(i10, this.putIndex));
        nBits[0] = 1;
        int i12 = i10 + 1;
        int length2 = i12 <= i11 ? i11 : objArr.length;
        int i13 = i10;
        while (true) {
            if (i12 < length2) {
                if (predicate.test((Object) itemAt(objArr, i12))) {
                    setBit(nBits, i12 - i13);
                }
                i12++;
            } else {
                if (length2 == i11) {
                    break;
                }
                i12 = 0;
                length2 = i11;
                i13 -= length;
            }
        }
        int i14 = i10;
        int i15 = i10 + 1;
        int length3 = i15 <= i11 ? i11 : objArr.length;
        int i16 = i10;
        while (true) {
            if (i15 < length3) {
                if (isClear(nBits, i15 - i16)) {
                    objArr[i14] = objArr[i15];
                    i14++;
                }
                i15++;
            } else {
                if (length3 == i11) {
                    break;
                }
                i15 = 0;
                length3 = i11;
                i16 -= length;
                while (i15 < length3 && i14 < length) {
                    if (isClear(nBits, i15 - i16)) {
                        objArr[i14] = objArr[i15];
                        i14++;
                    }
                    i15++;
                }
                if (i15 < length3) {
                    i14 = 0;
                } else if (i14 == length) {
                    i14 = 0;
                }
            }
        }
        this.count -= distanceNonEmpty(i14, i11);
        this.putIndex = i14;
        circularClear(objArr, i14, i11);
        return true;
    }

    void checkInvariants() {
        if (!invariantsSatisfied()) {
            String detail = String.format("takeIndex=%d putIndex=%d count=%d capacity=%d items=%s", Integer.valueOf(this.takeIndex), Integer.valueOf(this.putIndex), Integer.valueOf(this.count), Integer.valueOf(this.items.length), Arrays.toString(this.items));
            System.err.println(detail);
            throw new AssertionError((Object) detail);
        }
    }

    private boolean invariantsSatisfied() {
        Object[] objArr = this.items;
        int capacity = objArr.length;
        if (capacity > 0 && objArr.getClass() == Object[].class) {
            int i10 = this.takeIndex;
            int i11 = this.putIndex;
            int i12 = this.count;
            if ((i10 | i11 | i12) >= 0 && i10 < capacity && i11 < capacity && i12 <= capacity && ((i11 - i10) - i12) % capacity == 0 && ((i12 == 0 || this.items[i10] != null) && ((i12 == capacity || this.items[i11] == null) && (i12 == 0 || this.items[dec(i11, capacity)] != null)))) {
                return true;
            }
        }
        return false;
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        if (!invariantsSatisfied()) {
            throw new InvalidObjectException("invariants violated");
        }
    }
}
