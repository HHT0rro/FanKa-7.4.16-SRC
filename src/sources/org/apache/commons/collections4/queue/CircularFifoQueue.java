package org.apache.commons.collections4.queue;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CircularFifoQueue<E> extends AbstractCollection<E> implements Queue<E>, BoundedCollection<E>, Serializable {
    private static final long serialVersionUID = -8423413834657610406L;
    private transient E[] elements;
    private transient int end;
    private transient boolean full;
    private final int maxElements;
    private transient int start;

    public CircularFifoQueue() {
        this(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i10) {
        int i11 = i10 - 1;
        return i11 < 0 ? this.maxElements - 1 : i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.maxElements) {
            return 0;
        }
        return i11;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.elements = (E[]) new Object[this.maxElements];
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            ((E[]) this.elements)[i10] = objectInputStream.readObject();
        }
        this.start = 0;
        boolean z10 = readInt == this.maxElements;
        this.full = z10;
        if (z10) {
            this.end = 0;
        } else {
            this.end = readInt;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            objectOutputStream.writeObject(iterator2.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        Objects.requireNonNull(e2, "Attempted to add null object to queue");
        if (isAtFullCapacity()) {
            remove();
        }
        E[] eArr = this.elements;
        int i10 = this.end;
        int i11 = i10 + 1;
        this.end = i11;
        eArr[i10] = e2;
        if (i11 >= this.maxElements) {
            this.end = 0;
        }
        if (this.end == this.start) {
            this.full = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (!isEmpty()) {
            return peek();
        }
        throw new NoSuchElementException("queue is empty");
    }

    public E get(int i10) {
        int size = size();
        if (i10 >= 0 && i10 < size) {
            return this.elements[(this.start + i10) % this.maxElements];
        }
        throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", Integer.valueOf(i10), Integer.valueOf(size)));
    }

    public boolean isAtFullCapacity() {
        return size() == this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Iterator<E>() { // from class: org.apache.commons.collections4.queue.CircularFifoQueue.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = CircularFifoQueue.this.start;
                this.isFirst = CircularFifoQueue.this.full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != CircularFifoQueue.this.end;
            }

            @Override // java.util.Iterator
            public E next() {
                if (hasNext()) {
                    this.isFirst = false;
                    int i10 = this.index;
                    this.lastReturnedIndex = i10;
                    this.index = CircularFifoQueue.this.increment(i10);
                    return (E) CircularFifoQueue.this.elements[this.lastReturnedIndex];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                int i10 = this.lastReturnedIndex;
                if (i10 != -1) {
                    if (i10 == CircularFifoQueue.this.start) {
                        CircularFifoQueue.this.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int i11 = this.lastReturnedIndex + 1;
                    if (CircularFifoQueue.this.start < this.lastReturnedIndex && i11 < CircularFifoQueue.this.end) {
                        System.arraycopy(CircularFifoQueue.this.elements, i11, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - i11);
                    } else {
                        while (i11 != CircularFifoQueue.this.end) {
                            if (i11 >= CircularFifoQueue.this.maxElements) {
                                CircularFifoQueue.this.elements[i11 - 1] = CircularFifoQueue.this.elements[0];
                                i11 = 0;
                            } else {
                                CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(i11)] = CircularFifoQueue.this.elements[i11];
                                i11 = CircularFifoQueue.this.increment(i11);
                            }
                        }
                    }
                    this.lastReturnedIndex = -1;
                    CircularFifoQueue circularFifoQueue = CircularFifoQueue.this;
                    circularFifoQueue.end = circularFifoQueue.decrement(circularFifoQueue.end);
                    CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
                    CircularFifoQueue.this.full = false;
                    this.index = CircularFifoQueue.this.decrement(this.index);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return this.maxElements;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return add(e2);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.elements[this.start];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (!isEmpty()) {
            E[] eArr = this.elements;
            int i10 = this.start;
            E e2 = eArr[i10];
            if (e2 != null) {
                int i11 = i10 + 1;
                this.start = i11;
                eArr[i10] = null;
                if (i11 >= this.maxElements) {
                    this.start = 0;
                }
                this.full = false;
            }
            return e2;
        }
        throw new NoSuchElementException("queue is empty");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        int i10 = this.end;
        int i11 = this.start;
        if (i10 < i11) {
            return (this.maxElements - i11) + i10;
        }
        if (i10 != i11) {
            return i10 - i11;
        }
        if (this.full) {
            return this.maxElements;
        }
        return 0;
    }

    public CircularFifoQueue(int i10) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i10 > 0) {
            E[] eArr = (E[]) new Object[i10];
            this.elements = eArr;
            this.maxElements = eArr.length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }

    public CircularFifoQueue(Collection<? extends E> collection) {
        this(collection.size());
        addAll(collection);
    }
}
