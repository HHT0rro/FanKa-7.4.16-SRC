package com.tencent.liteav.videoconsumer.decoder;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ah f43856a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f43857b;

    private ai(ah ahVar, SurfaceTexture surfaceTexture) {
        this.f43856a = ahVar;
        this.f43857b = surfaceTexture;
    }

    public static Runnable a(ah ahVar, SurfaceTexture surfaceTexture) {
        return new ai(ahVar, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah.a(this.f43856a, this.f43857b);
    }
}
