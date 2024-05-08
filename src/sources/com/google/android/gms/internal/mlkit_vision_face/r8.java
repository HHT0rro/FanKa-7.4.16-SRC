package com.google.android.gms.internal.mlkit_vision_face;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class r8 implements Callable {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.mlkit.common.sdkinternal.m f25186b;

    public r8(com.google.mlkit.common.sdkinternal.m mVar) {
        this.f25186b = mVar;
    }

    public static Callable a(com.google.mlkit.common.sdkinternal.m mVar) {
        return new r8(mVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f25186b.a();
    }
}
