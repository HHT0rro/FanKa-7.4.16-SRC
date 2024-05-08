package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44397a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44398b;

    private d(CameraCaptureSingleton cameraCaptureSingleton, int i10) {
        this.f44397a = cameraCaptureSingleton;
        this.f44398b = i10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, int i10) {
        return new d(cameraCaptureSingleton, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setCameraAPIType$11(this.f44397a, this.f44398b);
    }
}
