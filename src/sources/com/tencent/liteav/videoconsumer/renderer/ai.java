package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ai implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44070a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44071b;

    private ai(t tVar, boolean z10) {
        this.f44070a = tVar;
        this.f44071b = z10;
    }

    public static Runnable a(t tVar, boolean z10) {
        return new ai(tVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b(this.f44070a, this.f44071b);
    }
}
