package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44381a;

    private bf(ScreenCapturer screenCapturer) {
        this.f44381a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new bf(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f44381a);
    }
}
