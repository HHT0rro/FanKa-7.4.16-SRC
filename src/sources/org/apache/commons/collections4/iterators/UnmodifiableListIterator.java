package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnmodifiableListIterator<E> implements ListIterator<E>, Unmodifiable {
    private final ListIterator<? extends E> iterator;

    private UnmodifiableListIterator(ListIterator<? extends E> listIterator) {
        this.iterator = listIterator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ListIterator<E> umodifiableListIterator(ListIterator<? extends E> listIterator) {
        Objects.requireNonNull(listIterator, "ListIterator must not be null");
        return listIterator instanceof Unmodifiable ? listIterator : new UnmodifiableListIterator(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(E e2) {
        throw new UnsupportedOperationException("add() is not supported");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator
    public E previous() {
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.ListIterator
    public void set(E e2) {
        throw new UnsupportedOperationException("set() is not supported");
    }
}
