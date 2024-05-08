package org.apache.commons.collections4.iterators;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ListIteratorWrapper<E> implements ResettableListIterator<E> {
    private static final String CANNOT_REMOVE_MESSAGE = "Cannot remove element at index {0}.";
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";
    private final Iterator<? extends E> iterator;
    private boolean removeState;
    private final List<E> list = new ArrayList();
    private int currentIndex = 0;
    private int wrappedIteratorIndex = 0;

    public ListIteratorWrapper(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterator = it;
    }

    @Override // java.util.ListIterator
    public void add(E e2) throws UnsupportedOperationException {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            ((ListIterator) it).add(e2);
            return;
        }
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex == this.wrappedIteratorIndex || (this.iterator instanceof ListIterator)) {
            return this.iterator.hasNext();
        }
        return true;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return ((ListIterator) it).hasPrevious();
        }
        return this.currentIndex > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() throws NoSuchElementException {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return it.next();
        }
        int i10 = this.currentIndex;
        if (i10 < this.wrappedIteratorIndex) {
            int i11 = i10 + 1;
            this.currentIndex = i11;
            return this.list.get(i11 - 1);
        }
        E next = it.next();
        this.list.add(next);
        this.currentIndex++;
        this.wrappedIteratorIndex++;
        this.removeState = true;
        return next;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return ((ListIterator) it).nextIndex();
        }
        return this.currentIndex;
    }

    @Override // java.util.ListIterator
    public E previous() throws NoSuchElementException {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return (E) ((ListIterator) it).previous();
        }
        int i10 = this.currentIndex;
        if (i10 != 0) {
            this.removeState = this.wrappedIteratorIndex == i10;
            List<E> list = this.list;
            int i11 = i10 - 1;
            this.currentIndex = i11;
            return list.get(i11);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            return ((ListIterator) it).previousIndex();
        }
        return this.currentIndex - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            it.remove();
            return;
        }
        int i10 = this.currentIndex;
        int i11 = this.wrappedIteratorIndex;
        int i12 = i10 == i11 ? i10 - 1 : i10;
        if (this.removeState && i11 - i10 <= 1) {
            it.remove();
            this.list.remove(i12);
            this.currentIndex = i12;
            this.wrappedIteratorIndex--;
            this.removeState = false;
            return;
        }
        throw new IllegalStateException(MessageFormat.format(CANNOT_REMOVE_MESSAGE, Integer.valueOf(i12)));
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            ListIterator listIterator = (ListIterator) it;
            while (listIterator.previousIndex() >= 0) {
                listIterator.previous();
            }
            return;
        }
        this.currentIndex = 0;
    }

    @Override // java.util.ListIterator
    public void set(E e2) throws UnsupportedOperationException {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ListIterator) {
            ((ListIterator) it).set(e2);
            return;
        }
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }
}
