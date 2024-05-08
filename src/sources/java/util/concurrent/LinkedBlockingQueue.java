package java.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private final AtomicInteger count;
    transient Node<E> head;
    private transient Node<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Node<E> {
        E item;
        Node<E> next;

        Node(E x10) {
            this.item = x10;
        }
    }

    private void signalNotEmpty() {
        ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            this.notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    private void enqueue(Node<E> node) {
        this.last.next = node;
        this.last = node;
    }

    private E dequeue() {
        Node<E> h10 = this.head;
        Node<E> first = h10.next;
        h10.next = h10;
        this.head = first;
        E x10 = first.item;
        first.item = null;
        return x10;
    }

    void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingQueue(int capacity) {
        this.count = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
    }

    public LinkedBlockingQueue(Collection<? extends E> c4) {
        this(Integer.MAX_VALUE);
        ReentrantLock putLock = this.putLock;
        putLock.lock();
        int n10 = 0;
        try {
            for (E e2 : c4) {
                if (e2 == null) {
                    throw new NullPointerException();
                }
                if (n10 == this.capacity) {
                    throw new IllegalStateException("Queue full");
                }
                enqueue(new Node<>(e2));
                n10++;
            }
            this.count.set(n10);
        } finally {
            putLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.count.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock putLock = this.putLock;
        AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        while (count.get() == this.capacity) {
            try {
                this.notFull.await();
            } finally {
                putLock.unlock();
            }
        }
        enqueue(node);
        int c4 = count.getAndIncrement();
        if (c4 + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (c4 == 0) {
            signalNotEmpty();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        long nanos = unit.toNanos(timeout);
        ReentrantLock putLock = this.putLock;
        AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        while (count.get() == this.capacity) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    putLock.unlock();
                    return false;
                }
            } finally {
                putLock.unlock();
            }
        }
        enqueue(new Node<>(e2));
        int c4 = count.getAndIncrement();
        if (c4 + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (c4 == 0) {
            signalNotEmpty();
            return true;
        }
        return true;
    }

    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        AtomicInteger count = this.count;
        if (count.get() == this.capacity) {
            return false;
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            if (count.get() == this.capacity) {
                return false;
            }
            enqueue(node);
            int c4 = count.getAndIncrement();
            if (c4 + 1 < this.capacity) {
                this.notFull.signal();
            }
            if (c4 == 0) {
                signalNotEmpty();
                return true;
            }
            return true;
        } finally {
            putLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        AtomicInteger count = this.count;
        ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        while (count.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                takeLock.unlock();
                throw th;
            }
        }
        E x10 = dequeue();
        int c4 = count.getAndDecrement();
        if (c4 > 1) {
            this.notEmpty.signal();
        }
        takeLock.unlock();
        if (c4 == this.capacity) {
            signalNotFull();
        }
        return x10;
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        AtomicInteger count = this.count;
        ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        while (count.get() == 0) {
            try {
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    takeLock.unlock();
                    return null;
                }
            } catch (Throwable th) {
                takeLock.unlock();
                throw th;
            }
        }
        E x10 = dequeue();
        int c4 = count.getAndDecrement();
        if (c4 > 1) {
            this.notEmpty.signal();
        }
        takeLock.unlock();
        if (c4 == this.capacity) {
            signalNotFull();
        }
        return x10;
    }

    @Override // java.util.Queue
    public E poll() {
        AtomicInteger count = this.count;
        if (count.get() == 0) {
            return null;
        }
        ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            if (count.get() == 0) {
                return null;
            }
            E x10 = dequeue();
            int c4 = count.getAndDecrement();
            if (c4 > 1) {
                this.notEmpty.signal();
            }
            takeLock.unlock();
            if (c4 == this.capacity) {
                signalNotFull();
            }
            return x10;
        } finally {
            takeLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        AtomicInteger count = this.count;
        if (count.get() == 0) {
            return null;
        }
        ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            return count.get() > 0 ? this.head.next.item : null;
        } finally {
            takeLock.unlock();
        }
    }

    void unlink(Node<E> p10, Node<E> pred) {
        p10.item = null;
        pred.next = p10.next;
        if (this.last == p10) {
            this.last = pred;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        if (o10 == null) {
            return false;
        }
        fullyLock();
        try {
            Node<E> pred = this.head;
            for (Node<E> p10 = pred.next; p10 != null; p10 = p10.next) {
                if (!o10.equals(p10.item)) {
                    pred = p10;
                } else {
                    unlink(p10, pred);
                    fullyUnlock();
                    return true;
                }
            }
            return false;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 == null) {
            return false;
        }
        fullyLock();
        try {
            for (Node<E> p10 = this.head.next; p10 != null; p10 = p10.next) {
                if (o10.equals(p10.item)) {
                    fullyUnlock();
                    return true;
                }
            }
            return false;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        fullyLock();
        try {
            int size = this.count.get();
            Object[] a10 = new Object[size];
            int k10 = 0;
            Node<E> p10 = this.head.next;
            while (p10 != null) {
                int k11 = k10 + 1;
                a10[k10] = p10.item;
                p10 = p10.next;
                k10 = k11;
            }
            return a10;
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i10 = this.count.get();
            if (tArr.length < i10) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10);
            }
            int i11 = 0;
            Node<E> node = this.head.next;
            while (node != null) {
                tArr[i11] = node.item;
                node = node.next;
                i11++;
            }
            if (tArr.length > i11) {
                tArr[i11] = 0;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return Helpers.collectionToString(this);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        fullyLock();
        try {
            Node<E> h10 = this.head;
            while (true) {
                Node<E> p10 = h10.next;
                if (p10 == null) {
                    break;
                }
                h10.next = h10;
                p10.item = null;
                h10 = p10;
            }
            Node<E> h11 = this.last;
            this.head = h11;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c4) {
        return drainTo(c4, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i10) {
        Objects.requireNonNull(collection);
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        boolean z10 = false;
        if (i10 <= 0) {
            return 0;
        }
        boolean z11 = false;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            int min = Math.min(i10, this.count.get());
            Node<E> node = this.head;
            int i11 = 0;
            while (true) {
                if (i11 >= min) {
                    break;
                }
                try {
                    Node<E> node2 = node.next;
                    collection.add(node2.item);
                    node2.item = null;
                    node.next = node;
                    node = node2;
                    i11++;
                } finally {
                    if (i11 > 0) {
                        this.head = node;
                        if (this.count.getAndAdd(-i11) == this.capacity) {
                            z10 = true;
                        }
                        boolean z12 = z10;
                    }
                }
            }
            return min;
        } finally {
            reentrantLock.unlock();
            if (0 != 0) {
                signalNotFull();
            }
        }
    }

    Node<E> succ(Node<E> p10) {
        Node<E> p11 = p10.next;
        return p10 == p11 ? this.head.next : p11;
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
    private class Itr implements Iterator<E> {
        private Node<E> ancestor;
        private Node<E> lastRet;
        private Node<E> next;
        private E nextItem;

        Itr() {
            LinkedBlockingQueue.this.fullyLock();
            try {
                Node<E> node = LinkedBlockingQueue.this.head.next;
                this.next = node;
                if (node != null) {
                    this.nextItem = node.item;
                }
            } finally {
                LinkedBlockingQueue.this.fullyUnlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            Node<E> p10 = this.next;
            if (p10 == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = p10;
            E x10 = this.nextItem;
            LinkedBlockingQueue.this.fullyLock();
            E e2 = null;
            try {
                Node<E> p11 = p10.next;
                while (p11 != null) {
                    E e10 = p11.item;
                    e2 = e10;
                    if (e10 != null) {
                        break;
                    }
                    p11 = LinkedBlockingQueue.this.succ(p11);
                }
                this.next = p11;
                this.nextItem = e2;
                return x10;
            } finally {
                LinkedBlockingQueue.this.fullyUnlock();
            }
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> action) {
            int n10;
            Objects.requireNonNull(action);
            Node<E> node = this.next;
            Node<E> p10 = node;
            if (node == null) {
                return;
            }
            this.lastRet = p10;
            this.next = null;
            Object[] es = null;
            int len = 1;
            do {
                LinkedBlockingQueue.this.fullyLock();
                if (es == null) {
                    try {
                        Node<E> q10 = p10.next;
                        p10 = q10;
                        while (q10 != null && (q10.item == null || (len = len + 1) != 64)) {
                            q10 = LinkedBlockingQueue.this.succ(q10);
                        }
                        es = new Object[len];
                        es[0] = this.nextItem;
                        this.nextItem = null;
                        n10 = 1;
                    } catch (Throwable th) {
                        LinkedBlockingQueue.this.fullyUnlock();
                        throw th;
                    }
                } else {
                    n10 = 0;
                }
                while (p10 != null && n10 < len) {
                    E e2 = p10.item;
                    es[n10] = e2;
                    if (e2 != null) {
                        this.lastRet = p10;
                        n10++;
                    }
                    p10 = LinkedBlockingQueue.this.succ(p10);
                }
                LinkedBlockingQueue.this.fullyUnlock();
                for (int i10 = 0; i10 < n10; i10++) {
                    action.accept(es[i10]);
                }
                if (n10 <= 0) {
                    return;
                }
            } while (p10 != null);
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> p10 = this.lastRet;
            if (p10 == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            LinkedBlockingQueue.this.fullyLock();
            try {
                if (p10.item != null) {
                    if (this.ancestor == null) {
                        this.ancestor = LinkedBlockingQueue.this.head;
                    }
                    Node<E> findPred = LinkedBlockingQueue.this.findPred(p10, this.ancestor);
                    this.ancestor = findPred;
                    LinkedBlockingQueue.this.unlink(p10, findPred);
                }
            } finally {
                LinkedBlockingQueue.this.fullyUnlock();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private final class LBQSpliterator implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        long est;
        boolean exhausted;

        LBQSpliterator() {
            this.est = LinkedBlockingQueue.this.size();
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.Spliterator<E> trySplit() {
            /*
                r12 = this;
                boolean r0 = r12.exhausted
                if (r0 != 0) goto L7c
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r12.current
                r1 = r0
                if (r0 != 0) goto L12
                java.util.concurrent.LinkedBlockingQueue r0 = java.util.concurrent.LinkedBlockingQueue.this
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.head
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r0.next
                r1 = r0
                if (r0 == 0) goto L7c
            L12:
                java.util.concurrent.LinkedBlockingQueue$Node<E> r0 = r1.next
                if (r0 == 0) goto L7c
                int r0 = r12.batch
                r2 = 1
                int r0 = r0 + r2
                r3 = 33554432(0x2000000, float:9.403955E-38)
                int r0 = java.lang.Math.min(r0, r3)
                r12.batch = r0
                java.lang.Object[] r3 = new java.lang.Object[r0]
                r4 = 0
                java.util.concurrent.LinkedBlockingQueue$Node<E> r5 = r12.current
                java.util.concurrent.LinkedBlockingQueue r6 = java.util.concurrent.LinkedBlockingQueue.this
                r6.fullyLock()
                if (r5 != 0) goto L3a
                java.util.concurrent.LinkedBlockingQueue r6 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L38
                java.util.concurrent.LinkedBlockingQueue$Node<E> r6 = r6.head     // Catch: java.lang.Throwable -> L38
                java.util.concurrent.LinkedBlockingQueue$Node<E> r6 = r6.next     // Catch: java.lang.Throwable -> L38
                r5 = r6
                if (r6 == 0) goto L54
                goto L3a
            L38:
                r2 = move-exception
                goto L4e
            L3a:
                if (r5 == 0) goto L54
                if (r4 >= r0) goto L54
                E r6 = r5.item     // Catch: java.lang.Throwable -> L38
                r3[r4] = r6     // Catch: java.lang.Throwable -> L38
                if (r6 == 0) goto L46
                int r4 = r4 + 1
            L46:
                java.util.concurrent.LinkedBlockingQueue r6 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L38
                java.util.concurrent.LinkedBlockingQueue$Node r6 = r6.succ(r5)     // Catch: java.lang.Throwable -> L38
                r5 = r6
                goto L3a
            L4e:
                java.util.concurrent.LinkedBlockingQueue r6 = java.util.concurrent.LinkedBlockingQueue.this
                r6.fullyUnlock()
                throw r2
            L54:
                java.util.concurrent.LinkedBlockingQueue r6 = java.util.concurrent.LinkedBlockingQueue.this
                r6.fullyUnlock()
                r12.current = r5
                r6 = 0
                if (r5 != 0) goto L65
                r12.est = r6
                r12.exhausted = r2
                goto L71
            L65:
                long r8 = r12.est
                long r10 = (long) r4
                long r8 = r8 - r10
                r12.est = r8
                int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r2 >= 0) goto L71
                r12.est = r6
            L71:
                if (r4 <= 0) goto L7c
            L74:
                r2 = 0
                r6 = 4368(0x1110, float:6.121E-42)
                java.util.Spliterator r2 = java.util.Spliterators.spliterator(r3, r2, r4, r6)
                return r2
            L7c:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingQueue.LBQSpliterator.trySplit():java.util.Spliterator");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            if (r1 != null) goto L28;
         */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r4) {
            /*
                r3 = this;
                java.util.Objects.requireNonNull(r4)
                boolean r0 = r3.exhausted
                if (r0 != 0) goto L43
                r0 = 0
                java.util.concurrent.LinkedBlockingQueue r1 = java.util.concurrent.LinkedBlockingQueue.this
                r1.fullyLock()
                java.util.concurrent.LinkedBlockingQueue$Node<E> r1 = r3.current     // Catch: java.lang.Throwable -> L3c
                r2 = r1
                if (r1 != 0) goto L1b
                java.util.concurrent.LinkedBlockingQueue r1 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L3c
                java.util.concurrent.LinkedBlockingQueue$Node<E> r1 = r1.head     // Catch: java.lang.Throwable -> L3c
                java.util.concurrent.LinkedBlockingQueue$Node<E> r1 = r1.next     // Catch: java.lang.Throwable -> L3c
                r2 = r1
                if (r1 == 0) goto L29
            L1b:
                E r1 = r2.item     // Catch: java.lang.Throwable -> L3c
                r0 = r1
                java.util.concurrent.LinkedBlockingQueue r1 = java.util.concurrent.LinkedBlockingQueue.this     // Catch: java.lang.Throwable -> L3c
                java.util.concurrent.LinkedBlockingQueue$Node r1 = r1.succ(r2)     // Catch: java.lang.Throwable -> L3c
                r2 = r1
                if (r0 != 0) goto L29
                if (r2 != 0) goto L1b
            L29:
                r3.current = r2     // Catch: java.lang.Throwable -> L3c
                r1 = 1
                if (r2 != 0) goto L30
                r3.exhausted = r1     // Catch: java.lang.Throwable -> L3c
            L30:
                java.util.concurrent.LinkedBlockingQueue r2 = java.util.concurrent.LinkedBlockingQueue.this
                r2.fullyUnlock()
                if (r0 == 0) goto L43
                r4.accept(r0)
                return r1
            L3c:
                r1 = move-exception
                java.util.concurrent.LinkedBlockingQueue r2 = java.util.concurrent.LinkedBlockingQueue.this
                r2.fullyUnlock()
                throw r1
            L43:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingQueue.LBQSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            if (!this.exhausted) {
                this.exhausted = true;
                Node<E> p10 = this.current;
                this.current = null;
                LinkedBlockingQueue.this.forEachFrom(action, p10);
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new LBQSpliterator();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        forEachFrom(action, null);
    }

    void forEachFrom(Consumer<? super E> action, Node<E> p10) {
        Object[] es = null;
        int len = 0;
        do {
            fullyLock();
            if (es == null) {
                if (p10 == null) {
                    try {
                        p10 = this.head.next;
                    } catch (Throwable th) {
                        fullyUnlock();
                        throw th;
                    }
                }
                Node<E> q10 = p10;
                while (q10 != null && (q10.item == null || (len = len + 1) != 64)) {
                    q10 = succ(q10);
                }
                es = new Object[len];
            }
            int n10 = 0;
            while (p10 != null && n10 < len) {
                E e2 = p10.item;
                es[n10] = e2;
                if (e2 != null) {
                    n10++;
                }
                p10 = succ(p10);
            }
            fullyUnlock();
            for (int i10 = 0; i10 < n10; i10++) {
                action.accept(es[i10]);
            }
            if (n10 <= 0) {
                return;
            }
        } while (p10 != null);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedBlockingQueue$$ExternalSyntheticLambda0
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedBlockingQueue$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return LinkedBlockingQueue.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    Node<E> findPred(Node<E> p10, Node<E> ancestor) {
        if (ancestor.item == null) {
            ancestor = this.head;
        }
        while (true) {
            Node<E> q10 = ancestor.next;
            if (q10 != p10) {
                ancestor = q10;
            } else {
                return ancestor;
            }
        }
    }

    private boolean bulkRemove(Predicate<? super E> predicate) {
        int i10 = 0;
        Node<E>[] nodeArr = null;
        Node<E> node = this.head;
        Node<E> node2 = null;
        boolean z10 = false;
        while (true) {
            fullyLock();
            if (nodeArr == null) {
                try {
                    Node<E> node3 = this.head.next;
                    node2 = node3;
                    while (node3 != null && (node3.item == null || (i10 = i10 + 1) != 64)) {
                        node3 = succ(node3);
                    }
                    nodeArr = new Node[i10];
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
            Node<E> node4 = node2;
            int i11 = 0;
            while (node4 != null && i11 < i10) {
                int i12 = i11 + 1;
                try {
                    nodeArr[i11] = node4;
                    node4 = succ(node4);
                    i11 = i12;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            fullyUnlock();
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                E e2 = nodeArr[i13].item;
                if (e2 != null && predicate.test(e2)) {
                    j10 |= 1 << i13;
                }
            }
            if (j10 != 0) {
                fullyLock();
                for (int i14 = 0; i14 < i11; i14++) {
                    if (((1 << i14) & j10) != 0) {
                        try {
                            Node<E> node5 = nodeArr[i14];
                            if (node5.item != null) {
                                node = findPred(node5, node);
                                unlink(node5, node);
                                z10 = true;
                            }
                        } finally {
                            fullyUnlock();
                        }
                    }
                    nodeArr[i14] = null;
                }
            }
            if (i11 <= 0 || node4 == null) {
                break;
            }
            node2 = node4;
        }
        return z10;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        fullyLock();
        try {
            s2.defaultWriteObject();
            for (Node<E> p10 = this.head.next; p10 != null; p10 = p10.next) {
                s2.writeObject(p10.item);
            }
            s2.writeObject(null);
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.count.set(0);
        Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object readObject = s2.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }
}
