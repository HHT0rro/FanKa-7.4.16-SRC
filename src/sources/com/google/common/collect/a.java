package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a<E> extends j1<E> {

    /* renamed from: b, reason: collision with root package name */
    public final int f26565b;

    /* renamed from: c, reason: collision with root package name */
    public int f26566c;

    public a(int i10) {
        this(i10, 0);
    }

    public abstract E a(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f26566c < this.f26565b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f26566c > 0;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f26566c;
            this.f26566c = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f26566c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f26566c - 1;
            this.f26566c = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f26566c - 1;
    }

    public a(int i10, int i11) {
        com.google.common.base.o.u(i11, i10);
        this.f26565b = i10;
        this.f26566c = i11;
    }
}
