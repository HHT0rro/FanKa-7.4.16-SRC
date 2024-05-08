package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformedSortedSet<E> extends TransformedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -1675486811351124386L;

    public TransformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        super(sortedSet, transformer);
    }

    public static <E> TransformedSortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        TransformedSortedSet<E> transformedSortedSet = new TransformedSortedSet<>(sortedSet, transformer);
        if (sortedSet.size() > 0) {
            Object[] array = sortedSet.toArray();
            sortedSet.clear();
            for (Object obj : array) {
                transformedSortedSet.decorated().add(transformer.transform(obj));
            }
        }
        return transformedSortedSet;
    }

    public static <E> TransformedSortedSet<E> transformingSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return new TransformedSortedSet<>(sortedSet, transformer);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return getSortedSet().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return getSortedSet().first();
    }

    public SortedSet<E> getSortedSet() {
        return (SortedSet) decorated();
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e2) {
        return new TransformedSortedSet(getSortedSet().headSet(e2), this.transformer);
    }

    @Override // java.util.SortedSet
    public E last() {
        return getSortedSet().last();
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e2, E e10) {
        return new TransformedSortedSet(getSortedSet().subSet(e2, e10), this.transformer);
    }

    @Override // java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e2) {
        return new TransformedSortedSet(getSortedSet().tailSet(e2), this.transformer);
    }
}
