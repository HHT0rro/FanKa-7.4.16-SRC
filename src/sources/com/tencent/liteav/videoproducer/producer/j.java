package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45021a;

    private j(i iVar) {
        this.f45021a = iVar;
    }

    public static Runnable a(i iVar) {
        return new j(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.g(this.f45021a);
    }
}
