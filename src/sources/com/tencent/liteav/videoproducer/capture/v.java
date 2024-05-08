package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CaptureCloudConfig f44443a;

    private v(CaptureCloudConfig captureCloudConfig) {
        this.f44443a = captureCloudConfig;
    }

    public static Runnable a(CaptureCloudConfig captureCloudConfig) {
        return new v(captureCloudConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.getInstance().setCaptureCloudConfig(this.f44443a);
    }
}
