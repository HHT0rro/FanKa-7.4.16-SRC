package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44451a;

    private z(t tVar) {
        this.f44451a = tVar;
    }

    public static Runnable a(t tVar) {
        return new z(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.c(this.f44451a);
    }
}
