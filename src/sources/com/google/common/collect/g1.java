package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: TransformedListIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class g1<F, T> extends f1<F, T> implements ListIterator<T> {
    public g1(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t2) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return Iterators.c(this.f26578b);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t2) {
        throw new UnsupportedOperationException();
    }
}
