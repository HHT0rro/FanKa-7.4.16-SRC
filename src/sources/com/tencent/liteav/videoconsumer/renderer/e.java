package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f44079a;

    private e(b bVar) {
        this.f44079a = bVar;
    }

    public static Runnable a(b bVar) {
        return new e(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f44079a);
    }
}
