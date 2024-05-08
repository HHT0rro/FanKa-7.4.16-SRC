package com.google.android.gms.internal.mlkit_common;

import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class c0 implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f24163b;

    public c0(com.google.mlkit.common.sdkinternal.m mVar) {
        this.f24163b = mVar;
    }

    public static Callable a(com.google.mlkit.common.sdkinternal.m mVar) {
        return new c0(mVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f24163b.a();
    }
}
