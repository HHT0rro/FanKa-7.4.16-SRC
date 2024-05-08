package com.google.common.collect;

import java.util.Iterator;

/* compiled from: TransformedIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class f1<F, T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Iterator<? extends F> f26578b;

    public f1(Iterator<? extends F> it) {
        this.f26578b = (Iterator) com.google.common.base.o.r(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26578b.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f26578b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f26578b.remove();
    }
}
