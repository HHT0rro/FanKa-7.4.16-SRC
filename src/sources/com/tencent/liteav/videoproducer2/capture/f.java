package com.tencent.liteav.videoproducer2.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeScreenCaptureListener f45074a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45075b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f45076c;

    private f(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z10, boolean z11) {
        this.f45074a = nativeScreenCaptureListener;
        this.f45075b = z10;
        this.f45076c = z11;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z10, boolean z11) {
        return new f(nativeScreenCaptureListener, z10, z11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f45074a.notifyStartFinish(this.f45075b, this.f45076c);
    }
}
