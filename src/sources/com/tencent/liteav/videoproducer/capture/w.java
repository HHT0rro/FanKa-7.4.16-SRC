package com.tencent.liteav.videoproducer.capture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final int f44444a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44445b;

    private w(int i10, int i11) {
        this.f44444a = i10;
        this.f44445b = i11;
    }

    public static Runnable a(int i10, int i11) {
        return new w(i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CameraCaptureSingleton.getInstance().startAutoFocusAtPosition(this.f44444a, this.f44445b);
    }
}
