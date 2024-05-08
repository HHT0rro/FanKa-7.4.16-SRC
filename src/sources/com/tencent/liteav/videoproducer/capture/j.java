package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44408a;

    private j(CameraCaptureSingleton cameraCaptureSingleton) {
        this.f44408a = cameraCaptureSingleton;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton) {
        return new j(cameraCaptureSingleton);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.resumeInternal(this.f44408a.mCurrentCaptureParams);
    }
}
