package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class AbstractEmptyIterator<E> {
    public void add(E e2) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void reset() {
    }

    public void set(E e2) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
