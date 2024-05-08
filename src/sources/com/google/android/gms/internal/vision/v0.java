package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class v0<E> extends p1<E> {

    /* renamed from: b, reason: collision with root package name */
    public final int f25658b;

    /* renamed from: c, reason: collision with root package name */
    public int f25659c;

    public v0(int i10, int i11) {
        p0.g(i11, i10);
        this.f25658b = i10;
        this.f25659c = i11;
    }

    public abstract E a(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25659c < this.f25658b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f25659c > 0;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f25659c;
            this.f25659c = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f25659c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f25659c - 1;
            this.f25659c = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f25659c - 1;
    }
}
