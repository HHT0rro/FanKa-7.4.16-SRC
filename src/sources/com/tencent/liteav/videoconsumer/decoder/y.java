package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f44029a;

    private y(u uVar) {
        this.f44029a = uVar;
    }

    public static Runnable a(u uVar) {
        return new y(uVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44029a.a();
    }
}
