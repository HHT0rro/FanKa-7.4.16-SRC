package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class az implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44330a;

    private az(ScreenCapturer screenCapturer) {
        this.f44330a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new az(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44330a.a();
    }
}
