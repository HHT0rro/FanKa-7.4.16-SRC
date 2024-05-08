package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f f44095a;

    private i(f fVar) {
        this.f44095a = fVar;
    }

    public static Runnable a(f fVar) {
        return new i(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f44095a);
    }
}
