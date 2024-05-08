package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.FluentIterable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZippingIterator<E> implements Iterator<E> {
    private final Iterator<Iterator<? extends E>> iterators;
    private Iterator<? extends E> lastReturned;
    private Iterator<? extends E> nextIterator;

    public ZippingIterator(Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(it, it2);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextIterator != null) {
            return true;
        }
        while (this.iterators.hasNext()) {
            Iterator<? extends E> next = this.iterators.next();
            if (next.hasNext()) {
                this.nextIterator = next;
                return true;
            }
            this.iterators.remove();
        }
        return false;
    }

    @Override // java.util.Iterator
    public E next() throws NoSuchElementException {
        if (hasNext()) {
            E next = this.nextIterator.next();
            this.lastReturned = this.nextIterator;
            this.nextIterator = null;
            return next;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterator<? extends E> it = this.lastReturned;
        if (it != null) {
            it.remove();
            this.lastReturned = null;
            return;
        }
        throw new IllegalStateException("No value can be removed at present");
    }

    public ZippingIterator(Iterator<? extends E> it, Iterator<? extends E> it2, Iterator<? extends E> it3) {
        this(it, it2, it3);
    }

    public ZippingIterator(Iterator<? extends E>... itArr) {
        this.nextIterator = null;
        this.lastReturned = null;
        ArrayList arrayList = new ArrayList();
        for (Iterator<? extends E> it : itArr) {
            Objects.requireNonNull(it, "Iterator must not be null.");
            arrayList.add(it);
        }
        this.iterators = FluentIterable.of((Iterable) arrayList).loop().iterator2();
    }
}
