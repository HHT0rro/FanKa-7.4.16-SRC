package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f44028a;

    private x(u uVar) {
        this.f44028a = uVar;
    }

    public static Runnable a(u uVar) {
        return new x(uVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44028a.b();
    }
}
