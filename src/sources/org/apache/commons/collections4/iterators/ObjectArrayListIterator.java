package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ObjectArrayListIterator(E... eArr) {
        super(eArr);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(E e2) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index > getStartIndex();
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, java.util.Iterator
    public E next() {
        if (hasNext()) {
            int i10 = this.index;
            this.lastItemIndex = i10;
            E[] eArr = this.array;
            this.index = i10 + 1;
            return eArr[i10];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - getStartIndex();
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (hasPrevious()) {
            int i10 = this.index - 1;
            this.index = i10;
            this.lastItemIndex = i10;
            return this.array[i10];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - getStartIndex()) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(E e2) {
        int i10 = this.lastItemIndex;
        if (i10 != -1) {
            this.array[i10] = e2;
            return;
        }
        throw new IllegalStateException("must call next() or previous() before a call to set()");
    }

    public ObjectArrayListIterator(E[] eArr, int i10) {
        super(eArr, i10);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(E[] eArr, int i10, int i11) {
        super(eArr, i10, i11);
        this.lastItemIndex = -1;
    }
}
