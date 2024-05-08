package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44331a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44332b;

    private b(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        this.f44331a = cameraCaptureSingleton;
        this.f44332b = f10;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, float f10) {
        return new b(cameraCaptureSingleton, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44331a.setZoomInternal(this.f44332b);
    }
}
