package java.util.concurrent;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DelayQueue<E extends Delayed> extends AbstractQueue<E> implements BlockingQueue<E> {
    private final Condition available;
    private Thread leader;
    private final transient ReentrantLock lock;

    /* renamed from: q, reason: collision with root package name */
    private final PriorityQueue<E> f50498q;

    public DelayQueue() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.f50498q = new PriorityQueue<>();
        this.available = reentrantLock.newCondition();
    }

    public DelayQueue(Collection<? extends E> c4) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.f50498q = new PriorityQueue<>();
        this.available = reentrantLock.newCondition();
        addAll(c4);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return offer((DelayQueue<E>) e2);
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            this.f50498q.offer(e2);
            if (this.f50498q.peek() == e2) {
                this.leader = null;
                this.available.signal();
            }
            lock.unlock();
            return true;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) {
        offer((DelayQueue<E>) e2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) {
        return offer((DelayQueue<E>) e2);
    }

    @Override // java.util.Queue
    public E poll() {
        E e2;
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            E first = this.f50498q.peek();
            if (first != null && first.getDelay(TimeUnit.NANOSECONDS) <= 0) {
                e2 = this.f50498q.poll();
                return e2;
            }
            e2 = null;
            return e2;
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
                E first = this.f50498q.peek();
                if (first == null) {
                    this.available.await();
                } else {
                    long delay = first.getDelay(TimeUnit.NANOSECONDS);
                    if (delay <= 0) {
                        break;
                    }
                    if (this.leader != null) {
                        this.available.await();
                    } else {
                        Thread thisThread = Thread.currentThread();
                        this.leader = thisThread;
                        try {
                            this.available.awaitNanos(delay);
                        } finally {
                            if (this.leader == thisThread) {
                                this.leader = null;
                            }
                        }
                    }
                }
            } finally {
                if (this.leader == null && this.f50498q.peek() != null) {
                    this.available.signal();
                }
                lock.unlock();
            }
        }
        return this.f50498q.poll();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (true) {
            try {
                E first = this.f50498q.peek();
                if (first != null) {
                    long delay = first.getDelay(TimeUnit.NANOSECONDS);
                    if (delay <= 0) {
                        E poll = this.f50498q.poll();
                        if (this.leader == null && this.f50498q.peek() != null) {
                            this.available.signal();
                        }
                        lock.unlock();
                        return poll;
                    }
                    if (nanos <= 0) {
                        if (this.leader == null && this.f50498q.peek() != null) {
                            this.available.signal();
                        }
                        lock.unlock();
                        return null;
                    }
                    if (nanos >= delay && this.leader == null) {
                        Thread thisThread = Thread.currentThread();
                        this.leader = thisThread;
                        try {
                            long timeLeft = this.available.awaitNanos(delay);
                            nanos -= delay - timeLeft;
                            if (this.leader == thisThread) {
                                this.leader = null;
                            }
                        } catch (Throwable th) {
                            if (this.leader == thisThread) {
                                this.leader = null;
                            }
                            throw th;
                        }
                    }
                    nanos = this.available.awaitNanos(nanos);
                } else {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = this.available.awaitNanos(nanos);
                }
            } finally {
                if (this.leader == null && this.f50498q.peek() != null) {
                    this.available.signal();
                }
                lock.unlock();
            }
        }
    }

    @Override // java.util.Queue
    public E peek() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.f50498q.peek();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.f50498q.size();
        } finally {
            lock.unlock();
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
        if (i10 <= 0) {
            return 0;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        int i11 = 0;
        while (i11 < i10) {
            try {
                E peek = this.f50498q.peek();
                if (peek == null || peek.getDelay(TimeUnit.NANOSECONDS) > 0) {
                    break;
                }
                collection.add(peek);
                this.f50498q.poll();
                i11++;
            } finally {
                reentrantLock.unlock();
            }
        }
        return i11;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            this.f50498q.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.f50498q.toArray();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return (T[]) this.f50498q.toArray(tArr);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.f50498q.remove(o10);
        } finally {
            lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void removeEQ(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r3.lock
            r0.lock()
            java.util.PriorityQueue<E extends java.util.concurrent.Delayed> r1 = r3.f50498q     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r1 = r1.iterator2()     // Catch: java.lang.Throwable -> L20
        Lb:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1b
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L20
            if (r4 != r2) goto Lb
            r1.remove()     // Catch: java.lang.Throwable -> L20
        L1b:
            r0.unlock()
            return
        L20:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.DelayQueue.removeEQ(java.lang.Object):void");
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
    private class Itr implements Iterator<E> {
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
            DelayQueue.this.removeEQ(this.array[i10]);
            this.lastRet = -1;
        }
    }
}
