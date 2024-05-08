package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LoopingIterator<E> implements ResettableIterator<E> {
    private final Collection<? extends E> collection;
    private Iterator<? extends E> iterator;

    public LoopingIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "The collection must not be null");
        this.collection = collection;
        reset();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.collection.size() > 0;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.collection.size() != 0) {
            if (!this.iterator.hasNext()) {
                reset();
            }
            return this.iterator.next();
        }
        throw new NoSuchElementException("There are no elements for this iterator to loop on");
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.iterator = this.collection.iterator2();
    }

    public int size() {
        return this.collection.size();
    }
}
