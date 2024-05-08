package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44442a;

    private u(t tVar) {
        this.f44442a = tVar;
    }

    public static Runnable a(t tVar) {
        return new u(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44442a);
    }
}
