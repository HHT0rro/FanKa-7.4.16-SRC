package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IteratorIterable<E> implements Iterable<E> {
    private final Iterator<? extends E> iterator;
    private final Iterator<E> typeSafeIterator;

    public IteratorIterable(Iterator<? extends E> it) {
        this(it, false);
    }

    private static <E> Iterator<E> createTypesafeIterator(final Iterator<? extends E> it) {
        return new Iterator<E>() { // from class: org.apache.commons.collections4.iterators.IteratorIterable.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return Iterator.this.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                return (E) Iterator.this.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                Iterator.this.remove();
            }
        };
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ResettableIterator) {
            ((ResettableIterator) it).reset();
        }
        return this.typeSafeIterator;
    }

    public IteratorIterable(Iterator<? extends E> it, boolean z10) {
        if (z10 && !(it instanceof ResettableIterator)) {
            this.iterator = new ListIteratorWrapper(it);
        } else {
            this.iterator = it;
        }
        this.typeSafeIterator = createTypesafeIterator(this.iterator);
    }
}
