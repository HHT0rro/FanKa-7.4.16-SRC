package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44155a;

    private v(t tVar) {
        this.f44155a = tVar;
    }

    public static Runnable a(t tVar) {
        return new v(tVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.c(this.f44155a);
    }
}
