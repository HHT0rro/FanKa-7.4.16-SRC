package com.google.common.collect;

import java.util.Iterator;

/* compiled from: UnmodifiableIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class i1<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
