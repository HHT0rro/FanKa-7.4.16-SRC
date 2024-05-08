package com.google.android.gms.internal.mlkit_common;

import com.huawei.quickcard.base.Attributes;
import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class c<E> extends m<E> {

    /* renamed from: b, reason: collision with root package name */
    public final int f24161b;

    /* renamed from: c, reason: collision with root package name */
    public int f24162c;

    public c(int i10, int i11) {
        u0.b(i11, i10, Attributes.Style.INDEX);
        this.f24161b = i10;
        this.f24162c = i11;
    }

    public abstract E a(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24162c < this.f24161b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f24162c > 0;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f24162c;
            this.f24162c = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f24162c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f24162c - 1;
            this.f24162c = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f24162c - 1;
    }
}
