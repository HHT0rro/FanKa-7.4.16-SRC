package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.b1;
import com.google.common.collect.k0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* compiled from: DescendingMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class q<E> extends y<E> implements a1<E> {

    /* renamed from: b, reason: collision with root package name */
    public transient Comparator<? super E> f26611b;

    /* renamed from: c, reason: collision with root package name */
    public transient NavigableSet<E> f26612c;

    /* renamed from: d, reason: collision with root package name */
    public transient Set<k0.a<E>> f26613d;

    /* compiled from: DescendingMultiset.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends Multisets.d<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.d
        public k0<E> b() {
            return q.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<k0.a<E>> iterator2() {
            return q.this.p();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q.this.q().entrySet().size();
        }
    }

    @Override // com.google.common.collect.a1, com.google.common.collect.y0
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f26611b;
        if (comparator != null) {
            return comparator;
        }
        Ordering reverse = Ordering.from(q().comparator()).reverse();
        this.f26611b = reverse;
        return reverse;
    }

    @Override // com.google.common.collect.a1
    public a1<E> descendingMultiset() {
        return q();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.k0
    public Set<k0.a<E>> entrySet() {
        Set<k0.a<E>> set = this.f26613d;
        if (set != null) {
            return set;
        }
        Set<k0.a<E>> o10 = o();
        this.f26613d = o10;
        return o10;
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> firstEntry() {
        return q().lastEntry();
    }

    @Override // com.google.common.collect.a1
    public a1<E> headMultiset(E e2, BoundType boundType) {
        return q().tailMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> lastEntry() {
        return q().firstEntry();
    }

    public Set<k0.a<E>> o() {
        return new a();
    }

    public abstract Iterator<k0.a<E>> p();

    @Override // com.google.common.collect.a1
    public k0.a<E> pollFirstEntry() {
        return q().pollLastEntry();
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> pollLastEntry() {
        return q().pollFirstEntry();
    }

    public abstract a1<E> q();

    @Override // com.google.common.collect.a1
    public a1<E> subMultiset(E e2, BoundType boundType, E e10, BoundType boundType2) {
        return q().subMultiset(e10, boundType2, e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.a1
    public a1<E> tailMultiset(E e2, BoundType boundType) {
        return q().headMultiset(e2, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.z
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.k0
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f26612c;
        if (navigableSet != null) {
            return navigableSet;
        }
        b1.b bVar = new b1.b(this);
        this.f26612c = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.s, com.google.common.collect.z
    public k0<E> delegate() {
        return q();
    }
}
