package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;

/* compiled from: SettableFuture.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class t<V> extends AbstractFuture.i<V> {
    public static <V> t<V> a() {
        return new t<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(V v2) {
        return super.set(v2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(n<? extends V> nVar) {
        return super.setFuture(nVar);
    }
}
