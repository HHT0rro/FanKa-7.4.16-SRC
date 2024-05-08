package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: SortedMultisets.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b1 {

    /* compiled from: SortedMultisets.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a<E> extends Multisets.c<E> implements SortedSet<E> {

        /* renamed from: b, reason: collision with root package name */
        public final a1<E> f26567b;

        public a(a1<E> a1Var) {
            this.f26567b = a1Var;
        }

        @Override // com.google.common.collect.Multisets.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a1<E> b() {
            return this.f26567b;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) b1.d(b().firstEntry());
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e2) {
            return b().headMultiset(e2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Multisets.e(b().entrySet().iterator2());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) b1.d(b().lastEntry());
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e2, E e10) {
            return b().subMultiset(e2, BoundType.CLOSED, e10, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e2) {
            return b().tailMultiset(e2, BoundType.CLOSED).elementSet();
        }
    }

    /* compiled from: SortedMultisets.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public b(a1<E> a1Var) {
            super(a1Var);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return (E) b1.c(b().tailMultiset(e2, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator2();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(b().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return (E) b1.c(b().headMultiset(e2, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z10) {
            return new b(b().headMultiset(e2, BoundType.forBoolean(z10)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return (E) b1.c(b().tailMultiset(e2, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return (E) b1.c(b().headMultiset(e2, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) b1.c(b().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) b1.c(b().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11) {
            return new b(b().subMultiset(e2, BoundType.forBoolean(z10), e10, BoundType.forBoolean(z11)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z10) {
            return new b(b().tailMultiset(e2, BoundType.forBoolean(z10)));
        }
    }

    public static <E> E c(k0.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.getElement();
    }

    public static <E> E d(k0.a<E> aVar) {
        if (aVar != null) {
            return aVar.getElement();
        }
        throw new NoSuchElementException();
    }
}
