package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44964a;

    private av(i iVar) {
        this.f44964a = iVar;
    }

    public static Runnable a(i iVar) {
        return new av(iVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44964a.b();
    }
}
