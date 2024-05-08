package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44414a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureCloudConfig f44415b;

    private m(CameraCaptureSingleton cameraCaptureSingleton, CaptureCloudConfig captureCloudConfig) {
        this.f44414a = cameraCaptureSingleton;
        this.f44415b = captureCloudConfig;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CaptureCloudConfig captureCloudConfig) {
        return new m(cameraCaptureSingleton, captureCloudConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$setCaptureCloudConfig$2(this.f44414a, this.f44415b);
    }
}
