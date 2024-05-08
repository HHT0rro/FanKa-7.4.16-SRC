package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44373a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.CaptureParams f44374b;

    private ba(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        this.f44373a = screenCapturer;
        this.f44374b = captureParams;
    }

    public static Runnable a(ScreenCapturer screenCapturer, CaptureSourceInterface.CaptureParams captureParams) {
        return new ba(screenCapturer, captureParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f44373a, this.f44374b);
    }
}
