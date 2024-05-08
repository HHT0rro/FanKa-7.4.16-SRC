package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ObjectGraphIterator<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private E currentValue;
    private boolean hasNext;
    private Iterator<? extends E> lastUsedIterator;
    private E root;
    private final Deque<Iterator<? extends E>> stack;
    private final Transformer<? super E, ? extends E> transformer;

    public ObjectGraphIterator(E e2, Transformer<? super E, ? extends E> transformer) {
        this.stack = new ArrayDeque(8);
        this.hasNext = false;
        if (e2 instanceof Iterator) {
            this.currentIterator = (Iterator) e2;
        } else {
            this.root = e2;
        }
        this.transformer = transformer;
    }

    public void findNext(E e2) {
        if (e2 instanceof Iterator) {
            findNextByIterator((Iterator) e2);
        } else {
            this.currentValue = e2;
            this.hasNext = true;
        }
    }

    public void findNextByIterator(Iterator<? extends E> it) {
        Iterator<? extends E> it2 = this.currentIterator;
        if (it != it2) {
            if (it2 != null) {
                this.stack.push(it2);
            }
            this.currentIterator = it;
        }
        while (this.currentIterator.hasNext() && !this.hasNext) {
            E next = this.currentIterator.next();
            Transformer<? super E, ? extends E> transformer = this.transformer;
            if (transformer != null) {
                next = transformer.transform(next);
            }
            findNext(next);
        }
        if (this.hasNext || this.stack.isEmpty()) {
            return;
        }
        Iterator<? extends E> pop = this.stack.pop();
        this.currentIterator = pop;
        findNextByIterator(pop);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        if (this.hasNext) {
            this.lastUsedIterator = this.currentIterator;
            E e2 = this.currentValue;
            this.currentValue = null;
            this.hasNext = false;
            return e2;
        }
        throw new NoSuchElementException("No more elements in the iteration");
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterator<? extends E> it = this.lastUsedIterator;
        if (it != null) {
            it.remove();
            this.lastUsedIterator = null;
            return;
        }
        throw new IllegalStateException("Iterator remove() cannot be called at this time");
    }

    public void updateCurrentIterator() {
        if (this.hasNext) {
            return;
        }
        Iterator<? extends E> it = this.currentIterator;
        if (it == null) {
            E e2 = this.root;
            if (e2 == null) {
                return;
            }
            Transformer<? super E, ? extends E> transformer = this.transformer;
            if (transformer == null) {
                findNext(e2);
            } else {
                findNext(transformer.transform(e2));
            }
            this.root = null;
            return;
        }
        findNextByIterator(it);
    }

    public ObjectGraphIterator(Iterator<? extends E> it) {
        this.stack = new ArrayDeque(8);
        this.hasNext = false;
        this.currentIterator = it;
        this.transformer = null;
    }
}
