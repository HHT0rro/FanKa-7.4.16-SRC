package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45033a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f45034b;

    private o(i iVar, boolean z10) {
        this.f45033a = iVar;
        this.f45034b = z10;
    }

    public static Runnable a(i iVar, boolean z10) {
        return new o(iVar, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.c(this.f45033a, this.f45034b);
    }
}
