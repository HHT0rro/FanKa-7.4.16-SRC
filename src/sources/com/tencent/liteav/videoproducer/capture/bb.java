package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44375a;

    private bb(ScreenCapturer screenCapturer) {
        this.f44375a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new bb(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.d(this.f44375a);
    }
}
