package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44409a;

    /* renamed from: b, reason: collision with root package name */
    private final CameraCaptureParams f44410b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44411c;

    private k(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44409a = cameraCaptureSingleton;
        this.f44410b = cameraCaptureParams;
        this.f44411c = captureParams;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureParams captureParams) {
        return new k(cameraCaptureSingleton, cameraCaptureParams, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$updateParams$17(this.f44409a, this.f44410b, this.f44411c);
    }
}
