package com.google.android.gms.internal.mlkit_vision_common;

import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class m6 implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f24472b;

    public m6(com.google.mlkit.common.sdkinternal.m mVar) {
        this.f24472b = mVar;
    }

    public static Callable a(com.google.mlkit.common.sdkinternal.m mVar) {
        return new m6(mVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f24472b.a();
    }
}
