package com.google.android.gms.internal.mlkit_vision_common;

import com.huawei.quickcard.base.Attributes;
import java.util.NoSuchElementException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class d6<E> extends n7<E> {

    /* renamed from: b, reason: collision with root package name */
    public final int f24284b;

    /* renamed from: c, reason: collision with root package name */
    public int f24285c;

    public d6(int i10, int i11) {
        e4.b(i11, i10, Attributes.Style.INDEX);
        this.f24284b = i10;
        this.f24285c = i11;
    }

    public abstract E a(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24285c < this.f24284b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f24285c > 0;
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f24285c;
            this.f24285c = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f24285c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f24285c - 1;
            this.f24285c = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f24285c - 1;
    }
}
