package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44417a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44418b;

    private o(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        this.f44417a = cameraCaptureSingleton;
        this.f44418b = z10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        return new o(cameraCaptureSingleton, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$turnOnTorch$4(this.f44417a, this.f44418b);
    }
}
