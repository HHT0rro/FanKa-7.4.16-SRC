package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: ForwardingSortedSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class d0<E> extends b0<E> implements SortedSet<E> {
    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e2) {
        return delegate().headSet(e2);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.s
    public boolean standardContains(Object obj) {
        try {
            return c0.unsafeCompare(comparator(), tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.s
    public boolean standardRemove(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator2();
            if (it.hasNext()) {
                if (c0.unsafeCompare(comparator(), it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(E e2, E e10) {
        return tailSet(e2).headSet(e10);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e2, E e10) {
        return delegate().subSet(e2, e10);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e2) {
        return delegate().tailSet(e2);
    }
}
