package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ArrayListIterator(Object obj) {
        super(obj);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, java.util.Iterator
    public E next() {
        if (hasNext()) {
            int i10 = this.index;
            this.lastItemIndex = i10;
            Object obj = this.array;
            this.index = i10 + 1;
            return (E) Array.get(obj, i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - this.startIndex;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (hasPrevious()) {
            int i10 = this.index - 1;
            this.index = i10;
            this.lastItemIndex = i10;
            return (E) Array.get(this.array, i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        int i10 = this.lastItemIndex;
        if (i10 != -1) {
            Array.set(this.array, i10, obj);
            return;
        }
        throw new IllegalStateException("must call next() or previous() before a call to set()");
    }

    public ArrayListIterator(Object obj, int i10) {
        super(obj, i10);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i10, int i11) {
        super(obj, i10, i11);
        this.lastItemIndex = -1;
    }
}
