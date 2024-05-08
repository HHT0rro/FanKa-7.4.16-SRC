package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    public static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable<?>> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        com.google.common.base.o.r(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(E e2, E e10) {
        return (E) NaturalOrdering.INSTANCE.min(e2, e10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(E e2, E e10) {
        return (E) NaturalOrdering.INSTANCE.max(e2, e10);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(E e2, E e10, E e11, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e2, e10, e11, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(E e2, E e10, E e11, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e2, e10, e11, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
