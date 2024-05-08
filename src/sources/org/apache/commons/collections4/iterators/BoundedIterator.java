package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BoundedIterator<E> implements Iterator<E> {
    private final Iterator<? extends E> iterator;
    private final long max;
    private final long offset;
    private long pos;

    public BoundedIterator(Iterator<? extends E> it, long j10, long j11) {
        Objects.requireNonNull(it, "Iterator must not be null");
        if (j10 < 0) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        if (j11 >= 0) {
            this.iterator = it;
            this.offset = j10;
            this.max = j11;
            this.pos = 0L;
            init();
            return;
        }
        throw new IllegalArgumentException("Max parameter must not be negative.");
    }

    private boolean checkBounds() {
        return (this.pos - this.offset) + 1 <= this.max;
    }

    private void init() {
        while (this.pos < this.offset && this.iterator.hasNext()) {
            this.iterator.next();
            this.pos++;
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (checkBounds()) {
            return this.iterator.hasNext();
        }
        return false;
    }

    @Override // java.util.Iterator
    public E next() {
        if (checkBounds()) {
            E next = this.iterator.next();
            this.pos++;
            return next;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.pos > this.offset) {
            this.iterator.remove();
            return;
        }
        throw new IllegalStateException("remove() can not be called before calling next()");
    }
}
