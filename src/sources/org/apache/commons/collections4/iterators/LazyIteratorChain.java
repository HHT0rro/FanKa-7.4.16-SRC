package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class LazyIteratorChain<E> implements Iterator<E> {
    private int callCounter = 0;
    private boolean chainExhausted = false;
    private Iterator<? extends E> currentIterator = null;
    private Iterator<? extends E> lastUsedIterator = null;

    private void updateCurrentIterator() {
        int i10 = this.callCounter;
        if (i10 == 0) {
            int i11 = i10 + 1;
            this.callCounter = i11;
            Iterator<? extends E> nextIterator = nextIterator(i11);
            this.currentIterator = nextIterator;
            if (nextIterator == null) {
                this.currentIterator = EmptyIterator.emptyIterator();
                this.chainExhausted = true;
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.chainExhausted) {
            int i12 = this.callCounter + 1;
            this.callCounter = i12;
            Iterator<? extends E> nextIterator2 = nextIterator(i12);
            if (nextIterator2 != null) {
                this.currentIterator = nextIterator2;
            } else {
                this.chainExhausted = true;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    public abstract Iterator<? extends E> nextIterator(int i10);

    @Override // java.util.Iterator
    public void remove() {
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
