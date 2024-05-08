package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44403a;

    /* renamed from: b, reason: collision with root package name */
    private final CameraCaptureParams f44404b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44405c;

    private g(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        this.f44403a = cameraCaptureSingleton;
        this.f44404b = cameraCaptureParams;
        this.f44405c = captureSourceListener;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        return new g(cameraCaptureSingleton, cameraCaptureParams, captureSourceListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$start$14(this.f44403a, this.f44404b, this.f44405c);
    }
}
