package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f44078a;

    private d(b bVar) {
        this.f44078a = bVar;
    }

    public static Runnable a(b bVar) {
        return new d(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b(this.f44078a);
    }
}
