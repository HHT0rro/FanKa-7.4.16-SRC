package com.google.common.collect;

import com.google.common.collect.b1;
import com.google.common.collect.k0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* compiled from: AbstractSortedMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class h<E> extends d<E> implements a1<E> {
    public final Comparator<? super E> comparator;
    private transient a1<E> descendingMultiset;

    /* compiled from: AbstractSortedMultiset.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends q<E> {
        public a() {
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return h.this.descendingIterator();
        }

        @Override // com.google.common.collect.q
        public Iterator<k0.a<E>> p() {
            return h.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.q
        public a1<E> q() {
            return h.this;
        }
    }

    public h() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public a1<E> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator<k0.a<E>> descendingEntryIterator();

    Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public a1<E> descendingMultiset() {
        a1<E> a1Var = this.descendingMultiset;
        if (a1Var != null) {
            return a1Var;
        }
        a1<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    public k0.a<E> firstEntry() {
        Iterator<k0.a<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public k0.a<E> lastEntry() {
        Iterator<k0.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public k0.a<E> pollFirstEntry() {
        Iterator<k0.a<E>> entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        k0.a<E> next = entryIterator.next();
        k0.a<E> g3 = Multisets.g(next.getElement(), next.getCount());
        entryIterator.remove();
        return g3;
    }

    public k0.a<E> pollLastEntry() {
        Iterator<k0.a<E>> descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        k0.a<E> next = descendingEntryIterator.next();
        k0.a<E> g3 = Multisets.g(next.getElement(), next.getCount());
        descendingEntryIterator.remove();
        return g3;
    }

    public a1<E> subMultiset(E e2, BoundType boundType, E e10, BoundType boundType2) {
        com.google.common.base.o.r(boundType);
        com.google.common.base.o.r(boundType2);
        return tailMultiset(e2, boundType).headMultiset(e10, boundType2);
    }

    public h(Comparator<? super E> comparator) {
        this.comparator = (Comparator) com.google.common.base.o.r(comparator);
    }

    @Override // com.google.common.collect.d
    public NavigableSet<E> createElementSet() {
        return new b1.b(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
