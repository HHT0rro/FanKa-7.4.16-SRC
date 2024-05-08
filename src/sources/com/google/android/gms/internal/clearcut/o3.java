package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o3 implements Iterator<String> {

    /* renamed from: b, reason: collision with root package name */
    public Iterator<String> f23973b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m3 f23974c;

    public o3(m3 m3Var) {
        j1 j1Var;
        this.f23974c = m3Var;
        j1Var = m3Var.f23956b;
        this.f23973b = j1Var.iterator2();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f23973b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f23973b.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
