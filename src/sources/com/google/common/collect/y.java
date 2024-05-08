package com.google.common.collect;

import com.google.common.collect.k0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ForwardingMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class y<E> extends s<E> implements k0<E> {
    public int add(E e2, int i10) {
        return delegate().add(e2, i10);
    }

    @Override // com.google.common.collect.k0
    public int count(Object obj) {
        return delegate().count(obj);
    }

    @Override // com.google.common.collect.s, com.google.common.collect.z
    public abstract k0<E> delegate();

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<k0.a<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public int remove(Object obj, int i10) {
        return delegate().remove(obj, i10);
    }

    public int setCount(E e2, int i10) {
        return delegate().setCount(e2, i10);
    }

    public boolean standardAdd(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // com.google.common.collect.s
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // com.google.common.collect.s
    public void standardClear() {
        Iterators.d(entrySet().iterator2());
    }

    @Override // com.google.common.collect.s
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    public int standardCount(Object obj) {
        for (k0.a<E> aVar : entrySet()) {
            if (com.google.common.base.l.a(aVar.getElement(), obj)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(Object obj) {
        return Multisets.f(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.s
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.s
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // com.google.common.collect.s
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    public int standardSetCount(E e2, int i10) {
        return Multisets.m(this, e2, i10);
    }

    public int standardSize() {
        return Multisets.j(this);
    }

    @Override // com.google.common.collect.s
    public String standardToString() {
        return entrySet().toString();
    }

    public boolean setCount(E e2, int i10, int i11) {
        return delegate().setCount(e2, i10, i11);
    }

    public boolean standardSetCount(E e2, int i10, int i11) {
        return Multisets.n(this, e2, i10, i11);
    }
}
