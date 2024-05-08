package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedIterables.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class z0 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? Ordering.natural() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.common.base.o.r(comparator);
        com.google.common.base.o.r(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof y0)) {
                return false;
            }
            comparator2 = ((y0) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
