package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: UnmodifiableListIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class j1<E> extends i1<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
