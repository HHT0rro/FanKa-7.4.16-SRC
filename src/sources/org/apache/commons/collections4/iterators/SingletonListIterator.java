package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SingletonListIterator<E> implements ResettableListIterator<E> {
    private E object;
    private boolean beforeFirst = true;
    private boolean nextCalled = false;
    private boolean removed = false;

    public SingletonListIterator(E e2) {
        this.object = e2;
    }

    @Override // java.util.ListIterator
    public void add(E e2) {
        throw new UnsupportedOperationException("add() is not supported by this iterator");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return (this.beforeFirst || this.removed) ? false : true;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (this.beforeFirst && !this.removed) {
            this.beforeFirst = false;
            this.nextCalled = true;
            return this.object;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return !this.beforeFirst ? 1 : 0;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!this.beforeFirst && !this.removed) {
            this.beforeFirst = true;
            return this.object;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.beforeFirst ? -1 : 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (this.nextCalled && !this.removed) {
            this.object = null;
            this.removed = true;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
        this.nextCalled = false;
    }

    @Override // java.util.ListIterator
    public void set(E e2) {
        if (this.nextCalled && !this.removed) {
            this.object = e2;
            return;
        }
        throw new IllegalStateException();
    }
}
