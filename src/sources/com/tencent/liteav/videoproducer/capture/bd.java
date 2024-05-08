package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44377a;

    private bd(ScreenCapturer screenCapturer) {
        this.f44377a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new bd(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.b(this.f44377a);
    }
}
