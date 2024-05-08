package org.apache.commons.collections4.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableListIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LoopingListIterator<E> implements ResettableListIterator<E> {
    private ListIterator<E> iterator;
    private final List<E> list;

    public LoopingListIterator(List<E> list) {
        Objects.requireNonNull(list, "The list must not be null");
        this.list = list;
        _reset();
    }

    private void _reset() {
        this.iterator = this.list.listIterator();
    }

    @Override // java.util.ListIterator
    public void add(E e2) {
        this.iterator.add(e2);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!this.list.isEmpty()) {
            if (!this.iterator.hasNext()) {
                reset();
            }
            return this.iterator.next();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        if (!this.list.isEmpty()) {
            if (this.iterator.hasNext()) {
                return this.iterator.nextIndex();
            }
            return 0;
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!this.list.isEmpty()) {
            if (!this.iterator.hasPrevious()) {
                E e2 = null;
                while (this.iterator.hasNext()) {
                    e2 = this.iterator.next();
                }
                this.iterator.previous();
                return e2;
            }
            return this.iterator.previous();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        if (!this.list.isEmpty()) {
            if (!this.iterator.hasPrevious()) {
                return this.list.size() - 1;
            }
            return this.iterator.previousIndex();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        _reset();
    }

    @Override // java.util.ListIterator
    public void set(E e2) {
        this.iterator.set(e2);
    }

    public int size() {
        return this.list.size();
    }
}
