package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final CameraCaptureSingleton f44421a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44422b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44423c;

    private q(CameraCaptureSingleton cameraCaptureSingleton, int i10, int i11) {
        this.f44421a = cameraCaptureSingleton;
        this.f44422b = i10;
        this.f44423c = i11;
    }

    public static Runnable a(CameraCaptureSingleton cameraCaptureSingleton, int i10, int i11) {
        return new q(cameraCaptureSingleton, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.lambda$startAutoFocusAtPosition$6(this.f44421a, this.f44422b, this.f44423c);
    }
}
