package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z implements Iterator {

    /* renamed from: b, reason: collision with root package name */
    public int f24116b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f24117c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbb f24118d;

    public z(zzbb zzbbVar) {
        this.f24118d = zzbbVar;
        this.f24117c = zzbbVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f24116b < this.f24117c;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final byte nextByte() {
        try {
            zzbb zzbbVar = this.f24118d;
            int i10 = this.f24116b;
            this.f24116b = i10 + 1;
            return zzbbVar.zzj(i10);
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
