package com.google.common.collect;

import com.google.common.collect.k0;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* compiled from: SortedMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface a1<E> extends k0, y0<E> {
    Comparator<? super E> comparator();

    a1<E> descendingMultiset();

    @Override // com.google.common.collect.k0
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.k0
    Set<k0.a<E>> entrySet();

    k0.a<E> firstEntry();

    a1<E> headMultiset(E e2, BoundType boundType);

    k0.a<E> lastEntry();

    k0.a<E> pollFirstEntry();

    k0.a<E> pollLastEntry();

    a1<E> subMultiset(E e2, BoundType boundType, E e10, BoundType boundType2);

    a1<E> tailMultiset(E e2, BoundType boundType);
}
