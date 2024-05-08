package com.nostra13.universalimageloader.core.assist.deque;

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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingQueue, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    public transient e<E> first;
    public transient e<E> last;
    public final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public abstract class b implements Iterator<E> {

        /* renamed from: b, reason: collision with root package name */
        public e<E> f37743b;

        /* renamed from: c, reason: collision with root package name */
        public E f37744c;

        /* renamed from: d, reason: collision with root package name */
        public e<E> f37745d;

        public b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b4 = b();
                this.f37743b = b4;
                this.f37744c = b4 == null ? null : b4.f37749a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d10 = d(this.f37743b);
                this.f37743b = d10;
                this.f37744c = d10 == null ? null : d10.f37749a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract e<E> b();

        public abstract e<E> c(e<E> eVar);

        public final e<E> d(e<E> eVar) {
            while (true) {
                e<E> c4 = c(eVar);
                if (c4 == null) {
                    return null;
                }
                if (c4.f37749a != null) {
                    return c4;
                }
                if (c4 == eVar) {
                    return b();
                }
                eVar = c4;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f37743b != null;
        }

        @Override // java.util.Iterator
        public E next() {
            e<E> eVar = this.f37743b;
            if (eVar != null) {
                this.f37745d = eVar;
                E e2 = this.f37744c;
                a();
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            e<E> eVar = this.f37745d;
            if (eVar != null) {
                this.f37745d = null;
                ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (eVar.f37749a != null) {
                        LinkedBlockingDeque.this.unlink(eVar);
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class c extends LinkedBlockingDeque<E>.b {
        public c() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> b() {
            return LinkedBlockingDeque.this.last;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f37750b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class d extends LinkedBlockingDeque<E>.b {
        public d() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> b() {
            return LinkedBlockingDeque.this.first;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.b
        public e<E> c(e<E> eVar) {
            return eVar.f37751c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class e<E> {

        /* renamed from: a, reason: collision with root package name */
        public E f37749a;

        /* renamed from: b, reason: collision with root package name */
        public e<E> f37750b;

        /* renamed from: c, reason: collision with root package name */
        public e<E> f37751c;

        public e(E e2) {
            this.f37749a = e2;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        int i10 = this.count;
        if (i10 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.f37751c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.f37750b = eVar;
        }
        this.count = i10 + 1;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        int i10 = this.count;
        if (i10 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.f37750b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.f37751c = eVar;
        }
        this.count = i10 + 1;
        this.notEmpty.signal();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }

    private E unlinkFirst() {
        e<E> eVar = this.first;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f37751c;
        E e2 = eVar.f37749a;
        eVar.f37749a = null;
        eVar.f37751c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.f37750b = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f37750b;
        E e2 = eVar.f37749a;
        eVar.f37749a = null;
        eVar.f37750b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.f37751c = null;
        }
        this.count--;
        this.notFull.signal();
        return e2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f37751c) {
                objectOutputStream.writeObject(eVar.f37749a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public void addFirst(E e2) {
        if (!offerFirst(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e2) {
        if (!offerLast(e2)) {
            throw new IllegalStateException("Deque full");
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            while (eVar != null) {
                eVar.f37749a = null;
                e<E> eVar2 = eVar.f37751c;
                eVar.f37750b = null;
                eVar.f37751c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f37751c) {
                if (obj.equals(eVar.f37749a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new d();
    }

    public boolean offer(E e2) {
        return offerLast(e2);
    }

    public boolean offerFirst(E e2) {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e2) {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            return eVar == null ? null : eVar.f37749a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.last;
            return eVar == null ? null : eVar.f37749a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.Queue
    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e2) {
        addFirst(e2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        putLast(e2);
    }

    public void putFirst(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e2) throws InterruptedException {
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f37751c) {
                if (obj.equals(eVar.f37749a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.f37750b) {
                if (obj.equals(eVar.f37749a)) {
                    unlink(eVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i10 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                int i11 = i10 + 1;
                objArr[i10] = eVar.f37749a;
                eVar = eVar.f37751c;
                i10 = i11;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            if (eVar == null) {
                return "[]";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            while (true) {
                Object obj = eVar.f37749a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb2.append(obj);
                eVar = eVar.f37751c;
                if (eVar == null) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(',');
                sb2.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.f37750b;
        e<E> eVar3 = eVar.f37751c;
        if (eVar2 == null) {
            unlinkFirst();
            return;
        }
        if (eVar3 == null) {
            unlinkLast();
            return;
        }
        eVar2.f37751c = eVar3;
        eVar3.f37750b = eVar2;
        eVar.f37749a = null;
        this.count--;
        this.notFull.signal();
    }

    public LinkedBlockingDeque(int i10) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i10 > 0) {
            this.capacity = i10;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i10) {
        Objects.requireNonNull(collection);
        if (collection != this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i10, this.count);
                for (int i11 = 0; i11 < min; i11++) {
                    collection.add(this.first.f37749a);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long j10, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e2, j10, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j10, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j10, timeUnit);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E pollFirst(long j10, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast(long j10, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e2, long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10;
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkFirst(eVar)) {
                    z10 = true;
                    break;
                }
                if (nanos <= 0) {
                    z10 = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z10;
    }

    public boolean offerLast(E e2, long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10;
        Objects.requireNonNull(e2);
        e<E> eVar = new e<>(e2);
        long nanos = timeUnit.toNanos(j10);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkLast(eVar)) {
                    z10 = true;
                    break;
                }
                if (nanos <= 0) {
                    z10 = false;
                    break;
                }
                nanos = this.notFull.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        return z10;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e2 : collection) {
                if (e2 != null) {
                    if (!linkLast(new e<>(e2))) {
                        throw new IllegalStateException("Deque full");
                    }
                } else {
                    throw new NullPointerException();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            int i10 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                tArr[i10] = eVar.f37749a;
                eVar = eVar.f37751c;
                i10++;
            }
            if (tArr.length > i10) {
                tArr[i10] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }
}
