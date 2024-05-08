package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    @Deprecated
    public static <E> ImmutableSortedMultiset.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public abstract /* synthetic */ int count(Object obj);

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e10, E e11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e10, E e11, E e12) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e10, E e11, E e12, E e13) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedMultiset<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
