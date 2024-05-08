package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44424a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44425b;

    private r(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        this.f44424a = cameraCaptureSingleton;
        this.f44425b = z10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        return new r(cameraCaptureSingleton, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$enableCameraZoom$7(this.f44424a, this.f44425b);
    }
}
