package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44167a;

    private z(t tVar) {
        this.f44167a = tVar;
    }

    public static Runnable a(t tVar) {
        return new z(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.b(this.f44167a);
    }
}
