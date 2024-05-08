package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k f44120a;

    private p(k kVar) {
        this.f44120a = kVar;
    }

    public static Runnable a(k kVar) {
        return new p(kVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.b(this.f44120a.f44097a);
    }
}
