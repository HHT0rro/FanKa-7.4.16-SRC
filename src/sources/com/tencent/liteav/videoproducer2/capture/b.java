package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f45067a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f45068b;

    private b(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.f45067a = nativeCameraCaptureListener;
        this.f45068b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new b(nativeCameraCaptureListener, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(c.a(this.f45067a, this.f45068b));
    }
}
