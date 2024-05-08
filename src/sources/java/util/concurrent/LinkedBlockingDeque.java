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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E x10) {
            this.item = x10;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int capacity) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
    }

    public LinkedBlockingDeque(Collection<? extends E> c4) {
        this(Integer.MAX_VALUE);
        addAll(c4);
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> f10 = this.first;
        node.next = f10;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            f10.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> l10 = this.last;
        node.prev = l10;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            l10.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            return null;
        }
        Node<E> n10 = f10.next;
        E item = f10.item;
        f10.item = null;
        f10.next = f10;
        this.first = n10;
        if (n10 == null) {
            this.last = null;
        } else {
            n10.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return item;
    }

    private E unlinkLast() {
        Node<E> l10 = this.last;
        if (l10 == null) {
            return null;
        }
        Node<E> p10 = l10.prev;
        E item = l10.item;
        l10.item = null;
        l10.prev = l10;
        this.last = p10;
        if (p10 == null) {
            this.first = null;
        } else {
            p10.next = null;
        }
        this.count--;
        this.notFull.signal();
        return item;
    }

    void unlink(Node<E> x10) {
        Node<E> p10 = x10.prev;
        Node<E> n10 = x10.next;
        if (p10 == null) {
            unlinkFirst();
            return;
        }
        if (n10 == null) {
            unlinkLast();
            return;
        }
        p10.next = n10;
        n10.prev = p10;
        x10.item = null;
        this.count--;
        this.notFull.signal();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean offerFirst(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return linkFirst(node);
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean offerLast(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return linkLast(node);
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock lock = this.lock;
        lock.lock();
        while (!linkFirst(node)) {
            try {
                this.notFull.await();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        ReentrantLock lock = this.lock;
        lock.lock();
        while (!linkLast(node)) {
            try {
                this.notFull.await();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (!linkFirst(node)) {
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
        lock.unlock();
        return true;
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Node<E> node = new Node<>(e2);
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (!linkLast(node)) {
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
        lock.unlock();
        return true;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        E x10 = pollFirst();
        if (x10 == null) {
            throw new NoSuchElementException();
        }
        return x10;
    }

    @Override // java.util.Deque
    public E removeLast() {
        E x10 = pollLast();
        if (x10 == null) {
            throw new NoSuchElementException();
        }
        return x10;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return unlinkFirst();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E pollLast() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return unlinkLast();
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        while (true) {
            try {
                E x10 = unlinkFirst();
                if (x10 != null) {
                    return x10;
                }
                this.notEmpty.await();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        while (true) {
            try {
                E x10 = unlinkLast();
                if (x10 != null) {
                    return x10;
                }
                this.notEmpty.await();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (true) {
            try {
                E x10 = unlinkFirst();
                if (x10 != null) {
                    return x10;
                }
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
    }

    @Override // java.util.concurrent.BlockingDeque
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        while (true) {
            try {
                E x10 = unlinkLast();
                if (x10 != null) {
                    return x10;
                }
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
    }

    @Override // java.util.Deque
    public E getFirst() {
        E x10 = peekFirst();
        if (x10 == null) {
            throw new NoSuchElementException();
        }
        return x10;
    }

    @Override // java.util.Deque
    public E getLast() {
        E x10 = peekLast();
        if (x10 == null) {
            throw new NoSuchElementException();
        }
        return x10;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Node<E> node = this.first;
            return node == null ? null : node.item;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.Deque
    public E peekLast() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Node<E> node = this.last;
            return node == null ? null : node.item;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean removeFirstOccurrence(Object o10) {
        if (o10 == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p10 = this.first; p10 != null; p10 = p10.next) {
                if (o10.equals(p10.item)) {
                    unlink(p10);
                    lock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public boolean removeLastOccurrence(Object o10) {
        if (o10 == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p10 = this.last; p10 != null; p10 = p10.prev) {
                if (o10.equals(p10.item)) {
                    unlink(p10);
                    lock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return offerLast(e2);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        return offerLast(e2, timeout, unit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return pollFirst(timeout, unit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.capacity - this.count;
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
        try {
            int min = Math.min(i10, this.count);
            for (int i11 = 0; i11 < min; i11++) {
                collection.add(this.first.item);
                unlinkFirst();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.Deque
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return removeFirstOccurrence(o10);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            for (Node<E> p10 = this.first; p10 != null; p10 = p10.next) {
                if (o10.equals(p10.item)) {
                    lock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        Node<E> beg = null;
        Node<E> end = null;
        int n10 = 0;
        for (E e2 : c4) {
            Objects.requireNonNull(e2);
            n10++;
            Node<E> newNode = new Node<>(e2);
            if (beg == null) {
                end = newNode;
                beg = newNode;
            } else {
                end.next = newNode;
                newNode.prev = end;
                end = newNode;
            }
        }
        if (beg == null) {
            return false;
        }
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (this.count + n10 <= this.capacity) {
                beg.prev = this.last;
                if (this.first == null) {
                    this.first = beg;
                } else {
                    this.last.next = beg;
                }
                this.last = end;
                this.count += n10;
                this.notEmpty.signalAll();
                lock.unlock();
                return true;
            }
            lock.unlock();
            return super.addAll(c4);
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] a10 = new Object[this.count];
            int k10 = 0;
            Node<E> p10 = this.first;
            while (p10 != null) {
                int k11 = k10 + 1;
                a10[k10] = p10.item;
                p10 = p10.next;
                k10 = k11;
            }
            return a10;
        } finally {
            lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i10 = 0;
            Node<E> node = this.first;
            while (node != null) {
                tArr[i10] = node.item;
                node = node.next;
                i10++;
            }
            if (tArr.length > i10) {
                tArr[i10] = 0;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
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
            Node<E> f10 = this.first;
            while (f10 != null) {
                f10.item = null;
                Node<E> n10 = f10.next;
                f10.prev = null;
                f10.next = null;
                f10 = n10;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    Node<E> succ(Node<E> p10) {
        Node<E> p11 = p10.next;
        return p10 == p11 ? this.first : p11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        abstract Node<E> firstNode();

        abstract Node<E> nextNode(Node<E> node);

        private Node<E> succ(Node<E> p10) {
            Node<E> p11 = nextNode(p10);
            return p10 == p11 ? firstNode() : p11;
        }

        AbstractItr() {
            ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try {
                Node<E> firstNode = firstNode();
                this.next = firstNode;
                if (firstNode != null) {
                    this.nextItem = firstNode.item;
                }
            } finally {
                lock.unlock();
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
            ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            E e2 = null;
            try {
                Node<E> p11 = nextNode(p10);
                while (p11 != null) {
                    E e10 = p11.item;
                    e2 = e10;
                    if (e10 != null) {
                        break;
                    }
                    p11 = succ(p11);
                }
                this.next = p11;
                this.nextItem = e2;
                return x10;
            } finally {
                lock.unlock();
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
            ReentrantLock lock = LinkedBlockingDeque.this.lock;
            Object[] es = null;
            int len = 1;
            do {
                lock.lock();
                if (es == null) {
                    try {
                        Node<E> q10 = nextNode(p10);
                        p10 = q10;
                        while (q10 != null && (q10.item == null || (len = len + 1) != 64)) {
                            q10 = succ(q10);
                        }
                        es = new Object[len];
                        es[0] = this.nextItem;
                        this.nextItem = null;
                        n10 = 1;
                    } catch (Throwable th) {
                        lock.unlock();
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
                    p10 = succ(p10);
                }
                lock.unlock();
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
            Node<E> n10 = this.lastRet;
            if (n10 == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try {
                if (n10.item != null) {
                    LinkedBlockingDeque.this.unlink(n10);
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Itr extends LinkedBlockingDeque<E>.AbstractItr {
        Itr() {
            super();
        }

        @Override // java.util.concurrent.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // java.util.concurrent.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> n10) {
            return n10.next;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DescendingItr extends LinkedBlockingDeque<E>.AbstractItr {
        DescendingItr() {
            super();
        }

        @Override // java.util.concurrent.LinkedBlockingDeque.AbstractItr
        Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // java.util.concurrent.LinkedBlockingDeque.AbstractItr
        Node<E> nextNode(Node<E> n10) {
            return n10.prev;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private final class LBDSpliterator implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        long est;
        boolean exhausted;

        LBDSpliterator() {
            this.est = LinkedBlockingDeque.this.size();
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.Spliterator<E> trySplit() {
            /*
                r13 = this;
                boolean r0 = r13.exhausted
                if (r0 != 0) goto L76
                java.util.concurrent.LinkedBlockingDeque$Node<E> r0 = r13.current
                r1 = r0
                if (r0 != 0) goto L10
                java.util.concurrent.LinkedBlockingDeque r0 = java.util.concurrent.LinkedBlockingDeque.this
                java.util.concurrent.LinkedBlockingDeque$Node<E> r0 = r0.first
                r1 = r0
                if (r0 == 0) goto L76
            L10:
                java.util.concurrent.LinkedBlockingDeque$Node<E> r0 = r1.next
                if (r0 == 0) goto L76
                int r0 = r13.batch
                r2 = 1
                int r0 = r0 + r2
                r3 = 33554432(0x2000000, float:9.403955E-38)
                int r0 = java.lang.Math.min(r0, r3)
                r13.batch = r0
                java.lang.Object[] r3 = new java.lang.Object[r0]
                java.util.concurrent.LinkedBlockingDeque r4 = java.util.concurrent.LinkedBlockingDeque.this
                java.util.concurrent.locks.ReentrantLock r4 = r4.lock
                r5 = 0
                java.util.concurrent.LinkedBlockingDeque$Node<E> r6 = r13.current
                r4.lock()
                if (r6 != 0) goto L38
                java.util.concurrent.LinkedBlockingDeque r7 = java.util.concurrent.LinkedBlockingDeque.this     // Catch: java.lang.Throwable -> L36
                java.util.concurrent.LinkedBlockingDeque$Node<E> r7 = r7.first     // Catch: java.lang.Throwable -> L36
                r6 = r7
                if (r7 == 0) goto L50
                goto L38
            L36:
                r2 = move-exception
                goto L4c
            L38:
                if (r6 == 0) goto L50
                if (r5 >= r0) goto L50
                E r7 = r6.item     // Catch: java.lang.Throwable -> L36
                r3[r5] = r7     // Catch: java.lang.Throwable -> L36
                if (r7 == 0) goto L44
                int r5 = r5 + 1
            L44:
                java.util.concurrent.LinkedBlockingDeque r7 = java.util.concurrent.LinkedBlockingDeque.this     // Catch: java.lang.Throwable -> L36
                java.util.concurrent.LinkedBlockingDeque$Node r7 = r7.succ(r6)     // Catch: java.lang.Throwable -> L36
                r6 = r7
                goto L38
            L4c:
                r4.unlock()
                throw r2
            L50:
                r4.unlock()
                r13.current = r6
                r7 = 0
                if (r6 != 0) goto L5f
                r13.est = r7
                r13.exhausted = r2
                goto L6b
            L5f:
                long r9 = r13.est
                long r11 = (long) r5
                long r9 = r9 - r11
                r13.est = r9
                int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r2 >= 0) goto L6b
                r13.est = r7
            L6b:
                if (r5 <= 0) goto L76
            L6e:
                r2 = 0
                r7 = 4368(0x1110, float:6.121E-42)
                java.util.Spliterator r2 = java.util.Spliterators.spliterator(r3, r2, r5, r7)
                return r2
            L76:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingDeque.LBDSpliterator.trySplit():java.util.Spliterator");
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            if (r2 != null) goto L28;
         */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r5) {
            /*
                r4 = this;
                java.util.Objects.requireNonNull(r5)
                boolean r0 = r4.exhausted
                if (r0 != 0) goto L3f
                r0 = 0
                java.util.concurrent.LinkedBlockingDeque r1 = java.util.concurrent.LinkedBlockingDeque.this
                java.util.concurrent.locks.ReentrantLock r1 = r1.lock
                r1.lock()
                java.util.concurrent.LinkedBlockingDeque$Node<E> r2 = r4.current     // Catch: java.lang.Throwable -> L3a
                r3 = r2
                if (r2 != 0) goto L1b
                java.util.concurrent.LinkedBlockingDeque r2 = java.util.concurrent.LinkedBlockingDeque.this     // Catch: java.lang.Throwable -> L3a
                java.util.concurrent.LinkedBlockingDeque$Node<E> r2 = r2.first     // Catch: java.lang.Throwable -> L3a
                r3 = r2
                if (r2 == 0) goto L29
            L1b:
                E r2 = r3.item     // Catch: java.lang.Throwable -> L3a
                r0 = r2
                java.util.concurrent.LinkedBlockingDeque r2 = java.util.concurrent.LinkedBlockingDeque.this     // Catch: java.lang.Throwable -> L3a
                java.util.concurrent.LinkedBlockingDeque$Node r2 = r2.succ(r3)     // Catch: java.lang.Throwable -> L3a
                r3 = r2
                if (r0 != 0) goto L29
                if (r3 != 0) goto L1b
            L29:
                r4.current = r3     // Catch: java.lang.Throwable -> L3a
                r2 = 1
                if (r3 != 0) goto L30
                r4.exhausted = r2     // Catch: java.lang.Throwable -> L3a
            L30:
                r1.unlock()
                if (r0 == 0) goto L3f
                r5.accept(r0)
                return r2
            L3a:
                r2 = move-exception
                r1.unlock()
                throw r2
            L3f:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedBlockingDeque.LBDSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            if (!this.exhausted) {
                this.exhausted = true;
                Node<E> p10 = this.current;
                this.current = null;
                LinkedBlockingDeque.this.forEachFrom(action, p10);
            }
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new LBDSpliterator();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        forEachFrom(action, null);
    }

    void forEachFrom(Consumer<? super E> action, Node<E> p10) {
        ReentrantLock lock = this.lock;
        Object[] es = null;
        int len = 0;
        do {
            lock.lock();
            if (es == null) {
                if (p10 == null) {
                    try {
                        p10 = this.first;
                    } catch (Throwable th) {
                        lock.unlock();
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
            lock.unlock();
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedBlockingDeque$$ExternalSyntheticLambda0
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
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedBlockingDeque$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return LinkedBlockingDeque.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    private boolean bulkRemove(Predicate<? super E> predicate) {
        ReentrantLock reentrantLock = this.lock;
        int i10 = 0;
        Node<E>[] nodeArr = null;
        Node<E> node = null;
        boolean z10 = false;
        while (true) {
            reentrantLock.lock();
            if (nodeArr == null) {
                try {
                    Node<E> node2 = this.first;
                    node = node2;
                    while (node2 != null && (node2.item == null || (i10 = i10 + 1) != 64)) {
                        node2 = succ(node2);
                    }
                    nodeArr = new Node[i10];
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
            Node<E> node3 = node;
            int i11 = 0;
            while (node3 != null && i11 < i10) {
                int i12 = i11 + 1;
                try {
                    nodeArr[i11] = node3;
                    node3 = succ(node3);
                    i11 = i12;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
            reentrantLock.unlock();
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                E e2 = nodeArr[i13].item;
                if (e2 != null && predicate.test(e2)) {
                    j10 |= 1 << i13;
                }
            }
            if (j10 != 0) {
                reentrantLock.lock();
                for (int i14 = 0; i14 < i11; i14++) {
                    if (((1 << i14) & j10) != 0) {
                        try {
                            Node<E> node4 = nodeArr[i14];
                            if (node4.item != null) {
                                unlink(node4);
                                z10 = true;
                            }
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                    nodeArr[i14] = null;
                }
            }
            if (i11 <= 0 || node3 == null) {
                break;
            }
            node = node3;
        }
        return z10;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            s2.defaultWriteObject();
            for (Node<E> p10 = this.first; p10 != null; p10 = p10.next) {
                s2.writeObject(p10.item);
            }
            s2.writeObject(null);
        } finally {
            lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = s2.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    void checkInvariants() {
        for (Node<E> p10 = this.first; p10 != null; p10 = p10.next) {
        }
    }
}
