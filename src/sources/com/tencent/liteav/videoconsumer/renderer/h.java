package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f f44094a;

    private h(f fVar) {
        this.f44094a = fVar;
    }

    public static Runnable a(f fVar) {
        return new h(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.c(this.f44094a);
    }
}
