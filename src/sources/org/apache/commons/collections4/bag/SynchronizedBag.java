package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class SynchronizedBagSet extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        public SynchronizedBagSet(Set<E> set, Object obj) {
            super(set, obj);
        }
    }

    public SynchronizedBag(Bag<E> bag) {
        super(bag);
    }

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> bag) {
        return new SynchronizedBag<>(bag);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e2, int i10) {
        boolean add;
        synchronized (this.lock) {
            add = getBag().add(e2, i10);
        }
        return add;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            equals = getBag().equals(obj);
        }
        return equals;
    }

    public Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = getBag().hashCode();
        }
        return hashCode;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i10) {
        boolean remove;
        synchronized (this.lock) {
            remove = getBag().remove(obj, i10);
        }
        return remove;
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    public SynchronizedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }
}
