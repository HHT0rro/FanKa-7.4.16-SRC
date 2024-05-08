package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f f44096a;

    private j(f fVar) {
        this.f44096a = fVar;
    }

    public static Runnable a(f fVar) {
        return new j(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44096a.b();
    }
}
