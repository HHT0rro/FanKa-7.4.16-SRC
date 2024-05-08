package com.tencent.liteav.videoproducer.capture;

import android.graphics.SurfaceTexture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44401a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceTexture f44402b;

    private f(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        this.f44401a = cameraCaptureSingleton;
        this.f44402b = surfaceTexture;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        return new f(cameraCaptureSingleton, surfaceTexture);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$onFrameAvailable$13(this.f44401a, this.f44402b);
    }
}
