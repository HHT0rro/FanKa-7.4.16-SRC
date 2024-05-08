package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: ForwardingCollection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class s<E> extends z implements Collection<E> {
    public boolean add(E e2) {
        return delegate().add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.z
    public abstract Collection<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return delegate().iterator2();
    }

    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator2());
    }

    public void standardClear() {
        Iterators.d(iterator2());
    }

    public boolean standardContains(Object obj) {
        return Iterators.f(iterator2(), obj);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return n.a(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator2().hasNext();
    }

    public boolean standardRemove(Object obj) {
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            if (com.google.common.base.l.a(iterator2.next(), obj)) {
                iterator2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.s(iterator2(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return Iterators.t(iterator2(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        return n.e(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) m0.g(this, tArr);
    }
}
