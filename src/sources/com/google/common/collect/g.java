package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractSequentialIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class g<T> extends i1<T> {

    /* renamed from: b, reason: collision with root package name */
    public T f26579b;

    public g(T t2) {
        this.f26579b = t2;
    }

    public abstract T a(T t2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26579b != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t2 = this.f26579b;
        if (t2 != null) {
            this.f26579b = a(t2);
            return t2;
        }
        throw new NoSuchElementException();
    }
}
