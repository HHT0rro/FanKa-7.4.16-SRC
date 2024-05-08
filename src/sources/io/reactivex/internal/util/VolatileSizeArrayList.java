package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    public final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(T t2) {
        boolean add = this.list.add(t2);
        lazySet(this.list.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    @Override // java.util.List
    public T get(int i10) {
        return this.list.get(i10);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return this.list.iterator2();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i10, T t2) {
        return this.list.set(i10, t2);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i10, int i11) {
        return this.list.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i10) {
        return this.list.listIterator(i10);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.list.toArray(eArr);
    }

    public VolatileSizeArrayList(int i10) {
        this.list = new ArrayList<>(i10);
    }

    @Override // java.util.List
    public void add(int i10, T t2) {
        this.list.add(i10, t2);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i10, collection);
        lazySet(this.list.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i10) {
        T remove = this.list.remove(i10);
        lazySet(this.list.size());
        return remove;
    }
}
