package com.tencent.liteav.videobase.utils;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SurfaceTextureHolder f43551a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f43552b;

    private s(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        this.f43551a = surfaceTextureHolder;
        this.f43552b = surfaceTexture;
    }

    public static Runnable a(SurfaceTextureHolder surfaceTextureHolder, SurfaceTexture surfaceTexture) {
        return new s(surfaceTextureHolder, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTextureHolder.lambda$onFrameAvailable$0(this.f43551a, this.f43552b);
    }
}
