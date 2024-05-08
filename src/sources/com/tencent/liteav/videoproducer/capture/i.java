package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44407a;

    private i(CameraCaptureSingleton cameraCaptureSingleton) {
        this.f44407a = cameraCaptureSingleton;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton) {
        return new i(cameraCaptureSingleton);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44407a.pauseInternal();
    }
}
