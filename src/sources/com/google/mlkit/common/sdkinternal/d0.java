package com.google.mlkit.common.sdkinternal;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class d0 implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f27045b;

    public /* synthetic */ d0(n nVar, b0 b0Var) {
        AtomicReference atomicReference;
        this.f27045b = nVar;
        atomicReference = nVar.f27062d;
        com.google.android.gms.common.internal.h.j(((Thread) atomicReference.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AtomicReference atomicReference;
        atomicReference = this.f27045b.f27062d;
        atomicReference.set(null);
        this.f27045b.e();
    }
}
