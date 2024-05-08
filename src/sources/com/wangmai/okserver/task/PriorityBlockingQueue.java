package com.wangmai.okserver.task;

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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    public static final long serialVersionUID = -6903933977591709194L;
    public final int capacity;
    public final AtomicInteger count;
    public transient PriorityBlockingQueue<E>.Node<E> head;
    public transient PriorityBlockingQueue<E>.Node<E> last;
    public final Condition notEmpty;
    public final Condition notFull;
    public final ReentrantLock putLock;
    public final ReentrantLock takeLock;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class Itr implements Iterator<E> {
        public PriorityBlockingQueue<E>.Node<E> current;
        public E currentElement;
        public PriorityBlockingQueue<E>.Node<E> lastRet;

        public Itr() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node = PriorityBlockingQueue.this.head.next;
                this.current = node;
                if (node != null) {
                    this.currentElement = node.getValue();
                }
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }

        private PriorityBlockingQueue<E>.Node<E> nextNode(PriorityBlockingQueue<E>.Node<E> node) {
            PriorityBlockingQueue<E>.Node<E> node2;
            while (true) {
                node2 = node.next;
                if (node2 == node) {
                    return PriorityBlockingQueue.this.head.next;
                }
                if (node2 == null || node2.getValue() != null) {
                    break;
                }
                node = node2;
            }
            return node2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public E next() {
            PriorityBlockingQueue.this.fullyLock();
            try {
                PriorityBlockingQueue<E>.Node<E> node = this.current;
                if (node != null) {
                    E e2 = this.currentElement;
                    this.lastRet = node;
                    PriorityBlockingQueue<E>.Node<E> nextNode = nextNode(node);
                    this.current = nextNode;
                    this.currentElement = nextNode == null ? null : nextNode.getValue();
                    return e2;
                }
                throw new NoSuchElementException();
            } finally {
                PriorityBlockingQueue.this.fullyUnlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        
            r4.this$0.unlink(r1, r2);
         */
        @Override // java.util.Iterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void remove() {
            /*
                r4 = this;
                com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<E> r0 = r4.lastRet
                if (r0 == 0) goto L31
                com.wangmai.okserver.task.PriorityBlockingQueue r0 = com.wangmai.okserver.task.PriorityBlockingQueue.this
                r0.fullyLock()
                com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<E> r0 = r4.lastRet     // Catch: java.lang.Throwable -> L2a
                r1 = 0
                r4.lastRet = r1     // Catch: java.lang.Throwable -> L2a
                com.wangmai.okserver.task.PriorityBlockingQueue r1 = com.wangmai.okserver.task.PriorityBlockingQueue.this     // Catch: java.lang.Throwable -> L2a
                com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<E> r1 = r1.head     // Catch: java.lang.Throwable -> L2a
                com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<T> r2 = r1.next     // Catch: java.lang.Throwable -> L2a
            L14:
                r3 = r2
                r2 = r1
                r1 = r3
                if (r1 == 0) goto L24
                if (r1 != r0) goto L21
                com.wangmai.okserver.task.PriorityBlockingQueue r0 = com.wangmai.okserver.task.PriorityBlockingQueue.this     // Catch: java.lang.Throwable -> L2a
                r0.unlink(r1, r2)     // Catch: java.lang.Throwable -> L2a
                goto L24
            L21:
                com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<T> r2 = r1.next     // Catch: java.lang.Throwable -> L2a
                goto L14
            L24:
                com.wangmai.okserver.task.PriorityBlockingQueue r0 = com.wangmai.okserver.task.PriorityBlockingQueue.this
                r0.fullyUnlock()
                return
            L2a:
                r0 = move-exception
                com.wangmai.okserver.task.PriorityBlockingQueue r1 = com.wangmai.okserver.task.PriorityBlockingQueue.this
                r1.fullyUnlock()
                throw r0
            L31:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wangmai.okserver.task.PriorityBlockingQueue.Itr.remove():void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class Node<T> {
        public PriorityBlockingQueue<E>.Node<T> next;
        public PriorityObject<?> value;
        public boolean valueAsT = false;

        public Node(T t2) {
            setValue(t2);
        }

        public int getPriority() {
            return this.value.priority;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.wangmai.okserver.task.PriorityObject<?>, T, com.wangmai.okserver.task.PriorityObject] */
        public T getValue() {
            ?? r02 = (T) this.value;
            if (r02 == 0) {
                return null;
            }
            return this.valueAsT ? r02 : r02.obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setValue(T t2) {
            if (t2 == 0) {
                this.value = null;
            } else if (t2 instanceof PriorityObject) {
                this.value = (PriorityObject) t2;
                this.valueAsT = true;
            } else {
                this.value = new PriorityObject<>(0, t2);
            }
        }
    }

    public PriorityBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    private E _dequeue() {
        PriorityBlockingQueue<E>.Node<E> node = this.head;
        PriorityBlockingQueue<E>.Node<E> node2 = (PriorityBlockingQueue<E>.Node<E>) node.next;
        node.next = node;
        this.head = node2;
        E value = node2.getValue();
        node2.setValue(null);
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void _enqueue(PriorityBlockingQueue<E>.Node<E> node) {
        boolean z10;
        Node node2 = this.head;
        while (true) {
            PriorityBlockingQueue<E>.Node<T> node3 = node2.next;
            if (node3 == 0) {
                z10 = false;
                break;
            } else {
                if (node3.getPriority() < node.getPriority()) {
                    node2.next = node;
                    node.next = node3;
                    z10 = true;
                    break;
                }
                node2 = node2.next;
            }
        }
        if (z10) {
            return;
        }
        this.last.next = node;
        this.last = node;
    }

    private synchronized E opQueue(PriorityBlockingQueue<E>.Node<E> node) {
        if (node == null) {
            return _dequeue();
        }
        _enqueue(node);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
        this.head = node;
        this.last = node;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            Node node = this.head;
            while (true) {
                node = node.next;
                if (node != null) {
                    objectOutputStream.writeObject(node.getValue());
                } else {
                    objectOutputStream.writeObject(null);
                    return;
                }
            }
        } finally {
            fullyUnlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.wangmai.okserver.task.PriorityBlockingQueue<E>$Node<T>, com.wangmai.okserver.task.PriorityBlockingQueue$Node] */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        fullyLock();
        try {
            ?? r02 = this.head;
            while (true) {
                Node node = r02.next;
                if (node == null) {
                    break;
                }
                r02.next = r02;
                node.setValue(null);
                r02 = (PriorityBlockingQueue<E>.Node<E>) node;
            }
            this.head = this.last;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            for (Node node = this.head.next; node != null; node = node.next) {
                if (obj.equals(node.getValue())) {
                    fullyUnlock();
                    return true;
                }
            }
            return false;
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    public void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j10, TimeUnit timeUnit) throws InterruptedException {
        Objects.requireNonNull(e2);
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        opQueue(new Node<>(e2));
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (andIncrement != 0) {
            return true;
        }
        signalNotEmpty();
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            PriorityBlockingQueue<E>.Node<E> node = this.head.next;
            if (node == null) {
                return null;
            }
            return node.getValue();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j10);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.putLock;
        AtomicInteger atomicInteger = this.count;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == this.capacity) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
        opQueue(node);
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement + 1 < this.capacity) {
            this.notFull.signal();
        }
        if (andIncrement == 0) {
            signalNotEmpty();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            PriorityBlockingQueue<E>.Node<E> node = this.head;
            PriorityBlockingQueue<E>.Node<E> node2 = node.next;
            while (true) {
                PriorityBlockingQueue<E>.Node<E> node3 = node2;
                PriorityBlockingQueue<E>.Node<E> node4 = node;
                node = node3;
                if (node == null) {
                    return false;
                }
                if (obj.equals(node.getValue())) {
                    unlink(node, node4);
                    fullyUnlock();
                    return true;
                }
                node2 = node.next;
            }
        } finally {
            fullyUnlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.count.get();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            int i10 = 0;
            Node node = this.head;
            while (true) {
                node = node.next;
                if (node == null) {
                    return objArr;
                }
                int i11 = i10 + 1;
                objArr[i10] = node.getValue();
                i10 = i11;
            }
        } finally {
            fullyUnlock();
        }
    }

    public void unlink(PriorityBlockingQueue<E>.Node<E> node, PriorityBlockingQueue<E>.Node<E> node2) {
        node.setValue(null);
        node2.next = node.next;
        if (this.last == node) {
            this.last = node2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }

    public PriorityBlockingQueue(int i10) {
        this.count = new AtomicInteger();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.takeLock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.putLock = reentrantLock2;
        this.notFull = reentrantLock2.newCondition();
        if (i10 > 0) {
            this.capacity = i10;
            PriorityBlockingQueue<E>.Node<E> node = new Node<>(null);
            this.head = node;
            this.last = node;
            return;
        }
        throw new IllegalArgumentException();
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
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            int min = Math.min(i10, this.count.get());
            PriorityBlockingQueue<E>.Node<E> node = this.head;
            int i11 = 0;
            while (i11 < min) {
                try {
                    Node node2 = node.next;
                    collection.add((Object) node2.getValue());
                    node2.setValue(null);
                    node.next = (PriorityBlockingQueue<E>.Node<T>) node;
                    i11++;
                    node = (PriorityBlockingQueue<E>.Node<E>) node2;
                } finally {
                    if (i11 > 0) {
                        this.head = (PriorityBlockingQueue<E>.Node<E>) node;
                        if (this.count.getAndAdd(-i11) == this.capacity) {
                        }
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i10 = this.count.get();
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
            }
            int i11 = 0;
            Node node = this.head;
            while (true) {
                node = node.next;
                if (node == null) {
                    break;
                }
                tArr[i11] = node.getValue();
                i11++;
            }
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    public PriorityBlockingQueue(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            int i10 = 0;
            for (E e2 : collection) {
                if (e2 != null) {
                    if (i10 != this.capacity) {
                        opQueue(new Node<>(e2));
                        i10++;
                    } else {
                        throw new IllegalStateException("Queue full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
            this.count.set(i10);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        AtomicInteger atomicInteger = this.count;
        E e2 = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i10 = -1;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e2 = opQueue(null);
                i10 = atomicInteger.getAndDecrement();
                if (i10 > 1) {
                    this.notEmpty.signal();
                }
            }
            reentrantLock.unlock();
            if (i10 == this.capacity) {
                signalNotFull();
            }
            return e2;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        Objects.requireNonNull(e2);
        AtomicInteger atomicInteger = this.count;
        if (atomicInteger.get() == this.capacity) {
            return false;
        }
        int i10 = -1;
        PriorityBlockingQueue<E>.Node<E> node = new Node<>(e2);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() < this.capacity) {
                opQueue(node);
                i10 = atomicInteger.getAndIncrement();
                if (i10 + 1 < this.capacity) {
                    this.notFull.signal();
                }
            }
            if (i10 == 0) {
                signalNotEmpty();
            }
            return i10 >= 0;
        } finally {
            reentrantLock.unlock();
        }
    }
}
