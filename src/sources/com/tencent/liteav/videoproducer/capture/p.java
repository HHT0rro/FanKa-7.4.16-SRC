package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44419a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44420b;

    private p(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        this.f44419a = cameraCaptureSingleton;
        this.f44420b = z10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, boolean z10) {
        return new p(cameraCaptureSingleton, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$enableTapToFocus$5(this.f44419a, this.f44420b);
    }
}
