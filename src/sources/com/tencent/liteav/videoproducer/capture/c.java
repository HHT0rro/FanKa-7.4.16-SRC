package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44395a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44396b;

    private c(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        this.f44395a = cameraCaptureSingleton;
        this.f44396b = f10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        return new c(cameraCaptureSingleton, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setExposureCompensation$10(this.f44395a, this.f44396b);
    }
}
