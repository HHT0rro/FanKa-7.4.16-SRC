package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SynchronizedCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 2412805092710877986L;
    private final Collection<E> collection;
    public final Object lock;

    public SynchronizedCollection(Collection<E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        this.collection = collection;
        this.lock = this;
    }

    public static <T> SynchronizedCollection<T> synchronizedCollection(Collection<T> collection) {
        return new SynchronizedCollection<>(collection);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        boolean add;
        synchronized (this.lock) {
            add = decorated().add(e2);
        }
        return add;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = decorated().addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        synchronized (this.lock) {
            decorated().clear();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.lock) {
            contains = decorated().contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.lock) {
            containsAll = decorated().containsAll(collection);
        }
        return containsAll;
    }

    public Collection<E> decorated() {
        return this.collection;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        synchronized (this.lock) {
            boolean z10 = true;
            try {
                if (obj == this) {
                    return true;
                }
                if (obj != this && !decorated().equals(obj)) {
                    z10 = false;
                }
                return z10;
            } finally {
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = decorated().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = decorated().isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return decorated().iterator2();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = decorated().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.lock) {
            removeAll = decorated().removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        boolean removeIf;
        synchronized (this.lock) {
            removeIf = decorated().removeIf(predicate);
        }
        return removeIf;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.lock) {
            retainAll = decorated().retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        int size;
        synchronized (this.lock) {
            size = decorated().size();
        }
        return size;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] array;
        synchronized (this.lock) {
            array = decorated().toArray();
        }
        return array;
    }

    public String toString() {
        String obj;
        synchronized (this.lock) {
            obj = decorated().toString();
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.lock) {
            tArr2 = (T[]) decorated().toArray(tArr);
        }
        return tArr2;
    }

    public SynchronizedCollection(Collection<E> collection, Object obj) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        Objects.requireNonNull(obj, "Lock must not be null.");
        this.collection = collection;
        this.lock = obj;
    }
}
