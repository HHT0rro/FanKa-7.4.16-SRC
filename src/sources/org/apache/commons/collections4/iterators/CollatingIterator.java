package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CollatingIterator<E> implements Iterator<E> {
    private Comparator<? super E> comparator;
    private List<Iterator<? extends E>> iterators;
    private int lastReturned;
    private BitSet valueSet;
    private List<E> values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    private boolean anyHasNext(List<Iterator<? extends E>> list) {
        Iterator<Iterator<? extends E>> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().hasNext()) {
                return true;
            }
        }
        return false;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i10 = 0; i10 < bitSet.size(); i10++) {
            if (bitSet.get(i10)) {
                return true;
            }
        }
        return false;
    }

    private void checkNotStarted() throws IllegalStateException {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private void clear(int i10) {
        this.values.set(i10, null);
        this.valueSet.clear(i10);
    }

    private int least() {
        Object obj = null;
        int i10 = -1;
        for (int i11 = 0; i11 < this.values.size(); i11++) {
            if (!this.valueSet.get(i11)) {
                set(i11);
            }
            if (this.valueSet.get(i11)) {
                if (i10 == -1) {
                    obj = this.values.get(i11);
                    i10 = i11;
                } else {
                    E e2 = this.values.get(i11);
                    Comparator<? super E> comparator = this.comparator;
                    Objects.requireNonNull(comparator, "You must invoke setComparator() to set a comparator first.");
                    if (comparator.compare(e2, obj) < 0) {
                        i10 = i11;
                        obj = e2;
                    }
                }
            }
        }
        return i10;
    }

    private boolean set(int i10) {
        Iterator<? extends E> it = this.iterators.get(i10);
        if (it.hasNext()) {
            this.values.set(i10, it.next());
            this.valueSet.set(i10);
            return true;
        }
        this.values.set(i10, null);
        this.valueSet.clear(i10);
        return false;
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i10 = 0; i10 < this.iterators.size(); i10++) {
                this.values.add(null);
                this.valueSet.clear(i10);
            }
        }
    }

    public void addIterator(Iterator<? extends E> it) {
        checkNotStarted();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterators.add(it);
    }

    public Comparator<? super E> getComparator() {
        return this.comparator;
    }

    public int getIteratorIndex() {
        int i10 = this.lastReturned;
        if (i10 != -1) {
            return i10;
        }
        throw new IllegalStateException("No value has been returned yet");
    }

    public List<Iterator<? extends E>> getIterators() {
        return UnmodifiableList.unmodifiableList(this.iterators);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        start();
        return anyValueSet(this.valueSet) || anyHasNext(this.iterators);
    }

    @Override // java.util.Iterator
    public E next() throws NoSuchElementException {
        if (hasNext()) {
            int least = least();
            if (least != -1) {
                E e2 = this.values.get(least);
                clear(least);
                this.lastReturned = least;
                return e2;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i10 = this.lastReturned;
        if (i10 != -1) {
            this.iterators.get(i10).remove();
            return;
        }
        throw new IllegalStateException("No value can be removed at present");
    }

    public void setComparator(Comparator<? super E> comparator) {
        checkNotStarted();
        this.comparator = comparator;
    }

    public void setIterator(int i10, Iterator<? extends E> it) {
        checkNotStarted();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterators.set(i10, it);
    }

    public CollatingIterator(Comparator<? super E> comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator<? super E> comparator, int i10) {
        this.comparator = null;
        this.iterators = null;
        this.values = null;
        this.valueSet = null;
        this.lastReturned = -1;
        this.iterators = new ArrayList(i10);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E> it, Iterator<? extends E> it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator<? super E> comparator, Iterator<? extends E>[] itArr) {
        this(comparator, itArr.length);
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public CollatingIterator(Comparator<? super E> comparator, Collection<Iterator<? extends E>> collection) {
        this(comparator, collection.size());
        Iterator<Iterator<? extends E>> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            addIterator(iterator2.next());
        }
    }
}
