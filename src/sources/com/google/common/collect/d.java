package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: AbstractMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class d<E> extends AbstractCollection<E> implements k0<E> {
    private transient Set<E> elementSet;
    private transient Set<k0.a<E>> entrySet;

    /* compiled from: AbstractMultiset.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends Multisets.c<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.c
        public k0<E> b() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return d.this.elementIterator();
        }
    }

    /* compiled from: AbstractMultiset.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends Multisets.d<E> {
        public b() {
        }

        @Override // com.google.common.collect.Multisets.d
        public k0<E> b() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<k0.a<E>> iterator2() {
            return d.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Set<E> createElementSet() {
        return new a();
    }

    Set<k0.a<E>> createEntrySet() {
        return new b();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    public abstract Iterator<k0.a<E>> entryIterator();

    public Set<k0.a<E>> entrySet() {
        Set<k0.a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<k0.a<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    public int setCount(E e2, int i10) {
        return Multisets.m(this, e2, i10);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public int add(E e2, int i10) {
        throw new UnsupportedOperationException();
    }

    public int remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    public boolean setCount(E e2, int i10, int i11) {
        return Multisets.n(this, e2, i10, i11);
    }
}
