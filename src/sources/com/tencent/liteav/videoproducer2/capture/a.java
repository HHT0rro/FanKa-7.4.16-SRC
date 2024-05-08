package com.tencent.liteav.videoproducer2.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f45066a;

    private a(NativeCameraCaptureListener nativeCameraCaptureListener) {
        this.f45066a = nativeCameraCaptureListener;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener) {
        return new a(nativeCameraCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.runInNative(d.a(this.f45066a));
    }
}
