package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44261a;

    private ab(t tVar) {
        this.f44261a = tVar;
    }

    public static Runnable a(t tVar) {
        return new ab(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b(this.f44261a);
    }
}
