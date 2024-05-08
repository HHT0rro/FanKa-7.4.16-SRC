package com.tencent.liteav.videoproducer2.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCameraCaptureListener f45071a;

    private d(NativeCameraCaptureListener nativeCameraCaptureListener) {
        this.f45071a = nativeCameraCaptureListener;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener) {
        return new d(nativeCameraCaptureListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        NativeCameraCaptureListener.nativeOnCameraError(this.f45071a.mNativeHandle);
    }
}
