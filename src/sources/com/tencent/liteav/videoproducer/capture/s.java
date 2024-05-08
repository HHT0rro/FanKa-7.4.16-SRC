package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44426a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44427b;

    private s(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        this.f44426a = cameraCaptureSingleton;
        this.f44427b = f10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        return new s(cameraCaptureSingleton, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setZoomLevel$8(this.f44426a, this.f44427b);
    }
}
