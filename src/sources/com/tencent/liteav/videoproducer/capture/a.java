package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44238a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureSourceListener f44239b;

    private a(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        this.f44238a = cameraCaptureSingleton;
        this.f44239b = captureSourceListener;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.CaptureSourceListener captureSourceListener) {
        return new a(cameraCaptureSingleton, captureSourceListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44238a.mListenerManager.b(this.f44239b);
    }
}
