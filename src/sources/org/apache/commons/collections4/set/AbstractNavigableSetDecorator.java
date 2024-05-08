package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractNavigableSetDecorator<E> extends AbstractSortedSetDecorator<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public AbstractNavigableSetDecorator() {
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e2) {
        return decorated().ceiling(e2);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return decorated().descendingSet();
    }

    @Override // java.util.NavigableSet
    public E floor(E e2) {
        return decorated().floor(e2);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e2, boolean z10) {
        return decorated().headSet(e2, z10);
    }

    @Override // java.util.NavigableSet
    public E higher(E e2) {
        return decorated().higher(e2);
    }

    @Override // java.util.NavigableSet
    public E lower(E e2) {
        return decorated().lower(e2);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return decorated().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return decorated().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11) {
        return decorated().subSet(e2, z10, e10, z11);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e2, boolean z10) {
        return decorated().tailSet(e2, z10);
    }

    public AbstractNavigableSetDecorator(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, org.apache.commons.collections4.set.AbstractSetDecorator, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }
}
