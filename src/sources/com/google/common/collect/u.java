package com.google.common.collect;

import java.util.Iterator;

/* compiled from: ForwardingIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class u<T> extends z implements Iterator<T> {
    @Override // java.util.Iterator
    public boolean hasNext() {
        return o().hasNext();
    }

    public T next() {
        return o().next();
    }

    public abstract Iterator<T> o();
}
