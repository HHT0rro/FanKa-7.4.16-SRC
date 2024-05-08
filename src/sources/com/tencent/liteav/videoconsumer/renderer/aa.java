package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44049a;

    private aa(t tVar) {
        this.f44049a = tVar;
    }

    public static Runnable a(t tVar) {
        return new aa(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44049a);
    }
}
