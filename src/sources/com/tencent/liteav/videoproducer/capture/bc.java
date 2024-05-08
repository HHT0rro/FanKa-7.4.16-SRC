package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44376a;

    private bc(ScreenCapturer screenCapturer) {
        this.f44376a = screenCapturer;
    }

    public static Runnable a(ScreenCapturer screenCapturer) {
        return new bc(screenCapturer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.c(this.f44376a);
    }
}
