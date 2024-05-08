package com.tencent.liteav.videoconsumer.renderer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final k f44119a;

    private o(k kVar) {
        this.f44119a = kVar;
    }

    public static Runnable a(k kVar) {
        return new o(kVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        k.b(this.f44119a);
    }
}
