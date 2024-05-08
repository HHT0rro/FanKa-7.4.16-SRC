package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45046a;

    private u(i iVar) {
        this.f45046a = iVar;
    }

    public static Runnable a(i iVar) {
        return new u(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f45046a);
    }
}
