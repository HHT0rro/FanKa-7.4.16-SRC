package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44399a;

    /* renamed from: b, reason: collision with root package name */
    private final CameraControllerInterface f44400b;

    private e(CameraCaptureSingleton cameraCaptureSingleton, CameraControllerInterface cameraControllerInterface) {
        this.f44399a = cameraCaptureSingleton;
        this.f44400b = cameraControllerInterface;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CameraControllerInterface cameraControllerInterface) {
        return new e(cameraCaptureSingleton, cameraControllerInterface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$onCameraError$12(this.f44399a, this.f44400b);
    }
}
