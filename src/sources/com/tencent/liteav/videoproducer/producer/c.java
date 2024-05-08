package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f44978a;

    private c(a aVar) {
        this.f44978a = aVar;
    }

    public static Runnable a(a aVar) {
        return new c(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f44978a;
        aVar.a(aVar.f44889c);
    }
}
