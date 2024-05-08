package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public PredicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        super(sortedSet, predicate);
    }

    public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return new PredicatedSortedSet<>(sortedSet, predicate);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e2) {
        return new PredicatedSortedSet(decorated().headSet(e2), this.predicate);
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e2, E e10) {
        return new PredicatedSortedSet(decorated().subSet(e2, e10), this.predicate);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e2) {
        return new PredicatedSortedSet(decorated().tailSet(e2), this.predicate);
    }

    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }
}
