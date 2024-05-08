package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FilterIterator<E> implements Iterator<E> {
    private Iterator<? extends E> iterator;
    private E nextObject;
    private boolean nextObjectSet = false;
    private Predicate<? super E> predicate;

    public FilterIterator() {
    }

    private boolean setNextObject() {
        while (this.iterator.hasNext()) {
            E next = this.iterator.next();
            if (this.predicate.evaluate(next)) {
                this.nextObject = next;
                this.nextObjectSet = true;
                return true;
            }
        }
        return false;
    }

    public Iterator<? extends E> getIterator() {
        return this.iterator;
    }

    public Predicate<? super E> getPredicate() {
        return this.predicate;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextObjectSet || setNextObject();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!this.nextObjectSet && !setNextObject()) {
            throw new NoSuchElementException();
        }
        this.nextObjectSet = false;
        return this.nextObject;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.nextObjectSet) {
            this.iterator.remove();
            return;
        }
        throw new IllegalStateException("remove() cannot be called");
    }

    public void setIterator(Iterator<? extends E> it) {
        this.iterator = it;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    public void setPredicate(Predicate<? super E> predicate) {
        this.predicate = predicate;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    public FilterIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    public FilterIterator(Iterator<? extends E> it, Predicate<? super E> predicate) {
        this.iterator = it;
        this.predicate = predicate;
    }
}
