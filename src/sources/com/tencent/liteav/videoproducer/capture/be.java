package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class be implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ScreenCapturer f44378a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44379b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44380c;

    private be(ScreenCapturer screenCapturer, boolean z10, boolean z11) {
        this.f44378a = screenCapturer;
        this.f44379b = z10;
        this.f44380c = z11;
    }

    public static Runnable a(ScreenCapturer screenCapturer, boolean z10, boolean z11) {
        return new be(screenCapturer, z10, z11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenCapturer.a(this.f44378a, this.f44379b, this.f44380c);
    }
}
