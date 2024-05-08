package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44920a;

    private ag(i iVar) {
        this.f44920a = iVar;
    }

    public static Runnable a(i iVar) {
        return new ag(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.k(this.f44920a);
    }
}
